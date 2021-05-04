package com.fish.business.service;

import com.fish.business.domain.Order;
import com.fish.business.vo.OrderVo;
import com.fish.system.utils.DataGridView;

import java.util.Map;

/**
 * @InterfaceName OrderService
 * @Description 订单业务层接口
 * @Author 柚子茶
 * @Date 2021/4/4 13:01
 * @Version 1.0
 */
public interface OrderService {


	/**
	 * @return Map<String, String>
	 * @description 获取自动生成的订单编号和当前登录的用户
	 * @author 柚子茶
	 * @date 2021/4/4 13:38
	 **/
	Map<String, String> queryOrderFormData();

	/**
	 * @param orderVo
	 * @return void
	 * @description 添加订单信息
	 * @author 柚子茶
	 * @date 2021/4/4 13:46
	 **/
	void addOrderData(OrderVo orderVo);

	/**
	 * @param orderVo
	 * @return DataGridView
	 * @description 查询订单信息
	 * @author 柚子茶
	 * @date 2021/4/5 12:29
	 **/
	DataGridView queryOrderInfo(OrderVo orderVo);

	/**
	 * @param orderVo
	 * @return void
	 * @description 订单结算
	 * @author 柚子茶
	 * @date 2021/4/5 12:52
	 **/
	void updateFinishOrderInfo(OrderVo orderVo);

	/**
	 * @param orderVo
	 * @return void
	 * @description 删除未结算的订单
	 * @author 柚子茶
	 * @date 2021/4/5 14:02
	 **/
	void deleteOrderInfo(OrderVo orderVo);


	/**
	 * @param orderVo
	 * @return boolean
	 * @description 校验购票数量是否正确
	 * @author 柚子茶
	 * @date 2021/4/5 20:15
	 **/
	boolean checkTicketNumber(OrderVo orderVo);

	/**
	 * @param orderVo
	 * @return DataGridView
	 * @description 查询个人消费记录
	 * @author 柚子茶
	 * @date 2021/4/5 22:13
	 **/
	DataGridView queryExpensesRecord(OrderVo orderVo);

	/**
	 * @param orderVo
	 * @return void
	 * @description 更新订单信息
	 * @author 柚子茶
	 * @date 2021/4/5 13:55
	 **/
	void updateOrderInfo(OrderVo orderVo);

	/**
	 * @param orderVo
	 * @return void
	 * @description 添加游客订单
	 * @author 柚子茶
	 * @date 2021/4/8 19:00
	 **/
	void addTouristOrderData(OrderVo orderVo);

	/**
	 * @return Map<String, String>
	 * @description 获取订单编号
	 * @author 柚子茶
	 * @date 2021/4/8 19:22
	 **/
	Map<String, String> queryOrderFormDataByTourist();
}
