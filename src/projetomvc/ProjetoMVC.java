/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetomvc;

import BO.fichaBO;
import Conexao.Conexao;
import DTO.fichaDTO;
import GUI.fichaGUI;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author aluno
 */
public class ProjetoMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        fichaGUI ficha = new fichaGUI();
        ficha.setVisible(true);
        //System.out.println("Teste de conexao");
        //Connection conn = Conexao.conectar("auladb");
        /*        
        fichaDTO ficha = new fichaDTO();
        ficha.setMatricula(1);
        ficha.setNome("");
        
        fichaBO fichabo = new fichaBO();
        List<fichaDTO> lista = fichabo.pesquisar();
        for(int i=0; i < lista.size(); i++){
           System.out.println(lista.get(i).getMatricula() + " - " + 
                              lista.get(i).getNome());
        }
        */
        
        //Pesquisar
        /*fichaDTO retorno = fichabo.procurar(ficha);
        if (retorno != null){
            int matricula = retorno.getMatricula();
            String nome = retorno.getNome();

            System.out.println("Matricula: "+matricula);
            System.out.println("Nome: "+nome);
        } else {
            System.out.println("Registro não encontrado!!");
        } */   
        
        //Alterar
        /*if (fichabo.existe(ficha)){
            if (fichabo.alterar(ficha)){
                System.out.println("Registro alterado com sucesso");
            } else {
                System.out.println("Erro ao alterar o registro");
            }
        } else {
            System.out.println("Registro não encontrado!");
        }*/
        
        
        /*if (fichabo.existe(ficha)){
            if (fichabo.excluir(ficha)){
                System.out.println("Registro excluído com sucesso");
            } else {
                System.out.println("Erro ao excluir o registro");
            }
        } else {
            System.out.println("Registro não encontrado!");
        }*/
        
        
        // Cadastrar novo registro
        /*
        if (!fichabo.existe(ficha)){
            if (fichabo.inserir(ficha)){
                System.out.println("Registro cadastrado com sucesso!");
            }else{
                System.out.println("Erro ao inserir o registro");
            }
        }else{
            System.out.println("Registro já cadastrado.");
        }*/ 
        
        
        // Exemplo de Consulta
        /*
        if (fichabo.existe(ficha)){
            System.out.println("Registro existente");
        } else {
            System.out.println("Registro não localizado");
        }*/
        
        
        
        
        
        
    }
    
}
