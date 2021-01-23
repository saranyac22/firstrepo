package com.simplilern.files;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
import java.awt.event.WindowEvent;  
import java.awt.event.WindowListener;  

public class GUI   {
	public String inpt;


	
	
	
	public GUI() {
		JFrame frame= new JFrame();
		JButton button=new JButton("Submit");
		button.setBounds(520, 315, 100, 30);
	
		JLabel label1 =new JLabel("Welcome");
		label1.setBounds(580,30,100,200);
		JLabel label7 =new JLabel("LOCKED ME. COM");
		label7.setBounds(550,1,150,200);
		JLabel label=new JLabel("Devoloped by Saranyambika C");
		label.setBounds(700,300,250,200);
		JLabel label2=new JLabel("Enter your option");
		label2.setBounds(300,230,220,200);
		JTextField EnterYourOptionText=new JTextField();
		EnterYourOptionText.setBounds(430,315,100,30);
		inpt=EnterYourOptionText.getText();
		
		
		JLabel label3=new JLabel("Below are the options available:");
		label3.setBounds(300,80,230,200);
		JLabel label4=new JLabel("1 - Return file names in ascending order ");
		label4.setBounds(300,110,400,200);
		JLabel label5=new JLabel("2 - Add, Delete or Search for a file ");
		label5.setBounds(300,140,400,200);
		JLabel label6=new JLabel("3 - Close the Application");
		label6.setBounds(300,170,400,200);
		JPanel panel=new JPanel();
		//panel.setBorder(BorderFactory.createEmptyBorder( 100,200,100,200));
		panel.setLayout(null);
		panel.add(label1);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label2);
		panel.add(label7);
		panel.add(EnterYourOptionText);
		panel.add(button);
		panel.add(label);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("locked me .com");
		frame.pack();
		frame.setSize(1200,600);
		frame.setVisible(true);
		
	    button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            String a = EnterYourOptionText.getText();
	            System.out.println(a);
	         
	            if(a.equals("1")) {
	            
	            JFrame frame= new JFrame();
	    		JButton button=new JButton("Submit");
	    		button.setBounds(540, 65, 100, 30);
	    		JLabel label2=new JLabel("Enter the folder path");
	    		label2.setBounds(300,65,240,30);
	    		JButton button1=new JButton("Go Back");
	    		button1.setBounds(800, 365, 100, 30);
	    		
	    		JLabel lab2=new JLabel("The sorted file list is as follows:");
	    		lab2.setBounds(400,125,250,30);
	    		
	    		JLabel lab=new JLabel();
	    		lab.setBounds(400,145,600,200);
	    		
	    	
	    		
	  
	    		
	    		JTextField EnterYourOptionText=new JTextField();
	    		EnterYourOptionText.setBounds(460,65,100,30);
	    		inpt=EnterYourOptionText.getText();
	    		JPanel panel=new JPanel();
	    		panel.setBorder(BorderFactory.createEmptyBorder( 100,200,100,200));
	    		panel.setLayout(null);
	    		panel.add(label2);
	    		panel.add(EnterYourOptionText);
	    		panel.add(button);
	    		panel.add(lab2);
	    		panel.add(lab);
	    		panel.add(button1);
	    		frame.add(panel);
	    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		frame.setTitle("File Sorting");
	    		frame.pack();
	    		frame.setSize(1200,600);
	    		frame.setVisible(true);
	    		
	    		button.addActionListener(new ActionListener() {
	    	        public void actionPerformed(ActionEvent e) {
	    	            String a = EnterYourOptionText.getText();
	    	            System.out.println(a);
	    	        
	    	        File dir=new File(a);
	    	        File[] files=dir.listFiles();
	    	        Arrays.sort(files,(f1,f2) -> f1.compareTo(f2));
	    	        
	    	        StringBuilder sb=new StringBuilder();
	    	        
	    	        for (File file : files) {
	    	            if (!file.isHidden()) {
	    	             
	    	            	  if (file.isDirectory()) {
	    	            		  sb.append(",").append(file.getName()).append("");
	    	            		  lab.setText(sb + "\n");
	    	                      
	    	                   } else {
	    	                	   sb.append(System.getProperty("line.separator")).append(file.getName()).append(System.getProperty("line.separator"));
	    	                	   lab.setText(sb + "\n");
	    	                	   
	    	                      
	    	                   }
	    	            	  
	    	         
	    	              
	    	               
	    	      
	    	 
	    	            }
	    	            
	    	        }
	    	     
	    	        System.out.println(sb);
    	            
	    	             
	    	        }
	    	        
	    		
	    		});
	    		
	    		button1.addActionListener(new ActionListener() {
	    	        public void actionPerformed(ActionEvent e) {
	    		
	    	    
	    	        	
	    	        frame.setVisible(false);
	           
	            
	            }
	    		});
	    		
	           
	            }
	    		
