package com.nssoft.api.common;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nssoft.util.VerifyCodeUtil;

/**   
 *
 * @ClassName VerifyCode
 * @Description
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年7月24日 上午9:44:20    
 * @version V1.0      
 *    
 */
@Controller
public class VerifyCode {
	@RequestMapping("/v1/api/common/verify-code")
	public void writeVerifyCode(HttpServletRequest request,
			HttpServletResponse response) {
		response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);  
        request.getSession().setAttribute("verifyCode", verifyCode);  
        response.setContentType("image/jpeg");  
        BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);  
        try {
			ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			
		} 
	}
}
