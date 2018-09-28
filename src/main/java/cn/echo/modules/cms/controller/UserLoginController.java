package cn.echo.modules.cms.controller;

import cn.echo.common.utils.ResuleMessage;
import cn.echo.modules.cms.service.IUserLoginService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/6/15.
 */
@Controller
public class UserLoginController {
	private static Logger log = LoggerFactory.getLogger(UserLoginController.class);
	@Resource(name = "userServiceImpl")
	private IUserLoginService userLoginService;

	@RequestMapping(value = "login.do")
	public ModelAndView login(HttpServletRequest request) {
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		ResuleMessage msg = new ResuleMessage();
		msg = userLoginService.UserLogin(name, password);
		log.debug(msg.getMessage());
		System.err.println("返回信息："+msg.getMessage());
		return new ModelAndView("login", "msg", msg);
	}
}
