package com.elaparato.elaparato_users_admin.service;

import com.elaparato.elaparato_users_admin.model.User;
import com.elaparato.elaparato_users_admin.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
    public List<User> findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

}
