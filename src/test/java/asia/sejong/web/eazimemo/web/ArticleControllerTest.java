package asia.sejong.web.eazimemo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import asia.sejong.web.eazimemo.springconfig.root.DbConfig;
import asia.sejong.web.eazimemo.springconfig.web.MvcConfig;
import asia.sejong.web.eazimemo.web.json.JsonResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes={
			MvcConfig.class
			,DbConfig.class
		}
	)
@WebAppConfiguration
@ActiveProfiles("dev")
public class ArticleControllerTest {
	
    @Autowired WebApplicationContext wac; 
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    protected IndexController ctrl;
    
	@Test
	public void list() throws Exception {
		
		String path ="/article/list";
		MvcResult result = mockMvc.perform(
				get(path)
				.param("debug", "true")
				)
				.andReturn();
		
		System.out.println(result);
		
		ModelMap modelMap = result.getModelAndView().getModelMap();
		System.out.println(modelMap);
	}
	
	//@Test
	public void insertAndUpdate() throws Exception {
		
		String path ="/article/apply";
		MvcResult result = mockMvc.perform(
				post(path)
				.param("title", "한글타이틀")
				.param("content", "Hello BODY")
				.accept(MediaType.APPLICATION_JSON)
				)
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonResult rslt = mapper.readValue(content, JsonResult.class);
		Map<?,?> sb = (Map<?,?>)rslt.getResult();
		result = mockMvc.perform(
				post(path)
				.param("title", "한글 타이틃2")
				.param("content", "한글 보디")
				.param("articleId", sb.get("articleId").toString())
				)
				.andReturn();
		
		System.out.println(result);
	}
}