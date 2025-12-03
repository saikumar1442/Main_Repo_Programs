package com.ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaEmployeePrograms {

	public static void main(String[] args) {
		
		
		
		// Below code is the example of Immutable class

		// public final class ImmutaClass{
		//
		// priavte final String name;
		// private final int age;
		//
		// public ImmutaClass(String name, int age){
		// this.name = name;
		// this.age = age;
		// }
		//
		// public String getName(){
		// return name;
		// }
		//
		// public int getAge(){
		// return age;
		// }
		//
		// }
		
		
		
		
		// Emp is the POJO Class
		
		
		   List<Emp> emp = Arrays.asList(new Emp(1,"Ashok", "CSC", 98.0),
											new Emp(2, "Pavan", "EEE", 70.0),
											new Emp(3, "Hari", "MECH", 60.0),
											new Emp(4, "Varun", "CIVIL", 99.0),
											new Emp(5, "Pandu", "ECE", 85.0));

// Find the Highest Salary based on department in  Employee Class
		   
Map<String,Double> HighestPercen = emp.stream()
							.collect(Collectors.groupingBy(Emp::getDept, Collectors.mapping(Emp::getsalary, Collectors.maxBy(Comparator.naturalOrder()))))
							.entrySet()
							.stream()
							.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get()));

System.out.println("Highest Percentage based on dept ::: "+HighestPercen); //Output : {CIVIL=99.0, CSC=98.0, EEE=70.0, ECE=85.0, MECH=60.0}



Map<String,Emp> highest = emp.stream()
.collect(Collectors.groupingBy(Emp::getDept, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Emp::getsalary)), em -> em.get())));

highest.entrySet().forEach(System.out::println);

//Output : CIVIL=Emp [id=4, name=Varun, dept=CIVIL, salary=99.0]
//CSC=Emp [id=1, name=Ashok, dept=CSC, salary=98.0]
//EEE=Emp [id=2, name=Pavan, dept=EEE, salary=70.0]
//ECE=Emp [id=5, name=Pandu, dept=ECE, salary=85.0]
//MECH=Emp [id=3, name=Hari, dept=MECH, salary=60.0]

System.out.println("To find the highest Salary based on department in employee class ::: "+highest);

//Output : {CIVIL=Emp [id=4, name=Varun, dept=CIVIL, salary=99.0], 
//			CSC=Emp [id=1, name=Ashok, dept=CSC, salary=98.0], 
//					EEE=Emp [id=2, name=Pavan, dept=EEE, salary=70.0], 
//					ECE=Emp [id=5, name=Pandu, dept=ECE, salary=85.0], 
//					MECH=Emp [id=3, name=Hari, dept=MECH, salary=60.0]}







Emp maxPercentage = emp.stream().max(Comparator.comparingDouble(Emp::getsalary)).get();

System.out.println("To find the Highest percentage ::: "+maxPercentage); //Output : Emp [id=4, name=Varun, dept=CIVIL, salary=99.0]

Emp minPercentage = emp.stream().min(Comparator.comparingDouble(Emp::getsalary)).get();

System.out.println("To find the Lowest percentage ::: "+minPercentage);	 //Output : Emp [id=3, name=Hari, dept=MECH, salary=60.0]

Emp findFirst = emp.stream().sorted(Comparator.comparingDouble(Emp::getsalary).reversed()).skip(1).findFirst().get();

System.out.println("To find the 2nd highest percentage ::: "+findFirst);  //Output : Emp [id=5, name=Pandu, dept=ECE, salary=85.0]
 


List<Integer> collect6 = emp.stream().filter(a -> a.getsalary()>70).map(Emp::getId).collect(Collectors.toList());

System.out.println("To find the Employee Percentage/salary > 70 and based on the ID ::: "+collect6);  //Output : [1, 4, 5]



List<Emp> collect13 = emp.stream().filter(a -> a.getsalary()==70).collect(Collectors.toList());

collect13.forEach(ee -> System.out.println(ee.getName()));  //Output : Pavan

System.out.println("TO find the salary is equal to 70 in a employee class using streams :: "+collect13);  //Output : [Emp [id=2, name=Pavan, dept=EEE, salary=70.0]]




List<Emp> collect7 = emp.stream().sorted(Comparator.comparing(Emp::getName).thenComparing(Emp::getDept).thenComparingDouble(Emp::getsalary)).collect(Collectors.toList());

System.out.println("Sorted employes based on name, dept and salary :::: "+collect7);  //Output : [Emp [id=1, name=Ashok, dept=CSC, salary=98.0], Emp [id=3, name=Hari, dept=MECH, salary=60.0], Emp [id=5, name=Pandu, dept=ECE, salary=85.0], Emp [id=2, name=Pavan, dept=EEE, salary=70.0], Emp [id=4, name=Varun, dept=CIVIL, salary=99.0]]

//collect7.forEach(System.out::println);



// SQL






	}

}
