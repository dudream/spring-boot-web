package com.dudream.dao;

import com.dudream.dao.base.Dao;
import com.dudream.dao.base.DataSourceType;
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
