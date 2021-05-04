package com.fish.business.controller;

import com.fish.business.vo.TouristVo;
import com.fish.system.controller.BaseController;
import com.fish.system.utils.CommonReturnType;
import com.fish.system.utils.DataGridView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TouristController
 * @Description 游客控制器
 * @Author 柚子茶
 * @Date 2021/4/1 11:58
 * @Version 1.0
 */
@RestController
@RequestMapping("tourist")
public class TouristController extends BaseController {

	/**
	 * @param touristVo
	 * @return DataGridView
	 * @description 查询游客信息
	 * @author 柚子茶
	 * @date 2021/4/1 13:54
	 **/
	@RequestMapping("loadTouristInfo")
	public DataGridView loadTouristInfo(TouristVo touristVo) {
		return this.touristService.queryTouristInfo(touristVo);
	}


	/**
	 * @param touristVo
	 * @return CommonReturnType
	 * @description 添加游客信息
	 * @author 柚子茶
	 * @date 2021/4/1 13:56
	 **/
	@RequestMapping("addTouristInfo")
	public CommonReturnType addTouristInfo(TouristVo touristVo) {
		try {
			this.touristService.addTouristInfo(touristVo);
			return CommonReturnType.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.ADD_FAILURE;
		}
	}

	/**
	 * @param touristVo
	 * @return CommonReturnType
	 * @description 删除游客信息
	 * @author 柚子茶
	 * @date 2021/4/1 13:58
	 **/
	@RequestMapping("deleteTouristInfo")
	public CommonReturnType deleteTouristInfo(TouristVo touristVo) {
		try {
			this.touristService.deleteTouristInfo(touristVo);
			return CommonReturnType.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.DELETE_FAILURE;
		}
	}

	/**
	 * @param touristVo
	 * @return CommonReturnType
	 * @description 修改游客信息
	 * @author 柚子茶
	 * @date 2021/4/1 13:58
	 **/
	@RequestMapping("updateTouristInfo")
	public CommonReturnType updateTouristInfo(TouristVo touristVo) {
		try {
			this.touristService.updateTouristInfo(touristVo);
			return CommonReturnType.MODIFY_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.MODIFY_FAILURE;
		}
	}

	/**
	 * @param touristVo
	 * @return CommonReturnType
	 * @description 游客注册
	 * @author 柚子茶
	 * @date 2021/4/3 14:25
	 **/
	@RequestMapping("touristRegister")
	public CommonReturnType touristRegister(TouristVo touristVo) {
		try {
			this.touristService.addTouristRegister(touristVo);
			return CommonReturnType.REGISTER_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.REGISTER_FAILURE;
		}
	}

	/**
	 * @param touristVo
	 * @return boolean
	 * @description 游客注册/添加手机号校验
	 * @author 柚子茶
	 * @date 2021/4/5 22:54
	 **/
	@RequestMapping("checkTouristPhone")
	public boolean checkTouristPhone(TouristVo touristVo) {
		return this.touristService.checkTouristPhone(touristVo);
	}


}
