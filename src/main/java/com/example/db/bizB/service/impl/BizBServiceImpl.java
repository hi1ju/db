package com.example.db.bizB.service.impl;

import com.example.db.bizA.dto.BizAUserDto;
import com.example.db.bizB.dto.BizBUserDto;
import com.example.db.bizB.mapper.BizBMapper;
import com.example.db.bizB.service.BizBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BizBServiceImpl implements BizBService {

    @Autowired
    BizBMapper bizBMapper;

    @Override
    public List<BizBUserDto> selectAllUserService() throws Exception {
        List<BizBUserDto> users = bizBMapper.selectAllList();
        for (BizBUserDto user : users) {
            System.out.println(user.getId() +" / "+ user.getName());
        }
        return users;
    }

    @Override
    public BizBUserDto selectUserByIdService(Long id) throws Exception{
        BizBUserDto user = bizBMapper.selectUserById(id);
        return user;
    }

    @Override
    public void insertUserService(BizBUserDto bizBUserDto) throws Exception{
        bizBMapper.insertList(bizBUserDto);
    }

    @Override
    public void insertMapService(Map<String, Object> map) throws Exception {
        if(bizBMapper.selectMap(map).stream().count() == 0){
            bizBMapper.insertMap(map);
        }else{
            System.out.println(bizBMapper.selectMap(map).stream().count());
        }

    }

    @Override
    public void inserBulkList(List<Map<String, Object>> bulkList) throws Exception {

    }

    @Override
    public boolean isNew(Map<String, Object> map) throws Exception {
        return bizBMapper.selectMap(map).stream().count() == 0 ? true : false;
    }
}
