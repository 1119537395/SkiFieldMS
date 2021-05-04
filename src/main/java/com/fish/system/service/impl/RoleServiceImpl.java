package com.fish.system.service.impl;

import com.fish.system.domain.Menu;
import com.fish.system.domain.Role;
import com.fish.system.service.RoleService;
import com.fish.system.utils.DataGridView;
import com.fish.system.utils.MessageConstant;
import com.fish.system.utils.ThreeNode;
import com.fish.system.vo.MenuVo;
import com.fish.system.vo.RoleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description 角色(role)业务层接口实现类
 * @Author 柚子茶
 * @Date 2020/12/15 17:51
 * @Version 1.0
 */
@Service
public class RoleServiceImpl extends BaseService implements RoleService {


	/**
	 * @param roleVo 角色实体实例化对象
	 * @return DataGridView
	 * @description 查询角色信息
	 * @author 柚子茶
	 * @date 2020/12/16 21:02
	 **/
	@Override
	public DataGridView queryRoleInfo(RoleVo roleVo) {
		// 开启分页
		Page<Object> page = PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
		List<Role> roleList = roleDao.queryRoleInfo(roleVo);
		return new DataGridView(page.getTotal(), roleList);
	}

	/**
	 * @param roleVo
	 * @return void
	 * @description 添加角色
	 * @author 柚子茶
	 * @date 2020/12/16 21:13
	 **/
	@Override
	public void addRoleData(RoleVo roleVo) {
		roleDao.addRoleData(roleVo);
	}

	/**
	 * @param roleId
	 * @return void
	 * @description 删除角色
	 * @author 柚子茶
	 * @date 2020/12/16 21:26
	 **/
	@Override
	public void deleteRoleData(Integer roleId) {
		// 删除角色信息
		roleDao.deleteRoleInfo(roleId);
		// 删除角色表和用户表关联的信息
		roleDao.deleteRoleAndUserByRid(roleId);
		// 删除角色表和菜单表关联的信息
		roleDao.deleteRoleAndMenuByRid(roleId);
	}

	/**
	 * @param roleVo
	 * @return void
	 * @description 修改角色
	 * @author 柚子茶
	 * @date 2020/12/16 21:36
	 **/
	@Override
	public void updateRoleData(RoleVo roleVo) {
		roleDao.updateRoleData(roleVo);
	}

	/**
	 * @param roleId
	 * @return DataGridView
	 * @description 加载角色所拥有的菜单权限
	 * @author 柚子茶
	 * @date 2020/12/16 21:45
	 **/
	@Override
	public DataGridView initMenuAssignTree(Integer roleId) {
		// 查询所有可用的菜单
		MenuVo menu = new MenuVo();
		menu.setAvailable(MessageConstant.AVAILABLE_TRUE);
		List<Menu> allMenuList = menuDao.queryMenuByAll(menu);

		// 根据角色id查询出该角色拥有的菜单权限
		List<Menu> roleMenuList = menuDao.queryMenuByRoleId(roleId, MessageConstant.AVAILABLE_TRUE);
		List<ThreeNode> assignMenuTreeData = new ArrayList<>();
		// 循环遍历
		// 查询出角色所拥有的菜单权限
		// 并且让角色拥有的菜单展开
		for (Menu allMenu : allMenuList) {
			String checkArr = MessageConstant.CODE_NUMBER_STRING_ZERO;
			Boolean spread = allMenu.getSpread() == 1;
			for (Menu roleMenu : roleMenuList) {
				if (allMenu.getId().equals(roleMenu.getId())) {
					checkArr = MessageConstant.CODE_NUMBER_STRING_ONE;
					spread = true;
				}
			}
			Integer id = allMenu.getId();
			Integer pid = allMenu.getPid();
			String title = allMenu.getTitle();
			assignMenuTreeData.add(new ThreeNode(id,pid,title, spread, checkArr));
		}
		return new DataGridView(assignMenuTreeData);
	}

	/**
	 * @param roleVo
	 * @return void
	 * @description 给角色分配菜单权限
	 * @author 柚子茶
	 * @date 2020/12/16 22:24
	 **/
	@Override
	public void insertAssignMenuToRole(RoleVo roleVo) {
		Integer roleId = roleVo.getRoleId();
		Integer[] ids = roleVo.getIds();
		// 在分配菜单权限之前先将之前分配好的清空
		roleDao.deleteRoleAndMenuByRid(roleId);
		// 进行菜单权限的分配
		for (Integer mid : ids) {
			roleDao.insertAssignMenuToRole(roleId,mid);
		}
	}
}
