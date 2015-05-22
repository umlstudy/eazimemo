package asia.sejong.web.eazimemo.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classes={
			MvcConfig.class
			,DbConfig.class
		}
	)
@WebAppConfiguration
@ActiveProfiles("dev")
public class IndexControllerTest {
	
    @Autowired WebApplicationContext wac; 
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    
    protected IndexController ctrl;
    
	@Test
	public void index() throws Exception {
		
		String path ="/index";
		MvcResult result = mockMvc.perform(
				get(path)
				.param("debug", "true")
				)
				.andReturn();
		
		System.out.println(result);
		
		ModelMap modelMap = result.getModelAndView().getModelMap();
		System.out.println(modelMap);
	}
}