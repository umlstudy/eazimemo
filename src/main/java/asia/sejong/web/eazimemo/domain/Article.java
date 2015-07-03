package asia.sejong.web.eazimemo.domain;

import java.sql.Timestamp;

public class Article {

	private Integer articleId;
	private Integer parentArticleId;
	private String categoryId;
	private String writerId;
	private String title;
	private String content;
	private Integer count;
	private Integer likeThis;
	private Integer hateThis;
	private String email;
	private String passwd;
	private Timestamp createTime;
	private Timestamp updateTime;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getParentArticleId() {
		return parentArticleId;
	}

	public void setParentArticleId(Integer parentArticleId) {
		this.parentArticleId = parentArticleId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getLikeThis() {
		return likeThis;
	}

	public void setLikeThis(Integer likeThis) {
		this.likeThis = likeThis;
	}

	public Integer getHateThis() {
		return hateThis;
	}

	public void setHateThis(Integer hateThis) {
		this.hateThis = hateThis;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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
