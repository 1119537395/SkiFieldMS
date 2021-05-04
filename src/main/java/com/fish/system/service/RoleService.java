package com.fish.system.service;

import com.fish.system.utils.DataGridView;
import com.fish.system.vo.RoleVo;

/**
 * @InterfaceName RoleService
 * @Description 角色(role)业务层接口
 * @Author 柚子茶
 * @Date 2020/12/15 17:50
 * @Version 1.0
 */
public interface RoleService {


	/**
	 * @param roleVo 角色实体对象
	 * @return DataGridView
	 * @description 查询角色信息
	 * @author 柚子茶
	 * @date 2020/12/16 21:00
	 **/
	DataGridView queryRoleInfo(RoleVo roleVo);

	/**
	 * @param roleVo
	 * @return void
	 * @description 添加角色
	 * @author 柚子茶
	 * @date 2020/12/16 21:13
	 **/
	void addRoleData(RoleVo roleVo);

	/**
	 * @param roleId
	 * @return void
	 * @description 删除角色
	 * @author 柚子茶
	 * @date 2020/12/16 21:25
	 **/
	void deleteRoleData(Integer roleId);

	/**
	 * @param roleVo
	 * @return void
	 * @description 修改角色
	 * @author 柚子茶
	 * @date 2020/12/16 21:35
	 **/
	void updateRoleData(RoleVo roleVo);

	/**
	 * @param roleId
	 * @return DataGridView
	 * @description 加载角色所拥有的菜单权限
	 * @author 柚子茶
	 * @date 2020/12/16 21:45
	 **/
	DataGridView initMenuAssignTree(Integer roleId);

	/**
	 * @param roleVo
	 * @return void
	 * @description 给角色分配菜单权限
	 * @author 柚子茶
	 * @date 2020/12/16 22:24
	 **/
	void insertAssignMenuToRole(RoleVo roleVo);
}
