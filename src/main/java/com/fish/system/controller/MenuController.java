package com.fish.system.controller;

import com.fish.system.domain.Menu;
import com.fish.system.domain.User;
import com.fish.system.utils.*;
import com.fish.system.vo.MenuVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MenuController
 * @Description 菜单控制器
 * @Author 柚子茶
 * @Date 2020/11/28 22:56
 * @Version 1.0
 */
@RestController
@RequestMapping("menu")
public class MenuController extends BaseController {


	/**
	 * @param menuVo 菜单实例化对象
	 * @return CommonReturnType
	 * @description 修改菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:10
	 **/
	@PostMapping("/updateMenuData")
	public CommonReturnType updateMenuData(MenuVo menuVo) {
		try {
			this.menuService.updateMenuData(menuVo);
			return CommonReturnType.MODIFY_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.MODIFY_FAILURE;
		}
	}

	/**
	 * @param menuVo 菜单实例化对象
	 * @return CommonReturnType
	 * @description 添加菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:11
	 **/
	@PostMapping("/addMenuData")
	public CommonReturnType addMenuData(MenuVo menuVo) {
		try {
			this.menuService.addMenuData(menuVo);
			return CommonReturnType.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.ADD_FAILURE;
		}
	}

	/**
	 * @param menuVo 菜单实例化对象
	 * @return CommonReturnType
	 * @description 删除菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:08
	 **/
	@PostMapping("/deleteMenuData")
	public CommonReturnType deleteMenuData(MenuVo menuVo) {
		try {
			this.menuService.deleteMenuData(menuVo);
			return CommonReturnType.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.DELETE_FAILURE;
		}

	}


	/**
	 * @param menuVo 菜单实例化对象
	 * @return CommonReturnType
	 * @description 查询该节点是否存在子节点
	 * @author 柚子茶
	 * @date 2020/12/12 21:58
	 **/
	@PostMapping("/checkMenuHasChildren")
	public CommonReturnType checkMenuHasChildren(MenuVo menuVo) {
		int count = this.menuService.checkMenuHasChildren(menuVo.getId());
		if (count == 0) {
			return CommonReturnType.CODE_SUCCESS;
		} else {
			return CommonReturnType.CODE_FAILURE;
		}
	}


	/**
	 * @param menuVo 菜单实例化对象
	 * @return DataGridView
	 * @description 加载菜单表格数据
	 * @author 柚子茶
	 * @date 2020/12/12 21:45
	 **/
	@RequestMapping("/loadMenuTableInfo")
	public DataGridView loadMenuTableInfo(MenuVo menuVo) {
		return menuService.loadMenuTableInfo(menuVo);
	}

	/**
	 * @param menuVo 菜单实例化对象
	 * @return DataGridView
	 * @description 加载菜单管理界面的左侧菜单树
	 * @author 柚子茶
	 * @date 2020/12/12 12:35
	 **/
	@RequestMapping("/loadLeftMenuTreeJson")
	public DataGridView loadLeftMenuTreeJson(MenuVo menuVo) {
		// 设置查询到的菜单是可用的
		menuVo.setAvailable(MessageConstant.AVAILABLE_TRUE);
		// 查询到所有的菜单数据
		List<Menu> menuList = menuService.queryMenuByAll(menuVo);

		List<ThreeNode> threeNodeList = new ArrayList<>();
		for (Menu menus : menuList) {
			Integer id = menus.getId();
			Integer pid = menus.getPid();
			String title = menus.getTitle();
			String icon = menus.getIcon();
			String href = menus.getHref();
			String target = menus.getTarget();
			Boolean spread = menus.getSpread() == 1;
			threeNodeList.add(new ThreeNode(id, pid, title, icon, href, spread, target));
		}

		return new DataGridView(0, threeNodeList);
	}

	/**
	 * @param menuVo 菜单对象
	 * @return List<ThreeNode>
	 * @description 查询所有的菜单
	 * @author 柚子茶
	 * @date 2020/12/1 14:54
	 **/
	@RequestMapping("loadLeftNavigationMenuBar")
	public List<ThreeNode> loadLeftNavigationMenuBar(MenuVo menuVo) {
		// 获取登录的用户ID
		Integer loginUserId = (Integer) WebUtils.getHttpSession().getAttribute("loginUserId");
		// 设置查询到的菜单都是可用的
		menuVo.setAvailable(MessageEnum.AVAILABLE_TYPE_TRUE.getCode());
		// 创建List集合接收菜单数据
		// List<Menu> list = menuService.queryMenuByAll(menuVo);
		List<Menu> list = menuService.queryMenuByUserId(menuVo,loginUserId);
		List<ThreeNode> threeNodeList = new ArrayList<>();
		// 对查询出的菜单数据进行遍历
		for (Menu menu : list) {
			Integer id = menu.getId();
			Integer pid = menu.getPid();
			String title = menu.getTitle();
			String icon = menu.getIcon();
			String href = menu.getHref();
			String target = menu.getTarget();
			Boolean spread = menu.getSpread() == 1 ? true : false;
			threeNodeList.add(new ThreeNode(id, pid, title, icon, href, spread, target));
		}

		return ThreeNodeBuilder.builder(threeNodeList, 1);
	}


}
