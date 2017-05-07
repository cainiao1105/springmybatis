package cn.springmvc.controller;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@Controller
@RequestMapping("/")
public class UserComtroller {
	Logger logger =  Logger.getLogger(UserComtroller.class);
	@RequestMapping("importExcel")
    public void importExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
		 MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;    
		Workbook wb = null;  
		try {
			MultipartFile file = multipartRequest.getFile("file");
			String filename = file.getOriginalFilename();
			String fileType = filename.substring(filename.lastIndexOf(".")+1);
			logger.info("文件格式"+fileType);
			InputStream in = file.getInputStream();
			if (fileType.equals("xls")) {
				 wb = new HSSFWorkbook(in);  
			}else if(fileType.equals("xlsx")){
				  wb = new XSSFWorkbook(in);  
			}else{
				throw new Exception("文件类型错误");
			}
			Sheet sheet = wb.getSheetAt(0);
			int count = sheet.getLastRowNum();
			for (int i = 1; i <= count; i++) {
				Row row = sheet.getRow(i);
				row.getCell(0).setCellType(1);
				row.getCell(1).setCellType(1);
				String id = row.getCell(0).getStringCellValue();
				String name = row.getCell(1).getStringCellValue();
				logger.info("id=" + id +",name="+name);
				
			}
			in.close();
			
			response.getWriter().print("<script type='text/javascript'>parent.clear();alert('消息内容不能为空');</script>");
		} catch (Exception e) {
			logger.error("导入excel异常", e);
		}
    }
}
