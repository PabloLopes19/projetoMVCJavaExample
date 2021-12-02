/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Conexao.Conexao;
import DTO.fichaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class fichaDAO {
    final String NOMEBANCO = "auladb";
    final String NOMETABELA = "ficha";
    
    public boolean existe(fichaDTO ficha){
        try{
            Connection conn = Conexao.conectar(NOMEBANCO);
            String sql = "SELECT * FROM "+NOMETABELA+" WHERE MATRICULA = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ficha.getMatricula());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e){
            System.err.println("Erro: "+e.toString());
            e.printStackTrace();
            return false;
        }  
        return false;
    }
    
    public boolean inserir(fichaDTO ficha){
        if (existe(ficha) != true){
            try{
                Connection conn = Conexao.conectar(NOMEBANCO);
                String sql = "INSERT INTO "+NOMETABELA+" (matricula, nome) values (?,?);";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, ficha.getMatricula());
                ps.setString(2, ficha.getNome());
                ps.execute();
                ps.close();
                conn.close();
                return true;
            }catch(Exception e){
                System.err.println("Erro: "+e.toString());
                e.printStackTrace();
                return false;
            }
        }
        return false;    
    }
    
    public boolean excluir(fichaDTO ficha){
        try{
            Connection conn = Conexao.conectar(NOMEBANCO);
            String sql = "DELETE FROM "+NOMETABELA+" WHERE MATRICULA = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ficha.getMatricula());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        }catch(Exception e){
            System.err.println("Erro: "+e.toString());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean alterar(fichaDTO ficha){
        try{
            Connection conn = Conexao.conectar(NOMEBANCO);
            String sql = "UPDATE "+NOMETABELA+" SET MATRICULA=?, NOME=? WHERE MATRICULA =?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ficha.getMatricula());
            ps.setString(2, ficha.getNome());
            ps.setInt(3, ficha.getMatricula());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true; 
        }catch(Exception e){
            System.err.println("Erro: "+e.toString());
            e.printStackTrace();
            return false;
        }
    }
    
    public fichaDTO procurar(fichaDTO ficha){
        try{
            Connection conn = Conexao.conectar(NOMEBANCO);
            String sql = "SELECT * FROM "+NOMETABELA+" WHERE MATRICULA = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ficha.getMatricula());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                fichaDTO registro = new fichaDTO();
                registro.setMatricula(rs.getInt(1));
                registro.setNome(rs.getString(2));
                
                ps.close();
                rs.close();
                conn.close();
                return registro;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }           
        }catch(Exception e){
            System.err.println("Erro: "+e.toString());
            e.printStackTrace();
            return null;
        }
    }
    
    public List<fichaDTO> pesquisar(){
        try{
            Connection conn = Conexao.conectar(NOMEBANCO);
            String sql = "SELECT * FROM "+NOMETABELA;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            List<fichaDTO> listRegistro = montarLista(rs);
            ps.close();
            rs.close();
            conn.close();
            return listRegistro;
        } catch (Exception e){
            System.err.println("Erro: "+e.toString());
            e.printStackTrace();
            return null;
        } 
    }
    
    public List<fichaDTO> montarLista (ResultSet rs){
        List<fichaDTO> listModel = new ArrayList<fichaDTO>();
        try{
            while(rs.next()){
                fichaDTO registro = new fichaDTO();
                registro.setMatricula(rs.getInt(1));
                registro.setNome(rs.getString(2));
                listModel.add(registro);
            }
            return listModel;
        } catch (Exception e){
            System.err.println("Erro: "+e.toString());
            e.printStackTrace();
            return null;
        }     
        
        
    }
    

}
