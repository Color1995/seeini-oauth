package com.seeini.system.service;

import java.util.List;
import com.seeini.system.entity.Access;
public interface AccessService{


    int deleteById(Integer id);

    int insert(Access record);

    int insertOrUpdate(Access record);

    int insertOrUpdateSelective(Access record);

    int insertSelective(Access record);

    Access selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Access record);

    int updateByPrimaryKey(Access record);

    int updateBatch(List<Access> list);

    int updateBatchSelective(List<Access> list);

    int batchInsert(List<Access> list);

}
