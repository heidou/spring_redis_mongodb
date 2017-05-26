package com.heidou.dao;

import com.heidou.model.BookDO;


/**
 * @author heidou.f
 *         2017/3/24.
 */
public interface BookDOMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(BookDO record);

  int insertSelective(BookDO record);

  BookDO selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(BookDO record);

  int updateByPrimaryKey(BookDO record);
}
