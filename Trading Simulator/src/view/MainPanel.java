package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.Buy;
import controller.Sell;

import java.awt.GridBagLayout;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class MainPanel extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	private JLabel curAskLbl;
	private JLabel curBidLbl;
	private JLabel btcLbl;
	private JLabel dollarsLbl;
	private JSlider btcSlider;
	private JButton buyButton, sellButton;
	

	/**
	 * Create the application.
	 */
	public MainPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pointsPanel = new JPanel();
		pointsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		frame.getContentPane().add(pointsPanel, BorderLayout.NORTH);
		pointsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCurrentPricebid = new JLabel("Price (Bid): ");
		pointsPanel.add(lblCurrentPricebid);
		
		curBidLbl = new JLabel("0");
		pointsPanel.add(curBidLbl);
		
		JLabel lblCurrentPriceask = new JLabel("Price (Ask):");
		pointsPanel.add(lblCurrentPriceask);
		
		curAskLbl = new JLabel("0");
		pointsPanel.add(curAskLbl);
		
		JLabel lblOfBtc = new JLabel("# of BTC: ");
		pointsPanel.add(lblOfBtc);
		
		btcLbl = new JLabel("0");
		pointsPanel.add(btcLbl);
		
		JLabel lblDollars = new JLabel("Dollars: ");
		pointsPanel.add(lblDollars);
		
		dollarsLbl = new JLabel("0");
		pointsPanel.add(dollarsLbl);
		
		JPanel buttonsPanel = new JPanel();
		frame.getContentPane().add(buttonsPanel, BorderLayout.EAST);
		buttonsPanel.setLayout(new GridLayout(5,1));
		
		btcSlider = new JSlider();
		btcSlider.setMajorTickSpacing(1);
		btcSlider.setMinimum(1);
		btcSlider.setSnapToTicks(true);
		btcSlider.setValue(0);
		btcSlider.setPaintTicks(true);
		btcSlider.setPaintLabels(true);
		btcSlider.setMaximum(5);
		buttonsPanel.add(btcSlider);
		
		buyButton = new JButton("Buy Bitcoin (Market Price)");
		buyButton.setEnabled(false);
		
		buttonsPanel.add(buyButton);
		
		sellButton = new JButton("Sell Bitcoin (Market Price)");
		sellButton.setEnabled(false);
		buttonsPanel.add(sellButton);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmLoad = new JMenuItem("Load");
		mnFile.add(mntmLoad);
		
		JMenuItem Quit = new JMenuItem("Quit");
		mnFile.add(Quit);
		
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		
	}
	public synchronized void updateFields(Map<String, Float> newvalues){
		curAskLbl.setText( String.valueOf( newvalues.get("curAsk") ) );
		curBidLbl.setText( String.valueOf( newvalues.get("curBid") ) );
		btcLbl.setText( String.valueOf( newvalues.get("bitcoin") ) );
		dollarsLbl.setText( String.valueOf( newvalues.get("dollars") ) );
		if (newvalues.get("curBid")!=0){
			buyButton.setEnabled(true);
			sellButton.setEnabled(true);
		}
		
	}
	
	public int getSlider(){
		return btcSlider.getValue();
	}
	
	public void attachListeners(ArrayList<AbstractAction> actions){
		for (AbstractAction cur : actions){
			if (cur instanceof Buy){
				//attach Buy to buy button
				buyButton.addActionListener(cur);
			}
			else if (cur instanceof Sell){
				sellButton.addActionListener(cur);
			}
		}
	}
	
}
