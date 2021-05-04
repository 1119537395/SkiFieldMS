package com.fish.business.dao;

import com.fish.business.domain.Tourist;
import com.fish.business.vo.TouristVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @InterfaceName TouristDao
 * @Description 游客数据库访问层
 * @Author 柚子茶
 * @Date 2021/4/1 11:48
 * @Version 1.0
 */
public interface TouristDao {

	/**
	 * @param touristId
	 * @return int
	 * @description 根据ID删除
	 * @author 柚子茶
	 * @date 2021/4/1 14:04
	 **/
	int deleteByPrimaryKey(Integer touristId);

	/**
	 * @param record
	 * @return int
	 * @description 添加
	 * @author 柚子茶
	 * @date 2021/4/1 14:04
	 **/
	int insert(Tourist record);

	/**
	 * @param record
	 * @return int
	 * @description 根据条件添加
	 * @author 柚子茶
	 * @date 2021/4/1 14:04
	 **/
	int insertSelective(Tourist record);

	/**
	 * @param touristId
	 * @return Tourist
	 * @description 根据ID查询
	 * @author 柚子茶
	 * @date 2021/4/1 14:05
	 **/
	Tourist selectByPrimaryKey(Integer touristId);

	/**
	 * @param record
	 * @return int
	 * @description 根据条件更新
	 * @author 柚子茶
	 * @date 2021/4/1 14:05
	 **/
	int updateByPrimaryKeySelective(Tourist record);

	/**
	 * @param record
	 * @return int
	 * @description 更新
	 * @author 柚子茶
	 * @date 2021/4/1 14:05
	 **/
	int updateByPrimaryKey(Tourist record);


	/**
	 * @param tourist
	 * @return List<Tourist>
	 * @description 查询游客信息
	 * @author 柚子茶
	 * @date 2021/4/1 14:04
	 **/
	List<Tourist> queryTouristInfo(Tourist tourist);

	/**
	 * @param tourist
	 * @return Tourist
	 * @description 游客登录验证
	 * @author 柚子茶
	 * @date 2021/4/1 23:43
	 **/
	Tourist touristLogin(Tourist tourist);

	/**
	 * @param touristPhone
	 * @return Tourist
	 * @description 根据手机号查询游客ID
	 * @author 柚子茶
	 * @date 2021/4/4 13:50
	 **/
	Tourist queryTouristInfoByPhone(@Param("touristPhone") String touristPhone);
}