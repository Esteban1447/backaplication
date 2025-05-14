package com.example.backaplication.services;

import com.example.backaplication.helper.ApiMessage;
import com.example.backaplication.models.Student;
import com.example.backaplication.repository.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudent repository;

    // Método para guardar
    public Student saveStudent(Student studentData) throws Exception {
        try {
            return this.repository.save(studentData);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar todos
    public List<Student> studentList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar uno por ID
    public Student searchStudentById(Integer id) throws Exception {
        try {
            Optional<Student> studentSearch = this.repository.findById(id);
            if (studentSearch.isPresent()) {
                return studentSearch.get();
            } else {
                throw new Exception(ApiMessage.ERROR_ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para modificar
    public Student updateStudent(Integer id, Student newDataStudent) throws Exception {
        try {
            Optional<Student> studentForChange = this.repository.findById(id);
            if (studentForChange.isPresent()) {

                studentForChange.get().setAddress(newDataStudent.getAddress());


                // Guardo las modificaciones en BD
                return this.repository.save(studentForChange.get());
            } else {
                throw new Exception(ApiMessage.ERROR_ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para eliminar
    public boolean deleteStudent(Integer id) throws Exception {
        try {
            Optional<Student> studentSearch = this.repository.findById(id);
            if (studentSearch.isPresent()) {
                // Lo elimino
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(ApiMessage.ERROR_ESTUDIANTE_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
