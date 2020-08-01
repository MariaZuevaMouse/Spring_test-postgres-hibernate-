package com.company.mz.mortgage.repository;

import com.company.mz.mortgage.MortgageApp;
import com.company.mz.mortgage.entity.MortgageApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MortgageManualRepository {
    EntityManager manager;

    public MortgageManualRepository(EntityManager manager) {
        this.manager = manager;
    }
    public List<MortgageApplication> getAllSuccessful(){
        Query nativeQuery = manager.createNativeQuery(
                "SELECT * FROM mortgage_application WHERE resolution = 0", MortgageApplication.class
        );
        List<MortgageApplication> resultList = nativeQuery.getResultList();
        return resultList;
    }
}

// 4) spring auto query filling (Spring Data JPA) (ManualRepositoryClass)
// 3) spring data / entity manager
// 2) jdbc template approach
/*
* JdbcTemplate jdbcTemplate;

    public MortgageManualRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MortgageApplication> getAllSuccessful(){
        List<MortgageApplication> mortgageApplicationsList = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM mortgage_application WHERE status = 0", new RowMapper<MortgageApplication>() {
            @Override
            public MortgageApplication mapRow(ResultSet resultSet, int i) throws SQLException {
                MortgageApplication mortgageApplication = new MortgageApplication();
                mortgageApplication.setId((resultSet.getLong(1)));
                mortgageApplicationsList.add(mortgageApplication);
                return mortgageApplication;
            }
        });
        return mortgageApplicationsList;
    }
    * */

// 1) old approach
/*
    DataSource dataSource;

    public MortgageManualRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<MortgageApplication> getAllSuccessful() {
        Connection connection = null;
        List<MortgageApplication> successList = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mortgage_application WHERE status = 0");
            while (resultSet.next()){
                MortgageApplication application = new MortgageApplication();
                application.setId(resultSet.getLong(1));
                application.setName(resultSet.getString(2));
                successList.add(application);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return successList;
    }
* */
// 0) long method using stream in Controller
