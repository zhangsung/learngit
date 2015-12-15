package com.nssoft.model;

import org.apache.poi.ss.usermodel.Workbook;

/** 
 *  
 * @ClassName ExcelObj
 * @Description 
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2014年12月12日 下午1:38:23    
 * @version V1.0        
 *        
 */
public class ExcelObj {
	private String filename = "";
	private Workbook workbook = null;
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Workbook getWorkbook() {
		return workbook;
	}
	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}
	public ExcelObj() {
	}
	public ExcelObj(String filename, Workbook workbook) {
		this.filename = filename;
		this.workbook = workbook;
	}
	
	
	
}
