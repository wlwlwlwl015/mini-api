package com.wl.repository;

import com.wl.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by wangliang on 2018/4/18.
 */
public interface StudentPagingAndSortingRepository extends PagingAndSortingRepository<Student,Integer> {

    // 仅支持排序
    List<Student> findAll(Sort sort);

    // 支持分页和排序
    Page<Student> findAll(Pageable pageable);

}
