package com.fish.business.service.impl;

import com.fish.business.domain.Field;
import com.fish.business.domain.Order;
import com.fish.business.service.OrderService;
import com.fish.business.vo.OrderVo;
import com.fish.system.domain.User;
import com.fish.system.service.impl.BaseService;
import com.fish.system.utils.DataGridView;
import com.fish.system.utils.MessageConstant;
import com.fish.system.utils.RandomUtils;
import com.fish.system.utils.WebUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName OrderServiceImpl
 * @Description 订单业务层接口实现类
 * @Author 柚子茶
 * @Date 2021/4/4 13:02
 * @Version 1.0
 */
@Service
public class OrderServiceImpl extends BaseService implements OrderService {


	/**
	 * @return Map<String, String>
	 * @description 获取自动生成的订单编号和当前登录的用户
	 * @author 柚子茶
	 * @date 2021/4/4 13:38
	 **/
	@Override
	public Map<String, String> queryOrderFormData() {
		// 自动生成订单编号
		String flowerOrderNumber = RandomUtils.createRandomNumberByTime(MessageConstant.ORDER_HEAD);
		// 获取当前登录的用户
		User user = (User) WebUtils.getHttpSession().getAttribute("user");

		// 创建Map集合
		// 将获取到数据封装到map集合中
		Map<String, String> map = new HashMap<>(16);
		map.put("orderNumber", flowerOrderNumber);
		map.put("userName", user.getUserName());

		return map;
	}

	/**
	 * @param orderVo
	 * @return void
	 * @description 添加订单信息
	 * @author 柚子茶
	 * @date 2021/4/4 13:47
	 **/
	@Override
	public void addOrderData(OrderVo orderVo) {
		// 根据手机号查询到游客ID
		Integer touristId = this.touristDao.queryTouristInfoByPhone(orderVo.getTouristPhone()).getTouristId();
		// 获取当前登录的用户ID
		Integer loginId = (Integer) WebUtils.getHttpSession().getAttribute("loginUserId");

		// 更新票数
		Field field = this.fieldDao.selectByPrimaryKey(orderVo.getFieldId());
		field.setFieldCapacity(Math.max(field.getFieldCapacity() - orderVo.getBuyTicketNumber(), 0));
		this.fieldDao.updateByPrimaryKeySelective(field);

		orderVo.setCreateUserId(loginId);
		orderVo.setTouristId(touristId);
		orderVo.setCreateTime(new Date());
		orderVo.setOrderState(1);

		this.orderDao.insertSelective(orderVo);
	}


	/**
	 * @param orderVo
	 * @return void
	 * @description 添加游客订单
	 * @author 柚子茶
	 * @date 2021/4/8 19:01
	 **/
	@Override
	public void addTouristOrderData(OrderVo orderVo) {
		// 获取到登录的游客ID
		Integer touristId = this.touristDao.queryTouristInfoByPhone(orderVo.getTouristPhone()).getTouristId();
		// 更新票数
		Field field = this.fieldDao.selectByPrimaryKey(orderVo.getFieldId());
		field.setFieldCapacity(Math.max(field.getFieldCapacity() - orderVo.getBuyTicketNumber(), 0));
		this.fieldDao.updateByPrimaryKeySelective(field);

		orderVo.setTouristId(touristId);
		orderVo.setCreateTime(new Date());
		orderVo.setOrderState(1);
		this.orderDao.insertSelective(orderVo);
	}

	/**
	 * @return Map<String, String>
	 * @description
	 * @author 柚子茶
	 * @date 2021/4/8 19:23
	 **/
	@Override
	public Map<String, String> queryOrderFormDataByTourist() {
		// 自动生成订单编号
		String flowerOrderNumber = RandomUtils.createRandomNumberByTime(MessageConstant.ORDER_HEAD);

		// 创建Map集合
		// 将获取到数据封装到map集合中
		Map<String, String> map = new HashMap<>(16);
		map.put("orderNumber", flowerOrderNumber);

		return map;
	}

	/**
	 * @param orderVo
	 * @return DataGridView
	 * @description 查询订单信息
	 * @author 柚子茶
	 * @date 2021/4/5 12:30
	 **/
	@Override
	public DataGridView queryOrderInfo(OrderVo orderVo) {
		// 开启分页
		Page<Object> page = PageHelper.startPage(orderVo.getPage(), orderVo.getLimit());
		List<Order> orderList = this.orderDao.selectOrderInfoByList(orderVo);
		return new DataGridView(page.getTotal(), orderList);
	}

