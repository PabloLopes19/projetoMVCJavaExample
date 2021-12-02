/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;
import DAO.fichaDAO;
import DTO.fichaDTO;
import java.util.List;

/**
 *
 * @author aluno
 */
public class fichaBO {
    public boolean existe (fichaDTO ficha){
        fichaDAO fichadao = new fichaDAO();
        return fichadao.existe(ficha);
    }
    
    public boolean inserir (fichaDTO ficha){
        fichaDAO fichadao = new fichaDAO();
        return fichadao.inserir(ficha);
    }
    
    public boolean excluir (fichaDTO ficha){
        fichaDAO fichadao = new fichaDAO();
        return fichadao.excluir(ficha);
    }
    
    public boolean alterar (fichaDTO ficha){
        fichaDAO fichadao = new fichaDAO();
        return fichadao.alterar(ficha);
    }
    
    public fichaDTO procurar (fichaDTO ficha){
        fichaDAO fichadao = new fichaDAO();
        return fichadao.procurar(ficha);
    }
    
    public List<fichaDTO> pesquisar(){
        fichaDAO fichadao = new fichaDAO();
        List<fichaDTO> lista = fichadao.pesquisar();
        return lista;
    }
}
