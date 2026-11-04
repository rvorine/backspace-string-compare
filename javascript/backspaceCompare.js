// walk left from i, skipping chars erased by '#', and return the next kept index (or -1)
function nextValidIndex(s, i) {
  let skip = 0;
  while (i >= 0) {
    if (s[i] === "#") skip++;
    else if (skip > 0) skip--;
    else break;
    i--;
  }
  return i;
}

function backspaceCompare(s, t) {
  let i = s.length - 1, j = t.length - 1;

  while (true) {
    i = nextValidIndex(s, i);
    j = nextValidIndex(t, j);

    if (i < 0 && j < 0) return true;
    if (i < 0 || j < 0 || s[i] !== t[j]) return false;
    i--;
    j--;
  }
}

console.log(backspaceCompare("ab#c", "ad#c")); // true
console.log(backspaceCompare("ab##", "c#d#")); // true
console.log(backspaceCompare("a#c", "b"));     // false

module.exports = { backspaceCompare };
