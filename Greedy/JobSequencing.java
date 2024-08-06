import java.util.*;

public class JobSequencing {
    public static class Job{
        int id;
        int deadline;
        int profit;

        public Job(int i, int d, int p){
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }

    public static int getMaxDeadline(ArrayList<Job> jobs){
        int max = 0;
        for(int i = 0; i < jobs.size(); i++){
            if(max < jobs.get(i).deadline)
                max = jobs.get(i).deadline;
        }

        return max;
    }

    public static int scheduldeJob(ArrayList<Job> jobs){
        int maxDeadline = getMaxDeadline(jobs);
        System.out.println(maxDeadline);
        int days[] = new int[maxDeadline+1];
        Arrays.fill(days, -1);
        Collections.sort(jobs, (a,b) -> b.profit - a.profit); //sorting based on descending profits
        int maxProfit = 0;
        // int time  = 0;
        int daysUsed = 0;
        for(int i = 0; i < jobs.size(); i++){
            if(daysUsed == maxDeadline)
                return maxProfit;
            
            int j = jobs.get(i).deadline;
            while(j > 0){
                if(days[j] == -1){
                    days[j] = 1;
                    maxProfit += jobs.get(i).profit;
                    daysUsed++;
                    break;
                }
                j--;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        ArrayList<Job> jobs = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            jobs.add(new Job(i, (int)Math.ceil((Math.random()*10)%5), (int)Math.floor(Math.random()*100)));
        }
        for(int i = 0; i < 5; i++){
            System.out.println("Job "+jobs.get(i).id+": deadline: "+jobs.get(i).deadline+" profit: "+jobs.get(i).profit);
        }

        System.out.println("Max Profit: "+ scheduldeJob(jobs));
    }
}
