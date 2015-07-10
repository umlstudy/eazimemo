--
-- Article
--
CREATE TABLE IF NOT EXISTS Article (
  articleId integer unsigned NOT NULL auto_increment,
  parentArticleId integer unsigned NOT NULL default '0' COMMENT '계층적검색을 위한 컬럼',
  categoryId varchar(20) NOT NULL COMMENT '게시판종류', 
  writerId varchar(40) NOT NULL,
  title varchar(200) NOT NULL,
  content mediumtext,
  count integer unsigned NOT NULL default '0' COMMENT '읽은 횟수',
  likeThis integer unsigned NOT NULL default '0',
  hateThis integer unsigned NOT NULL default '0',
  email varchar(40),
  passwd varchar(20) NOT NULL,
  createTime timestamp default current_timestamp(),
  updateTime timestamp ,
  PRIMARY KEY  (articleId)
) 
ENGINE=InnoDB 
DEFAULT CHARSET=utf8
auto_increment = 100;

--
-- Category
--
CREATE TABLE IF NOT EXISTS Category (
 categoryId varchar(20) NOT NULL COMMENT '카테고리명을 영문으로 작성한다.',
 categoryName varchar(50) NOT NULL,
 -- readonly enum('Y', 'N') NOT NULL default 'N',
 createTime timestamp default current_timestamp(),
 PRIMARY KEY (categoryId)
) 
ENGINE=InnoDB 
DEFAULT CHARSET=utf8;

--
-- Comment
--
CREATE TABLE IF NOT EXISTS Comment ( 
  commentId integer unsigned NOT NULL auto_increment,
  articleId integer unsigned NOT NULL COMMENT '외부키',
  parentCommentId integer unsigned NOT NULL default '0' COMMENT '계층적검색을 위한 컬럼',
  content character varying(200) NOT NULL, 
  writerId varchar(40) NOT NULL,
  createTime timestamp default current_timestamp(),
  PRIMARY KEY  (commentId)
)
ENGINE=InnoDB 
DEFAULT CHARSET=utf8
auto_increment = 100;

--
-- Keyword
--
CREATE TABLE IF NOT EXISTS Keyword ( 
  keywordId integer unsigned NOT NULL auto_increment,
  keywordName varchar(50) NOT NULL,
  createTime timestamp default current_timestamp(),
  PRIMARY KEY (keywordId)
)
ENGINE=InnoDB 
DEFAULT CHARSET=utf8
auto_increment = 100;

--
-- KeywordArticleRel
--
CREATE TABLE IF NOT EXISTS KeywordArticleRel ( 
  keywordId integer unsigned NOT NULL,
  articleId integer unsigned NOT NULL,
  createTime timestamp default current_timestamp(),
  PRIMARY KEY (keywordId, articleId)
)
ENGINE=InnoDB 
DEFAULT CHARSET=utf8;

--
-- User
--
CREATE TABLE IF NOT EXISTS User (
  userId varchar(40) NOT NULL,
  password varchar(45) NOT NULL,
  enabled TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (userId)
)
ENGINE=InnoDB 
DEFAULT CHARSET=utf8;
INSERT INTO User(userId,password,enabled) VALUES ('sejong','123456', TRUE);
INSERT INTO User(userId,password,enabled) VALUES ('admin','123456', TRUE);
--
-- Group
--
CREATE TABLE IF NOT EXISTS RoleGroup (
  roleGroupId VARCHAR(20) NOT NULL, -- ADMIN, USER ..
  PRIMARY KEY (roleGroupId)
)
ENGINE=InnoDB 
DEFAULT CHARSET=utf8;
INSERT INTO RoleGroup(roleGroupId) VALUES ('ADMIN');
INSERT INTO RoleGroup(roleGroupId) VALUES ('USER');
--
-- UserGroupRel
--
CREATE TABLE IF NOT EXISTS UserRoleGroupRel (
  roleGroupId VARCHAR(20) NOT NULL , -- ADMIN, USER ..
  userId VARCHAR(40) NOT NULL ,
  PRIMARY KEY (roleGroupId, userId)
)
ENGINE=InnoDB 
DEFAULT CHARSET=utf8;
INSERT INTO UserRoleGroupRel(roleGroupId, userId) VALUES ('ADMIN', 'admin');
INSERT INTO UserRoleGroupRel(roleGroupId, userId) VALUES ('USER', 'sejong');



-- 계층적 질의를 사용하지 않음 
SELECT * FROM Article; 

-- 계층적 질의를 사용함  (ORACLE ONLY)
SELECT *, LEVEL FROM Article 
START WITH parentBoardNo = 0
CONNECT BY PRIOR boardNo=parentBoardNo 
ORDER SIBLINGS BY boardNo DESC; 

-- 계층적 질의를 사용함  (ALL DB)
-- http://mikehillyer.com/articles/managing-hierarchical-data-in-mysql/
SELECT 
	CONCAT( REPEAT(' ', COUNT(parent.name) - 1), node.name) AS name
FROM 
	nested_category AS node,
	nested_category AS parent
WHERE 
	node.lft BETWEEN parent.lft AND parent.rgt
GROUP BY node.name
ORDER BY node.lft;