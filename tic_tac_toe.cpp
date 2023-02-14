#include<bits/stdc++.h>
using namespace std;
void clrscr(){
    system("cls || clear");
}
void show(char a[3][3]){
    clrscr();
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
int win_check(char s[3][3],char key[]){
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
int ifComputer(string com){
    transform(com.begin(), com.end(), com.begin(), ::tolower);
    if(com == "computer"){
        return 1;
    }
    return 0;
}
void Com_move(char s[3][3],char key[],int k){
    srand(time(0));
    vector<int> emptyPlace;
    for(int i=0;i<3;i++)
    for(int j=0;j<3;j++)
    if(s[i][j]==' '){
        emptyPlace.push_back(3*i+j);
    }
    int pos = emptyPlace[rand()%(emptyPlace.size())];
    int i=pos/3;
    int j=pos%3;
    s[i][j]=key[k];
}
void ticTacToe(){
    char s[3][3];
    for(int i=0;i<3;i++)
    for(int j=0;j<3;j++)
    s[i][j]=' ';
    char key[2];
    string name[2];
    clrscr();
    for(int i=0;i<2;i++){
        cout<<"Enter Player_"<<i+1<<" Name : ";
        cin>>name[i];
        cout<<"Enter "<<name[i]<<"'s Playing Character :";
        cin>>key[i];
    }
    show(s);
    for(int t=0;t<9;t++){
        if(ifComputer(name[t%2])){
            Com_move(s,key,t%2);
            goto CHECK;
        }
        int i,j,pos;
        cout<<"It's "<<name[t%2]<<"'s Turn."<<endl;
        cout<<"Enter Position for ["<<key[t%2]<<"] : ";
        AGAIN:
        cin>>pos;
        pos--;
        i = pos/3;
        j = pos%3;
        if(i>2||j>2||i<0||j<0|| s[i][j]!=' '){
            cout<<"Wrong Input\n";
            cout<<"Enter Position Again :";
            goto AGAIN;
        }
        s[i][j]= key[t%2];
        CHECK:
        show(s);
        int c=win_check(s,key);
        if(c){
          cout<<"\n\t"<<"["<<key[c-1]<<"] : "<<name[c-1]<<" WON\n\n";
          break;  
        }
        else if(t==8){
            cout<<"\n\tGAME DRAW\n\n";
        }
    }
}
int main(){
    ticTacToe();
    return 0;
}