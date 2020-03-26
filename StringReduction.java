package code.assignment.binarytree; 

public class StringReduction { 
   
public static String maxReducedString (String s) { 
	int len=s.length();

    int i = 0;
    while (i<len-1) {
        char currentChar = s.charAt(i);
        char nextChar = s.charAt(i+1);

        if (currentChar == nextChar) {
            s = s.substring(0, i) + s.substring(i+2);
            len = s.length();
            i = 0;
            continue;
        }
        i++;
    }
    if (s.length()==0) {
        return "Empty String";
    }
    return s;
} 

public static void main(String[] args) 
{ 
 String s = "aabcccd"; 
 System.out.println("Initial string is :: "+s);
 System.out.println("Max reduced string is :: "+maxReducedString(s)); 
} 
}