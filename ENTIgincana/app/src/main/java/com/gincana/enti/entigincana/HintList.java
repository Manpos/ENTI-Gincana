package com.gincana.enti.entigincana;

import java.util.ArrayList;
import java.util.Iterator;

public class HintList {

    private static ArrayList<Hint> hintList = new ArrayList<Hint>();

    private static int size;

    public static void addHint(Hint h){
        if(searchHint(h.getIdentificator()) != null){
            throw new RuntimeException("There's already a hint with this ID");
        }
        else {
            hintList.add(h);
            size++;
        }
    }

    public static Hint searchHint(int id) {
        Iterator<Hint> i = hintList.iterator();
        Hint h = null;
        boolean found = false;
        while(i.hasNext() && !found){
            h = i.next();
            if(h.getIdentificator() == id){
                found = true;
            }
        }
        if(found) return h;
        else return null;
    }

    public static void deleteHint(int id){
        hintList.remove(searchHint(id));
    }

    public static int nextHint(int id){

        int tmp = -1;

        for (Hint h : hintList) {
            if (h.getIdentificator() == id) {
                tmp = h.getNextHint();
            }
        }
        return tmp;
    }

    public static void listHints(){
        for(Hint h:hintList){
            h.printInfo();
        }
    }

    public static String listHintsId(){
        String result = new String();
        for(Hint h:hintList){
            result = result + h.getIdentificator() + " ";
        }
        return result;
    }

    public static String getDescriptions(){
        String result = new String();
        for(Hint h:hintList){
            result = result + h.getDescription() + " ";
        }
        return result;
    }

    public static ArrayList<Hint> getHintList(){
        return hintList;
    }

    public static int getSize(){
        return size;
    }

}
