package com.example.backaplication.services;

import com.example.backaplication.helper.ApiMessage;
import com.example.backaplication.models.Course;
import com.example.backaplication.repository.ICourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    ICourse repository;

    // Método para guardar
    public Course saveCourse(Course courseData) throws Exception {
        try {
            return this.repository.save(courseData);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar todos
    public List<Course> courseList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    // Método para buscar uno por ID
    public Course searchCourseById(Integer id) throws Exception {
        try {
            Optional<Course> courseSearch = this.repository.findById(id);
            if (courseSearch.isPresent()) {
                return courseSearch.get();
            } else {
                throw new Exception(ApiMessage.ERROR_CURSO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para modificar
    public Course updateCourse(Integer id, Course newDataCourse) throws Exception {
        try {
            Optional<Course> courseForChange = this.repository.findById(id);
            if (courseForChange.isPresent()) {

                courseForChange.get().setCourseName(newDataCourse.getCourseName());

                // Guardo las modificaciones en BD
                return this.repository.save(courseForChange.get());
            } else {
                throw new Exception(ApiMessage.ERROR_CURSO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Método para eliminar
    public boolean deleteCourse(Integer id) throws Exception {
        try {
            Optional<Course> courseSearch = this.repository.findById(id);
            if (courseSearch.isPresent()) {
                // Lo elimino
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(ApiMessage.ERROR_CURSO_NO_ENCONTRADO.getMensaje());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
