/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.view.components.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ps.domain.User;

/**
 *
 * @author Mr OLOGIZ
 */
public class UserTableModel extends AbstractTableModel {

    private List<User> users;

    private String[] columnNames = new String[]{"id", "name"};
    private Class[] columnClasses = new Class[]{Long.class, String.class};

    public UserTableModel(List<User> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        if (users == null) {
            return 0;
        }
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex > columnClasses.length) {
            return null;
        }
        return columnClasses[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getId();
            case 1:
                return user.getName();
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        if (column > columnNames.length) {
            return "n/a";
        }
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                user.setId((Long)value);
                break;
            case 1:
                user.setName(String.valueOf(value));
                break;
        }
    }
    
    public void insertUser(User u){
        this.users.add(u);      //ovo dodaje na model
        //Controller.getInstance().insertUser();    //ovo dodaje u bazu
        fireTableRowsInserted(users.size()-1, users.size()-1);       
    }
    
    public User deleteUser(int row){
        User u=users.remove(row);
        fireTableRowsDeleted(row, row);
        return u;
    }
    
    public User getUserAt(int index){
        return users.get(index);
    }
    
    public void refreshUsers(){
        fireTableDataChanged();
    }

}
