package com.事务xml形式;

import java.util.List;

public class CashierImpl implements Cashier {

    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkout(String username, List<String> isbns) throws Exception {
        for (String isbn:isbns){
            bookShopService.purchase(username,isbn);
        }
    }
}
