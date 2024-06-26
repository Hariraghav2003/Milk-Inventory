package Milkinventorym3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.io.Console;
public class mim3
{
    static String[] mp = {"Milk","Cheese","Butter","Sweets","Juice"};
    static Map<Object,List<Object>> ud=new HashMap<>();
    static List<Object> vud=new ArrayList<>();
    static String username;
    static String name;
    static String location;
    static int pincode;
    static String password;
    static String rpassword;
    static int i=0;
    static char[] pass;
    public static void register(int cho)
    {
       int c=cho;
       Scanner myobj=new Scanner(System.in);  
       Console Console = System.console(); 
       System.out.println("Do you want register(Y/N)?");
       String choice=myobj.nextLine();
       if (choice.equalsIgnoreCase("y")) 
       {
            jump6:
            while (i<5) 
            
            {
                System.out.println("Your Name:");
                name=myobj.nextLine();

                if (vud.contains(name)) 
                {
                    System.out.println("Name Already exist!!");
                    i++;
                    continue jump6;
                }

                if (name.length()<4) 
                {
                    System.out.println("Invalid!!..."); 
                    i++;
                    continue jump6;
                }
                
                else if (name.matches("-?\\d+")) 
                {
                    System.out.println("Invalid!!..."); 
                    i++;
                    continue jump6;
                }
                else if (i==5) 
                {
                    System.exit(c);
                }
                else if(name.length()>=4)
                {
                    i=0;
                    jump7:
                    while (i<5) 
                    {
                        System.out.println("Your Location:");
                        location=myobj.nextLine();
                        if ( location.isEmpty()) 
                        {
                            System.out.println("Invalid!!..."); 
                            i++;
                            continue jump7;
                        }   
                        
                        else if (location.matches("-?\\d+")) 
                        {
                            System.out.println("Invalid!!..."); 
                            i++;
                            continue jump7;
                        }


                        else if(i==5)
                        {
                            System.exit(i);
                        }

                        else
                        {
                            System.out.println("Your Pincode:");
                            pincode=myobj.nextInt();
                            i=0;           
                            jump3:
                            while (true)
                            {
                                System.out.println("Your password:");
                                pass=Console.readPassword("********");
                                password=new String(pass);
                                if (password.length()<8) 
                                {
                                    System.out.println("Your password should be minimum 8 charactes!!");
                                    i++;  
                                    if(i==5)
                                    {
                                        System.out.println("Attempts Maxed out!!");
                                        System.exit(i);
                                    }
                                    continue jump3;
                                }
                                else if(password.length()>=8)
                                {
                                    System.out.println("Retype Your password:");
                                    pass=Console.readPassword("********");
                                    rpassword=new String(pass);
                                    if(password.equals(rpassword))
                                    {
                                        System.out.println("Password Validated!!! You are successfully registered! Congratulations!");
                                        Random random = new Random();
                                        String un=name.substring(0, 4).toLowerCase();
                                        int randomNumber = random.nextInt(9000)+1000; 
                                        username = un+randomNumber;
                                        System.out.println("username:"+username.toUpperCase()+"\t"+"Password:"+password);
                                    }
                        
                                    if(!password.equals(rpassword))
                                    {
                                        System.out.println("Your password doesn't matches kindly re enter your password");
                                        continue jump3;
                                    }
                                }

                                break;
                            }
                        }
                        break;
                    }
                }
                else if (i==5) 
                {
                    System.out.println("Attempts Maxed out!!");
                    System.exit(i);    
                }

                break;
            }
            if (i==5) 
            {
                System.out.println("Attempts Maxed out!!");
                System.exit(i);
            }
            vud.add(name);
            vud.add(location);
            vud.add(pincode);
            vud.add(password);
            ud.put(username,vud);
            System.out.println("Your details:"+ud.get(username)); 
            register(cho);

       }
       else if(choice.equalsIgnoreCase("n"))
       {
            Milkinventorym4.mim4.login(mp,ud,c);
       }
       else
       {
            System.out.println("Choose either y or n");
            register(cho);
       }
       myobj.close();
    }
}
