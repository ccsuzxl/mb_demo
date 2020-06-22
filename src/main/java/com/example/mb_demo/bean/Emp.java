package com.example.mb_demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Emp {
    private int	id;
    private String name;
    private double	salary;
    private String hDate;
}
