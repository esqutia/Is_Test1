package sample;

public class Warmup2 {
    public String stringYak(String str) {
        String tmp="";
        int i=0;
        while(i<str.length()){
            if(i+2<str.length() && str.charAt(i)=='y' && str.charAt(i+1)=='a' && str.charAt(i+2)=='k'){
                i=i+3;
            }else{
                tmp=tmp+str.charAt(i);
                i++;
            }
        }
        return tmp;
    }


    public int array667(int[] nums) {
        int count = 0;
        for (int i=0; i < (nums.length-1); i++) {
            if (nums[i] == 6) {
                if (nums[i+1] == 6 || nums[i+1] == 7) {
                    count++;
                    System.out.println(nums[i]);
                    System.out.println(nums[i+1]);
                    System.out.println(nums[count]);
                }
            }
        }
        return count;

    }
}
