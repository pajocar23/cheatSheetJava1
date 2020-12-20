/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.controller;

import java.util.List;
import rs.ac.bg.fon.ps.domain.User;

/**
 *
 * @author Mr OLOGIZ
 */
public class Controller {

    public static Controller instance;
    private int loginAttempts = 3;

    private User loggedUser; //za prikaz na main formi

    private Controller() {
        //inicijalizovanje memorijskih i database repozitorijuma
    }

    public static Controller getInstane() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
    
     public int getLoginAttempts() {
        return loginAttempts;
    }
    
    public void setLoginAttempts(int aLoginAttempts) {
        loginAttempts = aLoginAttempts;
    }
    
    /*public User logIn(String username, String password) throws Exception {
        List<User> useri = null;
        loginAttempts--;
        
        if (loginAttempts == 0) {
            throw new Exception("You used all login attempts");
        }
        
        
        repDbUser.connect();
        try {
            useri = repDbUser.getAll();
            for (User user : useri) {
                if (username.equals(user.getUsername())) {
                    if (password.equals(user.getPassword())) {
                        return user;
                    }
                    throw new Exception("Wrong password");
                }
            }
            throw new Exception("Username does not exist");
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            repDbUser.disconnect();
        }
        return user[];
    }*/
}
