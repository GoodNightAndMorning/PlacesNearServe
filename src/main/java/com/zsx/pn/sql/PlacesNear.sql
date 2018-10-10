//后台管理账户
create table manager_tb (
  id int not null primary key auto_increment,
  name varchar(50) not null ,
  password varchar(32) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into manager_tb (name, password) values (
  "admin", "123456"
);

//一级标签表
create table tags_tb (
  id int not null primary key auto_increment,
  name varchar(50) not null,
  number int default 0,
  creator varchar(50),
  create_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
//["公交站","地铁站","电动车维修店","四儿子店","商业广场","垃圾回收站","医院","诊所","银行","派出所","ATM"]
insert into tags_tb (name, creator) values (
  "四儿子店", "admin"
),(
  "商业广场", "admin"
),(
  "垃圾回收站", "admin"
),(
  "医院", "admin"
),(
  "诊所", "admin"
),(
  "银行", "admin"
),(
  "派出所", "admin"
),(
  "ATM", "admin"
),(
  "超市", "admin"
),(
  "KTV", "admin"
),(
  "酒吧", "admin"
);

//创建用户表
create table user_tb (
  id int not null primary key auto_increment,
  name varchar(50) not null ,
  nick_name varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;;
insert into user_tb (name) values (
  "15860763896"
);

//创建地点表
create table places_tb (
  id int not null primary key auto_increment,
  tag_id int not  null ,
  place_name varchar(100) not null ,
  place_phone varchar(50),
  place_desc Text,
  place_photos Text,
  longitude double not null,
  latitude double not null,
  creator_id int not null,
  create_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  state int not null default 0,
  foreign key (tag_id) references tags_tb(id),
  foreign key (creator_id) references user_tb(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into places_tb (tag_id, place_name, place_phone, place_desc, place_photos, longitude, latitude, creator_id) values (
  1, "招呼站", "15860763896", "xxxxxxxxxxxxxxxxx", "http://www.baidu.com", 26.0631080000, 119.3185120000, 1
);
