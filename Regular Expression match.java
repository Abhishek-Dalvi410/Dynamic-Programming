import java.util.*;
public class Main {
  public static void main(String[] args) 
  {
    Scanner sc=new Scanner(System.in);
    String pattern, text;
    System.out.println("-------------------Program for Regular Expression matching--------------\n \n");
    System.out.println("Enter pattern");
    pattern=sc.next();
    System.out.println("Enter text");
    text=sc.next();
    int tl=text.length()+1;
    int pl=pattern.length()+1;
    boolean results[][]=new boolean[tl][pl];
    
    /*for(int i=0;i<tl;i++)
    {
      for(int j=0;j<pl;j++)
      {
        System.out.print(results[i][j]+"\t");
      }
      System.out.println();
    }*/

    results[0][0]=true;
    
    for(int i=1;i<tl;i++)
    {
      for(int j=1;j<pl;j++)
      {
        if((pattern.charAt(j-1)==text.charAt(i-1))||pattern.charAt(j-1)=='.')
        {
          results[i][j]=results[i-1][j-1];
        }

        else if(pattern.charAt(j-1)=='*')
        {
          if(results[i][j-2]==true)
          {
            results[i][j]=true;
          }
          
          else if(pattern.charAt(j-2)==text.charAt(i-1)||pattern.charAt(j-2)=='.')
          {
            if(results[i-1][j]==true)
            {
              results[i][j]=true;
            }
          }
        }
        
      }
    }

    if(results[t1-1][pl-1])
    System.out.println("Regular Expressions Match");
    else
    System.out.println("Not a Regular Expression Match");

  }
}