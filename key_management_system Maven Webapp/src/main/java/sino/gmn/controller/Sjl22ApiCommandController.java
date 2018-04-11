package sino.gmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sino.gmn.entity.Sjl22ApiCommand;
import sino.gmn.service.Sjl22ApiCommandService;

@Controller
@RequestMapping("/sjl22")
public class Sjl22ApiCommandController {

	@Autowired
	Sjl22ApiCommandService sjl22Service;
	
	@RequestMapping("/add")
	public String add(Sjl22ApiCommand obj){
		sjl22Service.add(obj);
		return "sjl22/MyJsp";
	}
}
