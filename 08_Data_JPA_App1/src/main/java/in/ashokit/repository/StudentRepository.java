package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.Student;
import jakarta.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("delete from Student where id= :sid")
	@Modifying
	@Transactional
	public void deleteStudent(Integer sid);
	
	@Query("update Student set gender = :gender where id= :sid")
	@Modifying
	@Transactional
	public void updateStudent(Integer sid, String gender);
	
	  @Query(value="insert into STUDENT_DTLS(student_id, student_name, student_gender) values (:id,:name,:gender)", nativeQuery=true)
	  @Modifying
	  @Transactional 
	  public void insertStudent(Integer id, String name, String gender);
	 
	/*
	 * @Query(value="select * from STUDENT_DTLS", nativeQuery= true) public List
	 * <Student> getAllStudents();
	 * 
	 * @Query("from Student") public List <Student> getStudents();
	 */

	
	/*
	 * public List<Student>findByGender(String gender);
	 * 
	 * public List<Student>findByRankGreaterThanEqual(Long rank); public
	 * List<Student>findByRankLessThanEqual(Long rank);
	 * 
	 * public List<Student>findByGenderAndRankGreaterThanEqual(String gender,Long
	 * rank);
	 * 
	 */
	 

}
