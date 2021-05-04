package com.fish.system.dao;

import com.fish.system.domain.User;
import com.fish.system.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName UserDao
 * @Description (User)数据库访问层
 * @Author 柚子茶
 * @Date 2020/11/26 17:09
 * @Version 1.0
 */
public interface UserDao {

	/**
	 * @param userVo 实例化对象
	 * @return User类对象
	 * @Description 用户登录验证
	 * @author 柚子茶
	 * @date 2020/11/26 17:13
	 **/
	User userLogin(UserVo userVo);


	/**
	 * @param userVo 实例化对象
	 * @return List<User>
	 * @description
	 * @author 柚子茶
	 * @date 2021/1/10 13:47
	 **/
	List<User> queryUserInfo(UserVo userVo);

	/**
	 * @param userId 用户ID
	 * @return void
	 * @description 删除用户信息
	 * @author 柚子茶
	 * @date 2021/1/11 20:46
	 **/
	void deleteUserInfo(Integer userId);

	/**
	 * @param userVo 封装user数据的实例化对象
	 * @return void
	 * @description 修改用户信息
	 * @author 柚子茶
	 * @date 2021/1/11 20:55
	 **/
	void updateUserInfo(UserVo userVo);

	/**
	 * @param userVo 封装user数据的实例化对象
	 * @return void
	 * @description 添加管理员
	 * @author 柚子茶
	 * @date 2021/1/11 22:09
	 **/
	void addUserInfo(UserVo userVo);

	/**
	 * @param userId
	 * @return void
	 * @description 根据用户的ID删除用户与角色中间表的数据
	 * @author 柚子茶
	 * @date 2021/2/25 12:39
	 **/
	void deleteUserAndRoleByUserId(@Param("userId") Integer userId);

	/**
	 * @param userId 用户ID
	 * @param roleId 角色ID
	 * @return void
	 * @description 保存分配的用户权限
	 * @author 柚子茶
	 * @date 2021/2/25 12:39
	 **/
	void insertUserHasRole(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
}
