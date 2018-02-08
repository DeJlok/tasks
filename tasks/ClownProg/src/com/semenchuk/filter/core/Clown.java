package com.semenchuk.filter.core;

/**
 * Created by MrWhite_PRO on 03.02.2018.
 */
public class Clown {
    private final Character[] ARCHES={'(',')'};
    private String[] args;
    private String[] result;

    public Clown(String[] args){
        this.args=args;
        justDoIT();
    }

    public void justDoIT(){
        result=new String[args.length];
        for(int i=0;i<args.length;i++){
            result[i]=format(args[i]);
        }

    }

    public String format(String str) {
        String result = "";
        for (Character c : str.toCharArray()) {
            if (!isIt(ARCHES, c)) {
                result += c;
            } else if (!c.equals(result.charAt(result.length()-1))) {
                result += c;
            }
        }
        return result;
    }

    public boolean isIt(Character[] arr, Character c){
        boolean result=false;
        for(Character elem: arr){
            if(elem.equals(c)){
                result=true;
            }
        }
        return result;
    }
    public String toString(){
        String result= "";
        for (String str:this.result){
            result+=str+" ";
        }
        return result;
    }
}
