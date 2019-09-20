import java.io.*;
import java.util.Arrays; 

class EmployeeInfo 
{
	
	 String EName;
	 String ENum;
	 String EState;
	 String EZip;
	 int EAge;
	 String ESex;

} // end of class EmployeeInfo

public class  EmployeeSet {

	
	private static final EmployeeInfo[] Einfo = null;
	Employee[] ESet;
    static int count;
	
	public EmployeeSet() {
		
		final int INITIAL_CAPACITY = 10;
		count = 0;
		ESet = new Employee[INITIAL_CAPACITY];
		
	} // end of EmployeeSet constructor
	
	/* 
	 * @precondition 
	 * obj should not be null and is to be an instance variable of EmployeeSet
	 */
	
	// copy constructor
	public EmployeeSet(Object obj) {
		
		EmployeeSet e1 = (EmployeeSet) obj;
		
		if ((obj!= null) && (obj instanceof EmployeeSet)) {
			
//			EmployeeSet toCopy = (EmployeeSet)obj;
//			count = toCopy.count;
			
			ESet = ESet;
			count = count;
			
			if (ESet.length < 0) {
				
				throw new IllegalArgumentException("the capacity cannot be negative");
				
			}
			
			//ESet = new Employee[count];
			
//			for (int i = 0; i < count; i++) {
//				
//				ESet[i] = toCopy.ESet[i];
//				
//			} // end of for
			
		} // end of if
		
	} // end of copy constructor
	
	public int size() {
		
		// put employee numbers into an array
		//int[] array = e1.getENum();
		
		return count;
		
	} // end of size
	
	public int capacity() {
		
		// return the capacity of the collection which in this case is 10
		
		return ESet.length;
		
	}
	
	/* 
	 * @precondition 
	 * employee obj a is not null
	 */
	
	
	public void add(Employee a) {
		
		ESet[count] = a;
		
		if (count == ESet.length) {
			
//			Employee[] array2 = new Employee[(count + 1)*2];
//			System.arraycopy(ESet, 0, array2, 0, count);
//			ESet = array2;
			ensureCapacity((count + 1)*2);
			
		} // end of if
		
		ESet[count] = a;
		count++;
		
	} // end of add 
	
	/*
	 * @precondition
	 * minimumCapacity should be positive
	 * 
	 */
	
	public void ensureCapacity(int minimumCapacity) {
		
			
			Employee[] array2;
			
			if(minimumCapacity < 0) {
				
				throw new IllegalArgumentException("minimum capacity must be positive");
				
			} // end of if
			
			else {
			
			if(ESet.length < minimumCapacity ) {
			
				array2 = new Employee[minimumCapacity];
				System.arraycopy(ESet, 0, array2, 0, count);
				ESet = array2;
				
			} // end of if
			
			} // end of else
			
		
	} // end of ensureCapacity
	
	public boolean contains(Employee a) {
		
		if (a == null) {
			
			return false;
			
		} // end of if
		
		else {
			
			for(int i = 0; i < count; i++) {
				
			
				if (ESet[i] == a) {
				
					return true;
				
				} // end if
			
			} // end for
			
				return false;
				
			} // end of first else
		
	} // end of contains
//	
	public boolean remove(int eno) {
		
		if(eno == 0) {
			
			return false;
			
		}
		
		else {
			
			for (int i = 0; i < count; i++) {
				
				if(ESet[i].equals(eno)) {
					
					ESet[i] = ESet[count - 1];
					ESet[count - 1] = null;
					return true;
					
				} // end of if
				
			} // end of for
			
			return false;
			
		}
		
	} // end of remove
	
	public void setESet(Employee[] e) {
		
		ESet = new Employee[e.length];
		this.ESet = e;
		
	}
	
	public Employee[] getESet() {

		return ESet;

	} // end of getESet
	
	/*
	 * @precondition
	 * employee object a should not be null
	 * the objects in the collection’s employee array are already in ascending order of employee nos.
	 */
	
	public void addOrdered(Employee a) {
		
		Arrays.sort(ESet); 
        System.out.printf("Modified arr[] : \n%s\n\n", 
                          Arrays.toString(ESet)); 
		
	}
	
	public static void read(String fname) {
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
	
	public static void main(String[] args) {
		
		//System.out.println("test");
	
		Employee e1 = new Employee();
		
		e1.setEName("Anna Bates");
		e1.setENum(7);
		e1.setEAge(20);
		e1.setEState("Colorado");
		e1.setEZip(80907);
		
		e1.getEName();
		e1.getENum();
		e1.getEAge();
		e1.getEState();
		e1.getEZip();
		
		Employee e2 = new Employee();
		
		e2.setEName("Jane Doe");
		e2.setENum(5);
		e2.setEAge(21);
		e2.setEState("New Mexico");
		e2.setEZip(88003);
		
		e2.getEName();
		e2.getENum();
		e2.getEAge();
		e2.getEState();
		e2.getEZip();
		
		Employee e3 = new Employee();
		
		e3.setEName("John Doe");
		e3.setENum(8);
		e3.setEAge(23);
		e3.setEState("Arizona");
		e3.setEZip(90456);
		
		e3.getEName();
		e3.getENum();
		e3.getEAge();
		e3.getEState();
		e3.getEZip();
		
		EmployeeSet ES = new EmployeeSet();
		
		System.out.println(ES.size());
		System.out.println(ES.capacity());
		
		ES.add(e1);
		ES.add(e2);
		
		System.out.println(ES.contains(e1));
		System.out.println(ES.contains(e3));
		
		ES.add(e3);
		System.out.println(ES.remove(8));
		
		//ES.addOrdered(e2);
		
		EmployeeSet ES2 = new EmployeeSet();
		
		ES2.read("/home/ugrad3/abates/workspace/EmployeeFileOp"); 
		

		

		
	} // end of main
	
} // end of EmployeeSet class
