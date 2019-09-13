package sample;

public class Logic1 {
    public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
        if (a<b && a<c && b<c && !equalOk){
            return true;
        }
        if(a<=b && a<=c && b<=c && equalOk){
            return true;

        }
        return false;
    }
}
