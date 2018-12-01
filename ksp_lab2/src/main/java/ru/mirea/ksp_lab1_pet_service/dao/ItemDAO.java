package ru.mirea.ksp_lab1_pet_service.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import ru.mirea.ksp_lab1_pet_service.ServiceElements.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ItemDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Item> getAll() {
        //return jdbcTemplate.query("select * from Item", new Extractor());
        /*return jdbcTemplate.query("select * from Item", new ResultSetExtractor<List<Item>>() {
            @Override
            public List<Item> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Item> out = new ArrayList<>();
                while(rs.next()) {
                    out.add(new Item(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("type"),
                            rs.getInt("count"))
                    );
                }
                return out;
            }
        });*/
        return jdbcTemplate.query("select * from Item", (ResultSet rs) ->
        {
            List<Item> out = new ArrayList<>();
            while(rs.next()) {
                out.add(new Item(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getInt("count"))
                );
            }
            return out;
        });
    }
}
