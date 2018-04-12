package sino.gmn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
	public String add(HttpServletRequest requuest, Sjl22ApiCommand obj){
		sjl22Service.add(obj);
		return "forward:show.action";
	}
	
	@RequestMapping("/show")
	public String show(HttpServletRequest request){
		List<Sjl22ApiCommand> objs = sjl22Service.selectAllSj();
		request.setAttribute("objs", objs);
		return "sjl22/showSjl22";
	}
}
