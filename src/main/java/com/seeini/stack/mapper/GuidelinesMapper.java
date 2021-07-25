package com.seeini.stack.mapper;

import com.seeini.stack.entity.Guidelines;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GuidelinesMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Guidelines record);

    int insertOrUpdate(Guidelines record);

    int insertOrUpdateSelective(Guidelines record);

    int insertOrUpdateWithBLOBs(Guidelines record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Guidelines record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Guidelines selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Guidelines record);

    int updateByPrimaryKeyWithBLOBs(Guidelines record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Guidelines record);

    int updateBatch(List<Guidelines> list);

    int updateBatchSelective(List<Guidelines> list);

    int batchInsert(@Param("list") List<Guidelines> list);

    List<Guidelines> list(@Param("sortArr") String[] sortArr,@Param("limitStartNum") Integer limitStartNum, @Param("limitEndNum") Integer limitEndNum);

    Integer total(@Param("sortArr") String[] sortArr);
}