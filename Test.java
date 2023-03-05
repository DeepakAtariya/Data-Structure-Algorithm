import java.util.Arrays;

class Solution {
    
    public int passThePillow(int n, int time) {

        int direction = 1;
        int passes = (n - 1);

        if (time > passes) {
            int splits[] = this.findDirectionAndPass(passes, time);
            direction = splits[0];
            time = splits[1];
        }
        
        return iterate(direction, n, time);
    }

    public int iterate(int direction, int n, int time) {

        if (direction == 1) {
            // forward direction
            return time + 1;
        } else {
            // backward direction
            return n - time;
        }
    }

    public int[] findDirectionAndPass(int passes, int time) {
        
        int index = 1;
        while (time > 0) {
            time = time - passes;
            index++;
        }
        
        return new int[]{
            index % 2 != 0 ? 1 : 0,
            time
        };
    }
}