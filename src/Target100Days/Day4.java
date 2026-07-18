package Target100Days;
import java.util.*;

public class Day4 {
    //shop with candy store
    public static List<Integer> minMax(int[] prices,int k){
        int N=prices.length;
        Arrays.sort(prices);
        int maxCost=0;
        int minCost=0;
        int i=0;
        int j=N-1;
        while(i <= j){
            minCost += prices[i];
            i++;
            j-=k;
        }
        i=N-1;
        j=0;
        while(i >= j){
            maxCost += prices[i];
            i--;
            j+=k;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(minCost);
        ans.add(maxCost);
        return ans;
    }

    //assign mice to holes
    public static int assign(int[] mices,int[] holes){
        int n=mices.length;
        Arrays.sort(mices);
        Arrays.sort(holes);
        int maxTime=0;
        for(int i=0;i<n;i++){
            maxTime=Math.max(maxTime,Math.abs(mices[i]-holes[i]));
        }
        return maxTime;
    }

    //N meetings in one room
    static class Meeting{
        int start, end;

        Meeting(int s, int e){
            this.start = s;
            this.end = e;
        }
    }
    public static int meeting(int[] start ,int[] end){
        int n=start.length;
        Meeting[] meetings = new Meeting[n];
        for(int i=0;i<n;i++){
            meetings[i]=new Meeting(start[i],end[i]);
        }
        Arrays.sort(meetings,(a,b)-> a.end-b.end);
        int count=1;
        int lastEnd = meetings[0].end;
        for(int i=1;i<n;i++){
            if(meetings[i].start > lastEnd){
                count++;
                lastEnd=meetings[i].end;
            }
        }
        return count;
    }

    //fractional knapsack
    static class Item {
        int value;
        int weight;
        Item(int v, int w) {
            value = v;
            weight = w;
        }
    }
    static double fractionalKnapsack(int val[],int weight[],int n,int capacity) {
        Item[] arr = new Item[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Item(val[i], weight[i]);
        }
        Arrays.sort(arr, (a, b) ->
                Double.compare(
                        (double)b.value / b.weight,
                        (double)a.value / a.weight
                ));
        double totalValue = 0.0;
        int W = capacity;
        for (int i = 0; i < n; i++) {
            if (arr[i].weight <= W) {
                totalValue += arr[i].value;
                W -= arr[i].weight;
            }
            else {
                totalValue +=((double)arr[i].value / arr[i].weight) * W;
                break;
            }
        }
        return totalValue;
    }

    //max platform
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int n=arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platform=1;
        int maxPlatform=1;
        int i=1;
        int j=0;
        while(i< n && j<n){
            if(arr[i] <= dep[j]){
                platform++;
                i++;
            }else{
                platform--;
                j++;
            }
            maxPlatform=Math.max(maxPlatform,platform);
        }
        return maxPlatform;
    }

    //job scheduling
    
    public static void main(String[] args) {
        int[] prices={3, 2, 1, 4};
        int k=2;
        int mices[] = {4, -4, 2};
        int holes[] = {4, 0, 5};
        System.out.println(minMax(prices,k));
        System.out.println(assign(mices,holes));
    }
}

