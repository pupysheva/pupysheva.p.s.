package ru.mirea.ksp_lab1_pet_service.dao;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import ru.mirea.ksp_lab1_pet_service.ServiceElements.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Extractor implements ResultSetExtractor<List<Item>> {

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
}