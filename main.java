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

import java.awt.Color;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class Lottery {
	static Random gen;
	private JFrame frmLotteryProgram;
	private JSpinner spinner_3;
	private JTextField textFieldFn;
	private JTextField textFieldLn;
	private int count = 0;
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
		private String firstName, lastName, state, info, numbers, fullName;
		private int number1, number2, number3, number4, number5;
		public double winnings, atWinnings, taxAmount, taxPercent;

		public People(String fName, String lName, String state, int s1, int s2, int s3, int s4, int s5, double winnings,
				double taxAmount, double atWinnings, double taxPercent, String info, String numbers, String fullName) {
			this.firstName = fName;
			this.lastName = lName;
			this.state = state;
			this.number1 = s1;
			this.number2 = s2;
			this.number3 = s3;
			this.number4 = s4;
			this.number5 = s5;
			this.taxAmount = taxAmount;
			this.winnings = winnings;
			this.atWinnings = atWinnings;
			this.taxPercent = taxPercent;
			this.info = info;
			this.fullName = fullName;
			this.numbers = numbers;
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
		for (int i = 0; i < 5; i++) {
			int win = gen.nextInt(8) + 1;
			winningNumbers[i] = win;
		}
		jackpot = gen.nextInt(10000000) + 1000000;

		System.out.println(Arrays.toString(winningNumbers));
		// Output for Test
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

		JLabel taxPLbl = new JLabel("Your State :");
		taxPLbl.setBounds(32, 162, 109, 16);
		frmLotteryProgram.getContentPane().add(taxPLbl);

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
		lblJackPot.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblJackPot.setForeground(new Color(50, 205, 50));
		lblJackPot.setBounds(178, 95, 249, 47);
		frmLotteryProgram.getContentPane().add(lblJackPot);

		JLabel error = new JLabel(errorMessage);
		error.setHorizontalAlignment(SwingConstants.RIGHT);
		error.setForeground(Color.RED);
		error.setBounds(97, 300, 338, 14);
		frmLotteryProgram.getContentPane().add(error);

		JButton btnAddPerson = new JButton("Add Person");
		btnAddPerson.setBounds(301, 269, 134, 29);
		frmLotteryProgram.getContentPane().add(btnAddPerson);

		JRadioButton rdbtnUtah = new JRadioButton("Utah");
		buttonGroup.add(rdbtnUtah);
		rdbtnUtah.setBounds(32, 176, 109, 23);
		frmLotteryProgram.getContentPane().add(rdbtnUtah);
		rdbtnUtah.setActionCommand("0.047");

		JRadioButton rdbtnIdaho = new JRadioButton("Idaho");
		buttonGroup.add(rdbtnIdaho);
		rdbtnIdaho.setBounds(32, 204, 109, 23);
		frmLotteryProgram.getContentPane().add(rdbtnIdaho);
		rdbtnIdaho.setActionCommand("0.06");

		JRadioButton rdbtnNevada = new JRadioButton("Nevada");
		buttonGroup.add(rdbtnNevada);
		rdbtnNevada.setBounds(32, 227, 109, 23);
		frmLotteryProgram.getContentPane().add(rdbtnNevada);
		rdbtnNevada.setActionCommand("0.081");

		JRadioButton rdbtnColorado = new JRadioButton("Colorado");
		buttonGroup.add(rdbtnColorado);
		rdbtnColorado.setBounds(32, 248, 109, 23);
		frmLotteryProgram.getContentPane().add(rdbtnColorado);
		rdbtnColorado.setActionCommand("0.029");

		JRadioButton rdbtnWyoming = new JRadioButton("Wyoming");
		buttonGroup.add(rdbtnWyoming);
		rdbtnWyoming.setBounds(32, 270, 109, 23);
		frmLotteryProgram.getContentPane().add(rdbtnWyoming);
		rdbtnWyoming.setActionCommand("0.04");

		btnAddPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldFn.equals(" ") && !textFieldLn.equals(" ") && !buttonGroup.isSelected(null)) {
					int number1 = (Integer) spinner_5.getValue();
					int number2 = (Integer) spinner_1.getValue();
					int number3 = (Integer) spinner_2.getValue();
					int number4 = (Integer) spinner_3.getValue();
					int number5 = (Integer) spinner_4.getValue();
					String fName = textFieldFn.getText();
					String lName = textFieldLn.getText();
					String state = buttonGroup.getSelection().getActionCommand();
					double atWinnings = 0;
					double winnings = 0;
					double taxAmount = 0;
					double taxPercent = 0;
					String numbers = String.format("%d,%d,%d,%d,%d", number1, number2, number3, number4, number5);
					String fullName = String.format("%s,%s", fName, lName);
					String info = String.format("%-15s %-15s", fullName, numbers);

					setData(fName, lName, state, number1, number2, number3, number4, number5, winnings, taxAmount,
							atWinnings, taxPercent, info, numbers, fullName);
					// Clears Data after First Person
					textFieldFn.setText(" ");
					textFieldLn.setText(" ");
					buttonGroup.clearSelection();
					spinner_5.setValue(1);
					spinner_1.setValue(1);
					spinner_2.setValue(1);
					spinner_3.setValue(1);
					spinner_4.setValue(1);
					error.setText(" ");
				} else {
					error.setText("You did not fill out all the required fields!");
				}
			}
		});

	}

	public void setData(String fName, String lName, String state, int s1, int s2, int s3, int s4, int s5,
			double winnings, double taxAmount, double atWinnings, double taxPercent, String info, String numbers,
			String fullName) {
		if (count == 0) {
			p1 = new People(fName, lName, state, s1, s2, s3, s4, s5, winnings, taxAmount, atWinnings, taxPercent, info,
					numbers, fullName);
		}
		if (count == 1) {
			p2 = new People(fName, lName, state, s1, s2, s3, s4, s5, winnings, taxAmount, atWinnings, taxPercent, info,
					numbers, fullName);
		}
		if (count == 2) {
			p3 = new People(fName, lName, state, s1, s2, s3, s4, s5, winnings, taxAmount, atWinnings, taxPercent, info,
					numbers, fullName);
		}
		if (count == 3) {
			p4 = new People(fName, lName, state, s1, s2, s3, s4, s5, winnings, taxAmount, atWinnings, taxPercent, info,
					numbers, fullName);
		}
		if (count == 4) {
			p5 = new People(fName, lName, state, s1, s2, s3, s4, s5, winnings, taxAmount, atWinnings, taxPercent, info,
					numbers, fullName);
			displayResults();
		}

		count++;
	}

	public int generateWins(People p) {
		other = 0;
		if (p.number1 == winningNumbers[0]) {
			other += 1;
		}
		if (p.number2 == winningNumbers[1]) {
			other += 1;
		}
		if (p.number3 == winningNumbers[2]) {
			other += 1;
		}
		if (p.number4 == winningNumbers[3]) {
			other += 1;
		}
		if (p.number5 == winningNumbers[4]) {
			other += 1;
		}

		return other;

	}

	public double winAmount(People p) {
		p.taxPercent = Double.parseDouble(p.state);
		if (other == 1) {
			p.winnings = jackpot * 0.025;
		}
		if (other == 2) {
			p.winnings = jackpot * 0.05;
		}
		if (other == 3) {
			p.winnings = jackpot * 0.075;
		}
		if (other == 4) {
			p.winnings = jackpot * 0.1;
		}
		if (other == 5) {
			p.winnings = jackpot * 0.75;
		}
		p.taxAmount = p.winnings * p.taxPercent;
		p.atWinnings = p.winnings - p.taxAmount;
		return p.atWinnings;
	}

	public void displayResults() {// convert to text box and add state\
		System.out.println("Jackpot: " + NumberFormat.getNumberInstance(Locale.US).format(jackpot)
				+ "   Winning Numbers: " + Arrays.toString(winningNumbers));
		System.out.printf("%n%-15s %-15s %-15s %-15s", "NAME", "NUMBERS", "# Matched", "WINNINGS");
		System.out.println("\n------------------------------------------------------------");
		System.out.printf("%s %-15s $%-15s%n", p1.info, generateWins(p1),
				NumberFormat.getNumberInstance(Locale.US).format(winAmount(p1)));
		System.out.printf("%s %-15s $%-15s%n", p2.info, generateWins(p2),
				NumberFormat.getNumberInstance(Locale.US).format(winAmount(p2)));
		System.out.printf("%s %-15s $%-15s%n", p3.info, generateWins(p3),
				NumberFormat.getNumberInstance(Locale.US).format(winAmount(p3)));
		System.out.printf("%s %-15s $%-15s%n", p4.info, generateWins(p4),
				NumberFormat.getNumberInstance(Locale.US).format(winAmount(p4)));
		System.out.printf("%s %-15s $%-15s%n", p5.info, generateWins(p5),
				NumberFormat.getNumberInstance(Locale.US).format(winAmount(p5)));

		System.exit(0);
	}
}
