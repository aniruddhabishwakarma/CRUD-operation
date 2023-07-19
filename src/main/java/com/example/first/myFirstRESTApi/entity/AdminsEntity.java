package com.example.first.myFirstRESTApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="admins_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="user_name")
    private String username;

    @Column(name="contact")
    private String contactNo;

    @Column(name="email")
    private String eMail;

    @Column(name="password")
    private String password;

    @Column(name="image")
    private String image;

}
