package com.FanXuyang.dao;

import com.FanXuyang.model.Category;
import com.sun.istack.internal.NotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IcategoryDao {

    public List<Category> findAllCategory(Connection con) throws SQLException;

    public String findByCategoryId(Connection con, int categoryId) throws SQLException;

}
