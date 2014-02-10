/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpn_calculator;

/**
 *
 * @author jonathanmolson
 */
public class Stack 
{
    private int[] myStack = new int[10];
    private int headPointer = -1;
    
    public boolean isEmpty()
    {
        if(headPointer < 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public int pop()
    {
        if(isEmpty()==false)
        {
            int temp = myStack[headPointer];
            headPointer = headPointer - 1;
            return temp;
        }
        else
        {
            return -1;
        }
    }
    
    public void push(int value2add)
    {
        headPointer = headPointer + 1;
        myStack[headPointer] = value2add;
    }
    
    
}
