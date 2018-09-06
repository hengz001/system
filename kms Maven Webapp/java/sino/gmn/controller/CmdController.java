package sino.gmn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import sino.gmn.entity.Cmd;
import sino.gmn.service.CmdService;
import sino.gmn.service.ToolsSevice;

@Controller
@RequestMapping("/cmd")
public class CmdController {
	@Autowired
	private CmdService cmdService;
	
	@Autowired
	private ToolsSevice toolsService;
	
	@RequestMapping("home")
	public Object home(){
		return "dataOperation";
	}
	
	@RequestMapping("/updatePage")
	@ResponseBody
	public Object updatePage(int id){
		Cmd cmd = cmdService.cmdSearch(id);
		return cmd;
	}

	@RequestMapping("/addOrUpdate")
	@ResponseBody
	public Object addOrUpdate(Cmd cmd){
		int rc = -1;
		
		if(null!=cmd){
			if(null==cmd.getId() || null == cmdService.cmdSearch(cmd.getId())){
				rc = cmdService.cmdAdd(cmd);
			}else{
				rc = cmdService.cmdUpdate(cmd);
			}
		}
		return rc;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object cmdDelete(int id){
		return cmdService.cmdDelete(id);
	}
	
	@RequestMapping("/searchPage")
	@ResponseBody
	public Object cmdSearchPage(HttpServletRequest request,HttpServletResponse response, String page, String rows,String name,String value,String sort,String order){
		int total = 0;
		List<Cmd> list = null;
		int iPage,iRows;

		if(null==page||""==page||null==rows||""==rows){
			iPage=1;
			iRows=1024;
		}else{
			iPage = Integer.parseInt(page);
			iRows = Integer.parseInt(rows);
		}
		total = cmdService.cmdCountParamOrder(name, value);
		list = cmdService.cmdSearchPageParamOrder(iPage,iRows,name,value,sort,order);
		
		JSONObject json = new JSONObject();
		json.put("total", total);
		json.put("rows", list);
		return json;
	}
	
	@RequestMapping("/uploadDataFile")
	@ResponseBody
	public Object uploadDataFile(@RequestParam("file")MultipartFile file){
		int rc = 0;
		List<String> key = new ArrayList<String>();
		List<String> value = new ArrayList<String>();
		
		if(null!=file){
			try {
				rc = toolsService.operationStream(file.getInputStream(), key, value);
				for (int i = 0; i < key.size(); i++) {
					Cmd c = new Cmd();
					c.setCommand(key.get(i).substring(0, 2));
					c.setRequest(key.get(i));
					c.setResponse(value.get(i));
					c.setFlag(1);
					c.setDatetime(new Date());
					cmdService.cmdAdd(c);
				}
			} catch (IOException e) {
				e.printStackTrace();
				return String.valueOf(rc); 
			}
			
		}
		
		return String.valueOf(rc);
	}
	
	
	@RequestMapping("interactiveAction")
	@ResponseBody
	public Object interactiveAction(HttpServletRequest request,String ip,String port,String inValue){
		request.setAttribute("flag", "互动");
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(toolsService.operationHsm(ip, port, inValue,map)<=0){
			map.put("recv", "HSM not connect");
			map.put("recvHex", "HSM not connect");
		}
		
		return  JSONObject.toJSON(map);
	}
	
	@RequestMapping("interactive")
	public Object interactive(){
		return "interactive";
	}
	
//	private String getMethodName() {
//		return Thread.currentThread().getStackTrace()[2].getMethodName();
//	}

}
