import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;
import java.io.*;




public class Login extends JFrame implements ActionListener{
	
	JLabel txUserID, txPW;
    
	JTextField tfUserID, tfPW; 
    
	JButton btnLogin;
    
	JPanel panelLogin, panelUserID, panelPW;
	
	//JList ;
	
	//DefaultListModel<String>dfContacts;
	
	//JComboBox<String> GenderBox;
	
	private boolean _clickMeMode = true;
	//private String[] gender = { "Male", "Female" , "Transgender"};
	
	Login () {
	//add text label
	txUserID = new JLabel("Username");
	txPW = new JLabel ("Password");
	
	
	
	// add text field
	tfUserID = new JTextField (20);
	tfPW = new JTextField (20);
	
	
	
	// add button
	btnLogin = new JButton ("Login");
	
	//add button as an event listener
	btnLogin.addActionListener(this);
	//public void actionPerformed(ActionEvent event){
	//		System.exit(0);
	//		}
	//	});
        //clickButton = new JButton("Return");
        //Add button as an event listener
        //clickButton.addActionListener(this);
		
		
	//create panel
	panelLogin = new JPanel();
	panelUserID = new JPanel ();
	panelPW = new JPanel ();
	
	
	
	//Specify layout manager and background color
       
	    panelLogin.setLayout(new BorderLayout(50,50));
        panelLogin.setBackground(Color.blue);	

	// Subpanel
		panelUserID.setLayout(new BorderLayout(50,50));
        panelUserID.setBackground(Color.blue);
		
		
		panelPW.setLayout(new BorderLayout(50,50));
        panelPW.setBackground(Color.blue);
	
		panelUserID.add(BorderLayout.EAST, tfUserID);
		panelUserID.add(BorderLayout.WEST, txUserID);
		
		panelPW.add(BorderLayout.EAST, tfPW);
		panelPW.add(BorderLayout.WEST, txPW);
	
	
	
	
	//Main panel
		panelLogin.add(BorderLayout.NORTH, panelUserID);

		//Add label and button to panel
        getContentPane().add(panelLogin);
	}
	
	public void actionPerformed(ActionEvent event){
		Object source = event.getSource();
		
	
		if ( source == btnLogin){
			String UserID = tfUserID.getText();
			String Password = tfPW.getText();
		}else{
			tfUserID.setText("");
			tfPW.setText(""); 
		}
	}
		//	String lastname = textField3.getText();
		//	String age = textField4.getText();
			//String gender = Genderbox.getText();
		//	String sex = (String) GenderBox.getSelectedItem();
		//	String mobilenumber = textField6.getText();
			
			 //CopyFile n = new CopyFile ();
				//n.submain();
        //if (firstname.isEmpty() || familyname.isEmpty()) return;

       // int size = listContacts.getModel().getSize();
       // dfContacts.add(size, firstname + "  " + middlename + "  " + lastname + "  " + age + "  ,  " + sex + "  ,  " + mobilenumber );

        //textField.setText("");
        //textField2.setText("");
        //textField3.setText("");
		//textField4.setText("");
		//GenderBox.setText("");
		//textField6.setText("");
		//} else if (source == button3) {
			//int index = -1;
			//if ((index = listContacts.getSelectedIndex()) != -1){
			//	dfContacts.remove(index);
			//} else {
			//	dfContacts.removeAllElements();
			//}		
		//}else if (source == button2){
			//save();
		//}else if (source ==button5){
			//load();
		//}
	
	
	public static void main(String[] args){
        //Create top-level frame
        Login frame = new Login();
        frame.setTitle("Login");

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