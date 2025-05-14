package com.example.backaplication.services;

import com.example.backaplication.helper.ApiMessage;
import com.example.backaplication.models.Attendance;
import com.example.backaplication.repository.IAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    @Autowired
    IAttendance repository;

    // Método para guardar
    public Attendance saveAttendance(Attendance attendanceData) throws Exception {
        try {
            return this.repository.save(attendanceData);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar todos
    public List<Attendance> attendanceList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar uno por ID
    public Attendance searchAttendanceById(Integer id) throws Exception {
        try {
            Optional<Attendance> attendanceSearch = this.repository.findById(id);
            if (attendanceSearch.isPresent()) {
                return attendanceSearch.get();
            } else {
                throw new Exception(ApiMessage.ERROR_ASISTENCIA_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para modificar
    public Attendance updateAttendance(Integer id, Attendance newDataAttendance) throws Exception {
        try {
            Optional<Attendance> attendanceForChange = this.repository.findById(id);
            if (attendanceForChange.isPresent()) {
                // Modifico esa asistencia
                attendanceForChange.get().setStudent(newDataAttendance.getStudent());
                // Guardo las modificaciones en BD
                return this.repository.save(attendanceForChange.get());
            } else {
                throw new Exception(ApiMessage.ERROR_ASISTENCIA_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para eliminar
    public boolean deleteAttendance(Integer id) throws Exception {
        try {
            Optional<Attendance> attendanceSearch = this.repository.findById(id);
            if (attendanceSearch.isPresent()) {
                // La elimino
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(ApiMessage.ERROR_ASISTENCIA_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
