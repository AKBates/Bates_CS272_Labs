

	// Anna Bates; 800643948; CS272; Lab1


	// the code below was given by Dr.Cao and edited to serve the purposes of this lab



	import java.io.*;


	class EmployeeInfo 
	{
		
		 String EName;
		 String ENum;
		 String EState;
		 String EZip;
		 int EAge;
		 String ESex;

	} // end of class EmployeeInfo


	public class EmployeeFileOp {


		private static EmployeeInfo[] Einfo = new EmployeeInfo[302];
		private static int count = 0;
		public static void count(String fname) 
		{
				//int num = 0;
				String line = "";
				
		try {

		FileReader fileReader1 = new FileReader(fname);

		BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
		
		String input;
		
		while ((input = bufferedReader1.readLine()) != null)
		{
			count++;
		}
		
		System.out.println("Count : " + count);

		//create this EmployeeInfo[] with count number of elements
		Einfo = new EmployeeInfo[count];
		
		bufferedReader1.close();
		} // end of try
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '"  + fname + "' ");
		} // end of catch
		catch(IOException ex) {
			System.out.println("Error reading file '" + fname + "' ");
		} // end of catch
				System.out.println("Finish reading Employee Information from the file '" + fname + " ' ");
	} // end of count
		
		public static void read(String fname) 
		{
				//int num = 0;
				String line = "";
				
		try {

		FileReader fileReader1 = new FileReader(fname);

		BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
		

		int local_count = 0;
		
		boolean firstLine= true;
		while ((line = bufferedReader1.readLine()) != null) {
			
			
			if(firstLine)
			{
				//first line, skip
				firstLine = false;
				continue;
				
			} // end of if
			
			else {
			
				String[] lineStr = line.split(",");
				
				if(local_count > count) {
					System.out.println("There are too many employees in this file");
					break;
				} // end of if
				
				int age = Integer.parseInt(lineStr[4]);;
				
				if (age <= 30)
				{
				
				Einfo[local_count] = new EmployeeInfo();
				Einfo[local_count].EName = lineStr[0]+lineStr[1]; //Integer.parseInt(lineStr[0]);
				Einfo[local_count].ENum = lineStr[2];
				Einfo[local_count].EState = lineStr[3];
				Einfo[local_count].EZip = lineStr[4];
				Einfo[local_count].EAge = Integer.parseInt(lineStr[6]);
				Einfo[local_count].ESex = lineStr[7];
				System.out.println(Einfo[local_count].EName);
				}
				
				//print line
				
				} // end of else
		} // end of while
		bufferedReader1.close();
		} // end of try
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '"  + fname + "' ");
		} // end of catch
		catch(IOException ex) {
			System.out.println("Error reading file '" + fname + "' ");
		} // end of catch
		
		
		//print the array 
		//System.out.println(Einfo[local_count].EName + "," + Einfo[local_count].ENum + "," + Einfo[local_count].EState + ","  + Einfo[local_count].EZip + "," + Einfo[local_count].EAge + "," + Einfo[local_count].ESex); 

		//System.out.println(Einfo[count].EName + "," + Einfo[count].ENum + "," + Einfo[count].EState + ","  + Einfo[count].EZip + "," + Einfo[count].EAge + "," + Einfo[count].ESex); 
		System.out.println("Finish reading Employee Information from the file '" + fname + " ' ");
				
				
	} // end of read

		public static void write(String fname) 
		{
			
			try {
				File file1 = new File(fname);

				FileWriter fw = new FileWriter(file1.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(count + "\n");
				for(int i=1; i < count; i++) 
				{	
					if(Einfo[i].EAge<=30){
				//System.out.println("i=" + i + ":" + Einfo[i].EName + "," + Einfo[i].ENum + "," + Einfo[i].EState + "," + Einfo[i].EZip + "," + Einfo[i].EAge + "," + Einfo[i].ESex);
						bw.write(Einfo[i].EName + "," + Einfo[i].ENum + "," + Einfo[i].EState + "," + Einfo[i].EZip + "," + Einfo[i].EAge + "," + Einfo[i].ESex);
					}
				} // end of for

				bw.close();
				fw.close();
		} // end try
		catch(IOException e) {
			e.printStackTrace();
		} // end catch
		System.out.println("Finish writing employee information to file "  + fname);
		} // end of write

		public static void main(String[] args) 
		{
			//Einfo = null; // clear memory
			//count("/home/ugrad3/abates/workspace/myprograms/myprograms/core_dataset.csv"); 
			read("/home/ugrad3/abates/workspace/EmployeeFileOp/core_dataset.csv"); 
			write("young_employee.csv");
		} 
	} // end of class EmployeeFileOp
