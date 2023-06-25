package com.nbu.MedRecord.services;

import com.nbu.MedRecord.Models.entity.User;

public interface UserService {

    boolean registerUser(String email, String password);

    User login(String email, String password);
}

