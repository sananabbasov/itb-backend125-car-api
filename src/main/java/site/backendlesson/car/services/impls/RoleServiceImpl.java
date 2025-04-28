package site.backendlesson.car.services.impls;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import site.backendlesson.car.dtos.role.RoleCreateDto;
import site.backendlesson.car.dtos.role.RoleDto;
import site.backendlesson.car.exceptions.ResourceNotFoundException;
import site.backendlesson.car.models.Role;
import site.backendlesson.car.payloads.ApiPayload;
import site.backendlesson.car.payloads.ApiResponse;
import site.backendlesson.car.repositories.RoleRepository;
import site.backendlesson.car.services.RoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponse createRole(RoleCreateDto roleCreateDto) {
        try {
            Role findRole = roleRepository.findByName(roleCreateDto.getName().toUpperCase());
            if (findRole != null){
                return new ApiResponse("Rele already exist.", false, HttpStatus.CONFLICT);
            }
            Role role = new Role();
            role.setName(roleCreateDto.getName().toUpperCase());
            roleRepository.save(role);
            return new ApiResponse("Role is created successfully", true, HttpStatus.CREATED);
        }catch (Exception e){
            return new ApiResponse(e.getMessage(), false, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ApiPayload<List<RoleDto>> getAllRoles() {
        try {
            List<Role> findRoles = roleRepository.findAll();
            List<RoleDto> roles = findRoles.stream().map(role -> modelMapper.map(role, RoleDto.class)).collect(Collectors.toList());
            ApiPayload<List<RoleDto>> response = new ApiPayload<>();
            response.setData(roles);
            response.setHttpStatus(HttpStatus.OK);
            response.setSuccess(true);
            return response;
        }catch (Exception error){
            return new ApiPayload<>(false, new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Role findRole(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role", "id", roleId));
    }
}
