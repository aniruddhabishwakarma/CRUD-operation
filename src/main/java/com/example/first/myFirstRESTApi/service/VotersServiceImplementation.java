package com.example.first.myFirstRESTApi.service;

import com.example.first.myFirstRESTApi.entity.VotersEntity;
import com.example.first.myFirstRESTApi.exception.VotersServiceCustomException;
import com.example.first.myFirstRESTApi.model.VotersRequest;
import com.example.first.myFirstRESTApi.model.VotersResponse;
import com.example.first.myFirstRESTApi.repository.VotersRepository;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@Log4j2
@Builder
public class VotersServiceImplementation implements VotersService{

    @Autowired
    private VotersRepository votersRepository;
    @Override
    public long save(VotersRequest votersRequest) {
        log.info("Adding Voters");
        if(votersRequest.getFirstName().isBlank() || votersRequest.getLastName().isBlank() || votersRequest.getUserName().isBlank() || votersRequest.getContact().isBlank() || votersRequest.getEmail().isBlank() || votersRequest.getPassword().isBlank()|| votersRequest.getAddress().isBlank()){
            throw (new VotersServiceCustomException("Every field should be provided","Cannot be blank"));
        }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
            String result = encoder.encode(votersRequest.getPassword());

        VotersEntity votersEntity = VotersEntity.builder()
                .firstName(votersRequest.getFirstName())
                .lastName(votersRequest.getLastName())
                .contact(votersRequest.getContact())
                .userName(votersRequest.getUserName())
                .email(votersRequest.getPassword())
                .hashedPassword(result)
                .address(votersRequest.getAddress())
                .build();
        votersRepository.save(votersEntity);
        log.info("Voter Registered");
        return votersEntity.getId() ;
    }

    @Override
    public List<VotersResponse> getAllVoters() {
        List<VotersEntity> votersEntityList = votersRepository.findAll();
        List<VotersResponse> votersResponses = votersEntityList.stream()
                .map(votersEntity -> {
                    VotersResponse response = new VotersResponse();
                    BeanUtils.copyProperties(votersEntity,response);
                    return  response;
                }).collect(Collectors.toList());
        return votersResponses;
    }

    @Override
    public VotersResponse getVoterById(Long voterId) {
        VotersEntity votersEntity = votersRepository.findById(voterId)
                .orElseThrow(()-> new VotersServiceCustomException("Product with given id not found",HttpStatus.NOT_FOUND.toString()));
        VotersResponse votersResponse = new VotersResponse();
        BeanUtils.copyProperties(votersEntity,votersResponse);
        return votersResponse;
    }

    @Override
    public ResponseEntity<String> deleteVoterById(Long id) {
        votersRepository.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");

    }

    @Override
    public ResponseEntity<String> updateUserById(VotersRequest votersRequest, long id) {
        VotersEntity voters = votersRepository.findById(id).get();
        voters.setFirstName(votersRequest.getFirstName());
        voters.setLastName(votersRequest.getLastName());
        voters.setUserName(votersRequest.getUserName());
        voters.setEmail(votersRequest.getEmail());
        voters.setContact(votersRequest.getContact());
        voters.setAddress(voters.getAddress());
        votersRepository.save(voters);

        return ResponseEntity.ok("User Updated succesfully");

    }
}
