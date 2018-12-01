package ru.mirea.ksp_lab1_pet_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DBService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    DBService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    void init(){
        // init db инициализация базы данных
        //если создалась то не создавать заново
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS Item(id int NOT NULL ,name VARCHAR , type VARCHAR,count int)");
 //       jdbcTemplate.execute("CREATE TABLE Cart(int id,int user_id,int item_id, private boolean status)");
 //       jdbcTemplate.execute("CREATE TABLE Balance(int id,int user_id, float current_balance)");
        //наполняем базу тоже тут
        jdbcTemplate.execute("INSERT INTO Item( id, name,type,count) VALUES (1, 'dog', 'pet',4), ( 2,'cat', 'pet',3),( 3,'cat food', 'stuff',4),( 4,'dog food', 'stuff',3),");
    }
}
