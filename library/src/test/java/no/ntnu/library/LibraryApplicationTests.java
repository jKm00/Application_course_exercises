package no.ntnu.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.ntnu.library.model.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class LibraryApplicationTests {

	/**
	 * Used for simulating API endpoint requests and analyzing item
	 */
	@Autowired
	MockMvc mvc;

	/**
	 * Used for converting Book <-> JSON string
	 */
	@Autowired
	ObjectMapper objectMapper;

	/**
	 * Checks if the application starts running with no problem
	 */
	@Test
	void contextLoads() {
	}

	/**
	 * Test that the book/count returns 200 OK and the correct
	 * number of books
	 */
	@Test
	void bookCount() throws Exception {
		mvc.perform(get("/books/count"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("4")));
	}

	/**
	 * Test that trying to fetch a book that is not in the register
	 * will result in 404 NOT FOUND
	 */
	@Test
	void getNoneExistingBook() throws Exception {
		mvc.perform(get("/books/883"))
				.andExpect(status().isNotFound());
	}

	/**
	 * Test that trying to fetch a book in the register returns 200 OK
	 * and the correct book object.
	 */
	@Test
	void getValidBook() throws Exception {
		String responseJson = mvc.perform(get("/books/1"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		Book book = objectMapper.readValue(responseJson, Book.class);

		assertThat(book.getTitle()).isEqualTo("The Nordic Theory");
		assertThat(book.getYear()).isEqualTo(2019);
	}

	/**
	 * Test trying to delete book that is not in the register
	 * returns code 404 NOT FOUND
	 */
	@Test
	void deleteNoneExistingBook() throws Exception {
		mvc.perform(delete("/books/883"))
				.andExpect(status().isNotFound());
	}

	@Test
	void taskE() throws Exception {
		// 1. Check book count
		mvc.perform(get("/books/count"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("4")));

		// 2. Check book with id = 1
		String responseJson = mvc.perform(get("/books/1"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		Book book = objectMapper.readValue(responseJson, Book.class);

		assertThat(book.getTitle()).isEqualTo("The Nordic Theory");
		assertThat(book.getYear()).isEqualTo(2019);

		// 3. Remove book with id = 1
		mvc.perform(delete("/books/1"))
				.andExpect(status().isOk());

		// 4. Check book with id = 1 (should be deleted and therefor not found)
		mvc.perform(get("/books/1"))
				.andExpect(status().isNotFound());

		// 5. Check book count after deletion
		mvc.perform(get("/books/count"))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("3")));

		// 6. Add a new book
		String jsonString = objectMapper.writeValueAsString(new Book(1, "Network", 2015, 473));
		mvc.perform(post("/books")
				.content(jsonString)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		// 7. Check that book with id = 1 is the one that was just added
		responseJson = mvc.perform(get("/books/1"))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		book = objectMapper.readValue(responseJson, Book.class);

		assertThat(book.getTitle()).isEqualTo("Network");
		assertThat(book.getYear()).isEqualTo(2015);
	}

}
