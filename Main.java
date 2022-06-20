package monoply;

import java.util.Scanner;



public class Main {
	
public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	int currentuser=0;
	
    System.out.println("please enter the number of users");
    int usercount = input.nextInt();
    User[] user = new User[usercount];
    for(int i=0;i<usercount;i++) {
   user[i] = new User();      
   System.out.printf("enter name user: %d\n",i+1);
   user[i].name = input.next();
   if(user[i].name == "") {
	   System.out.println("invalid name ");
   }
    }
	
	System.out.printf("list of active members ");
    for(int i=0;i<usercount;i++) {
    System.out.printf("%s, " ,user[i].name);
    }
 
    System.out.println("we will now require you to enter a passcode and a 4 digit pin");
    System.out.println("");
    System.out.println("your passcode should comprse of 1 upper case letter and the rest lower");
    System.out.println("");
    for(int i=0;i<usercount;i++) {
    	System.out.printf("enter passcode user %d: \n",i+1);
    	System.out.println("");
   	user[i].password = input.next();
   	System.out.printf("please now enter 4 digit code user %d: \n",i+1);
   	user[i].pass = input.nextInt();
   	user[i].cash =2365*i+(i-1);
    }
    for(int i=0;i<usercount;i++) {
    	System.out.println("enter cash balance "+user[i].name);
    	user[i].cash = input.nextInt();
    } 
    
    boolean num1 = true;
	String console = ("**********  OPTION MENU  *********** \n"
         +user[0].name + "is logged in \n" 
    +"1| log into a diffrent account \n" // partially done still need 
    +"2| view account balance\n"         // done
    +"3| transfer money to a diffrent account\n" // done
    +"4| display all active users\n"  // done
    +"5| change password\n"
    +"6| change pin\n"         
    +"7| delete account\n"
    +"8| withdraw money\n"     // done
    +"9| deposit money\n"     // done
    +"10| terminate\n");     //done
	//String console2 = ("**********  OPTION MENU  *********** \n"
	  //       +user[0].name + "is logged in \n" 
	    //+"1| log into a diffrent account \n" 
	    //+"2| view account balance\n"         
	//    +"3| transfer money to a diffrent account\n" 
	  //  +"4| display all active users\n"  
	    //+"5| change password\n"
//	    +"6| change pin\n"         
	//    +"7| delete account\n"
	  //  +"8| withdraw money\n"     
	    //+"9| deposit money\n"     
	   // +"10| terminate\n");     
	do {
		
	
	System.out.println(console);
    int num = input.nextInt();
    switch (num) {
    
    
    
    
    
    case 1: {
    	System.out.println("");
    	System.out.println("please select which number account to log into ");
       for(int i=0;i<usercount;i++) {
    	   System.out.printf("%d  =  %s ",user[i].name,i); 

       }
        
       int selection = input.nextInt();
       System.out.println("current user is "+user[selection].name);
       System.out.println("enter the 4 digit pin to continue");
       int pin1 = input.nextInt();
       if(pin1 == user[selection].pass) {
    	   System.out.println("passwrod is correct");
    	  usercount = usercount + selection;
    	  System.out.println("you are now logged into "+user[usercount].name);
    	   break;
       }
       else {
    	break;
       }
    
    }
   
    
    
    
    
    case 2: {
    	System.out.println("");
    	System.out.println(user[currentuser].cash);
    	break;
    }
    
    
    
    
    case 3: { //transfer
    	System.out.println("");
    	System.out.println("how much cash to transfer");
    	int cashtrans = input.nextInt();
    	if(cashtrans > user[currentuser].cash) {
    		System.out.println("invalid funds");
    		break;
    	}
    	else {
    		
    	
    	System.out.println("choose number");
    for(int i=0;i<usercount;i++) {
    	System.out.println(user[i].name + i);
    	
    }
    int traf = input.nextInt();
    user[traf].cash = user[traf].cash + cashtrans;
    user[currentuser].cash = user[currentuser].cash - cashtrans;
    System.out.println("");
    System.out.println(+cashtrans+ "has been trnsfered too:  "+user[traf]);
    System.out.println("current balance is ");
    System.out.println(user[currentuser].cash);
    break;
    	}}
    
    case 4: {
    	System.out.println("");
    	System.out.println("to view all active accounts enter y");
    		for(int i=0;i<usercount;i++) {
    			System.out.println(user[i].name);
    		}
    			break;
    		}
    
    
    
    case 5: {
    	// change password
    	System.out.println("");
    	System.out.println("to change password enter old password");
    	String passcheck = input.next();
    	if(passcheck == user[currentuser].password) {
    		System.out.println("please enter new password");
    		System.out.println("");
    		user[currentuser].password = input.next();
    		System.out.println("password changed successfully ");
    		break;
    	}
    	else {
    		System.out.println("password incorrect ");
    		break;
    	}
    }
    
    
    case 6: {
    	// change pin
    	System.out.println("");
    	System.out.println("to change password enter old 4 digit pin");
    	int pincheck = input.nextInt();
    	if(pincheck == user[currentuser].pass) {
    		System.out.println("please enter new 4 digit pin");
    		System.out.println("");
    		user[currentuser].pass = input.nextInt();
    		System.out.println("password changed successfully ");
    		break;
    	}
    	else {
    		System.out.println("pin incorrect ");
    		break;
    	}
    }
    
    case 7: {
    	// delete user
    	System.out.println("");
    	System.out.println("select which number to delete");
    	for(int i=0;i<usercount;i++) {
    		System.out.printf("%d ==>  %d\n",i,user[i].name);
    	}
    	System.out.println("");
    	int delete = input.nextInt();
    	System.out.println(user[delete].name + "has been removed from system");
    	user[delete].name = "null";
    	user[delete].cash = 0;
    	user[delete].pass = 0;
    	user[delete].password = "";
    	break;
    	
    }
    
    case 8: {
    	System.out.println("how much do you want to withdraw");
    	System.out.println("50        100");
    	System.out.println("150       200");
    	System.out.println("250       300");
    	System.out.println("350       400");
    	System.out.println("450       500");
    	int withcash = input.nextInt();
    	user[currentuser].cash = user[currentuser].cash - withcash;
    	break;
    	
    }
    
    case 9:{
    	System.out.println("");
    	System.out.println("enter amount you want to lodge");
    	int lodge = input.nextInt();
    	user[currentuser].cash = user[currentuser].cash + lodge;
    	// not sure what to do here need it to return to menu
    	break;

    }

    
    
    	
    	
    
    
     

    
    
    
   
    

    
    
//contd    
    
    
    case 10: {
    	return;
    	
    }
    
    
    
	}}
	while(num1);
	
	}}
    
    
    
    
    
    
    
 
 
 
 
 
 

