package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import model.Model;

public class View /*extends JFrame*/{
	/**
	 * 
	 */
	private Model m;
	private Map<String, Float> values;
	public View(Model model){
		//save reference to Model in m
		m = model;
		values = new HashMap<String, Float>();
		//initialize GUI values using initial Model info
		
	}
	
	public void updateView(Map<String, Float> newvalues){
		//clear the current set of values saved in the HashMap, then save the new values
		values.clear();
		values.putAll(newvalues);
	}
}
