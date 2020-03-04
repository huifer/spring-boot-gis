package com.huifer.springbootgis.mapper;

import com.huifer.springbootgis.entity.PointTable;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(PointTable record);

	int insertSelective(PointTable record);

	PointTable selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(PointTable record);

	int updateByPrimaryKey(PointTable record);

}