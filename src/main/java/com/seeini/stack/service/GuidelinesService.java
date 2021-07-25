package com.seeini.stack.service;

import com.seeini.common.request.RequestData;
import com.seeini.common.response.ResponseData;
import com.seeini.stack.entity.Guidelines;

import java.util.List;
public interface GuidelinesService{


    int deleteByPrimaryKey(Long id);

    int insert(Guidelines record);

    int insertOrUpdate(Guidelines record);

    int insertOrUpdateSelective(Guidelines record);

    int insertOrUpdateWithBLOBs(Guidelines record);

    int insertSelective(Guidelines record);

    Guidelines selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Guidelines record);

    int updateByPrimaryKeyWithBLOBs(Guidelines record);

    int updateByPrimaryKey(Guidelines record);

    int updateBatch(List<Guidelines> list);

    int updateBatchSelective(List<Guidelines> list);

    int batchInsert(List<Guidelines> list);

    /**
     * 查询所有
     * @return
     * @param requestData
     */
    ResponseData list(RequestData requestData);

    /**
     * 查询所有,排序规则
     * @return
     */
    List<Guidelines> list(String[] orderBy, Integer limitNum);
}
