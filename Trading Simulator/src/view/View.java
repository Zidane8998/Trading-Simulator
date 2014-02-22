package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;


import model.Model;

public class View{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Model m;
	private MainPanel mp;
	public View(Model model){
		//save reference to Model in m
		m = model;
		
		//initialize GUI values using initial Model info
		mp = new MainPanel();
	}
	
	public void updateView(Map<String, Float> newvalues){
		//pass the updated values into MainPanel to update the view
		mp.updateFields(newvalues);
	}
	
	//accessor for Model-->MainPanel
	public int getSlider(){
		return mp.getSlider();
	}
	
	//accessor for Game-->MainPanel for attaching button actions
	public void attachListeners(ArrayList<AbstractAction> actions){
		mp.attachListeners(actions);
	}
	
}
