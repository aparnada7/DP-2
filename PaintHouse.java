/*
Time: O(m*n) need to check all rows and col elements in given n*m matrix
Space: O(1) no extra space is used here
*/
class Solution {
    public int minCost(int[][] costs) {
        //Base:
        //costs is null
        if(costs == null || costs.length == 0){
            return 0;
        }
        //Logic:
        //Go bottom to top=> so tLE can be managed
        // Choose either of the two colors from last row in (row-1)th
        //and keep going until 0th  row. Return min from row 0.
        for(int i=costs.length-2; i>=0 ; i--){
            costs[i][0] = Math.min((costs[i][0]+costs[i+1][1]), (costs[i][0]+costs[i+1][2]));
            costs[i][1] = Math.min((costs[i][1]+costs[i+1][0]), (costs[i][1]+costs[i+1][2]));
            costs[i][2] = Math.min((costs[i][2]+costs[i+1][0]), (costs[i][2]+costs[i+1][1]));
        }
        
        return Math.min(costs[0][0], Math.min(costs[0][1], costs[0][2]));
    
    }
}
