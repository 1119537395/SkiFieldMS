package com.fish.system.dao;

import com.fish.system.domain.Menu;
import com.fish.system.vo.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName MenuDao
 * @Description (menu)菜单数据库访问层
 * @Author 柚子茶
 * @Date 2020/11/28 21:55
 * @Version 1.0
 */
public interface MenuDao {


	/**
	 * @param menuVo 封装菜单实体的实例对象
	 * @return List<Menu>
	 * @description 查询所有的菜单数据
	 * @author 柚子茶
	 * @date 2020/12/1 10:09
	 **/
	List<Menu> queryMenuByAll(MenuVo menuVo);


	/**
	 * @param id 菜单id
	 * @return int
	 * @description 查询是否存在子节点
	 * @author 柚子茶
	 * @date 2020/12/12 22:25
	 **/
	int checkMenuHasChildren(Integer id);

	/**
	 * @param menuVo 菜单实例化对象
	 * @return void
	 * @description 修改菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:31
	 **/
	void updateMenuData(MenuVo menuVo);

	/**
	 * @param menuVo 菜单实例化对象
	 * @return void
	 * @description 添加菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:34
	 **/
	void addMenuData(MenuVo menuVo);

	/**
	 * @param id 菜单id
	 * @return void
	 * @description 删除菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:36
	 **/
	void deleteMenuData(Integer id);

	/**
	 * @param roleId 角色id
	 * @param available 是否可用
	 * @return List<Menu>
	 * @description 根据角色id查询出该角色拥有的菜单权限
	 * @author 柚子茶
	 * @date 2020/12/16 22:04
	 **/
	List<Menu> queryMenuByRoleId(@Param("roleId") Integer roleId, @Param("available") Integer available);

	/**
	 * @param available 是否可用
	 * @param userId    用户ID
	 * @return List<Menu>
	 * @description 根据用户ID查询菜单数据
	 * @author 柚子茶
	 * @date 2021/3/6 11:08
	 **/
	List<Menu> queryMenuByUserId(@Param("available") Integer available, @Param("userId") Integer userId);
}
