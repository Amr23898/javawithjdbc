/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawithjdbc.controler;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javawithjdbc.model.User;

/**
 *
 * @author ElAbd
 */
public class Userconnection {
    
    Statement state;
    public void insert(User us){
        try {
            state = (Statement) DBConection.getconnection().createStatement();
            state.executeUpdate("insert into user_table (u_name,u_age,u_year) values ('"+us.getName()+"',"+us.getAge()+" ,"+us.getYear()+")");
        } catch (SQLException ex) {
            Logger.getLogger(Userconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(User us){
        try {
            state = (Statement) DBConection.getconnection().createStatement();
            state.executeUpdate("update user_table set u_name = '"+us.getName()+"',u_age="+us.getAge()+",u_year="+us.getYear()+" where u_id = "+us.getId()+"");
        } catch (SQLException ex) {
            Logger.getLogger(Userconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(int id){
        try {
            state = (Statement) DBConection.getconnection().createStatement();
            state.executeUpdate
        ("delete from user_table where u_id = "+id+"");
        } catch (SQLException ex) {
            Logger.getLogger(Userconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public ObservableList<User> getalluser(){
        ObservableList<User> users= FXCollections.observableArrayList();
        try {
            state= (Statement) DBConection.getconnection().createStatement();
            ResultSet result=state.executeQuery("select * from user_table");
            result.beforeFirst();
            while(result.next()){
                User user=new User();
                user.setId(result.getInt(1));
                user.setName(result.getString(2));
                user.setAge(result.getInt(3)); 
                user.setYear(result.getInt(4));
                users.add(user);
        
            }
        } catch (SQLException ex) {
            Logger.getLogger(Userconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

       public ObservableList<User> search( int id){
        ObservableList<User> users= FXCollections.observableArrayList();
        try {
            state= (Statement) DBConection.getconnection().createStatement();
            ResultSet result=state.executeQuery("select * from user_table where u_id = "+id+"");
            result.beforeFirst();
            while(result.next()){
                User user=new User();
                user.setId(result.getInt(1));
                user.setName(result.getString(2));
                user.setAge(result.getInt(3)); 
                user.setYear(result.getInt(4));
                users.add(user);
        
            }
        } catch (SQLException ex) {
            Logger.getLogger(Userconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
}
