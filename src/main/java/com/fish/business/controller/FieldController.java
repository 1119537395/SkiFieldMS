package com.fish.business.controller;

import com.fish.business.domain.Field;
import com.fish.business.vo.FieldVo;
import com.fish.system.controller.BaseController;
import com.fish.system.utils.CommonReturnType;
import com.fish.system.utils.DataGridView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FieldController
 * @Description 场地管理前端控制器
 * @Author 柚子茶
 * @Date 2021/4/1 16:44
 * @Version 1.0
 */
@RestController
@RequestMapping("field")
public class FieldController extends BaseController {


	/**
	 * @param fieldVo
	 * @return DataGridView
	 * @description 查询场地信息
	 * @author 柚子茶
	 * @date 2021/4/1 16:47
	 **/
	@RequestMapping("loadFieldInfo")
	public DataGridView loadFieldInfo(FieldVo fieldVo) {
		return this.fieldService.queryFieldInfo(fieldVo);
	}

	/**
	 * @param fieldVo
	 * @return CommonReturnType
	 * @description 添加场地信息
	 * @author 柚子茶
	 * @date 2021/4/1 16:49
	 **/
	@RequestMapping("addFieldInfo")
	public CommonReturnType addFieldInfo(FieldVo fieldVo) {
		try {
			this.fieldService.addFieldInfo(fieldVo);
			return CommonReturnType.ADD_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.ADD_FAILURE;
		}
	}


	/**
	 * @param fieldVo
	 * @return boolean
	 * @description 校验购票数量是否正确
	 * @author 柚子茶
	 * @date 2021/4/5 21:51
	 **/
	@RequestMapping("checkTicketNumber")
	public boolean checkTicketNumber(FieldVo fieldVo) {
		return this.fieldService.checkTicketNumber(fieldVo);
	}


	/**
	 * @param fieldVo
	 * @return CommonReturnType
	 * @description 修改场地信息
	 * @author 柚子茶
	 * @date 2021/4/1 16:53
	 **/
	@RequestMapping("updateFieldInfo")
	public CommonReturnType updateFieldInfo(FieldVo fieldVo) {
		try {
			this.fieldService.updateFieldInfo(fieldVo);
			return CommonReturnType.MODIFY_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.MODIFY_FAILURE;
		}
	}

	/**
	 * @param fieldVo
	 * @return CommonReturnType
	 * @description 删除场次信息
	 * @author 柚子茶
	 * @date 2021/4/1 16:54
	 **/
	@RequestMapping("deleteFieldInfo")
	public CommonReturnType deleteFieldInfo(FieldVo fieldVo) {
		try {
			this.fieldService.deleteFieldInfo(fieldVo);
			return CommonReturnType.DELETE_SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return CommonReturnType.DELETE_FAILURE;
		}
	}


	/**
	 * @param fieldVo
	 * @return DataGridView
	 * @description 查询未隐藏的场次信息
	 * @author 柚子茶
	 * @date 2021/4/4 13:09
	 **/
	@RequestMapping("loadFieldInfoByState")
	public DataGridView loadFieldInfoByState(FieldVo fieldVo) {
		return this.fieldService.loadFieldInfoByState(fieldVo);
	}


}
