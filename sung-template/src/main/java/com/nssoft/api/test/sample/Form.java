package com.nssoft.api.test.sample;

import org.apache.log4j.Logger;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.neighborsystem.durian.exception.AbsAPIException;
import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.exception.ApiException;
import com.nssoft.exception.ParamException;
import com.nssoft.exception.SqlException;
import com.nssoft.model.FileObj;
import com.nssoft.model.Success;
import com.nssoft.util.FileUtil;
import com.nssoft.util.Prompt;
import com.nssoft.util.RequestUtil;

/**
 * @api {post} /v1/api/test/sample/form.json Form.java
 * @apiVersion 1.0.0
 * @apiName  Form.java
 * @apiGroup com.nssoft.api.test.sample
 * @apiParam {String} name 姓名
 * @apiParam {String} email 邮箱	
 * @apiParam {String} tel 电话
 * @apiParam {String} address 地址
 * @apiParam {String} gender 性别
 * @apiParam {String} birthday 生日
 * @apiSampleRequest /v1/api/test/sample/form.json
 * @author xuliguo
 * @date 2015年8月18日 上午9:50:08
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Controller("/v1/api/test/sample/form.json")
public class Form extends AbsQuery<Success> {

	private static final Logger logger = Logger.getLogger(Form.class);

	@Override
	public String getApiId() {
		return "sample_form";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.POST;
	}

	@Override
	public Success executeAPI(HttpServletRequest req, HttpServletResponse res,
			String trId) throws AbsException {
		Map paramMap = getParameterMap(req);
		SqlSession session = null;
		Success success = new Success(true, Prompt.ADDSUCCESS);
		FileObj fileObj = null;
		try {
			// 如果参数中有需要后台处理的部分,可在此处理
			paramMap.put("id", UUID.randomUUID().toString());
			try {
				// 此处为带文件的form表单提交处理.若无法强制转换成MultipartRequest则为普通请求
				// request编码
				req.setCharacterEncoding("UTF-8");
				MultipartRequest multiReq = (MultipartRequest) req;
				// 注意解码
				RequestUtil.decodeParams(paramMap);
				MultipartFile multiFile = multiReq.getFile("file");
				if (multiFile != null && !multiFile.isEmpty()) {
					String file_path = req.getSession().getServletContext()
							.getRealPath("/files/test/");
					fileObj = FileUtil.getFileInfo(multiFile, file_path);
					if (!FileUtil.writeFile(multiFile, fileObj)) {
						success.setSuccess(false);
						success.setMsg("上传失败.");
					}
				}
				if (fileObj != null) {
					logger.info(fileObj);
					paramMap.put(
							"photo",
							fileObj.getFile_id() + "."
									+ fileObj.getFile_extension());
				}
			} catch (Exception e) {
				// 此处不做任何处理
			}
			session = getSqlSessionFactory().openSession();
			if (session.insert("testSample.form", paramMap) <= 0) {
				success.setSuccess(false);
				success.setMsg(Prompt.ADDFAIL);
			}
			session.commit();
		} catch (AbsAPIException e) {
			logger.error(e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e);
			throw new ParamException();
		} catch (PersistenceException e) {
			logger.error(e);
			throw new SqlException(e);
		} catch (Exception e) {
			logger.error(e);
			throw new ApiException();
		} finally {
			if (session != null)
				session.close();
		}
		return success;
	}

	@Override
	public Class getMustParameter() throws AbsException {
		return MustParam.class;
	}

	@Override
	public Class getOptionParameter() throws AbsException {
		return OptionParam.class;
	}

	private enum MustParam {
		name, 
		email, 
		tel, 
		address, 
		gender, 
		birthday
	}

	private enum OptionParam {
		exp
	}

}
