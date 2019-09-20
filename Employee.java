// Anna Bates, Lab 2

import java.util.Arrays;

public class Employee {

	String EName;
	int ENum;
	int EAge;
	String EState;
	int EZip;
	int[] EAdvisors;
	static int count;

	// create no-argument constructor that sets null to all variables with
	// non-primitive types and zero to all variables with an int

	public Employee() {

		EName = null;
		ENum = 0;
		EAge = 0;
		EState = null;
		EZip = 0;
		EAdvisors = null;
		count = 0;

	} // end of no-argument constructor

	// create a copy constructor that uses the given parameter obj to set the
	// instance variables

	public Employee(Object obj) {

		if ((obj != null) && (obj instanceof Employee)) {

			Employee e1 = (Employee) obj;
			this.EName = new String(e1.EName);
			this.ENum = e1.ENum;
			this.EAge = e1.EAge;
			this.EState = new String(e1.EState);
			this.EZip = e1.EZip;
			this.EAdvisors = e1.EAdvisors;
			
		} // end of if
			
	} // end of Copy Constructor

	// create get and set methods for all instance variables

	public String getEName() {

		return EName;

	} // end of getEName

	public void setEName(String EName) {

		this.EName = EName;

	} // end of setEName

	public int getENum() {

		return ENum;

	} // end of getENum

	public void setENum(int ENum) {

		this.ENum = ENum;

	} // end of setENum

	public int getEAge() {

		return EAge;

	} // end of getEAge

	public void setEAge(int EAge) {

		this.EAge = EAge;

	} // end of setEAge

	public String getEState() {

		return EState;

	} // end of getEState

	public void setEState(String EState) {

		this.EState = EState;

	} // end of setEState

	public int getEZip() {

		return EZip;

	} // end of getEZip

	public void setEZip(int EZip) {

		this.EZip = EZip;

	} // end of setEZip

	public int[] getEAdvisors() {

		return EAdvisors;

	} // end of getEAdvisors

	public void setEAdvisors(int[] eAd) {

		// make sure an employee can only have three advisors maximum
		if (eAd.length > 3) {

			throw new IllegalArgumentException("An employee can only have three advisors.");

		} // end of if

		else {

			EAdvisors = new int[eAd.length];
		   this.EAdvisors = eAd;
		}

	} // end of setEAdvisors

	// create a toString method to organize the String information in the order of
	// name, num, age, state, zip, and list advisor names

	public String toString() {
		
	int[] ad = new int[EAdvisors.length];
		  
		  for (int i = 0; i < EAdvisors.length; i++) {
		  
		  ad[i] = EAdvisors[i];
		  		  
		  } // end of for
		 
	 // return "Name: " + EName + " " + "Number: " + ENum + " " + "Age: " + EAge + " " + "State: " + EState + " " + "Zip Code: " + EZip + " " + "List of Advisor(s): " + EAdvisors;

	  if(ad.length == 0) {
	  
	  return "Name: " + EName + " " + "Number: " + ENum + " " + "Age: " + EAge + " " + "State: " + EState + " " + "Zip Code: " + EZip + " " + "List of Advisor(s): " + "There are no advisors";
	  
	  }
	  
	  else if (ad.length == 1) {
	  
	  return "Name: " + EName + " " + "Number: " + ENum + " " + "Age: " + EAge + " " + "State: " + EState + " " + "Zip Code: " + EZip + " " + "List of Advisor(s): " + ad[0];
	  
	  }
	  
	  else if (ad.length == 2) {
	  
	  return "Name: " + EName + " " + "Number: " + ENum + " " + "Age: " + EAge + " " + "State: " + EState + " " + "Zip Code: " + EZip + " " + "List of Advisor(s): " + " " + ad[0] + " " + ad[1];
	  
	  }
	  
	  else {
	  
	  return "Name: " + EName + " " + "Number: " + ENum + " " + "Age: " + EAge + " " + "State: " + EState + " " + "Zip Code: " + EZip + " " + "List of Advisor(s): " + " " + ad[0] + " " + ad[1] + " " + ad[2];
		  
	  } // end of else
	  
	} // end of toString

	// create an equals method that returns true if the given object's employee num
	// is the same as the num of the given employee instance which activates the
	// method. Otherwise, return false

