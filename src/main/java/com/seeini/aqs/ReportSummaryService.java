package com.seeini.aqs;

import java.util.List;
import com.seeini.aqs.ReportSummary;
    /**
 * @Author Vincent
 * @Date 2021/5/27 11:32
 * @Version 1.0
 * @Description 
 */
public interface ReportSummaryService{


    int deleteByPrimaryKey(Integer summaryId);

    int insert(ReportSummary record);

    int insertOrUpdate(ReportSummary record);

    int insertOrUpdateSelective(ReportSummary record);

    int insertSelective(ReportSummary record);

    ReportSummary selectByPrimaryKey(Integer summaryId);

    int updateByPrimaryKeySelective(ReportSummary record);

    int updateByPrimaryKey(ReportSummary record);

    int updateBatch(List<ReportSummary> list);

    int updateBatchSelective(List<ReportSummary> list);

    int batchInsert(List<ReportSummary> list);

}
