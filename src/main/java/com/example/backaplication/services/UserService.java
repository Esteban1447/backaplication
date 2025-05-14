package com.example.backaplication.services;

import com.example.backaplication.helper.ApiMessage;
import com.example.backaplication.models.User;
import com.example.backaplication.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUser repository;

    public User saveUser(User userData)throws Exception{
        try{
            return this.repository.save(userData);
        }catch (Exception error){
            throw new Exception();
        }
    }

    public List<User> userList()throws Exception{
        try{
            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }

    public User searchUserById(Integer id)throws Exception{
        try{
            Optional<User> userSearch=this.repository.findById(id);
            if(userSearch.isPresent()){
                return userSearch.get();
            }else{
                throw new Exception(ApiMessage.ERROR_DOCENTE_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public User updateUser(Integer id, User newDataUser)throws Exception{
        try{
            Optional<User>userForChange=this.repository.findById(id);
            if(userForChange.isPresent()){
                userForChange.get().setName(newDataUser.getName());

                return this.repository.save(userForChange.get());
            }else{
                throw new Exception(ApiMessage.ERROR_DOCENTE_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteUser(Integer id)throws Exception{
        try{
            Optional<User>userSearch=this.repository.findById(id);
            if(userSearch.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception(ApiMessage.ERROR_DOCENTE_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }




}
