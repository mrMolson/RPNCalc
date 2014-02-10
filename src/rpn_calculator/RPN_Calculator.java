/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn_calculator;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author jonathanmolson
 */
public class RPN_Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Stack RPNStack = new Stack();
        String RPNString = "";
        boolean error = false;
        
        Scanner keypInp = new Scanner(System.in);
        
        System.out.println("Please insert your expression seperating the numbers and symbols with a comma :");
        RPNString = keypInp.nextLine();
        StringTokenizer SplitRPNString = new StringTokenizer(RPNString,",");
        
        while(SplitRPNString.hasMoreTokens()==true)
        {
            String temp = SplitRPNString.nextToken();
            if(temp.matches("[0-9]+")==true)
            {
                int temp2 = Integer.parseInt(temp);
                RPNStack.push(temp2);
            }
            else if(temp.matches("[*]|[/]|[+]|[-]")==true)
            {
                int x = RPNStack.pop();
                int y = RPNStack.pop();
                if(x==-1||y==-1)
                {
                    error = true;
                }
                else
                {
                    switch(temp)
                    {
                        case "+": RPNStack.push(x+y);
                            break;
                        case "-": RPNStack.push(x-y);
                            break;
                        case "*": RPNStack.push(x*y);
                            break;
                        case "/": RPNStack.push(y/x);
                            break;
                    }
                }
            }
            else
            {
                error = true;
            }
        }
        if(error==true)
        {
            System.out.println("Please insert a valid expression");
        }
        else
        {
            System.out.println("Your answer is : " + RPNStack.pop());
        }
        
    }
}
