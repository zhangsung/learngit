package com.nssoft.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.neighborsystem.durian.restapi.api.CommonTag;
import com.neighborsystem.durian.utils.StrUtil;
import com.nssoft.exception.OperateFileException;
import com.nssoft.model.FileObj;

/**   
 *
 * @ClassName DownloadFormat
 * @Description 文件下载View
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2014年12月12日 下午2:02:02    
 * @version V1.0     
 *           
 */
@SuppressWarnings("rawtypes")
public class DownloadFormat extends AbstractView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = model;
		File file = null;
		FileInputStream fis = null;
		OutputStream out = null;

		FileObj fileObj =  (FileObj) result.get(CommonTag.result.name());

		String file_id = fileObj.getFile_id();
		String file_nm = fileObj.getFile_nm();
		String file_path = fileObj.getFile_path();
		String file_extension = fileObj.getFile_extension();
		String file_content_type = fileObj.getFile_content_type();
		
		setContentType(file_content_type);
		try {
			file = new File(file_path, file_id + "." + file_extension);
			if (file.exists() && file.isFile()) {
				fis = new FileInputStream(file);
				out = response.getOutputStream();
				response.setContentType(getContentType());
				response.setContentLength((int)file.length());
				file_nm += "." + file_extension;
				
				response.setHeader("Content-Disposition", "attachment;filename=" + StrUtil.encodeURL(file_nm,"UTF-8"));
				response.setHeader("Content-Transfer-Encoding", "binary");
				FileCopyUtils.copy(fis, out);
				out.flush();
			}
		} catch (FileNotFoundException e) {
			logger.error(e);
			throw new OperateFileException("未找到文件.");
		} catch (IOException e) {
			logger.error(e);
			throw new OperateFileException("文件读取错误.");
		} finally {
			if (fis != null) { 
				try { 
					fis.close(); 
				} catch (IOException e) {
					logger.error(e);
					throw new OperateFileException("关闭文件输入流错误.");
				}
			}
			if (out != null) { 
				try { 
					out.close(); 
				} catch (IOException e) {
					logger.error(e);
					throw new OperateFileException("关闭文件输出流错误.");
				}
			}
			if(result != null) {
				result.clear();
				result = null;
			}
		}
	}
}
