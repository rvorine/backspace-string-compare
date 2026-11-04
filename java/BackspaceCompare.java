public class BackspaceCompare {

    // walk left from i, skipping chars erased by '#', and return the next kept index (or -1)
    static int nextValidIndex(String s, int i) {
        int skip = 0;
        while (i >= 0) {
            if (s.charAt(i) == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                break;
            }
            i--;
        }
        return i;
    }

    static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;

        while (true) {
            i = nextValidIndex(s, i);
            j = nextValidIndex(t, j);

            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0 || s.charAt(i) != t.charAt(j)) return false;
            i--;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##", "c#d#")); // true
        System.out.println(backspaceCompare("a#c", "b"));     // false
    }
}
