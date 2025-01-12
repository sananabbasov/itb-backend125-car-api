package site.backendlesson.car.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Brand brand;

    private Double price;
    private Double discount;

    @Column(length = 10000)
    private String description;

    @OneToMany(mappedBy = "car")
    private List<Photo> photos;

}
