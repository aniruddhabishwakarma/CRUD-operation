package com.example.first.myFirstRESTApi.service;

import com.example.first.myFirstRESTApi.model.VotersRequest;
import com.example.first.myFirstRESTApi.model.VotersResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface VotersService {
    long save(VotersRequest votersRequest);

    List<VotersResponse> getAllVoters();

    VotersResponse getVoterById(Long voterId);

    ResponseEntity<String> deleteVoterById(Long id);

    ResponseEntity<String> updateUserById(VotersRequest votersRequest,long id);
}
