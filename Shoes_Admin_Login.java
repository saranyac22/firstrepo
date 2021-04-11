
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.border.BevelBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class user_login extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel userLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JCheckBox showPassword = new JCheckBox("Show Password");
	JButton SignupButton = new JButton("SIGN UP");
	

	user_login() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		Connect();

	}

	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	DefaultTableModel d;

	public void Connect()

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "Simplilearn");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {
		userLabel.setBounds(50, 150, 100, 30);
		passwordLabel.setBounds(50, 220, 100, 30);
		userTextField.setBounds(150, 150, 150, 30);
		passwordField.setBounds(150, 220, 150, 30);
		showPassword.setBounds(150, 250, 150, 30);
		loginButton.setBounds(50, 300, 100, 30);
		resetButton.setBounds(200, 300, 100, 30);
		SignupButton.setBounds(130,380,100,30);

	}

	public void addComponentsToContainer() {
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
		container.add(loginButton);
		container.add(resetButton);
		container.add(SignupButton);
	}

	public void addActionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
		SignupButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			String userText;
			String pwdText;
			int c;
			String pwd = null;
			userText = userTextField.getText();
			pwdText = passwordField.getText();

			try {
				pat = con.prepareStatement("select * from user_details where user_name=?");
				pat.setString(1, userText);

				rs = pat.executeQuery();
				while (rs.next()) {
					pwd = rs.getString("password");
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (userText.equalsIgnoreCase(userText) && pwdText.equalsIgnoreCase(pwd)) {
				JOptionPane.showMessageDialog(this, "Login Successful");
				dispose();

				school_management frame2 = new school_management();
				frame2.setTitle("Admin Management");
				frame2.setVisible(true);
				frame2.setBounds(10, 10, 670, 600);

				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.setResizable(false);

			} else {
				JOptionPane.showMessageDialog(this, "Invalid Username or Password");
			}

		}
		if (e.getSource() == resetButton) {
			reset frame5 = new reset();
			frame5.setTitle("Reset Password");
			frame5.setVisible(true);
			frame5.setBounds(10, 10, 370, 600);
			frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame5.setResizable(false);
		}
		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}

		}
		
		if (e.getSource() == SignupButton) {
			signup frame5 = new signup();
			frame5.setTitle("Sign Up");
			frame5.setVisible(true);
			frame5.setBounds(10, 10, 370, 600);
			frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame5.setResizable(false);
		}
	}

}

class signup extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel userLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JCheckBox showPassword = new JCheckBox("Show Password");
	JButton SignupButton = new JButton("SIGN UP");
	
	
	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	DefaultTableModel d;

	public void Connect()

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "Simplilearn");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	signup() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		Connect();
		

	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {
		userLabel.setBounds(50, 150, 100, 30);
		passwordLabel.setBounds(50, 220, 100, 30);
		userTextField.setBounds(150, 150, 150, 30);
		passwordField.setBounds(150, 220, 150, 30);
		showPassword.setBounds(150, 250, 150, 30);
		SignupButton.setBounds(130,380,100,30);

	}

	public void addComponentsToContainer() {
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
	
		container.add(SignupButton);
	}

	public void addActionEvent() {
		
		SignupButton.addActionListener(this);
		showPassword.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SignupButton) {
			String userText;
			String pwdText;
			int c;
			String pwd = null;
			userText = userTextField.getText();
			pwdText = passwordField.getText();
			pwd=pwdText.toString();
			
			

			try {
				pat = con.prepareStatement("insert into user_details(user_name,password,user_type) values(?,?,?)");
				pat.setString(1, userText);
				pat.setString(2, pwd);
				pat.setString(3, "user");

				pat.executeUpdate();
				JOptionPane.showMessageDialog(this, "User signed up successfully");
				dispose();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
}
		
		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}

		}
		
	}
	
}


