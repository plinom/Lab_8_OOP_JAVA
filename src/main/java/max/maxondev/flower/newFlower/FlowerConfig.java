package max.maxondev.flower.newFlower;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Configurable
public class FlowerConfig {
    @Bean
    CommandLineRunner commandLineRunner(FlowerRepository repository) {
        return args -> {
            Flower flower1 = new Flower("Flower1", 12.5d, 21.3d);
            Flower flower2 = new Flower("Flower2", 12.5d, 21.3d);
            Flower flower3 = new Flower("Flower3", 12.5d, 21.3d);
            repository.saveAll(List.of(flower1, flower2, flower3));
        };
    }
}
