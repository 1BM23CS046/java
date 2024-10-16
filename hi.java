import java.util.scanner;
class student{
string usn.name;
int m[]=new int[3];
int c[]=new.int[3];
int g.es.tc;
double sgpa;
scanner s=new scanner(system.in);

void details()
{
system.out.println("enter usn:");
usn=s.next();
system.out.println("enter name:");
name=s.next();
system.out.println("enter marks:");
for(int i=0;i<3;i++)
{
m[i]=s.next int()
}
system.out.println("enter credits for 3 subjects:");

for(int i=0;i<3;i++)
{
c[i]=s.next();
}
void display()
{
system.out.println("usn:"+" "+usn);
system.out.println("name:"+" "+name);
system.out.println("marks:");

for(int i=0;i<3;i++)
{
system.out.println("marks"+" "+(i+1)
}
}

void sgpacalc()
{

system.out.println("usn:"+" "+usn);
for(int i=0;i<3;i++)
{
g=(m[i][10]+1;
es+=g*c[i];
tc+=c[i];
}
sgpa=(double)es/(double)tc;
system.out.println(sgpa);
}
}

class hi{
public static void main(string[]args);
{
student s[]=newstudent[s];
for(int i=0;i<3;i++)
{
s[i]=new student();
}
for(int j=0;j<3;j++)
{
system.out.println("enter details of"+" "+(j+1)+s[j].details();
}
for(int k=0;k<3;k++)
system.out.println("details of"+" "+(k+1)+"student:");
s[k].display();
}
for(int i=0;i<3;i++)
{
system.out.println("sgpa of"+" "+(i+1)+"student:");
s[i].sgpacalc();
}
}
}



