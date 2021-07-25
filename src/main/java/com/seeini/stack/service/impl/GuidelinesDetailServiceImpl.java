package com.seeini.stack.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.seeini.stack.mapper.GuidelinesDetailMapper;
import java.util.List;
import com.seeini.stack.entity.GuidelinesDetail;
import com.seeini.stack.service.GuidelinesDetailService;
@Service
public class GuidelinesDetailServiceImpl implements GuidelinesDetailService{

    @Resource
    private GuidelinesDetailMapper guidelinesDetailMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return guidelinesDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GuidelinesDetail record) {
        return guidelinesDetailMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(GuidelinesDetail record) {
        return guidelinesDetailMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(GuidelinesDetail record) {
        return guidelinesDetailMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertOrUpdateWithBLOBs(GuidelinesDetail record) {
        return guidelinesDetailMapper.insertOrUpdateWithBLOBs(record);
    }

    @Override
    public int insertSelective(GuidelinesDetail record) {
        return guidelinesDetailMapper.insertSelective(record);
    }

    @Override
    public GuidelinesDetail selectByPrimaryKey(Long id) {
        return guidelinesDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GuidelinesDetail record) {
        return guidelinesDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(GuidelinesDetail record) {
        return guidelinesDetailMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(GuidelinesDetail record) {
        return guidelinesDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<GuidelinesDetail> list) {
        return guidelinesDetailMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<GuidelinesDetail> list) {
        return guidelinesDetailMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<GuidelinesDetail> list) {
        return guidelinesDetailMapper.batchInsert(list);
    }

}
