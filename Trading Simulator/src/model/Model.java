package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import view.View;

public class Model {
	private float dollars;
	private float bitcoin;
	private float profit;
	private float curPrice;
	private Map<String, Float> values;
	private View v;
	public Model(){}
	
	protected void initModel(){
		//initialize starting values
		dollars = 2000;
		bitcoin = 0;
		profit = 0;
		curPrice = 0;
		
		//Initialize View and save link to it
		v = new View(this);
		
		//instantiate the values array and update it
		values = new HashMap<String, Float>();
		
		//update the current list of values and notify the View that state information has changed
		this.updateList();
	}
	
	//update the list of values used by the View, update 
	private void updateList(){
		//clear list
		values.clear();
		
		//add newest values
		values.put("dollars", dollars);
		values.put("bitcoin", bitcoin);
		values.put("profit", profit);
		values.put("curPrice", curPrice);
		
		//update the View since at least one value has changed
		updateView();
	}
	
	//notify the View that the state information has changed
	private void updateView(){
		//pass updated values to View
		v.updateView(values);
	}
	
	//setters
	protected void setPrice(float newPrice){
		curPrice = newPrice;
		System.out.println("New price: " + newPrice);
		updateList();
	}
	
	//getters
    protected float getPrice(){
    	return this.curPrice;
    }
	
}
