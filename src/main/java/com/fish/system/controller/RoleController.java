package com.fish.system.controller;

import com.fish.system.utils.CommonReturnType;
import com.fish.system.utils.DataGridView;
import com.fish.system.vo.RoleVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RoleController
 * @Description 角色管理控制器
 * @Author 柚子茶
 * @Date 2020/12/15 17:47
 * @Version 1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {


	/**
	 * @param roleVo 角色实体类实例化对象
	 * @return DataGridView
	 * @description 查询所有的角色信息
	 * @author 柚子茶
	 * @date 2020/12/15 17:49
	 **/
	@RequestMapping("/loadRoleInfo")
	public DataGridView loadRoleInfo(RoleVo roleVo) {
		return roleService.queryRoleInfo(roleVo);
	}

	/**
	 * @param roleVo
	 * @return CommonReturnType
	 * @description 添加角色
	 * @author 柚子茶
	 * @date 2020/12/16 21:11
	 **/
	@RequestMapping("/addRoleData")
	public CommonReturnType addRoleData(RoleVo roleVo) {
		try {
			roleService.addRoleData(roleVo);
			return CommonReturnType.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.ADD_FAILURE;
		}
	}

	/**
	 * @param roleVo
	 * @return CommonReturnType
	 * @description 删除角色
	 * @author 柚子茶
	 * @date 2020/12/16 21:23
	 **/
	@RequestMapping("/deleteRoleData")
	public CommonReturnType deleteRoleData(RoleVo roleVo) {
		try {
			roleService.deleteRoleData(roleVo.getRoleId());
			return CommonReturnType.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.DELETE_FAILURE;
		}
	}


	/**
	 * @param roleVo
	 * @return CommonReturnType
	 * @description 修改角色数据
	 * @author 柚子茶
	 * @date 2020/12/16 21:34
	 **/
	@RequestMapping("/updateRoleData")
	public CommonReturnType updateRoleData(RoleVo roleVo) {
		try {
			roleService.updateRoleData(roleVo);
			return CommonReturnType.MODIFY_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.MODIFY_FAILURE;
		}
	}

	/**
	 * @param roleVo
	 * @return DataGridView
	 * @description 加载角色所拥有的菜单权限
	 * @author 柚子茶
	 * @date 2020/12/16 21:43
	 **/
	@RequestMapping("/initMenuAssignTree")
	public DataGridView initMenuAssignTree(RoleVo roleVo) {
		return roleService.initMenuAssignTree(roleVo.getRoleId());
	}


	/**
	 * @param roleVo
	 * @return CommonReturnType
	 * @description 给角色分配菜单权限
	 * @author 柚子茶
	 * @date 2020/12/16 22:22
	 **/
	@RequestMapping("/assignMenuToRole")
	public CommonReturnType assignMenuToRole(RoleVo roleVo) {
		try {
			roleService.insertAssignMenuToRole(roleVo);
			return CommonReturnType.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.ADD_FAILURE;
		}
	}

}
