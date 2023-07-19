package com.example.first.myFirstRESTApi.repository;

import com.example.first.myFirstRESTApi.entity.AdminsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<AdminsEntity ,Long> {
}
