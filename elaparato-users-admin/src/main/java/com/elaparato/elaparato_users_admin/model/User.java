package com.elaparato.elaparato_users_admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
}
