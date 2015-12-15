package com.nssoft.util;

import org.apache.log4j.Logger;
import com.nssoft.exception.ParamException;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


/**   
 *
 * @ClassName BeanMapConvertUtil
 * @Description JavaBean转Map、Map转JavaBean工具类.慎用
 * Copyright (c) 2014 by NS Soft. 
 * @author xuliguo   
 * @date 2015年1月29日 上午10:54:05    
 * @version V1.0      
 *    
 */
@SuppressWarnings({"rawtypes"})
public class BeanMapConvertUtil {
	
	private static final Logger logger = Logger.getLogger(BeanMapConvertUtil.class);

	/**
     * 将一个 Map 对象转化为一个 JavaBean
     * @param clazz 要转化的类型
     * @param map 包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InstantiationException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static <T> T toBean(Class<T> clazz, Map map) {
        T obj = null;
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            obj = clazz.newInstance(); // 创建 JavaBean 对象
 
            // 给 JavaBean 对象的属性赋值
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (map.containsKey(propertyName)) {
                    // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                    Object value = map.get(propertyName);
                    if ("".equals(value)) {
                        value = null;
                    }
                    Object[] args = new Object[1];
                    args[0] = value;
                    try {
                        descriptor.getWriteMethod().invoke(obj, args);
                    } catch (InvocationTargetException e) {
                    		logger.error("字段映射失败");
                    }
                }
            }
        } catch (IllegalAccessException e) {
        		logger.error("实例化 JavaBean 失败");
        } catch (IntrospectionException e) {
        		logger.error("分析类属性失败");
        } catch (IllegalArgumentException e) {
        		logger.error("映射错误");
        } catch (InstantiationException e) {
        		logger.error("实例化 JavaBean 失败");
        }
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
        int errorCnt = 0;
        String errorMsg = "";
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
        		errorCnt++;
        		errorMsg += constraintViolation.getMessage();
		}
        //logger.info("errorCnt:" + errorCnt);
        if (errorCnt != 0) {
        		throw new ParamException(errorMsg);
        }
        return obj;
    }
 
    /**
     * 将一个 JavaBean 对象转化为一个 Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的 Map 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Map toMap(Object bean) {
        Class<? extends Object> clazz = bean.getClass();
        Map<Object, Object> returnMap = new HashMap<Object, Object>();
        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = null;
                    result = readMethod.invoke(bean, new Object[0]);
                    if (null != propertyName) {
                        propertyName = propertyName.toString();
                    }
                    if (null != result) {
                        result = result.toString();
                    }
                    returnMap.put(propertyName, result);
                }
            }
        } catch (IntrospectionException e) {
        		logger.error("分析类属性失败");
        } catch (IllegalAccessException e) {
        		logger.error("实例化 JavaBean 失败");
        } catch (IllegalArgumentException e) {
        		logger.error("映射错误");
        } catch (InvocationTargetException e) {
        		logger.error("调用属性的 setter 方法失败");
        }
        return returnMap;
    }
 
}
