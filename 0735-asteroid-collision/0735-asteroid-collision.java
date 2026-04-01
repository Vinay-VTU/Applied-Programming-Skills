import java.util.*;
class Solution{
public int[] asteroidCollision(int[] a){
Stack<Integer>s=new Stack<>();
for(int x:a){
boolean alive=true;
while(alive&&!s.isEmpty()&&s.peek()>0&&x<0){
if(Math.abs(s.peek())<Math.abs(x))s.pop();
else if(Math.abs(s.peek())==Math.abs(x)){s.pop();alive=false;}
else alive=false;
}
if(alive)s.push(x);
}
int[]res=new int[s.size()];
for(int i=s.size()-1;i>=0;i--)res[i]=s.pop();
return res;
}
}