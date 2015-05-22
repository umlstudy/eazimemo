CREATE TABLE SimpleBoard (
  idx int(10) unsigned NOT NULL auto_increment,
  title varchar(200) NOT NULL,
  body varchar(500) NOT NULL,
  createTime timestamp default current_timestamp(),
  updateTime timestamp ,
  PRIMARY KEY  (idx)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;