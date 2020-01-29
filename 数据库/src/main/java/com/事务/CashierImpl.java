package com.事务;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    //添加事务注解
    @Transactional
    @Override
    public void checkout(String username, List<String> isbns) throws Exception {
        for (String isbn:isbns){
            bookShopService.purchase(username,isbn);
        }
    }
}
