#include<iostream>
#include<string>
using namespace std;
void clrscr(){
    system("cls || clear");
}
void show(char a[3][3]){
    cout<<"-===========-";
    cout<<"\t\t-===========-"<<endl;
    cout<<"| "<<a[0][0]<<" | "<<a[0][1]<<" | "<<a[0][2]<<" |";
    cout<<"\t\t| 1 | 2 | 3 |"<<endl;
    cout<<"|===|===|===|";
    cout<<"\t\t|===|===|===|"<<endl;
    cout<<"| "<<a[1][0]<<" | "<<a[1][1]<<" | "<<a[1][2]<<" |";
    cout<<"\t\t| 4 | 5 | 6 |"<<endl;
    cout<<"|===|===|===|";
    cout<<"\t\t|===|===|===|"<<endl;
    cout<<"| "<<a[2][0]<<" | "<<a[2][1]<<" | "<<a[2][2]<<" |";
    cout<<"\t\t| 7 | 8 | 9 |"<<endl;
    cout<<"-===========-";
    cout<<"\t\t-===========-"<<endl;
}
int win_check(char s[3][3]){
    char key[]={'O','X'};
    for(int k=0;k<2;k++){
        for(int i=0;i<3;i++){
            if(s[i][0]==key[k]&&s[i][1]==key[k]&&s[i][2]==key[k])
                return k+1;
            if(s[0][i]==key[k]&&s[1][i]==key[k]&&s[2][i]==key[k])
                return k+1;
        }
        if(s[0][0]==key[k]&&s[1][1]==key[k]&&s[2][2]==key[k])
            return k+1;
        if(s[0][2]==key[k]&&s[1][1]==key[k]&&s[2][0]==key[k])
            return k+1;
    }
    return 0;
}
int main(){
    char s[3][3];
    for(int i=0;i<3;i++)
    for(int j=0;j<3;j++)
    s[i][j]=' ';
    char tic_tac[2]={'O','X'};
    string name[2];
    clrscr();
    cout<<"Enter Player_1 Name : ";
    cin>>name[0];
    cout<<"Enter Player_2 Name : ";
    cin>>name[1];
    int t=9;
    clrscr();
    show(s);
    int all_pos[9]={0};
    for(int t=0;t<9;t++){
        int i,j,pos;
        cout<<"It's "<<name[t%2]<<"'s Turn."<<endl;
        cout<<"Enter Position : ";
        cin>>pos;
        pos--;
        i = pos/3;
        j = pos%3;
        while(i>2||j>2||i<0||j<0|| s[i][j]!=' '){
            cout<<"Wrong Input\n";
            cout<<"Enter Position Again :";
            cin>>pos;
            pos--;
            i = pos/3;
            j = pos%3;
        }
        s[i][j]= tic_tac[t%2];
        clrscr();
        show(s);
        int c=win_check(s);
        if(c){
          cout<<"\n\t"<<name[c-1]<<" WON\n\n";
          break;  
        }
        else if(t==8){
            cout<<"\n\tGAME DRAW\n\n";
        }
    }
    return 0;
}