package com.nssoft.api.test.sample;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neighborsystem.durian.exception.AbsAPIException;
import com.neighborsystem.durian.exception.AbsException;
import com.nssoft.controller.EasyUIGridQuery;
import com.nssoft.exception.ApiException;
import com.nssoft.exception.ParamException;
import com.nssoft.exception.SqlException;
import com.nssoft.model.EasyUIGridObj;

/**
 * @api {post} /v1/api/test/sample/table.json Table.java
 * @apiVersion 1.0.0
 * @apiName  Table.java
 * @apiGroup com.nssoft.api.test.sample
 * @apiParam {String} [a]      可选参数x.
 * @apiParam {Number} [b=18]   可选参数的默认值为'18'.
 * @apiParam {String} c        必填参数z.
 * @apiParam {String} d="D"    必填参数的默认值为'D'.
 * @apiSampleRequest /v1/api/test/sample/table.json
 * @author xuliguo
 * @date 2015年8月18日 上午9:50:14
 */
@SuppressWarnings({ "rawtypes" })
@Controller("/v1/api/test/sample/table.json")
public class Table extends EasyUIGridQuery {

	private static final Logger logger = Logger.getLogger(Table.class);

	@Override
	public String getApiId() {
		return "sample_table_tables";
	}

	@Override
	public EasyUIGridObj executeAPI(HttpServletRequest req,
			HttpServletResponse res, String trId) throws AbsException {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return page(session, getParameterMap(req), "testSample.table");
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
		page, 
		rows
	}

	private enum OptionParam {
		sort, 
		order, 
		name, 
		tel, 
		gender
	}
}
