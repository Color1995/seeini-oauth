package com.seeini.oauth.mapper;

import com.seeini.oauth.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Vincent
 * @Date 2021/7/26 11:42
 * @Version 1.0
 * @Description
 */
@Mapper
public interface UserMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteById(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(User record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(User record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    User selectById(Integer id);

    /**
     * select by primary account
     *
     * @param account primary key
     * @return object by primary key
     */
    User selectByAccount(String account);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(User record);

}