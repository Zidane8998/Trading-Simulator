package model;

public class Model {
	private int dollars;
	private double bitcoin;
	private double profit;
	private double curPrice;
	public Model(){}
	protected void initGame(){
		//initialize starting values
		dollars = 2000;
		bitcoin = 0;
		profit = 0;
		//notify view that model has been initialized, update view
	}
	
	private void updateView(){
		//pass updated values to View
	}
	
	protected void updatePrice(double newPrice){
		curPrice = newPrice;
		updateView();
	}
	
    protected double getPrice(){
    	return this.curPrice;
    }
	
}
