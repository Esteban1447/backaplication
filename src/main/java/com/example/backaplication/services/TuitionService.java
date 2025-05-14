package com.example.backaplication.services;

import com.example.backaplication.helper.ApiMessage;
import com.example.backaplication.models.Tuition;
import com.example.backaplication.repository.ITuition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TuitionService {
    @Autowired
    ITuition repository;

    // Método para guardar
    public Tuition saveTuition(Tuition tuitionData) throws Exception {
        try {
            return this.repository.save(tuitionData);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar todos
    public List<Tuition> tuitionList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar uno por ID
    public Tuition searchTuitionById(Integer id) throws Exception {
        try {
            Optional<Tuition> tuitionSearch = this.repository.findById(id);
            if (tuitionSearch.isPresent()) {
                return tuitionSearch.get();
            } else {
                throw new Exception(ApiMessage.ERROR_TUITION_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para modificar
    public Tuition updateTuition(Integer id, Tuition newDataTuition) throws Exception {
        try {
            Optional<Tuition> tuitionForChange = this.repository.findById(id);
            if (tuitionForChange.isPresent()) {

                tuitionForChange.get().setTuitionDate(newDataTuition.getTuitionDate());

                // Guardo las modificaciones en BD
                return this.repository.save(tuitionForChange.get());
            } else {
                throw new Exception(ApiMessage.ERROR_TUITION_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para eliminar
    public boolean deleteTuition(Integer id) throws Exception {
        try {
            Optional<Tuition> tuitionSearch = this.repository.findById(id);
            if (tuitionSearch.isPresent()) {
                // La elimino
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(ApiMessage.ERROR_TUITION_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
