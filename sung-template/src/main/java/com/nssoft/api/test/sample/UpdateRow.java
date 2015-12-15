package com.nssoft.api.test.sample;

import org.apache.log4j.Logger;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;

import com.neighborsystem.durian.exception.AbsAPIException;
import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.exception.ApiException;
import com.nssoft.exception.ParamException;
import com.nssoft.exception.SqlException;
import com.nssoft.model.Success;
import com.nssoft.util.Prompt;

/**
 * @api {post} /v1/api/test/sample/updateRow.json UpdateRow.java
 * @apiVersion 1.0.0
 * @apiName  UpdateRow.java
 * @apiGroup com.nssoft.api.test.sample
 * @apiParam {String} [a]      可选参数x.
 * @apiParam {Number} [b=18]   可选参数的默认值为'18'.
 * @apiParam {String} c        必填参数z.
 * @apiParam {String} d="D"    必填参数的默认值为'D'.
 * @apiSampleRequest /v1/api/test/sample/updateRow.json
 * @author xuliguo
 * @date 2015年8月18日 上午9:50:18
 */
@SuppressWarnings({ "rawtypes" })
@Controller("/v1/api/test/sample/updateRow.json")
public class UpdateRow extends AbsQuery<Success> {

	private static final Logger logger = Logger.getLogger(UpdateRow.class);

	@Override
	public String getApiId() {
		return "sample_updaterow";
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
		Success success = new Success(Prompt.UPDATEFAIL);
		try {
			session = getSqlSessionFactory().openSession();
			if (session.update("testSample.updateRow", paramMap) > 0) {
				success.setSuccess(true);
				success.setMsg(Prompt.UPDATESUCCESS);
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
		id, 
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
