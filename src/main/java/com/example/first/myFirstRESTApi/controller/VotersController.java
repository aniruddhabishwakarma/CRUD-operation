package com.example.first.myFirstRESTApi.controller;

import com.example.first.myFirstRESTApi.model.VotersRequest;
import com.example.first.myFirstRESTApi.model.VotersResponse;
import com.example.first.myFirstRESTApi.service.VotersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voters")
public class VotersController {
    @Autowired
    VotersService votersService;

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody VotersRequest votersRequest){
        long voterId = votersService.save(votersRequest);
       return new ResponseEntity<>(voterId, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VotersResponse> getProductById(@PathVariable("id") long voterId){
        VotersResponse votersResponse = votersService.getVoterById(voterId);
        return new ResponseEntity<>(votersResponse,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VotersResponse>> getAllVoters(){
        List<VotersResponse> votersResponse = votersService.getAllVoters();
        return new ResponseEntity<>(votersResponse,HttpStatus.OK) ;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVoterById(@PathVariable long id){

        return votersService.deleteVoterById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id,@RequestBody VotersRequest votersRequest){
        return votersService.updateUserById(votersRequest,id);
    }
}
