package com.practicacrud.demo.infraestructure.configuration;

import com.practicacrud.demo.domain.api.IUserServicePort;
import com.practicacrud.demo.domain.spi.IUserPersistencePort;
import com.practicacrud.demo.domain.usecase.UserUseCase;
import com.practicacrud.demo.infraestructure.output.jpa.adapter.UserJpaAdapter;
import com.practicacrud.demo.infraestructure.output.jpa.mapper.IUserEntityMapper;
import com.practicacrud.demo.infraestructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }


    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }

}
