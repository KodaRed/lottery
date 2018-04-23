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
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

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

	// Launches the Program and Creates the GUI Frame.
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

	// Creates a people so that we can add specific data to each person.
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
	// Groups the Radio Buttons together so only 1 can be selected.
	private final ButtonGroup buttonGroup = new ButtonGroup();

	// Launches the GUI interface.
	public Lottery() {
		initialize();
	}

	private void initialize() {
		// Creates Random Number Generator.
		gen = new Random();
		// Generates the the 5 Winning Numbers 1-9.
		for (int i = 0; i < 5; i++) {
			int win = gen.nextInt(9) + 1;
			winningNumbers[i] = win;
		}
		// Generates the winning Jackpot.
		jackpot = gen.nextInt(10000000) + 1000000;
		// System.out.println(Arrays.toString(winningNumbers));
		// Output for Test

		// This Generates the content of our GUI
		frmLotteryProgram = new JFrame();
		frmLotteryProgram.setTitle("Lottery Program");

		frmLotteryProgram.setBounds(100, 100, 516, 411);

		frmLotteryProgram.getContentPane().setLayout(null);

		JPanel firstPanel = new JPanel();
		firstPanel.setBounds(0, 0, 500, 372);
		frmLotteryProgram.getContentPane().add(firstPanel);
		firstPanel.setLayout(null);

		JLabel error = new JLabel();
		error.setFont(new Font("Dialog", Font.BOLD, 11));
		error.setBounds(212, 236, 248, 23);
		firstPanel.add(error);
		error.setHorizontalAlignment(SwingConstants.RIGHT);
		error.setForeground(Color.RED);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(21, 16, 125, 106);
		firstPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(6, 6, 113, 20);
		panel_1.add(lblFirstName);
		lblFirstName.setForeground(new Color(0, 0, 0));
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 14));

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(6, 58, 113, 16);
		panel_1.add(lblLastName);
		lblLastName.setForeground(new Color(0, 0, 0));
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 14));

		textFieldFn = new JTextField();
		textFieldFn.setBounds(6, 32, 113, 20);
		panel_1.add(textFieldFn);
		textFieldFn.setFont(new Font("Dialog", Font.PLAIN, 12));
		textFieldFn.setColumns(10);

		textFieldLn = new JTextField();
		textFieldLn.setBounds(6, 80, 113, 20);
		panel_1.add(textFieldLn);
		textFieldLn.setFont(new Font("Dialog", Font.PLAIN, 12));
		textFieldLn.setColumns(10);

		JLabel lblLottery = new JLabel("Lottery");
		lblLottery.setBounds(274, 11, 170, 64);
		firstPanel.add(lblLottery);
		lblLottery.setFont(new Font("Lucida Grande", Font.BOLD, 50));

		JLabel lblJackPot = new JLabel("$ " + NumberFormat.getNumberInstance(Locale.US).format(jackpot));
		lblJackPot.setBounds(286, 86, 147, 33);
		firstPanel.add(lblJackPot);
		lblJackPot.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblJackPot.setForeground(new Color(50, 205, 50));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pick 5 Numbers",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(216, 176, 256, 64);
		firstPanel.add(panel_2);
		panel_2.setLayout(null);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(9, 16, 40, 35);
		panel_2.add(spinner_1);
		spinner_1.setFont(new Font("Dialog", Font.BOLD, 12));
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 9, 1));

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(58, 16, 40, 35);
		panel_2.add(spinner_2);
		spinner_2.setFont(new Font("Dialog", Font.BOLD, 11));
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 9, 1));

		spinner_3 = new JSpinner();
		spinner_3.setBounds(107, 16, 40, 35);
		panel_2.add(spinner_3);
		spinner_3.setFont(new Font("Dialog", Font.BOLD, 11));
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 9, 1));

		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(156, 16, 40, 35);
		panel_2.add(spinner_4);
		spinner_4.setFont(new Font("Dialog", Font.BOLD, 11));
		spinner_4.setModel(new SpinnerNumberModel(1, 1, 9, 1));

		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(205, 16, 40, 35);
		panel_2.add(spinner_5);
		spinner_5.setFont(new Font("Dialog", Font.BOLD, 11));
		spinner_5.setModel(new SpinnerNumberModel(1, 1, 9, 1));

		JButton btnAddPerson = new JButton("Add Person");
		btnAddPerson.setFont(new Font("Dialog", Font.BOLD, 11));
		btnAddPerson.setBounds(301, 270, 157, 40);
		firstPanel.add(btnAddPerson);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Your State :",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(21, 159, 129, 155);
		firstPanel.add(panel);
		panel.setLayout(null);

		JRadioButton rdbtnUtah = new JRadioButton("Utah");
		rdbtnUtah.setBounds(6, 97, 117, 23);
		panel.add(rdbtnUtah);
		rdbtnUtah.setBackground(new Color(211, 211, 211));
		rdbtnUtah.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonGroup.add(rdbtnUtah);
		rdbtnUtah.setActionCommand("0.047");

		JRadioButton rdbtnIdaho = new JRadioButton("Idaho");
		rdbtnIdaho.setBounds(6, 41, 117, 23);
		panel.add(rdbtnIdaho);
		rdbtnIdaho.setBackground(new Color(211, 211, 211));
		rdbtnIdaho.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonGroup.add(rdbtnIdaho);
		rdbtnIdaho.setActionCommand("0.06");

		JRadioButton rdbtnNevada = new JRadioButton("Nevada");
		rdbtnNevada.setBounds(6, 69, 117, 23);
		panel.add(rdbtnNevada);
		rdbtnNevada.setBackground(new Color(211, 211, 211));
		rdbtnNevada.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonGroup.add(rdbtnNevada);
		rdbtnNevada.setActionCommand("0.081");

		JRadioButton rdbtnColorado = new JRadioButton("Colorado");
		rdbtnColorado.setBounds(6, 13, 117, 23);
		panel.add(rdbtnColorado);
		rdbtnColorado.setBackground(new Color(211, 211, 211));
		rdbtnColorado.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonGroup.add(rdbtnColorado);
		rdbtnColorado.setActionCommand("0.029");

		JRadioButton rdbtnWyoming = new JRadioButton("Wyoming");
		rdbtnWyoming.setBounds(6, 125, 117, 23);
		panel.add(rdbtnWyoming);
		rdbtnWyoming.setBackground(new Color(211, 211, 211));
		rdbtnWyoming.setFont(new Font("Dialog", Font.BOLD, 12));
		buttonGroup.add(rdbtnWyoming);
		rdbtnWyoming.setActionCommand("0.04");

		JLabel lblJackpot = new JLabel("JACKPOT -");
		lblJackpot.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJackpot.setFont(new Font("Dialog", Font.BOLD, 11));
		lblJackpot.setBounds(197, 95, 79, 14);
		firstPanel.add(lblJackpot);

		JPanel resultsPanel = new JPanel();
		resultsPanel.setBounds(0, 0, 500, 383);
		frmLotteryProgram.getContentPane().add(resultsPanel);
		resultsPanel.setLayout(null);

		JLabel lotterylblResults = new JLabel("Lottery");
		lotterylblResults.setBounds(10, 0, 170, 64);
		resultsPanel.add(lotterylblResults);
		lotterylblResults.setFont(new Font("Dialog", Font.BOLD, 50));

		JLabel jckpotResults = new JLabel("$ " + NumberFormat.getNumberInstance(Locale.US).format(jackpot));
		jckpotResults.setHorizontalAlignment(SwingConstants.LEFT);
		jckpotResults.setForeground(new Color(50, 205, 50));
		jckpotResults.setFont(new Font("Dialog", Font.PLAIN, 25));
		jckpotResults.setBounds(340, 2, 157, 35);
		resultsPanel.add(jckpotResults);

		JLabel namelbl = new JLabel("Name");
		namelbl.setHorizontalAlignment(SwingConstants.CENTER);
		namelbl.setFont(new Font("Dialog", Font.BOLD, 16));
		namelbl.setBounds(0, 94, 175, 35);
		resultsPanel.add(namelbl);

		JLabel lblNumbers = new JLabel("Numbers");
		lblNumbers.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumbers.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNumbers.setBounds(174, 94, 111, 35);
		resultsPanel.add(lblNumbers);

		JLabel lblWinnings = new JLabel("Winnings");
		lblWinnings.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinnings.setFont(new Font("Dialog", Font.BOLD, 16));
		lblWinnings.setBounds(295, 94, 119, 35);
		resultsPanel.add(lblWinnings);

		JLabel name1 = new JLabel();
		name1.setFont(new Font("Dialog", Font.BOLD, 14));
		name1.setHorizontalAlignment(SwingConstants.CENTER);
		name1.setText("name1");
		name1.setBounds(0, 128, 175, 44);
		resultsPanel.add(name1);

		JLabel name2 = new JLabel("name2");
		name2.setFont(new Font("Dialog", Font.BOLD, 14));
		name2.setHorizontalAlignment(SwingConstants.CENTER);
		name2.setBounds(0, 165, 175, 44);
		resultsPanel.add(name2);

		JLabel name3 = new JLabel("name3");
		name3.setFont(new Font("Dialog", Font.BOLD, 14));
		name3.setHorizontalAlignment(SwingConstants.CENTER);
		name3.setBounds(0, 205, 175, 44);
		resultsPanel.add(name3);

		JLabel name4 = new JLabel("name4");
		name4.setFont(new Font("Dialog", Font.BOLD, 14));
		name4.setHorizontalAlignment(SwingConstants.CENTER);
		name4.setBounds(0, 245, 175, 44);
		resultsPanel.add(name4);

		JLabel name5 = new JLabel("name5");
		name5.setFont(new Font("Dialog", Font.BOLD, 14));
		name5.setHorizontalAlignment(SwingConstants.CENTER);
		name5.setBounds(0, 285, 175, 44);
		resultsPanel.add(name5);

		JLabel numbers1 = new JLabel("numbers1");
		numbers1.setForeground(new Color(0, 0, 255));
		numbers1.setFont(new Font("Dialog", Font.BOLD, 14));
		numbers1.setHorizontalAlignment(SwingConstants.CENTER);
		numbers1.setBounds(174, 131, 111, 38);
		resultsPanel.add(numbers1);

		JLabel numbers2 = new JLabel("numbers2");
		numbers2.setForeground(new Color(0, 0, 255));
		numbers2.setFont(new Font("Dialog", Font.BOLD, 14));
		numbers2.setHorizontalAlignment(SwingConstants.CENTER);
		numbers2.setBounds(174, 165, 111, 44);
		resultsPanel.add(numbers2);

		JLabel numbers3 = new JLabel("numbers1");
		numbers3.setForeground(new Color(0, 0, 255));
		numbers3.setFont(new Font("Dialog", Font.BOLD, 14));
		numbers3.setHorizontalAlignment(SwingConstants.CENTER);
		numbers3.setBounds(174, 205, 111, 44);
		resultsPanel.add(numbers3);

		JLabel numbers4 = new JLabel("numbers1");
		numbers4.setForeground(new Color(0, 0, 255));
		numbers4.setFont(new Font("Dialog", Font.BOLD, 14));
		numbers4.setHorizontalAlignment(SwingConstants.CENTER);
		numbers4.setBounds(174, 245, 111, 44);
		resultsPanel.add(numbers4);

		JLabel numbers5 = new JLabel("numbers1");
		numbers5.setForeground(new Color(0, 0, 255));
		numbers5.setFont(new Font("Dialog", Font.BOLD, 14));
		numbers5.setHorizontalAlignment(SwingConstants.CENTER);
		numbers5.setBounds(174, 285, 111, 44);
		resultsPanel.add(numbers5);

		JLabel winnings1 = new JLabel("numbers1");
		winnings1.setHorizontalAlignment(SwingConstants.CENTER);
		winnings1.setForeground(new Color(0, 128, 0));
		winnings1.setFont(new Font("Dialog", Font.BOLD, 14));
		winnings1.setBounds(287, 131, 127, 38);
		resultsPanel.add(winnings1);

		JLabel winnings2 = new JLabel("numbers1");
		winnings2.setHorizontalAlignment(SwingConstants.CENTER);
		winnings2.setForeground(new Color(0, 128, 0));
		winnings2.setFont(new Font("Dialog", Font.BOLD, 14));
		winnings2.setBounds(287, 168, 127, 35);
		resultsPanel.add(winnings2);

		JLabel winnings3 = new JLabel("numbers1");
		winnings3.setHorizontalAlignment(SwingConstants.CENTER);
		winnings3.setFont(new Font("Dialog", Font.BOLD, 14));
		winnings3.setForeground(new Color(0, 128, 0));
		winnings3.setBounds(287, 205, 127, 44);
		resultsPanel.add(winnings3);

		JLabel winnings4 = new JLabel("numbers1");
		winnings4.setFont(new Font("Dialog", Font.BOLD, 14));
		winnings4.setForeground(new Color(0, 128, 0));
		winnings4.setHorizontalAlignment(SwingConstants.CENTER);
		winnings4.setBounds(287, 245, 127, 44);
		resultsPanel.add(winnings4);

		JLabel winnings5 = new JLabel("numbers1");
		winnings5.setHorizontalAlignment(SwingConstants.CENTER);
		winnings5.setFont(new Font("Dialog", Font.BOLD, 14));
		winnings5.setForeground(new Color(0, 128, 0));
		winnings5.setBounds(287, 285, 127, 44);
		resultsPanel.add(winnings5);

		JLabel jackpotlbl = new JLabel("JACKPOT -");
		jackpotlbl.setFont(new Font("Dialog", Font.BOLD, 11));
		jackpotlbl.setHorizontalAlignment(SwingConstants.RIGHT);
		jackpotlbl.setBounds(213, 0, 117, 37);
		resultsPanel.add(jackpotlbl);

		JLabel winningNumberslbl = new JLabel("WINNING NUMBERS -");
		winningNumberslbl.setFont(new Font("Dialog", Font.BOLD, 11));
		winningNumberslbl.setHorizontalAlignment(SwingConstants.RIGHT);
		winningNumberslbl.setBounds(211, 50, 119, 14);
		resultsPanel.add(winningNumberslbl);
		JLabel winNumbers = new JLabel();
		winNumbers.setHorizontalAlignment(SwingConstants.LEFT);
		winNumbers.setText(Arrays.toString(winningNumbers).replace("[", "").replace("]", ""));

		winNumbers.setForeground(Color.RED);
		winNumbers.setFont(new Font("Dialog", Font.PLAIN, 25));
		winNumbers.setBounds(340, 37, 157, 35);
		resultsPanel.add(winNumbers);

		JLabel numbersMatchedlbl = new JLabel("Matches");
		numbersMatchedlbl.setHorizontalAlignment(SwingConstants.CENTER);
		numbersMatchedlbl.setFont(new Font("Dialog", Font.BOLD, 16));
		numbersMatchedlbl.setBounds(411, 95, 86, 35);
		resultsPanel.add(numbersMatchedlbl);

		JLabel nm1 = new JLabel("nm1");
		nm1.setHorizontalAlignment(SwingConstants.CENTER);
		nm1.setFont(new Font("Dialog", Font.BOLD, 14));
		nm1.setForeground(new Color(255, 0, 0));
		nm1.setBounds(411, 128, 86, 44);
		resultsPanel.add(nm1);

		JLabel nm2 = new JLabel("nm1");
		nm2.setHorizontalAlignment(SwingConstants.CENTER);
		nm2.setFont(new Font("Dialog", Font.BOLD, 14));
		nm2.setForeground(new Color(255, 0, 0));
		nm2.setBounds(411, 168, 86, 35);
		resultsPanel.add(nm2);

		JLabel nm3 = new JLabel("nm1");
		nm3.setHorizontalAlignment(SwingConstants.CENTER);
		nm3.setFont(new Font("Dialog", Font.BOLD, 14));
		nm3.setForeground(new Color(255, 0, 0));
		nm3.setBounds(411, 205, 86, 44);
		resultsPanel.add(nm3);

		JLabel nm4 = new JLabel("nm1");
		nm4.setHorizontalAlignment(SwingConstants.CENTER);
		nm4.setFont(new Font("Dialog", Font.BOLD, 14));
		nm4.setForeground(new Color(255, 0, 0));
		nm4.setBounds(411, 245, 86, 44);
		resultsPanel.add(nm4);

		JLabel nm5 = new JLabel("nm1");
		nm5.setHorizontalAlignment(SwingConstants.CENTER);
		nm5.setFont(new Font("Dialog", Font.BOLD, 14));
		nm5.setForeground(new Color(255, 0, 0));
		nm5.setBounds(411, 285, 86, 44);
		resultsPanel.add(nm5);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 131, 1, 2);
		resultsPanel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(0, 127, 500, 2);
		resultsPanel.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.BLACK);
		separator_2.setBounds(0, 167, 500, 2);
		resultsPanel.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setBounds(0, 205, 500, 2);
		resultsPanel.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setBounds(0, 247, 500, 2);
		resultsPanel.add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(Color.BLACK);
		separator_5.setBounds(0, 287, 500, 22);
		resultsPanel.add(separator_5);

		JSeparator separator_8 = new JSeparator();
		separator_8.setOrientation(SwingConstants.VERTICAL);
		separator_8.setBackground(Color.BLACK);
		separator_8.setBounds(174, 94, 11, 235);
		resultsPanel.add(separator_8);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.BLACK);
		separator_6.setBounds(0, 90, 500, 2);
		resultsPanel.add(separator_6);

		JSeparator separator_9 = new JSeparator();
		separator_9.setOrientation(SwingConstants.VERTICAL);
		separator_9.setBackground(Color.BLACK);
		separator_9.setBounds(285, 89, 11, 240);
		resultsPanel.add(separator_9);

		JSeparator separator_12 = new JSeparator();
		separator_12.setOrientation(SwingConstants.VERTICAL);
		separator_12.setBackground(Color.BLACK);
		separator_12.setBounds(499, 90, 1, 302);
		resultsPanel.add(separator_12);

		JLabel results = new JLabel("RESULTS :");
		results.setHorizontalAlignment(SwingConstants.LEFT);
		results.setFont(new Font("Dialog", Font.BOLD, 16));
		results.setBounds(20, 69, 119, 14);
		resultsPanel.add(results);

		JSeparator separator_13 = new JSeparator();
		separator_13.setOrientation(SwingConstants.VERTICAL);
		separator_13.setBackground(Color.BLACK);
		separator_13.setBounds(213, -16, 11, 92);
		resultsPanel.add(separator_13);

		JSeparator separator_14 = new JSeparator();
		separator_14.setBackground(Color.BLACK);
		separator_14.setBounds(213, 37, 301, 14);
		resultsPanel.add(separator_14);

		JSeparator separator_15 = new JSeparator();
		separator_15.setBackground(Color.BLACK);
		separator_15.setBounds(213, 75, 301, 14);
		resultsPanel.add(separator_15);

		JSeparator separator_16 = new JSeparator();
		separator_16.setBounds(0, 0, 500, 22);
		resultsPanel.add(separator_16);
		separator_16.setBackground(Color.BLACK);

		JSeparator separator_17 = new JSeparator();
		separator_17.setBackground(Color.BLACK);
		separator_17.setBounds(0, 330, 500, 22);
		resultsPanel.add(separator_17);

		JButton btnClose = new JButton("CLOSE");
		btnClose.setFont(new Font("Dialog", Font.BOLD, 13));
		btnClose.setBounds(366, 332, 131, 40);
		resultsPanel.add(btnClose);

		JSeparator separator_11 = new JSeparator();
		separator_11.setOrientation(SwingConstants.VERTICAL);
		separator_11.setBackground(Color.BLACK);
		separator_11.setBounds(411, 94, 11, 244);
		resultsPanel.add(separator_11);

		// Makes it so the " CLOSE" Button works.
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		// Cycles through 5 times and gets the values of each field in the GUI then uses
		// the Methods to do Calculations
		btnAddPerson.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				if (!textFieldFn.equals("") && !textFieldLn.equals("") && !buttonGroup.isSelected(null)) {
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
					// Clears Data after each Person
					textFieldFn.setText(" ");
					textFieldLn.setText(" ");
					buttonGroup.clearSelection();
					spinner_5.setValue(1);
					spinner_1.setValue(1);
					spinner_2.setValue(1);
					spinner_3.setValue(1);
					spinner_4.setValue(1);
					error.setText(" ");
					// Sets the " Add Person " button to " Calculate Results " on the last person to
					// be added
					if (count == 4) {
						btnAddPerson.setText("Calculate Results");
					}
					// Displays the data into the resultsFrame Panel and displays the firstPanel
					if (count == 5) {
						// Sets the First Panel to not visible so we can see the results.
						firstPanel.setVisible(false);
						generateResults();
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
						winnings1.setText("$" + NumberFormat.getNumberInstance(Locale.US).format(winAmount(p1)));
						winnings2.setText("$" + NumberFormat.getNumberInstance(Locale.US).format(winAmount(p2)));
						winnings3.setText("$" + NumberFormat.getNumberInstance(Locale.US).format(winAmount(p3)));
						winnings4.setText("$" + NumberFormat.getNumberInstance(Locale.US).format(winAmount(p4)));
						winnings5.setText("$" + NumberFormat.getNumberInstance(Locale.US).format(winAmount(p5)));
						nm1.setText(String.valueOf(generateWins(p1)));
						nm2.setText(String.valueOf(generateWins(p2)));
						nm3.setText(String.valueOf(generateWins(p3)));
						nm4.setText(String.valueOf(generateWins(p4)));
						nm5.setText(String.valueOf(generateWins(p5)));
					}
				}
				// Displays the Error text if all the fields are filled out.
				else {
					error.setText("You did not fill out all the required fields!");
				}
			}

		});

	}

	// Defines the data for each Person
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

	// Generates how many numbers each person has matched.
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

	// Does the Calculation for Winnings multiplied by their state tax then that
	// amount subtract from their winnings.
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

	// Runs methods generateWins and winAmount for each person
	public void generateResults() {
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
