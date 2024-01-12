class Solution {
    public String numberToWords(int num) {
        String ones[] = new String[]{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String tens[] = new String[]{"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if(num == 0)
            return ones[0];
        HashMap<Integer,String> places = new HashMap<>();
        places.put(4, "Thousand");
        places.put(7, "Million");
        places.put(10, "Billion");
        int place = 1;
        Stack<String> stack = new Stack<>();
        while(num > 0){
            if(places.containsKey(place) && ((num%10 != 0) || (num/10)%10 != 0 || (num/100)%10 != 0)){
                stack.push(places.get(place));
            }
            int curr = num%10;
            num /= 10;
            if( curr == 0)
            {
                place ++;
                continue;
            }
            if(place%3 == 1 && num%10 == 1){
                int currPre = num%10;
                stack.push(ones[currPre*10 + curr]);
                num /= 10;
                place += 1;
            }
            else if(place%3 == 1){
                stack.push(ones[curr]);
            }
            else if(place%3 == 2){
                stack.push(tens[curr]);
            }
            else if(place%3 == 0){
                stack.push("Hundred");
                stack.push(ones[curr]);
            }
            place ++;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}