package com.nssoft.api.test.sample;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.exception.ApiException;
import com.nssoft.model.FileObj;
import com.nssoft.model.Success;
import com.nssoft.util.FileUtil;
import com.nssoft.util.Prompt;
import com.nssoft.util.RequestUtil;

/**
 * @api {post} /v1/api/test/sample/fileupload.form FileUpload.java
 * @apiVersion 1.0.0
 * @apiName  FileUpload.java
 * @apiGroup com.nssoft.api.test.sample
 * @apiParam {String} [a]      可选参数x.
 * @apiParam {Number} [b=18]   可选参数的默认值为'18'.
 * @apiParam {String} c        必填参数z.
 * @apiParam {String} d="D"    必填参数的默认值为'D'.
 * @apiSampleRequest /v1/api/test/sample/fileupload.form
 * @author xuliguo
 * @date 2015年8月18日 上午9:50:02
 */
@SuppressWarnings({ "rawtypes" })
@Controller("/v1/api/test/sample/fileupload.form")
public class FileUpload extends AbsQuery<Success> {

	private static final Logger logger = Logger.getLogger(FileUpload.class);

	@Override
	public String getApiId() {
		return "sample_fileupload";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.ALL;
	}

	@Override
	public Success executeAPI(HttpServletRequest req, HttpServletResponse res,
			String trId) throws AbsException {
		Success success = new Success(true, "上传成功.");
		try {
			Map paramMap = getParameterMap(req);
			// 注意解码
			RequestUtil.decodeParams(paramMap);
			// request编码
			req.setCharacterEncoding("utf-8");
			MultipartRequest multiReq = (MultipartRequest) req;
			Iterator<String> files = multiReq.getFileNames();

			while (files.hasNext()) {
				String fileName = (String) files.next();
				MultipartFile multiFile = multiReq.getFile(fileName);
				if (multiFile != null && !multiFile.isEmpty()) {
					String file_path = req.getSession().getServletContext()
							.getRealPath("/files/test/");
					FileObj fileObj = FileUtil
							.getFileInfo(multiFile, file_path);
					if (!FileUtil.writeFile(multiFile, fileObj)) {
						success.setSuccess(false);
						success.setMsg("上传失败.");
						logger.error(fileName + "上传失败.");
					}
				}
			}
		} catch (Exception e) {
			logger.error("上传出错.");
			throw new ApiException(Prompt.SERVERERROR);
		}
		return success;
	}

	@Override
	public Class getMustParameter() throws AbsException {
		return MustParam.class;
	}

	@Override
	public Class getOptionParameter() throws AbsException {
		return null;
	}

	private enum MustParam {
		x, y
	}
}