class reset extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel userLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JCheckBox showPassword = new JCheckBox("Show Password");
	JButton SignupButton = new JButton("RESET");
	
	
	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	DefaultTableModel d;

	public void Connect()

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "Simplilearn");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	reset() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		Connect();
		

	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {
		userLabel.setBounds(50, 150, 100, 30);
		passwordLabel.setBounds(50, 220, 100, 30);
		userTextField.setBounds(150, 150, 150, 30);
		passwordField.setBounds(150, 220, 150, 30);
		showPassword.setBounds(150, 250, 150, 30);
		SignupButton.setBounds(130,380,100,30);

	}

	public void addComponentsToContainer() {
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(showPassword);
	
		container.add(SignupButton);
	}

	public void addActionEvent() {
		
		SignupButton.addActionListener(this);
		showPassword.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == SignupButton) {
			String userText;
			String pwdText;
			int c;
			String pwd = null;
			userText = userTextField.getText();
			pwdText = passwordField.getText();
			
			
			

			try {
				pat = con.prepareStatement("update user_details set password='"+pwdText+"' where user_name='"+userText+"'");
			
				

				pat.executeUpdate();
				JOptionPane.showMessageDialog(this, "Password Reset Successfully");
				dispose();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
}
		
		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}

		}
		
	}
	
}







class school_management extends JFrame implements ActionListener {

	Container container = getContentPane();
	JButton classmgmt = new JButton("Product Management");
	JButton submgmt = new JButton("Users Management");
	JButton studmgmt = new JButton("Student Management");
	JButton tchrmgmt = new JButton("Teacher Management");
	JButton classreport = new JButton("Purchase Report");
	JButton clsbtn = new JButton("Close");

	school_management() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {
		classmgmt.setBounds(50, 150, 200, 60);
		submgmt.setBounds(260, 150, 200, 60);
		studmgmt.setBounds(390, 150, 200, 60);
		tchrmgmt.setBounds(350, 320, 200, 60);
		classreport.setBounds(470, 150, 180, 60);
		clsbtn.setBounds(280, 250, 90, 30);
	}

	public void addComponentsToContainer() {
		container.add(classmgmt);
		container.add(submgmt);
		//container.add(studmgmt);
		//container.add(tchrmgmt);
		container.add(classreport);
		container.add(clsbtn);

	}

	public void addActionEvent() {
		classmgmt.addActionListener(this);
		submgmt.addActionListener(this);
		studmgmt.addActionListener(this);
		tchrmgmt.addActionListener(this);
		classreport.addActionListener(this);
		clsbtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == classmgmt) {
			class_mgmt frame5 = new class_mgmt();
			frame5.setTitle("Class Management");
			frame5.setVisible(true);
			frame5.setBounds(10, 10, 1200, 680);
			frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame5.setResizable(false);

		}
		if (e.getSource() == submgmt) {

			subj_mgmt frame3 = new subj_mgmt();
			frame3.setTitle("Subject Management");
			frame3.setVisible(true);
			frame3.setBounds(10, 10, 1000, 680);
			frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame3.setResizable(false);
		}
		if (e.getSource() == studmgmt) {

			stud_mgmt frame4 = new stud_mgmt();
			frame4.setTitle("Student Management");
			frame4.setVisible(true);
			frame4.setBounds(10, 10, 1400, 680);
			frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame4.setResizable(false);

		}
		if (e.getSource() == tchrmgmt) {
			tchr_mgmt frame6 = new tchr_mgmt();
			frame6.setTitle("Teacher Management");
			frame6.setVisible(true);
			frame6.setBounds(10, 10, 1000, 680);
			frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame6.setResizable(false);
		}

		if (e.getSource() == classreport) {
			purchase_report frame7 = new purchase_report();
			frame7.setTitle("Purchase Report");
			frame7.setVisible(true);
			frame7.setBounds(10, 10, 1300, 680);
			frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame7.setResizable(false);
		}
		if (e.getSource() == clsbtn) {
			dispose();
		}

	}
}

