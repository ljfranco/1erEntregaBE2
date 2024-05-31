package com.elaparato.elaparato_users_admin.repository;

import com.elaparato.elaparato_users_admin.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    List<User> findByUserName(String userName);
    Optional<User> findById(String id);
    User deleteUserById(String id);
}
