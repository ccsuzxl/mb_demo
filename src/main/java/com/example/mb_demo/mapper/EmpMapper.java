package com.example.mb_demo.mapper;

import com.example.mb_demo.bean.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMapper {
    List<Emp> selectAllEmp();
}
