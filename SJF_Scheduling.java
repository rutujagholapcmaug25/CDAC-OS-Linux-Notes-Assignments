import java.util.*;

class SJF_Scheduling{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter number of processes: ");
		int n  = in.nextInt();

		int[] pid = new int[n];      // process id
		int[] bt = new int[n];       // burst time
		int[] wt = new int[n];		 // waiting time
		int[] tat = new int[n];		 // turnaround time
		
		for(int i=0; i < n; i++){
			pid[i] = i +1;
			System.out.println("Enter the burst time for process" + pid[i] + ": ");
			bt[i] = in.nextInt();
		}
		
		// bt : sorting for shortest job
		for(int i = 0; i < n-1 ; i++){
			for(int j = i+1; j<n; j++){
				if(bt[i]>bt[j]){
					int temp = bt[i];
					bt[i] = bt[j];
					bt[j] = temp;
					
					int t = pid[i];
					pid[i] = pid[j];
					pid[j] = temp;
				}
			}
		}
		
		// calculate waiting time
		wt[0] = 0;  // first process waiting time 
		for(int i =1 ; i < n; i++){
			wt[i] = wt[i-1] + bt[i-1];
		}
		
		// calculate TAT
		double totalWT = 0, totalTAT = 0;
		for(int i = 0 ; i < n; i++){
			tat[i] = wt[i] + bt[i];
			totalWT += wt[i];
			totalTAT += tat[i];
		}
		
		// Output
        System.out.println("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + pid[i] + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }

        System.out.printf("\nAverage Waiting Time = %.2f", totalWT / n);
        System.out.printf("\nAverage Turnaround Time = %.2f\n", totalTAT / n);
	}
}

/*
output:

Enter number of processes:
4
Enter the burst time for process1:
6
Enter the burst time for process2:
8
Enter the burst time for process3:
7
Enter the burst time for process4:
3

Process     Burst Time      Waiting Time    Turnaround Time
P4              3               0               3
P6              6               3               9
P7              7               9               16
P8              8               16              24

Average Waiting Time = 7.00
Average Turnaround Time = 13.00

*/