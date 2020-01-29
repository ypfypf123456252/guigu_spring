package com.事务;

import java.util.List;

public interface Cashier {
    public void checkout(String username, List<String> isbns) throws Exception;
}
