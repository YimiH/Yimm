package com.yimm;

import java.util.Arrays;

/**
 * 项目名称：Structure
 *
 * @Author: Yimm
 * @Date：2019-08-14 13:38
 * @Description：TODO
 */




class Outter{
    private int out;

    class inner{
        private int a;
        public inner(){
            System.out.println("this is inner 构造方法");
        }
    }

    public void test(){
        inner in=new inner();

    }

}

public class test {
    private int num;


    public static void main(String[] args) {
        /*int[] ints=new int[]{6,3,4,2,5,1};
        char[] chars=new char[]{'d','a','c','b'};
        Arrays.sort(ints);
        for(int i:ints){
            System.out.print(i);
        }

        System.out.println("===========\n");

        Arrays.sort(chars);
        for(char i:chars){
            System.out.println(i);
        }*/


        int[] dataA = new int[]{1,2,3,4,5} ;
        int[] dataB = new int[]{11,22,33,44,55};
        int[] ints = Arrays.copyOf(dataA, 10);

        System.arraycopy(dataB,1,dataA,1,3) ;
        //printArray(ints);

        Outter.inner in=new Outter().new inner();



    }

    public static void printArray(int[] temp) {
        for (int i = 0 ; i<temp.length ; i++) {
            System.out.print(temp[i]+" ") ;
        }
        System.out.println() ;
    }
}
