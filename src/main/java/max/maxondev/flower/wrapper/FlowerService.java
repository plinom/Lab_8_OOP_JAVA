package max.maxondev.flower.wrapper;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FlowerService {
    private final FlowerRepository flowerRepository;
    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }
    public List<Flower> getFlowers() {
        return flowerRepository.findAll();
    }
    public void addNewFlower(Flower flower) {
        Optional<Flower> flowerOptional = flowerRepository.findFlowerByName(flower.getName());
        if(flowerOptional.isPresent()) {
            throw new IllegalStateException("this flower is taken");
        }
        flowerRepository.save(flower);
    }
    public void deleteFlower(Long flowerId) {
        boolean exists = flowerRepository.existsById(flowerId);
        if(!exists) {
            throw new IllegalStateException("flower with name" + flowerId + "not found");
        }
        flowerRepository.deleteById(flowerId);
    }
    @Transactional
    public void updateFlower(Long flowerId, String name, Double sepalLength, Double price) {
        Flower flower = flowerRepository.findById(flowerId).orElseThrow(() -> new IllegalStateException("does not exists"));
        if(name != null && !name.isEmpty() && !Objects.equals(flower.getName(), name)) { flower.setName(name); }
        if(sepalLength > 0 && !Objects.equals(flower.getSepalLength(), sepalLength)) { flower.setSepalLength(sepalLength); }
        if(price > 0 && !Objects.equals(flower.getPrice(), price)) { flower.setPrice(price); }
    }
}
