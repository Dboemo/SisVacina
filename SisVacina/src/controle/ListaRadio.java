/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.googlecode.lanterna.gui.component.RadioCheckBoxList;
import com.googlecode.lanterna.gui.Interactable;
import com.googlecode.lanterna.input.Key;
public class ListaRadio extends RadioCheckBoxList {

		
		public ListaRadio(String[] options) {
			super();
			for (String option: options) {
				addItem(option);
			}
		}
		
 
                
            @Override
	    protected Interactable.Result unhandledKeyboardEvent(Key key) {
	    	//int indexBeforeEvent = getCheckedItemIndex();
	    	Interactable.Result result = super.unhandledKeyboardEvent(key);
	    	//int indexAfterEvent = getCheckedItemIndex();
	    	

	    	return result;
	    }


	}