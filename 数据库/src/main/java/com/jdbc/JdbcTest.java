package com.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//jdbcTemplate线程安全
public class JdbcTest {
    private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean01.xml");
    private JdbcTemplate jdbcTemplate= (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

    private EmployeeDao employeeDao= applicationContext.getBean(EmployeeDao.class);
    @Test
    public void testEmployeeDao(){
        System.out.println(employeeDao.get(1));
    }

    private DepartmentDao departmentDao=applicationContext.getBean(DepartmentDao.class);
    @Test
    public void testDepartmentDao(){
        System.out.println(departmentDao.get(1));
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource=applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    /**
     * 执行insert,update,delete
     */
    @Test
    public void testUpdate(){
        String sql="update employees set last_name = ? where id = ?";
        jdbcTemplate.update(sql,"jack",3);
    }

    /**
     * 执行批量更新
     */
    @Test
    public void testBatchUpdate(){
        String sql="insert into employees(last_name,email,dept_id) values(?,?,?)";
        List<Object[]> batchArgs=new ArrayList<>();
        batchArgs.add(new Object[]{"AA","aa@atguigu.com",1});
        batchArgs.add(new Object[]{"BB","bb@atguigu.com",2});
        batchArgs.add(new Object[]{"CC","cc@atguigu.com",3});
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }
    /**
     * 从数据库中获取一条记录,实际得到一个对应的对象
     *  1.其中的RowMapper指定如何去映射结果集的行,常用的实现类为BeanPropertyRowMapper
     *  2.不支持级联属性
     */
    @Test
    public void testQueryForObject(){
        String sql="select id,last_name,email from employees where id=?";
        RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<>(Employee.class);
        Employee employee=jdbcTemplate.queryForObject(sql,rowMapper,1);
        System.out.println(employee);
    }
    /**
     * 查找实例类的集合
     */
    @Test
    public void testQueryForList(){
        String sql="select id,last_name,email from employees where id = ?";
        RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees=jdbcTemplate.query(sql,rowMapper,5);
        System.out.println(employees);
    }
    /**
     * 获取单个列的值,或做统计查询
     */
    @Test
    public void testQueryForObject2(){
        String sql="select count(id) from employees";
        long count=jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(count);
    }

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate=applicationContext.getBean(NamedParameterJdbcTemplate.class);

}
