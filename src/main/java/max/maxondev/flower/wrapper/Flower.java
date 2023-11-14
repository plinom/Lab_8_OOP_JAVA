package max.maxondev.flower.wrapper;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter @Entity @Table
public class Flower {
    @Id
    @SequenceGenerator(
            name = "flower_sequence",
            sequenceName = "flower_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "flower_sequence"
    )
    private Long id;
    private String name;
    private double sepalLength;
    private double price;
    public Flower() {}
    public Flower(Long id,
                  String name,
                  double sepalLength,
                  double price) {
        this.id = id;
        this.name = name;
        this.sepalLength = sepalLength;
        this.price = price;
    }
    public Flower(String name,
                  double sepalLength,
                  double price) {
        this.name = name;
        this.sepalLength = sepalLength;
        this.price = price;
    }
}
