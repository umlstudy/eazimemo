package asia.sejong.web.eazimemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import asia.sejong.web.eazimemo.domain.SimpleBoard;
import asia.sejong.web.eazimemo.service.SimpleBoardService;
import asia.sejong.web.eazimemo.web.json.JsonResult;

@Controller("/simpleboard")
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
	
	@RequestMapping(method = RequestMethod.GET, value = "/edit")
	public ModelAndView edit(SimpleBoard simpleBoard) {
		ModelAndView mv = new ModelAndView();
		
		if ( simpleBoard.getIdx() != null ) {
			simpleBoard = simpleBoardService.selectSimpleBoard(simpleBoard.getIdx());
		}
		
		mv.addObject("simpleBoard", simpleBoard);
		mv.setViewName("/simpleboard/SimpleBoardEdit");
		return mv;
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
