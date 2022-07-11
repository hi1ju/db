package com.example.db.bizA.service.impl;

import com.example.db.bizA.dto.BizAUserDto;
import com.example.db.bizA.mapper.BizAMapper;
import com.example.db.bizA.service.BizAService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BizAServiceImpl implements BizAService {

    @Autowired
    BizAMapper bizAMapper;

    @Override
    public List<BizAUserDto> selectAllUserService() throws Exception {
        List<BizAUserDto> users = bizAMapper.selectAllList();
        for (BizAUserDto user : users) {
            System.out.println(user.getId() +" / "+ user.getName());
        }
        return users;
    }

    @Override
    public BizAUserDto selectUserByIdService(Long id) throws Exception{
        BizAUserDto user = bizAMapper.selectUserById(id);
        return user;
    }

    @Override
    public void insertUserService(BizAUserDto bizAUserDto) throws Exception{
        bizAMapper.insertList(bizAUserDto);
    }

    @Override
    public List<Map<String,Object>> selectAll() throws Exception {
        List<Map<String, Object>> maps = bizAMapper.selectAll();
        for (Map<String, Object> map : maps) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println("map key : "+entry.getKey() + " / "+"map value : "+entry.getValue());
            }
        }
        return maps;
    }

}
