package com.example.first.myFirstRESTApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Files")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="file_name")
    private String fileName;
}
