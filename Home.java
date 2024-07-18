
package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Home extends JFrame implements ActionListener{
   
    public Home(){
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AMS/iconss/7786225.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1750, 1150, Image.SCALE_DEFAULT);
        ImageIcon imagee = new ImageIcon(i2); 
       JLabel image =new JLabel(imagee);
       image.setBounds(0,0,1600,950);
        add(image);
        
        JLabel heading = new JLabel("AIRLINE WELCOMES YOU");
        heading.setBounds(500 , 20 ,1000, 40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image.add(heading);
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details =new JMenu("DETAILS");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
       ticketCancellation.addActionListener(this);

        details.add(ticketCancellation);
        
        JMenu ticket = new JMenu("TICKET");
        menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        
        
       
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(600 , 250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        
       String text = ae.getActionCommand();
       
       if(text.equals("Add Customer Details")){
           new AddCustomer();
           
       }else if(text.equals("Flight Details")){
           new FlightInfo();
       }else if (text.equals("Book Flight")){
           new BookFlight();
       }else if(text.equals("Journey Details")){
           new journeyDetails();
       }else if (text.equals("Cancel Ticket")){
           new Cancel();
       } else if (text.equals("Boarding Pass")){
           new BoardingPass();
       }
    }
    public static void main (String[] args){
        new Home();
    }
}
