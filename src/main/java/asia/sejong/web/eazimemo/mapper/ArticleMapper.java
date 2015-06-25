package asia.sejong.web.eazimemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import asia.sejong.web.eazimemo.domain.Article;

public interface ArticleMapper {

	public int insertArticle(Article article);

	public int updateArticle(Article article);

	@Select("SELECT * FROM Article")
	public List<Article> selectAllArticle();

	@Select("SELECT * FROM Article WHERE articleId = #{articleId}")
	public Article selectArticle(@Param("articleId") int articleId);


}
