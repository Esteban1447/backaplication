package com.example.backaplication.services;

import com.example.backaplication.helper.ApiMessage;
import com.example.backaplication.models.Grade;
import com.example.backaplication.repository.IGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {
    @Autowired
    IGrade repository;

    // Método para guardar
    public Grade saveGrade(Grade gradeData) throws Exception {
        try {
            return this.repository.save(gradeData);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar todos
    public List<Grade> gradeList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar uno por ID
    public Grade searchGradeById(Integer id) throws Exception {
        try {
            Optional<Grade> gradeSearch = this.repository.findById(id);
            if (gradeSearch.isPresent()) {
                return gradeSearch.get();
            } else {
                throw new Exception(ApiMessage.ERROR_CALIFICACION_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para modificar
    public Grade updateGrade(Integer id, Grade newDataGrade) throws Exception {
        try {
            Optional<Grade> gradeForChange = this.repository.findById(id);
            if (gradeForChange.isPresent()) {

                gradeForChange.get().setGrade(newDataGrade.getGrade());


                // Guardo las modificaciones en BD
                return this.repository.save(gradeForChange.get());
            } else {
                throw new Exception(ApiMessage.ERROR_CALIFICACION_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para eliminar
    public boolean deleteGrade(Integer id) throws Exception {
        try {
            Optional<Grade> gradeSearch = this.repository.findById(id);
            if (gradeSearch.isPresent()) {
                // La elimino
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(ApiMessage.ERROR_CALIFICACION_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
