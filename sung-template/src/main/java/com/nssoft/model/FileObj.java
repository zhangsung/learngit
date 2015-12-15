package com.nssoft.model;
/** 
 *  
 * @ClassName DownLoadObj
 * @Description 
 * Copyright (c) 2014 by NS Soft.  
 * @author xuliguo   
 * @date 2014年12月12日 下午1:36:11    
 * @version V1.0        
 *        
 */
public class FileObj {
	
	private String file_id = "";
	private String file_nm = "";
	private String file_path = "";
	private String file_extension = "";
	private String file_content_type = "";
	public String getFile_id() {
		return file_id;
	}
	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}
	public String getFile_nm() {
		return file_nm;
	}
	public void setFile_nm(String file_nm) {
		this.file_nm = file_nm;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_extension() {
		return file_extension;
	}
	public void setFile_extension(String file_extension) {
		this.file_extension = file_extension;
	}
	public String getFile_content_type() {
		return file_content_type;
	}
	public void setFile_content_type(String file_content_type) {
		this.file_content_type = file_content_type;
	}
	public FileObj() {
	}
	public FileObj(String file_id, String file_nm, String file_path,
			String file_extension, String file_content_type) {
		this.file_id = file_id;
		this.file_nm = file_nm;
		this.file_path = file_path;
		this.file_extension = file_extension;
		this.file_content_type = file_content_type;
	}
	@Override
	public String toString() {
		return "FileObj [file_id=" + file_id + ", file_nm=" + file_nm
				+ ", file_path=" + file_path + ", file_extension="
				+ file_extension + ", file_content_type=" + file_content_type
				+ "]";
	}
}
