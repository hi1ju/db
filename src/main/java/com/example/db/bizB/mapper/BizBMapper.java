package com.example.db.bizB.mapper;

import com.example.db.bizB.dto.BizBUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface BizBMapper {

    List<BizBUserDto> selectAllList() throws SQLException;
    BizBUserDto selectUserById(Long id) throws SQLException;
    void insertList(BizBUserDto bizBUserDto) throws SQLException;
    void insertMap(Map<String,Object> map) throws SQLException;
    List<Map<String,Object>> selectMap(Map<String,Object> map) throws SQLException;

}
