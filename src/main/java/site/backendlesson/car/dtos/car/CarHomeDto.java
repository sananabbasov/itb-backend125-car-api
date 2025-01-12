package site.backendlesson.car.dtos.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.backendlesson.car.dtos.brand.BrandDto;
import site.backendlesson.car.dtos.photo.PhotoDto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarHomeDto {
    private Long id;
    private BrandDto brand;
    private String description;
    private String photo;
}
