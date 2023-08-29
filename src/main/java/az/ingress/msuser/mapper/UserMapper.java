package az.ingress.msuser.mapper;

import az.ingress.msuser.dto.request.SaveUserRequest;
import az.ingress.msuser.model.request.SaveOrderRequest;
import az.ingress.msuser.dao.entity.UserEntity;
import az.ingress.msuser.dto.request.UpdateUserRequest;
import az.ingress.msuser.dto.response.UserResponse;

public class UserMapper {
    public static UserResponse buildToResponse(UserEntity user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .userName(user.getUsername())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .build();
    }

    public static UserEntity buildToEntity(SaveUserRequest request){
        return UserEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .username(request.getUserName())
                .birthDate(request.getBirthDate())
                .build();
    }

    public static void updateToUser(UserEntity user, UpdateUserRequest request){
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setUsername(request.getUserName());
        user.setEmail(request.getEmail());
        user.setBirthDate(request.getBirthDate());
    }

    public static SaveOrderRequest createOrderRequestFromUser(UserEntity user){
        return SaveOrderRequest.builder()
                .userId(user.getId())
                .build();
    }
}
