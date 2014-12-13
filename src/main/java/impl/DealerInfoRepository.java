package impl;

import configuration.annotations.DealersDB;
import configuration.annotations.SentinelDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Alina_Tamkevich
 */
@Component
public class DealerInfoRepository {
    @Autowired
    @SentinelDB
    private JdbcTemplate sentinelJdbcTemplate;

    @Autowired
    @DealersDB
    private JdbcTemplate dealersJdbcTemplate;


    public void getAndSetDealersInformation () {
        String query = "select location_id, name, original_name from cdd2.location";
        final String queryInsert = "INSERT INTO cdd2.location(location_id, name, original_name) VALUES (?, ?, ?)";
        dealersJdbcTemplate.query(query, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                sentinelJdbcTemplate.update(queryInsert, resultSet.getInt("location_id"), resultSet.getString("name"), resultSet.getString("original_name"));
                return null;
            }
        });
    }
    public void getAndSetDealerContact() {
        String query = "select contact_id, email, contact_type from cdd2.contact";
        final String insertQuery = "insert into cdd2.contact(contact_id, email) VALUES (?, ?)";
        dealersJdbcTemplate.query(query, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                sentinelJdbcTemplate.update(insertQuery, resultSet.getInt("contact_id"), resultSet.getString("email"));
                return null;
            }
        });
    }

    public void getAndSetDealerAddress() {
        String query = "select address_id, state, zip, city from cdd2.address";
        final String insertQuery = "insert into cdd2.address(address_id, state, zip, city) VALUES (?, ?, ?)";
        dealersJdbcTemplate.query(query, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                sentinelJdbcTemplate.update(insertQuery, resultSet.getInt("address_id"), resultSet.getString("state"), resultSet.getString("zip"), resultSet.getString("zip"));
                return null;
            }
        });
    }
    public void getAndSetLocationAddressMap() {
        String query = "select location_id, address_id, id  from cdd2.location_address_map";
        final String insertQuery = "insert into cdd2.location_address_map(location_id, address_id, id) VALUES (?, ?, ?)";
        dealersJdbcTemplate.query(query, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                sentinelJdbcTemplate.update(insertQuery, resultSet.getInt("location_id"), resultSet.getInt("address_id"), resultSet.getInt("id"));
                return null;
            }
        });
    }

    public void getAndSetLocationContactMap() {
        String query = "select location_id, contact_id, id  from cdd2.location_contact_map";
        final String insertQuery = "insert into cdd2.location_contact_map(location_id, contact_id, id) VALUES (?, ?, ?)";
        dealersJdbcTemplate.query(query, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                sentinelJdbcTemplate.update(insertQuery, resultSet.getInt("location_id"), resultSet.getInt("contact_id"), resultSet.getInt("id"));
                return null;
            }
        });
    }

    public void getAndSetContactType() {
        String query = "select contact_type_id, name from cdd2.contact_type";
        final String insertQuery = "insert into cdd2.contact_type(contact_type_id, name) VALUES (?, ?)";
        dealersJdbcTemplate.query(query, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                sentinelJdbcTemplate.update(insertQuery, resultSet.getInt("contact_type_id"), resultSet.getString("name"));
                return null;
            }
        });
    }

}
