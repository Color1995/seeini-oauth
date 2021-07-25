package com.seeini.stack.service;

import java.util.List;
import com.seeini.stack.entity.GuidelinesDetail;
public interface GuidelinesDetailService{


    int deleteByPrimaryKey(Long id);

    int insert(GuidelinesDetail record);

    int insertOrUpdate(GuidelinesDetail record);

    int insertOrUpdateSelective(GuidelinesDetail record);

    int insertOrUpdateWithBLOBs(GuidelinesDetail record);

    int insertSelective(GuidelinesDetail record);

    GuidelinesDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GuidelinesDetail record);

    int updateByPrimaryKeyWithBLOBs(GuidelinesDetail record);

    int updateByPrimaryKey(GuidelinesDetail record);

    int updateBatch(List<GuidelinesDetail> list);

    int updateBatchSelective(List<GuidelinesDetail> list);

    int batchInsert(List<GuidelinesDetail> list);

}
