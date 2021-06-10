package ru.skblab.broker.dto.mappers;

import org.mapstruct.Mapper;
import ru.skblab.broker.db.models.User;
import ru.skblab.broker.dto.UserRequestDto;
import ru.skblab.broker.dto.UserToBroker;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDtoRequestToEntity(UserRequestDto userRequestDto);

    UserToBroker userEntityToMessageBroker(User entity);
}
