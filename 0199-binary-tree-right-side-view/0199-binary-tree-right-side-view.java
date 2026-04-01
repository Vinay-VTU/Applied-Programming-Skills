import java.util.*;
class Solution{
public List<Integer> rightSideView(TreeNode root){
List<Integer>res=new ArrayList<>();
if(root==null)return res;
Queue<TreeNode>q=new LinkedList<>();
q.offer(root);
while(!q.isEmpty()){
int n=q.size();
for(int i=0;i<n;i++){
TreeNode cur=q.poll();
if(i==n-1)res.add(cur.val);
if(cur.left!=null)q.offer(cur.left);
if(cur.right!=null)q.offer(cur.right);
}
}
return res;
}
}