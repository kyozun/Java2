create table student_class
(
    student_id varchar(50) not null
        constraint PK_student_class
            primary key,
    class_id   varchar(50)
)
go

create table class_name
(
    student_id   varchar(50),
    class_id     varchar(50)
        constraint FK_class_name_student_class
            references student_class,
    class_name   text,
    class_number int
)
go

create table score
(
    student_id varchar(50)
        constraint FK_score_student_class
            references student_class,
    subject_id varchar(50),
    score      int,
    result     text
)
go

create table student_name
(
    student_id   varchar(50) not null
        constraint PK_student_name
            primary key,
    student_name text
)
go

create table subject
(
    subject_id   varchar(30) not null
        constraint PK_subject
            primary key,
    subject_name varchar(50) not null
)
go

create table sysdiagrams
(
    name         sysname not null,
    principal_id int     not null,
    diagram_id   int identity
        primary key,
    version      int,
    definition   varbinary(max),
    constraint UK_principal_name
        unique (principal_id, name)
)
go

exec sp_addextendedproperty 'microsoft_database_tools_support', 1, 'SCHEMA', 'dbo', 'TABLE', 'sysdiagrams'
go


