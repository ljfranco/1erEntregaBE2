package com.elaparato.elaparato_users_admin.controller;

import com.elaparato.elaparato_users_admin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.elaparato.elaparato_users_admin.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class UserController {
    @Autowired
    private UserService service;


    @GetMapping("/getall")
    @PreAuthorize("hasRole('ROLE_Administrador')")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/username/{userName}")
    public ResponseEntity<List<User>> findByUserName(@PathVariable String userName) {
        return ResponseEntity.ok(service.findByUserName(userName));
    }

}
