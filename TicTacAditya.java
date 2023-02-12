import java.util.Scanner;
class TicTacAditya 
{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter Player 1 Name And His Choice:");
        String p1=ob.next();
        String ch1=ob.next();
        System.out.println("Enter Player 2 Name And His Choice:");
        String p2=ob.next();
        String ch2=ob.next();
        System.out.print("\033[H\033[2J");
        System.out.println("__GAME STARTS__");
        System.out.println();
        
        display2();
        String [][] array=new String[4][4];
        borderset(array); 
        int h=0;
        int flag=0;
        int r=1,c=0;
        while(true)
        {
            int j,k;
           if(flag==1)
            break;
            
            if(c==9)
            break;
                  while(true)
                {
                   if(r%2==0)
            {
                System.out.println(p2+"'s"+" Chance");
                j=ob.nextInt();
                k=ob.nextInt();
            }
             else
            {
                System.out.println(p1+"'s"+" Chance");
                 j=ob.nextInt();
                 k=ob.nextInt();
            }
            if(j>3||k>3)
            {
                System.out.print("\033[H\033[2J");
                 System.out.println("Wrong Input");
                 display2();
                 System.out.println("After Round "+c);
                 System.out.println();
                 display(array);
                 System.out.print("Again ");
                 break;
                }
               else if(array[j][k].equals(ch1)||array[j][k].equals(ch2))
                {
                    System.out.print("\033[H\033[2J");
                 System.out.println("Wrong Input");
                 display2();
                 System.out.println("After Round "+c);
                 System.out.println();
                 display(array);
                 System.out.print("Again ");
                 break;
                }
                else
                {
                    if(r%2==0)
                    array[j][k]=ch2;
                    else
                    array[j][k]=ch1;
                   c=c+1;
                   System.out.print("\033[H\033[2J");
                   display2();
                   System.out.println("After Round "+c);
                   System.out.println();
                  display(array);
                  r++;
                 int p=checkarray(array,p1,p2,ch1,ch2,h);
                   if(p==1)
                  flag=1;
                  break;
            }
    }
    }
        if(flag==0)
        {
             System.out.println("__GAME ENDS__");
        System.out.println("Game Tied");
    }
}
    public static int checkarray(String a[][],String p1,String p2,String ch1,String ch2,int h)
    {
        int c1=0,c2=0,t1=0,c=0;
         if((a[1][1].concat(a[2][2]).concat(a[3][3])).equalsIgnoreCase("XXX"))
        c1++;
       else if((a[1][1].concat(a[2][2]).concat(a[3][3])).equalsIgnoreCase("OOO"))
        c2++;
      else if((a[1][1].concat(a[2][1]).concat(a[3][1])).equalsIgnoreCase("XXX"))
        c1++;
      else if((a[1][1].concat(a[2][1]).concat(a[3][1])).equalsIgnoreCase("OOO"))
       c2++;
       else if((a[1][1].concat(a[1][2]).concat(a[1][3])).equalsIgnoreCase("XXX"))
        c1++;
     else if((a[1][1].concat(a[1][2]).concat(a[1][3])).equalsIgnoreCase("OOO"))
        c2++;
        else if((a[1][3].concat(a[2][3]).concat(a[3][3])).equalsIgnoreCase("XXX"))
        c1++;
     else if((a[1][3].concat(a[2][3]).concat(a[3][3])).equalsIgnoreCase("OOO"))
        c2++;
       else if((a[3][1].concat(a[3][2]).concat(a[3][3])).equalsIgnoreCase("XXX"))
        c1++;
       else if((a[3][1].concat(a[3][2]).concat(a[3][3])).equalsIgnoreCase("OOO"))
        c2++; 
        else if((a[1][3].concat(a[2][2]).concat(a[3][1])).equalsIgnoreCase("XXX"))
        c1++;
        else if((a[1][3].concat(a[2][2]).concat(a[3][1])).equalsIgnoreCase("OOO"))
        c2++;
        else if((a[1][2].concat(a[2][2]).concat(a[3][2])).equalsIgnoreCase("XXX"))
        c1++;
        else if((a[1][2].concat(a[2][2]).concat(a[3][2])).equalsIgnoreCase("OOO"))
        c2++;
        else if((a[2][1].concat(a[2][2]).concat(a[2][3])).equalsIgnoreCase("XXX"))
        c1++;
        else if((a[2][1].concat(a[2][2]).concat(a[2][3])).equalsIgnoreCase("OOO"))
        c2++;
       
        else
        t1++;
        
        if(c1==1)
        {
            c=1;
            if(ch1.equalsIgnoreCase("X"))
            {
             System.out.println("__GAME ENDS__");
        System.out.println(p1+" Wins The Game");
    }
    else if(ch2.equalsIgnoreCase("X"))
    {
        System.out.println("__GAME ENDS__");
        System.out.println(p2+" Wins The Game");
}
}
        else if(c2==1)
        {
            c=1;
            if(ch1.equalsIgnoreCase("O"))
            {
             System.out.println("__GAME ENDS__");
        System.out.println(p1+" Wins The Game");
    }
    else if(ch2.equalsIgnoreCase("O"))
    {
    System.out.println("__GAME ENDS__");
        System.out.println(p2+" Wins The Game");
}
 }
    return c;
}
    public static void borderset(String array[][])
    { 
        for(int a=1;a<4;a++)
{
for(int b=1;b<4;b++)
{
    array[a][b]="|-";
    System.out.print(array[a][b]);
}
System.out.println("|");
System.out.println();
} 
}
public static void display2()
{
    for(int i=1;i<4;i++)
    {
    for(int j=1;j<4;j++)
    {
        System.out.print("|"+i+""+j);
    }
    System.out.println("|");
    System.out.println();
    }
}
 public static void display(String array[][])
{
for(int a=1;a<4;a++)
{
   for(int b=1;b<4;b++)
{
    if(array[a][b].equals("X")||array[a][b].equals("O"))
System.out.print("|"+array[a][b]);
else
System.out.print(array[a][b]);
}
System.out.println("|");
System.out.println();
}
} 
}