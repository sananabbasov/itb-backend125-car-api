package site.backendlesson.car.services;

import site.backendlesson.car.dtos.auth.RegisterDto;
import site.backendlesson.car.dtos.user.UserAddRoleDto;
import site.backendlesson.car.models.User;
import site.backendlesson.car.payloads.ApiResponse;

public interface UserService {

    ApiResponse register(RegisterDto registerDto);
    User findUserByName(String email);
    ApiResponse addRoleToUser(UserAddRoleDto userAddRoleDto);
}
