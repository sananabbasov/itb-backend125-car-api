package site.backendlesson.car.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.backendlesson.car.dtos.user.UserAddRoleDto;
import site.backendlesson.car.payloads.ApiResponse;
import site.backendlesson.car.services.UserService;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/role")
    public ResponseEntity<ApiResponse> create(@RequestBody UserAddRoleDto userAddRoleDto){
        ApiResponse response = userService.addRoleToUser(userAddRoleDto);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

}
