package Tree.Top6;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution10{
    Integer prev = null;
    int count = 1;
    int max = 0;

    public int[] findMode(TreeNode root){
        List<Integer> modes = new ArrayList();

        traverse(root, modes);

        int[] result = new int[modes.size()];
        for(int i=0; i< modes.size(); i++){
            result[i] = modes.get(i);
        }
        return result;
    }

    public void traverse(TreeNode node, List<Integer> modes){

        if(node ==null) return;

        traverse(node.left, modes);

        // This is when you are processing the root element
        if(prev!=null){
            if(prev == node.value){
                count++;
            }else{
                count = 1;
            }
        }

        if(count> max){
            max= count;
            modes.clear();
            modes.add(node.value);
        }else if (count == max){
            modes.add(node.value);
        }

        prev = node.value;
        traverse(node.right, modes);
    }
}