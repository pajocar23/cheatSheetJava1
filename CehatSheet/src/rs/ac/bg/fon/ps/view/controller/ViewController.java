/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.controller;

import java.awt.Frame;
import rs.ac.bg.fon.ps.view.form.FrmLogIn;
import rs.ac.bg.fon.ps.view.form.FrmMain;

/**
 *
 * @author Mr OLOGIZ
 */
public class ViewController {

    private static ViewController instance;
    private FrmLogIn frmLogin;
    private FrmMain frmMain;

    private ViewController() {

    }

    public static ViewController getInstance() {
        if (instance == null) {
            instance = new ViewController();
        }
        return instance;
    }
    
    
     public void startApp(){
        frmLogin=new FrmLogIn();
        frmLogin.setTitle("Log in");
        frmLogin.setVisible(true);
        frmLogin.setLocationRelativeTo(null);
    }
    
    public void openMainFrm(){
        frmMain=new FrmMain();
        frmMain.setTitle("Main form");
        frmMain.setVisible(true);
        frmMain.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}
