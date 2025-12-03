package com.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.programs.entity.Emp;
import com.programs.entity.Employ;
import com.programs.entity.Employee;

public class EmpPrograms {

	public static void main(String[] args) {
		
// Emp is the POJO Class

		   List<Emp> emp = Arrays.asList(new Emp(1,"Ashok", "CSC", 98.0),
					new Emp(2, "Pavan", "EEE", 70.0),
					new Emp(3, "Hari", "MECH", 60.0),
					new Emp(4, "Varun", "CIVIL", 99.0),
					new Emp(5, "Pandu", "ECE", 85.0));

Map<String,Double> HighestPercen = emp.stream()
							.collect(Collectors.groupingBy(Emp::getDept, Collectors.mapping(Emp::getSalary, Collectors.maxBy(Comparator.naturalOrder()))))
							.entrySet()
							.stream()
							.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get()));

		System.out.println("Highest Percentage based on dept ::: "+HighestPercen); //Output : {CIVIL=99.0, CSC=98.0, EEE=70.0, ECE=85.0, MECH=60.0}
		
		Map<String,Emp> highest = emp.stream()
		.collect(Collectors.groupingBy(Emp::getDept, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Emp::getSalary)), em -> em.get())));

		highest.entrySet().forEach(System.out::println);
		//Output :   CIVIL=Emp [id=4, name=Varun, dept=CIVIL, salary=99.0]
					//CSC=Emp [id=1, name=Ashok, dept=CSC, salary=98.0]
					//EEE=Emp [id=2, name=Pavan, dept=EEE, salary=70.0]
					//ECE=Emp [id=5, name=Pandu, dept=ECE, salary=85.0]
					//MECH=Emp [id=3, name=Hari, dept=MECH, salary=60.0]
		
		System.out.println("To find the highest Salary based on department in employee class ::: "+highest);

		//Output : {CIVIL=Emp [id=4, name=Varun, dept=CIVIL, salary=99.0], 
				//	CSC=Emp [id=1, name=Ashok, dept=CSC, salary=98.0], 
				//	EEE=Emp [id=2, name=Pavan, dept=EEE, salary=70.0], 
				//	ECE=Emp [id=5, name=Pandu, dept=ECE, salary=85.0], 
				//	MECH=Emp [id=3, name=Hari, dept=MECH, salary=60.0]}

		Emp maxPercentage = emp.stream().max(Comparator.comparingDouble(Emp::getSalary)).get();
		
		System.out.println("To find the Highest percentage ::: "+maxPercentage); //Output : Emp [id=4, name=Varun, dept=CIVIL, salary=99.0]
		
		
		Emp minPercentage = emp.stream().min(Comparator.comparingDouble(Emp::getSalary)).get();
		
		System.out.println("To find the Lowest percentage ::: "+minPercentage);	 //Output : Emp [id=3, name=Hari, dept=MECH, salary=60.0]
		
		
		Emp findFirst = emp.stream().sorted(Comparator.comparingDouble(Emp::getSalary).reversed()).skip(2).findFirst().get();
		
		System.out.println("To find the 2nd highest percentage ::: "+findFirst);  //Output : Emp [id=5, name=Pandu, dept=ECE, salary=85.0]
 

		List<Integer> collect6 = emp.stream().filter(a -> a.getSalary()>70).map(Emp::getId).collect(Collectors.toList());
		
		System.out.println("To find the Employee Percentage/salary > 70 and based on the ID ::: "+collect6);  //Output : [1, 4, 5]


		List<Emp> collect13 = emp.stream().filter(a -> a.getSalary()==70).collect(Collectors.toList());
		
		collect13.forEach(ee -> System.out.println(ee.getName()));  //Output : Pavan
		
		System.out.println("TO find the salary is equal to 70 in a employee class using streams :: "+collect13);  //Output : [Emp [id=2, name=Pavan, dept=EEE, salary=70.0]]

		
		List<Emp> collect7 = emp.stream().sorted(Comparator.comparing(Emp::getName).thenComparing(Emp::getDept).thenComparingDouble(Emp::getSalary)).collect(Collectors.toList());
		
		System.out.println("Sorted employes based on name, age and salary :::: "+collect7);  //Output : [Emp [id=1, name=Ashok, dept=CSC, salary=98.0], Emp [id=3, name=Hari, dept=MECH, salary=60.0], Emp [id=5, name=Pandu, dept=ECE, salary=85.0], Emp [id=2, name=Pavan, dept=EEE, salary=70.0], Emp [id=4, name=Varun, dept=CIVIL, salary=99.0]]
		
		//collect7.forEach(System.out::println);
		

// Find the highest salary based on department in Employee class

			List <Employee> employees = Arrays.asList(
							new Employee("Alice", "HR", 70000),
							new Employee("Bob", "IT", 85000),
							new Employee("Charlie", "HR", 75000),
							new Employee("David", "IT", 90000),
							new Employee("Eve", "Finance", 60000),
							new Employee("Frank", "Finance", 62000)
							        );
		
		       Map<String, Optional<Employee>>highestPaidByDepartment
						= employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
															Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
																			));

				System.out.println("Highest paid employee in each department:");
				highestPaidByDepartment.forEach((department, employeeOptional) ->{ employeeOptional.ifPresent(employee ->
				System.out.println(department + ": " + employee.getName() + " (Salary: " + employee.getSalary() + ")")); });
										// Finance: Frank (Salary: 62000.0)
										// HR: Charlie (Salary: 75000.0)
										// IT: David (Salary: 90000.0)
		
// Employee with highest salary	with Optional 
		
		        List<Employ> employee = Arrays.asList(
									new Employ("Alice", 75000),
									new Employ("Bob", 90000),
									new Employ("Charlie", 60000),
									new Employ("David", 95000)
									   );
		
		    Optional<Employ> highestPaidEmployee = employee.stream().max(Comparator.comparingDouble(Employ::getSalary));

			if (highestPaidEmployee.isPresent()) {
			System.out.println("Employee with the highest salary: " + highestPaidEmployee.get()); // Employ [name=David, salary=95000.0]
			System.out.println("Highest salary: " + highestPaidEmployee.get().getSalary());  // 95000.0
			   } else {
			System.out.println("No employees found.");
			   }

	}

}
