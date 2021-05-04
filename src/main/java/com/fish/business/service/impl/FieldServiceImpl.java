package com.fish.business.service.impl;

import com.fish.business.domain.Field;
import com.fish.business.service.FieldService;
import com.fish.business.vo.FieldVo;
import com.fish.system.domain.User;
import com.fish.system.service.impl.BaseService;
import com.fish.system.utils.DataGridView;
import com.fish.system.utils.WebUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName FieldServiceImpl
 * @Description 场地业务层接口实现类
 * @Author 柚子茶
 * @Date 2021/4/1 16:43
 * @Version 1.0
 */
@Service
public class FieldServiceImpl extends BaseService implements FieldService {


	/**
	 * @param fieldVo
	 * @return DataGridView
	 * @description 查询场地信息
	 * @author 柚子茶
	 * @date 2021/4/1 16:57
	 **/
	@Override
	public DataGridView queryFieldInfo(FieldVo fieldVo) {
		// 开启分页
		Page<Object> page = PageHelper.startPage(fieldVo.getPage(), fieldVo.getLimit());
		List<Field> fieldList = this.fieldDao.queryFieldInfo(fieldVo);
		return new DataGridView(page.getTotal(), fieldList);
	}

	/**
	 * @param fieldVo
	 * @return void
	 * @description 添加场地信息
	 * @author 柚子茶
	 * @date 2021/4/1 16:57
	 **/
	@Override
	public void addFieldInfo(FieldVo fieldVo) {
		// 获取当前登录用户
		User user = (User) WebUtils.getHttpSession().getAttribute("user");
		fieldVo.setCreateTime(new Date());
		fieldVo.setCreateUserId(user.getUserId());
		this.fieldDao.insertSelective(fieldVo);
	}

	/**
	 * @param fieldVo
	 * @return void
	 * @description 修改场地信息
	 * @author 柚子茶
	 * @date 2021/4/1 16:57
	 **/
	@Override
	public void updateFieldInfo(FieldVo fieldVo) {
		this.fieldDao.updateByPrimaryKeySelective(fieldVo);
	}

	/**
	 * @param fieldVo
	 * @return void
	 * @description 删除场地信息
	 * @author 柚子茶
	 * @date 2021/4/1 16:57
	 **/
	@Override
	public void deleteFieldInfo(FieldVo fieldVo) {
		this.fieldDao.deleteByPrimaryKey(fieldVo.getFieldId());
	}

	/**
	 * @param fieldVo
	 * @return DataGridView
	 * @description 查询未隐藏的场次信息
	 * @author 柚子茶
	 * @date 2021/4/4 13:10
	 **/
	@Override
	public DataGridView loadFieldInfoByState(FieldVo fieldVo) {
		// 开启分页
		Page<Object> page = PageHelper.startPage(fieldVo.getPage(), fieldVo.getLimit());
		fieldVo.setFieldState(1);
		List<Field> fieldList = this.fieldDao.queryFieldInfo(fieldVo);
		return new DataGridView(page.getTotal(), fieldList);
	}

	/**
	 * @param fieldVo
	 * @return boolean
	 * @description 校验购票数量是否正确
	 * @author 柚子茶
	 * @date 2021/4/5 21:52
	 **/
	@Override
	public boolean checkTicketNumber(FieldVo fieldVo) {
		// 查询出剩余票量
		Field field = this.fieldDao.selectByPrimaryKey(fieldVo.getFieldId());
		if (field.getFieldCapacity() < fieldVo.getTicketNumber()){
			return true;
		}
		return false;
	}
}
