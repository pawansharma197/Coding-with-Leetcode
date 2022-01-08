/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class NodeValue{
    int minVal, maxVal, maxSum;
    NodeValue(int minVal, int maxVal, int maxSum){
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.maxSum = maxSum;
    }
}
class Solution {
    int maxS = 0;
    public int maxSumBST(TreeNode root) {
        solve(root);
        return maxS;
    }
    private NodeValue solve(TreeNode root){
        if(root==null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        
        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);
        
        if(root.val>left.maxVal && root.val<right.minVal){
            maxS = Math.max(maxS, root.val+right.maxSum+left.maxSum);
            return new NodeValue(Math.min(root.val,left.minVal),Math.max(root.val,right.maxVal),root.val+right.maxSum+left.maxSum);
        }
        
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSum,right.maxSum));
    }
}