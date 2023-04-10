package com.inaal.rumahkost_api.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class UserDTO {
    @NotBlank(message = "{invalid.name}")
    private String name;
    @Email(message = "{invalid.email}")
    private String email;
    @NotBlank(message = "{invalid.phone}")
    @Pattern(regexp="(^$|[0-9]{10})", message = "{invalid.format.phone}")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
