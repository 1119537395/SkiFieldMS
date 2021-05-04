package com.fish.system.service.impl;

import com.fish.system.domain.Menu;
import com.fish.system.service.MenuService;
import com.fish.system.utils.DataGridView;
import com.fish.system.utils.MessageConstant;
import com.fish.system.vo.MenuVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MenuServiceImpl
 * @Description 菜单(menu)业务层接口实现类
 * @Author 柚子茶
 * @Date 2020/11/28 22:49
 * @Version 1.0
 */
@Service
public class MenuServiceImpl extends BaseService implements MenuService {


	/**
	 * @param menuVo 菜单实体的实例化对象
	 * @return List<Menu>
	 * @description 查询所有的菜单数据
	 * @author 柚子茶
	 * @date 2020/12/1 10:08
	 **/
	@Override
	public List<Menu> queryMenuByAll(MenuVo menuVo) {
		return menuDao.queryMenuByAll(menuVo);
	}

	/**
	 * @param menuVo 菜单实例化对象
	 * @return DataGridView
	 * @description 加载菜单表格数据
	 * @author 柚子茶
	 * @date 2020/12/12 21:49
	 **/
	@Override
	public DataGridView loadMenuTableInfo(MenuVo menuVo) {
		// 开启分页
		Page<Object> page = PageHelper.startPage(menuVo.getPage(), menuVo.getLimit());
		List<Menu> menuList = this.menuDao.queryMenuByAll(menuVo);
		return new DataGridView(page.getTotal(), menuList);
	}

	/**
	 * @param id 菜单id
	 * @return int
	 * @description 查询是否存在子节点
	 * @author 柚子茶
	 * @date 2020/12/12 22:22
	 **/
	@Override
	public int checkMenuHasChildren(Integer id) {
		return this.menuDao.checkMenuHasChildren(id);
	}

	/**
	 * @param menuVo 菜单实例对象
	 * @return void
	 * @description 修改菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:22
	 **/
	@Override
	public void updateMenuData(MenuVo menuVo) {
		this.menuDao.updateMenuData(menuVo);
	}

	/**
	 * @param menuVo 菜单实例对象
	 * @return void
	 * @description 添加菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:22
	 **/
	@Override
	public void addMenuData(MenuVo menuVo) {
		this.menuDao.addMenuData(menuVo);
	}

	/**
	 * @param menuVo 菜单实例对象
	 * @return void
	 * @description 删除菜单
	 * @author 柚子茶
	 * @date 2020/12/12 22:22
	 **/
	@Override
	public void deleteMenuData(MenuVo menuVo) {
		this.menuDao.deleteMenuData(menuVo.getId());
	}

	/**
	 * @param menuVo 菜单实体类
	 * @param userId 用户ID
	 * @return List<Menu>
	 * @description 根据用户ID查询出菜单权限
	 * @author 柚子茶
	 * @date 2021/3/6 11:06
	 **/
	@Override
	public List<Menu> queryMenuByUserId(MenuVo menuVo, Integer userId) {
		// 设置查询出的菜单都是可用的
		menuVo.setAvailable(MessageConstant.AVAILABLE_TRUE);
		return this.menuDao.queryMenuByUserId(menuVo.getAvailable(),userId);
	}
}
