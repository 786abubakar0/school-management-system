import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class searchtable extends Table implements ActionListener {
	public searchtable()
	{
		int index=array1.length + array2.length + array3.length -1;
		createTextField("Enter Student Name",-150+width/2,50,200,50,addressArray[1]);
		
		
		JButton b=new JButton("Search");
		b.setBounds(60+width/2,70,93,20);
		b.setBackground(Color.black);
		b.setForeground(Color.white);
		addressArray[1].f.add(b);
		
		
		b.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
				readfile(4,addressArray[20].f,filenames[0],textFieldArray[index].getText());
				addressArray[20].f.setVisible(true);
				addressArray[1].f.setVisible(false);
				//textFieldArray[18].setText("Enter Student Name");
		    }  
		    });  
	}
	

}
