package com.wl.repository;

import com.wl.bean.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wangliang on 2018/4/18.
 */
public interface StudentCurdRepository extends CrudRepository<Student, Integer> {

}
