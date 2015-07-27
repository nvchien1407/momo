package com.momo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.momo.domain.ProductDo;
import com.momo.service.interfaces.TestService;
@RestController
public class MainController {
    private TestService testService = null;
    
    @Autowired
    public MainController(TestService testService) {
    	this.testService = testService;
    }

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView getdata() throws Exception {
		ModelAndView model = new ModelAndView("index");
		try {
			List<ProductDo> list = testService.getList();
			model.addObject("lists", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/index/json", method = RequestMethod.GET, headers="Accept=application/json")
	public Map<Integer, ProductDo> troubleshootCase(){
		Map<Integer, ProductDo> map = new HashMap<Integer, ProductDo>();
		try {
			//response.setContentType(MediaType.APPLICATION_JSON.toString());
			//response.addHeader("Content-Disposition", "attachment; filename=ProductDo.json");
			List<ProductDo> list = testService.getList();
			for (ProductDo p : list) {
				map.put(p.getId(), p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/*
	 * @ExceptionHandler(CustomeException.class) public ModelAndView
	 * handleCustomException(CustomeException ex) { ModelAndView model = new
	 * ModelAndView("error"); model.addObject("exception", ex); return model;
	 * 
	 * }
	 * 
	 * @ExceptionHandler(Exception.class) public ModelAndView
	 * handleAllException(Exception ex) { ModelAndView model = new
	 * ModelAndView("error"); return model;
	 * 
	 * }
	 */

}