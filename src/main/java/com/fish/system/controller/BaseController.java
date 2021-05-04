package com.fish.system.controller;

import com.fish.business.service.FieldService;
import com.fish.business.service.OrderService;
import com.fish.business.service.TouristService;
import com.fish.system.service.MenuService;
import com.fish.system.service.RoleService;
import com.fish.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName BaseController
 * @Description 控制器的基类，所有的控制器类都要继承该类
 * @Author 柚子茶
 * @Date 2020/11/26 10:22
 * @Version 1.0
 */
public class BaseController {

	@Autowired
	protected UserService userService;

	@Autowired
	protected MenuService menuService;

	@Autowired
	protected RoleService roleService;

	@Autowired
	protected TouristService touristService;

	@Autowired
	protected FieldService fieldService;

	@Autowired
	protected OrderService orderService;

}
