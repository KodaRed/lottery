import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.*;




public class Lottery {

	private JFrame frame;
	private JSpinner textField;
	private JTextField textFieldFn;
	private JTextField textFieldLn;
   private int count = 0;
   Random gen;
   //ArrayList<People> persons = new ArrayList<>(); // don't need it. Overcomplicates.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lottery window = new Lottery();
					window.frame.setVisible(true);
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
		private String state;
		private int number1, number2, number3, number4, number5;
      
      public People(String fName, String lName, int s1, int s2, int s3, int s4, int s5){
         this.firstName = fName;
         this.lastName = lName;
         this.number1 = s1;
         this.number2 = s2;
         this.number3 = s3;
         this.number4 = s4;
         this.number5 = s5;
      }
   }
   People p1;
   People p2;
   People p3;
   People p4;
   People p5;

	public Lottery() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		gen = new Random();

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLottery = new JLabel("Lottery");
		lblLottery.setFont(new Font("Lucida Grande", Font.BOLD, 50));
		lblLottery.setBounds(233, 6, 191, 74);
		frame.getContentPane().add(lblLottery);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblFirstName.setBounds(32, 50, 96, 16);
		frame.getContentPane().add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblLastName.setBounds(32, 95, 98, 16);
		frame.getContentPane().add(lblLastName);

		JLabel spinner2 = new JLabel("2");
		spinner2.setBounds(247, 207, 13, 16);
		frame.getContentPane().add(spinner2);

		JLabel spinner1 = new JLabel("1");
		spinner1.setBounds(192, 207, 18, 16);
		frame.getContentPane().add(spinner1);

		JLabel spinner3 = new JLabel("3");
		spinner3.setBounds(302, 207, 13, 16);
		frame.getContentPane().add(spinner3);

		JLabel spinner4 = new JLabel("4");
		spinner4.setBounds(357, 207, 13, 16);
		frame.getContentPane().add(spinner4);

		JLabel spinner5 = new JLabel("5");
		spinner5.setBounds(412, 207, 13, 16);
		frame.getContentPane().add(spinner5);

		JLabel lblJackPotAmount = new JLabel("JACKPOT:");
		lblJackPotAmount.setBounds(230, 116, 61, 16);
		frame.getContentPane().add(lblJackPotAmount);

		textField = new JSpinner();
		textField.setBounds(175, 225, 40, 25);
		frame.getContentPane().add(textField);      

		JCheckBox chckbxWyoming = new JCheckBox("Wyoming");
		chckbxWyoming.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxWyoming.setBounds(32, 175, 128, 23);
		frame.getContentPane().add(chckbxWyoming);

		JLabel lblNewLabel = new JLabel("Select a State:");
		lblNewLabel.setBounds(31, 153, 109, 16);
		frame.getContentPane().add(lblNewLabel);

		JCheckBox chckbxIdaho = new JCheckBox("Idaho");
		chckbxIdaho.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxIdaho.setBounds(32, 200, 128, 23);
		frame.getContentPane().add(chckbxIdaho);

		JCheckBox chckbxNevada = new JCheckBox("Nevada");
		chckbxNevada.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxNevada.setBounds(32, 225, 128, 23);
		frame.getContentPane().add(chckbxNevada);

		JCheckBox chckbxColorado = new JCheckBox("Colorado");
		chckbxColorado.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxColorado.setBounds(32, 250, 128, 23);
		frame.getContentPane().add(chckbxColorado);

		JCheckBox chckbxUtah = new JCheckBox("Utah");
		chckbxUtah.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxUtah.setBounds(32, 275, 128, 23);
		frame.getContentPane().add(chckbxUtah);

		JLabel lblNewLabel_1 = new JLabel("Pick 5 numbers:");
		lblNewLabel_1.setBounds(172, 179, 108, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(230, 225, 40, 25);
		frame.getContentPane().add(spinner);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(285, 225, 40, 25);
		frame.getContentPane().add(spinner_1);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(340, 225, 40, 25);
		frame.getContentPane().add(spinner_2);

		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(395, 225, 40, 25);
		frame.getContentPane().add(spinner_3);

		textFieldFn = new JTextField();
		textFieldFn.setBounds(30, 70, 108, 26);
		frame.getContentPane().add(textFieldFn);
		textFieldFn.setColumns(10);

		textFieldLn = new JTextField();
		textFieldLn.setColumns(10);
		textFieldLn.setBounds(32, 115, 108, 26);
		frame.getContentPane().add(textFieldLn);

		JLabel lblJackPot = new JLabel("$10,345,981.54");
		lblJackPot.setForeground(Color.RED);
		lblJackPot.setBounds(302, 116, 125, 16);
		frame.getContentPane().add(lblJackPot);
      
      JButton btnAddPerson = new JButton("Add Person");
		btnAddPerson.setBounds(290, 287, 134, 29);
		frame.getContentPane().add(btnAddPerson);
      
      
      btnAddPerson.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent e)
        {
          // display/center the jdialog when the button is pressed
          int value1 = (Integer)spinner.getValue();
          int value2 = (Integer)spinner_1.getValue();
          int value3 = (Integer)spinner_2.getValue();
          int value4 = (Integer)spinner_3.getValue();
          int value5 = (Integer)textField.getValue();
          String fName = textFieldFn.getText();
          String lName = textFieldLn.getText();
          setData(fName, lName, value1, value2, value3, value4, value5);
        }
      });
	}
    
    
   public void setData(String fName, String lName, int s2, int s3, int s4, int s5, int s1){
      if(count == 0){
         p1 = new People(fName, lName, s1, s2, s3, s4, s5);//set struct class
      }
      if(count == 1){
         p2 = new People(fName, lName, s1, s2, s3, s4, s5);
      }
      if(count == 2){
         p3 = new People(fName, lName, s1, s2, s3, s4, s5);
      }
      if(count == 3){
         p4 = new People(fName, lName, s1, s2, s3, s4, s5);
      }
      if(count == 4){
         p5 = new People(fName, lName, s1, s2, s3, s4, s5);
         displayResults();
      }

      count++;
   }
   
   public int generateResults(People p){
      int other = 1; // make it so you can compare values to random numbers
//       if(p.number1 == gen){//needs adjustment
//          other *= 1000;   //needs adjustment
//       }
//       if(p.number2 == gen){
//          other *= 1000;
//       }
//       if(p.number3 == gen){
//          other *= 1000;
//       }
//       if(p.number4 == gen){
//          other *= 1000;
//       }
//       if(p.number5 == gen){
//          other *= 1000;
//       }
      
      return other;
   }
   
   public void displayResults(){//convert to text box and add state
      System.out.println(p1.firstName + " " + p1.lastName + " chose numbers: " + p1.number1 + " " + p1.number2 + " " + p1.number3 + " " + p1.number4 + " " + p1.number5 + " and won " + generateResults(p1));
      System.out.println(p2.firstName + " " + p2.lastName + " chose numbers: " + p2.number1 + " " + p2.number2 + " " + p2.number3 + " " + p2.number4 + " " + p2.number5 + " and won " + generateResults(p2));
      System.out.println(p3.firstName + " " + p3.lastName + " chose numbers: " + p3.number1 + " " + p3.number2 + " " + p3.number3 + " " + p3.number4 + " " + p3.number5 + " and won " + generateResults(p3));
      System.out.println(p4.firstName + " " + p4.lastName + " chose numbers: " + p4.number1 + " " + p4.number2 + " " + p4.number3 + " " + p4.number4 + " " + p4.number5 + " and won " + generateResults(p4));
      System.out.println(p5.firstName + " " + p5.lastName + " chose numbers: " + p5.number1 + " " + p5.number2 + " " + p5.number3 + " " + p5.number4 + " " + p5.number5 + " and won " + generateResults(p5));
      System.exit(0);
   }
}
