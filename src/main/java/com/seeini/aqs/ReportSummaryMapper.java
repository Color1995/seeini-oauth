package com.seeini.aqs;

import com.seeini.aqs.ReportSummary;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Vincent
 * @Date 2021/5/27 11:32
 * @Version 1.0
 * @Description 
 */
@Mapper
public interface ReportSummaryMapper {
    /**
     * delete by primary key
     * @param summaryId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer summaryId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(ReportSummary record);

    int insertOrUpdate(ReportSummary record);

    int insertOrUpdateSelective(ReportSummary record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ReportSummary record);

    /**
     * select by primary key
     * @param summaryId primary key
     * @return object by primary key
     */
    ReportSummary selectByPrimaryKey(Integer summaryId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ReportSummary record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ReportSummary record);

    int updateBatch(List<ReportSummary> list);

    int updateBatchSelective(List<ReportSummary> list);

    int batchInsert(@Param("list") List<ReportSummary> list);
}