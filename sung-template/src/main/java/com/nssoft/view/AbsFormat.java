package com.nssoft.view;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.view.AbstractView;

import com.neighborsystem.durian.exception.AbsHttpException;
import com.neighborsystem.durian.restapi.api.CommonTag;
import com.neighborsystem.durian.restapi.model.NFData;

/**
 * JSON 타입의 테이타 표헌
 * 
 * @author rainmaker
 */
public abstract class AbsFormat<T> extends AbstractView implements IFormat<T> {
	final Log			logger	= LogFactory.getLog(AbsFormat.class);
	String		_m_charset	= null;
	
	/**
	 * 기본적인 인코딩 설정으로 XML 정의에서 자동으로 설정
	 * @param chr
	 */
	public void setCharset(String chr) {
		_m_charset = chr;
	}

	public String getCharset() {
		return _m_charset;
	}

	/**
	 * MVC 패턴에 의해 호출되는 기본 함수
	 */
	@Override
	protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest req,	HttpServletResponse res) throws Exception {
		T element = null;
		String sendText = null;
		NFData data = new NFData(map);
		res.setContentType(getContentType());
		//res.setCharacterEncoding("UTF-8");

		if (logger.isDebugEnabled()) {
			Object errCd = data.get(CommonTag.errCd.name());
			if(errCd == null)
				errCd = 0;
			logger.debug("ErrorCode[" + errCd + "]");
		}

		try {
			element = makeHeader(data);
			sendText = makeResult(data, element);
			//doFormat(data, sbFormat);

			if (logger.isDebugEnabled()) {
				logger.debug("----------------------------------[RESPONSE]----------------------------------");
				logger.debug(sendText);
				logger.debug("------------------------------------------------------------------------------");
			}
			
			if( sendText != null )
			{
				res.getOutputStream().write(sendText.getBytes());
			}
			
			res.getOutputStream().flush();
		}
		catch (AbsHttpException e) {
			logger.error(e);
			throw e;
		}
		catch (IOException e) {
			logger.error(e);
			throw e;
		}
		catch ( Exception e) {
			logger.error(e);
			throw e;
		}
		finally {
			data.clear();
			sendText = null;
			data = null;
		}
	}
}
