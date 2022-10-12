package com.wl.service.impl;

import com.wl.bean.Student;
import com.wl.repository.StudentJpaRepository;
import com.wl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangliang on 2018/4/19.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentJpaRepository.findAll();
    }
}
