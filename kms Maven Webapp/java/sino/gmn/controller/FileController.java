package sino.gmn.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import sino.gmn.entity.DownloadFile;
import sino.gmn.service.DownloadFileService;
import sino.gmn.service.ToolsSevice;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private ToolsSevice toolsService;
	
	@Autowired
	private DownloadFileService downloadFileService;
	
	@RequestMapping("/uploadPage")
	public Object page(){
		return "upload";
	}
	
	@RequestMapping("/uploadFile")
	@ResponseBody
	public Object uploadFile(@RequestParam("file")MultipartFile file){
		return Integer.toString(toolsService.uploadFile( file));
	}
	
	@RequestMapping("/searchPage")
	@ResponseBody
	public Object fileSearchPage(HttpServletRequest request,HttpServletResponse response, String page, String rows,String name,String value,String sort,String order){
		int total = 0;
		List<DownloadFile> list = null;
		int iPage,iRows;

		if(null==page||""==page||null==rows||""==rows){
			iPage=1;
			iRows=1024;
		}else{
			iPage = Integer.parseInt(page);
			iRows = Integer.parseInt(rows);
		}
		total = downloadFileService.countParamOrder(name, value);
		list = downloadFileService.searchPageParamOrder(iPage,iRows,name,value,sort,order);
		
		JSONObject json = new JSONObject();
		json.put("total", total);
		json.put("rows", list);
		return json;
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(int id){
		return downloadFileService.deleteDownloadFile(id);
	}
	
	@RequestMapping("/downloadFile")
	public void downloadFile(int id, HttpServletResponse response) throws IOException{
		DownloadFile downloadFile = downloadFileService.searchDownloadFile(id);
		if(	toolsService.downloadFileAction(response, downloadFile.getName())>0){
			downloadFile.setDownloadFileDate(new Date());
			downloadFileService.updateDownloadFile(downloadFile);
		}
	}
	
}
  