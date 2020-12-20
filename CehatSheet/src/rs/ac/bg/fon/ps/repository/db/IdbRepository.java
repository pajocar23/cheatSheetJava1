/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.repository.db;

import rs.ac.bg.fon.ps.repository.IRepository;

/**
 *
 * @author Mr OLOGIZ
 */
public interface IdbRepository<T, K> extends IRepository<T, K>{

    @Override
    public default void connect() throws Exception {
        DbConnectionFactory.getInstance().getConnection();
    }

    @Override
    public default void disconnect() throws Exception {
         DbConnectionFactory.getInstance().getConnection().close();
    }
    
    
}
