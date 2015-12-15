package com.nssoft.api.test.sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.model.FileObj;

/**
 * @api {post} /v1/api/test/sample/detail.json DownLoad.java
 * @apiVersion 1.0.0
 * @apiName  DownLoad.java
 * @apiGroup com.nssoft.api.test.sample
 * @apiParam {String} [a]      可选参数x.
 * @apiParam {Number} [b=18]   可选参数的默认值为'18'.
 * @apiParam {String} c        必填参数z.
 * @apiParam {String} d="D"    必填参数的默认值为'D'.
 * @apiSampleRequest /v1/api/test/sample/detail.json
 * @author xuliguo
 * @date 2015年8月18日 上午9:49:50
 */
@SuppressWarnings({ "rawtypes" })
@Controller("/v1/api/test/sample/download.download")
public class DownLoad extends AbsQuery<FileObj> {

	@Override
	public String getApiId() {
		return "sample_download";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.ALL;
	}

	@Override
	public FileObj executeAPI(HttpServletRequest req, HttpServletResponse res,
			String trId) throws AbsException {
		String file_id = "测试文件下载";
		String file_nm = "测试文件下载";
		String file_path = req.getSession().getServletContext()
				.getRealPath("/files");
		String file_extension = "txt";
		String file_content_type = "txt";
		return new FileObj(file_id, file_nm, file_path, file_extension,
				file_content_type);
	}

	@Override
	public Class getMustParameter() throws AbsException {
		return null;
	}

	@Override
	public Class getOptionParameter() throws AbsException {
		return null;
	}

}
