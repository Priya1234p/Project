package in.ashokit;

import java.util.stream.Stream;

public class Employee {
	String name;
	int age;
	double salary;
	public Employee(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	public static void main(String[]args) {
		Employee e1 = new Employee("Ram",23,40000.00);
		Employee e2 = new Employee("gita",32,70000.00);
		Employee e3 = new Employee("sita",25,5000.00);
		Employee e4 = new Employee("wits",45,80000.00);
		Employee e5 = new Employee("geetas",20,2000.00);
		
		Stream<Employee> stream=Stream.of(e1,e2,e3,e4,e5);
		stream.filter(streams->streams.salary>=50000.00).map(streams->streams.name+"-"+streams.age).forEach(streams->System.out.println(streams));
	}
	
	

}
