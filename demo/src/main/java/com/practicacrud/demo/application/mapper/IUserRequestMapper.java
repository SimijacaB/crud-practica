package com.practicacrud.demo.application.mapper;


import com.practicacrud.demo.application.dtos.UserRequestDto;
import com.practicacrud.demo.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface IUserRequestMapper {

    //IUserRequestMapper INSTANCE =  Mappers.getMapper(IUserRequestMapper.class);

    User toUser(UserRequestDto userRequestDto);

    List<User> toUserList(List<UserRequestDto> userRequestDtoList);

}
