package com.example.first.myFirstRESTApi.repository;

import com.example.first.myFirstRESTApi.entity.VotersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotersRepository extends JpaRepository<VotersEntity,Long> {

}
