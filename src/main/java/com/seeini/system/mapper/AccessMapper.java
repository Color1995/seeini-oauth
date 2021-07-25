package com.seeini.system.mapper;

import com.seeini.system.entity.Access;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccessMapper {
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
    int insert(Access record);

    int insertOrUpdate(Access record);

    int insertOrUpdateSelective(Access record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Access record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Access selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Access record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Access record);

    int updateBatch(List<Access> list);

    int updateBatchSelective(List<Access> list);

    int batchInsert(@Param("list") List<Access> list);
}