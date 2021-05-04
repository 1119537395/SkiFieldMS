package com.fish.business.dao;

import com.fish.business.domain.Order;
import com.fish.business.vo.OrderVo;

import java.util.List;


/**
 * @InterfaceName OrderDao
 * @Description 订单数据库访问层
 * @Author 柚子茶
 * @Date 2021/4/1 11:48
 * @Version 1.0
 */
public interface OrderDao {

	int deleteByPrimaryKey(String orderId);

	int insert(Order record);

	int insertSelective(Order record);

	Order selectByPrimaryKey(String orderId);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);


	/**
	 * @param orderVo
	 * @return List<Order>
	 * @description 查询订单信息
	 * @author 柚子茶
	 * @date 2021/4/5 12:30
	 **/
	List<Order> selectOrderInfoByList(OrderVo orderVo);
}