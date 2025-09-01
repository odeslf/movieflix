package com.musicflux.movieflix.mapper;

import com.musicflux.movieflix.controller.request.UserRequest;
import com.musicflux.movieflix.controller.response.UserResponse;
import com.musicflux.movieflix.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request) {
        return User
                .builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
