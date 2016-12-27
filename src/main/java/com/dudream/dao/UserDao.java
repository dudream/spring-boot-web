package com.dudream.dao;

import com.dudream.base.dao.Dao;
import com.dudream.base.dao.DataSourceType;
import com.dudream.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by dudream on 2016/12/27.
 */
@Mapper
@Dao(DataSourceType.Demo)
public interface UserDao {

    User getById(Long userId);

}
