package asia.sejong.web.eazimemo.web;

import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import asia.sejong.web.eazimemo.domain.SimpleBoard;
import asia.sejong.web.eazimemo.service.SimpleBoardService;
import asia.sejong.web.eazimemo.web.json.JsonResult;

@Controller
@RequestMapping("/simpleBoard")
public class SimpleBoardController {
	
	@Autowired
	SimpleBoardService simpleBoardService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/simpleboard/simpleBoardList");
		mv.addObject("simpleBoards", simpleBoardService.selectAllSimpleBoard());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/show")
	public ModelAndView show(int idx) {
		ModelAndView mv = new ModelAndView();
		
		SimpleBoard simpleBoard = simpleBoardService.selectSimpleBoard(idx);
		
		mv.addObject("simpleBoard", simpleBoard);
		PegDownProcessor pdp = new PegDownProcessor();
		pdp.markdownToHtml(simpleBoard.getBody());
		mv.addObject("simpleBoardBody", pdp.markdownToHtml(simpleBoard.getBody()));
		mv.setViewName("/simpleboard/simpleBoardShow");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	public ModelAndView edit(SimpleBoard simpleBoard) {
		ModelAndView mv = new ModelAndView();
		
		if ( simpleBoard.getIdx() != null ) {
			simpleBoard = simpleBoardService.selectSimpleBoard(simpleBoard.getIdx());
		}
		
		mv.addObject("simpleBoard", simpleBoard);
		mv.setViewName("/simpleboard/simpleBoardEdit");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/applyAndList")
	public ModelAndView applyAndList(SimpleBoard simpleBoard) {
		apply(simpleBoard);
		return list();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/apply")
	@ResponseBody
	public JsonResult apply(SimpleBoard simpleBoard) {
		if ( simpleBoard.getIdx() != null ) {
			simpleBoardService.updateSimpleBoard(simpleBoard);
		} else {
			simpleBoardService.insertSimpleBoard(simpleBoard);
		}

		return JsonResult.create(simpleBoard);
	}
}
