package com.fish.business.controller;

import com.fish.business.domain.Field;
import com.fish.business.domain.Order;
import com.fish.business.domain.Tourist;
import com.fish.business.vo.OrderVo;
import com.fish.business.vo.TouristVo;
import com.fish.system.controller.BaseController;
import com.fish.system.utils.CommonReturnType;
import com.fish.system.utils.DataGridView;
import org.omg.CORBA.ORB;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName OrderController
 * @Description
 * @Author 柚子茶
 * @Date 2021/4/4 13:05
 * @Version 1.0
 */
@RestController
@RequestMapping("order")
public class OrderController extends BaseController {


	/**
	 * @param orderVo
	 * @return boolean
	 * @description 校验购票数量是否正确
	 * @author 柚子茶
	 * @date 2021/4/5 20:08
	 **/
	@RequestMapping("checkTicketNumber")
	public boolean checkTicketNumber(OrderVo orderVo) {
		return this.orderService.checkTicketNumber(orderVo);
	}


	/**
	 * @param orderVo
	 * @return DataGridView
	 * @description 查询订单信息
	 * @author 柚子茶
	 * @date 2021/4/5 12:29
	 **/
	@RequestMapping("loadOrderInfo")
	public DataGridView loadOrderInfo(OrderVo orderVo) {
		return this.orderService.queryOrderInfo(orderVo);
	}

	/**
	 * @param orderVo
	 * @return DataGridView
	 * @description 查询个人消费记录
	 * @author 柚子茶
	 * @date 2021/4/5 22:12
	 **/
	@RequestMapping("loadExpensesRecord")
	public DataGridView loadExpensesRecord(OrderVo orderVo) {
		return this.orderService.queryExpensesRecord(orderVo);
	}


	/**
	 * @param orderVo
	 * @return CommonReturnType
	 * @description 更新订单信息
	 * @author 柚子茶
	 * @date 2021/4/5 13:54
	 **/
	@RequestMapping("updateOrderInfo")
	public CommonReturnType updateOrderInfo(OrderVo orderVo) {
		try {
			this.orderService.updateOrderInfo(orderVo);
			return CommonReturnType.MODIFY_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.MODIFY_FAILURE;
		}
	}

	/**
	 * @param orderVo
	 * @return CommonReturnType
	 * @description 订单结算
	 * @author 柚子茶
	 * @date 2021/4/5 12:51
	 **/
	@RequestMapping("finishOrderInfo")
	public CommonReturnType finishOrderInfo(OrderVo orderVo) {
		try {
			this.orderService.updateFinishOrderInfo(orderVo);
			return CommonReturnType.FINISH_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.FINISH_FAILURE;
		}
	}

	/**
	 * @param orderVo
	 * @return CommonReturnType
	 * @description 删除未结算的订单
	 * @author 柚子茶
	 * @date 2021/4/5 13:57
	 **/
	@RequestMapping("deleteOrderInfo")
	public CommonReturnType deleteOrderInfo(OrderVo orderVo) {
		try {
			this.orderService.deleteOrderInfo(orderVo);
			return CommonReturnType.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.DELETE_FAILURE;
		}
	}


	/**
	 * @param orderVo
	 * @return CommonReturnType
	 * @description 添加订单
	 * @author 柚子茶
	 * @date 2021/4/4 13:45
	 **/
	@RequestMapping("addOrderData")
	public CommonReturnType addOrderData(OrderVo orderVo) {
		try {
			this.orderService.addOrderData(orderVo);
			return CommonReturnType.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.ADD_FAILURE;
		}
	}

	/**
	 * @param orderVo
	 * @return CommonReturnType
	 * @description 添加游客订单
	 * @author 柚子茶
	 * @date 2021/4/8 18:56
	 **/
	@RequestMapping("addTouristOrderData")
	public CommonReturnType addTouristOrderData(OrderVo orderVo) {
		try {
			this.orderService.addTouristOrderData(orderVo);
			return CommonReturnType.BUY_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.BUY_FAILURE;
		}
	}


	/**
	 * @return Map<String, Object>
	 * @description 获取自动生成的订单编号和当前系统登录的用户
	 * @author 柚子茶
	 * @date 2021/4/3 11:53
	 **/
	@RequestMapping("loadOrderFormData")
	public Map<String, String> loadOrderFormData() {
		return this.orderService.queryOrderFormData();
	}

	/**
	 * @return Map<String, String>
	 * @description 获取自动生成的订单编号
	 * @author 柚子茶
	 * @date 2021/4/8 19:22
	 **/
	@RequestMapping("loadOrderFormDataByTourist")
	public Map<String, String> loadOrderFormDataByTourist() {
		return this.orderService.queryOrderFormDataByTourist();
	}


	/**
	 * @param touristVo
	 * @return boolean
	 * @description 校验游客手机号
	 * @author 柚子茶
	 * @date 2021/4/4 13:58
	 **/
	@RequestMapping("checkTouristPhone")
	public boolean checkTouristPhone(TouristVo touristVo) {
		Tourist tourist = this.touristService.queryTouristInfoByPhone(touristVo.getTouristPhone());
		if (null != tourist) {
			return false;
		} else {
			return true;
		}

	}

}
