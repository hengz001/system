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
	
	List<Sjl22ApiCommand> objs;
	
	/*
	private int totalCount;//总数
    private int pageSize=10;//每页显示数量
    private int currpageNum;//当前页
    private int pageCount;//总页数
    private int prePage;//上一页
    private int nextPage;//下一页
    private boolean hasPrePage;//是否有上一页
    private boolean hasNextPage;//是否有下一页
    private int firstPage;//第一页
    private int lastPage;//最后一页
    private int currentcount;//当前从第多少条数据开始显示
	*/
	@RequestMapping("/show")
	public String show(HttpServletRequest request){
		int currpageNum = 1;
		int pageSize = 10;
	
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
	public String uploadPage(){
		return "sjl22/upload";
	}
	
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request,String username, @RequestParam("file1") MultipartFile file1){
		String message;
		
		message = "successfully.";
		
		try {
			sjl22Service.addAll(file1.getInputStream(),username);
		} catch (IOException e) {
			message = "ERROR!";
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		return "sjl22/message";
	}
	
	@RequestMapping("findPage")
	public String findPage(HttpServletRequest request, HttpServletResponse response, PageUtil page,String paramType,String parameter){
		
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
	public String uploadFile(){
		return "sjl22/uploadFile";
	}
	
	@RequestMapping("/downloadFile")
	public String downloadFile(){
		return "sjl22/downloadFile";
	}
}
