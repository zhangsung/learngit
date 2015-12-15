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
public class ZipFormat extends AbstractView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map result = model;
		FileInputStream fis = null;
		OutputStream out = null;

		File file =  (File) result.get(CommonTag.result.name());
		
		try {
			if (file.exists() && file.isFile()) {
				fis = new FileInputStream(file);
				out = response.getOutputStream();
				response.setContentType(getContentType());
				response.setContentLength((int)file.length());
				
				response.setHeader("Content-Disposition", "attachment;filename=" + StrUtil.encodeURL(file.getName(),"UTF-8"));
				response.setHeader("Content-Transfer-Encoding", "binary");
				FileCopyUtils.copy(fis, out);
				out.flush();
				if (file != null && file.exists())
					file.delete();
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
