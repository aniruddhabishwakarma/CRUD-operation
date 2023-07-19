package com.example.first.myFirstRESTApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VotersResponse {

    private String firstName;
    private String lastName;
    private String contact;
    private String userName;
    private String email;
    private String password;
    private String address;
}
