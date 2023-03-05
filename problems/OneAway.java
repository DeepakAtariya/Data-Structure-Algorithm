public class OneAway {

    static boolean unMatchedLenCase(String s1, String s2, int len) {

        int s1p = 0;
        int s2p = 0;
        int cc = 0;

        for (int i = 0; i < len; i++) {
            if (s2.charAt(s1p) != s1.charAt(s2p)) {
                cc++;
                s2p++;
            } else {
                s1p++;
                s2p++;
            }

            if (cc > 1) {
                return false;
            }
        }
        return true;
    }

    static boolean matchedLenCase(String s1, String s2, int s1len) {

        int changeCount = 0;
        for (int i = 0; i < s1len; i++) {

            if (s1.charAt(i) != s2.charAt(i)) {
                changeCount++;
            }

            if (changeCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean solution(String s1, String s2) {
        int s1len = s1.length();
        int s2len = s2.length();
        int diff = s1len - s2len;

        if (Math.abs(diff) == 1) {
            return unMatchedLenCase(s1, s2, s1len < s2len ? s1len : s2len);
        }

        if (diff == 0) {
            return matchedLenCase(s1, s2, s1len);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(OneAway.solution("ple", "pale"));
        System.out.println(OneAway.solution("pales", "pale"));
        System.out.println(OneAway.solution("pale", "bale"));
        System.out.println(OneAway.solution("pale", "bake"));
    }
}
