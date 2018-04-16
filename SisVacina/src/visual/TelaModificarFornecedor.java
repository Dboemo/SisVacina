/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

/**
 *
 * @author boemo
 */
//public class TelaModificarFornecedor {
    
//
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import controle.Conexao;
import controle.FornecedorControle;
import java.sql.Connection;
import modelo.Fornecedor;

/**
 *
 * @author boemo
 */
class TelaModificarFornecedor extends Window {

    private Panel painel01;
    private Button botaoSair;
    private Button botaoSalvar;
    private Label label01;
    private Label lblCNPJ;
    private TextBox txtCNPJ;
    private Label lblNome;
    private TextBox txtNome;
    Fornecedor fornecedor = new Fornecedor();
    private static GUIScreen guiScreen;
    FornecedorControle fCtrl;
    private String operacao;

    public TelaModificarFornecedor(GUIScreen gS,Fornecedor forn,String op) {
        super("Modificar Fornecedor");
        this.guiScreen = gS;
        fornecedor= forn;
        operacao=op;
        if(op.equals("A")){
        Alterar();
        }else{
        Excluir();
        }
    }

    private void Alterar() {
              
        Connection conn = Conexao.AbrirConexao();
        fCtrl=new FornecedorControle(conn);
        
        setBorder(new Border.Standard());
        painel01 = new Panel(Panel.Orientation.HORISONTAL);
        painel01.setBetweenComponentsPadding(1);
        label01 = new Label("Altere de Fornecedor  ");
        addComponent(label01);
        lblCNPJ = new Label("CNPJ : "+fornecedor.getCNPJ());
        lblNome = new Label("Nome do Fornecedor :");
        txtNome = new TextBox();
        addComponent(lblCNPJ);
        addComponent(txtCNPJ);
        addComponent(lblNome);
        addComponent(txtNome);
        botaoSalvar = new Button("Alterar", new Action() {
            @Override
            public void doAction() {
                fornecedor.setNomeFornecedor(txtNome.getText());
                //fornecedor.setCNPJ(txtCNPJ.getText());
                MessageBox.showMessageBox(guiScreen, "Fornecedores", 
                        fCtrl.AlterarFornecedor(fornecedor));
                close();
            }

        });
        addComponent(botaoSalvar);
        botaoSair = new Button("Sair", new Action() {
            @Override
            public void doAction() {
                close();
            }
        });
        addComponent(botaoSair);

    }

    private void Excluir() {
        Connection conn = Conexao.AbrirConexao();
        fCtrl=new FornecedorControle(conn);
        
        setBorder(new Border.Standard());
        painel01 = new Panel(Panel.Orientation.HORISONTAL);
        painel01.setBetweenComponentsPadding(1);
        label01 = new Label("Exclusão de Fornecedor  ");
        addComponent(label01);
        lblCNPJ = new Label("CNPJ : "+fornecedor.getCNPJ());
        lblNome = new Label("Nome do Fornecedor : "+fornecedor.getNomeFornecedor());
        addComponent(lblCNPJ);
        addComponent(lblNome);
        botaoSalvar = new Button("Excluir", new Action() {
            @Override
            public void doAction() {
                //fornecedor.setNomeFornecedor(txtNome.getText());
                //fornecedor.setCNPJ(txtCNPJ.getText());
                MessageBox.showMessageBox(guiScreen, "Fornecedores", 
                        fCtrl.ExcluirFornecedor(fornecedor));
                close();
            }

        });
        addComponent(botaoSalvar);
        botaoSair = new Button("Sair", new Action() {
            @Override
            public void doAction() {
                close();
            }
        });
        addComponent(botaoSair);

    }

}
