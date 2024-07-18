
    package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Cancel extends JFrame implements ActionListener {
    JLabel tfname , cancellationno , lblfcode , lbldate ;
    JTextField tfpnr ;
    JButton fetchButton,flight;

            
    public Cancel(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading =new JLabel("CANCELLATION");
        heading.setBounds(180, 20,250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN,32));
        add (heading);
       /* ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AMS/iconss/cancel.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,800,450);
        add(image);*/
        
        
         JLabel lblaadhar =new JLabel("PNR Number");
        lblaadhar.setBounds(60, 80,150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lblaadhar);
        tfpnr = new JTextField();
        tfpnr.setBounds(220 ,80 ,150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
                
        JLabel lblname =new JLabel("Name");
        lblname.setBounds(60, 130,150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lblname);
        tfname = new JLabel();
        tfname.setBounds(220 , 130 ,150, 25);
        add(tfname);
        
        JLabel lblnationality =new JLabel("Cancellation NO.");
        lblnationality.setBounds(60, 180,150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lblnationality);
        cancellationno = new JLabel(""+ random.nextInt(1000000));
        cancellationno.setBounds(220 , 180 ,150, 25);
        add(cancellationno);
        
        JLabel lbladress =new JLabel("Flight Code");
        lbladress.setBounds(60, 230,150, 25);
        lbladress.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lbladress);
        lblfcode = new JLabel();
        lblfcode.setBounds(220 , 230 ,150, 25);
        add(lblfcode);
        
        JLabel lblgender =new JLabel("Date");
        lblgender.setBounds(60, 280,150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lblgender);
        
        lbldate =new JLabel();
        lbldate.setBounds(220, 280,150, 25);
        add (lbldate);
         
  
        flight = new JButton("Cancel");
        flight.setBackground(Color.RED);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220,330,120,21);
        flight.addActionListener(this);
        add(flight);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("AMS/iconss/youn.png"));
        Image i2 =i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470,100,300,250);
        add(image);
        
       
        setSize(800 ,450);
        setLocation(350,150);
        setVisible(true);
    }
    
   public static void main(String[] args){
        new Cancel();
   }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== fetchButton){
            
        String pnr = tfpnr.getText();
       
        try{
            connection_class conn = new connection_class();
            
            String query ="select * from reservation where PNR = '"+pnr+"'";

        ResultSet rs = conn.stm.executeQuery(query);
        if(rs.next()){
            tfname.setText(rs.getString("name")); 
            lblfcode.setText(rs.getString("flightcode")); 
            lbldate.setText(rs.getString("ddate"));
        }else{
            JOptionPane.showMessageDialog(null,"Please Enter Correct PNR");
        }

            
        }catch(Exception e){
            
            e.printStackTrace();
        }
        } else if(ae.getSource()== flight){
            
        String name = tfname.getText();
        String pnr = tfpnr.getText();
        String cancelno = cancellationno.getText();
        String fcode = lblfcode.getText();
        String date = lbldate.getText();
        try{
            connection_class conn = new connection_class();
            
            String query ="insert into cancel values('"+pnr+"','"+name+"','"+cancelno+"','"+fcode+"','"+date+"')";
            
        conn.stm.executeUpdate(query);
        conn.stm.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
        
        JOptionPane.showMessageDialog(null,"TICKET CANCELLED");
        setVisible(false);

        }catch(Exception e){
            
            e.printStackTrace();
        }
        }
    }
    }
