package sino.gmn.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sino.gmn.entity.PageUtil;
import sino.gmn.entity.Sjl22ApiCommand;
import sino.gmn.service.Sjl22ApiCommandService;
import sino.gmn.service.ToolsSevice;

@Controller
@RequestMapping("/sjl22")
public class Sjl22ApiCommandController {

	@Autowired
	Sjl22ApiCommandService sjl22Service;
	
	@Autowired
	ToolsSevice toolsService;
	
	List<Sjl22ApiCommand> objs;
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Sjl22ApiCommand obj){
		request.setAttribute("flag","主页");
		return "sjl22/home";
	}
	
	@RequestMapping("/addData")
	public String addData(HttpServletRequest request, Sjl22ApiCommand obj){
		request.setAttribute("flag","添加");
		return "sjl22/addData";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Sjl22ApiCommand obj){
		sjl22Service.add(obj);
		return "forward:show.action";
	}
	
	@RequestMapping("/show")
	public String show(HttpServletRequest request){
		int currpageNum = 1;
		int pageSize = 10;
	
		request.setAttribute("flag","查询");
		PageUtil page = sjl22Service.getPage(pageSize, currpageNum);
		if(null == page){
			return "sjl22/showSjl22";
		}
		objs = sjl22Service.selectSjRecord(page.getCurrpageNum(), page.getPageSize());
		if(null != objs){
			request.setAttribute("objs", objs);
			request.setAttribute("page", page);
		}
		return "sjl22/showSjl22";
	}
	
	@RequestMapping("/file")
	public String uploadPage(HttpServletRequest request){
		request.setAttribute("flag","读取");
		return "sjl22/upload";
	}
	
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request,String username, @RequestParam("file1") MultipartFile file1){
		String message = "ERROR!";
		
		try {
			sjl22Service.addAll(file1.getInputStream(),username);
			message = "successfully.";
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		return "sjl22/message";
	}
	
	@RequestMapping("findPage")
	public String findPage(HttpServletRequest request, HttpServletResponse response, PageUtil page,String paramType,String parameter){
		
		request.setAttribute("flag","查询");
		page.setTotalCount(sjl22Service.getCountParam(paramType, parameter));
		request.setAttribute("page", page);
		
		if(null==paramType || null==parameter){
			objs = sjl22Service.selectSjRecord(page.getCurrpageNum(), page.getPageSize());
		}else{
			objs = sjl22Service.selectSjRecordParam(page.getCurrpageNum(), page.getPageSize(), paramType, parameter);
			request.setAttribute("paramType", paramType);
			request.setAttribute("parameter", parameter);
		}
		
		if(null != objs){
			request.setAttribute("objs", objs);
		}
		
		return "sjl22/showSjl22";
	}
	
	@RequestMapping("/uploadFile")
	public String uploadFile(HttpServletRequest request){
		request.setAttribute("flag","上传");
		return "sjl22/uploadFile";
	}
	
	@RequestMapping("/downloadFile")
	public String downloadFile(HttpServletRequest request){
		request.setAttribute("flag","下载");
		request.setAttribute("fileNames", toolsService.getFiles(request));
		return "sjl22/downloadFile";
	}
	
	@RequestMapping("/uploadFileAction")
	public String uploadFileAction(HttpServletRequest request, @RequestParam("file1") MultipartFile file1){
		String message = "ERROR!";
		
		if(toolsService.uploadFile(request, file1)>0){
			message = "successfully.";
		}
		
		request.setAttribute("message", message);
		return "sjl22/message";
	}
	
	@RequestMapping("/downloadFileAction")
	public void downloadFileAction(HttpServletRequest request,HttpServletResponse  response, String fileName){
		toolsService.downloadFileAction(request, response, fileName);
	}
}