	public boolean equals(Object obj) {

		if (obj instanceof Employee) {

			Employee e1 = (Employee) obj;

			return (e1.ENum == getENum());

		} // end of if
			// return ((e1.EName == EName) && (e1.ENum == ENum) && (e1.EAge == EAge) &&
			// (e1.EState == EState) && (e1.EZip == EZip) && (e1.EAdvisors == EAdvisors));

		else {

			return false;

		} // end of else

	} // end of equals

	// create a static method to get all the distinct advisors of two employees
	// which are the input parameters

	public static int[] getAllAdvisors(Employee e1, Employee e2) {

		int[] DistinctAdvisors = new int[e1.EAdvisors.length*2];
		
		int[] arr = e1.getEAdvisors();
		int[] ray = e2.getEAdvisors();
		
		// for loop stores the first array into distinct advisors
		for( int i = 0; i <= e1.EAdvisors.length; i++) {
			
			for(int j = 0; j <= e2.EAdvisors.length; j++) {
				
				// checks to see if any of the elements match each other
				if((arr[0] != ray[0]) || (arr[0] != ray[1]) || (arr[0] != ray[2]) || (arr[0] != arr[1]) || arr[0] != arr[2]) {
					
					// places the elements in the right position of the array
					DistinctAdvisors[0] = arr[0];
					DistinctAdvisors[1] = ray[0];
					
				}
				
				else {
					
					// only one element needs to written since they are the same value
					DistinctAdvisors[0] = arr[0];
					
				}
				
				// checks to see if any of the elements match each other
				if((arr[1] != ray[1]) || (arr[1] != ray[2]) || (arr[1] != arr[0]) || (arr[1] != arr[2]) || (arr[1] != ray[0])) {
					
					// places the elements in the right position of the array
					DistinctAdvisors[2] = arr[1];
					DistinctAdvisors[3] = ray[1];
					
					
				}
				
				else {
					
					// only one element needs to written since they are the same value
					DistinctAdvisors[2] = arr[1];
					
				}
				
				// checks to see if any of the elements match each other
				if((arr[2] != ray[2]) || (arr[2] != ray[0]) || (arr[2] != ray[1]) || (arr[2] != arr[0]) || arr[2] != arr[1]){
					
					// places the elements in the right position of the array
					DistinctAdvisors[4] = arr[2];
					DistinctAdvisors[5] = ray[2];
					
				}
				
				else {

					// only one element needs to written since they are the same value
					DistinctAdvisors[3] = arr[2];
					
				}
			
			} // end of second for
		
		} // end of first for
		
		return DistinctAdvisors;
		
	} // end of getAllAdvisors

	// System.out.println(EName + " " + ENum + " " + EAge + " " + EState + " " +
	// EZip + " " + EAdvisors);

	// create a main method to test everything

	public static void main(String[] args) {

		Employee e3 = new Employee();
		Employee e4 = new Employee();
		Employee e5 = new Employee();

		// test all set functions
		e4.setEName("Anna Bates");
		e4.setENum(7);
		e4.setEAge(20);
		e4.setEState("Colorado");
		e4.setEZip(80907);

		// test all get functions
		e4.getEName();
		e4.getENum();
		e4.getEAge();
		e4.getEState();
		e4.getEZip();

		int[] e4Advisors = new int[] { 1, 2, 3};
		e4.setEAdvisors(e4Advisors);
		
		// create a for loop to ensure that the EAdvisor array gets filled
		System.out.println("e4 advisor(s): ");
		for (int i = 0; i < e4Advisors.length; i++) {

			// e4.EAdvisors[i] = e4Advisors[i];
			e4.getEAdvisors();
			System.out.println(e4Advisors[i]);
		} // end of for

		System.out.println();
		
		// create an array for a fifth employee to test the getAllAdvisors function
		int[] e5Advisors = new int[] { 3, 4, 5 };
		e5.setEAdvisors(e5Advisors);
		
		// create a for loop that ensures the EAdvisor array gets filled
		System.out.println("e5 advisor(s): ");
		for (int i = 0; i < e5Advisors.length; i++) {

			e5.getEAdvisors();
			System.out.println(e5Advisors[i]);

		}
		
		System.out.println();

		// test to see if all get and set methods work
		System.out.println(e4);
		
		System.out.println();

		// test to see if employees are equal
		System.out.println("If the employees are equal, it will state true. If the employees are not equal, it will state false.");
		System.out.println(e3.equals(e4));

		System.out.println();
		
		System.out.println("The distinct array is: ");
		System.out.println(Arrays.toString(getAllAdvisors(e4, e5)));
	} // end of main

} // end of class Employee
