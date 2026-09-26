package ru.mfa.rbpo2026.entity;

import lombok.Data;

@Data
public class Student {

    /**
     * GET - чтение
     * POST - сохранение / выполнение действий
     * PUT - обновить целиком
     * PATCH - обновить частично
     * DELETE - удалить
     * HEAD
     * OPTIONS
     */
    private String name;
    private String email;
    private Group group;
    private Course additionalCourse;

}
