package tele;

import java.util.HashMap;

import java.util.Scanner;

public class TargetCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		int r1;
		int r2;
		
		int target;
		int current_target;
		int np;
		int tvs;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" Enter total number of rooms ");
		n = sc.nextInt();
		
		System.out.println(" Enter the price of room with tv ");
		r1 = sc.nextInt();
		
		System.out.println(" Enter the price of room without tv");
		r2 = sc.nextInt();

		System.out.println(" Enter the required target ");
		target = sc.nextInt();
		
		HashMap<Integer, Integer> dayscount = new HashMap<Integer, Integer>();
		 
		dayscount.put(1, 31);
		dayscount.put(2, 29);
		dayscount.put(3, 31);
		dayscount.put(4, 30);
		dayscount.put(5, 31);
		dayscount.put(6, 30);
		dayscount.put(7, 31);
		dayscount.put(8, 31);
		dayscount.put(9, 30);
		dayscount.put(10, 31);
		dayscount.put(11, 30);
		dayscount.put(12, 31);
		
		
		for(tvs= 0 ;tvs<=n;tvs++)
		{
			current_target=0;
			
			System.out.println("Incrementing tvs " + tvs);
			
			for(int m=1 ;m<=12;m++)
			{
				for(int d=1;d<=dayscount.get(m);d++)
				{
					np=countpat(d,m);
					
					System.out.println("The number of patients " + np);
					
					//checks the patient does not exceed number of rooms
					np = min(np, n);
					
					// calculating target for day if number of patients is less than the number of non ac rooms
					if (np<=n-tvs)
					{
						current_target  = current_target+ (np*r2);
					}
					
					// calculating target for day if number of patients is greater than no of non ac rooms
					
					else
					{
						current_target = current_target+ (((n-tvs)*r2)+(np-(n-tvs))*r1);
						
					}
				
				}
			}
			
			System.out.println( "The current target " + current_target);
			
			if(current_target>=target)
			{
				System.out.println("the target is reached with the number of ac rooms being " + tvs);
				break;
			}
			
			if(current_target<target)
			{
				System.out.println("the target is not reached  " );
			}
		}
		
		System.out.println("the target is reached with the number of ac rooms being " + tvs);
	}

	private static int min(int np, int n) {
		// TODO Auto-generated method stub
		int min;
		if (np<n)
			min = np;
		else
			min = n;
		
		return min;
	}

	private static int countpat(int d, int m) {
		// TODO Auto-generated method stub
		
		double pt = Math.pow((6-m),2) + Math.abs(d-15);
		int pt1 = (int) pt;
		return pt1;
	}

}
