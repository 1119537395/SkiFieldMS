package com.fish.business.service;

import com.fish.business.domain.Field;
import com.fish.business.vo.FieldVo;
import com.fish.system.utils.DataGridView;

/**
 * @InterfaceName FieldService
 * @Description 场地业务层接口
 * @Author 柚子茶
 * @Date 2021/4/1 16:43
 * @Version 1.0
 */
public interface FieldService {


	/**
	 * @param fieldVo
	 * @return DataGridView
	 * @description 查询
	 * @author 柚子茶
	 * @date 2021/4/1 16:48
	 **/
	DataGridView queryFieldInfo(FieldVo fieldVo);

	/**
	 * @param fieldVo
	 * @return void
	 * @description 添加
	 * @author 柚子茶
	 * @date 2021/4/1 16:50
	 **/
	void addFieldInfo(FieldVo fieldVo);

	/**
	 * @param fieldVo
	 * @return void
	 * @description 修改场地信息
	 * @author 柚子茶
	 * @date 2021/4/1 16:53
	 **/
	void updateFieldInfo(FieldVo fieldVo);

	/**
	 * @param fieldVo
	 * @return void
	 * @description 删除场地信息
	 * @author 柚子茶
	 * @date 2021/4/1 16:56
	 **/
	void deleteFieldInfo(FieldVo fieldVo);

	/**
	 * @param fieldVo
	 * @return DataGridView
	 * @description 查询未隐藏的场次信息
	 * @author 柚子茶
	 * @date 2021/4/4 13:10
	 **/
	DataGridView loadFieldInfoByState(FieldVo fieldVo);


	/**
	 * @param fieldVo
	 * @return boolean
	 * @description 校验购票数量是否正确
	 * @author 柚子茶
	 * @date 2021/4/5 21:51
	 **/
	boolean checkTicketNumber(FieldVo fieldVo);
}
