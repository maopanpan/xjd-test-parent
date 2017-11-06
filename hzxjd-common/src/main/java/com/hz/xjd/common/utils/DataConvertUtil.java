package com.hz.xjd.common.utils;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hz.xjd.common.exception.BusinessException;


/**
 * 一些公共基本类型转换处理
 */
public class DataConvertUtil {

	private final static Logger logger = LoggerFactory.getLogger(DataConvertUtil.class);

	/**
	 * 转换字符串类型为Integer类型,不抛出异常.
	 * @param s
	 * @return
	 */
	public static Integer convertString2Integer(String s) {

		Integer i = null;

		try {
			i = Integer.valueOf(s);
		}
		catch (Exception e) {
			logger.warn("返回数据转换类型格式不正确, 转换数据:" + s);
		}

		return i;
	}

	/**
	 * 转换字符串类型为Integer类型,不抛出异常.
	 * 赋初始Integer值
	 * @param s
	 * @param initInteger
	 * @return
	 */
	public static Integer convertString2Integer(String s, Integer initInteger) {

		Integer i = null;

		try {
			i = Integer.valueOf(s);
		}
		catch (Exception e) {
			logger.warn("返回数据转换类型格式不正确, 转换数据:" + s);
			i = initInteger;
		}

		return i;
	}

	/**
	 * 转换字符串类型为Integer类型,不抛出异常.
	 * 赋初始Integer值
	 * @param s
	 * @param initInteger
	 * @return
	 */
	public static Double convertString2Double(String s, Double initDouble) {

		Double d = null;

		try {
			d = Double.valueOf(s);
		}
		catch (Exception e) {
			logger.warn("返回数据转换类型格式不正确, 转换数据:" + s);
			d = initDouble;
		}

		return d;
	}

	/**
	 * 转换字符串类型为Double类型,不抛出异常.
	 * @param s
	 * @return
	 */
	public static Double convertString2Double(String s) {

		Double d = null;

		try {
			d = Double.valueOf(s);
		}
		catch (Exception e) {
			logger.warn("返回数据转换类型格式不正确, 转换数据:" + s);
		}

		return d;
	}

	/**
	 * 转换大数据类型为Double类型,不抛出异常.
	 * @param bigDecimalValue
	 * @return
	 */
	public static Double convertBigDecimal2Double(BigDecimal bigDecimalValue) {

		Double d = null;

		try {
			d = Double.valueOf(bigDecimalValue.toString());
		}
		catch (Exception e) {
			logger.warn("返回数据转换类型格式不正确, 转换数据:" + bigDecimalValue);
		}

		return d;
	}

	/**
	 * 转换BigDecimal类型为Double类型,不抛出异常.
	 * 赋初始Double值
	 * @param bigDecimalValue
	 * @param initDouble
	 * @return
	 */
	public static Double convertBigDecimal2Double(BigDecimal bigDecimalValue, Double initDouble) {

		Double d = null;

		try {
			d = Double.valueOf(bigDecimalValue.toString());
		}
		catch (Exception e) {
			logger.warn("返回数据转换类型格式不正确, 转换数据:" + bigDecimalValue);
			d = initDouble;
		}

		return d;
	}

	/**
	 * 转换字符串类型为Double类型,抛出异常提示信息.
	 * @param s
	 * @param msg
	 * @return
	 * @throws BusinessException
	 */
	public static Double convertString2Double(String s, String msg) throws BusinessException {

		Double d = null;

		try {
			d = Double.valueOf(s);
		}
		catch (Exception e) {
			logger.warn("返回数据转换类型格式不正确, 转换数据:" + s);
			throw new BusinessException(msg);
		}

		return d;
	}

	/**
	 * 转换字符串类型为Long类型,不抛出异常.
	 * @param s
	 * @return
	 */
	public static Long convertString2Long(String s) {

		Long l = null;

		try {
			l = Long.valueOf(s);
		}
		catch (Exception e) {
			logger.warn("返回数据转换类型格式不正确, 转换数据:" + l);
		}

		return l;
	}

	/**
	 * 转换字符串类型为Long类型,抛出异常提示信息.
	 * @param s
	 * @param msg
	 * @return
	 * @throws BusinessException
	 */
	public static Long convertString2Long(String s, String msg) throws BusinessException {

		Long l = null;

		try {
			l = Long.valueOf(s);
		}
		catch (Exception e) {
			logger.warn("返回数据转换类型格式不正确, 转换数据:" + s);
			throw new BusinessException(msg);
		}

		return l;
	}
}
