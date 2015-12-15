package com.nssoft.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.nssoft.exception.ConvertException;
import com.nssoft.exception.OperateFileException;
import com.nssoft.model.FileObj;


/**   
 *
 * @ClassName FileUtil
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月15日 下午7:22:48    
 * @version V1.0      
 *    
 */
@SuppressWarnings({ "unchecked", "rawtypes" ,"serial" })
public class FileUtil {
	
	private static final Logger logger = Logger.getLogger(FileUtil.class);
	
	public static String test = "/test/";
	public static String newProductPhoto = "/newproduct/photo/";
	public static String orderPhoto = "/order/photo/";
	public static String orderPaperDisplayMode = "/order/paper-displaymode/";
	public static String orderPaperFoldingMode = "/order/paper-foldingmode/";
	public static String orderPaperFinalShape = "/order/paper-finalshape/";
	public static String orderPPSample = "/order/sample-pp/";
	public static String orderInnerSample = "/order/sample-inner/";
	public static String orderBulkSample = "/order/sample-bulk/";
	public static String shipmentInspection = "/shipment/inspection/";
	public static String taxrefundCustomsDeclaration = "/taxrefund/customs-declaration/";
	public static String taxrefundVatInvoice = "/taxrefund/vat-invoice/";
	public static String taxrefundDeclaration = "/taxrefund/taxrefund-declaration/";
	public static String bug = "/bug/";
	
	public static ArrayList<String> getFileModules(){
		return new ArrayList<String>() {{
			add(test);
			add(newProductPhoto);
			add(orderPhoto);
			add(orderPaperDisplayMode);
			add(orderPaperFoldingMode);
			add(orderPaperFinalShape);
			add(orderPPSample);
			add(orderInnerSample);
			add(orderBulkSample);
			add(shipmentInspection);
			add(taxrefundCustomsDeclaration);
			add(taxrefundVatInvoice);
			add(taxrefundDeclaration);
			add(bug);
		}};
	}
	
	public static Boolean filesUnUsed (String module_cd , String module_no, SqlSession session) {
		if (module_cd == null || module_no == null) 
			return false;
		else {
			Map paramMap = new HashMap();
			paramMap.put("module_cd", module_cd);
			paramMap.put("module_no", module_no);
			return (session.update("common.filesUnused", paramMap) > 0);
		}
	}
	
	public static Boolean filesUnUsed (Map paramMap, SqlSession session) {
		return (session.update("common.filesUnused", paramMap) > 0);
	}
	
	public static Boolean filesUsed (Map paramMap, SqlSession session) {
		return (session.update("common.filesUsed", paramMap) > 0);
	}
	
	public static Boolean filesUsed (String module_cd, String module_no, String file_list, SqlSession session) {
		if (file_list == null || file_list.length() <= 0 || module_cd == null || module_no == null)
			return false;
		else {
			Map paramMap = new HashMap();
			paramMap.put("module_cd", module_cd);
			paramMap.put("module_no", module_no);
			paramMap.put("file_list", file_list.split(","));
			return (session.update("common.filesUsed", paramMap) > 0);
		}
	}
	
	public static List getFiles (Map paramMap, SqlSession session) {
		return session.selectList("common.getFiles", paramMap);
	}
	
	public static List getFiles (final String module_cd, final String module_no, final String fileIds, SqlSession session) {
		return session.selectList("common.getFiles", new HashMap(){
			{
				put("module_cd", module_cd);
				put("module_no", module_no);
				if (fileIds != null)
					put("fileIds", fileIds.split(","));
			}
		});
	}
	
	public static List getFiles (final String module_cd, final String module_no, final String fileIds, final String fileExtensions, SqlSession session) {
		return session.selectList("common.getFiles", new HashMap(){
			{
				put("module_cd", module_cd);
				put("module_no", module_no);
				if (fileIds != null)
					put("fileIds", fileIds.split(","));
				if (fileExtensions != null)
					put("fileExtensions", fileExtensions.split(","));
			}
		});
	}
	
