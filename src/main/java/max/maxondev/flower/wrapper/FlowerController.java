package max.maxondev.flower.wrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/flower")
public class FlowerController {
    private final FlowerService flowerService;
    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }
    @GetMapping
    public List<Flower> getFlowers() {
        return flowerService.getFlowers();
    }
    @PostMapping
    public void registerNewFlower(@RequestBody Flower flower) {
        flowerService.addNewFlower(flower);
    }
    @DeleteMapping(path = "{flowerName}")
    public void deleteFlower(@PathVariable("flowerName") Long flowerName) {
        flowerService.deleteFlower(flowerName);
    }
    @PutMapping(path = "{flowerId}")
    public void updateFlower(
            @PathVariable("flowerId") Long flowerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double sepalLength,
            @RequestParam(required = false) Double price
    ) {
        flowerService.updateFlower(flowerId, name, sepalLength, price);
    }
}
