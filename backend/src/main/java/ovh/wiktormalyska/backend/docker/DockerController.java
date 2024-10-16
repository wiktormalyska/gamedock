package ovh.wiktormalyska.backend.docker;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ovh.wiktormalyska.backend.docker.model.Info;

// TODO: Add info about windows setup, expose docker socket
// TODO: Add info about linux setup, in service there needs to be localhost:2375 enabled

@RestController
@RequestMapping("/docker")
public class DockerController {

    @Autowired
    DockerService dockerService;
    @Autowired
    private Gson gson;

    @GetMapping(value="/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> info() {
        Info response = dockerService.info();
        return ResponseEntity.ok(gson.toJson(response));
    }
}
