package repository;

import config.DataBaseConnection;
import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public void save(Book book) {
        String sql = "insert into books (title ,author ,isbn) values (?,?,?)";

        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getIsbn());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void update(Book book) {
        String sql = "update books Set title = ? ,author=? ,isbn=?  Where book_id=?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getIsbn());
            statement.setInt(4, book.getBookId());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Book findById(int id) {
        String sql = " select * from books where book_id=?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Book(resultSet.getInt("bookId"), resultSet.getString("title"),
                        resultSet.getString("author"), resultSet.getString("isbn"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return null;
    }

    public List<Book> findAll() {
        String sql = "select * from Books";
        List<Book> books = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt("bookId"), resultSet.getString("title"),
                        resultSet.getString("author"), resultSet.getString("isbn")));
            }
            return books;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id){
        String sql="delete from books where book_id=?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

    }




}