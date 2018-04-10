package sino.gmn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sino.gmn.entity.GmnUser;
import sino.gmn.service.GmnUserService;

@Controller
@RequestMapping("/user")  
public class UserController {  
      
	@Autowired
	private GmnUserService gs;
	
    @RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request){  
    	GmnUser user = new GmnUser();
    	user.setUsername("SwordGod");
    	gs.insert(user);
        return "showUser";  
    }  
}  