/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
/**
 *
 * @author steven
 */
public class Exer30_15 {
    public static void main(String[] args){
        
        final int MAX = 9000000;
        int[] list = new int[MAX];
        for(int i = 0; i < MAX; i++){
            list[i] =(int)( Math.random() *2);
        }
        
        RecursiveTask<Long> task = new Sum(list, 0, MAX);
        ForkJoinPool pool = new ForkJoinPool();
        System.out.print(pool.invoke(task));
        
    }
}

class Sum extends RecursiveTask<Long> {
    static final int SEQUENTIAL_THRESHOLD = 500;

    int low;
    int high;
    int[] array;

    Sum(int[] arr, int lo, int hi) {
        array = arr;
        low   = lo;
        high  = hi;
    }

    protected Long compute() {
        if(high - low <= SEQUENTIAL_THRESHOLD) {
            long sum = 0;
            for(int i=low; i < high; ++i) 
                sum += array[i];
            return sum;
         } else {
            int mid = low + (high - low) / 2;
            Sum left  = new Sum(array, low, mid);
            Sum right = new Sum(array, mid, high);
            left.fork();
            long rightAns = right.compute();
            long leftAns  = left.join();
            return leftAns + rightAns;
         }
     }


}