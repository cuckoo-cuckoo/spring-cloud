package com.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @create 2021-02-07 22:05
 */
@Mapper
public interface AccountDao {
    void decrease(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
