import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGame extends JFrame {
	
	//game variable
	int variableNumber = 4;
	int[] answer = new int[variableNumber];
	int[] input = new int[variableNumber];
	int[] result = new int [variableNumber];
	int attempt; //user's attempt
	int numCap = 10;// max number
	boolean finish = false;
	Random randNum = new Random();
	
	NumberPool inputPool;
	NumberPool ansPool;
	JFrame frame = new JFrame("Number Game");
	JPanel panel = new JPanel(new BorderLayout());
	JButton[] button_Up = new JButton[4];
	JButton[] button_Down = new JButton[4];
	JButton[] indicator = new JButton[4];
	JButton button_Check = new JButton("Check");
	JButton button_Reset = new JButton("reset");
	JLabel[] label_Input = new JLabel[4];
	JLabel label_Trail = new JLabel("0");
	JLabel nothing = new JLabel();;
	
	//end of game variable
	
	//UI setting
	private int buttonWidth = 70;
	private int buttonHeight = 20;
	private int indicatorSize = buttonWidth;
	private int labelWitdh = buttonWidth;
	private int labelHeight = 50;
	private int summitWitdh = 300;
	private int summitHeight = 50;
	private int gapWidth = 50;
	private int gapHeight = 20;
	private int indicatorY = 50;
	private int upY = indicatorY+indicatorSize+gapHeight;
	private int labelY = upY + gapHeight + buttonHeight;
	private int downY = labelY + gapHeight + labelHeight;
	private int checkY = 450;
	private int resetY = 500;
	private int trailY = 400;
	
	private int frameWidth = (variableNumber*buttonWidth)+((variableNumber+1)*gapWidth);
	private int frameHeight = 600;
	
	Color red = Color.red; //result = 0 => not in answer
	Color yellow = Color.yellow; // result = 1 => wrong location
	Color green = Color.green;// result 2 => correct
	Color gray = Color.gray;//result = -1 => not started;
	//end of UI setting
	
	public static void main(String[] args) {
		new NumberGame();
	}
	
	public NumberGame(){
		
		frame.setSize(frameWidth, frameHeight);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
	}
	
	public boolean contains (int num){
		//check does the answer contain variable "num"
		for(int i =0;i<variableNumber;i++){
			if(answer[i]==num)
				return true;
		}
		return false;
	}

	public void check(){
		//after check
		//compare answer with input
		attempt++;
		label_Trail.setText(""+attempt);
		for(int i = 0;i<variableNumber;i++){
			if(input[i]==answer[i])
				result[i]=2;
			else if(contains(input[i]))
				result[i]=1;
			else
				result[i]=0;
		}
		updateColor();
		if(result[0]==2&&result[1]==2&&result[2]==2&&result[3]==2)
			finish = true;
	}
	
	public void init(){
		int x = 0;
		inputPool = new NumberPool(numCap);
		for(int i=0;i<variableNumber;i++){
			
			x = (gapWidth*(i+1)) + (buttonWidth*i);
			button_Up[i] = new JButton("+");
			button_Up[i].setSize(buttonWidth, buttonHeight);
			button_Up[i].setLocation(x, upY);
			
			button_Down[i] = new JButton("-");
			button_Down[i].setSize(buttonWidth, buttonHeight);
			button_Down[i].setLocation(x, downY);
			
			addActionListener(i);
			indicator[i] = new JButton();
			indicator[i].setSize(indicatorSize, indicatorSize);
			indicator[i].setLocation(x, indicatorY);
			
			label_Input[i] = new JLabel(""+i);
			label_Input[i].setSize(labelWitdh, labelHeight);
			label_Input[i].setLocation(x, labelY);
			label_Input[i].setHorizontalAlignment(JLabel.CENTER);
			
			panel.add(button_Up[i]);
			panel.add(button_Down[i]);
			panel.add(indicator[i]);
			panel.add(label_Input[i]);
			
		}
		
		int systemX = (frame.getWidth()-summitWitdh)/2; 
		
		button_Check.setBounds(systemX, checkY, summitWitdh, summitHeight);
		button_Check.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!finish){
					check();
					if(finish)
						JOptionPane.showMessageDialog(null,"YOU WIN");
				}
			}
		});
		
		button_Reset.setBounds(systemX, resetY, summitWitdh, summitHeight);
		button_Reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				newAnswer();
				JOptionPane.showMessageDialog(null, "NEW GAME!");
				
			}
		});
		
		label_Trail.setBounds(systemX, trailY, summitWitdh, summitHeight);
		label_Trail.setHorizontalAlignment(JLabel.CENTER);
		
		panel.add(label_Trail);
		panel.add(button_Check);
		panel.add(button_Reset);
		panel.add(nothing);
		panel.validate();
		frame.add(panel);
		newAnswer();
		
	}
	
	public void newAnswer(){
		//reset the game
		attempt = 0;
		label_Trail.setText(""+attempt);
		finish = false;
		
		int temp;
		for(int i = 0;i<4;i++){
			result[i]=-1;
			input[i]=i;
			indicator[i].setBackground(gray);
			
			temp = randNum.nextInt(numCap);
			while((contains(temp)))
				temp= randNum.nextInt(numCap);
			answer[i]=temp;
		}
		inputPool.reset();
		System.out.println(""+answer[0]+answer[1]+answer[2]+answer[3]+"");
		
	}
	public void updateColor(){
		//update color for indicator
		for(int i=0;i<variableNumber;i++){
			if(result[i] == 0)
				indicator[i].setBackground(red);
			else if(result[i] == 1)
			indicator[i].setBackground(yellow);
			else 
				indicator[i].setBackground(green);
		}
	}

	public void addActionListener(final int i){
		button_Up[i].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	//input[i]=inputPool.next(input[i],input[i]);
            	if(!finish){
	            	input[i]++;
	        		if(input[i]>=numCap)
	        			input[i]=0;
	            	label_Input[i].setText(""+input[i]);
            	}
            }
        });  
		
		button_Down[i].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	//input[i]=inputPool.prev(input[i],input[i]);
            	if(!finish){
	            	input[i]--;
	        		if(input[i]<0)
	        			input[i]=numCap-1;
	            	label_Input[i].setText(""+input[i]);
            	}
            }
        });
	}
}
