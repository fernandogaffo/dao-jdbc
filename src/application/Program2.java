package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println("=== TEST 2: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 3: Department insert ===");
		Department newDepartment = new Department(null, "Cellphones");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("=== TEST 4: Department update ===");
		dep = departmentDao.findById(1);
		dep.setName("Axes");
		departmentDao.update(dep);
		System.out.println("Update complete.");
		
		System.out.println("=== TEST 5: Department delte ===");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the department Id to delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deletion complete.");
		sc.close();
	}

}
