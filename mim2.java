package Milkinventorym2;
import java.util.Scanner;
public class mim2 
{
	 static int[][] product={{240,130},{260,14},{270,120},{280,50},{290,90}};//a 2D array to display price per pack & Available Quantity
	static int tot;
	
	// static int cho;
	static int i=0;
	static int []booked={0,0,0,0,0};
	static int h;
	public static void ProductDetails(String[] mp,int cho)
    {
		
		Scanner myObj = new Scanner(System.in);
		
	     
		System.out.println("You have chossen:"+mp[(cho)]);
		jump1:
		
		while (i<5) 
		{ 	
			    
				for (int j = 0; j < product[cho].length; j++)//To loop through the elements of current row based on the user cho milk product
				{
					
					
					
					// to break the loop based on user cho milk product(if user has cho milk it will only print the values 240,140 )
					if (j==0)
					{
						System.out.println("#Price per pack:"+product[cho][j]+"/-");

					}
					else
					{
						product[cho][j]-=booked[cho];
						System.out.println("# Available Quantity:"+(product[cho][j]));
					}
				}
				for (int j = 0; j < product[cho].length; j++)
				{
					if (j==0)
					{
						//To store the values of price per pack & Available Quantity
						int pp=product[cho][j];
						// To get the quantity of milk products from the user who is going to book
						int i=0;
						jump:
						while (i<5) 
						{
							booked[cho]=0;
							System.out.println("#To be booked:");
							booked[cho]=myObj.nextInt();
							if (booked[cho]>=15) //To limit the user for not to enter more than 15 even if the specific product has available quantity
							{
								System.out.println("Sorry !! please enter within 15 packs");
								i++;
								continue jump;
							}
							else if (booked[cho]<15)
							{	
								//System.out.println("Wow! great booking "+booked[cho]+" "+mp[(cho)]+" packs!");
								int g= tot+=booked[cho]*pp;
								//System.out.println(tot);
								System.out.println("Wanna book more products?(Y/N)");
								myObj.nextLine();
								String r=myObj.nextLine();
								r.toUpperCase();
								
								if(r.equalsIgnoreCase("Y"))
								{
									i=0;
									jump14:
									while (i<5) 
									{
										for(int k=0;k<mp.length;k++)
										{
											System.out.println( k+1 + "." + mp[k]);
										}
										System.out.println("Choose Product:");	
										cho=myObj.nextInt()-1;
										if (cho >= 0 && cho <mp.length)
										{
											System.out.println(mp[(cho)]+"!"+ "good choice!!");
											continue jump1;
										}
										else
										{
											System.out.println("Enter a proper product id:");
											i++;
											if (i==5) 
											{
												System.out.println("Attempts Maxed out!! ");
												System.exit(i);	
											}
											continue jump14;
										}

									}
								
								}
								else if(r.equalsIgnoreCase("n"))
								{
									CalculatePrice(g);
									break;
								}
								/*else if (r.isEmpty()) 
								{
									System.out.println("Prpoerly Enter a value");

								}*/
								else
								{
									System.out.println("You haven't cho a proper option");
								}
							}
							else if(i==5)
							{
								System.out.println("Attempts Maxed out!! ");
								System.exit(i);
							}
						}

					}
				
				}
	
			break;
		}
		myObj.close();
	}
	public static void CalculatePrice(int g)
	{
		double e=((5.0/100)*g)+g;
		System.out.println("#Total Pricing:Rs."+e+"/-"+"(including GST of 5%)");
	}

}