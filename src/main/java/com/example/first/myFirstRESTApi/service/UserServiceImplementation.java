package com.example.first.myFirstRESTApi.service;
import com.example.first.myFirstRESTApi.entity.UsersEntity;
import com.example.first.myFirstRESTApi.model.Users;
import com.example.first.myFirstRESTApi.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Users save(Users user) {
        if(user.getId()==null || user.getId().isEmpty()){
            user.setId(UUID.randomUUID().toString());
        }
        UsersEntity usersEntity = new UsersEntity();

        BeanUtils.copyProperties(user,usersEntity);
        userRepository.save(usersEntity);
        return user;
    }

    @Override
    public List<Users> getAllUsers() {

        List<UsersEntity> usersEntityList = userRepository.findAll();
        List<Users> users= usersEntityList.stream().
                map(userEntity ->{
                    Users user = new Users();
                    BeanUtils.copyProperties(userEntity,user);
                    return user;
                }).collect(Collectors.toList());
        return users;
    }

    @Override
    public Users getUserById(String id) {

        UsersEntity usersEntity = userRepository.findById(id).get();
        Users user = new Users();
        BeanUtils.copyProperties(usersEntity,user);
        return user;
    }

    @Override
    public String deleteUserById(String id) {
        userRepository.deleteById(id);
        return  "Employee deleted with the id:" +id;
    }
}
