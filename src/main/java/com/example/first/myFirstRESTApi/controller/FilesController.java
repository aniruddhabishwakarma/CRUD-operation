package com.example.first.myFirstRESTApi.controller;


import com.example.first.myFirstRESTApi.model.FileResponse;
import com.example.first.myFirstRESTApi.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@RestController
@RequestMapping("/files")
public class FilesController {
    @Value("{project.image}")
    private String path;
    FileService fileService;

    @Autowired
    public FilesController(FileService fileService){
    this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> uploadImage(@RequestParam("file") MultipartFile file)  {
        String fileName = null;
        try {
            fileName = this.fileService.uploadFile(path,file);
        }
        catch (IOException e) {
            return new ResponseEntity<>(new FileResponse(null,"Image cannot be blank"),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new FileResponse(fileName,"Image is successfully updated"),HttpStatus.OK);

    }

}
