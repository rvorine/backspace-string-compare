def next_valid_index(s, i):
    """Walk left from i, skipping chars erased by '#', and return the next kept index (or -1)."""
    skip = 0
    while i >= 0:
        if s[i] == "#":
            skip += 1
        elif skip > 0:
            skip -= 1
        else:
            break
        i -= 1
    return i


def backspace_compare(s, t):
    i, j = len(s) - 1, len(t) - 1

    while True:
        i = next_valid_index(s, i)
        j = next_valid_index(t, j)

        if i < 0 and j < 0:
            return True
        if i < 0 or j < 0 or s[i] != t[j]:
            return False
        i -= 1
        j -= 1


if __name__ == "__main__":
    print(backspace_compare("ab#c", "ad#c"))  # True
    print(backspace_compare("ab##", "c#d#"))  # True
    print(backspace_compare("a#c", "b"))      # False
