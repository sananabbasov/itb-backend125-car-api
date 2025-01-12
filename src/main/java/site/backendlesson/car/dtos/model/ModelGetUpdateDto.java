package site.backendlesson.car.dtos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.backendlesson.car.dtos.brand.BrandDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelGetUpdateDto {
    private String name;
    private BrandDto brand;
}
