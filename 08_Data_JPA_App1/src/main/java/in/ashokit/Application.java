package in.ashokit;


import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import in.ashokit.entity.Student;
import in.ashokit.repository.StudentRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		Student s = new Student(1, "Raja", 111l, "Male");
		studentRepository.save(s);
		System.out.println("Saved.......");
		/*
		 * studentRepository.insertStudent(107, "veer", "Male");
		 * System.out.println("inserted.......");
		 */
		
		/*
		 * studentRepository.updateStudent(106, "Male");
		 */
		/*
		 * studentRepository.deleteStudent(105); System.out.println("deleted.......");
		 */
		
		/*
		 * Student s = new Student(); s.setGender("Male");
		 * 
		 * Example<Student> example = Example.of(s); List<Student> Students =
		 * studentRepository.findAll(example); Students.forEach(System.out::println);
		 */
		/*
		 * List<Student> Students = studentRepository.findAll(Sort.by("gender"));
		 * Students.forEach(System.out::println);
		 */
		/*
		 * Iterable<Student> all = studentRepository.findAll();
		 * all.forEach(System.out::println);
		 * 
		 * Scanner sc = new Scanner(System.in); System.out.println("Enter page no: ");
		 * int pageNo = sc.nextInt(); int paggeSize =3;
		 * 
		 * PageRequest page = PageRequest.of(pageNo, paggeSize); Page<Student>findAll=
		 * studentRepository.findAll(page); List<Student> Students =
		 * findAll.getContent(); Students.forEach(System.out::println);
		 */
		
		/*
		 * List<Student> Students = studentRepository.getStudents();
		 * Students.forEach(System.out::println);
		 */
		/*
		 * List<Student> Students = studentRepository.getAllStudents();
		 * Students.forEach(System.out::println);
		 */
		/*
		 * List<Student> Students = studentRepository.findByRankGreaterThanEqual(100l);
		 * Students.forEach(System.out::println);
		 */
		
		/*
		 * List<Student> MaleStudents = studentRepository.findByGender("Male");
		 * MaleStudents.forEach(System.out::println);
		 */
		
		/*
		 * Student s1=new Student(103, "sita", 90l, "FeMale"); Student s2=new
		 * Student(104, "dim", 91l, "Male"); Student s3=new Student(105, "diya", 92l,
		 * "Female"); Student s4=new Student(106, "siya", 93l, "female");
		 * 
		 * List<Student> Students = Arrays.asList(s1,s2,s3,s4);
		 * studentRepository.saveAll(Students);
		 */
		
		/*
		 * Student s= new Student(); s.setId(103); s.setName("Shita"); s.setRank(234l);
		 * s.setGender("FeMale");
		 * 
		 * studentRepository.save(s); System.out.println("Record is Saved.....");
		 */
		
		/*
		 * Optional<Student> optional = studentRepository.findById(101);
		 * 
		 * if(optional.isPresent()) { System.out.println(optional.get()); }
		 */
		
		/*
		 * // IT Basically print all record in consol Iterable<Student> findAll =
		 * studentRepository.findAll(); findAll.forEach(System.out::println);
		 * 
		 * 
		 */
		/*
		 * studentRepository.deleteById(103);
		 * System.out.println("Record is deleted.......");
		 */
		
		/*
		 * if(studentRepository.existsById(503)) { studentRepository.deleteById(503);
		 * System.out.println("Record is deleted......."); }else {
		 * System.out.println("no Record is not deleted......."); }
		 */
		/*
		 * long count = studentRepository.count(); System.out.println("record count:"+
		 * count);
		 */
		

	}

}
