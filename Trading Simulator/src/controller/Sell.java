package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.AbstractAction;

import model.Model;


public class Sell extends AbstractAction implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Model m;
	public Sell(Model model){
		m = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//get the current values of all state variables
		Map<String, Float> values;
		values = m.getPrices();
		
		//get value of btcSlider
		int amt = m.getSlider();
		System.out.println(amt);
		
		//get $
		
		//check to see if enough $ remains
		//subtract the dollars
		//add the bitcoin
		//update the model
		
	}

}
