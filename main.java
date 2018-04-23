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
import javax.swing.JPanel;

public class Lottery {
	static Random gen;
	private JFrame frmLotteryProgram;
	private JSpinner spinner_3;
	private JTextField textFieldFn;
	private JTextField textFieldLn;
	private static int count = 0;
	public int other;
	double jackpot;
	static int[] winningNumbers = new int[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		// System.out.println(Arrays.toString(winningNumbers));
		// Output for Test
		frmLotteryProgram = new JFrame();
		frmLotteryProgram.setTitle("Lottery Program");

		frmLotteryProgram.setBounds(100, 100, 530, 360);

		frmLotteryProgram.getContentPane().setLayout(null);

		JPanel firstPanel = new JPanel();
		firstPanel.setBounds(0, 0, 514, 321);
		frmLotteryProgram.getContentPane().add(firstPanel);
		firstPanel.setLayout(null);

		JLabel error = new JLabel();
		error.setBounds(212, 236, 248, 23);
		firstPanel.add(error);
		error.setHorizontalAlignment(SwingConstants.RIGHT);
		error.setForeground(Color.RED);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(27, 28, 64, 16);
		firstPanel.add(lblFirstName);
		lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 12));

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(27, 79, 64, 16);
		firstPanel.add(lblLastName);
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 12));

		JLabel taxPLbl = new JLabel("Your State :");
		taxPLbl.setBounds(27, 155, 161, 14);
		firstPanel.add(taxPLbl);

		JLabel lblLottery = new JLabel("Lottery");
		lblLottery.setBounds(274, 11, 170, 64);
		firstPanel.add(lblLottery);
		lblLottery.setFont(new Font("Lucida Grande", Font.BOLD, 50));

		JLabel lblJackPot = new JLabel("$ " + NumberFormat.getNumberInstance(Locale.US).format(jackpot));
		lblJackPot.setBounds(286, 86, 147, 33);
		firstPanel.add(lblJackPot);
		lblJackPot.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblJackPot.setForeground(new Color(50, 205, 50));

		JLabel lblPickNumbers = new JLabel("Pick 5 numbers:");
		lblPickNumbers.setBounds(212, 167, 149, 14);
		firstPanel.add(lblPickNumbers);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(222, 192, 31, 20);
		firstPanel.add(spinner_1);
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 9, 1));

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(258, 192, 31, 20);
		firstPanel.add(spinner_2);
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 9, 1));

		spinner_3 = new JSpinner();
		spinner_3.setBounds(294, 192, 31, 20);
		firstPanel.add(spinner_3);
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 9, 1));

		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(330, 192, 31, 20);
		firstPanel.add(spinner_4);
		spinner_4.setModel(new SpinnerNumberModel(1, 1, 9, 1));

		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(366, 192, 31, 20);
		firstPanel.add(spinner_5);
		spinner_5.setModel(new SpinnerNumberModel(1, 1, 9, 1));

		textFieldFn = new JTextField();
		textFieldFn.setBounds(27, 48, 113, 20);
		firstPanel.add(textFieldFn);
		textFieldFn.setColumns(10);

		textFieldLn = new JTextField();
		textFieldLn.setBounds(27, 95, 113, 20);
		firstPanel.add(textFieldLn);
		textFieldLn.setColumns(10);

		JButton btnAddPerson = new JButton("Add Person");
		btnAddPerson.setBounds(330, 270, 128, 40);
		firstPanel.add(btnAddPerson);

		JRadioButton rdbtnUtah = new JRadioButton("Utah");
		rdbtnUtah.setBounds(27, 228, 95, 23);
		firstPanel.add(rdbtnUtah);
		buttonGroup.add(rdbtnUtah);
		rdbtnUtah.setActionCommand("0.047");

		JRadioButton rdbtnIdaho = new JRadioButton("Idaho");
		rdbtnIdaho.setBounds(27, 251, 95, 23);
		firstPanel.add(rdbtnIdaho);
		buttonGroup.add(rdbtnIdaho);
		rdbtnIdaho.setActionCommand("0.06");

		JRadioButton rdbtnNevada = new JRadioButton("Nevada");
		rdbtnNevada.setBounds(27, 279, 95, 23);
		firstPanel.add(rdbtnNevada);
		buttonGroup.add(rdbtnNevada);
		rdbtnNevada.setActionCommand("0.081");

		JRadioButton rdbtnColorado = new JRadioButton("Colorado");
		rdbtnColorado.setBounds(27, 176, 113, 23);
		firstPanel.add(rdbtnColorado);
		buttonGroup.add(rdbtnColorado);
		rdbtnColorado.setActionCommand("0.029");

		JRadioButton rdbtnWyoming = new JRadioButton("Wyoming");
		rdbtnWyoming.setBounds(27, 202, 113, 23);
		firstPanel.add(rdbtnWyoming);
		buttonGroup.add(rdbtnWyoming);
		rdbtnWyoming.setActionCommand("0.04");

		JPanel resultsPanel = new JPanel();
		resultsPanel.setBounds(0, 0, 514, 321);
		frmLotteryProgram.getContentPane().add(resultsPanel);
		resultsPanel.setLayout(null);

		JLabel lotterylblResults = new JLabel("Lottery");
		lotterylblResults.setBounds(10, 11, 170, 64);
		resultsPanel.add(lotterylblResults);
		lotterylblResults.setFont(new Font("Dialog", Font.BOLD, 50));

		JLabel jckpotResults = new JLabel("$ " + NumberFormat.getNumberInstance(Locale.US).format(jackpot));
		jckpotResults.setForeground(new Color(50, 205, 50));
		jckpotResults.setFont(new Font("Dialog", Font.PLAIN, 25));
		jckpotResults.setBounds(311, 36, 147, 33);
		resultsPanel.add(jckpotResults);

		JLabel namelbl = new JLabel("Name");
		namelbl.setBounds(20, 119, 100, 14);
		resultsPanel.add(namelbl);

		JLabel lblNumbers = new JLabel("Numbers");
		lblNumbers.setBounds(130, 119, 100, 14);
		resultsPanel.add(lblNumbers);

		JLabel lblWinnings = new JLabel("Winnings");
		lblWinnings.setBounds(240, 119, 100, 14);
		resultsPanel.add(lblWinnings);

		JLabel name1 = new JLabel();
		name1.setText("name1");
		name1.setVerticalAlignment(SwingConstants.TOP);
		name1.setBounds(20, 144, 100, 14);
		resultsPanel.add(name1);

		JLabel name2 = new JLabel("name2");
		name2.setBounds(20, 181, 100, 14);
		resultsPanel.add(name2);

		JLabel name3 = new JLabel("name3");
		name3.setBounds(20, 216, 100, 14);
		resultsPanel.add(name3);

		JLabel name4 = new JLabel("name4");
		name4.setBounds(20, 257, 100, 14);
		resultsPanel.add(name4);

		JLabel name5 = new JLabel("name5");
		name5.setBounds(20, 296, 100, 14);
		resultsPanel.add(name5);

		JLabel seperator = new JLabel("_________________________________________________________________________");
		seperator.setVerticalAlignment(SwingConstants.TOP);
		seperator.setBounds(10, 119, 460, 24);
		resultsPanel.add(seperator);

		JLabel numbers1 = new JLabel("numbers1");
		numbers1.setVerticalAlignment(SwingConstants.TOP);
		numbers1.setBounds(130, 144, 100, 14);
		resultsPanel.add(numbers1);

		JLabel numbers2 = new JLabel("numbers2");
		numbers2.setVerticalAlignment(SwingConstants.TOP);
		numbers2.setBounds(130, 181, 100, 14);
		resultsPanel.add(numbers2);

		JLabel numbers3 = new JLabel("numbers1");
		numbers3.setVerticalAlignment(SwingConstants.TOP);
		numbers3.setBounds(130, 216, 100, 14);
		resultsPanel.add(numbers3);

		JLabel numbers4 = new JLabel("numbers1");
		numbers4.setVerticalAlignment(SwingConstants.TOP);
		numbers4.setBounds(130, 257, 100, 14);
		resultsPanel.add(numbers4);

		JLabel numbers5 = new JLabel("numbers1");
		numbers5.setVerticalAlignment(SwingConstants.TOP);
		numbers5.setBounds(130, 296, 100, 14);
		resultsPanel.add(numbers5);

		JLabel winnings1 = new JLabel("numbers1");
		winnings1.setVerticalAlignment(SwingConstants.TOP);
		winnings1.setBounds(240, 144, 100, 14);
		resultsPanel.add(winnings1);

		JLabel winnings2 = new JLabel("numbers1");
		winnings2.setVerticalAlignment(SwingConstants.TOP);
		winnings2.setBounds(240, 181, 100, 14);
		resultsPanel.add(winnings2);

		JLabel winnings3 = new JLabel("numbers1");
		winnings3.setVerticalAlignment(SwingConstants.TOP);
		winnings3.setBounds(240, 216, 100, 14);
		resultsPanel.add(winnings3);

		JLabel winnings4 = new JLabel("numbers1");
		winnings4.setVerticalAlignment(SwingConstants.TOP);
		winnings4.setBounds(240, 257, 100, 14);
		resultsPanel.add(winnings4);

		JLabel winnings5 = new JLabel("numbers1");
		winnings5.setVerticalAlignment(SwingConstants.TOP);
		winnings5.setBounds(240, 296, 100, 14);
		resultsPanel.add(winnings5);

		JLabel jackpotlbl = new JLabel("Jackpot : ");
		jackpotlbl.setBounds(257, 51, 61, 14);
		resultsPanel.add(jackpotlbl);

		JLabel winningNumberslbl = new JLabel("Winning Numbers");
		winningNumberslbl.setBounds(20, 94, 130, 14);
		resultsPanel.add(winningNumberslbl);
		JLabel winNumbers = new JLabel();
		winNumbers.setText(Arrays.toString(winningNumbers));

		winNumbers.setForeground(Color.RED);
		winNumbers.setFont(new Font("Dialog", Font.PLAIN, 25));
		winNumbers.setBounds(130, 76, 147, 33);
		resultsPanel.add(winNumbers);

		JLabel numbersMatchedlbl = new JLabel("Numbers Matched");
		numbersMatchedlbl.setBounds(350, 119, 108, 14);
		resultsPanel.add(numbersMatchedlbl);

		JLabel nm1 = new JLabel("nm1");
		nm1.setBounds(350, 144, 100, 14);
		resultsPanel.add(nm1);

		JLabel nm2 = new JLabel("nm1");
		nm2.setBounds(350, 181, 100, 14);
		resultsPanel.add(nm2);

		JLabel nm3 = new JLabel("nm1");
		nm3.setBounds(350, 216, 100, 14);
		resultsPanel.add(nm3);

		JLabel nm4 = new JLabel("nm1");
		nm4.setBounds(350, 257, 100, 14);
		resultsPanel.add(nm4);

		JLabel nm5 = new JLabel("nm1");
		nm5.setBounds(350, 296, 100, 14);
		resultsPanel.add(nm5);
		btnAddPerson.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				if (!textFieldFn.equals(" ") && !textFieldLn.equals(" ") && !buttonGroup.isSelected(null)) {
					int number1 = (Integer) spinner_1.getValue();
					int number2 = (Integer) spinner_2.getValue();
					int number3 = (Integer) spinner_3.getValue();
					int number4 = (Integer) spinner_4.getValue();
					int number5 = (Integer) spinner_5.getValue();
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
					if (count == 5) {
						firstPanel.setVisible(false);
						displayResults();
						name1.setText(p1.fullName);
						name2.setText(p2.fullName);
						name3.setText(p3.fullName);
						name4.setText(p4.fullName);
						name5.setText(p5.fullName);
						numbers1.setText(p1.numbers);
						numbers2.setText(p2.numbers);
						numbers3.setText(p3.numbers);
						numbers4.setText(p4.numbers);
						numbers5.setText(p5.numbers);
						winnings1.setText(NumberFormat.getNumberInstance(Locale.US).format(winAmount(p1)));
						winnings2.setText(NumberFormat.getNumberInstance(Locale.US).format(winAmount(p2)));
						winnings3.setText(NumberFormat.getNumberInstance(Locale.US).format(winAmount(p3)));
						winnings4.setText(NumberFormat.getNumberInstance(Locale.US).format(winAmount(p4)));
						winnings5.setText(NumberFormat.getNumberInstance(Locale.US).format(winAmount(p5)));
						nm1.setText(String.valueOf(generateWins(p1)));
						nm2.setText(String.valueOf(generateWins(p2)));
						nm3.setText(String.valueOf(generateWins(p3)));
						nm4.setText(String.valueOf(generateWins(p4)));
						nm5.setText(String.valueOf(generateWins(p5)));
					}
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
		generateWins(p1);
		winAmount(p1);
		generateWins(p2);
		winAmount(p2);
		generateWins(p3);
		winAmount(p3);
		generateWins(p4);
		winAmount(p4);
		generateWins(p5);
		winAmount(p5);

	}
}
