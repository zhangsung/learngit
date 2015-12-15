package com.nssoft.api.test.sample;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neighborsystem.durian.exception.AbsAPIException;
import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.exception.ApiException;
import com.nssoft.exception.ParamException;
import com.nssoft.exception.SqlException;
import com.nssoft.model.Success;
import com.nssoft.util.Prompt;
import com.nssoft.util.SerialUtil;

/**
 * @api {post} /v1/api/test/sample/deleteRow.json DeleteRow.java
 * @apiVersion 1.0.0
 * @apiName  DeleteRow.java
 * @apiGroup com.nssoft.api.test.sample
 * @apiParam {String} [a]      可选参数x.
 * @apiParam {Number} [b=18]   可选参数的默认值为'18'.
 * @apiParam {String} c        必填参数z.
 * @apiParam {String} d="D"    必填参数的默认值为'D'.
 * @apiSampleRequest /v1/api/test/sample/deleteRow.json
 * @author xuliguo
 * @date 2015年8月18日 上午9:49:35
 */
@SuppressWarnings({ "rawtypes" })
@Controller("/v1/api/test/sample/deleteRow.json")
public class DeleteRow extends AbsQuery<Success> {

	private static final Logger logger = Logger.getLogger(DeleteRow.class);

	@Override
	public String getApiId() {
		return "sample_deleterow";
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.POST;
	}

	@Override
	public Success executeAPI(HttpServletRequest req, HttpServletResponse res,
			String trId) throws AbsException {
		String id_list = req.getParameter(MustParam.ids.name());
		Success success = new Success(Prompt.DELETEFAIL);
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			if (session.delete("testSample.deleteRow",
					SerialUtil.JsonToList(new JSONArray(id_list))) > 0) {
				success.setSuccess(true);
				success.setMsg(Prompt.DELETESUCCESS);
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
		return null;
	}

	private enum MustParam {
		ids
	}
}
