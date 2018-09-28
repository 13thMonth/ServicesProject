package cn.echo.modules.cms.service;

import cn.echo.common.utils.ResuleMessage;
import cn.echo.modules.cms.model.UserModel;

public interface IUserLoginService {

	
	/**
	 * 校验登录是否成功
	 *
	 * @param data
	 * @return ResuleMessage
	 */
	ResuleMessage UserLogin(String name, String password);
	
	/**
	 * 创建用户
	 *
	 * @param userModel
	 * @return
	 */
	ResuleMessage createUser(UserModel userModel);

	/**
	 * 更新用户
	 *
	 * @param userModel
	 * @return
	 */
	ResuleMessage updateUser(UserModel userModel);

	/**
	 * 删除用户
	 *
	 * @param id
	 * @return
	 */
	ResuleMessage deleteUser(Integer id);

	/**
	 * 根据用户id查询用户
	 *
	 * @param id
	 * @return
	 */
	ResuleMessage getUserById(Integer id);

	/**
	 * 校验登录是否成功
	 *
	 * @param data
	 * @return ResuleMessage
	 */
	ResuleMessage selectAll();

}
