package com.fish.system.service.impl;

import com.fish.business.dao.FieldDao;
import com.fish.business.dao.OrderDao;
import com.fish.business.dao.TouristDao;
import com.fish.system.dao.MenuDao;
import com.fish.system.dao.RoleDao;
import com.fish.system.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName BaseService
 * @Description 业务层的基类，所有业务层接口的实现类都要继承此类
 * @Author 柚子茶
 * @Date 2020/11/25 18:54
 * @Version 1.0
 */
public class BaseService {

	@Autowired
	protected UserDao userDao;

	@Autowired
	protected MenuDao menuDao;

	@Autowired
	protected RoleDao roleDao;

	@Autowired
	protected TouristDao touristDao;

	@Autowired
	protected FieldDao fieldDao;

	@Autowired
	protected OrderDao orderDao;


}
