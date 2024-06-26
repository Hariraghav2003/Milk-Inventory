package Milkinventorym4;
import java.io.Console;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class mim4 
{
    static char[] pass1;
    static int i=0;
    public static void login(String[] mp,Map<Object,List<Object>>ud,int c)
    {
        Console Console = System.console();
        Scanner myobJ=new Scanner(System.in);
        jump11:
        while (i<5) 
        {
            System.out.println("Your User name:");
            String eusername=myobJ.nextLine();
            if (eusername.isEmpty()) 
            {
                System.out.println("Invalid");
                i++;
                continue jump11;    
            }
            else if (i==5) 
            {
                System.out.println("Attempts Maxed out!!");
                System.exit(i);    
            }
            else
            {
                String vuser= eusername.toLowerCase();
                if (ud.containsKey(vuser)) 
                {
                    System.out.println("Your Password:");
                    pass1=Console.readPassword("********");
                    String pass = new String(pass1);
                    Object check= ud.get(vuser);
                    String check2=check.toString();
                    if (check!=null && check2.contains(pass)) 
                    {
                        System.out.println("Login Sucessful!!");
                        Milkinventorym2.mim2.ProductDetails(mp, c);
                    }
                    else
                    {
                        System.out.println("Kindly register to continue");
                        Milkinventorym3.mim3.register(c);
                    }
                }
                else if(!ud.containsKey(vuser))
                {
                    System.out.println("Kindly register to continue");
                    Milkinventorym3.mim3.register(c);
                }
                break;
            }
        }
        myobJ.close();
    }
}
