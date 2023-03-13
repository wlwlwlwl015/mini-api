package com.wl;

import com.wl.bean.Cgt;
import com.wl.bean.CgtOrder;
import com.wl.bean.Student;
import com.wl.bean.SysUserInfo;
import com.wl.repository.*;
import com.wl.service.CgtService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangliang on 2018/4/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCurdRepository studentCurdRepository;

    @Autowired
    private StudentPagingAndSortingRepository studentPagingAndSortingRepository;

    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @Autowired
    private SysUserInfoRepository sysUserInfoRepository;

    @Autowired
    private CgtOrderRepository cgtOrderRepository;

    @Autowired
    private CgtService cgtService;

    @Test
    public void testStudentRepository() {
        // 1.测试通过Annotation声明的HQL查询
        Student stu1 = studentRepository.loadById(1);
        Assert.assertEquals("Raito", stu1.getName());
        // 2.测试衍生条件查询(1)
        List<Student> stus = studentRepository.findByAddressAndAge("West Shadow Road. No 29.", 25);
        Assert.assertEquals(2, stus.size());
        // 3.测试衍生条件查询(2)
        Student stu3 = studentRepository.readById(2);
        Assert.assertEquals("Tsuri", stu3.getName());
        // 4.测试衍生条件查询(3)
        Student stu4 = studentRepository.getById(3);
        Assert.assertEquals("Harry", stu4.getName());
        // 5.测试衍生条件查询(4)
        Student stu5 = studentRepository.findById(4);
        Assert.assertEquals("Tom", stu5.getName());
        // 6.测试重写findAll方法
        List<Student> allStudents = studentRepository.findAll();
        Assert.assertEquals(4, allStudents.size());
        Assert.assertEquals("Raito", allStudents.get(0).getName());
    }

    @Test
    public void testStudentCurdRepository() {
        // 添加操作
        Student stu = new Student("Jimmy", "East Road. No 2. 5#2608", 31);
        Student stu1 = studentCurdRepository.save(stu);
        Assert.assertEquals("Jimmy", stu1.getName());
        // 批量添加
        List<Student> saveList = new ArrayList<>();
        Student stu2 = new Student("Jack", "East Road. No 3. 1#1102", 21);
        Student stu3 = new Student("Tony", "East Road. No 3. 2#802", 25);
        Student stu4 = new Student("Linux", "East Road. No 3. 3#2102", 26);
        saveList.add(stu2);
        saveList.add(stu3);
        saveList.add(stu4);
        studentCurdRepository.save(saveList);
        // 判断是否存在
        boolean exists = studentCurdRepository.exists(stu1.getId());
        Assert.assertEquals(true, exists);
        // count操作
        long count = studentCurdRepository.count();
        Assert.assertEquals(8, count);
        // 更新操作
        Student stu13 = studentCurdRepository.findOne(17);
        stu13.setName("Emily");
        stu13.setAge(18);
        Student stu13_ = studentCurdRepository.save(stu13);
        Assert.assertEquals("Emily", stu13_.getName());
        // 删除操作
        // studentCurdRepository.delete(stu1);


    }

    @Test
    public void testStudentPagingAndSortingRepository() {
        // 测试List排序
        List<Student> stus = studentPagingAndSortingRepository.findAll(new Sort(Sort.Direction.DESC, "name"));
        Assert.assertEquals("Zara", stus.get(0).getName());
        // 测试List分页
        Page<Student> studentPage = studentPagingAndSortingRepository.findAll(new PageRequest(1, 3));
        Assert.assertEquals(3, studentPage.getTotalPages());
        Assert.assertEquals(9, studentPage.getTotalElements());
        // 测试List分页+排序（注意page下标用0开始）
        Page<Student> studentPage2 = studentPagingAndSortingRepository.findAll(new PageRequest(0, 3, Sort.Direction.DESC, "name"));
        Assert.assertEquals("Zara", studentPage2.getContent().get(0).getName());
    }


    @Test
    public void testStudentJpaRepository() {
        // 测试List分页+排序（注意page下标用0开始）
//        Page<Student> stus = studentJpaRepository.findAll(new PageRequest(0, 3, Sort.Direction.DESC, "name"));
//        Assert.assertEquals("Zara", stus.getContent().get(0).getName());
    }

    @Test
    public void testSysUserInfoRepository() {
        SysUserInfo sysUser = sysUserInfoRepository.findByLoginNameOrPhoneNumber("wlwlwlwl011", "123");
        Assert.assertNull(sysUser);
    }

    @Test
    public void testCgtOrderRepository() {
        Page<CgtOrder> cgtOrderPage = cgtOrderRepository.findByLoginName("wlwlwlwl015", new PageRequest(0, 10, Sort.Direction.DESC, "orderTime"));
        Assert.assertEquals("618006806111", cgtOrderPage.getContent().get(0).getOrderId());
    }

    @Test
    public void testCgtRepository() {
        List<Cgt> list = cgtService.findByIsTop();
        Assert.assertEquals(8, list.size());
    }

    @Test
    public void testGitBranch() {
        System.out.println("Test Git Branch");
    }

}
