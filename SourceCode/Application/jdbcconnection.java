/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.sql.Connection;

/**
 *
 * @author dhruv
 */
abstract class jdbcconnection  {
    
    abstract public  Connection getConnection(String database, String user, String password);
    
}
