package com.fish.system.controller;

import com.fish.system.utils.CommonReturnType;
import com.fish.system.utils.DataGridView;
import com.fish.system.vo.UserVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description 管理员/用户控制器
 * @Author 柚子茶
 * @Date 2020/11/26 18:11
 * @Version 1.0
 */
@RequestMapping("/user")
@RestController
public class UserController extends BaseController {


	/**
	 * @return DataGridView
	 * @description 查询所有的用户信息
	 * @author 柚子茶
	 * @date 2021/1/10 13:37
	 **/
	@RequestMapping("/loadUserDataInfo")
	public DataGridView loadUserDataInfo(UserVo userVo) {
		return this.userService.queryUserInfo(userVo);
	}


	/**
	 * @param userVo 封装user数据的实例化对象
	 * @return CommonReturnType
	 * @description 添加用户信息
	 * @author 柚子茶
	 * @date 2021/1/11 21:57
	 **/
	@PostMapping("/addUserInfo")
	public CommonReturnType addUserInfo(UserVo userVo) {
		try {
			this.userService.addUserInfo(userVo);
			return CommonReturnType.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.ADD_FAILURE;
		}
	}

	/**
	 * @param userVo 封装user数据的实例化对象
	 * @return CommonReturnType
	 * @description 删除用户信息
	 * @author 柚子茶
	 * @date 2021/1/11 20:43
	 **/
	@PostMapping("/deleteUserInfo")
	public CommonReturnType deleteUserInfo(UserVo userVo) {
		try {
			this.userService.deleteUserInfo(userVo.getUserId());
			return CommonReturnType.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.DELETE_FAILURE;
		}
	}

	/**
	 * @param userVo 封装user数据的实例化对象
	 * @return CommonReturnType
	 * @description 修改用户信息
	 * @author 柚子茶
	 * @date 2021/1/11 20:52
	 **/
	@PostMapping("/updateUserInfo")
	public CommonReturnType updateUserInfo(UserVo userVo) {
		try {
			this.userService.updateUserInfo(userVo);
			return CommonReturnType.MODIFY_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.MODIFY_FAILURE;
		}
	}

	/**
	 * @param userVo 封装user数据的实例化对象
	 * @return CommonReturnType
	 * @description 保存分配的用户权限
	 * @author 柚子茶
	 * @date 2021/2/25 12:32
	 **/
	@RequestMapping("saveUserHasRole")
	public CommonReturnType saveUserHasRole(UserVo userVo) {
		try {
			this.userService.insertUserHasRole(userVo);
			return CommonReturnType.ASSIGN_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.ASSIGN_FAILURE;
		}

	}

	/**
	 * @return DataGridView
	 * @description 加载角色信息表格
	 * @author 柚子茶
	 * @date 2021/2/25 13:11
	 **/
	@RequestMapping("loadAssignRoleData")
	public DataGridView loadAssignRoleData(UserVo userVo) {
		return this.userService.queryAssignRoleData(userVo);
	}


}
