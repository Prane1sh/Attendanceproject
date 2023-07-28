package com.iamneo.security.dto.request;

import com.iamneo.security.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String mobile;
    private Role role;
	
}
