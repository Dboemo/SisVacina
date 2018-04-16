/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Fornecedor;
/**
 *
 * @author boemo
 */
public class FornecedorControle {
    
    private Connection con;

    public FornecedorControle(Connection con) {
        this.con = con;
    }
    

    
    public String InserirFornecedor(Fornecedor forn){
    
    String SQL = "INSERT INTO fornecedor(cnpj, nome)"
            + " VALUES (?, ?)";
    try{
        PreparedStatement ps= con.prepareStatement(SQL);
        ps.setString(1, forn.getCNPJ());
        ps.setString(2, forn.getNomeFornecedor());
        //ps.executeUpdate();//podemos retirar este aqui.
        
        if(ps.executeUpdate()>0){
        return "Inclusão de novo Fornecedor realizada com sucesso";
        }else{
        return "Erro ao tentar incluir novo Fornecedor";
        }
    
    }catch(SQLException e){
        System.out.println(e.getErrorCode());
        return e.getMessage();
        
    }

    }
    public String AlterarFornecedor (Fornecedor forn){
    
    String SQL = "UPDATE Fornecedor SET nome=?" +
" WHERE CNPJ='"+forn.getCNPJ()+"'";
    try{
        PreparedStatement ps= con.prepareStatement(SQL);
        ps.setString(1, forn.getNomeFornecedor());

        ps.executeUpdate();//podemos retirar este aqui.
        if(ps.executeUpdate()>0){
        return "Alteração de Fornecedor realizada com sucesso";
        }else{
        return "Erro ao tentar alterar Fornecedor";
        }
    
    }catch(SQLException e){
        return e.getMessage();
    }
    }    
    public String ExcluirFornecedor (Fornecedor forn){
    
    String SQL = "DELETE FROM fornecedor " +
" WHERE cnpj =?";
    try{
        PreparedStatement ps= con.prepareStatement(SQL);

        ps.setString(1, forn.getCNPJ());
        ps.executeUpdate();//podemos retirar este aqui.
       
        return "Exclusão do fornecedor realizada com sucesso";
        
    
    }catch(SQLException e){
        return e.getMessage();
    }
    }
    
    
    public List<Fornecedor> listarTodosFornecedores(String texto) {
        String SQL="SELECT * FROM fornecedor where nome "
                + " like '"+texto+"%'order by CNPJ;";
        List<Fornecedor> listaforn = new ArrayList<Fornecedor>();
       try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs= ps.executeQuery(); 
            if(rs !=null){
            while(rs.next()){
            Fornecedor forn =new Fornecedor();
            forn.setCNPJ(rs.getString("CNPJ"));
            forn.setNomeFornecedor(rs.getString("nome"));
            listaforn.add(forn);
            }
            }
            return listaforn;
        } catch (SQLException e) {
            return null;
        }
    }
    public String[]  listarTodosNomesFornecedores() {
        String SQL="SELECT * FROM fornecedor order by nome;";
        int numreg=NumeroTotalRegistros();
        String listaforn[]= new String [numreg];
       
       try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs= ps.executeQuery(); 
            int i=0;
            if(rs !=null){
            while(rs.next()){
            listaforn[i]=(rs.getString("nome"));
                System.out.println("i : "+i+" nome : "+listaforn[i]);
                i++;
            }
            }
            return listaforn;
        } catch (SQLException e) {
            return null;
        }
    }    

    public int NumeroTotalRegistros() {
        String SQL = "Select count(*) from fornecedor";
        int numt = 0;
        try {
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    numt = rs.getInt(1);
                }
            }
            return numt;
        } catch (SQLException e) {
            System.out.println("" + e);
            return 0;
        }
    }    
}
