package cn.echo.common.utils;

import java.io.Serializable;

/**
 * 
 * @author JX 前后台信息交互对象
 *
 */
public class ResuleMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4748480670003224254L;
	// 返回结果
	private boolean success;
	// 返回信息
	private String message;
	// 返回数据
	private Object data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
