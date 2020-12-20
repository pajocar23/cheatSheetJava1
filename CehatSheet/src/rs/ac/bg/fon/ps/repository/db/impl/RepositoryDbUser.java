/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ps.domain.User;
import rs.ac.bg.fon.ps.repository.db.DbConnectionFactory;
import rs.ac.bg.fon.ps.repository.db.IdbRepository;

/**
 *
 * @author Mr OLOGIZ
 */
public class RepositoryDbUser implements IdbRepository<User, Long> {

    @Override
    public void insert(User t) throws Exception {
        try {
            String query = "INSERT into user(id,name) VALUES (?,?)";
            System.out.println(query);
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, t.getId());
            statement.setString(2, t.getName());
            //statement.setDate(3, new java.sql.Date(t.getDatumPolaganja().getTime()));  --->ovako se ubacuje datum u sql

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("insert user error");
        }
    }

    @Override
    public void delete(User t) throws Exception {
        try {
            String query = "DELETE FROM users"
                    + " WHERE id=" + t.getId().toString();
            System.out.println(query);

            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Delete user error. \n" + e.getMessage());
        }
    }

    @Override
    public void update(User t, Long k) throws Exception {
        try {
            String query = "UPDATE user SET id=" + t.getId()
                    + ",name=" + t.getName() + " WHERE id=" + k;
            System.out.println(query);
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Update user error");
        }
    }

    @Override
    public User get(Long k) throws Exception {
        return new User(); //ova metoda nam ne treba, jer cemo svakako u kontroleru preko get all traziti tog jednog iz liste
    }

    @Override
    public List<User> getAll() throws Exception {
        try {
            String query = "SELECT id,name FROM user";
            System.out.println(query);
            List<User> users = new ArrayList<>();
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                User u = new User(rs.getLong("id"),rs.getString("name"));

                users.add(u);
            }

            statement.close();
            rs.close();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error in getting all Users");
        }
    }

}
