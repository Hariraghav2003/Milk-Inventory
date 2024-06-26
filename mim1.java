package Milkinventorym1;
import java.util.*;
public class mim1
{
	static int i=0;
	static int cho;
	static void Introduction()
	{
		Scanner myObj = new Scanner(System.in);  
		jump11:
		while (i<5) 
		{
			System.out.println("Enter the Location:");
			String Location = myObj.nextLine();
			if (Location.isEmpty()) //to check whether the given input is NULL
			{
				System.out.println("Please Enter this available location's \n Madurai \n Tirunelveli in proper format!!");
				i++;
				continue jump11;
			}
			else if (Location.matches("-?\\d+")) // to check whether the given input is in proper datatype(String)
			{
				System.out.println("Please Enter this available location's \n Madurai \n Tirunelveli in proper format!!");
				i++;
				continue jump11;
			}
			else if (!Location.equalsIgnoreCase("madurai") && !Location.equalsIgnoreCase("Tirunelveli")) 
			{
				System.out.println("Please Enter this available location's \n Madurai \n Tirunelveli");
				i++;
				continue jump11;
			}
			else
			{
				Storelocation(Location);
			}
			break;
		}
		if (i==5) 
		{
			System.out.println("Attempts maxed out!!");
			System.exit(i);

		}
		myObj.close();
	}
	static void  Storelocation(String Location)
	{
		if (Location.equalsIgnoreCase("Madurai")) //to display locations available in madurai
		{
			System.out.println("Locations at "+Location);
			String Larray[]={"Annanagar","625020","Arittapatti","625106","GandhiiNagarMA","625020","Samanatham","625009"};
			for (int a = 0; a < Larray.length; a=a+2) 
			{
				System.out.println(((a/2)+1) + "." + Larray[a]+"-"+Larray[a+1]);
			}
			MilkStores(Larray);
		}
		else if(Location.equalsIgnoreCase("Tirunelveli")) //to display locations available in Tirunelveli
		{
			System.out.println("Locations at "+Location);
			String Larray[]={"Perumalpuram", "627020","Palayamkottai","625706","KTC Nagar","625707","Maharaja Nagar","625708"};
			for (int a = 0; a < Larray.length; a=a+2) 
			{
				System.out.println(((a/2)+1) + "." + Larray[a]+"-"+Larray[a+1]);
			}
			MilkStores(Larray);
		}
	} 
	static void MilkStores(String[] Larray)
	{
		Scanner myObj = new Scanner(System.in);
		i=0; 
		jump10:
		while (i<5) 
		{
			System.out.println("Choose your Location:");
			int choosen = myObj.nextInt()-1;
			try
			{
				if (choosen >= 0 && choosen <Larray.length) 
				{
					System.out.println("Milk Products at " + Larray[(choosen)*2]+"!!");
					MilkProducts(choosen);
				}
			}
			catch (Exception e) 
			{
				System.out.println("Choose a Proper Location");
				i++;
				continue jump10;
			}
			break;
		}
		if (i==5) 
		{
			System.out.println("Attempts Maxed out!!");
			System.exit(i);	
		}
		myObj.close();
	}
	static void MilkProducts(int chossen)
	{
		String[] mp = {"Milk","Cheese","Butter","Sweets","Juice"}; //List of Milk Products
		Scanner myObj=new Scanner(System.in);
		i=0;
		jump0:
		while (i<5) 
		{
			for(int i=0;i<mp.length;i++)
			{
				System.out.println( i+1 + "." + mp[i]);
			}
			System.out.println("Choose Product:");
			cho = myObj.nextInt()-1;
			if (cho >= 0 && cho <mp.length)
			{
				System.out.println(mp[(cho)]+"!"+ "good choice!!");
				System.out.println("You must be a registered user to book the items");
				Milkinventorym3.mim3.register(cho);
			}
			else
			{
				System.out.println("Choose a proper product id!!");
				i++;
				continue jump0;
			}
			break;
		}
		if (i==5) 
		{
			System.out.println("Attempts maxed out!!");
			System.exit(i);
		}
		myObj.close();

	}
	public static void main(String[] args) 
	{
		System.out.println("Welcome to Sampoorna Diary!!! Please Enter this available location's \n Madurai \n Tirunelveli");
        Introduction();
	}
}