	public static Boolean deleteFiles (Map paramMap, String contextPath, SqlSession session) {
		Boolean f = false;
		List<Map> files = getFiles(paramMap, session);
		for (Map map : files) {
			File file = new File(contextPath + map.get("file_path"),
					map.get("file_id") + "." + map.get("file_extension"));
			if (file.exists() && file.isFile())
				file.delete();
		}
		if (session.delete("common.deleteFiles", paramMap) > 0) {
			f = true;
		}
		return f;
	}
	
	public static Boolean deleteFiles (final String module_cd, final String module_no, final String fileIds, String contextPath, SqlSession session) {
		Boolean f = false;
		List<Map> files = getFiles(module_cd, module_no, fileIds, session);
		for (Map map : files) {
			File file = new File(contextPath + map.get("file_path"),
					map.get("file_id") + "." + map.get("file_extension"));
			if (file.exists() && file.isFile())
				file.delete();
		}
		
		if (session.delete("common.deleteFiles", new HashMap() {{
				put("module_cd", module_cd);
				put("module_no", module_no);
				if (fileIds != null)
					put("fileIds", fileIds.split(","));
			}}) > 0) 
				f = true;
		return f;
	}
	
	public static FileObj getFileInfo(MultipartFile multiFile,String file_path) {
		FileObj fileObj = new FileObj();
		if (multiFile != null && !multiFile.isEmpty()) {
			String originName = multiFile.getOriginalFilename();
	 		try {
	 			originName = new String (originName.getBytes ("iso-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				logger.error(e);
				throw new ConvertException("编码错误.");
			}
			String fileExtension = originName.substring(originName.lastIndexOf(".") + 1);
			String fileName = originName.substring(0, originName.lastIndexOf("."));
	    		
	    		long curTime = System.currentTimeMillis();
	    		String fileId = fileName + Long.toString(curTime);
	    		String fileContentType = multiFile.getContentType();
			
	 		fileObj.setFile_id(fileId);
	 		fileObj.setFile_nm(fileName);
	 		fileObj.setFile_extension(fileExtension);
	 		fileObj.setFile_path(file_path);
	 		fileObj.setFile_content_type(fileContentType);
		}
	    	return fileObj;
	 }
	
	 public static Boolean writeFile(MultipartFile file,FileObj fileObj) {
		File f = new File(fileObj.getFile_path());
		FileOutputStream fos = null;
		if (!f.exists()) {
			f.mkdirs();
			logger.info("创建了" + fileObj.getFile_path() + "文件夹.");
		}
		Boolean returnValue = true;
		try {
			fos = new FileOutputStream(new File(
					fileObj.getFile_path(),
					fileObj.getFile_id() + 
					"." +
					fileObj.getFile_extension()));
			if (file != null && !file.isEmpty())
				fos.write(file.getBytes());
		} catch(Exception e) {
			returnValue = false;
			logger.error(e);
			throw new OperateFileException("写文件错误.");
		} finally {
			if (fos != null)
				try {
					fos.close();
					fos = null;
				} catch (IOException e) {
					logger.error(e);
					throw new OperateFileException("关闭文件流错误.");
				}
		}
		return returnValue;
	}
	 
 	//删除单个文件
	public static boolean deleteFile(String sPath) {
	    Boolean flag = false;
	    File file = new File(sPath);
	    if (file.isFile() && file.exists()) {
	        file.delete();
	        flag = true;
	    }
	    return flag;
	}
	
	//删除目录（遍历）
	public static boolean deleteDirectory(String sPath) {
		Boolean flag = false;
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    if (!dirFile.exists() || !dirFile.isDirectory())   
	        return false;  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } 
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) 
	    		return false;  
	    if (dirFile.delete()) 
	        return true;  
	    else  
	    		return false;  
	}

}
