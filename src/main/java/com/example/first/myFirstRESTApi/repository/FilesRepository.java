package com.example.first.myFirstRESTApi.repository;

import com.example.first.myFirstRESTApi.entity.FilesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesRepository extends JpaRepository<FilesEntity,Long> {

}
