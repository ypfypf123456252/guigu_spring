package com.事务;

public interface BookShopDao {
    //根据书号获取书的单价
    public int findBookPriceByIsbn(String isbn);
    //更新书的库存
    public void updateBookStock(String isbn) throws Exception;
    //更新用户的账户余额:使username 的balance-price
    public void updateUserAccount(String username,int price) throws Exception;
}
