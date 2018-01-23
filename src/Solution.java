import java.util.Arrays;
import java.util.Comparator;


class Pair{
    int value;
    int index;
    public Pair(int value, int index){
        this.value = value;
        this.index = index;
    }
        }

public class Solution {
    /*
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    static public void main(String [] args){

        int [] nums = new int [] {2,7,15,24};
        int [] result = new int [2];
        Solution test = new Solution();

        result = test.twoSum7(nums,-5);

        for (int value: result) {
            System.out.println(value);
        }

    }


    public int[] twoSum7(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        //pay attention
        if(target < 0){
            target = -target;
        }
        Pair [] pairs = new Pair[nums.length];

        for(int i = 0; i < nums.length ; i++){
            pairs[i] = new Pair(nums[i],i);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value - o2.value;
            }
        });


        int index1 = 0;
        int index2 = 1;

        for(; index1 < nums.length ; index1++){

            if(index1 == index2){
                index2++;
            }

            //why we need index2 < nums.length
            while(index2 < nums.length && pairs[index2].value - pairs[index1].value < target){
                index2++;
            }

            //why we need index2 < nums.length
            if(index2 < nums.length && pairs[index2].value - pairs[index1].value == target){
                break;
            }
        }

        if(index1 == nums.length){
            return null;
        }
        else {
            return pairs[index1].index < pairs[index2].index?
                    new int[] {pairs[index1].index+1,pairs[index2].index+1}:
                    new int[] {pairs[index2].index+1,pairs[index1].index+1};
        }
    }
}