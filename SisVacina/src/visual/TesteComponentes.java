/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.CheckBox;
import com.googlecode.lanterna.gui.component.EditArea;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.ListSelectDialog;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import com.googlecode.lanterna.gui.dialog.TextInputDialog;
import com.googlecode.lanterna.terminal.TerminalSize;
import controle.ListaRadio;
import java.sql.Connection;


public class TesteComponentes extends Window{
    
public static GUIScreen gs;
public  Panel painel;
public  Panel painelCheck;
public  Label label01;
public  Label labeltexto;
public  Label lbNome;
public  Label lbCel;
public  Label lbFixo;
public  TextBox txtNome;
public  TextBox txtCel;
public  TextBox txtFixo;
public  Button botaoSair;
public  Button botatestacheck;
public  Button botaMensagem1;
public  Button botaMensagemList;
public  Button botatestalistaRadio;
public CheckBox check01;
public CheckBox check02;
public EditArea areatexto;
public ListaRadio listc;

private static String[] opRadio = new String[] {
		"Masculino",
		"Feminino",
                
	};


    public TesteComponentes(GUIScreen gs) {
        super("Teste Componentes");
        this.gs=gs;
        init();
    }
    public void init(){
       
        setBorder(new Border.Standard());
        painel =new Panel(Panel.Orientation.VERTICAL);
        painel.setBetweenComponentsPadding(1);
        label01 = new Label("Teste de mensagens e componentes");
        addComponent(label01);
        painelCheck = new Panel(Panel.Orientation.HORISONTAL);
        check01 = new CheckBox("Valor 01", true);
        painelCheck.addComponent(check01);
        check02 = new CheckBox("Valor 02", false);
        painelCheck.addComponent(check02);   
        addComponent(painelCheck);
        
        listc = new ListaRadio(opRadio);
        
       // addComponent(listc);
        
        botatestalistaRadio=new Button("Teste Radiobox",new Action(){
        @Override
        public void doAction(){
        
        int pos=listc.getCheckedItemIndex();
        MessageBox.showMessageBox(gs, "Valor de retorno", ""+pos);
            
        }
        });   
        addComponent(botatestalistaRadio);
        
        labeltexto=new Label("Área de edição");
        addComponent(labeltexto);
        areatexto=new EditArea(new TerminalSize(45, 15));
        addComponent(areatexto);      
        
        
        botatestacheck=new Button("Teste CheckBox",new Action(){
        @Override
        public void doAction(){
            if(check01.isSelected()){
            MessageBox.showMessageBox(gs, "Resultado Check 01", "Verdadeiro");
            }else{
            MessageBox.showMessageBox(gs, "Resultado Check 01", "Falso");}
            if(check02.isSelected()){
            MessageBox.showMessageBox(gs, "Resultado Check 02", "Verdadeiro");
            }else{
            MessageBox.showMessageBox(gs, "Resultado Check 02", "Falso");}
            
        }
        });   
        addComponent(botatestacheck);
        
        botaMensagem1=new Button("Mensagem input dialog",new Action(){
        @Override
        public void doAction(){
            String auxText=TextInputDialog.showTextInputBox(gs, "TÃ­tulo","Pergunta", "Default");
            String auxText2=TextInputDialog.showPasswordInputBox(gs, "TÃ­tulo","Pergunta",null);
        }
        });   
        addComponent(botaMensagem1);
        botaMensagemList=new Button("Mensagem ListTextbox",new Action(){
        @Override
        public void doAction(){
            String []items=new String[3];
            items[0]="Item 1";
            items[1]="Item 2";
            items[2]="Item 3";
            String auxText=ListSelectDialog.showDialog(gs, "título", "Entrada", items);
           
        }
        });   
        addComponent(botaMensagemList);
        
        botaoSair=new Button("Sair",new Action(){
        @Override
        public void doAction(){
         close();
        }
        }); 
        addComponent(botaoSair);
        
    }
    
    
}
