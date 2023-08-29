package az.ingress.msuser.service;

import az.ingress.msuser.client.OrderClient;
import az.ingress.msuser.dao.entity.UserEntity;
import az.ingress.msuser.dao.respository.UserRepository;
import az.ingress.msuser.dto.request.SaveUserRequest;
import az.ingress.msuser.dto.response.UserResponse;
import az.ingress.msuser.enums.Status;
import az.ingress.msuser.exception.NotFoundException;
import az.ingress.msuser.mapper.UserMapper;
import az.ingress.msuser.model.request.SaveOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final OrderClient orderClient;

    public UserResponse getUserById(Long id) {
        var user = fetchUserIfExist(id);
        return UserMapper.buildToResponse(user);
    }

    public UserResponse findUserByUsername(String username) {
        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        return UserMapper.buildToResponse(user);
    }

    public void saveUser(SaveUserRequest request) {
        UserEntity user = UserMapper.buildToEntity(request);
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);
    }

    public void createOrder(SaveOrderRequest request){
        orderClient.saveOrder(request);
    }

    public UserEntity fetchUserIfExist(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("USE_NOT_FOUND"));
    }
}
