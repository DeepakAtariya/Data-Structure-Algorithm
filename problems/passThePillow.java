class Solution {    
    public int passThePillow(int n, int time) {

        int passes = (n - 1);
        int index = 1;
        if (time > passes) {
            while (time > passes) {
                time = time - passes;
                index++;
            }
        }
        
        return index % 2 != 0 ? time + 1 : n - time;
    }
}