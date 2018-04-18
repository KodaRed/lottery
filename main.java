import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class Lottery {
	static Random gen;
	private JFrame frmLotteryProgram;
	private JSpinner spinner_3;
	private JTextField textFieldFn;
	private JTextField textFieldLn;
	private int count = 0;
	double Wyoming = 0.04, Nevada = 0.081, Colorado = 0.029, Utah = 0.047, Idaho = 0.06;
	public int other;
	double jackpot;
	static int[] winningNumbers = new int[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lottery window = new Lottery();
					window.frmLotteryProgram.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */

	public class People {
		private String firstName;
		private String lastName;
		private double state;
		private int number1, number2, number3, number4, number5;
		public double winnings;
		public double atWinnings;
		public double taxAmount;


		public People(String fName, String lName, double state, int s1, int s2, int s3, int s4, int s5,double winnings, double atWinnings) {
			this.firstName = fName;
			this.lastName = lName;
			this.state = state;
			this.number1 = s1;
			this.number2 = s2;
			this.number3 = s3;
			this.number4 = s4;
			this.number5 = s5;
			this.winnings = winnings;
			this.atWinnings = atWinnings;
		}
	}

	People p1;
	People p2;
	People p3;
	People p4;
	People p5;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public Lottery() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		gen = new Random();
		// Generates the Winning Numbers
		for(int i = 0; i < 5; i++) {
			int win = gen.nextInt(8)+1;
			winningNumbers[i] = win;
		}
		jackpot = gen.nextInt(10000000)+1000000;
		
		System.out.println(Arrays.toString(winningNumbers));
		//Output for Test
		frmLotteryProgram = new JFrame();
		frmLotteryProgram.setTitle("Lottery Program");
		frmLotteryProgram.setBounds(100, 100, 484, 360);
		frmLotteryProgram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLotteryProgram.getContentPane().setLayout(null);

		JLabel lblLottery = new JLabel("Lottery");
		lblLottery.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		lblLottery.setBounds(233, 6, 191, 74);
		frmLotteryProgram.getContentPane().add(lblLottery);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblFirstName.setBounds(32, 50, 96, 16);
		frmLotteryProgram.getContentPane().add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblLastName.setBounds(32, 95, 98, 16);
		frmLotteryProgram.getContentPane().add(lblLastName);

		JLabel spinner2 = new JLabel("2");
		spinner2.setBounds(247, 207, 13, 16);
		frmLotteryProgram.getContentPane().add(spinner2);

		JLabel spinner1 = new JLabel("1");
		spinner1.setBounds(192, 207, 18, 16);
		frmLotteryProgram.getContentPane().add(spinner1);

		JLabel spinner3 = new JLabel("3");
		spinner3.setBounds(302, 207, 13, 16);
		frmLotteryProgram.getContentPane().add(spinner3);

		JLabel spinner4 = new JLabel("4");
		spinner4.setBounds(357, 207, 13, 16);
		frmLotteryProgram.getContentPane().add(spinner4);

		JLabel spinner5 = new JLabel("5");
		spinner5.setBounds(412, 207, 13, 16);
		frmLotteryProgram.getContentPane().add(spinner5);

		JLabel lblJackPotAmount = new JLabel("JACKPOT:");
		lblJackPotAmount.setBounds(230, 116, 61, 16);
		frmLotteryProgram.getContentPane().add(lblJackPotAmount);

		JLabel lblNewLabel = new JLabel("Select a State:");
		lblNewLabel.setBounds(31, 153, 109, 16);
		frmLotteryProgram.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pick 5 numbers:");
		lblNewLabel_1.setBounds(172, 179, 108, 16);
		frmLotteryProgram.getContentPane().add(lblNewLabel_1);

		JSpinner spinner_5 = new JSpinner();
		spinner_5.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		spinner_5.setBounds(170, 225, 40, 25);
		frmLotteryProgram.getContentPane().add(spinner_5);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		spinner_1.setBounds(220, 225, 40, 25);
		frmLotteryProgram.getContentPane().add(spinner_1);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 9, 1));
		spinner_2.setBounds(275, 225, 40, 25);
		frmLotteryProgram.getContentPane().add(spinner_2);
				
						spinner_3 = new JSpinner();
						spinner_3.setModel(new SpinnerNumberModel(1, 1, 9, 1));
						spinner_3.setBounds(330, 225, 40, 25);
						frmLotteryProgram.getContentPane().add(spinner_3);
		
				JSpinner spinner_4 = new JSpinner();
				spinner_4.setModel(new SpinnerNumberModel(1, 1, 9, 1));
				spinner_4.setBounds(380, 225, 40, 25);
				frmLotteryProgram.getContentPane().add(spinner_4);

		textFieldFn = new JTextField();
		textFieldFn.setBounds(30, 70, 108, 26);
		frmLotteryProgram.getContentPane().add(textFieldFn);
		textFieldFn.setColumns(10);

		textFieldLn = new JTextField();
		textFieldLn.setColumns(10);
		textFieldLn.setBounds(32, 115, 108, 26);
		frmLotteryProgram.getContentPane().add(textFieldLn);
		String errorMessage = null;

		JLabel lblJackPot = new JLabel("$ " + NumberFormat.getNumberInstance(Locale.US).format(jackpot));
		lblJackPot.setForeground(Color.RED);
		lblJackPot.setBounds(302, 116, 125, 16);
		frmLotteryProgram.getContentPane().add(lblJackPot);

		JLabel error = new JLabel(errorMessage);
		error.setHorizontalAlignment(SwingConstants.RIGHT);
		error.setForeground(Color.RED);
		error.setBounds(97, 300, 338, 14);
		frmLotteryProgram.getContentPane().add(error);
		

		JButton btnAddPerson = new JButton("Add Person");
		btnAddPerson.setBounds(301, 269, 134, 29);
		frmLotteryProgram.getContentPane().add(btnAddPerson);
		
		JList states = new JList();
		states.setValueIsAdjusting(true);
		states.setVisibleRowCount(5);
		states.setModel(new AbstractListModel() {
			String[] values = new String[] {"Wyoming", "Nevada", "Colorado", "Idaho", "Utah"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		states.setSelectedIndex(0);
		states.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		states.setBounds(32, 169, 96, 120);
		frmLotteryProgram.getContentPane().add(states);
		

		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if(!spinner_1.equals(0) && !spinner_1.equals(0) && !spinner_1.equals(0) && !spinner_1.equals(0) && !spinner_1.equals(0) && !textFieldFn.equals(" ") && !textFieldLn.equals(" ") && !states.isSelectionEmpty()) {
				// display/center the jdialog when the button is pressed
				int number1 = (Integer) spinner_5.getValue();
				int number2 = (Integer) spinner_1.getValue();
				int number3 = (Integer) spinner_2.getValue();
				int number4 = (Integer) spinner_3.getValue();
				int number5 = (Integer) spinner_4.getValue();
				String fName = textFieldFn.getText();
				String lName = textFieldLn.getText();
				double state = states.getSelectedIndex();
				double atWinnings = 0;
				double winnings = 0;
			
				setData(fName, lName, state, number1, number2, number3, number4, number5, winnings, atWinnings);
				// Clears Data after First Person
				textFieldFn.setText(" ");
				textFieldLn.setText(" ");
				spinner_5.setValue(1);
				spinner_1.setValue(1);
				spinner_2.setValue(1);
				spinner_3.setValue(1);
				spinner_4.setValue(1);
				states.setSelectedIndex(0);
				error.setText(" ");
				}
//				else {
//					error.setText("You did not fill out all the required fields!");
//				}
//			}
		});
		

	}
	
