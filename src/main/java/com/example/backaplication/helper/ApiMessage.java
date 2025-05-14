package com.example.backaplication.helper;

public enum ApiMessage {
    ERROR_DOCENTE_NO_ENCONTRADO("El docente que buscas no está en la base de datos"),
    ERROR_ASISTENCIA_NO_ENCONTRADO("La asistencia que buscas no está en la base de datos"),
    ERROR_CURSO_NO_ENCONTRADO("El curso que buscas no está en la base de datos"),
    ERROR_CALIFICACION_NO_ENCONTRADO("La calificación que buscas no está en la base de datos"),
    ERROR_ESTUDIANTE_NO_ENCONTRADO("El estudiante que buscas no está en la base de datos"),
    ERROR_SUBJECT_NO_ENCONTRADO("La materia que buscas no está en la base de datos"),
    ERROR_TUITION_NO_ENCONTRADO("La matrícula que buscas no está en la base de datos");

    private final String mensaje;

    ApiMessage(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
