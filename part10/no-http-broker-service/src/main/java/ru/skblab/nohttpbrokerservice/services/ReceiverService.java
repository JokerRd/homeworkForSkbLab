package ru.skblab.nohttpbrokerservice.services;


import ru.skblab.nohttpbrokerservice.models.UserInfoShort;
import ru.skblab.nohttpbrokerservice.models.UserState;

public interface ReceiverService {

    UserState listen(UserInfoShort userInfoShort);
}
