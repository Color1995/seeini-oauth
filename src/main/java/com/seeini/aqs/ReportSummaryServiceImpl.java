package com.seeini.aqs;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.seeini.aqs.ReportSummaryMapper;
import com.seeini.aqs.ReportSummary;
import com.seeini.aqs.ReportSummaryService;
/**
 * @Author Vincent
 * @Date 2021/5/27 11:32
 * @Version 1.0
 * @Description 
 */
@Service
public class ReportSummaryServiceImpl implements ReportSummaryService{

    @Resource
    private ReportSummaryMapper reportSummaryMapper;

    @Override
    public int deleteByPrimaryKey(Integer summaryId) {
        return reportSummaryMapper.deleteByPrimaryKey(summaryId);
    }

    @Override
    public int insert(ReportSummary record) {
        return reportSummaryMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(ReportSummary record) {
        return reportSummaryMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(ReportSummary record) {
        return reportSummaryMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(ReportSummary record) {
        return reportSummaryMapper.insertSelective(record);
    }

    @Override
    public ReportSummary selectByPrimaryKey(Integer summaryId) {
        return reportSummaryMapper.selectByPrimaryKey(summaryId);
    }

    @Override
    public int updateByPrimaryKeySelective(ReportSummary record) {
        return reportSummaryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReportSummary record) {
        return reportSummaryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<ReportSummary> list) {
        return reportSummaryMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<ReportSummary> list) {
        return reportSummaryMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<ReportSummary> list) {
        return reportSummaryMapper.batchInsert(list);
    }

}
