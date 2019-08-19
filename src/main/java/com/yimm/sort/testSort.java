package com.yimm.sort;

import java.util.Random;
import java.util.Stack;

/**
 * Author: sy
 * Create:2019-08-05
 * 07:18
 */
public class testSort {

    /* *
     * @name: shellSort
     * @description: 希尔排序（分组排序）
     * 直接插排的优化
     * 时间复杂度：O（n^1.3 ~ n^1.5）
     * 空间复杂度：O（1）
     * 稳定性：不稳定
     * @param array
     * @return: void
     *
    */
    public static void shellSort(int[] array){
        int[] drr={5,3,1};
        for(int i=0;i<drr.length;i++){
            shell(array,drr[i]);
        }
    }

    private static void shell(int[] array, int gap) {
        for(int i=gap;i<array.length;i++){
            int tmp=array[i];
            int j=0;
            //此处判断j的减幅应为gap，进行同组直接插排
            for(j=i-gap;j>=0;j-=gap){
                if(array[j]>tmp) {
                    array[j+gap]=array[j];
                }else{
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }



   /**
    * @name:   insertSort
    * @description: 直接插入排序，时间负责度O（n^2）-->最好是O（n）
    * 空间负责度O（1）
    * 稳定性：稳定
    * @param array
    * @return: void
    *
   */
    public static void insertSort(int[] array){
        /*for(int i=1;i<array.length;i++){
            int tmp=array[i];
            int j=0;
            for(j=i-1;j>=0;j--){
                if(array[j]>tmp){
                    //注意此处数组的下标应为j相关的，因为j+1不断向后移动
                    array[j+1]=array[j];
                }else{
                    //有序后，前面的部分一定有序
                    //array[j+1]=tmp;
                    break;
                }
            }
            //此处应为j走到-1位置处
            array[j+1]=tmp;
        }*/

        for(int i=1;i<array.length;i++){
            int tmp=array[i];
            int j=0;
            for(j=i-1;j>=0;j--){
                if(array[j]>tmp)
                    array[j+1]=array[j];
                else
                    //一旦有序无须再次向前遍历（前面有序）
                    break;
            }
            /*走到此处有两种情况：
            * 1.j此时小于0；
            * 2.array[j]<tmp--->则前面也已经有序
            */
            array[j+1]=tmp;
        }
    }


    /**
     * @name: selectSort
     * @description: 选择排序
     * 时间复杂度：O（n^2）
     * 空间复杂度：O（1）
     * 稳定性：不稳定
     * @param array
     * @return: void
     *
    */
    public static void selectSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    int tmp=array[j];
                    array[j]=array[i];
                    array[i]=tmp;
                }
            }
        }
    }



    /**
     * @name: bubbleSort
     * @description: 冒泡排序
     * 时间复杂度：O（n^2） 优化之后O（n）
     * 空间复杂度：O（1）
     * 稳定性：稳定
     * @param array
     * @return: void
     *
    */
    public static void bubbleSort(int[] array){
        boolean flag=true;
        //代表比较的趟数
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flag=false;
                }
            }
            //如果没被更改过则说明当前数组已经有序,直接break退出for循环
            if(flag)
                break;
        }
    }


    public static int partion(int[] array,int low,int high){
        medOfThree(array,low,high);
        int tmp=array[low];
        while(low<high){

            while(low<high && array[high]>=tmp){
                high--;
            }

            if(low>=high){
                //array[low]=tmp;
                break;
            }else{
                array[low]=array[high];
            }


            while(low<high && array[low]<=tmp){
                low++;
            }

            if(low>=high){
                //array[low]=tmp;
                break;
            }else{
                array[high]=array[low];
            }
        }
        array[low]=tmp;
        return low;
    }

    public static void swap(int[] array,int a,int b){
        int tmp=array[a];
        array[a]=array[b];
        array[b]=tmp;
    }

    public static void medOfThree(int[] array,int low,int high){
        int mid=(low+high)/2;

        if(array[mid]<array[low]){
            swap(array,mid,low);
        }

        if(array[mid]>array[high]){
            swap(array,mid,high);
        }

        /*if(array[low]>array[high]){
            swap(array,low,high);
        }
*/

    }

    public static void insertSort2(int[] array,int start,int end){
        for(int i=start+1;i<=end;i++){
            int tmp=array[i];
            int j=0;
            for(j=i-1;j>=start;j--){
                if(array[j]>tmp)
                    array[j+1]=array[j];
                else
                    break;
            }
            array[j+1]=tmp;
        }
    }


    public static void quick(int[] array,int start,int end){
        //第二种优化
        if(end-start+1>15)
            insertSort2(array,start,end);

        int par=partion(array,start,end);
        //递归左边--保证左边有大于一个的元素
        if(par>start+1) {
            quick(array, start, par - 1);
        }
        //递归右边--保证右边有大于一个的元素
        if(par<end-1) {
            quick(array, par+1, end);
        }
    }


    /**
     * @name: quickSort
     * @description: (递归)快速排序
     * 时间复杂度：最好O（n*log 2 n） 最坏：O（n^2）
     * 空间复杂度：O（logn） 最坏：O（n）-->排序数组为{1，2，3，4，5，6}
     * 稳定性：不稳定
     * @param array
     * @return: void
     *
    */
    public static void quickSort1(int[] array){
        quick(array,0,array.length-1);
    }


    /**
     * @name: quickSort
     * @description: （非递归版本的）快速排序
     * @param array
     * @return: void
     *
    */
    public static void quickSort2(int[] array){
        int low=0;
        int high=array.length-1;
        int par=partion(array,low,high);
        Stack<Integer> stack=new Stack<Integer>();


        /*当按照基准值划分后两边都大于两个数，将其左右下标入栈*/
        if(par>low+1) {
            stack.push(low);
            stack.push(par - 1);
        }

        if(par<high-1){
            stack.push(par+1);
            stack.push(high);
        }

        while(!stack.empty()){
            high=stack.pop();
            low=stack.pop();
            par=partion(array,low,high);

            if(par>low+1){
                stack.push(low);
                stack.push(par - 1);
            }

            if(par<high-1){
                stack.push(par+1);
                stack.push(high);
            }
        }

    }


    /**
     * @name: mergerSort
     * @description: 归并排序
     * 时间复杂度：O（nlogn）
     * 空间复杂度：O(n)
     * 稳定性：稳定
     * @param array
     * @param start
     * @param end
     * @return: void
     *
    */
    public static void mergeSort(int[] array,int start,int end,int[] tmpArr){
        //递归的结束条件
        if(start>=end){
            return;
        }
        //mid每次递归需要重新计算
        int mid=(start+end)/2;

        //递归左边
        mergeSort(array,start,mid,tmpArr);
        //递归右边
        mergeSort(array,mid+1,end,tmpArr);

        merge(array,start,mid,end,tmpArr);
    }

    private static void merge(int[] array,int start,int mid,int end,int[] tmpArr) {
        //放置合并好的数组---递归中创建，清楚数组花费巨大时间
        //int[] tmpArr=new int[array.length];

        //归并区间的起始下标
        int tmpIndex=start;

        int i=start;

        int s2=mid+1;

        //当有两个归并段的时候，将两个有序表合并为一个
        while(start<=mid && s2<=end){
            //前一段的对应数字小
            if(array[start]<array[s2]){
                tmpArr[tmpIndex++]=array[start++];
            }else{
                tmpArr[tmpIndex++]=array[s2++];
            }
        }

        //第一个归并段还有数据
        while(start<=mid){
            tmpArr[tmpIndex++]=array[start++];
        }

        //第二个归并段还有数据
        while(s2<=end){
            tmpArr[tmpIndex++]=array[s2++];
        }

        //此时合并好的排序数组在tmpArr数组中，需要将其拷贝到array中,i保存原来的start数值
        while(i<=end){
            array[i]=tmpArr[i];
            i++;
        }

    }


    public static void main(String[] args) {
        int[] array = new int[10000];
        int[] tmpArr = new int[10000];

        //int[] array=new int[]{9,8,7,6,5,4,3,2,1};
        Random random=new Random();
        for(int i=0;i<array.length;i++){
            array[i]=random.nextInt(10000)+1;
        }
        //System.out.println(System.currentTimeMillis());
        //mergeSort(array,0,array.length-1,tmpArr);
        //System.out.println(System.currentTimeMillis());

        selectSort(array);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }
}
