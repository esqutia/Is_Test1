package sample;

public class In_Order_Equal {
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
