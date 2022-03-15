package dao;

public class DaoFactory {

    public ArticleDao articleDao() {
        return new ArticleDao(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        return new WooWahanArticleDao();
    }
}
