import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


	public class Table extends form implements ActionListener {
		
		static int isupdate=0;
		static int facultyNum=0;
		static int staffNum=0;
		static JTable[] tablearray;
		
		
	    public void addTable(JFrame fr,Object[][] data,Object[] column){ 
	    	
	    	
	    	
	    	DefaultTableModel tableModel = new DefaultTableModel(data, column);

	    	JTable jt=new JTable(tableModel);
	    	TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jt.getModel());
	    	jt.setRowSorter(sorter);

	    	ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(1000);
	    	if(fr==addressArray[2].f || fr==addressArray[3].f) {
	    		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
	    	}
	    	else
	    	{
	    		sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
	    	}
	    	//sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
	    	sorter.setSortKeys(sortKeys);
	    	
	    	
	    	jt.setBounds(50,150,width-100,height-250);
	    	JScrollPane sp=new JScrollPane(jt);   
	    	sp.setBounds(50, 150, width-100, height-250);
	    	
	    	fr.add(sp);
	    
	    	JButton b=new JButton("refresh");
	    	b.setBackground(Color.WHITE);
	    	b.setForeground(Color.BLUE);
	    	b.setBounds(150, 50, 100, 50);
	    	fr.add(b);
	    	b.addActionListener(this);

	}

	    @Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			main();
			readfile(4,addressArray[20].f,filenames[0],textFieldArray[array1.length + array2.length + array3.length -1].getText());
		}
	  
	    public void main()
	    {	
	    	try {
	    		for(int i=0;i<filenames.length;i++)
	    		{
	    			File file=new File(super.filenames[i]);
		    		if (!file.exists()) {
						file.createNewFile();
					}
	    		}
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    	
	    	int index=0;
	    	
	    	for(int i=2;i<17;i++)
	    	{
	    		if(i==2 )
	    		{
	    			readfile(2,addressArray[i].f,filenames[1],"null");
	    		}
	    		else if(i==3)
	    		{
	    			readfile(3,addressArray[i].f,filenames[2],"null");

	    		}
	    		else {
		    		readfile(1,addressArray[i].f,filenames[0],levels[index]);
		    		index++;
	    		}
	    	}
	    	
	    	
	    }
	    
	    
	    public void readfile(int type,JFrame fr,String file,String... grade)
	    { 
	    	 int studentNum=0;
			 
	    	try {
	    			    		
				int counter=0;
				Object[] column=null;
				if(type==1 )
				{
					column=array1;
				}
				else if(type==4)
				{
					String[] array=array1;
					column= array;
					
				}
				else if (type==2)
				{
					column=array2;
				}
				
				else if (type==3)
				{
					column=array3;
				}
				Object data[][];
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				StringBuffer stringBuffer = new StringBuffer();
				String line;
				line = bufferedReader.readLine();
				
				
				/*for(int m=0;m<column.length;m++)
					stringBuffer.append(String.format("%s\t",column[m]));
					*/
				String gradenumber=null;
				for(String a:grade)
				{
					gradenumber=a;
				}
				
				while ((line = bufferedReader.readLine()) != null) {
					String[] arr1=line.split("\t");
				
					if(arr1[0].equals(gradenumber))
					{
						stringBuffer.append(line);
						stringBuffer.append("\n");
					}
					
					
					else if("null".equals(gradenumber))
					{
						stringBuffer.append(line);
						stringBuffer.append("\n");
					}
					
					else if((arr1[1].equals(gradenumber) || arr1[2].equals(gradenumber) || String.format("%s %s", arr1[1],arr1[2]).equals(gradenumber) )  && type==4)
					{
						stringBuffer.append(line);
						stringBuffer.append("\n");
					}
				}
				
				
				fileReader.close();
				String[] arr=stringBuffer.toString().split("\t");
				
				int rows=arr.length/column.length;
				
				
				data=new String[rows][column.length];
				

				
				
				for(int i=0;i<rows;i++)
				{
					for(int j=0;j<column.length;j++)
					{
						if(j==0 && gradenumber.equals("null")==false  &&type==1)
						{
							
							data[i][j]=arr[counter];
							studentNum++;
						}
						
						else
							data[i][j]=arr[counter];
												
						counter++;
					}
				}
				
				
				{
					if(gradenumber.equals("null")==true && type==3)
						facultyNum=data.length;
					if(gradenumber.equals("null")==true && type==2)
						staffNum=data.length;
				//	createLabel(String.format("Total Faculty: "),330,50,200,100,addressArray[3]);
					createLabel(String.format("Total Faculty: %d", this.facultyNum),330,50,200,100,addressArray[3]);
					
					//createLabel(String.format("Total Staff: "),330,50,200,100,addressArray[2]);
					createLabel(String.format("Total Staff:%d", this.staffNum),330,50,200,100,addressArray[2]);
					for(int i=4;i<17;i++)
			    	{
			    		if(fr==addressArray[i].f)
			    		{
			    			for(int j=0;j<data.length;j++)
			    			{
			    			//	createLabel(String.format("Student: "),330,50,200,100,addressArray[i]);
			    				createLabel(String.format("Student: %d", studentNum),330,50,200,100,addressArray[i]);
			    				
			    			}
			    			break;
			    		}
			    	}
				}
				addTable(fr,data,column);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

		
	}
	    
	  

