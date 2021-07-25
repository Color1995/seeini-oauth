package com.seeini.stack.mapper;

import com.seeini.stack.entity.GuidelinesDetail;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GuidelinesDetailMapper {
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
    int insert(GuidelinesDetail record);

    int insertOrUpdate(GuidelinesDetail record);

    int insertOrUpdateSelective(GuidelinesDetail record);

    int insertOrUpdateWithBLOBs(GuidelinesDetail record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(GuidelinesDetail record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    GuidelinesDetail selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(GuidelinesDetail record);

    int updateByPrimaryKeyWithBLOBs(GuidelinesDetail record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(GuidelinesDetail record);

    int updateBatch(List<GuidelinesDetail> list);

    int updateBatchSelective(List<GuidelinesDetail> list);

    int batchInsert(@Param("list") List<GuidelinesDetail> list);
}