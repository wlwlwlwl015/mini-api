package com.wl.repository;

import com.wl.bean.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by wangliang on 2018/4/16.
 */
public interface StudentRepository extends Repository<Student, Integer> {

    // 通过Annotation声明HQL查询
    // ?1表示用方法中的第一个参数
    @Query("select s from Student s where s.id=?1")
    public Student loadById(int id);

    // 衍生查询，只要函数的声明有findBy,getBy,readBy,就会去读取
    // findByAddressAnAge表示根据address和age进行查询
    public List<Student> findByAddressAndAge(String address, int age);

    // 根据id获取对象，即可返回对象，也可以返回列表
    public Student readById(int id);

    // 根据id获取列表，这里如果确定只有一个对象，也可以返回对象
    public Student getById(int id);

    // 根据id获取一个对象，同样也可以返回列表
    public Student findById(int id);

    // 查询所有学生，重写CrudRepository的findAll，直接返回List<Student>而不是Iterable<Student>
    public List<Student> findAll();

}
