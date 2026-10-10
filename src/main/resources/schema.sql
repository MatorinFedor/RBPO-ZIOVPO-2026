CREATE SCHEMA app AUTHORIZATION demo_owner;

CREATE TABLE app.groups
(
    id   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE app.courses
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        VARCHAR(255) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE app.students
(
    id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name                 VARCHAR(255) NOT NULL,
    email                VARCHAR(255) UNIQUE,
    group_id             UUID         NOT NULL REFERENCES app.groups (id),
    additional_course_id UUID REFERENCES app.courses (id)
);

CREATE TABLE app.student_profiles
(
    id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    student_number VARCHAR(255) NOT NULL UNIQUE,
    internal_note  TEXT,
    student_id     UUID         NOT NULL UNIQUE REFERENCES app.students (id) ON DELETE CASCADE
);

CREATE TABLE app.group_courses
(
    group_id  UUID NOT NULL REFERENCES app.groups (id) ON DELETE CASCADE,
    course_id UUID NOT NULL REFERENCES app.courses (id) ON DELETE CASCADE,
    PRIMARY KEY (group_id, course_id)
);

GRANT USAGE ON SCHEMA app TO demo_service;
GRANT SELECT, INSERT, UPDATE, DELETE
    ON TABLE app.students, app.student_profiles TO demo_service;
GRANT SELECT ON TABLE app.groups, app.courses TO demo_service;
GRANT SELECT, INSERT, DELETE ON TABLE app.group_courses TO demo_service;
