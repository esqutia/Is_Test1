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
}
