create table manager_tb (
  id int not null primary key auto_increment,
  name varchar(50) not null ,
  password varchar(32) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into manager_tb (name, password) values (
  "admin", "123456"
);