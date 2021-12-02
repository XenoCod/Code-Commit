package Arrays;

public class FindMissingObservations {
    public static void main(String[] args) {
        int currSum =0;
        for(int i: rolls) currSum += i;
        int missingSum = (rolls.length + n) * mean - currSum;

        if(missingSum < n || missingSum > 6 * n) return new int[0];

        int res[]= new int[n];
        int part= missingSum / n, rem= missingSum % n;
        Arrays.fill(res, part);
        for(int i=0; i< rem; i++)
            res[i]++;
        return res;
    }
}
