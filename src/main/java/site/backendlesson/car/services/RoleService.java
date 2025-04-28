package site.backendlesson.car.services;

import site.backendlesson.car.dtos.role.RoleCreateDto;
import site.backendlesson.car.dtos.role.RoleDto;
import site.backendlesson.car.models.Role;
import site.backendlesson.car.payloads.ApiPayload;
import site.backendlesson.car.payloads.ApiResponse;

import java.util.List;

public interface RoleService {
    ApiResponse createRole(RoleCreateDto roleCreateDto);
    ApiPayload<List<RoleDto>> getAllRoles();
    Role findRole(Long roleId);
}
