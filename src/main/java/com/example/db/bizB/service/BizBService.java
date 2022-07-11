package com.example.db.bizB.service;

import com.example.db.bizB.dto.BizBUserDto;

import java.util.List;
import java.util.Map;

public interface BizBService {

    public List<BizBUserDto> selectAllUserService() throws Exception;
    public BizBUserDto selectUserByIdService(Long id) throws Exception;
    public void insertUserService(BizBUserDto txdto) throws Exception;
    public void insertMapService(Map<String, Object> map) throws Exception;
    public void inserBulkList(List<Map<String,Object>> bulkList) throws Exception;
    public boolean isNew(Map<String, Object> map) throws Exception;
}
