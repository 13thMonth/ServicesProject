package cn.echo.modules.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.echo.common.utils.ResuleMessage;
import cn.echo.modules.cms.controller.UserLoginController;
import cn.echo.modules.cms.model.UserModel;
import cn.echo.modules.cms.service.IUserLoginService;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@Scope("prototype")
// @Controller
@RequestMapping("/userLogin/")
public class ApiLoginController {
	private static Logger log = LoggerFactory.getLogger(UserLoginController.class);
	@Resource(name = "userServiceImpl")
	private IUserLoginService userLoginService;

	/**
	 * 
	 * @param userModel
	 * @return
	 * @author JX
	 * 描述：用户登录
	 */
	@RequestMapping(value = "login",method = RequestMethod.GET)
	@ResponseBody
	public ResuleMessage login(@RequestParam String name,@RequestParam String password,HttpServletRequest request) {
		ResuleMessage msg = new ResuleMessage();
	    //把用户信息保存到session
		HttpSession session = request.getSession(); 
        session.setAttribute("sessionName", name);
		msg = userLoginService.UserLogin(name, password);
		log.debug(msg.getMessage());
		return msg;
	}
	/**
	 * 
	 * @param userModel
	 * @return
	 * @author JX
	 * 描述：注册用户
	 */
	@RequestMapping(value = "createUser",method = RequestMethod.GET)
	@ResponseBody
	public ResuleMessage createUser(@RequestParam UserModel userModel) {
		ResuleMessage msg = new ResuleMessage();
		msg = userLoginService.createUser(userModel);
		log.debug(msg.getMessage());
		return msg;
	}
	
	/**
	 * 
	 * @param userModel
	 * @return
	 * @author JX
	 * 描述：修改用户
	 */
	@RequestMapping(value = "updateUser",method = RequestMethod.GET)
	@ResponseBody
	public ResuleMessage updateUser(@RequestParam UserModel userModel) {
		ResuleMessage msg = new ResuleMessage();
		msg = userLoginService.updateUser(userModel);
		log.debug(msg.getMessage());
		return msg;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @author JX
	 * 描述：删除用户
	 */
	@RequestMapping(value = "deleteUser",method = RequestMethod.GET)
	@ResponseBody
	public ResuleMessage deleteUser(@RequestParam Integer id) {
		ResuleMessage msg = new ResuleMessage();
		msg = userLoginService.deleteUser(id);
		log.debug(msg.getMessage());
		return msg;
	}
	
	/**
	 * 
	 * @param userModel
	 * @return
	 * @author JX
	 * 描述：删除用户
	 */
	@RequestMapping(value = "getUserById",method = RequestMethod.GET)
	@ResponseBody
	public ResuleMessage getUserById(@RequestParam Integer id) {
		ResuleMessage msg = new ResuleMessage();
		msg = userLoginService.getUserById(id);
		log.debug(msg.getMessage());
		return msg;
	}
	
	/**
	 * 
	 * @param userModel
	 * @return
	 * @author JX
	 * 描述：注册用户
	 */
	@RequestMapping(value = "selectAll",method = RequestMethod.GET)
	@ResponseBody
	public ResuleMessage selectAll() {
		ResuleMessage msg = new ResuleMessage();
		msg = userLoginService.selectAll();
		log.debug(msg.getMessage());
		return msg;
	}
	
	
}
