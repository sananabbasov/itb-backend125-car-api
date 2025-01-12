package site.backendlesson.car.dtos.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandGetUpdateDto {
    private Long id;
    private String name;
}
