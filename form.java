import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.*;

public class form extends gui {
	protected static String[] array1;
	protected static String[] array2;
	protected static String[] array3;
	protected static File file;
	
	protected static String[] filenames= {"Student.txt","Staff.txt","Faculty.txt"}; //enter here your files names instead of these three

	
	public void Form()
	{
		String[] array1= {"CLASS","First Name","Second Name","FATHER NAME","AGE","SECTION","CONTACT","Roll #","address"};
		submitbutton(1,array1,filenames[0],17,0,array1.length-1,true);
		
		String[] array2= {"NAME","AGE","JOB","CONTACT","address"};
		submitbutton(2,array2,filenames[1],18,array1.length-1,array2.length+array1.length-1,false);
		
		String[] array3= {"NAME","AGE","JOB","CONTACT","address"};
		submitbutton(3,array3,filenames[2],19,array2.length+array1.length-1,array3.length+array2.length+array1.length-1,false);
		
		this.array1=array1;
		this.array2=array2;
		this.array3=array3;
	}

	public void submitbutton(int type,String[] labelRows,String FILENAME,int fnum,int start,int stop,boolean choice)//fnum=frame number
	{
		int yAxis=150;
		JButton b=new JButton("Submit");
		b.setBounds(1100, 700, 93, 50);
	
		addressArray[fnum].f.add(b);

		b.addActionListener(new ActionListener(){  
		public void actionPerformed(ActionEvent e){  
			try{
				

				BufferedWriter bw = null;
				boolean isempty=false;
				label:
				while(true)
				{
					
					
				FileWriter fw = null;
				file = new File(FILENAME);
				
				// true = append file
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);
				// if file doesn't exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				bw.newLine();
				for(int counter=start;counter<stop;counter++)
				{
					if(textFieldArray[counter].getText().equals(""))
					{
						
						isempty=false;
						JOptionPane.showMessageDialog(null, "Please fill all fields!","InComplete Form",JOptionPane.ERROR_MESSAGE);	
						break label;
						
						}
					
					else
					{
						isempty=true;
					}
				}
				
				for(int k=start-1;k<stop;k++)
				{
					if(k==start-1 && choice==true)
					{
						bw.write(String.format("%s\t",comboBoxArray[0].getSelectedItem()));
					}
					else if(k==start-1 && choice== false)
						continue;
					else
						bw.write(String.format("%s\t",textFieldArray[k].getText()));
				}
				
				
				
				if(isempty==true)
				{
					JOptionPane.showMessageDialog(null, "Submitted!");
					for(int counter=start;counter<stop;counter++)
					{
						textFieldArray[counter].setText(null);		
					}
					break;
				}
				
				}
				
				if(isempty==true)
					bw.close();
				
				Table obj=new Table();
				obj.main();
				
				
		        }
			catch(Exception k){System.out.println(k);}
			
		        } 
		
		
		
	}); 
	for(int i=0;i<labelRows.length;i++)
	{
		if(i==0 && choice==true)
		{
			createLabel(labelRows[i],500,yAxis,93,100,addressArray[fnum]);
			createcombo(levels,600,yAxis+40,200,20,addressArray[fnum]);
		}
		else
		{
			createLabel(labelRows[i],500,yAxis,93,100,addressArray[fnum]);
			createTextField("",600,(yAxis+40),200,20,addressArray[fnum]);
		}
		
			
		yAxis+=75;
	}
	}
	
}
