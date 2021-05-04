package com.fish.system.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.fish.business.domain.Tourist;
import com.fish.system.domain.User;
import com.fish.system.utils.CommonReturnType;
import com.fish.system.utils.WebUtils;
import com.fish.system.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName LoginController
 * @Description 登录控制器
 * @Author 柚子茶
 * @Date 2020/11/26 18:19
 * @Version 1.0
 */
@Controller
@RequestMapping("login")
public class LoginController extends BaseController {

	/**
	 * @return String
	 * @Description 跳转到登录界面
	 * @author 柚子茶
	 * @date 2020/11/26 18:53
	 **/
	@RequestMapping("toLogin")
	public String toLogin() {
		return "system/main/login";
	}


	/**
	 * @param userVo 用户实例化对象
	 * @return String
	 * @description 登录验证
	 * @author 柚子茶
	 * @date 2020/11/27 0:01
	 **/
	@ResponseBody
	@RequestMapping("userLogin")
	public CommonReturnType userLogin(UserVo userVo) {

		// 获取到前台验证码
		String code = (String) WebUtils.getHttpSession().getAttribute("code");
		// 判断输入的验证码是否正确
		boolean flag = userVo.getCode().equalsIgnoreCase(code);
		if (flag) {
			if (userVo.getMark() == 0){
				// 工作人员登录
				User user = userService.userLogin(userVo);
				if (null != user) {
					// 记录登录的用户信息
					WebUtils.getHttpSession().setAttribute("user", user);
					// 记录登录的用户姓名
					WebUtils.getHttpSession().setAttribute("loginUserName", user.getUserName());
					// 记录登录的用户ID
					WebUtils.getHttpSession().setAttribute("loginUserId",user.getUserId());
					// 记录登录的用户类型
					WebUtils.getHttpSession().setAttribute("loginUserType",user.getUserType());
					return CommonReturnType.LOGIN_SUCCESS;
				} else {
					// 登录失败
					return CommonReturnType.LOGIN_FAILURE;
				}
			}else {
				Tourist tourist = new Tourist();
				tourist.setTouristLoginAccount(userVo.getUserAccount());
				tourist.setTouristLoginPassword(userVo.getUserPassword());
				// 普通游客登录
				Tourist tourist1 = touristService.touristLogin(tourist);
				if (null != tourist1){
					// 记录登录的游客信息
					WebUtils.getHttpSession().setAttribute("tourist", tourist1);
					// 记录登录的游客姓名
					WebUtils.getHttpSession().setAttribute("loginUserName", tourist1.getTouristName());
					// 记录登录的用户ID
					WebUtils.getHttpSession().setAttribute("loginUserId",tourist1.getTouristId());
					// 记录登录的用户类型
					WebUtils.getHttpSession().setAttribute("loginUserType",3);
					return CommonReturnType.LOGIN_SUCCESS;
				}else {
					// 登录失败
					return CommonReturnType.LOGIN_FAILURE;
				}
			}
		} else {
			// 验证码错误
			return CommonReturnType.LOGIN_CAPTCHA_ERROR;
		}
	}

	/**
	 * @param response 响应对象
	 * @param session  session
	 * @return void
	 * @description 获取验证码存入session中并将图片写回前台
	 * @author 柚子茶
	 * @date 2020/11/26 19:09
	 **/
	@RequestMapping("getCaptcha")
	public void getCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
		// 定义验证码的宽高
		CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(116, 36, 4, 10);
		// 将生成的验证码存入到Session中
		session.setAttribute("code", captcha.getCode());
		// 得到字节输出流对象
		ServletOutputStream sos = response.getOutputStream();
		// 输出写到前端界面
		ImageIO.write(captcha.getImage(), "JPEG", sos);
	}


}
