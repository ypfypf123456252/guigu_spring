package com.事务xml形式;

import java.util.List;

public interface Cashier {
    public void checkout(String username, List<String> isbns) throws Exception;
}
