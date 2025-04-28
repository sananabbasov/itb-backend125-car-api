package site.backendlesson.car.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import site.backendlesson.car.dtos.role.RoleCreateDto;
import site.backendlesson.car.dtos.role.RoleDto;
import site.backendlesson.car.payloads.ApiPayload;
import site.backendlesson.car.payloads.ApiResponse;
import site.backendlesson.car.services.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;



    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody RoleCreateDto roleCreateDto){
        ApiResponse response = roleService.createRole(roleCreateDto);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/getall")
    public ResponseEntity<ApiPayload<List<RoleDto>>> getAll(){
        ApiPayload<List<RoleDto>> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, roles.getHttpStatus());
    }


}
