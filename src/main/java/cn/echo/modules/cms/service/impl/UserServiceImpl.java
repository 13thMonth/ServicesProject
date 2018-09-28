package cn.echo.modules.cms.service.impl;

import cn.echo.common.utils.ResuleMessage;
import cn.echo.modules.cms.dao.IUserDao;
import cn.echo.modules.cms.model.UserModel;
import cn.echo.modules.cms.service.IUserLoginService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/15.
 */
@Service
public class UserServiceImpl implements IUserLoginService {
	@Resource
	private IUserDao userDao;
	
	@Override
	public ResuleMessage UserLogin(String name, String password) {
		ResuleMessage msg = new ResuleMessage();
		UserModel model = new UserModel();
		model.setUserName(name);
		model.setUserPassword(password);
		UserModel resultModel = userDao.userLogin(model);
		if(resultModel != null) {
			msg.setSuccess(true);
			msg.setMessage("登陆成功");
		}else {
			msg.setSuccess(false);
			msg.setMessage("用户名或密码错误");
		}
		return msg;
	}
	
	@Override
	public ResuleMessage createUser(UserModel userModel) {
		ResuleMessage msg = new ResuleMessage();
		Integer i = userDao.insert(userModel);
		if(i != null) {
			msg.setSuccess(true);
			msg.setMessage("注册成功，请登录");
		}else {
			msg.setSuccess(false);
			msg.setMessage("注册失败");
		}
		return msg;
	}

	@Override
	public ResuleMessage updateUser(UserModel userModel) {
		ResuleMessage msg = new ResuleMessage();
		Integer i = userDao.update(userModel);
		if(i != null) {
			msg.setSuccess(true);
			msg.setMessage("修改成功");
		}else {
			msg.setSuccess(false);
			msg.setMessage("修改失败");
		}
		return msg;
	}

	@Override
	public ResuleMessage deleteUser(Integer id) {
		ResuleMessage msg = new ResuleMessage();
		Integer i = userDao.delete(id);
		if(i != null) {
			msg.setSuccess(true);
			msg.setMessage("删除成功");
		}else {
			msg.setSuccess(false);
			msg.setMessage("删除失败");
		}
		return msg;
	}

	@Override
	public ResuleMessage getUserById(Integer id) {
		ResuleMessage msg = new ResuleMessage();
		UserModel userModel = userDao.selectById(id);
		if(userModel != null) {
			msg.setSuccess(true);
			msg.setMessage("操作成功");
		}else {
			msg.setSuccess(false);
			msg.setMessage("操作失败");
		}
		return msg;
	}

	@Override
	public ResuleMessage selectAll() {
		ResuleMessage msg = new ResuleMessage();
		List<UserModel> userModels = userDao.selectAll();
		if(userModels != null||userModels.size()>0) {
			msg.setSuccess(true);
			msg.setData(userModels);
			msg.setMessage("操作成功");
		}else {
			msg.setSuccess(false);
			msg.setMessage("操作失败");
		}
		return msg;
	}

}
