import java.util.*;
class Solution{
public int[] maxSlidingWindow(int[] a,int k){
Deque<Integer>d=new ArrayDeque<>();
int n=a.length;
int[]res=new int[n-k+1];
int j=0;
for(int i=0;i<n;i++){
while(!d.isEmpty()&&d.peekFirst()<=i-k)d.pollFirst();
while(!d.isEmpty()&&a[d.peekLast()]<a[i])d.pollLast();
d.offerLast(i);
if(i>=k-1)res[j++]=a[d.peekFirst()];
}
return res;
}
}