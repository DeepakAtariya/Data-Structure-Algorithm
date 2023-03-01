
/**
 * Given an array of strins, group the anagras together. you can return the
 * answer in any order.
 */
public class P2 {

    /**
     * 
     * @param input
     * @author Deepak Atariya
     */
    public static void solution(int jar, int nog) {
        // test 1
        // jar = 6
        // nog = 4
        // output : 4, 2

        // test 2
        // jar = 4
        // nog = 4
        // output : 4

        // test 3
        // jar = 4
        // nog = 50
        // output : 4

        int remaining = jar;
        String output = "";
        for (int i = 1; i <= Double.POSITIVE_INFINITY; i++) {
            if (remaining >= nog) {
                remaining = remaining - nog;
                output = output + nog + ' ';
            }

            if (remaining == 0) {
                break;
            } else if (nog <= 0) {
                output = "-1";
                break;
            }
            nog--;
        }
        System.out.print(output);
    }

    public static void main(String[] args) {
        P2.solution(6, 4);
    }
}
