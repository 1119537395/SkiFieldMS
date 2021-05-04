package com.fish.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName SystemController
 * @Description 系统管理的路由控制器
 * @Author 柚子茶
 * @Date 2020/12/1 13:21
 * @Version 1.0
 */
@Controller
@RequestMapping("system")
public class SystemController {


	/**
	 * @return String
	 * @description 跳转到角色管理界面
	 * @author 柚子茶
	 * @date 2020/12/15 17:37
	 **/
	@RequestMapping("toRoleManager")
	public String toRoleManager() {
		return "system/role/roleManager";
	}

	/**
	 * @return String
	 * @description 跳转到系统主界面
	 * @author 柚子茶
	 * @date 2020/12/15 19:41
	 **/
	@RequestMapping("toMainManager")
	public String toMainManager() {
		return "system/main/index";
	}

	/**
	 * @return String
	 * @description 跳转到用户管理界面
	 * @author 柚子茶
	 * @date 2021/1/10 13:03
	 **/
	@RequestMapping("toUserManager")
	public String toUserManager() {
		return "system/user/userManager";
	}


	/**
	 * @return String
	 * @description 跳转到菜单主界面
	 * @author 柚子茶
	 * @date 2020/12/12 12:13
	 **/
	@RequestMapping("toMenuManager")
	public String toMenuManager() {
		return "system/menu/menuManager";
	}

	/**
	 * @return String
	 * @description 跳转到菜单左界面
	 * @author 柚子茶
	 * @date 2020/12/12 12:13
	 **/
	@RequestMapping("toMenuLeftManager")
	public String toMenuLeftManager() {
		return "system/menu/menuLeftManager";
	}

	/**
	 * @return String
	 * @description 跳转到菜单右界面
	 * @author 柚子茶
	 * @date 2020/12/12 12:13
	 **/
	@RequestMapping("toMenuRightManager")
	public String toMenuRightManager() {
		return "system/menu/menuRightManager";
	}

	/**
	 * @return String
	 * @description 跳转到后台首页
	 * @author 柚子茶
	 * @date 2020/12/1 14:06
	 **/
	@RequestMapping("toDesktopManager")
	public String toDesktopManager() {
		return "system/main/DesktopManager";
	}

	/**
	 * @return String
	 * @description 跳转到游客注册界面
	 * @author 柚子茶
	 * @date 2021/4/3 13:42
	 **/
	@RequestMapping("toTouristRegister")
	public String toTouristRegister() {
		return "system/main/register";
	}


}
