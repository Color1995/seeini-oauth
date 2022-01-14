package com.seeini.stack.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seeini.common.request.RequestData;
import com.seeini.common.response.ResponseData;
import com.seeini.common.response.ResponseUtil;
import com.seeini.stack.entity.Guidelines;
import com.seeini.stack.mapper.GuidelinesMapper;
import com.seeini.stack.service.GuidelinesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GuidelinesServiceImpl implements GuidelinesService {

    @Resource
    private GuidelinesMapper guidelinesMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return guidelinesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Guidelines record) {
        return guidelinesMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Guidelines record) {
        return guidelinesMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Guidelines record) {
        return guidelinesMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertOrUpdateWithBLOBs(Guidelines record) {
        return guidelinesMapper.insertOrUpdateWithBLOBs(record);
    }

    @Override
    public int insertSelective(Guidelines record) {
        return guidelinesMapper.insertSelective(record);
    }

    @Override
    public Guidelines selectByPrimaryKey(Long id) {
        return guidelinesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Guidelines record) {
        return guidelinesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Guidelines record) {
        return guidelinesMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(Guidelines record) {
        return guidelinesMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Guidelines> list) {
        return guidelinesMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Guidelines> list) {
        return guidelinesMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Guidelines> list) {
        return guidelinesMapper.batchInsert(list);
    }

    /**
     * 查询所有
     * @return
     * @param requestData
     */
    @Override
    public ResponseData list(RequestData requestData) {

        int pageNum = requestData.getPageInfo().getPageNum();
        int pageRows = requestData.getPageInfo().getPageSize();
        String sortArr = requestData.getPageInfo().getOrderArr();

        PageHelper.startPage(pageNum,pageRows,sortArr);
        List<Guidelines> guidelines = guidelinesMapper.list(null, null, null);
        PageInfo<Guidelines> pageInfo = new PageInfo<>(guidelines);
        return ResponseUtil.success(pageInfo);
    }

    /**
     * 查询所有,排序规则
     * @param sortArr
     * @return
     */
    @Override
    public List<Guidelines> list(String[] sortArr, Integer limitStartNum) {
        return guidelinesMapper.list(sortArr, limitStartNum, null);
    }
}
