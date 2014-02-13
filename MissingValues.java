/*--------------------MISSING VALUES PROGRAM---------------------*/
//This program checks for missing values in the input file and adds a "?" in their place in the output file


import java.io.*;                      //For file operations

public class MissingValues 
{ 
  public static void main(String args[]) throws IOException
  { 
	
	FileInputStream fin;
	
	//Open input file
	try
	{ 
	  fin = new FileInputStream("C:/Documents and Settings/NISHANT/Desktop/MV.csv");		
	}
	catch(FileNotFoundException e)
	{
	  System.out.println("File not found.");
	  return;
	}
	
	//To read line by line from input file
	DataInputStream in = new DataInputStream(fin);
	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	String strLine;
	
	//Output file
	BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:/Documents and Settings/NISHANT/Desktop/MV_OP.csv"), true));
	
	while ( (strLine = br.readLine()) != null )  //"null" means EOF (end of file)  
	{	  
		String delim = "[,]";                    //Commas are used as delimiters in ".csv" files
		String[] tokens = strLine.split(delim);  //Parse the column/attribute values from current read line using "split()" method and store into string array "tokens" 
		
		for(int i=0; i<tokens.length; i++)       
		{ 
		  	
		  if(tokens[i].length() < 1)             //For null (missing) values
			 tokens[i] = "(?)";
		 
		  bw.write(tokens[i]);                   //Write non-missing values as it is into output file
		 		  
		  
		  if(i < tokens.length - 1)              //If not last column/attribute value in  input file, write "," into output file 
			bw.write(",");
					 
		}
		
		//To check if last value of column/attribute in a particular row is missing
		if( strLine.charAt(strLine.length() - 1) == ',' )    //If last character of row is comma in input .csv file, then write ",(?)" into output file
		{
			bw.write(",(?)");
		} 
		
		bw.newLine();               //For new row in output file
				
	  }
	
	
	fin.close();                    //Close input file
	bw.close();                     //Close output file
  
  }

}
