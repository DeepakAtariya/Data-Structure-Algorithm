
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import java.math.BigInteger;
//  Definition for a binary tree node.
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 
class KthLargestSumInBinaryTree {
    
    ArrayList<BigInteger> findLevelSums(TreeNode root)
    {
        HashMap<Integer, BigInteger> dict = new HashMap<Integer, BigInteger>();
        int currLevel = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
 
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                
                if (tempNode.right != null){
                    queue.add(tempNode.right);
                }
                
                if(dict.containsKey(currLevel))
                    dict.put(currLevel, dict.get(currLevel).add(BigInteger.valueOf(tempNode.val)));
                else{
                    dict.put(currLevel, BigInteger.valueOf(tempNode.val));
                }
            }
            
            currLevel++;
        }
        
        return new ArrayList<BigInteger>(dict.values());
    }
    
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        ArrayList<BigInteger> levelSums = findLevelSums(root);
        long res = -1;
        
        if(levelSums.size() >= k){
            Collections.sort(levelSums, Collections.reverseOrder());
            res = levelSums.get(k-1).longValue();
        }
        
        return res;
    }
}


// solution given by 
class BestSolution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(k==9633)return 903240;
      
        Queue<TreeNode> a=new LinkedList<>();
        TreeSet<Long> b=new TreeSet<>();
        a.add(root);
        while(!a.isEmpty()){
             long sum=0;
            int count=a.size();
            while(count>0){
                TreeNode temp=a.peek();
                a.poll();
                sum+=temp.val;
                if(temp.left!=null){
                    a.add(temp.left);
                }if(temp.right!=null){
                    a.add(temp.right);
                }
                count--;
                
            }
            b.add(sum);
            
        }
        int count=0;
        for(long i:b){
            long h=i;
            count++;
            if(b.size()-count+1==k){
                return h;
            }
        }if(b.size()==1){
            return 1;
        }
        return -1;
    }
}

/*

Test case 


3



 */