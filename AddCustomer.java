package AMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
  
    JTextField tfname , tfphone ,tfemail ,tfaadhar , tfnationality , tfadress;
    JRadioButton rbmale, rbfemale,rbothers;
            
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20,500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN,32));
        heading.setForeground(Color.BLUE);
        add (heading);
        
        JLabel lblname =new JLabel("Name");
        lblname.setBounds(60, 80,150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lblname);
        tfname = new JTextField();
        tfname.setBounds(220 , 80 ,150, 25);
        add(tfname);
        
        JLabel lblnationality =new JLabel("Nationality");
        lblnationality.setBounds(60, 130,150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lblnationality);
        tfnationality = new JTextField();
        tfnationality.setBounds(220 , 130 ,150, 25);
        add(tfnationality);
        
         JLabel lblaadhar =new JLabel("Adhar Number");
        lblaadhar.setBounds(60, 180,150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lblaadhar);
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220 , 180 ,150, 25);
        add(tfaadhar);
        
        JLabel lbladress =new JLabel("Adress");
        lbladress.setBounds(60, 230,150, 25);
        lbladress.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lbladress);
        tfadress = new JTextField();
        tfadress.setBounds(220 , 230 ,150, 25);
        add(tfadress);
        
        JLabel lblgender =new JLabel("Gender");
        lblgender.setBounds(60, 280,150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
         rbmale = new JRadioButton("Male");
        rbmale.setBounds(220 , 280 , 70 ,25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
         rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(290 , 280 , 70 ,25);
         rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
         rbothers = new JRadioButton("Others");
        rbothers.setBounds(250 , 310 , 70 ,25);
         rbothers.setBackground(Color.WHITE);
        add(rbothers);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        gendergroup.add(rbothers);
        
        JLabel lblphone =new JLabel("Phone");
        lblphone.setBounds(60, 360,150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lblphone);
        tfphone = new JTextField();
        tfphone.setBounds(220 , 360 ,150, 25);
        add(tfphone);
        
          JLabel lblemail =new JLabel("Email");
        lblemail.setBounds(60, 410,150, 25);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN,16));
        add (lblemail);
        tfemail = new JTextField();
        tfemail.setBounds(220 , 410 ,150, 25);
        add(tfemail);

        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,460,150,30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("AMS/iconss/th.jpeg"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80 , 380 , 400);
        add(lblimage);
        
        setSize(900 ,600);
        setLocation(300,150);
        setVisible(true);
    }
    
   public static void main(String[] args){
       new AddCustomer();
   }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getName();
        String adress = tfadress.getText();
        String email = tfemail.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        }else if(rbfemale.isSelected()){
            gender = "Female";
        }else{
            gender = "Others";
        }
        try{
            connection_class conn = new connection_class();
            
            String query =" insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+adress+"','"+aadhar+"','"+gender+"','"+email+"')";

      conn.stm.executeUpdate(query);
      
      JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
      setVisible(false);
            
        }catch(Exception e){
            
            e.printStackTrace();
        }
    }
}
