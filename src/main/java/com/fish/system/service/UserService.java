package com.fish.system.service;

import com.fish.system.domain.User;
import com.fish.system.utils.DataGridView;
import com.fish.system.vo.UserVo;

/**
 * @InterfaceName UserService
 * @Description 用户(user)业务层接口类
 * @Author 柚子茶
 * @Date 2020/11/26 18:01
 * @Version 1.0
 */
public interface UserService {

	/**
	 * @param userVo 封装user数据的实例化对象
	 * @return User对象
	 * @Description 登录验证
	 * @author 柚子茶
	 * @date 2020/11/26 18:02
	 **/
	User userLogin(UserVo userVo);


	/**
	 * @param userVo 封装user数据的实例化对象
	 * @return DataGridView
	 * @description 查询用户信息
	 * @author 柚子茶
	 * @date 2021/1/10 13:41
	 **/
	DataGridView queryUserInfo(UserVo userVo);


	/**
	 * @param userId 用户ID
	 * @return void
	 * @description 删除用户信息
	 * @author 柚子茶
	 * @date 2021/1/11 20:45
	 **/
	void deleteUserInfo(Integer userId);

	/**
	 * @param userVo 封装user数据的实例化对象
	 * @return void
	 * @description 修改用户信息
	 * @author 柚子茶
	 * @date 2021/1/11 20:53
	 **/
	void updateUserInfo(UserVo userVo);

	/**
	 * @param userVo 封装user数据的实例化对象
	 * @return void
	 * @description 添加管理员
	 * @author 柚子茶
	 * @date 2021/1/11 22:00
	 **/
	void addUserInfo(UserVo userVo);


	/**
	 * @param userVo 封装user数据的实例化对象
	 * @return void 保存给用户分类的权限
	 * @description
	 * @author 柚子茶
	 * @date 2021/2/25 12:27
	 **/
	void insertUserHasRole(UserVo userVo);

	/**
	 * @param userVo
	 * @return DataGridView
	 * @description 加载角色信息
	 * @author 柚子茶
	 * @date 2021/2/25 13:12
	 **/
	DataGridView queryAssignRoleData(UserVo userVo);
}
