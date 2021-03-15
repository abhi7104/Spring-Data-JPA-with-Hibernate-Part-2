package com.example.Jpql.repo;
import com.example.Jpql.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import  org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee,Integer>{

    @Query("select firstName, lastName from Employee " +
            "where salary>(select AVG(salary) from Employee order by age) order by salary DESC")
    List<Object[]> getEmployeeSalary();

    @Query("select AVG(salary) from Employee")
    int findAverageSalary();
    @Modifying
    @Query("update Employee e set e.salary=:salary where e.salary<:avgSalary")
    void updateBelowAvgEmpSalary(@Param("salary")  double salary,@Param("avgSalary") double avgSalary);

    @Query("select MIN(salary) from Employee")
    double findMinSalary();

    @Modifying
    @Query("delete from Employee where salary=:salary")
    void deleteMinSalary(@Param("salary") double salary);

    @Query(value = "select empId,empFirstName from employeetable where empLastName like '%singh'", nativeQuery = true)
    List<Object[]> getAllEmployeeWhoseNameEndsWith();

    @Modifying
    @Query(value = "delete from employeetable where empAge>:age", nativeQuery = true)
    void deleteEmployeeHaingAgeGreaterThan(@Param("age") int age);

}
