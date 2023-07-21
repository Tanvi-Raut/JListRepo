
import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

class MyFrame extends JFrame implements ListSelectionListener,ActionListener
{
   private JPanel p1;
   private JScrollPane sp;
   private JSplitPane jsp;
   private JList<String> lst;
   private Vector<String>list_data;
   private JTextField txt_name;
   private JLabel sel_item;
   private JLabel sel_index; 
   public MyFrame()
   {
    //left side
    list_data = new Vector<String>();
    String arr[] = {"TANVI","DIMPLE"};
    for(String item:arr)
    {
        list_data.add(item);
    }
    lst = new JList<String>(list_data);
    lst.addListSelectionListener(this);
    sp = new JScrollPane(lst);


    //right side
    p1 = new JPanel();
    p1.setLayout(new GridLayout(4,2));

    p1.add(new JLabel("Enter name:"));
    txt_name = new JTextField();
    p1.add(txt_name);

    String arg[] = {"ADD","DELETE"};
    for(String item:arg)
    {
        JButton b = new JButton(item);
        b.addActionListener(this);
        p1.add(b);
    }
    p1.add(new JLabel("Selected INDEX:"));
    sel_index = new JLabel();
    p1.add(sel_index);
      p1.add(new JLabel("Selected ITEM:"));
    sel_item = new JLabel();
    p1.add(sel_item);

    jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,sp,p1);
    jsp.setDividerLocation(150);
    jsp.setDividerSize(2);
    this.add(jsp,BorderLayout.CENTER);



   this.setVisible(true);
   this.setSize(500,150);
   this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

   }
   @Override
   public void actionPerformed(ActionEvent e)
   {
    String text = e.getActionCommand();
    String name = txt_name.getText().trim().toUpperCase();
    txt_name.setText("");
    switch(text)
    {
    case"ADD":
        list_data.add(name);
        lst.setListData(list_data);
        break;

    case"DELETE":
        list_data.remove(name);
        lst.setListData(list_data);
        break;
    }
}
@Override
public void valueChanged(ListSelectionEvent e)
{
    int index = lst.getSelectedIndex();
    String item = lst.getSelectedValue().toString();
    sel_index.setText(index+"");
    sel_item.setText(item);

}

}
class JListExample
{
    public static void main(String[] args) {
        new MyFrame();
    }
}