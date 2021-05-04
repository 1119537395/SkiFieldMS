package com.fish.system.dao;

import com.fish.system.domain.Role;
import com.fish.system.vo.RoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName RoleDao
 * @Description 角色(role)数据访问层
 * @Author 柚子茶
 * @Date 2020/12/15 17:52
 * @Version 1.0
 */
public interface RoleDao {


	/**
	 * @param roleVo 角色实体实例化对象
	 * @return List<Role>
	 * @description 查询角色信息
	 * @author 柚子茶
	 * @date 2020/12/16 20:57
	 **/
	List<Role> queryRoleInfo(RoleVo roleVo);


	/**
	 * @param roleVo
	 * @return void
	 * @description 添加角色
	 * @author 柚子茶
	 * @date 2020/12/16 21:14
	 **/
	void addRoleData(RoleVo roleVo);

	void deleteRoleInfo(Integer roleId);

	void deleteRoleAndUserByRid(Integer roleId);

	void deleteRoleAndMenuByRid(Integer roleId);

	void updateRoleData(RoleVo roleVo);

	void insertAssignMenuToRole(@Param("roleId") Integer roleId,@Param("mid") Integer mid);

	/**
	 * @param roleId
	 * @return Role
	 * @description 通过ID查询角色信息
	 * @author 柚子茶
	 * @date 2021/2/25 13:49
	 **/
	Role queryRoleByRoleId(Integer roleId);

	/**
	 * @param userId
	 * @return List<Role>
	 * @description 通过用户ID查询该用户拥有的角色权限
	 * @author 柚子茶
	 * @date 2021/2/25 13:21
	 **/
	List<Role> queryUserHasRoleByUserId(@Param("userId") Integer userId);
}
