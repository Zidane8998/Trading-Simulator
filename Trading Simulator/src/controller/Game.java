package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractAction;

import model.JsonReader;
import model.Model;

import org.json.JSONObject;

import view.View;



public class Game extends JsonReader implements ActionListener{
	private Model m;
	private View v;
	private float tmpAsk;
	private float tmpBid;
	private Timer timer;
	private JSONObject json;
	private Buy buy;
	private Sell sell;
	
	public Game(){
		
		//initialize Model and save link
		m = new Model();
		
		//initialize View and save link
		v = new View(m);
		
		m.initModel(v);
		
		timer = new Timer();
		json = null;
		
		//create actions
		buy = new Buy(m);
		sell = new Sell(m);
		
		ArrayList<AbstractAction> actions = new ArrayList<AbstractAction>();
		actions.add(buy);
		actions.add(sell);
		v.attachListeners(actions);
		
		//initialize timer that updates price
		checkPrice();
		play();
		
	}
	
	//main game loop
	private int play(){
		//update BTC price if timer is over 10s
		scheduleTimer(timer);
		
		//show UI
		
		//main game loop - updates state information
		//while (true){}
		return 1;
	}
	
	//schedule a Timer to get the price every 10 seconds
	private void scheduleTimer(Timer timer){
		System.out.println("Starting timer...");
		timer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run(){
				checkPrice();
			}
		}, 10*1000, 10*1000);
	}
	
	//get current price of Ask and Bids on Bitstamp, returning 1 when finished
	private int checkPrice(){
		System.out.println("Checking price...");
		//get current price
		String ask = "";
		String bid = "";
		try {
			json = readJsonFromUrl("https://www.bitstamp.net/api/ticker/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ask = json.get("ask").toString();
			bid = json.get("bid").toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//parse JSON data into float format
		this.tmpAsk = Float.parseFloat(ask);
		this.tmpBid = Float.parseFloat(bid);
		
		//check prices currently in Model by getting the collection of values
		Map <String, Float> curvalues;
		curvalues = m.getPrices();
		
		float curAsk = curvalues.get("curAsk");
		float curBid = curvalues.get("curBid");
	
		if ( this.tmpAsk != curAsk || this.tmpBid != curBid){
			
			//if price has changed and temporary price values don't match, change price in Model
			
			//initialize a new values map, pass to Model
			Map<String, Float> values = new HashMap<String, Float>();
			values.put("curAsk", tmpAsk);
			values.put("curBid", tmpBid);
			
			System.out.println("Price changed, updating Model..");
			m.setPrices(values);
		}
		return 1;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
