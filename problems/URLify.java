public class URLify {
    public static String solution(String s1) {
        s1 = s1.trim();
        char chars[] = s1.toCharArray();
        int cs = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                cs++;
            }
        }

        if (cs > 0) {
            // System.out.println("Total spaces found : " + cs);
            char chars1[] = new char[chars.length + (cs * 2)];
            int j = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') {
                    chars1[j++] = '%';
                    chars1[j++] = '2';
                    chars1[j++] = '0';
                } else {
                    chars1[j++] = chars[i];
                }

            }
            return new String(chars1);

        }

        return s1;
    }

    public static void main(String[] args) {
        String input = "Mr John Smith      ";
        System.out.println(URLify.solution(input));
    }
}
