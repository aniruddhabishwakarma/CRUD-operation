package com.example.first.myFirstRESTApi.controller;

import com.example.first.myFirstRESTApi.model.AdminRequest;
import com.example.first.myFirstRESTApi.model.AdminResponse;
import com.example.first.myFirstRESTApi.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ObjectMapper mapper;
    @Value("{project.admin}")
    String path = "null";
    @Autowired
    AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminResponse> addAdmin(@RequestParam("file") MultipartFile file,
                                         @RequestParam("adminData") String adminData ) throws IOException {

        AdminRequest adminRequest= mapper.readValue(adminData,AdminRequest.class);
        String message = adminService.registerAdmin(path,file,adminRequest);

        return  new ResponseEntity<>(new AdminResponse("Admin has been registerd succesully"),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<AdminResponse>> getAdmin() throws IOException {
        List<AdminResponse> adminResponse = adminService.getAdmin();

        return new ResponseEntity<>(adminResponse,HttpStatus.OK);
    }


}
