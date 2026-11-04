[![Instagram](https://img.shields.io/badge/Instagram-lacopydepastel-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://instagram.com/lacopydepastel)
[![YouTube](https://img.shields.io/badge/YouTube-%40rvorine-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://youtube.com/@rvorine)

# Backspace String Compare (LeetCode 844)

## Problem

Given two strings `s` and `t`, where `#` means a **backspace**, return `true` if they are equal once both are typed into empty text editors. Backspacing on empty text does nothing.

Example:

```
Input:  s = "ab#c",  t = "ad#c"     Output: true    // both become "ac"
Input:  s = "ab##",  t = "c#d#"     Output: true    // both become ""
Input:  s = "a#c",   t = "b"        Output: false   // "c" vs "b"
```

## Solution

**Two pointers from the end** — compare without building the final strings.

A `#` only affects characters **before** it, so scanning right to left lets each `#` be handled as it is met.

- Start one pointer at the end of each string.
- Move a pointer left with a `skip` counter: a `#` adds one to `skip`; a normal character is erased if `skip > 0`, otherwise it is the next real character.
- Stop both pointers on their next real character and compare them. A mismatch means `false`.
- If both pointers run out together, the strings are equal. If only one runs out, they are not.

The stack approach is simpler (build both results and compare) but uses O(n) space. The pointer version needs none.

**Time:** O(n + m) — each string is walked once.
**Space:** O(1) — no extra strings.

## Implementations

| Language | File |
|---|---|
| Python | [`python/backspace_compare.py`](python/backspace_compare.py) |
| Java | [`java/BackspaceCompare.java`](java/BackspaceCompare.java) |
| Kotlin | [`kotlin/BackspaceCompare.kt`](kotlin/BackspaceCompare.kt) |
| JavaScript | [`javascript/backspaceCompare.js`](javascript/backspaceCompare.js) |
| C# | [`csharp/BackspaceCompare.cs`](csharp/BackspaceCompare.cs) |
