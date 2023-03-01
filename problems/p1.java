import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strins, group the anagras together. you can return the answer in any order.
 */
public class p1 {

    /**
     * 
     * @param input
     * @author Deepak Atariya
     */
    public static int[] weights(String[] input) {

        int weights[] = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int weight = 0;
            for (int j = 0; j < input[i].length(); j++) {
                // taking each charater ascii value to summing them
                weight = weight + (int) input[i].charAt(j);
            }
            // storing each sum
            weights[i] = weight;
        }

        return weights;
    }

    /**
     * 
     * @param input
     * @author Deepak Atariya
     */
    public static void solution(String[] input) {
        // get weights of each string for further comparations and grouping them
        int weights[] = p1.weights(input);

        // parent array that will contain grouped arrays;
        ArrayList<List<String>> ans = new ArrayList<List<String>>();
        for (int i = 0; i < weights.length; i++) {
            // inner array to collect same weight values
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(input[i]);
            if (weights[i] != 0) {
                for (int j = i + 1; j < weights.length; j++) {
                    // comparing weights and storing actual value index is same
                    if (weights[i] == weights[j]) {
                        temp.add(input[j]);
                        weights[j] = 0;
                    }
                }
                ans.add(temp);
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        String input[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        p1.solution(input);
    }
}
