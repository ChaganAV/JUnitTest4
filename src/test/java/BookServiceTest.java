import com.example.model.Book;
import com.example.repository.BookRepository;
import com.example.services.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class BookServiceTest {
    /**
     * mock заглушка на репозиторий
     */
    BookRepository booksRepoMock = mock(BookRepository.class);

    /**
     * используем при создании service заглушку mock на репозиторий
      */
    BookService bookService = new BookService(booksRepoMock);

    /**
     * проверка метод findById сервиса BookService
     */
    @Test
    public void BookFindByIdTest(){
        // act
        when(booksRepoMock.findById("1")).thenReturn(new Book("1","book1","Jon"));
        Book book = bookService.findBookById("1");
        System.out.println(book);
        // assert
        assertEquals("book1",book.getTitle());
    }

    @Test
    public void BookAllTest(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("1","book1","Jon"));
        books.add(new Book("2","book2","Bob"));
        when(booksRepoMock.findAll()).thenReturn(books);
        List<Book> booksTest = bookService.findAllBooks();
        assertEquals(booksTest,books);
        verify(booksRepoMock).findAll();
    }
}
