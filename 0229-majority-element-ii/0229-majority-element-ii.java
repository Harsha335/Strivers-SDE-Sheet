class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1=-(int)1e9-1;
        int num2=(int)1e9+1;
        int count1=0,count2=0;
        for(int x:nums)
        {
             if(num1==x)
            {
                count1++;
            }
            else if(num2==x)
            {
                count2++;
            }
            else if(count1==0)
            {
                num1=x;
                count1=1;
            }
            else if(count2==0)
            {
                num2=x;
                count2=1;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        // System.out.println(num1+" "+num2);
        count1=0;
        count2=0;
        for(int x:nums)
        {
            if(x==num1)count1++;
            else if(x==num2)count2++;
        }
        List<Integer> output=new ArrayList<>();
        if(count1>nums.length/3)output.add(num1);
        if(count2>nums.length/3)output.add(num2);
        return output;
    }
}