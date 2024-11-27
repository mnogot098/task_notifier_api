package com.notifier.app.mappers;

import com.notifier.app.dtos.SignUpDto;
import com.notifier.app.dtos.UserDto;
import com.notifier.app.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(source = "phone_number", target = "phone_number") // Correct custom mapping for phone_Number
    User signUpToUser(SignUpDto signUpDto);
}