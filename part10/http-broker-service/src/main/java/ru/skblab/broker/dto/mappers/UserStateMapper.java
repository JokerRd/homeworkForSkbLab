package ru.skblab.broker.dto.mappers;

import org.mapstruct.Mapper;
import ru.skblab.broker.db.models.UserState;
import ru.skblab.broker.dto.UserStateFromBroker;
import ru.skblab.broker.dto.UserStateResponseDto;

@Mapper(componentModel = "spring")
public interface UserStateMapper {

    UserState UserStateFromBrokerToEntity(UserStateFromBroker userStateFromBroker);

    UserStateResponseDto UserStateEntityToResponseDto(UserState userState);
}
