package balancedparentheses;

import java.util.Stack;

/**
 * A class to emulate reading from a text stream
 * from standard input and uses a stack to determine whether its parentheses are
 * properly balanced. A true statement will be returned for a String like:
 * [()]{}[{[()()]()}] and false for {[(])}.
 *
 * @author Paola Jiron 06/10/15
 */

public class BalancedParentheses
{
    public static boolean balanced(String s)
    {
        Stack<Character> brace = new Stack<>();

        int i = 0;

        while (i < s.length())     // while not end of file
        {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[')    
            {
                brace.push(c);
            }
            else
            {
                if (!brace.isEmpty())
                {
                    char popped = brace.pop();  
                  
                    // De Morgan's Laws
                    if (!((popped == '(' && c == ')') || (popped == '{' && c == '}') || (popped == '[' && c == ']')))
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }   
            i++;
        }
        return brace.isEmpty();
    }
    // tester for BalancedParentheses 
    public static void main(String[] args)
    {
        System.out.println(balanced("[()]{}[{[()()]()}]"));  // true balance
        System.out.println(balanced("{[(])}"));             // false balance
    }
}  // end of BalancedParentheses class definitions