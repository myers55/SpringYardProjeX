package com.example.customer.Repository;

import com.example.customer.Model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomersRepositoryimpl implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_SQL = "INSERT INTO persons (firstName, lastName) VALUES (?,?)";

    @Override
    public void add(Customers customers) {
        jdbcTemplate.update(INSERT_SQL, customers.getFirstName(), customers.getLastName());
    }

    private final String SELECT_BY_ID_SQL = "select * from persons where id = ?";

    @Override
    public Customers getById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new CustomersMapper(), id);
    }

    private final String SELECT_SQL = "select * from persons";

    @Override
    public List<Customers> get() {
        return jdbcTemplate.query(SELECT_SQL, new CustomersMapper());
    }

    private final String UPDATE_SQL = "update persons set firstName=?, lastName=? where id=?";

    @Override
    public void update(Customers customers) {
        jdbcTemplate.update(UPDATE_SQL, customers.getFirstName(), customers.getLastName(), customers.getId());
    }

    private final String DELETE_SQL = "delete from persons where id=?";

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

    @Override
    public void deleteAll(List<Integer> ids) {
        for (int id : ids) {
            delete(id);
        }
    }

    private static class CustomersMapper implements RowMapper<Customers> {
        @Override
        public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customers customers = new Customers();
            customers.setId(rs.getInt("id"));
            customers.setFirstName(rs.getString("firstName"));
            customers.setLastName(rs.getString("lastName"));
            return customers;
        }
    }
}