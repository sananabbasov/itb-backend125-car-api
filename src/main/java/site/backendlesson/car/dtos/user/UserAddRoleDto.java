package site.backendlesson.car.dtos.user;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddRoleDto {
    private String email;
    private Long roleId;
}
