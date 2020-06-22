package com.example.mb_demo.service.impl;

import com.example.mb_demo.bean.Emp;
import com.example.mb_demo.mapper.EmpMapper;
import com.example.mb_demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> selectAllEmp() {
        return empMapper.selectAllEmp();
    }
}
