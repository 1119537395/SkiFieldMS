package com.fish.system.service;

import com.fish.system.domain.Menu;
import com.fish.system.utils.DataGridView;
import com.fish.system.vo.MenuVo;

import java.util.List;

/**
 * @InterfaceName MenuService
 * @Description 菜单(menu)业务层接口
 * @Author 柚子茶
 * @Date 2020/11/28 22:47
 * @Version 1.0
 */
public interface MenuService {


	/**
	 * @param menuVo 菜单实例对象
	 * @return List<Menu>
	 * @description 查询所有的菜单数据
	 * @author 柚子茶
	 * @date 2020/12/1 10:06
	 **/
	List<Menu> queryMenuByAll(MenuVo menuVo);


	/**
	 * @param menuVo 菜单实例对象
	 * @return DataGridView
	 * @description 加载菜单表格数据
	 * @author 柚子茶
	 * @date 2020/12/12 21:48
	 **/
	DataGridView loadMenuTableInfo(MenuVo menuVo);

	/**
	 * @param id 菜单id
	 * @return int
	 * @description 查询是否存在子节点
	 * @author 柚子茶
	 * @date 2020/12/12 22:21
	 **/
	int checkMenuHasChildren(Integer id);

	/**
	 * @param menuVo 菜单实例对象
	 * @return void
	 * @description 修改菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:21
	 **/
	void updateMenuData(MenuVo menuVo);

	/**
	 * @param menuVo 菜单实例对象
	 * @return void
	 * @description 添加菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:21
	 **/
	void addMenuData(MenuVo menuVo);

	/**
	 * @param menuVo 菜单实例对象
	 * @return void
	 * @description 删除菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:21
	 **/
	void deleteMenuData(MenuVo menuVo);

	/**
	 * @param menuVo 菜单实体类
	 * @param userId 用户ID
	 * @return List<Menu>
	 * @description 根据用户ID查询菜单数据
	 * @author 柚子茶
	 * @date 2021/3/6 11:05
	 **/
	List<Menu> queryMenuByUserId(MenuVo menuVo, Integer userId);
}
