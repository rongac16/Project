import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;
import java.io.*;



	


public class EmployeeProfile extends JFrame implements ActionListener{

	
    JLabel text,text2,text3,text4,text5,text6, clicked;
    
	JTextField textField,textField2,textField3,textField4,textField6; //textField5
    
	JButton button,button2,button3,button4,button5, clickButton;
    
	JPanel panel,panel2,panel3,panel4,panel5,panel6,panel7,panel8;
	
	JList listContacts;
	
	DefaultListModel<String>dfContacts;
	
	JComboBox<String> GenderBox;
	

    private boolean _clickMeMode = true;
	private String[] gender = { "Male", "Female" , "Transgender"};
	//collection or array
	//JList ListContacts = new JList();
	
	
	
	//dummy account
	//people.add(new Person (" Rodrigo", "Roa","Duterte",73,true,));
	//people.add(new Person ("Mar","Araneta","Roxas",69,false));
	//people.add(new Person ("Benigno","Couangco","Aquino",68,false));

	

	
    EmployeeProfile() {
        
		//add text label
		text = new JLabel("First Name");
		text2 = new JLabel("Middle Name");
		text3 = new JLabel("Last Name");
		text4 = new JLabel("Age");
		text5 = new JLabel("Gender");
		text6 = new JLabel("Mobile Number");
        clicked = new JLabel("Button Clicked");
		
		//add text field
        textField = new JTextField(20);
		textField2 = new JTextField(20);
		textField3 = new JTextField(20);
		textField4 = new JTextField(20);
		GenderBox = new JComboBox<>(gender);
		textField6 = new JTextField(20);
        textField.addActionListener(this);
		
		
		
		// add button 
        button = new JButton("Add");
		button2 = new JButton("Save");
		button3 = new JButton("Delete");
		button4 = new JButton("Exit");
		button5 = new JButton("Load");
	
        
		//Add button as an event listener
        button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button5.addActionListener(this);
		button4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			System.exit(0);
			}
		});
       // clickButton = new JButton("Return");
        //Add button as an event listener
       // clickButton.addActionListener(this);
		
		

        //Create panel
        panel = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();
		panel6 = new JPanel();
		panel7 = new JPanel();
		panel8 = new JPanel();
		
		
		
		// Add List
		dfContacts = new DefaultListModel<>();
        listContacts = new JList<>(dfContacts);
		
		/*
		infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout(4, 4));
        //infoPanel.setBackground(Color.white);
        infoPanel.add(BorderLayout.WEST, labelPanel);
        infoPanel.add(BorderLayout.CENTER, fieldPanel);
        infoPanel.add(BorderLayout.SOUTH, addButton);
		*/
		
		
        //Specify layout manager and background color
       
	    panel.setLayout(new BorderLayout(50,50));
        panel.setBackground(Color.red);
		
		//First Name
		panel2.setLayout(new BorderLayout(50,10));
        panel2.setBackground(Color.gray);
		
		// Middle Name
		panel3.setLayout(new BorderLayout(50,10));
        panel3.setBackground(Color.gray);
		
		//Last Name
		panel4.setLayout(new BorderLayout(50,10));
        panel4.setBackground(Color.gray);
		
		//Age
		panel5.setLayout(new BorderLayout(50,10));
        panel5.setBackground(Color.gray);
		//Gender
		panel6.setLayout(new BorderLayout(50,10));
        panel6.setBackground(Color.gray);
		//Mobile Number
		panel7.setLayout(new BorderLayout(50,10));
        panel7.setBackground(Color.gray);
		
		
	
		
		
		//subpanel
		panel2.add(BorderLayout.SOUTH, panel3);
		panel3.add(BorderLayout.SOUTH, panel4);
		panel4.add(BorderLayout.SOUTH, panel5);
		panel5.add(BorderLayout.SOUTH, panel6);
		panel6.add(BorderLayout.SOUTH, panel7);
		
		// first name
		panel2.add(BorderLayout.EAST, textField);
		panel2.add(BorderLayout.WEST, text);
		
		// Middle Name
		panel3.add(BorderLayout.EAST, textField2);
		panel3.add(BorderLayout.WEST, text2);
		
		//Last Name
		panel4.add(BorderLayout.EAST, textField3);
		panel4.add(BorderLayout.WEST, text3);
		
		//Age
		panel5.add(BorderLayout.EAST, textField4);
		panel5.add(BorderLayout.WEST, text4);
		
		//Gender
		panel6.add(BorderLayout.EAST, GenderBox);
		panel6.add(BorderLayout.WEST, text5);
		
		//Mobile
		panel7.add(BorderLayout.EAST, textField6);
		panel7.add(BorderLayout.WEST, text6);
		
		
		
		
		
		//Main panel
		panel.add(BorderLayout.NORTH, panel2);
	    //button " Add Save Delete"
        panel.add(BorderLayout.SOUTH, panel8);
		panel8.add(BorderLayout.EAST, button);
		panel8.add(BorderLayout.WEST, button2);
		panel8.add(BorderLayout.NORTH, button3);
		panel8.add(BorderLayout.CENTER, button4);
		panel8.add(BorderLayout.SOUTH, button5);
        panel.add(BorderLayout.CENTER, new JScrollPane(listContacts));
		
		
		//Add label and button to panel
        getContentPane().add(panel);
		
		
		//people.add(new Person (" Rodrigo", "Roa","Duterte",73,true,));
		//people.add(new Person ("Mar","Araneta","Roxas",69,false));
		//people.add(new Person ("Benigno","Couangco","Aquino",68,false));
    
	}
	
	//Load
	public void load () {
		FileReader in = null;
		
		try {
			in = new FileReader ("OutputFile.txt");
			BufferedReader bufferedreader = new BufferedReader (in);
			String person;
			while ((person = bufferedreader.readLine()) !=null){
				int size = listContacts.getModel().getSize();
				dfContacts.add(size,person);
			}
			in.close();
		}catch (IOException e) {
			}
	}
	
	//Save button
	public void save () {
		FileWriter out = null;
		int size = listContacts.getModel().getSize();
		System.out.println(size);
		try {
			out = new FileWriter ("OutputFile.txt");
			for (int i = 0; i<size; i++) {
				String person = (String) listContacts.getModel().getElementAt(i) + "\n";
				out.write(person);
				System.out.println(person);
			}
			out.close();
			
			
		}catch (IOException e) {
				}
			
		
	}

    public void actionPerformed(ActionEvent event){
		Object source = event.getSource();
		
		
		if ( source == button){
			String firstname = textField.getText();
			String middlename = textField2.getText();
			String lastname = textField3.getText();
			String age = textField4.getText();
			//String gender = Genderbox.getText();
			String sex = (String) GenderBox.getSelectedItem();
			String mobilenumber = textField6.getText();
			
			 //CopyFile n = new CopyFile ();
				//n.submain();
        //if (firstname.isEmpty() || familyname.isEmpty()) return;

        int size = listContacts.getModel().getSize();
        dfContacts.add(size, firstname + "  " + middlename + "  " + lastname + "  " + age + "  ,  " + sex + "  ,  " + mobilenumber );

        textField.setText("");
        textField2.setText("");
        textField3.setText("");
		textField4.setText("");
		//GenderBox.setText("");
		textField6.setText("");
		} else if (source == button3) {
			int index = -1;
			if ((index = listContacts.getSelectedIndex()) != -1){
				dfContacts.remove(index);
			} else {
				dfContacts.removeAllElements();
			}		
		}else if (source == button2){
			save();
		}else if (source ==button5){
			load();
		}
	} 
	
		
		
		
		/*
		string firstname = textField.getText();
		String middlename = textField2.getText();
		String lastname = textField3.getText();
		String age = textField4.getText();
		String gender = textField5.getSelectedText();
		//String inputMobileNumber = textField6.getText();
	
	
		people.add(new Person (firstname,middlename,lastname,age,gender));
		
	}

	/*
		Object source = event.getSource();
        String msg = textField.getText();
        if (_clickMeMode) {
            text.setText(msg);
            button.setText("Return");
            _clickMeMode = false;
        } else {
            text.setText("First Name");
            button.setText("Add");
            _clickMeMode = true;
        */
	
		

	/*
	public void UpdateContacts(){
		//printing
		contactListString = "";
			
		for(Person n : people) {
				
             /*System.out.println(*/
			 /*
			 contactListString += 
				n.getlastname() + "," + 
				n.getfirstname() + "," + 
				n.getmiddlename()+ "," + 
				n.getage() + "," + 
				n.getgender()+ "<br/>";
	}  
		text.setText("<html>" + contactListString + "<html>");
	}	
	*/
		//}
    public static void main(String[] args){
        //Create top-level frame
        EmployeeProfile frame = new EmployeeProfile();
        frame.setTitle("EMPLOYEE PROFILE");

        //This code lets you close the window
        WindowListener l = new WindowAdapter() {
        //The instantiation of object l is extended to
        //include this code:
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        frame.addWindowListener(l);
        //This code lets you see the frame
        frame.pack();
        frame.setVisible(true);
    }
}