public void setData(String fName, String lName, double state, int s1, int s2, int s3, int s4, int s5,double winnings, double atWinnings) {
	if (count == 0) {
		p1 = new People(fName, lName, state, s1, s2, s3, s4, s5, winnings, atWinnings);// set struct class
	}
	if (count == 1) {
		p2 = new People(fName, lName, state, s1, s2, s3, s4, s5, winnings, atWinnings);
	}
	if (count == 2) {
		p3 = new People(fName, lName, state, s1, s2, s3, s4, s5, winnings, atWinnings);
	}
	if (count == 3) {
		p4 = new People(fName, lName, state, s1, s2, s3, s4, s5, winnings, atWinnings);
	}
	if (count == 4) {
		p5 = new People(fName, lName, state, s1, s2, s3, s4, s5, winnings, atWinnings);
		displayResults();
	}

	count++;
}

public int generateResults(People p){
	other = 0;
     if(p.number1 == winningNumbers[0]){
         other += 1;
     }
     if(p.number2 == winningNumbers[1]){
        other += 1;
     }
     if(p.number3 == winningNumbers[2]){
         other += 1;
     }
     if(p.number4 == winningNumbers[3]){
         other += 1;
     }
     if(p.number5 == winningNumbers[4]){
         other += 1;
     }
     
	return other;

 }
public double winAmount(People p) {
	if(other == 1) {
		p.winnings = jackpot * 0.025;
	}
	if(other == 2) {
		p.winnings = jackpot * 0.05;
	}
	if(other == 3) {
		p.winnings = jackpot * 0.075;
	}
	if(other == 4) {
		p.winnings = jackpot * 0.1;
	}
	if(other == 5) {
		p.winnings = jackpot * 0.75;
	}
	return p.winnings;
}

	public void displayResults() {// convert to text box and add state
		System.out.println("$ " + NumberFormat.getNumberInstance(Locale.US).format(jackpot));
		System.out.println(p1.firstName + " " + p1.lastName + " chose numbers: " + p1.number1 + " " + p1.number2 + " "
				+ p1.number3 + " " + p1.number4 + " " + p1.number5 + " and got " + generateResults(p1) + " correctly " + "and won " + "$ " + NumberFormat.getNumberInstance(Locale.US).format(winAmount(p1)) );
		System.out.println(p2.firstName + " " + p2.lastName + " chose numbers: " + p2.number1 + " " + p2.number2 + " "
				+ p2.number3 + " " + p2.number4 + " " + p2.number5 + " and won " + generateResults(p2));
		System.out.println(p3.firstName + " " + p3.lastName + " chose numbers: " + p3.number1 + " " + p3.number2 + " "
				+ p3.number3 + " " + p3.number4 + " " + p3.number5 + " and won " + generateResults(p3));
		System.out.println(p4.firstName + " " + p4.lastName + " chose numbers: " + p4.number1 + " " + p4.number2 + " "
				+ p4.number3 + " " + p4.number4 + " " + p4.number5 + " and won " + generateResults(p4));
		System.out.println(p5.firstName + " " + p5.lastName + " chose numbers: " + p5.number1 + " " + p5.number2 + " "
				+ p5.number3 + " " + p5.number4 + " " + p5.number5 + " and won " + generateResults(p5));
		System.exit(0);
	}
}
