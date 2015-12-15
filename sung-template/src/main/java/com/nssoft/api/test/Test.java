package com.nssoft.api.test;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Controller;

import com.neighborsystem.durian.exception.AbsAPIException;
import com.neighborsystem.durian.exception.AbsException;
import com.neighborsystem.durian.restapi.api.HttpMethod;
import com.nssoft.controller.AbsQuery;
import com.nssoft.exception.ApiException;
import com.nssoft.exception.ParamException;
import com.nssoft.exception.SqlException;
import com.nssoft.generator.model.ChajaDtMemberinfo;

@Controller("/v1/api/test.json")
public class Test extends AbsQuery<String> {
	
	private static final Logger logger = Logger.getLogger(Test.class);

	@Override
	public String executeAPI(HttpServletRequest req,
			HttpServletResponse res, String arg2) throws AbsException {
		try {
//			int i = session.insert("testSample.test");
//			session.commit();
//			return  i + "";
			//String test1 = DurianMessage.getMessage("test.test1", new Object[] {"呵呵1", "呵呵2"});
			ChajaDtMemberinfo memberinfo = new ChajaDtMemberinfo();
			MapToBean(memberinfo, getParameterMap(req));
			//ChajaDtMemberinfo member = MapToBean(ChajaDtMemberinfo.class, getParameterMap(req));
			return memberinfo.toString();
		} catch (AbsAPIException e) {
			logger.error(e);
			throw e;
		} catch (IllegalArgumentException e) {
			logger.error(e);
			throw new ParamException();
		} catch (PersistenceException e) {
			logger.error(e);
			throw new SqlException(e);
		}  catch (Exception e) {
			logger.error(e);
			throw new ApiException();
		}
		
	}

	@Override
	public String getApiId() {
		return null;
	}

	@Override
	public Class getMustParameter() throws AbsException {
		return null;
	}

	@Override
	public Class getOptionParameter() throws AbsException {
		return null;
	}

	@Override
	public HttpMethod getHttpMethod() {
		return HttpMethod.ALL;
	}
	
	private enum OptionParam {
	}
	

}
