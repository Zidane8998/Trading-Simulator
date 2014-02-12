package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Timer;
import java.util.TimerTask;



public class Game implements ActionListener{
	private Model m;
	private double tmp;
	private Timer timer;
	public Game() {
		m = new Model();
		timer = new Timer();
		m.initGame();
		play();
	}
	
	//main game loop
	private void play(){
		//update BTC price if timer is over 10s
		scheduleTimer(timer);
		
		//show UI
		
		//main game loop - updates state information
		//while (true){}
	}
	
	private void scheduleTimer(Timer timer)
	{
		System.out.println("Starting timer...");
		timer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				checkPrice();
			}
		}, 10*1000, 10*1000);
	}
	
	private void checkPrice()
	{
		System.out.println("Checking price...");
		//get current price
		//tmp = 
		//if price has changed, change price in Model
		if ( tmp != m.getPrice() ){
			m.updatePrice(tmp);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//getters
	public double getCurPrice() {
		return curPrice;
	}
	
	//setters
	public void setCurPrice(double curPrice) {
		this.curPrice = curPrice;
	}
}
