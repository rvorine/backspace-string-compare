using System;

class BackspaceCompare
{
    // walk left from i, skipping chars erased by '#', and return the next kept index (or -1)
    static int NextValidIndex(string s, int i)
    {
        int skip = 0;
        while (i >= 0)
        {
            if (s[i] == '#') skip++;
            else if (skip > 0) skip--;
            else break;
            i--;
        }
        return i;
    }

    static bool Compare(string s, string t)
    {
        int i = s.Length - 1, j = t.Length - 1;

        while (true)
        {
            i = NextValidIndex(s, i);
            j = NextValidIndex(t, j);

            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0 || s[i] != t[j]) return false;
            i--;
            j--;
        }
    }

    static void Main()
    {
        Console.WriteLine(Compare("ab#c", "ad#c")); // True
        Console.WriteLine(Compare("ab##", "c#d#")); // True
        Console.WriteLine(Compare("a#c", "b"));     // False
    }
}
