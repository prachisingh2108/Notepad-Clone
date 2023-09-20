package notepad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class About extends JFrame  implements ActionListener{

    About()
    {
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/windows.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(70, 40, 400, 80);
        add(l1);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/notepad.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel icon = new JLabel(i6);
        icon.setBounds(50, 180, 70, 70);
        add(icon);
        
        JLabel text =new JLabel("<html>PRACHI SINGH<br>Youtube Made in 2023 <br>PRACHI SINGH. All rights reserved<br><br>Notepad is a word processing program, <br>which allows changing of text in a computer file.<br>Notepad is a simple text editor for basic text-editing program<br> which enables computer users to create documents. </html>");
        text.setBounds(150,100,500,200);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        add(text);
        
        JButton ok=new JButton("OK");
        ok.setBounds(150,350,120,25);
        ok.addActionListener(this);
        add(ok);
        
        setBounds(400,100,600,500);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e) 
    {
        this.setVisible(false);
    }
    public static void main(String args[]) {
        new About();
    }
}
