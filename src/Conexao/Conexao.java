/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/** Script do MySQL
CREATE DATABASE IF NOT EXISTS auladb;
USE auladb;
CREATE TABLE IF NOT EXISTS `ficha` (
 `matricula` int(11) NOT NULL,
 `nome` varchar(50) NOT NULL,
 PRIMARY KEY (`matricula`)
);
INSERT INTO `ficha` (`matricula`, `nome`) VALUES
(1, 'Zeus'),
(2, 'Apolo'),
(3, 'Ares'),
(4, 'Poseidon');
**/
public class Conexao {
    
    public static Connection conectar (String nomeBanco) {
        try {
            String db_url = "jdbc:mysql://localhost/"+nomeBanco;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(db_url, "root", "");
            return con;
        } catch (Exception e){
            System.err.println("Erro: "+e.toString());
            e.printStackTrace();
            return null;
        }
    }
    
    
}
