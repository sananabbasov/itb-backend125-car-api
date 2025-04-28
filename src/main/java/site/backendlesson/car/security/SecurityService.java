package site.backendlesson.car.security;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.backendlesson.car.models.MethodPermission;
import site.backendlesson.car.repositories.MethodPermissionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service("securityService")
@RequiredArgsConstructor
public class SecurityService {

    private final MethodPermissionRepository methodPermissionRepository;

    public String privilege(String methodName){
        MethodPermission methodPermission = methodPermissionRepository.findByName(methodName);
        List<String> roles = methodPermission.getRoles().stream().map(x->x.getName()).collect(Collectors.toList());
        String result = String.join(",",roles);
        return result;
    }

}
