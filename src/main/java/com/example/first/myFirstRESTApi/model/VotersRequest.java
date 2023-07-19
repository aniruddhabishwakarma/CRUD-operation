package com.example.first.myFirstRESTApi.model;

import org.springframework.http.ResponseEntity;

public class VotersRequest {

    private Long id;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String firstName;
    private String lastName;
    private String contact;
    private String userName;
    private String email;
    private String password;
    private String address;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
