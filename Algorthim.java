/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorthim;
import java.util.Arrays;

/**
 *
 * @author sony
 */
public class Algorthim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //2D array jobs to store the input jobs in the format (id, Deadline, Profit).
     int[][] jobs = {{1, 4, 20}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}};
        //call the getmax method with the input jobs
        int[] result = getmax(jobs);
        //print reault
        System.out.println("Number of jobs done: " + result[0]);
        System.out.println("Maximum profit: " + result[1]);
    }
     public static int[] getmax(int[][] jobs) {
        //first sort the jobs in decreasing order of their profits 
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);
        //max profit
        int max = 0;
        //job done
        int numjob = 0;
        //inital array 
        boolean[] time = new boolean[jobs.length];

        for (int i = 0; i < jobs.length; i++) {
            //for each job deadline 
            int deadline = jobs[i][1];
            // allocate the job to the latest possible time slot before its deadline
            for (int j = Math.min(deadline, jobs.length) - 1; j >= 0; j--) {
                //If the time slot is available
                if (!time[j]) {
                    time[j] = true;
                    max += jobs[i][2];
                    numjob++;
                    break;
                }
            }
        }

        int[] result = {numjob, max};
        return result;
    }
}
//output
//Number of jobs done: 2
//Maximum profit: 60
//BUILD SUCCESSFUL (total time: 0 seconds)



    

