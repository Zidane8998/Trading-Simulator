package model;

import java.util.HashMap;
import java.util.Map;

import view.View;

public class Model {
	private float dollars;
	private float bitcoin;
	private float profit;
	private float curBid;
	private float curAsk;
	private Map<String, Float> values;
	private View v;
	public Model(){}
	
	public void initModel(View view){
		v = view;
		
		//initialize starting values
		dollars = 2000;
		bitcoin = 0;
		profit = 0;
		curBid = 0;
		curAsk = 0;
		
		//instantiate the values array and update it
		values = new HashMap<String, Float>();
		
		//update the current list of values and notify the View that state information has changed
		this.updateList();
	}
	
	//update the list of values used by the View, update 
	private synchronized void updateList(){
		//clear list
		values.clear();
		
		//add newest values
		values.put("dollars", dollars);
		values.put("bitcoin", bitcoin);
		values.put("profit", profit);
		values.put("curBid", curBid);
		values.put("curAsk", curAsk);
		
		//update the View since at least one value has changed
		updateView();
	}
	
	//notify the View that the state information has changed
	private synchronized void updateView(){
		//pass updated values to View
		v.updateView(values);
	}
	
	//setters
	public synchronized void setPrices(Map<String, Float> newvalues){
		curBid = newvalues.get("curBid");
		curAsk = newvalues.get("curAsk");
		System.out.println("Prices updated!");
		updateList();
	}
	
	public synchronized void setVars(Map<String, Float> newvalues){
		dollars = newvalues.get("dollars");
		bitcoin = newvalues.get("bitcoin");
		System.out.println("Dollars and bitcoin updated!");
		updateList();
	}
	
	//getters
    public synchronized Map<String, Float> getPrices(){
    	return this.values;
    }
    
    //gives access to the View-->Model
    public synchronized int getSlider(){
		return v.getSlider();
    }
   
	
}
