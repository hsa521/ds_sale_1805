package com.mr.mapper;

import com.mr.model.TMallUserAccount;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ${ShenTao} on 2018/11/5.
 */
public interface UserMapper {
    TMallUserAccount findUserByNamePswd(@Param("userName") String userName,
                                        @Param("password") String password);
}
