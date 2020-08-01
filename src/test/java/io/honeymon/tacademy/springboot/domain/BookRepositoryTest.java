package io.honeymon.tacademy.springboot.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	BookRepository repository;
	 
	@Test
	public void testSave() {
		Book book = new Book();
		book.setName("boot-spring-book");
		book.setIsbn10("0123456789");
		book.setIsbn13("012345678912");
		
		assertThat(book.isNew()).isTrue();
		
		repository.save(book);
		
		assertThat(book.isNew()).isFalse();
	}
	@Test
	public void testFindByNameLike() {
		Book book = new Book();
		book.setName("boot-spring-book");
		book.setIsbn10("0123456789");
		book.setIsbn13("012345678912");
		
		repository.save(book);
		
		List<Book> books = repository.findByNameLike("boot-spring-%");
		assertThat(books).isNotEmpty();
		
		books = repository.findByNameLike("book");
		assertThat(books).isEmpty();
		
		
	}
}
