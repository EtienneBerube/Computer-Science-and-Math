
import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Étienne Bérubé
 */
public class ThreadListSum {
    
    
    public static void main(String[] args){
       
       int n = 9000000;
       n = 2000;
       int[] list = new int[n];
       
       for(int i = 0 ; i< list.length; i++){
           list[i] = i;
       }
       
       
      
       
       SumTask task = new SumTask(list);
       ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(task));
    }
    private static class SumTask extends RecursiveTask<BigInteger>{
        final int THRESHOLD = 500;
        int[] list;

        public SumTask(int[] list) {
            this.list = list;
        }
        

        @Override
        protected BigInteger compute() {
         BigInteger sum = new BigInteger("0");
         
            if(list.length <= THRESHOLD){
                for( int i = 0 ; i < list.length; i++){
                   
                    sum = sum.add(new BigInteger("" + list[i]));
                    System.out.println("sum:" + sum + " & value: " + list[i]);
                }
            }else{
                int mid = (int)(list.length/2);
                int[] first = new int[list.length/2];
                System.arraycopy(list, 0, first, 0, mid);
                
                int[] second = new int[(list.length - mid)];
                System.arraycopy(list, list.length/2, second, 0, list.length - mid);
                
                SumTask left = new SumTask(first);
                SumTask right = new SumTask(second);
                
                left.fork();
                right.fork();
                
                //sum.add(new BigInteger(left.join().toString()).add(new BigInteger(right.join().toString())));
                sum = sum.add(left.join().add(right.join()));
            }
                
            
           return sum ;
        }
    
    }
}


