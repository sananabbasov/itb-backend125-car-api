package site.backendlesson.car.dtos.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelCreateDto {
    private String name;
    private Long brandId;
}

