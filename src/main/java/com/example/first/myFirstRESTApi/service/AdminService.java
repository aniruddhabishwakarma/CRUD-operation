package com.example.first.myFirstRESTApi.service;

import com.example.first.myFirstRESTApi.model.AdminRequest;
import com.example.first.myFirstRESTApi.model.AdminResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface AdminService {
    String registerAdmin(String path,MultipartFile file, AdminRequest adminRequest) throws IOException;

    List<AdminResponse> getAdmin() throws IOException;
}
