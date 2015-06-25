package asia.sejong.web.eazimemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asia.sejong.web.eazimemo.domain.Article;
import asia.sejong.web.eazimemo.mapper.ArticleMapper;

@Service("asia.sejong.web.eazimemo.service.ArticleService")
public class ArticleService {

	@Autowired
	private ArticleMapper articleMapper;

	public List<Article> selectAllArticle() {
		return articleMapper.selectAllArticle();
	}

	public Article selectArticle(int articleId) {
		return articleMapper.selectArticle(articleId);
	}
	
	public int updateArticle(Article article) {
		return articleMapper.updateArticle(article);
	}

	public int insertArticle(Article article) {
		return articleMapper.insertArticle(article);
	}
}