class class_mgmt extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel subjid = new JLabel("Product ID");
	JLabel subjname = new JLabel("Product Name");
	JLabel prodtype = new JLabel("Product Type");
	JLabel prodsize = new JLabel("Product Size");
	JLabel prodcat = new JLabel("Product Ctgry");
	
	JTextField subjid1 = new JTextField();
	JTextField subjname1 = new JTextField();
	JTextField prodtype1 = new JTextField();
	JTextField prodsize1 = new JTextField();
	JTextField prodcat1 = new JTextField();
	

	JTable table1 = new JTable();

	JButton saveval = new JButton("Add");
	JButton rmvval = new JButton("Delete");
	JButton closebtn = new JButton("Go Back");

	class_mgmt() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		Connect();
		Connect_fetch();

	}

	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	DefaultTableModel d = null;

	public void Connect()

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "Simplilearn");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Connect_fetch() {
		String[] columnNames = { "Product ID", "Product Name","Product Type","Product Size","Product Category" };

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table1.setModel(model);

		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table1.setFillsViewportHeight(true);
		try {

			int c;
			pat = con.prepareStatement("select * from product_details order by product_id asc");
			rs = pat.executeQuery();

			ResultSetMetaData rsd = rs.getMetaData();
			c = rsd.getColumnCount();

			d = (DefaultTableModel) table1.getModel();
			d.setRowCount(0);

			while (rs.next()) {
				Vector v2 = new Vector();
				for (int i = 1; i <= c; i++) {
					v2.add(rs.getString("product_id"));
					v2.add(rs.getString("product_name"));
					v2.add(rs.getString("product_type"));
					v2.add(rs.getString("product_size"));
					v2.add(rs.getString("product_category"));
										
				}

				d.addRow(v2);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void setLayoutManager() {
		container.setLayout(null);

	}

	public void setLocationAndSize() {
		subjid.setBounds(50, 150, 120, 30);
		subjid1.setBounds(180, 150, 150, 30);
		subjname.setBounds(50, 200, 120, 30);
		subjname1.setBounds(180, 200, 150, 30);
		prodtype.setBounds(50, 250, 120, 30);
		prodtype1.setBounds(180, 250, 150, 30);
		prodsize.setBounds(50, 300, 120, 30);
		prodsize1.setBounds(180, 300, 150, 30);
		prodcat.setBounds(50, 350, 120, 30);
		prodcat1.setBounds(180, 350, 150, 30);

		saveval.setBounds(50, 400, 100, 30);
		rmvval.setBounds(160, 400, 100, 30);
		closebtn.setBounds(270, 400, 100, 30);
		table1.setBounds(410, 150, 700, 300);
		table1.getTableHeader().setBounds(410, 120, 700, 30);

	}

	public void addComponentsToContainer() {
		container.add(subjid);
		container.add(subjname);
		container.add(subjid1);
		container.add(prodtype);
		container.add(prodtype1);
		container.add(prodsize);
		container.add(prodsize1);

		container.add(subjname1);
		container.add(prodcat);
		container.add(prodcat1);
		

		container.add(saveval);
		container.add(rmvval);
		container.add(closebtn);
		container.add(table1);
		container.add(table1.getTableHeader());

	}

	public void addActionEvent() {
		saveval.addActionListener(this);
		rmvval.addActionListener(this);
		closebtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveval) {
			try {

				String classname = subjname1.getText();
				String classid = subjid1.getText();
				String prodtype = prodtype1.getText();
				String prodsize = prodsize1.getText();
				String prodcat = prodcat1.getText();
				
				pat = con.prepareStatement("insert into product_details(product_id,product_name,product_type,product_size,product_category)values(?,?,?,?,?)");
				pat.setString(1, classid);
				pat.setString(2, classname);
				pat.setString(3, prodtype);
				pat.setString(4, prodsize);
				pat.setString(5, prodcat);
				
				pat.executeUpdate();
				JOptionPane.showMessageDialog(this, "Product Added Successfully");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == rmvval) {

			try {

				String classid = subjid1.getText();
				pat = con.prepareStatement("delete from product_details where product_id=?");
				pat.setString(1, classid);

				pat.executeUpdate();

				JOptionPane.showMessageDialog(this, "Product Deleted Successfully");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == closebtn) {
			dispose();

		}
	}

}





class subj_mgmt extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel subjid = new JLabel("User Name");
	JLabel subjname = new JLabel("Password");
	JLabel classname = new JLabel("User Type");
	JLabel tchrnme = new JLabel("Teacher FName");
	JLabel tchrlnme = new JLabel("Teacher LName");
	JTextField subjid1 = new JTextField();
	JTextField subjname1 = new JTextField();
	JTextField classname1 = new JTextField();
	JTextField tchrnme1 = new JTextField();
	JTextField tchrlnme1 = new JTextField();

	JButton saveval = new JButton("Add");
	JButton rmvval = new JButton("Delete");
	JButton closebtn = new JButton("Go Back");
	JButton searchuser = new JButton("Search User");

	JTable table1 = new JTable();

	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	DefaultTableModel d;

	public void Connect()

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "Simplilearn");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Connect_fetch() {
		String[] columnNames = { "User Name", "Password", "User Type" };

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table1.setModel(model);

		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table1.setFillsViewportHeight(true);
		try {

			int c;
			pat = con.prepareStatement("select * from user_details order by user_name asc");
			rs = pat.executeQuery();

			ResultSetMetaData rsd = rs.getMetaData();
			c = rsd.getColumnCount();

			d = (DefaultTableModel) table1.getModel();
			d.setRowCount(0);

			while (rs.next()) {
				Vector v2 = new Vector();
				for (int i = 1; i <= c; i++) {
					v2.add(rs.getString("user_name"));
					v2.add(rs.getString("password"));
					v2.add(rs.getString("user_type"));
				
				}

				d.addRow(v2);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	subj_mgmt() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		Connect();
		Connect_fetch();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {
		subjid.setBounds(50, 90, 120, 30);
		subjname.setBounds(50, 150, 120, 30);
		classname.setBounds(50, 210, 120, 30);
		tchrnme.setBounds(50, 270, 120, 30);
		tchrlnme.setBounds(50, 330, 120, 30);
		subjid1.setBounds(180, 90, 150, 30);
		subjname1.setBounds(180, 150, 150, 30);
		classname1.setBounds(180, 210, 150, 30);
		tchrnme1.setBounds(180, 270, 150, 30);
		tchrlnme1.setBounds(180, 330, 150, 30);
		saveval.setBounds(50, 400, 100, 30);
		rmvval.setBounds(160, 400, 100, 30);
		closebtn.setBounds(270, 400, 100, 30);
		searchuser.setBounds(150, 500, 150, 30);
		table1.setBounds(410, 120, 500, 450);
		table1.getTableHeader().setBounds(410, 90, 500, 30);
	}

	public void addComponentsToContainer() {
		container.add(subjid);
		container.add(subjname);
		container.add(classname);
		//container.add(tchrnme);
		container.add(subjid1);
		container.add(subjname1);
		container.add(classname1);
		//container.add(tchrnme1);
		//container.add(tchrlnme);
		//container.add(tchrlnme1);
		container.add(saveval);
		container.add(rmvval);
		container.add(closebtn);
		container.add(searchuser);
		container.add(table1);
		container.add(table1.getTableHeader());
	}

	public void addActionEvent() {
		saveval.addActionListener(this);
		rmvval.addActionListener(this);
		closebtn.addActionListener(this);
		searchuser.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveval) {
			try {
				String subjid = subjid1.getText();
				String subjname = subjname1.getText();
				String classname = classname1.getText();
				String tchrname = tchrnme1.getText();
				String tchrlname = tchrlnme1.getText();

				pat = con.prepareStatement(
						"insert into user_details(user_name,password,user_type)values(?,?,?)");
				pat.setString(1, subjid);
				pat.setString(2, subjname);
				pat.setString(3, classname);
			

				pat.executeUpdate();
				JOptionPane.showMessageDialog(this, "User Added Successfully");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == rmvval) {
			try {
				String subjid = subjid1.getText();

				pat = con.prepareStatement("delete from user_details where user_name=?");
				pat.setString(1, subjid);
				pat.executeUpdate();
				JOptionPane.showMessageDialog(this, "User Deleted Successfully");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == closebtn) {
			dispose();

		}
		
		if (e.getSource() == searchuser) {
			class_report frame7 = new class_report();
			frame7.setTitle("Class Report");
			frame7.setVisible(true);
			frame7.setBounds(10, 10, 1300, 680);
			frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame7.setResizable(false);

		}
	}

}

class stud_mgmt extends JFrame implements ActionListener {

	Container container = getContentPane();

	JLabel studid = new JLabel("Student ID");
	JLabel studfname = new JLabel("Student First Name");
	JLabel studlname = new JLabel("Student Last Name");
	JLabel studsx = new JLabel("Sex");
	JLabel studdob = new JLabel("DOB (YYYY-MM-DD)");
	JLabel studaddrline1 = new JLabel("Class Name");
	JLabel studaddrline2 = new JLabel("Address");
	JLabel studaddrzip = new JLabel("Zip Code");
	JLabel studphn = new JLabel("Phone Number");

	JTextField studid1 = new JTextField();
	JTextField studfname1 = new JTextField();
	JTextField studlname1 = new JTextField();
	JTextField studsx1 = new JTextField();
	JTextField studdob1 = new JTextField();
	JTextField studaddrline11 = new JTextField();
	JTextField studaddrline21 = new JTextField();
	JTextField studaddrzip1 = new JTextField();
	JTextField studphn1 = new JTextField();

	JButton saveval = new JButton("Add");
	JButton rmvval = new JButton("Delete");
	JButton closebtn = new JButton("Go Back");

	JTable table1 = new JTable();

	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	DefaultTableModel d;

	public void Connect()

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "Simplilearn");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Connect_fetch() {
		String[] columnNames = { "Student ID", "Student FName", "Student LName", "Sex", "DOB", "Class Name", "Address",
				"Zip Code", "Phone Number" };

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table1.setModel(model);

		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table1.setFillsViewportHeight(true);
		try {

			int c;
			pat = con.prepareStatement("select * from student_details order by student_id asc");
			rs = pat.executeQuery();

			ResultSetMetaData rsd = rs.getMetaData();
			c = rsd.getColumnCount();

			d = (DefaultTableModel) table1.getModel();
			d.setRowCount(0);

			while (rs.next()) {
				Vector v2 = new Vector();
				for (int i = 1; i <= c; i++) {
					v2.add(rs.getString("student_id"));
					v2.add(rs.getString("student_first_name"));
					v2.add(rs.getString("student_last_name"));
					v2.add(rs.getString("sex"));
					v2.add(rs.getString("dob"));
					v2.add(rs.getString("class_name"));
					v2.add(rs.getString("address"));
					v2.add(rs.getString("zip_cd"));
					v2.add(rs.getString("phn_nmbr"));

				}

				d.addRow(v2);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	stud_mgmt() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		Connect();
		Connect_fetch();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {
		studid.setBounds(50, 0, 160, 30);
		studfname.setBounds(50, 60, 160, 30);
		studlname.setBounds(50, 120, 160, 30);
		studsx.setBounds(50, 180, 160, 30);
		studdob.setBounds(50, 240, 160, 30);
		studaddrline1.setBounds(50, 300, 160, 30);
		studaddrline2.setBounds(50, 360, 160, 30);
		studaddrzip.setBounds(50, 420, 160, 30);
		studphn.setBounds(50, 480, 160, 30);

		studid1.setBounds(220, 0, 150, 30);
		studfname1.setBounds(220, 60, 150, 30);
		studlname1.setBounds(220, 120, 150, 30);
		studsx1.setBounds(220, 180, 150, 30);
		studdob1.setBounds(220, 240, 150, 30);
		studaddrline11.setBounds(220, 300, 150, 30);
		studaddrline21.setBounds(220, 360, 150, 30);
		studaddrzip1.setBounds(220, 420, 150, 30);
		studphn1.setBounds(220, 480, 150, 30);

		saveval.setBounds(50, 530, 100, 30);
		rmvval.setBounds(160, 530, 100, 30);
		closebtn.setBounds(270, 530, 100, 30);

		table1.setBounds(410, 30, 980, 450);
		table1.getTableHeader().setBounds(410, 0, 980, 30);
	}

	public void addComponentsToContainer() {
		container.add(studid);
		container.add(studfname);
		container.add(studlname);
		container.add(studsx);
		container.add(studdob);
		container.add(studaddrline1);
		container.add(studaddrline2);
		container.add(studaddrzip);
		container.add(studphn);
		container.add(studid1);
		container.add(studfname1);
		container.add(studlname1);
		container.add(studsx1);
		container.add(studdob1);
		container.add(studaddrline11);
		container.add(studaddrline21);
		container.add(studaddrzip1);
		container.add(studphn1);
		container.add(saveval);
		container.add(rmvval);
		container.add(closebtn);
		container.add(table1);
		container.add(table1.getTableHeader());
	}

	public void addActionEvent() {
		saveval.addActionListener(this);
		rmvval.addActionListener(this);
		closebtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveval) {
			try {
				String studid = studid1.getText();
				String studfname = studfname1.getText();
				String studlname = studlname1.getText();
				String studsx = studsx1.getText();
				String studdob = studdob1.getText();
				String studaddr1 = studaddrline11.getText();
				String studaddr2 = studaddrline21.getText();
				String studzip = studaddrzip1.getText();
				String studph = studphn1.getText();

				pat = con.prepareStatement(
						"insert into student_details(student_id,student_first_name,student_last_name,sex,dob,class_name,address,zip_cd,phn_nmbr)values(?,?,?,?,?,?,?,?,?)");
				pat.setString(1, studid);
				pat.setString(2, studfname);
				pat.setString(3, studlname);
				pat.setString(4, studsx);
				pat.setString(5, studdob);
				pat.setString(6, studaddr1);
				pat.setString(7, studaddr2);
				pat.setString(8, studzip);
				pat.setString(9, studph);

				pat.executeUpdate();
				JOptionPane.showMessageDialog(this, "Student Details Added Successfully");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == rmvval) {

			try {
				String studid = studid1.getText();

				pat = con.prepareStatement("delete from student_details where student_id=?");
				pat.setString(1, studid);
				pat.executeUpdate();
				JOptionPane.showMessageDialog(this, "Student Details Deleted Successfully");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == closebtn) {
			dispose();

		}
	}

}

class purchase_report extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel tchrid = new JLabel("Purchase Date(YYYY-MM-DD)");
	JLabel purchasecat = new JLabel("Purchase Category");

	JTextField tchrid1 = new JTextField();
	JTextField purchasecat1 = new JTextField();

	JButton saveval = new JButton("Fetch Purchase Report");
	JButton closebt = new JButton("Close");

	JTable table1 = new JTable();

	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	DefaultTableModel d;

	public void Connect()

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "Simplilearn");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Connect_fetch() {
		String[] columnNames = { "Purchase ID", "Purchase Category", "Purchase Date", "Purchase Amount","Order ID" };

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table1.setModel(model);

		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table1.setFillsViewportHeight(true);
		try {
			String userText = tchrid1.getText();
			String userText1 = purchasecat1.getText();
			int c;
			pat = con.prepareStatement(
					"Select * from purchase_details where purchase_date=? and purchase_category=?");
			pat.setString(1, userText);
			pat.setString(2, userText1);
			rs = pat.executeQuery();

			ResultSetMetaData rsd = rs.getMetaData();
			c = rsd.getColumnCount();

			d = (DefaultTableModel) table1.getModel();
			d.setRowCount(0);

			while (rs.next()) {
				Vector v2 = new Vector();
				for (int i = 1; i <= c; i++) {
					v2.add(rs.getString("purchase_id"));
					v2.add(rs.getString("purchase_category"));
					v2.add(rs.getString("purchase_date"));
					v2.add(rs.getString("purchase_amount"));
					v2.add(rs.getString("order_id"));
				}

				d.addRow(v2);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	purchase_report() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		Connect();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {
		tchrid.setBounds(10, 30, 200, 30);

		tchrid1.setBounds(210, 30, 150, 30);
		purchasecat.setBounds(10, 80, 200, 30);

		purchasecat1.setBounds(210, 80, 150, 30);

		saveval.setBounds(100, 120, 200, 30);
		closebt.setBounds(310, 120, 100, 30);

		table1.setBounds(410, 30, 850, 450);
		table1.getTableHeader().setBounds(410, 0, 850, 30);

	}

	public void addComponentsToContainer() {
		container.add(tchrid);

		container.add(tchrid1);
		container.add(purchasecat);

		container.add(purchasecat1);

		container.add(saveval);
		container.add(closebt);

		container.add(table1);
		container.add(table1.getTableHeader());

	}

	public void addActionEvent() {
		saveval.addActionListener(this);
		closebt.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveval) {

			Connect_fetch();
		}

		if (e.getSource() == closebt) {

			dispose();

		}

	}

}

class tchr_mgmt extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel tchrid = new JLabel("Teacher ID");
	JLabel subjname = new JLabel("Teacher First Name");
	JLabel classname = new JLabel("Teacher Last Name");
	JLabel tchrnme = new JLabel("Class Name");
	JTextField tchrid1 = new JTextField();
	JTextField subjname1 = new JTextField();
	JTextField classname1 = new JTextField();
	JTextField tchrnme1 = new JTextField();

	JButton saveval = new JButton("Add");
	JButton rmvval = new JButton("Delete");
	JButton closebtn = new JButton("Go Back");

	JTable table1 = new JTable();

	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	DefaultTableModel d;

	public void Connect()

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "Simplilearn");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Connect_fetch() {
		String[] columnNames = { "Teacher ID", "Teacher FName", "Teacher LName", "Class Name" };

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table1.setModel(model);

		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table1.setFillsViewportHeight(true);
		try {

			int c;
			pat = con.prepareStatement("select * from teacher_details order by teacher_id asc");
			rs = pat.executeQuery();

			ResultSetMetaData rsd = rs.getMetaData();
			c = rsd.getColumnCount();

			d = (DefaultTableModel) table1.getModel();
			d.setRowCount(0);

			while (rs.next()) {
				Vector v2 = new Vector();
				for (int i = 1; i <= c; i++) {
					v2.add(rs.getString("teacher_id"));
					v2.add(rs.getString("teacher_first_name"));
					v2.add(rs.getString("teacher_last_name"));
					v2.add(rs.getString("class_name"));
				}

				d.addRow(v2);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	tchr_mgmt() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		Connect();
		Connect_fetch();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {
		tchrid.setBounds(50, 90, 150, 30);
		subjname.setBounds(50, 150, 150, 30);
		classname.setBounds(50, 210, 150, 30);
		tchrnme.setBounds(50, 270, 150, 30);
		tchrid1.setBounds(210, 90, 150, 30);
		subjname1.setBounds(210, 150, 150, 30);
		classname1.setBounds(210, 210, 150, 30);
		tchrnme1.setBounds(210, 270, 150, 30);
		saveval.setBounds(50, 400, 100, 30);
		rmvval.setBounds(160, 400, 100, 30);
		closebtn.setBounds(270, 400, 100, 30);
		table1.setBounds(410, 120, 450, 450);
		table1.getTableHeader().setBounds(410, 90, 450, 30);
	}

	public void addComponentsToContainer() {
		container.add(tchrid);
		container.add(subjname);
		container.add(classname);
		container.add(tchrnme);
		container.add(tchrid1);
		container.add(subjname1);
		container.add(classname1);
		container.add(tchrnme1);
		container.add(saveval);
		container.add(rmvval);
		container.add(closebtn);
		container.add(table1);
		container.add(table1.getTableHeader());
	}

	public void addActionEvent() {
		saveval.addActionListener(this);
		rmvval.addActionListener(this);
		closebtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveval) {
			try {
				String teacherid = tchrid1.getText();
				String teacherfname = subjname1.getText();
				String teacherlname = classname1.getText();
				String phnnumbr = tchrnme1.getText();
				;

				pat = con.prepareStatement(
						"insert into teacher_details(teacher_id,teacher_first_name,teacher_last_name,class_name)values(?,?,?,?)");
				pat.setString(1, teacherid);
				pat.setString(2, teacherfname);
				pat.setString(3, teacherlname);
				pat.setString(4, phnnumbr);

				pat.executeUpdate();
				JOptionPane.showMessageDialog(this, "Teacher Details Added Successfully");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource() == rmvval) {

			try {
				String tchrid = tchrid1.getText();

				pat = con.prepareStatement("delete from teacher_details where teacher_id=?");
				pat.setString(1, tchrid);
				pat.executeUpdate();
				JOptionPane.showMessageDialog(this, "Teacher Details Deleted Successfully");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == closebtn) {
			dispose();

		}
	}

}

class class_report extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel tchrid = new JLabel("User Name");

	JTextField tchrid1 = new JTextField();

	JButton saveval = new JButton("Fetch Report");
	JButton closebt = new JButton("Close");

	JTable table1 = new JTable();

	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	DefaultTableModel d;

	public void Connect()

	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "Simplilearn");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Connect_fetch() {
		String[] columnNames = { "User Name", "Password", "User Type" };

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table1.setModel(model);

		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table1.setFillsViewportHeight(true);
		try {
			String userText = tchrid1.getText();
			int c;
			pat = con.prepareStatement(
					"Select * from user_details where user_name=?");
			pat.setString(1, userText);
			rs = pat.executeQuery();

			ResultSetMetaData rsd = rs.getMetaData();
			c = rsd.getColumnCount();

			d = (DefaultTableModel) table1.getModel();
			d.setRowCount(0);

			while (rs.next()) {
				Vector v2 = new Vector();
				for (int i = 1; i <= c; i++) {
					v2.add(rs.getString("user_name"));
					v2.add(rs.getString("password"));
					v2.add(rs.getString("user_type"));
				
				}

				d.addRow(v2);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	class_report() {
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();
		Connect();

	}

	public void setLayoutManager() {
		container.setLayout(null);
	}

	public void setLocationAndSize() {
		tchrid.setBounds(10, 30, 100, 30);

		tchrid1.setBounds(100, 30, 150, 30);

		saveval.setBounds(100, 70, 150, 30);
		closebt.setBounds(270, 70, 100, 30);

		table1.setBounds(410, 30, 850, 450);
		table1.getTableHeader().setBounds(410, 0, 850, 30);

	}

	public void addComponentsToContainer() {
		container.add(tchrid);

		container.add(tchrid1);

		container.add(saveval);
		container.add(closebt);

		container.add(table1);
		container.add(table1.getTableHeader());

	}

	public void addActionEvent() {
		saveval.addActionListener(this);
		closebt.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveval) {

			Connect_fetch();
		}

		if (e.getSource() == closebt) {

			dispose();

		}

	}

}

public class Shoes_Admin_Login {

	public static void main(String[] a) {
		user_login frame = new user_login();
		frame.setTitle("Login Form");
		frame.setBounds(10, 10, 370, 600);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setState(Frame.NORMAL);
		frame.setVisible(true);

	}

}