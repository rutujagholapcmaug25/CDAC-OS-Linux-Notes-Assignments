class FirstComeFS{
	public static void main(String args[]){
		int processes[] = {1,2,3};
		int burst_time[] = {3,5,2};
		
		findAvg(processes, processes.length, burst_time);
	}
	
	static void findWaitingTime(int processes[], int n, int bt[], int wt[]) {
		wt[0] = 0;  // Waiting time of first process is 0
		for (int i = 1; i < n ; i++) {
			wt[i] = wt[i - 1] + bt[i - 1]; 
		}
	}

	static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
		for (int i = 0; i < n; i++) {   // start from 0, stop at n-1
			tat[i] = wt[i] + bt[i];
    }
}

	
	static void findAvg(int processes[], int n, int bt[]){
		int wt[] = new int[n];
		int tat[] = new int[n];
		int total_wt = 0;
		int total_tal = 0;
		
		findWaitingTime(processes, n, bt, wt);
		findTurnAroundTime(processes, n, bt, wt, tat);
		
		System.out.printf("Process \t Burst Time \t Waiting Time \t Turn Around Time \n");
		
		for(int i=0; i< n ; i++){
			total_wt += wt[i];
			total_tal += tat[i];
			
			System.out.printf("%d\t\t %d\t\t %d\t\t %d\t\t \n ", (i+1), bt[i],wt[i],tat[i]);
		}
		
		float avg_wt = (float) total_wt/n ;
		float avg_tat = total_tal/n ;
		
		System.out.printf("Average Waiting Time = %.2f\n", avg_wt);
        System.out.printf("Average Turn Around Time = %.2f\n", avg_tat);
	}
}


/*
output:

Process          Burst Time      Waiting Time    Turn Around Time
 1               3               0               3
 2               5               3               8
 3               2               8               10
Average Waiting Time = 3.67
Average Turn Around Time = 7.00
*/