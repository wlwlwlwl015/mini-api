package com.wl.repository;

import com.wl.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangliang on 2018/4/18.
 */
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

}
