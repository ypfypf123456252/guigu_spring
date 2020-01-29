package com.事务xml形式;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookShopDaoImpl implements BookShopDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql="select price from book where isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    @Override
    public void updateBookStock(String isbn) throws Exception {
        //检查书的库存是否足够,若不够,则抛出异常
        String sql1="select stock from book_stock where isbn=?";
        int stock=jdbcTemplate.queryForObject(sql1,Integer.class,isbn);
        if (stock==0){
            throw new RuntimeException("库存不足");
        }
        String sql2="update book_stock set stock=stock-1 where isbn=?";
        jdbcTemplate.update(sql2,isbn);
    }

    @Override
    public void updateUserAccount(String username, int price) throws Exception {
        String sql1="select balance from account where username=?";
        int balance=jdbcTemplate.queryForObject(sql1,Integer.class,username);
        if (balance<price){
            throw new RuntimeException("余额不足");
        }
        String sql2="update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql2,price,username);
    }
}
