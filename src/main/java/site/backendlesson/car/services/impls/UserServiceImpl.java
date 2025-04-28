package site.backendlesson.car.services.impls;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import site.backendlesson.car.dtos.auth.RegisterDto;
import site.backendlesson.car.dtos.user.UserAddRoleDto;
import site.backendlesson.car.models.Role;
import site.backendlesson.car.models.User;
import site.backendlesson.car.payloads.ApiResponse;
import site.backendlesson.car.repositories.UserRepository;
import site.backendlesson.car.services.RoleService;
import site.backendlesson.car.services.UserService;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Override
    public ApiResponse register(RegisterDto registerDto) {
        try {
            User findUser = userRepository.findByEmail(registerDto.getEmail());
            if (findUser != null){
                return new ApiResponse("User already exist",false, HttpStatus.CONFLICT);
            }

            User user = new User();
            String password = passwordEncoder.encode(registerDto.getPassword());
            user.setEmail(registerDto.getEmail());
            user.setFirstName(registerDto.getFirstName());
            user.setLastName(registerDto.getLastName());
            user.setPassword(password);
            userRepository.save(user);
            return new ApiResponse("User registered successfully",true,HttpStatus.CREATED);
        }catch (Exception e){
            return  new ApiResponse(e.getMessage(), false,HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public User findUserByName(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public ApiResponse addRoleToUser(UserAddRoleDto userAddRoleDto) {

        Role findRole = roleService.findRole(userAddRoleDto.getRoleId());
        User findUser = userRepository.findByEmail(userAddRoleDto.getEmail());
        Set<Role> roles = findUser.getRoles();
        roles.add(findRole);
        findUser.setRoles(roles);
        userRepository.save(findUser);
        return new ApiResponse("Role add successfully", false, HttpStatus.CREATED);
    }
}
