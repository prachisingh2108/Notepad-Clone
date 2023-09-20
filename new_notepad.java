package notepad;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.io.*;
public class new_notepad extends JFrame implements ActionListener{
    JTextArea area;
    String text;
    new_notepad()
    {
        setTitle("Notepad");
        ImageIcon notepad=new ImageIcon(ClassLoader.getSystemResource("icons/notepad.png"));
        Image icon= notepad.getImage();
        setIconImage(icon);
        
        
        JMenuBar menubar=new JMenuBar();
        menubar.setBackground(Color.white);
        
        
        JMenu file= new JMenu("File ");
        file.setFont(new Font("AERIAL",Font.PLAIN,14));
        
        JMenuItem newdoc=new JMenuItem("New ");
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        newdoc.addActionListener(this);
        file.add(newdoc);
        
        JMenuItem open=new JMenuItem("Open ");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        open.addActionListener(this);
        file.add(open);
        
        JMenuItem save=new JMenuItem("Save ");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        save.addActionListener(this);
        file.add(save);
        
        JMenuItem print=new JMenuItem("Print ");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        print.addActionListener(this);
        file.add(print);
        
        JMenuItem exit=new JMenuItem("Exit ");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,ActionEvent.CTRL_MASK));
        file.add(exit);
        exit.addActionListener(this);
        menubar.add(file);
        
        JMenu edit= new JMenu("Edit ");
        edit.setFont(new Font("AERIAL",Font.PLAIN,14));
        
        JMenuItem copy=new JMenuItem("Copy ");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        copy.addActionListener(this);
        edit.add(copy);
        
        JMenuItem cut=new JMenuItem("Cut ");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        cut.addActionListener(this);
        edit.add(cut);
        
        JMenuItem paste=new JMenuItem("Paste ");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        paste.addActionListener(this);
        edit.add(paste);
        
        JMenuItem selectall=new JMenuItem("Select All ");
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
        edit.add(selectall);
        selectall.addActionListener(this);
        menubar.add(edit);
        
        JMenu helpmenu= new JMenu("Help ");
        helpmenu.setFont(new Font("AERIAL",Font.PLAIN,14));
        
        JMenuItem help=new JMenuItem("About ");
        //help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
        helpmenu.add(help);
        help.addActionListener(this);
        menubar.add(helpmenu);
       
        setJMenuBar(menubar);
        
        area =new JTextArea();
        area.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JScrollPane pane=new JScrollPane(area); 
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);        
        setVisible(true);
        //setLocation();
    }
    @Override
    public  void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("New"))
        {
            area.setText("");
        }
        else if(e.getActionCommand().equals("Open"))
        {
            JFileChooser  chooser=new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict=new FileNameExtensionFilter("Only .txt files","txt");
            chooser.addChoosableFileFilter(restrict);
            int action=chooser.showOpenDialog(this);
            
            if(action!=JFileChooser.APPROVE_OPTION)
            {
                return;
            }
            File file=chooser.getSelectedFile();
            try
            {
               BufferedReader reader=new BufferedReader(new FileReader(file));//To read the file that is selected
               area.read(reader,null);
            }
            catch(Exception ae)
            {
                System.out.println(ae);
            }
        }
        else if(e.getActionCommand().equals("Save"))
        {
            JFileChooser saveas =new JFileChooser();
            saveas.setApproveButtonText("Save");
            int action=saveas.showOpenDialog(this);
            
            if(action!=JFileChooser.APPROVE_OPTION)
            {
                return;
            }
            File filename=new File(saveas.getSelectedFile()+".txt");
            BufferedWriter outFile=null;
            try
            {
                outFile=new BufferedWriter(new FileWriter(filename));
                area.write(outFile);
            }
            catch(Exception ae)
            {
                 System.out.println(ae);
            }
        }
        else if(e.getActionCommand().equals("Print"))
        {
            try
            {
                area.print();
            }
            catch(Exception ae)
            {
                 System.out.println(ae);
            } 
        }
         else if(e.getActionCommand().equals("Exit"))
         {
             System.exit(0);
         }
        else if(e.getActionCommand().equals("Copy"))
         { 
             text=area.getSelectedText();
         }
        else if(e.getActionCommand().equals("Paste"))
         { 
             area.insert(text, area.getCaretPosition());
         }
        else if(e.getActionCommand().equals("Cut"))
         { 
             text=area.getSelectedText();
             area.replaceRange("", area.getSelectionStart(),area.getSelectionEnd());
         }
        else if(e.getActionCommand().equals("Select All"))
         { 
             area.selectAll();
         }
        else if(e.getActionCommand().equals("About"))
         { 
             About a=new About();
             a.setVisible(true);
         }
    }
    public static void main(String[] args) {
        new new_notepad();
    }
    
}
