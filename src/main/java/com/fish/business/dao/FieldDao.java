package com.fish.business.dao;

import com.fish.business.domain.Field;
import com.fish.business.vo.FieldVo;

import java.util.List;


/**
 * @InterfaceName FieldDao
 * @Description 滑雪场地数据库访问层
 * @Author 柚子茶
 * @Date 2021/4/1 11:48
 * @Version 1.0
 */
public interface FieldDao {

	int deleteByPrimaryKey(Integer fieldId);

	int insert(Field record);

	int insertSelective(Field record);

	Field selectByPrimaryKey(Integer fieldId);

	int updateByPrimaryKeySelective(Field record);

	int updateByPrimaryKey(Field record);

	/**
	 * @param fieldVo
	 * @return List<Field>
	 * @description 查询场地信息
	 * @author 柚子茶
	 * @date 2021/4/1 16:59
	 **/
	List<Field> queryFieldInfo(FieldVo fieldVo);
}