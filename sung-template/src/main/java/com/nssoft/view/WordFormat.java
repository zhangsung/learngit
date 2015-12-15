package com.nssoft.view;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.AbstractView;

import com.neighborsystem.durian.restapi.api.CommonTag;
import com.neighborsystem.durian.utils.StrUtil;
import com.nssoft.model.ExcelObj;

/**   
 *
 * @ClassName WordFormat
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年3月24日 下午1:46:55    
 * @version V1.0      
 *    
 */
public class WordFormat extends AbstractView {
	@SuppressWarnings("rawtypes")
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res) throws Exception {
		Map data = model;
		Workbook wb = null;
		res.setContentType(getContentType());
		try {
			setContentType("text/html;charset=UTF-8");
			ExcelObj excelObj = (ExcelObj) data.get(CommonTag.result.name());
			setContentDisposition(res, excelObj.getFilename());
			wb = excelObj.getWorkbook();
			if (wb != null) {
				wb.write(res.getOutputStream());
				res.getOutputStream().flush();
			}
		} finally {
			data.clear();
			data = null;
			wb = null;
		}
	}
	
	private void setContentDisposition(HttpServletResponse res, String filename) throws UnsupportedEncodingException {
		res.setHeader("Content-disposition", "attachment; filename=" + StrUtil.encodeURL(filename,"UTF-8"));
	}
}
