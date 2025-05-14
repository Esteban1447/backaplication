package com.example.backaplication.services;

import com.example.backaplication.helper.ApiMessage;
import com.example.backaplication.models.Subject;
import com.example.backaplication.repository.ISubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    ISubject repository;

    // Método para guardar
    public Subject saveSubject(Subject subjectData) throws Exception {
        try {
            return this.repository.save(subjectData);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar todos
    public List<Subject> subjectList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar uno por ID
    public Subject searchSubjectById(Integer id) throws Exception {
        try {
            Optional<Subject> subjectSearch = this.repository.findById(id);
            if (subjectSearch.isPresent()) {
                return subjectSearch.get();
            } else {
                throw new Exception(ApiMessage.ERROR_SUBJECT_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para modificar
    public Subject updateSubject(Integer id, Subject newDataSubject) throws Exception {
        try {
            Optional<Subject> subjectForChange = this.repository.findById(id);
            if (subjectForChange.isPresent()) {


                subjectForChange.get().setSubjectName(newDataSubject.getSubjectName());

                return this.repository.save(subjectForChange.get());
            } else {
                throw new Exception(ApiMessage.ERROR_SUBJECT_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para eliminar
    public boolean deleteSubject(Integer id) throws Exception {
        try {
            Optional<Subject> subjectSearch = this.repository.findById(id);
            if (subjectSearch.isPresent()) {
                // Lo elimino
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(ApiMessage.ERROR_SUBJECT_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}