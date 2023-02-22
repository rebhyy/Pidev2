/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Personne;
import entite.User;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author wiemhjiri
 */
public class ServicePersonne implements IService<Personne> {

    private Connection conn;

    public ServicePersonne() {
        conn = DataSource.getInstance().getCnx();
    }

    @Override
    public void insert(Personne t) {
        String requete = "insert into personne (nom,prenom,age) values "
                + "('" + t.getNom() + "','" + t.getPrenom() + "'," + t.getAge() + ")";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ServicePersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public void insertPst(User user) {
    try  {
        conn.setAutoCommit(false); // start transaction

        // Insert new user and role
        String query = "INSERT INTO user (firstName, lastName, phoneNumber, email, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setInt(3, user.getPhoneNumber());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPassword());
        statement.setString(6, user.getRole());
        int rows = statement.executeUpdate();
        if (rows != 1) {
            throw new SQLException  ("User and role insert failed");
        }

        // Get the generated id for the user
        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            int userId = generatedKeys.getInt(1);

            // Insert new role for user
            String roleQuery = "INSERT INTO role (role, user_id) VALUES (?, ?)";
            PreparedStatement roleStatement = conn.prepareStatement(roleQuery);
            roleStatement.setString(1, user.getRole());
            roleStatement.setInt(2, userId);
            int roleRows = roleStatement.executeUpdate();
            if (roleRows != 1) {
                throw new SQLException("Role insert failed");
            }
        } else {
            throw new SQLException("User insert failed to return ID");
        }

        conn.commit(); // end transaction

    } catch (SQLException e) {
        System.err.println("Error inserting new user and role: " + e.getMessage());
        try {
            conn.rollback(); // undo changes
        } catch (SQLException ex) {
            System.err.println("Error rolling back transaction: " + ex.getMessage());
        }
    }
}


    @Override
    public void delete(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Personne> readAll() {
            List<Personne> list=new ArrayList<>();
            String requete="select * from personne";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(requete);
            while(rs.next()){
                Personne p=new Personne(rs.getInt("id"), rs.getString(2),
                        rs.getString("prenom"), rs.getInt("age"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ServicePersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;          
    }

    @Override
    public Personne readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
