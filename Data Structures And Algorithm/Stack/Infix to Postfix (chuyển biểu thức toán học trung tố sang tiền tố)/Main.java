import java.util.* ;

public class Main
{
    // xet do uu tien cua cac toan tu + - * /
    static int precedence(char operator)
    {
        if(operator == '*' || operator == '/')  return 2 ;
        if(operator == '+' || operator == '-')  return 1 ;
        return 0 ;  
    }

    static double getResult(char operator, double a, double b)  // + - *
    {
        if(operator == '+') return a + b ;
        if(operator == '-') return a - b ;
        if(operator == '/') return a/b ;
        return a * b ; 
    }

    static double calculatePostfix(String postfix)
    {
        Stack<Double> stack = new Stack<>() ;

        for(int i=postfix.length()-1;i>=0;i--)
            if(Character.isDigit(postfix.charAt(i)))
                stack.push(Double.parseDouble(String.valueOf(postfix.charAt(i)))) ;
        
        // postFix: 1 2 + 3 +
        // stack: 3 3
        for(int i=0;i<postfix.length();i++)
            if(!Character.isDigit(postfix.charAt(i)))   // is operator
            {
                double a = stack.pop() ;
                double b = stack.pop() ;
                
                stack.push(getResult(postfix.charAt(i), a, b));
            }

        return stack.peek() ;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in) ;
        Stack<Character> stack = new Stack<Character>() ;
        String postfix = "";

        System.out.print("Nhap vao mot bieu thuc toan hoc co dang Infix: ") ;
        String infix = sc.nextLine() ;
  
        for (int i=0;i<infix.length();i++) 
        {
 		    if(Character.isLetter(infix.charAt(i)) || Character.isDigit(infix.charAt(i)))
                postfix += infix.charAt(i);      
 		    else if(infix.charAt(i) == '(')
                stack.push(infix.charAt(i)); 
            else if(infix.charAt(i) == ')')
            {
                while (stack.peek() != '(')
				    postfix += stack.pop();  // pop cac toan tu

                stack.pop();  // remove '('
            }
		    else if(infix.charAt(i) == '=' 
            || infix.charAt(i) == '+' 
            || infix.charAt(i) == '-'
            || infix.charAt(i) == '*'
            || infix.charAt(i) == '/')
            {
                while (!stack.empty() && stack.peek() != '(' 
                && precedence(infix.charAt(i)) <= precedence(stack.peek()))
                    postfix += stack.pop();
                    
                stack.push(infix.charAt(i)); 
            }
            else    continue ;       
        } 

        while(!stack.empty())
	        postfix += stack.pop();   
        
        // print postfix
        for(int i=0;i<postfix.length();i++)
            System.out.print(postfix.substring(i,i+1) + ' ') ;

        System.out.println("\nResult is: " + calculatePostfix(postfix)) ;
    }
}