package com.nbu.MedRecord.services;

import com.nbu.MedRecord.Models.entity.User;

public interface UserService {

    boolean registerUser(String username, String password);

    User login(String username, String password);

    User getCurrentUser();

}

