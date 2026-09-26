package ru.mfa.rbpo2026.entity;

import lombok.Data;

@Data
public class Student {

    /**
     * GET - чтение
     * POST - создание
     * PUT - полное обновление
     * PATCH - частичное обновление
     * DELETE - удаления
     * HEAD
     * OPTIONS
     */

    private String name;
    private String email;
    private Group group;
    private Course additionalCourse;

}
