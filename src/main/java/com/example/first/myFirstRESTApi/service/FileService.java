package com.example.first.myFirstRESTApi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileService {

    String uploadFile(String path, MultipartFile file) throws IOException;
}
