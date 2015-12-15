package com.nssoft.view;

import com.neighborsystem.durian.restapi.api.CommonTag;
import com.neighborsystem.durian.utils.StrUtil;
import com.nssoft.model.ExcelObj;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.AbstractView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**   
 *
 * @ClassName ExcelFormat
 * @Description  Excel下载转换View
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2014年12月13日 下午9:00:42    
 * @version V1.0     
 *           
 */
@SuppressWarnings("rawtypes")
public class ExcelFormat extends AbstractView {

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
