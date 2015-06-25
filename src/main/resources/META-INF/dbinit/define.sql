CREATE TABLE IF NOT EXISTS Article (
  -- categoryId varchar(20) NOT NULL COMMENT '게시판종류', 
  parentArticleId integer unsigned NOT NULL default '0' COMMENT '계층적검색을 위한 컬럼',
  articleId integer unsigned NOT NULL auto_increment,
  -- writerId varchar(40) NOT NULL,
  title varchar(200) NOT NULL,
  content mediumtext,
  readCount integer unsigned NOT NULL default '0' COMMENT '읽은 횟수',
  likeCount integer unsigned NOT NULL default '0' COMMENT '추천',
  hateCount integer unsigned NOT NULL default '0' COMMENT '반대',
  email varchar(40) COMMENT '작성자이메일',
  -- passwd varchar(20) COMMENT '게시물암호',
  createTime timestamp default current_timestamp(),
  updateTime timestamp ,
  PRIMARY KEY  (articleId)
) 
ENGINE=InnoDB, 
DEFAULT CHARSET=utf8;
-- ALTER TABLE Article AUTO_INCREMENT = 100;
CREATE INDEX Article_Default
ON Comment (parentArticleId, articleId);

CREATE TABLE IF NOT EXISTS Comment ( 
  -- categoryId varchar(20) NOT NULL,
  parentArticleId integer unsigned NOT NULL,
  articleId integer unsigned NOT NULL,
  parentCommentId integer unsigned NOT NULL default '0',
  commentId integer unsigned NOT NULL auto_increment,
  content character varying(200) NOT NULL, 
  -- writerId varchar(40) NOT NULL,
  createTime timestamp default current_timestamp(),
  PRIMARY KEY  (commentId)
) 
ENGINE=InnoDB, 
DEFAULT CHARSET=utf8; 

CREATE INDEX Comment_Default
ON Comment (parentArticleId, articleId, parentCommentId, commentId);


CREATE TABLE IF NOT EXISTS Category (
 categoryId varchar(20) NOT NULL COMMENT '게시판종류',
 categoryName varchar(50) NOT NULL COMMENT '게시판종류명',
 -- passwd varchar(20),
 -- readonly enum('Y', 'N') NOT NULL default 'N',
 createTime timestamp default current_timestamp(),
 PRIMARY KEY (num)
) ENGINE=InnoDB, DEFAULT CHARSET=utf8, COMMENT='게시판종류';

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