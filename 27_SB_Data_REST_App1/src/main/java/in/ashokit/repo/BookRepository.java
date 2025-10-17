package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import in.ashokit.entity.Book;


//http://localhost:8080/books


@RepositoryRestResource(path="books")
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	//http://localhost:8080/books/search/findByNameContaining?name=ng
	
	public List<Book> findByNameContaining(@Param("name") String name);
}
