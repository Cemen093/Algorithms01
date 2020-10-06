package org.itstep.Interface;

import java.util.Arrays;

public class ToolBar {
    Submenu[] arr;

    public ToolBar(){

    }
    public ToolBar(String[][] _arr){
        arr = new Submenu[_arr.length];
    }


    public int[] addSubMenu(int[] position, String[]){
        int[] array = {51,136, 387};
        if (position.length == 1){

        }
        else{
            addSubMenu(Arrays.copyOfRange(array, 1, position.length));
        }
        return array;
    }
}
