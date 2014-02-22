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
	private void updateList(){
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
	private void updateView(){
		//pass updated values to View
		v.updateView(values);
	}
	
	//setters
	public void setPrices(Map<String, Float> newvalues){
		curBid = newvalues.get("curBid");
		curAsk = newvalues.get("curAsk");
		System.out.println("Prices updated!");
		updateList();
	}
	
	
	//getters
    public Map<String, Float> getPrices(){
    	return this.values;
    }
    
    //gives access to the View-->Model
    public int getSlider(){
		return v.getSlider();
    }
   
	
}
