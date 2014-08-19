package com.etech.webutil;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.variable.Variables;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/*

 * 2014.07.01 

 * */
@Component
public class CookieUtil {
	// 保存cookie时的cookieName
	private final static String cookieDomainName = "aileguang";
	// 加密cookie时的网站自定码
	private final static String webKey = "123456!@#";
	// 设置cookie有效期是两天
	private final static int cookieMaxAge = 1000 * 60 * 60 * 24 * 2;
	@Resource
	private EtechService etechService;

	// 保存Cookie到客户端-------------------------------------------------------------------------
	// 在CheckLogonServlet.java中被调用
	// 传递进来的user对象中封装了在登陆时填写的用户名与密码
	@SuppressWarnings("restriction")
	public void saveCookie(String username, String password,HttpServletResponse response) {
		// cookie的有效期
		long validTime = System.currentTimeMillis() + (cookieMaxAge);
		// MD5加密用户详细信息
		String cookieValueWithMd5 = DigestUtils.md5Hex(username + ":"+ password + ":" + validTime + ":" + webKey);
		// 将要被保存的完整的Cookie值
		String cookieValue = username + ":" + validTime + ":"+ cookieValueWithMd5;
		// 再一次对Cookie的值进行BASE64编码
		String cookieValueBase64 = new String(Base64.encode(cookieValue.getBytes()));
		// 开始保存Cookie
		Cookie cookie = new Cookie(cookieDomainName, cookieValueBase64);
		// 存两年(这个值应该大于或等于validTime)
		cookie.setMaxAge(cookieMaxAge);
		// cookie有效路径是网站根目录
		cookie.setPath("/");
		// 向客户端写入
		response.addCookie(cookie);

	}

	// 读取Cookie,自动完成登陆操作----------------------------------------------------------------
	public boolean autoLogin(HttpServletRequest request,HttpServletResponse response) {
		// 根据cookieName取cookieValue
		Cookie cookies[] = request.getCookies();
		String cookieValue = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookieDomainName.equals(cookies[i].getName())) {
					cookieValue = cookies[i].getValue();
					break;
				}
			}
		}
		// 如果cookieValue为空,返回,
		if (cookieValue == null) {
			return false;
		}
		// 如果cookieValue不为空,才执行下面的代码
		// 先得到的CookieValue进行Base64解码
		String cookieValueAfterDecode="";
		try {
			cookieValueAfterDecode = new String(Base64.decode(cookieValue),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 对解码后的值进行分拆,得到一个数组,如果数组长度不为3,就是非法登陆
		String cookieValues[] = cookieValueAfterDecode.split(":");
		if (cookieValues.length != 3) {
			return false;
		}
		// 判断是否在有效期内,过期就删除Cookie
		long validTimeInCookie = new Long(cookieValues[1]);
		if (validTimeInCookie < System.currentTimeMillis()) {
			// 删除Cookie
			clearCookie(response);
			return false;
		}
		// 取出cookie中的用户名,并到数据库中检查这个用户名,
		String username = cookieValues[0];
		Tshopuser sessionUser = (Tshopuser) etechService.findObject(Tshopuser.class, Variables.phoneNumber, username);
		// 根据用户名到数据库中检查用户是否存在

		// 如果user返回不为空,就取出密码,使用用户名+密码+有效时间+ webSiteKey进行MD5加密
		if (sessionUser != null) {
			String md5ValueInCookie = cookieValues[2];
			String md5ValueFromUser = DigestUtils.md5Hex(sessionUser.getPhoneNumber()+ ":" + sessionUser.getPassword() + ":" + validTimeInCookie+ ":" + webKey);
			// 将结果与Cookie中的MD5码相比较,如果相同,写入Session,自动登陆成功,并继续用户请求
			if (md5ValueFromUser.equals(md5ValueInCookie)) {
				HttpSession session = request.getSession();
				session.setAttribute(Variables.sessionUser,sessionUser);
				return true;
			}
		} else {
			return false;
		}
		return false;

	}

	// 用户注销时,清除Cookie,在需要时可随时调用-----------------------------------------------------
	public static void clearCookie(HttpServletResponse response) {
		Cookie cookie = new Cookie(cookieDomainName, null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}