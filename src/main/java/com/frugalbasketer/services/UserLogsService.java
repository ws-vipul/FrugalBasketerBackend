package com.frugalbasketer.services;

import com.frugalbasketer.entities.SellersLogsEntity;
import com.frugalbasketer.entities.UserLogsEntity;

import java.util.List;

public interface UserLogsService {

    UserLogsEntity saveUserLog(final UserLogsEntity userLogsEntity);

    List<UserLogsEntity> getUserLogsByUserId(final int userId);
}
