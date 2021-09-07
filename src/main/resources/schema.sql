drop table if exists employees;
create table employees
(
    employee_id   BIGSERIAL primary key,
    first_name    varchar(20),
    last_name     varchar(20),
    department_id varchar(20),
    job_title     varchar(20),
    gender        varchar(20),
    date_of_birth varchar(20)
)