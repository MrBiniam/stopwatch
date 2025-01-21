package stopwatch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatchClass implements ActionListener {
	
	JFrame frame = new JFrame("Biniam's Stop Watch");
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	
	int elapsedTime = 0;
	int second = 0;
	int minute = 0;
	int hour = 0;
	
	boolean started = false;
	
	String second_string = String.format("%02d",second);
	String minute_string = String.format("%02d",minute);
	String hour_string = String.format("%02d",hour);
	
	Timer timer = new Timer(1000,new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime+=1000;
			hour= (elapsedTime/3600000);
			minute= (elapsedTime/60000)%60;
			second= (elapsedTime/1000)%60;
			
			second_string = String.format("%02d",second);
			minute_string = String.format("%02d",minute);
		    hour_string = String.format("%02d",hour);
		    
		    timeLabel.setText(hour_string+":"+minute_string+":"+second_string);
			
			
		}
		
			
});
	
	StopWatchClass(){
		
		timeLabel.setText(hour_string+":"+minute_string+":"+second_string);
		timeLabel.setBounds(100,100 ,200,100);
		timeLabel.setFont(new Font("verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		
		startButton.setBounds(100,200,100,50);
		startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		resetButton.setBounds(200,200,100,50);
		resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		frame.add(startButton);
		frame.add(resetButton);
		frame.add(timeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==startButton) {
			
			if(started==false) {
				
				started = true;
				startButton.setText("STOP");
				start();
			}
			else {
				started = false;
				startButton.setText("START");
				stop();
				
			}
			
		}
		
		if(e.getSource()==resetButton) {
			
			started = false;
			startButton.setText("START");
			reset();
		}
		
		
	}
	
	public void start() {
		
		timer.start();
		
	}
	public void stop() {
		
		timer.stop();
		
	}
	public void reset() {
		timer.stop();
		elapsedTime = 0;
		second = 0;
		minute = 0;
		hour = 0;
		
		second_string = String.format("%02d",second);
		minute_string = String.format("%02d",minute);
	    hour_string = String.format("%02d",hour);
	    
	    timeLabel.setText(hour_string+":"+minute_string+":"+second_string);
		
		
	}

}
