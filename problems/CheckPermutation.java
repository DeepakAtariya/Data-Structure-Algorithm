public class CheckPermutation {
    public static boolean solution(String s1, String s2) {

        s1 = s1.trim();
        s2 = s2.trim();

        if(s1.length()!=s2.length()) return false;
        // Array variable for storing character occurrence
        int occurrence[] = new int[128];

        // hash table for s1
        for (int i = 0; i < s1.length(); i++) {
            int index = (int)s1.charAt(i);
            occurrence[index]++;
        }
        
        for (int i = 0; i < s2.length(); i++) {
            
            int index = (int)s2.charAt(i);
            occurrence[index]--;

            if(occurrence[index] == -1){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(CheckPermutation.solution("ab", "   ab          "));
    }
}
