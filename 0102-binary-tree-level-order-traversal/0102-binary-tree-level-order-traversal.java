import java.util.*;
class Solution{
public List<List<Integer>> levelOrder(TreeNode root){
List<List<Integer>>res=new ArrayList<>();
if(root==null)return res;
Queue<TreeNode>q=new LinkedList<>();
q.offer(root);
while(!q.isEmpty()){
int n=q.size();
List<Integer>level=new ArrayList<>();
for(int i=0;i<n;i++){
TreeNode cur=q.poll();
level.add(cur.val);
if(cur.left!=null)q.offer(cur.left);
if(cur.right!=null)q.offer(cur.right);
}
res.add(level);
}
return res;
}
}