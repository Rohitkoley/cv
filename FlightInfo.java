package AMS;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
 public class FlightInfo extends JFrame{
    
    public FlightInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table = new JTable();
        
        try{
            connection_class conn = new connection_class();
            
            ResultSet rs = conn.stm.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
        JScrollPane jsp =new JScrollPane(table);
        jsp.setBounds(0, 0, 800 , 500);
        add(jsp);
        
        setSize(800 , 500);
        setLocation(400 , 200);
        setVisible(true);
        
    }
    
    
    public static void main(String[] args){
        new FlightInfo();
    }
}
