package com.seeini.system.service.impl;

import com.seeini.system.service.AccessService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.seeini.system.mapper.AccessMapper;
import com.seeini.system.entity.Access;

@Service
public class AccessServiceImpl implements AccessService {

    @Resource
    private AccessMapper accessMapper;

    @Override
    public int deleteById(Integer id) {
        return accessMapper.deleteById(id);
    }

    @Override
    public int insert(Access record) {
        return accessMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Access record) {
        return accessMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Access record) {
        return accessMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Access record) {
        return accessMapper.insertSelective(record);
    }

    @Override
    public Access selectByPrimaryKey(Integer id) {
        return accessMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Access record) {
        return accessMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Access record) {
        return accessMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Access> list) {
        return accessMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Access> list) {
        return accessMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Access> list) {
        return accessMapper.batchInsert(list);
    }

}
