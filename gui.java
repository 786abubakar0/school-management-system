import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class gui
{
	protected JFrame f=new JFrame();
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    protected int width=screenSize.width; 
    protected int height=screenSize.height;
    protected static gui[] addressArray=new gui[500];
    private static int i=0;
    protected static JTextField[] textFieldArray=new JTextField[500];
    protected static JComboBox[] comboBoxArray=new JComboBox[500];
    private static int counter=0;
    private static int combocounter=0;
    protected String[] levels={"PLAY GROUP","NURSERY","PREP","1","2","3","4","5","6","7","8","9","10"};
    
    public gui()
    {
    	
    }
    											/*--------------------------------------------------------------*/
    public gui(boolean choice,gui window,int buttonwidth,String image)
    {	
    	addressArray[i]=this;
    	createframe(choice,window,buttonwidth,image);
    	i++;
    }
												/*--------------------------------------------------------------*/
	public void createframe(boolean choice,gui window,int buttonwidth,String image)
	{
	    f.setSize(width,height);
//	    f.setBackground(Color.BLACK);
		f.setContentPane(new JLabel(new ImageIcon(image)));
	    f.setLayout(null);
	    f.setVisible(choice);
	    createbutton("Back", 50, 50, buttonwidth, 50, window,this);
	  f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
												/*--------------------------------------------------------------*/	
	public void createbutton(String text,int x,int y,int width,int height,gui window,gui close)
	{
	    JButton b=new JButton(text);
	    b.setBackground(Color.WHITE);
	    b.setForeground(Color.BLUE);
		b.setBounds(x,y,width,height);
		f.add(b);
		b.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
			            window.f.setVisible(true);
			            close.f.setVisible(false);			            
			        }  
		}); 
		
	}
												/*--------------------------------------------------------------*/
	public void createcombo(String[] text,int x,int y,int width,int height,gui window)
	{
		JComboBox cb=new JComboBox(text);
		cb.setBounds(x,y,width,height);
		window.f.add(cb);
		comboBoxArray[combocounter]=cb;
		combocounter++;
	}
												/*--------------------------------------------------------------*/
public void createLabel(String text,int x,int y,int width,int height,gui window)
{
	JLabel l=new JLabel(text);
	l.setBounds(x,y,width,height);
	window.f.add(l);
	return;
}
												/*--------------------------------------------------------------*/
public void createTextField(String text,int x,int y,int width,int height,gui window)
{
	JTextField t=new JTextField(text);
	t.setBounds(x,y,width,height);
	window.f.add(t);
	textFieldArray[counter]=t;
	counter++;
	return;
}
												/*--------------------------------------------------------------*/
	public void display()
	{
		gui[] array=new gui[21];
		String image=null;
		int size=0;gui var=null;boolean t=false;
		for (int i=0;i<21;i++)
		{
			if(i==0)
			{
				t=true;
				image="image1.jpg";//replace with given pics address here
			}
				
			else
			{
				image="image2.jpg";//replace with given pics address here
				t=false;
				size=100;
			}
			
			if((i>0 && i<=3))
			{
				var=gui.addressArray[0];
			}
			
			if(i>3 && i<=17)
			{
				var=gui.addressArray[1];
			}
			
			if(i==18)
				var=gui.addressArray[2];
			
			if(i==19)
				var=gui.addressArray[3];
			if(i==20)
				var=gui.addressArray[1];
			
			array[i]=new gui(t,var,size,image);
		}
			
		
		array[0].createbutton("Student", 500 , 320 , 600 , 80,array[1],array[0]);
		array[0].createbutton("Staff"  , 500 , 420 , 600 , 80,array[2],array[0] );
		array[0].createbutton("Faculty", 500 , 520 , 600 , 80,array[3],array[0] );
		
		array[1].createbutton("+Add new", 1350, 50, 100, 50,array[17] , array[1]);
		array[2].createbutton("+Add new", 1350, 50, 100, 50,array[18] , array[2]);
		array[3].createbutton("+Add new", 1350, 50, 100, 50,array[19] , array[3]);
		
		
		int b=120;
		int a=100;
		int c=4;
		for(int i=0;i<levels.length;i++)
		{
			array[1].createbutton(levels[i], a , b , 600 , 80,gui.addressArray[c],array[1]);
			
			if(i==5)
			{
				a=800;
				b=20;
			}
			
			if(i==11)
				a=450;
			
			b+=100;
			c++;
		}

	}
													/*--------------------------------------------------------------*/
	
}

