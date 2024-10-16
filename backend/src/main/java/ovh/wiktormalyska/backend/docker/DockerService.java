package ovh.wiktormalyska.backend.docker;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ovh.wiktormalyska.backend.docker.model.Info;

@Service
public class DockerService {
    @Autowired
    private Gson gson;

    static String dockerHost = "localhost:2375";
    private final WebClient webClient;
    public DockerService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://" + dockerHost).build();
        this.gson = new Gson();
    }

    public Info info() {
        String response = this.webClient.get()
                .uri("/info")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return gson.fromJson(response, Info.class);
    }
}
