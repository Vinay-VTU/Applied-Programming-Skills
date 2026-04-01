import java.util.*;
class Solution{
public int longestSubarray(int[] a,int limit){
Deque<Integer>maxD=new ArrayDeque<>();
Deque<Integer>minD=new ArrayDeque<>();
int l=0,res=0;
for(int r=0;r<a.length;r++){
while(!maxD.isEmpty()&&a[maxD.peekLast()]<a[r])maxD.pollLast();
while(!minD.isEmpty()&&a[minD.peekLast()]>a[r])minD.pollLast();
maxD.offerLast(r);
minD.offerLast(r);
while(a[maxD.peekFirst()]-a[minD.peekFirst()]>limit){
if(maxD.peekFirst()==l)maxD.pollFirst();
if(minD.peekFirst()==l)minD.pollFirst();
l++;
}
res=Math.max(res,r-l+1);
}
return res;
}
}