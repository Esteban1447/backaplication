package com.example.backaplication.services;

import com.example.backaplication.helper.ApiMessage;
import com.example.backaplication.models.Teacher;
import com.example.backaplication.repository.ITeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    ITeacher repository;

    //Metodo para guardar
    public Teacher saveTeacher(Teacher teacherData)throws Exception{
        try{
            return this.repository.save(teacherData);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //metodo para buscarTodos
    public List<Teacher> getAllTeachers()throws Exception{
        try{
            return this.repository.findAll();

        }catch (Exception error){
            throw new Exception();
        }
    }

    //metodo para buscarUnoPorId
    public Teacher searchTeacherById(Integer id)throws Exception{
        try{
            Optional<Teacher> teacherSearch =this.repository.findById(id);
            if(teacherSearch.isPresent()){
                return teacherSearch.get();
            }else{
                throw new Exception(ApiMessage.ERROR_DOCENTE_NO_ENCONTRADO.getMensaje());
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //metodo para modificar
    public Teacher updateTeacher(Integer id, Teacher newDataTeacher)throws Exception{
        try{
            Optional<Teacher>teacherForChange=this.repository.findById(id);
            if(teacherForChange.isPresent()){
                //Modifico ese docente
                teacherForChange.get().setSpecialty(newDataTeacher.getSpecialty());

                //guardo las modificaciones en BD
                return this.repository.save(teacherForChange.get());
            }else{
                throw new Exception(ApiMessage.ERROR_DOCENTE_NO_ENCONTRADO.getMensaje());
            }

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //metodo para eliminar
    public boolean deleteTeacher(Integer id)throws Exception{
        try{
            Optional<Teacher>teacherSearch=this.repository.findById(id);
            if(teacherSearch.isPresent()){
                //Lo elimino
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
