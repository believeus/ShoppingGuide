package com.etech.controller;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.etech.entity.Tshopuser;
import com.etech.service.EtechService;
import com.etech.webutil.Brower;

/**Begin Author:wuqiwei Data:2014-05-26 Email:1058633117@qq.com AddReason:用户登录业务逻辑 */
@Controller
public class ControllerLogin {
	private static final Log log = LogFactory.getLog(ControllerLogin.class);
	@Resource
	private EtechService userService;
	
	/**Begin Author:yangQiXian Data:2014-07-02 AddReason:用户登陆,进行ajax登录验证 */
	@RequestMapping(value = "/ajaxLoginValid")
	public void ajaxLoginValid(Tshopuser formUser, HttpServletResponse response,HttpSession session) throws Exception {
		Assert.assertNotNull(formUser);
		log.debug("current user name:"+formUser.getUserName());
		log.debug("current user passowrd:"+formUser.getPassword());
		Tshopuser sessionUser = (Tshopuser) userService.findObject(Tshopuser.class, "userName", formUser.getUserName());
		Map<String, Object> message=new HashMap<String, Object>();
			if(!StringUtils.isEmpty(sessionUser)){
				String oldPassword = DigestUtils.md5Hex(formUser.getPassword());
				if(sessionUser.getUserName().equals(formUser.getUserName())){
					String password =DigestUtils.md5Hex(formUser.getPassword());
					log.debug(password);
					if(oldPassword.equals(password)){
						String url="/menu.jhtml";
						/**Begin Author:wuqiwei Data:2014-07-02 AddReason:用户登陆成功,跳转到编辑商铺页面 */
						Brower.redirect(url, response);
						log.debug("form password match user.password,login success");
						//return;
						/**End Author:wuqiwei Data:2014-07-02 AddReason:用户登陆,跳转到编辑商铺页面 */
					}
				}else {
					message.put("message","error");
					Brower.outJson(message, response);
					return;
				}
			}else{
				message.put("message","error");
				Brower.outJson(message, response);
				return;
			}
		
	}
	/**End Author:yangQiXian Data:2014-07-02 AddReason:用户登陆,进行ajax登录验证 */
	
	@RequestMapping(value="/login")
	public String loginView(){
		return "/WEB-INF/login.jsp";
	}
}
/**End Author:wuqiwei Data:2014-05-26 Email:1058633117@qq.com AddReason:用户登录业务逻辑 */