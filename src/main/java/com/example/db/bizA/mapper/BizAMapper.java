package com.example.db.bizA.mapper;

import com.example.db.bizA.dto.BizAUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface BizAMapper {

    List<BizAUserDto> selectAllList() throws SQLException;
    BizAUserDto selectUserById(Long id) throws SQLException;
    void insertList(BizAUserDto bizAUserDto) throws SQLException;
    List<Map<String,Object>> selectAll() throws SQLException;

}
