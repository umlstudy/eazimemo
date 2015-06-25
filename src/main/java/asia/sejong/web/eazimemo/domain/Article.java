package asia.sejong.web.eazimemo.domain;

import java.sql.Timestamp;

public class Article {

	private int parentArticleId;

	private Integer articleId; // 신규생성의 경우 null 값을 가짐.

	private String content;

	private String title;
	
	private int readCount;
	
	private int likeCount;
	
	private int hateCount;
	
	private int depth;

	private Timestamp createTime;

	private Timestamp updateTime;

	public Article() {
	}

	public int getParentArticleId() {
		return parentArticleId;
	}

	public void setParentArticleId(int parentArticleId) {
		this.parentArticleId = parentArticleId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getHateCount() {
		return hateCount;
	}

	public void setHateCount(int hateCount) {
		this.hateCount = hateCount;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
}
