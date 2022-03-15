package dao;

import domain.Article;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * Ver 1_1 문제점
 *      1. 중복코드가 너무 많다. (Driver 가져오기, DB 커넥션 연결)
 *      2. main에서 테스트를 진행하고 있다.
 */
public class ArticleDao {

    public void add(Article article) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/toby_spring", "sa", "");

        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO article(id, writer, title, contents, created_time, updated_time) " +
                                                            "VALUES (?, ?, ?, ?, ?, ?) ");

        pstmt.setLong(1, article.getId());
        pstmt.setString(2, article.getWriter());
        pstmt.setString(3, article.getTitle());
        pstmt.setString(4, article.getContents());
        pstmt.setObject(5, article.getCreatedTime());
        pstmt.setObject(6, article.getUpdatedTime());

        pstmt.executeUpdate();

        pstmt.close();
        conn.close();
    }

    public Article get(Long id) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/toby_spring", "sa", "");

        PreparedStatement pstmt = conn.prepareStatement("SELECT * " +
                                                            "FROM article " +
                                                            "WHERE id = ?");
        pstmt.setLong(1, id);

        ResultSet rs = pstmt.executeQuery();
        rs.next();
        Article article = new Article();
        article.setId(rs.getLong("id"));
        article.setWriter(rs.getString("writer"));
        article.setTitle(rs.getString("title"));
        article.setContents(rs.getString("contents"));
        article.setCreatedTime((LocalDateTime)rs.getObject("created_time"));
        article.setUpdatedTime((LocalDateTime)rs.getObject("updated_time"));

        rs.close();
        pstmt.close();
        conn.close();

        return article;
    }
}
