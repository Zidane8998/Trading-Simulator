package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.AbstractAction;

import model.Model;


public class Buy extends AbstractAction implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Model m;
	public Buy(Model model){
		m = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//get the current values of all state variables
		Map<String, Float> values;
		values = m.getPrices();
		
		//get value of btcSlider
		int amt = m.getSlider();
		
		//get bitcoin, $ and current buy price
		float dollars = values.get("dollars");
		float bitcoin = values.get("bitcoin");
		float curAsk = values.get("curAsk");
		
		//check to see if enough $ remains
		if (amt * curAsk <= dollars){
			//subtract the dollars
			dollars -= amt * curAsk;
			//add the bitcoin
			bitcoin += amt;
			//update the model by passing in new values array
			values.put("dollars", dollars);
			values.put("bitcoin", bitcoin);
			m.setVars(values);
			
		}
		else{
			System.out.println("Not enough $!");
		}
	
	}

}
