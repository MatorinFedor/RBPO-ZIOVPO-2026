CREATE SCHEMA IF NOT EXISTS app AUTHORIZATION demo_owner;

CREATE TABLE IF NOT EXISTS app.groups
(
    id   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS app.courses
(
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        VARCHAR(255) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE IF NOT EXISTS app.students
(
    id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name                 VARCHAR(255) NOT NULL,
    email                VARCHAR(255) UNIQUE,
    group_id             UUID         NOT NULL REFERENCES app.groups (id),
    additional_course_id UUID REFERENCES app.courses (id)
);

CREATE TABLE IF NOT EXISTS app.student_profiles
(
    id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    student_number VARCHAR(255) NOT NULL UNIQUE,
    internal_note  TEXT,
    student_id     UUID         NOT NULL UNIQUE REFERENCES app.students (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS app.group_courses
(
    group_id  UUID NOT NULL REFERENCES app.groups (id) ON DELETE CASCADE,
    course_id UUID NOT NULL REFERENCES app.courses (id) ON DELETE CASCADE,
    PRIMARY KEY (group_id, course_id)
);

CREATE TABLE IF NOT EXISTS app.application_users
(
    id                      UUID PRIMARY KEY      DEFAULT pg_catalog.gen_random_uuid(),
    email                   VARCHAR(255) NOT NULL UNIQUE,
    password_hash           VARCHAR(255) NOT NULL,
    role                    VARCHAR(32)  NOT NULL,
    enabled                 BOOLEAN      NOT NULL DEFAULT TRUE,
    account_non_expired     BOOLEAN      NOT NULL DEFAULT TRUE,
    account_non_locked      BOOLEAN      NOT NULL DEFAULT TRUE,
    credentials_non_expired BOOLEAN      NOT NULL DEFAULT TRUE
);

GRANT USAGE ON SCHEMA app TO demo_service;
GRANT SELECT, INSERT, UPDATE, DELETE
    ON TABLE app.students, app.student_profiles TO demo_service;
GRANT SELECT ON TABLE app.groups, app.courses TO demo_service;
GRANT SELECT, INSERT, DELETE ON TABLE app.group_courses TO demo_service;
GRANT SELECT, INSERT, UPDATE ON TABLE app.application_users TO demo_service;
