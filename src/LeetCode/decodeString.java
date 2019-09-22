package LeetCode;

public class decodeString {
    public static char[] sArray;

    public static String decodeString(String s) {

        sArray = s.toCharArray();
        return decodeString(1, 0, s.length());

    }
    private static String decodeString(int r, int s, int f) {
        StringBuilder sb = new StringBuilder();
        char c;
        while (s < f) {
            c = sArray[s];
            if (Character.isLetter(c)) {
                sb.append(c);
                s++;
            } else {
                int rep = Character.getNumericValue(c);
                //  get substring
                int b = 0, t = s;
                do {
                    t++;
                    if (sArray[t] == '[') {
                        b++;
                    } else if (sArray[t] == ']') {
                        b--;
                    }
                } while (b != 0);
                sb.append(decodeString(rep, s+2, t));
                s = t+1;
            }
        }
        for (int i = 1; i < r; i++) {
            sb.append(sb);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        int num = Integer.parseInt(sb.toString());
        System.out.println(num);
    }
}
