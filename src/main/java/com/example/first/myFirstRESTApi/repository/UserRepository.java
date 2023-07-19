package com.example.first.myFirstRESTApi.repository;

import com.example.first.myFirstRESTApi.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity,String> {

}
