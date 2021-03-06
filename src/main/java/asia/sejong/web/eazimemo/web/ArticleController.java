package asia.sejong.web.eazimemo.web;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.pegdown.PegDownProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import asia.sejong.web.eazimemo.domain.Article;
import asia.sejong.web.eazimemo.service.ArticleService;
import asia.sejong.web.eazimemo.web.json.JsonResult;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/article/articleList");
		mv.addObject("articles", articleService.selectAllArticle());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/show")
	public ModelAndView show(int articleId) {
		ModelAndView mv = new ModelAndView();
		
		Article article = articleService.selectArticle(articleId);
		
		mv.addObject("article", article);
		PegDownProcessor pdp = new PegDownProcessor();
		pdp.markdownToHtml(article.getContent());
		//mv.addObject("articleBody", pdp.markdownToHtml(article.getBody()));
		mv.setViewName("/article/articleShow");
		return mv;
	}
	
	@Secured( {"ROLE_ADMIN", "ROLE_USER" } )
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	public ModelAndView edit(Article article) {
		ModelAndView mv = new ModelAndView();
		
		if ( article.getArticleId() != null ) {
			article = articleService.selectArticle(article.getArticleId());
		}
		
		mv.addObject("article", article);
		mv.setViewName("/article/articleEditBySummerNote");
		return mv;
	}
	
	@Secured( {"ROLE_ADMIN", "ROLE_USER" } )
	@RequestMapping(method = RequestMethod.POST, value = "/applyAndList")
	public ModelAndView applyAndList(Article article) {
		apply(article);
		return list();
	}
	
	@Secured( {"ROLE_ADMIN", "ROLE_USER" } )
	@RequestMapping(method = RequestMethod.POST, value = "/apply")
	@ResponseBody
	public JsonResult apply(Article article) {
		System.out.println(ToStringBuilder.reflectionToString(article, ToStringStyle.SIMPLE_STYLE));
		if ( article.getArticleId() != null ) {
			articleService.updateArticle(article);
		} else {
			article.setWriterId("개똥아");
			article.setPasswd("암호흥");
			article.setCategoryId("FreeBoard");
			articleService.insertArticle(article);
		}

		return JsonResult.create(article);
	}
}
