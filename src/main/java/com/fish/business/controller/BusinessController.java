package com.fish.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName BusinessController
 * @Description 业务管理的路由控制器
 * @Author 柚子茶
 * @Date 2021/4/1 12:01
 * @Version 1.0
 */
@Controller
@RequestMapping("business")
public class BusinessController {


	/**
	 * @return String
	 * @description 跳转到游客管理界面
	 * @author 柚子茶
	 * @date 2021/4/1 12:03
	 **/
	@RequestMapping("toTouristManager")
	public String toTouristManager() {
		return "business/tourist/TouristManager";
	}

	/**
	 * @return String
	 * @description 跳转到场地管理界面
	 * @author 柚子茶
	 * @date 2021/4/1 17:18
	 **/
	@RequestMapping("toFieldManager")
	public String toFieldManager() {
		return "business/field/FieldManager";
	}

	/**
	 * @return String
	 * @description 跳转到购票界面
	 * @author 柚子茶
	 * @date 2021/4/4 14:05
	 **/
	@RequestMapping("toTicketsManager")
	public String toTicketsManager() {
		return "business/tickets/TicketsManager";
	}

	/**
	 * @return String
	 * @description 跳转到游客查看场次安排界面
	 * @author 柚子茶
	 * @date 2021/4/5 10:35
	 **/
	@RequestMapping("toViewManager")
	public String toViewManager() {
		return "business/tourist/ViewManager";
	}

	/**
	 * @return String
	 * @description 跳转到订单管理界面
	 * @author 柚子茶
	 * @date 2021/4/5 14:33
	 **/
	@RequestMapping("toOrderManager")
	public String toOrderManager() {
		return "business/order/OrderManager";
	}

	/**
	 * @return String
	 * @description 跳转到消费记录页面
	 * @author 柚子茶
	 * @date 2021/4/5 22:21
	 **/
	@RequestMapping("toConsumeManager")
	public String toConsumeManager() {
		return "business/tourist/ConsumeManager";
	}

	/**
	 * @return String
	 * @description 跳转到游客购票界面
	 * @author 柚子茶
	 * @date 2021/4/8 17:30
	 **/
	@RequestMapping("toBuyTicketsManager")
	public String toBuyTicketsManager() {
		return "business/tourist/BuyTicketsManager";
	}

}