	/**
	 * @param orderVo
	 * @return void
	 * @description 订单结算
	 * @author 柚子茶
	 * @date 2021/4/5 12:52
	 **/
	@Override
	public void updateFinishOrderInfo(OrderVo orderVo) {
		// 根据订单ID获取订单信息
		Order order = this.orderDao.selectByPrimaryKey(orderVo.getOrderId());
		// 根据ID查询场次信息
		Field field = this.fieldDao.selectByPrimaryKey(order.getFieldId());
		field.setFieldCapacity(field.getFieldCapacity() + order.getBuyTicketNumber());
		// 更新票数信息
		this.fieldDao.updateByPrimaryKeySelective(field);
		// 结算时带上结算人信息
		if (order.getCreateUserId() == null) {
			Integer userId = (Integer) WebUtils.getHttpSession().getAttribute("loginUserId");
			orderVo.setCreateUserId(userId);
		}
		// 更新订单的状态为已经结算
		orderVo.setOrderState(0);
		this.orderDao.updateByPrimaryKeySelective(orderVo);
	}

	/**
	 * @param orderVo
	 * @return void
	 * @description 删除订单信息
	 * @author 柚子茶
	 * @date 2021/4/5 14:10
	 **/
	@Override
	public void deleteOrderInfo(OrderVo orderVo) {
		// 根据订单ID获取场次信息
		Order order = this.orderDao.selectByPrimaryKey(orderVo.getOrderId());
		// 根据ID查询场次信息
		Field field = this.fieldDao.selectByPrimaryKey(order.getFieldId());
		field.setFieldCapacity(field.getFieldCapacity() + order.getBuyTicketNumber());
		// 更新票数信息
		this.fieldDao.updateByPrimaryKeySelective(field);

		// 删除订单
		this.orderDao.deleteByPrimaryKey(orderVo.getOrderId());

	}

	/**
	 * @param orderVo
	 * @return boolean
	 * @description 校验购票数量是否正确
	 * @author 柚子茶
	 * @date 2021/4/5 20:17
	 **/
	@Override
	public boolean checkTicketNumber(OrderVo orderVo) {

		// 根据订单编号查询订单信息
		Order order = this.orderDao.selectByPrimaryKey(orderVo.getOrderId());
		// 根据场次编号查询场次信息
		Field field = this.fieldDao.selectByPrimaryKey(order.getFieldId());

		return field.getFieldCapacity() < (orderVo.getNewBuyTicketNumber() - orderVo.getOldBuyTicketNumber());
	}

	/**
	 * @param orderVo
	 * @return DataGridView
	 * @description 查询个人消费记录
	 * @author 柚子茶
	 * @date 2021/4/5 22:13
	 **/
	@Override
	public DataGridView queryExpensesRecord(OrderVo orderVo) {
		// 开启分页
		Page<Object> page = PageHelper.startPage(orderVo.getPage(), orderVo.getLimit());
		// 获取当前的登录的用户ID
		Integer loginUserId = (Integer) WebUtils.getHttpSession().getAttribute("loginUserId");
		orderVo.setTouristId(loginUserId);
		List<Order> orderList = this.orderDao.selectOrderInfoByList(orderVo);
		return new DataGridView(page.getTotal(), orderList);
	}

	/**
	 * @param orderVo
	 * @return void
	 * @description 更新订单信息
	 * @author 柚子茶
	 * @date 2021/4/5 13:55
	 **/
	@Override
	public void updateOrderInfo(OrderVo orderVo) {
		// 根据订单ID查询出订单信息
		Order order = this.orderDao.selectByPrimaryKey(orderVo.getOrderId());
		// 查询出对应该订单的滑雪场次信息
		Field field = this.fieldDao.selectByPrimaryKey(order.getFieldId());
		// 增加票量的购买
		if (orderVo.getBuyTicketNumber() > order.getBuyTicketNumber()) {
			int increment = orderVo.getBuyTicketNumber() - order.getBuyTicketNumber();
			field.setFieldCapacity(field.getFieldCapacity() - increment);
			this.fieldDao.updateByPrimaryKeySelective(field);
		}
		// 减少票量的购买
		if (orderVo.getBuyTicketNumber() < order.getBuyTicketNumber()) {
			int decrease = order.getBuyTicketNumber() - orderVo.getBuyTicketNumber();
			field.setFieldCapacity(field.getFieldCapacity() + decrease);
			this.fieldDao.updateByPrimaryKeySelective(field);
		}

		this.orderDao.updateByPrimaryKeySelective(orderVo);
	}


}
