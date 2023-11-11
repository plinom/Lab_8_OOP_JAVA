package max.maxondev.flower;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FlowerConfig {
    @Bean
    CommandLineRunner commandLineRunner(FlowerRepository repository) {
        return args -> {
            Flower flower1 = new Flower(1L, "flower1", 12.5d, 12.3d);
            Flower flower2 = new Flower(2L, "flower2", 12.5d, 12.3d);
            Flower flower3 = new Flower(3L, "flower3", 12.5d, 12.3d);
            repository.saveAll(List.of(flower1, flower2, flower3));
        };
    }
}
