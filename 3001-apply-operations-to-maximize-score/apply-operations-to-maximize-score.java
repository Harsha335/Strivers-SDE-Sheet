class Solution {
    public int maximumScore(List<Integer> nums, int k) {
        //finding prime score
        int maxi=0;
        int n=nums.size();
        //getting max ele
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->b.get(0)-a.get(0));
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,nums.get(i));
            pq.add(Arrays.asList(nums.get(i),i));
        }
        int primeScore[]=new int[maxi+1];
        boolean isPrime[]=new boolean[maxi+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        // primeScore[1]=1; //vurike
        for(int i=2;i<=maxi;i++)
        {
            if(isPrime[i])
            {
                // primeScore[i]=1;//
                for(int j=i;j<=maxi;j+=i)
                {
                    isPrime[j]=false;
                    primeScore[j]+=1;   //counting prime numbers
                }
            }
        }
        // System.out.println("prime");
        // for(int i=0;i<=maxi;i++)
        // {
        //     System.out.println(i+" "+isPrime[i]+" "+primeScore[i]);
        // }
        int postMax[]=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty() && primeScore[nums.get(stack.peek())]<primeScore[nums.get(i)])
            {
                // System.out.println(primeScore[stack.peek()]+" "+primeScore[i]);
                postMax[stack.pop()]=i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            postMax[stack.pop()]=n;
        }
        // System.out.println("post");
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(postMax[i]+" ");
        // }
        int preMax[]=new int[n];
        // stack.clear();
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && primeScore[nums.get(stack.peek())]<=primeScore[nums.get(i)])
            {
                preMax[stack.pop()]=i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty())
        {
            preMax[stack.pop()]=-1;
        }
        // System.out.println("pre");
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(preMax[i]+" ");
        // }
        // int mod=(int)1e9+7;
        int ans=1;
        while(!pq.isEmpty() && k>0)
        {
            List<Integer> ele=pq.poll();
            // System.out.println(ele);
            int times=Math.min(k,(ele.get(1)-preMax[ele.get(1)])*(postMax[ele.get(1)]-ele.get(1)));
             int power = calculatePower(ele.get(0), times);
            ans = (int) (((long) ans * power)%mod);
            k-=times;
            // System.out.println(ans+" "+times+" "+ele.get(0));
        }
        return ans;

    }
   int mod = (int) 1e9 + 7;

public int calculatePower(int base, int exponent) {
//     int result = 1;
//     while (exponent > 0) {
//         if (exponent % 2 == 1) {
//             result = (int) (((long) result * base)%mod);
//         }
//         base = (int) (((long) base * base) % mod);
//         exponent /= 2;
//     }
//     return result;
// }
    if(exponent==1) return base;
    int value=calculatePower(base,exponent/2);
    return (int)((1L*((1L*value*value)%mod)*(exponent%2==0?1:base))%mod);
    // return (int) ((1L * ((1L * value * value) % mod) * (exponent % 2 == 1 ? base : 1)) % mod);
    }
}