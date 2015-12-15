package com.nssoft.api.test.sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFSimpleShape;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;

import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.model.ExcelObj;

/**
 * @api {post} /v1/api/test/sample/excel.excel Excel.java
 * @apiVersion 1.0.0
 * @apiName  Excel.java
 * @apiGroup com.nssoft.api.test.sample
 * @apiParam {String} [a]      可选参数x.
 * @apiParam {Number} [b=18]   可选参数的默认值为'18'.
 * @apiParam {String} c        必填参数z.
 * @apiParam {String} d="D"    必填参数的默认值为'D'.
 * @apiSampleRequest /v1/api/test/sample/excel.excel
 * @author xuliguo
 * @date 2015年8月18日 上午9:49:56
 */
@SuppressWarnings({ "rawtypes" })
@Controller("/v1/api/test/sample/excel.excel")
public class Excel extends AbsQuery<ExcelObj> {

	@Override
	public String getApiId() {
		return "sample_excel";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.ALL;
	}

	@Override
	public ExcelObj executeAPI(HttpServletRequest req, HttpServletResponse res,
			String trId) throws AbsException {
		return new ExcelObj("excel-test.xls", exportTable());
	}

	@Override
	public Class getMustParameter() throws AbsException {
		return null;
	}

	@Override
	public Class getOptionParameter() throws AbsException {
		return null;
	}

	private HSSFWorkbook exportTable() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("WorkSheet1");
		sheet.setDefaultColumnWidth(10);
		HSSFCellStyle style = wb.createCellStyle();
		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 12);
		HSSFFont font1 = wb.createFont();
		font1.setFontHeightInPoints((short) 7);
		style.setFont(font);
		style1.setFont(font1);
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("test");
		cell.setCellStyle(style1);
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		HSSFClientAnchor a = new HSSFClientAnchor(0, 0, 1023, 255, (short) 0,
				0, (short) 0, 0);
		HSSFSimpleShape shape1 = patriarch.createSimpleShape(a);
		shape1.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);
		shape1.setLineStyle(HSSFSimpleShape.LINESTYLE_SOLID);

		for (int i = 0; i < 20; i++) {
			String xVal = "test";
			row.createCell(i + 1).setCellValue(xVal);
		}
		for (int i = 0; i < 20; i++) {
			row = sheet.createRow((int) i + 1);
			for (int t = 0; t < 10; t++) {
				row.createCell(t).setCellValue("test中文");
			}
		}
		return wb;
	}
}
