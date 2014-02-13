package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;



public class Game extends JsonReader implements ActionListener{
	private Model m;
	private float tmp;
	private Timer timer;
	private JSONObject json;
	public Game() {
		m = new Model();
		timer = new Timer();
		json = null;
		m.initModel();
		this.checkPrice();
		this.play();
	}
	
	//main game loop
	private void play(){
		//update BTC price if timer is over 10s
		scheduleTimer(timer);
		
		//show UI
		
		//main game loop - updates state information
		//while (true){}
	}
	
	private void scheduleTimer(Timer timer){
		System.out.println("Starting timer...");
		timer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run(){
				checkPrice();
			}
		}, 10*1000, 10*1000);
	}
	
	private void checkPrice(){
		System.out.println("Checking price...");
		//get current price
		String lastPrice = "";
		try {
			json = readJsonFromUrl("http://www.bitstamp.net/api/ticker/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		try {
			lastPrice = json.get("last").toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		//parse JSON data into float
		this.tmp = Float.parseFloat(lastPrice);
		
		//if price has changed, change price in Model
		if ( this.tmp != m.getPrice() ){
			System.out.println("Price changed, updating Model..");
			m.setPrice(this.tmp);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
