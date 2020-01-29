package com.事务xml形式;

public class BookShopServiceImpl implements BookShopService {
    private BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    @Override
    public void purchase(String username, String isbn) throws Exception {
        //1.获取书的单价
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        //2.跟新书的库存
        bookShopDao.updateBookStock(isbn);
        //3.跟新用户余额
        bookShopDao.updateUserAccount(username,price);
    }
}
