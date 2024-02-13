package com.practicacrud.demo.application.mapper;

import com.practicacrud.demo.application.dtos.UserRequestDto;
import com.practicacrud.demo.application.dtos.UserResponseDto;
import com.practicacrud.demo.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

    @Mapper(componentModel = "spring",
            unmappedSourcePolicy = ReportingPolicy.IGNORE,
            unmappedTargetPolicy = ReportingPolicy.IGNORE)
    public interface IUserResponseMapper {

        //IUserRequestMapper INSTANCE =  Mappers.getMapper(IUserResponseMapper.class);

        UserResponseDto toUserResponse(User user);

        List<UserResponseDto> toUserResponseList(List<User> user);

    }

