package com.example.first.myFirstRESTApi.service;

import com.example.first.myFirstRESTApi.entity.FilesEntity;
import com.example.first.myFirstRESTApi.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImplementation implements FileService{

    @Autowired
    FilesRepository filesRepository;
    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {
        
        String name = file.getOriginalFilename();
        String filePath = path + File.separator+name ;
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        Files.copy(file.getInputStream(), Paths.get(filePath));

        FilesEntity fileEntity = FilesEntity.builder()
                .fileName(name).build();
        System.out.println(fileEntity);
        filesRepository.save(fileEntity);

        return name;
    }
}
