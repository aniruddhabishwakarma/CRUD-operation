package com.example.first.myFirstRESTApi.service;

import com.example.first.myFirstRESTApi.entity.AdminsEntity;
import com.example.first.myFirstRESTApi.model.AdminRequest;
import com.example.first.myFirstRESTApi.model.AdminResponse;
import com.example.first.myFirstRESTApi.model.VotersResponse;
import com.example.first.myFirstRESTApi.repository.AdminsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminServiceImplementation implements AdminService{
    @Autowired
    AdminsRepository adminsRepository;

    @Override
    public String registerAdmin(String path,MultipartFile file, AdminRequest adminRequest) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = path + File.separator+fileName;

        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        Files.copy(file.getInputStream(), Paths.get(filePath));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode(adminRequest.getPassword());

        AdminsEntity adminsEntity = AdminsEntity.builder()
                .fullName(adminRequest.getFullName())
                .username(adminRequest.getUserName())
                .contactNo(adminRequest.getContactNo())
                .eMail(adminRequest.geteMail())
                .password(result)
                .image(fileName).build();
        adminsRepository.save(adminsEntity);

        return "Admin is registered successfully";
    }

    @Override
    public List<AdminResponse> getAdmin() throws IOException {

        String filePath = "C:\\Users\\user\\Desktop\\springboot\\myFirstRESTApi\\{project.admin}\\";
        List<AdminsEntity> adminsEntityList = adminsRepository.findAll();
        List<AdminResponse> adminResponses = adminsEntityList.stream()
                .map(adminsEntity -> {
                    AdminResponse response = new AdminResponse();
                    BeanUtils.copyProperties(adminsEntity,response);
                    return  response;
                }).collect(Collectors.toList());

        return null;
    }
}
