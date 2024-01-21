public class MaxMirror {
    public static void main(String[] args) {

    }

    public int maxMirror(int[] nums)
    {
        int span;
        int maxSpan = 0;
        int left;
        int right;
        for(int i = 0; i < nums.length; i++)
        {
            left = i;
            right = lastIndexOf(nums, nums[i], nums.length - 1);
            while(right != -1)
            {
                span = 0;
                left = i;
                do
                {
                    left++;
                    right--;
                    span++;
                }	while(left < nums.length && right >= 0 && nums[left] == nums[right]);
                if(span > maxSpan)
                    maxSpan = span;
                right = lastIndexOf(nums, nums[i], right);
            }
        }
        return maxSpan;
    }

    // helper function for maxMirror
    public int lastIndexOf(int[] nums, int value, int index)
    {
        for(; index >= 0; index--)
        {
            if(nums[index] == value)
                return index;
        }
        return -1;
    }
}
