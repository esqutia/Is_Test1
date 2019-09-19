package sample;

import java.util.Map;

public class MapAB{
    public Map<String, String> mapAB(Map<String, String> map) {
        String a, b;
        a=map.get("a");
        b=map.get("b");
        if(a!=null && b!=null){
            map.remove("b");
            map.put("ab", a+b);
            map.put("b", b);
        }
        return map;
    }
}