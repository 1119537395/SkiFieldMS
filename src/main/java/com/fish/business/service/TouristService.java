package com.fish.business.service;

import com.fish.business.domain.Tourist;
import com.fish.business.vo.OrderVo;
import com.fish.business.vo.TouristVo;
import com.fish.system.utils.DataGridView;

/**
 * @InterfaceName TouristService
 * @Description 游客业务层接口
 * @Author 柚子茶
 * @Date 2021/4/1 11:56
 * @Version 1.0
 */
public interface TouristService {


	/**
	 * @param touristVo 游客实体类
	 * @return DataGridView
	 * @description 查询游客信息
	 * @author 柚子茶
	 * @date 2021/4/1 13:55
	 **/
	DataGridView queryTouristInfo(TouristVo touristVo);

	/**
	 * @param touristVo
	 * @return void
	 * @description 添加游客信息
	 * @author 柚子茶
	 * @date 2021/4/1 14:00
	 **/
	void addTouristInfo(TouristVo touristVo);

	/**
	 * @param touristVo
	 * @return void
	 * @description 删除游客信息
	 * @author 柚子茶
	 * @date 2021/4/1 14:00
	 **/
	void deleteTouristInfo(TouristVo touristVo);

	/**
	 * @param touristVo
	 * @return void
	 * @description 修改游客信息
	 * @author 柚子茶
	 * @date 2021/4/1 14:01
	 **/
	void updateTouristInfo(TouristVo touristVo);

	/**
	 * @param tourist
	 * @return Tourist
	 * @description 游客登录验证
	 * @author 柚子茶
	 * @date 2021/4/1 23:42
	 **/
	Tourist touristLogin(Tourist tourist);

	/**
	 * @param touristVo
	 * @return void
	 * @description 游客注册
	 * @author 柚子茶
	 * @date 2021/4/3 14:41
	 **/
	void addTouristRegister(TouristVo touristVo);

	/**
	 * @param touristPhone
	 * @return Tourist
	 * @description 根据手机号查询游客信息
	 * @author 柚子茶
	 * @date 2021/4/4 14:02
	 **/
	Tourist queryTouristInfoByPhone(String touristPhone);



	/**
	 * @param touristVo
	 * @return boolean
	 * @description 游客注册/添加手机号校验
	 * @author 柚子茶
	 * @date 2021/4/5 22:55
	 **/
	boolean checkTouristPhone(TouristVo touristVo);
}