	            else if (a.equals("2")) {
	                JFrame frame= new JFrame();
		    		JButton button=new JButton("Submit");
		    		button.setBounds(720, 65, 100, 30);
		    		JLabel label2=new JLabel("Enter the full path of the file to be added");
		    		label2.setBounds(300,65,600,30);
		    		JTextField EnterYourOptionText=new JTextField();
		    		EnterYourOptionText.setBounds(620,65,100,30);
		    		
		    		JButton button1=new JButton("Submit");
		    		button1.setBounds(720, 105, 100, 30);
		    		JLabel label21=new JLabel("Enter the full path of the file to be deleted");
		    		label21.setBounds(300,105,600,30);
		    		JTextField EnterYourOptionText1=new JTextField();
		    		EnterYourOptionText1.setBounds(620,105,100,30);
		    		
		    		JButton button2=new JButton("Submit");
		    		button2.setBounds(720, 145, 100, 30);
		    		JLabel label22=new JLabel("Enter the full path of the file to be searched");
		    		label22.setBounds(300,145,600,30);
		    		JTextField EnterYourOptionText2=new JTextField();
		    		EnterYourOptionText2.setBounds(620,145,100,30);
		    		
		    		JLabel lab=new JLabel();
		    		lab.setBounds(300,145,600,200);
		    		
		    		JButton button3=new JButton("Go Back");
		    		button3.setBounds(800, 365, 100, 30);
		    		
		    		
		    		JPanel panel=new JPanel();
		    		panel.setBorder(BorderFactory.createEmptyBorder( 100,200,100,200));
		    		panel.setLayout(null);
		    		panel.add(label2);
		    		panel.add(EnterYourOptionText);
		    		panel.add(button);
		    		
		    		panel.add(label21);
		    		panel.add(EnterYourOptionText1);
		    		panel.add(button1);
		    		
		    		panel.add(label22);
		    		panel.add(EnterYourOptionText2);
		    		panel.add(button2);
		    		panel.add(button3);
		    		panel.add(lab);
		    		
		    		frame.add(panel);
		    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    		frame.setTitle("File Sorting");
		    		frame.pack();
		    		frame.setSize(1200,600);
		    		frame.setVisible(true);
		    		
		    	
		    		
		    		button.addActionListener(new ActionListener() {
		    	        public void actionPerformed(ActionEvent e) {
		    		
		    	        	 String a = EnterYourOptionText.getText();
			    	         File file=new File(a);
			    	         boolean result;
			    	         try   
			    	         {  
			    	         result = file.createNewFile();  //creates a new file  
			    	         if(result)      // test if successfully created a new file  
			    	         {  
			    	         System.out.println("File created successfully "+file.getCanonicalPath()); //returns the path string 
			    	         lab.setText("File created successfully "+file.getCanonicalPath());
			    	         }  
			    	         else  
			    	         {  
			    	         System.out.println("File already exists at location: "+file.getCanonicalPath());
			    	         lab.setText("File already exists at location: "+file.getCanonicalPath());
			    	         }  
			    	         }   
			    	         catch (IOException e1)   
			    	         {  
			    	         e1.printStackTrace();    //prints exception if any  
			    	         }         
			    	         
		    	        
		           
		            
		            }
		    		});
		    		
		    		button1.addActionListener(new ActionListener() {
		    	        public void actionPerformed(ActionEvent e) {
		    		
		    	        	
		    	        	 String b = EnterYourOptionText1.getText();
			    	         File file=new File(b);
			    	         System.out.println(b);
			    	         boolean result;
			    	         try   
			    	         {  
			    	         result = file.delete();  //creates a new file  
			    	         if(result)      // test if successfully created a new file  
			    	         {  
			    	         System.out.println("File deleted successfully "+file.getCanonicalPath()); //returns the path string
			    	         lab.setText("File deleted successfully "+file.getCanonicalPath());
			    	         }  
			    	         else  
			    	         {  
			    	         System.out.println("File can't be deleted, since it is not available "+file.getCanonicalPath());
			    	         lab.setText("File can't be deleted, since it is not available "+file.getCanonicalPath());
			    	         }  
			    	         }   
			    	         catch (IOException e1)   
			    	         {  
			    	         e1.printStackTrace();    //prints exception if any  
			    	         }         
			    	         
		    	        
		           
		            
		            }
		    		});
		    		
		    		button2.addActionListener(new ActionListener() {
		    	        public void actionPerformed(ActionEvent e) {
		    		
		    	        	
		    	        	 String b = EnterYourOptionText2.getText();
			    	         File file=new File(b);
			    	        
			    	         boolean result;
			    	         
			    	        int iend = b.lastIndexOf("/");
			    	         String b1=b.substring(0,iend);
			    	   
			    	         File directory=new File(b1);
			    	         
			    	       
			    	         
			    	         String b2=b.substring(iend+1,b.length());
			    	      
			    	         
			    	         
			    	         
			    	         
			    	         String[] flist = directory.list(); 
			    	         int flag = 0; 
			    	         if (flist == null) { 
			    	             System.out.println("Empty Directory."); 
			    	         } 
			    	         else { 
			    	   
			    	             // Linear search in the array 
			    	             for (int i = 0; i < flist.length; i++) { 
			    	                 String filename = flist[i]; 
			    	                 if (filename.equalsIgnoreCase(b2)) { 
			    	                     System.out.println(filename + " Found");
			    	                     lab.setText(filename + " Found");
			    	                     flag = 1; 
			    	                 } 
			    	             } 
			    	         } 
			    	   
			    	         if (flag == 0) { 
			    	             System.out.println("File Not Found");
			    	             lab.setText("File Not Found");
			    	         } 
			    	     
			    	 
			    	         
			    	         
			    	         
			    	         
			    	         
			  
			    	         
		    	        
		           
		            
		            }
		    		});
		    		
		    		
		      		button3.addActionListener(new ActionListener() {
		    	        public void actionPerformed(ActionEvent e) {
		    		
		    	    
		    	        	
		    	        frame.setVisible(false);
		           
		            
		            }
		    		});
		    		
		    		
		    		
		    		
		    		
		    		
		    		
	            }
	            
	            else if (a.equals("3")) {frame.setVisible(false);}
	            
	           
	            
	           
	       	 
	    	
	            
	            
	  
	            
	           	        }  
	        
	        
	        
	        
	        
	        
	    });
			
	}
	
	

	
	
	
  


	
	public static void main (String[] args){
		new GUI();
		
	}
	
		
	}









	
		
	












