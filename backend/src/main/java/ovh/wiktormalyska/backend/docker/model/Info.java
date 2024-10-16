package ovh.wiktormalyska.backend.docker.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    int Containers;
    int ContainersRunning;
    int ContainersPaused;
    int ContainersStopped;
    int Images;
}

