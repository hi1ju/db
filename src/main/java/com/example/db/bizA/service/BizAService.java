package com.example.db.bizA.service;

import com.example.db.bizA.dto.BizAUserDto;

import java.util.List;
import java.util.Map;

public interface BizAService {

    public List<BizAUserDto> selectAllUserService() throws Exception;
    public BizAUserDto selectUserByIdService(Long id) throws Exception;
    public void insertUserService(BizAUserDto txdto) throws Exception;
    public List<Map<String,Object>> selectAll() throws Exception;

}
