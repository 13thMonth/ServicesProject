package cn.echo.modules.cms.dao;

import java.util.List;

import cn.echo.modules.cms.model.UserModel;

/**
 * Created by Administrator on 2019/9/15. 用于标注数据访问组件,即DAO组件
 */
public interface IUserDao {

	
	/**
	 * 校验登录是否成功
	 *
	 * @param data
	 * @return ResuleMessage
	 */
	UserModel userLogin(UserModel userModel);
	
	/**
	 * 新增用户
	 *@author JX
	 * @param userModel
	 * @return Integer
	 */
	Integer insert(UserModel userModel);

	/**
	 * 删除用户记录
	 *
	 * @param id
	 * @return
	 */
	Integer delete(Integer id);

	/**
	 * 更新用户记录
	 *
	 * @param userModel
	 * @return
	 */
	Integer update(UserModel userModel);

	/**
	 * 根据用户id查找用户
	 *
	 * @param id
	 * @return
	 */
	UserModel selectById(Integer id);
	
	/**
	 * 根据用户id查找用户
	 *
	 * @param id
	 * @return
	 */
	List<UserModel> selectAll();

}
