package com.fish.business.service.impl;

import com.fish.business.domain.Field;
import com.fish.business.domain.Order;
import com.fish.business.domain.Tourist;
import com.fish.business.service.TouristService;
import com.fish.business.vo.OrderVo;
import com.fish.business.vo.TouristVo;
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
 * @ClassName TouristServiceImpl
 * @Description 游客业务层接口实现类
 * @Author 柚子茶
 * @Date 2021/4/1 11:56
 * @Version 1.0
 */
@Service
public class TouristServiceImpl extends BaseService implements TouristService {


	/**
	 * @param touristVo
	 * @return DataGridView
	 * @description 查询
	 * @author 柚子茶
	 * @date 2021/4/1 14:02
	 **/
	@Override
	public DataGridView queryTouristInfo(TouristVo touristVo) {
		// 开启分页
		Page<Object> page = PageHelper.startPage(touristVo.getPage(), touristVo.getLimit());
		List<Tourist> touristList = this.touristDao.queryTouristInfo(touristVo);
		return new DataGridView(page.getTotal(), touristList);
	}

	/**
	 * @param touristVo
	 * @return void
	 * @description 添加
	 * @author 柚子茶
	 * @date 2021/4/1 14:02
	 **/
	@Override
	public void addTouristInfo(TouristVo touristVo) {
		// 获取当前登录的用户
		User user = (User) WebUtils.getHttpSession().getAttribute("user");
		touristVo.setCreateTime(new Date());
		touristVo.setCreateUserId(user.getUserId());
		this.touristDao.insertSelective(touristVo);
		// 给新增的游客分配角色
		this.userDao.insertUserHasRole(touristVo.getTouristId(), 3);
	}

	/**
	 * @param touristVo
	 * @return void
	 * @description 删除
	 * @author 柚子茶
	 * @date 2021/4/1 14:02
	 **/
	@Override
	public void deleteTouristInfo(TouristVo touristVo) {
		this.touristDao.deleteByPrimaryKey(touristVo.getTouristId());
	}

	/**
	 * @param touristVo
	 * @return void
	 * @description 修改
	 * @author 柚子茶
	 * @date 2021/4/1 14:02
	 **/
	@Override
	public void updateTouristInfo(TouristVo touristVo) {
		this.touristDao.updateByPrimaryKeySelective(touristVo);
	}

	/**
	 * @param tourist
	 * @return Tourist
	 * @description 游客登录验证
	 * @author 柚子茶
	 * @date 2021/4/1 23:42
	 **/
	@Override
	public Tourist touristLogin(Tourist tourist) {
		return this.touristDao.touristLogin(tourist);
	}

	/**
	 * @param touristVo
	 * @return void
	 * @description 游客注册
	 * @author 柚子茶
	 * @date 2021/4/3 14:42
	 **/
	@Override
	public void addTouristRegister(TouristVo touristVo) {
		// 获取当前登录的用户
		touristVo.setCreateTime(new Date());
		this.touristDao.insertSelective(touristVo);
		// 给新增的游客分配角色
		this.userDao.insertUserHasRole(touristVo.getTouristId(), 3);
	}

	/**
	 * @param touristPhone
	 * @return Tourist
	 * @description 根据手机号查询游客信息
	 * @author 柚子茶
	 * @date 2021/4/4 14:03
	 **/
	@Override
	public Tourist queryTouristInfoByPhone(String touristPhone) {
		return this.touristDao.queryTouristInfoByPhone(touristPhone);
	}



	/**
	 * @param touristVo
	 * @return boolean
	 * @description 游客注册/添加手机号校验
	 * @author 柚子茶
	 * @date 2021/4/5 22:55
	 **/
	@Override
	public boolean checkTouristPhone(TouristVo touristVo) {
		if (null != touristVo.getTouristId()){
			Tourist tourist = this.touristDao.selectByPrimaryKey(touristVo.getTouristId());
			if (tourist.getTouristPhone().equals(touristVo.getTouristPhone())){
				return false;
			}else {
				Tourist tourist1 = this.touristDao.queryTouristInfoByPhone(touristVo.getTouristPhone());
				if (null != tourist1){
					return true;
				}else {
					return false;
				}
			}
		} else {
			Tourist tourist2 = this.touristDao.queryTouristInfoByPhone(touristVo.getTouristPhone());
			if (null != tourist2){
				return true;
			}else {
				return false;
			}
		}
	}
}
