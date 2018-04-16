/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.ListSelectDialog;
import controle.Conexao;
import controle.FornecedorControle;
import java.sql.Connection;
import modelo.Fornecedor;
import static visual.TesteComponentes.gs;

/**
 *
 * @author boemo
 */
class TelaCartaoVacinas extends Window {
    private Panel painelPaciente;
    private Button botaoSair;
    private Button botaoPaciente;
    private Label lblPaciente;
    private Label lblPacienteDados;
    private TextBox txtCNPJ;
    private Label lblNome;
    private TextBox txtNome;
    Fornecedor fornecedor = new Fornecedor();
    private static GUIScreen guiScreen;
    FornecedorControle fCtrl;
      
    
    
    public TelaCartaoVacinas(GUIScreen gs) {
              super("Cartão de Vacinação");
        this.guiScreen = gs;
        init();  
    }

    private void init() {
        Connection conn = Conexao.AbrirConexao();
        fCtrl=new FornecedorControle(conn);
        
        setBorder(new Border.Standard());
        painelPaciente = new Panel(Panel.Orientation.HORISONTAL);
        painelPaciente.setBetweenComponentsPadding(1);
        lblPaciente = new Label("Paciente");
        painelPaciente.addComponent(lblPaciente);

        botaoPaciente = new Button("Consultar Pacientes", new Action() {
            @Override
            public void doAction() {
                //Aqui consulta
                       
            String auxText=ListSelectDialog.showDialog(guiScreen, "titulo", "Entrada", fCtrl.listarTodosNomesFornecedores());
            lblPacienteDados.setText(auxText);
            }
        });
        painelPaciente.addComponent(botaoPaciente);
         lblPacienteDados=new Label("[]");
         painelPaciente.addComponent(lblPacienteDados);
        
        
        addComponent(painelPaciente);
        botaoSair = new Button("Sair", new Action() {
            @Override
            public void doAction() {
                close();
            }
        });
        addComponent(botaoSair);
    }
    
}
