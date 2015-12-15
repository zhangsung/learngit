package com.nssoft;

import java.util.Date;
import java.util.Random;




public class StraightInsertionSort {

	public static void main(String[] args) {
		int[] number = new int[100000000];
		Random random = new Random(54216546);
		for(int i = 0; i < 100000000; i++){
			number[i] = random.nextInt();
		}
		System.out.println("生成完成!");
		System.out.println(new Date());
		quickSort(number,0,99999999);
		System.out.println(new Date());
		System.out.println("排序完成!");
		System.out.println(number[0]);
		System.out.println(number[99999999]);

	}
	
	//直接插入排序
	public static void insertSort(int[] unsorted){
		for(int i = 1;i < unsorted.length; i++) {
			if(unsorted[i-1] > unsorted[i]) {
				int temp = unsorted[i];
				int j = i;
				while(j > 0 && unsorted[j - 1] > temp) {
					unsorted[j] = unsorted[j-1];
					j--;
				}
				unsorted[j] = temp;
			}
		}
	}
	
	//希尔排序
	public static void shellSort(int[] unsorted){
		int n = unsorted.length;
	    int dk = n/2;  
	    while( dk >= 1  ){  
	    	for(int i= dk; i<n; i++){  
	            if(unsorted[i] < unsorted[i-dk]){          //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入  
	                int j = i-dk;     
	                int x = unsorted[i];           //复制为哨兵，即存储待排序元素  
	                unsorted[i] = unsorted[i-dk];         //首先后移一个元素  
	                while(j >= 0 && x < unsorted[j]){     //查找在有序表的插入位置  
	                	unsorted[j+dk] = unsorted[j];  
	                    j -= dk;             //元素后移  
	                }  
	                unsorted[j+dk] = x;            //插入到正确位置  
	            }  
	        } 
	        dk = dk/2;  
	    }
	}
	
	//选择排序
	public static void selectSort(int[] unsorted){
		
    	for(int i= 0; i < unsorted.length; i++){ 
    		int min = i;
    		for(int j = i ;j < unsorted.length; j++) {
    			if(unsorted[min] > unsorted[j]) {
    				min = j;
    			}
    		}
    		int temp = unsorted[min];
    		unsorted[min] = unsorted[i];
    		unsorted[i] = temp;
        } 
	}
	
	//堆排序
	public static void heapSort(int[] unsorted){
		bulidHeap(unsorted);
		for(int i= unsorted.length-1; i > 0; i--){
			int temp = unsorted[i];
			unsorted[i] = unsorted[0];
			unsorted[0] = temp;
			heapAdjust(unsorted, 0, i);
		}
	}
	public static void bulidHeap(int[] unsorted){
		for(int i= (unsorted.length-1)/2; i >= 0; i--){
			heapAdjust(unsorted, i, unsorted.length);
		}
	}
	public static void heapAdjust(int[] unsorted,int j,int length){
		int child = j*2+1;
		int temp = unsorted[j];
		while(child < length){
			if(child+1 < length && unsorted[child] < unsorted[child +1])
    			child++;
    		if(unsorted[child] > unsorted[j]) {
    			unsorted[j] = unsorted[child];
        		j = child;
        		child = 2*j +1;
    		}else{
    			break;
    		}
    		unsorted[j]= temp;
		}
	}
	
	//快速排序
	public static void quickSort(int[] unsorted, int low, int high){
		if(low < high){  
	        int privotLoc = partition(unsorted,  low,  high);  //将表一分为二  
	        quickSort(unsorted,  low,  privotLoc -1);          //递归对低子表递归排序  
	        quickSort(unsorted,   privotLoc + 1, high);        //递归对高子表递归排序  
	    }  
	}
	public static int partition(int unsorted[], int low, int high)  
	{  
	    int privotKey = unsorted[low];                             //基准元素  
	    while(low < high){                                   //从表的两端交替地向中间扫描  
	        while(low < high  && unsorted[high] >= privotKey) --high;  //从high 所指位置向前搜索，至多到low+1 位置。将比基准元素小的交换到低端  
	        int temp  = unsorted[low];
	        unsorted[low] = unsorted[high];
	        unsorted[high] = temp;
	        while(low < high  && unsorted[low] <= privotKey ) ++low;  
	        temp  = unsorted[low];
	        unsorted[low] = unsorted[high];
	        unsorted[high] = temp; 
	    }  
	    return low;  
	} 
	//冒泡排序改进算法1
	public static void Bubble_1 ( int r[], int n) {  
	    int i= n -1;  //初始时,最后位置保持不变  
	    while ( i> 0) {   
	        int pos= 0; //每趟开始时,无记录交换  
	        for (int j= 0; j< i; j++)  
	            if (r[j]> r[j+1]) {  
	                pos= j; //记录交换的位置   
	                int tmp = r[j]; r[j]=r[j+1];r[j+1]=tmp;  
	            }   
	        i= pos; //为下一趟排序作准备  
	     }   
	} 
	
	//冒泡排序改进算法2
	public static void Bubble_2 ( int r[], int n) {  
	    int high = n - 1;  
	    int low = 0;
	    int tmp, j;
	    while ( low < high) {   
	    	for (j= low; j< high; ++j) //正向冒泡,找到最大者  
	            if (r[j]> r[j+1]) {  
	                tmp = r[j]; r[j]=r[j+1];r[j+1]=tmp;  
	            }   
	        --high;                 //修改high值, 前移一位  
	        for ( j=high; j>low; --j) //反向冒泡,找到最小者  
	            if (r[j]<r[j-1]) {  
	                tmp = r[j]; r[j]=r[j-1];r[j-1]=tmp;  
	            }  
	        ++low;                  //修改low值,后移一位 
	     }   
	}
	
}
