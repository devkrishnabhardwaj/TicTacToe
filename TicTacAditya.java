import java.util.Scanner;
class TicTac
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
        System.out.println("__GAME STARTS__\n");
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
                 System.out.println("After Round "+c+"\n");
                 display(array);
                System.out.print("Again ");
                 break;
                }
               else if(array[j][k].equals(ch1)||array[j][k].equals(ch2))
                {
                    System.out.print("\033[H\033[2J");
                 System.out.println("Wrong Input");
                 display2();
                 System.out.println("After Round "+c+"\n");
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
               int p=check(array,p1,p2,ch1,ch2,h);
               {
                if(p==1)
 {
    System.out.println("__GAME ENDS__\n"+p1+" Wins The Game");
 }
 else if(p==2)
 {
    System.out.println("__GAME ENDS__\n"+p2+" Wins The Game");
 }
               }
                   if(p>=1)
                  flag=1;
                  break;
            }
    }
    }
        if(flag==0)
        System.out.println("__GAME ENDS__\nGame Tied");
}
public static int check(String a[][],String p1,String p2,String ch1,String ch2,int i)
{
    
    String p[]={ch1,ch2};
    int c=0,r=0;
    for(i=0;i<2;i++)
    {
        for(int k=1;k<4;k++)
        {
            if(a[k][1].equals(p[i])&&a[k][2].equals(p[i])&&a[k][3].equals(p[i]))
            return i+1;
            if(a[1][k].equals(p[i])&&a[2][k].equals(p[i])&&a[3][k].equals(p[i]))
            return i+1;
        }
            if(a[1][1].equals(p[i])&&a[2][2].equals(p[i])&&a[3][3].equals(p[i]))
            return i+1;
            if(a[1][3].equals(p[i])&&a[2][2].equals(p[i])&&a[3][1].equals(p[i]))
            return i+1;
}
return 0;
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
System.out.println("|\n");
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
    System.out.println("|\n");
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
System.out.println("|\n");
}
} 
}