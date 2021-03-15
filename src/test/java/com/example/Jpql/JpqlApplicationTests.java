package com.example.Jpql;

import com.example.Jpql.entity.*;
import com.example.Jpql.repo.ComponentMappingRepo;
import com.example.Jpql.repo.EmployeeRepo;
import com.example.Jpql.repo.PaymentRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class JpqlApplicationTests {
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	PaymentRepo paymentRepo;
	@Autowired
	ComponentMappingRepo componentMappingRepo;
	@Test
	void contextLoads() {
	}
	@Test
	void testEmp() {
		Employee employee= new Employee();
		employee.setId(5);
		employee.setAge(20);
		employee.setFirstName("Nitish");
		employee.setLastName("Arora");
		employee.setSalary(11000.10);
		employeeRepo.save(employee);
	}
	@Test
	void testEmployeeSalary()
	{
		List<Object[]> getemployee=employeeRepo.getEmployeeSalary();
		for(Object[] objects: getemployee){
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}

	@Test
	@Transactional
	@Rollback(value = false)
	void testUpdateEmployee()
	{
		employeeRepo.updateBelowAvgEmpSalary(10000.0,employeeRepo.findAverageSalary());
	}
	@Test
	@Transactional
	@Rollback(value = false)
	void deleteMinSalary()
	{
		employeeRepo.deleteMinSalary(employeeRepo.findMinSalary());
	}
	@Test
	public void testGetAllEmployeeWhoseNameEndsWith(){
		List<Object[]> empData = employeeRepo.getAllEmployeeWhoseNameEndsWith();
		for(Object[] obj: empData){
			System.out.println(obj[0]);
			System.out.println(obj[1]);
		}
	}
	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteEmployeeHavingAgeGreaterThan(){
		employeeRepo.deleteEmployeeHaingAgeGreaterThan(45);
	}

	@Test
	public void createPaymentCreditCard(){
		CreditCard cc = new CreditCard();
		cc.setId(1);
		cc.setAmount(5000);
		cc.setCardnumber("532437963");
		paymentRepo.save(cc);
	}
	@Test
	public void createPaymentCheckBook(){
		Check ch = new Check();
		ch.setId(2);
		ch.setAmount(5000);
		ch.setChecknumber("532437963");
		paymentRepo.save(ch);
	}
	//Component Mapping TEST
	@Test
	public void testCreated(){
		Employeemapping employeemapping=new Employeemapping();
		employeemapping.setId(1);
		employeemapping.setAge(23);
		employeemapping.setFirstName("Abhishek");
		employeemapping.setLastName("bhardwaj");
		Salarymapping salarymapping=new Salarymapping();
		salarymapping.setBasicSalary(30000);
		salarymapping.setBonusSalary(5000);
		salarymapping.setTaxAmount(4000);
		salarymapping.setSpecialAllowanceSalary(10000);
		employeemapping.setSalarymapping(salarymapping);
		componentMappingRepo.save(employeemapping);
	}
}
