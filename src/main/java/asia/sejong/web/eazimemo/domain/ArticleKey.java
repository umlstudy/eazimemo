package asia.sejong.web.eazimemo.domain;


public class ArticleKey {

	private int parentArticleId;

	private int articleId;

	public ArticleKey() {
	}

	public int getParentArticleId() {
		return parentArticleId;
	}

	public void setParentArticleId(int parentArticleId) {
		this.parentArticleId = parentArticleId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
}
