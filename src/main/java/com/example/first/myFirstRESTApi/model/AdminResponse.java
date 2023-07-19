package com.example.first.myFirstRESTApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {
    private String message;
    private String fullName;

    public AdminResponse(String message) {
        this.message = message;
    }

    private String username;
    private String contactNo;
    private String eMail;
    private String password;
}
