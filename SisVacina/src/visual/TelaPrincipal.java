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

/**
 *
 * @author boemo
 */
class TelaPrincipal extends Window {
    
 private Panel painel01;
 private Label label01;
 private Button botaoCadastros;
 private Button botaoCartaoVacinas;
 private Button botaoRelatorio;
 private Button botaoSair;
 private Button Exemplos;
 
 private static GUIScreen guitelaprincipal;
 
 
 
    public TelaPrincipal(GUIScreen gs) {
        super("Sistema de Controle de Vacinas");
        this.guitelaprincipal=gs;
        init();
    }

    private void init() {
      setBorder(new Border.Standard());
        painel01 = new Panel(Panel.Orientation.HORISONTAL);
        botaoCadastros = new Button("Cadastros", new Action() {
            @Override
            public void doAction() {
              guitelaprincipal.showWindow(new TelaCadastros(guitelaprincipal));
            }
            
        });
        painel01.addComponent(botaoCadastros);
        
        botaoCartaoVacinas = new Button("Cartão de vacinas", new Action() {
            @Override
            public void doAction() {
              guitelaprincipal.showWindow(new TelaCartaoVacinas(guitelaprincipal));
            }
            
        });
        painel01.addComponent(botaoCartaoVacinas);
        
        botaoRelatorio = new Button("Relatorios", new Action() {
            @Override
            public void doAction() {
             // guitelaprincipal.showWindow(new TelaIncluirFornecedor(guitelaprincipal));
            }
            
        });
        painel01.addComponent(botaoRelatorio);
        
        botaoSair = new Button("Sair", new Action() {
        @Override
            public void doAction() {
                close();
            }
        });      
        painel01.addComponent(botaoSair);
                Exemplos = new Button("Exemplos", new Action() {
        @Override
            public void doAction() {
               guitelaprincipal.showWindow(new TesteComponentes(guitelaprincipal));
            }
        });      
        painel01.addComponent(Exemplos);
        addComponent(painel01);
        
        
    }
    
    
}
