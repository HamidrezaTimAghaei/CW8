package service;

import entity.Book;
import exeption.BookNotFoundException;
import repository.BookRepository;

public class BookService {

    BookRepository bookRepository = new BookRepository();

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void update(Book book) {
        bookRepository.update(book);
    }

    public void deleteBook(int id) {
        Book book = bookRepository.findById(id);
        if (book == null) {
            throw new BookNotFoundException("Book not found");
        }
        bookRepository.deleteById(id);
    }


}
