# Checking Whether a String Has All Unique Characters in Java

## Problem

Given:

```java
String[] words = {"abcde", "hello", "apple", "kite", "padle"};
```

Check whether each string contains only unique characters.

Constraint:

- Do not use Java Collection APIs.

Expected result:

```text
abcde -> true
hello -> false
apple -> false
kite -> true
padle -> true
```

---

## 1. Boolean Array Approach

The simplest approach without using collections is to use a boolean array as a lookup table.

```java
public class UniqueCharacters {

    public static boolean hasUniqueCharacters(String word) {

        boolean[] characters = new boolean[256];

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (characters[ch]) {
                return false;
            }

            characters[ch] = true;
        }

        return true;
    }

    public static void main(String[] args) {

        String[] words = {"abcde", "hello", "apple", "kite", "padle"};

        for (String word : words) {
            System.out.println(
                word + " -> " + hasUniqueCharacters(word)
            );
        }
    }
}
```

Output:

```text
abcde -> true
hello -> false
apple -> false
kite -> true
padle -> true
```

---

# 2. What Does `boolean[256]` Mean?

When we write:

```java
boolean[] characters = new boolean[256];
```

Java creates an array containing 256 boolean positions.

The valid indexes are:

```text
0 → 255
```

Initially, every position is `false`:

```text
Index:  0    1    2    3    ...    97    ...    255
        ↓    ↓    ↓    ↓           ↓            ↓
Value: false false false false ... false ... false
```

We use each position to remember whether a particular character has already appeared.

Think of it like 256 switches:

```text
Switch 0
Switch 1
Switch 2
...
Switch 97
...
Switch 255
```

Initially all switches are OFF.

When we see a character, we turn ON the switch corresponding to that character.

---

# 3. Why 256?

For the basic problem, we commonly assume ASCII characters.

Basic ASCII uses values:

```text
0 → 127
```

Using:

```java
boolean[256]
```

provides room for the full 8-bit character range:

```text
0 → 255
```

Therefore, under an ASCII/8-bit assumption, each character can be mapped to one array position.

Strictly speaking, Java `char` is not limited to 0–255. Java `char` is a UTF-16 code unit and can have values from:

```text
0 → 65,535
```

So `boolean[256]` should be used when the input is known to be within the assumed 256-character range.

---

# 4. Why Do We Use the Numeric Value of a Character?

This is the central idea.

An array is accessed using a numeric index:

```java
characters[0]
characters[1]
characters[2]
...
```

Characters have numeric values.

For example:

```text
'a' → 97
'b' → 98
'c' → 99
'h' → 104
'l' → 108
```

Therefore:

```java
characters['a']
```

effectively refers to:

```java
characters[97]
```

And:

```java
characters['h']
```

effectively refers to:

```java
characters[104]
```

Java allows a `char` to be used directly as an array index because `char` has an integer-like numeric value.

---

# 5. Why Not Use the Character Directly?

There is an important distinction.

We can write:

```java
char ch = 'a';

characters[ch] = true;
```

This is valid Java.

We don't need to manually write:

```java
characters[(int) ch] = true;
```

Java automatically uses the numeric value of `ch` when it is used as an array index.

So:

```java
char ch = 'a';

characters[ch]
```

is effectively:

```java
characters[97]
```

The array itself still has numeric indexes. It does not have character-named positions.

Conceptually:

```text
Character
   ↓
'a'
   ↓
numeric value 97
   ↓
array index 97
   ↓
characters[97]
```

---

# 6. Example with `"abcde"`

Initially:

```text
characters[97]  = false
characters[98]  = false
characters[99]  = false
characters[100] = false
characters[101] = false
```

### First character: `'a'`

```java
char ch = 'a';
```

`'a'` has numeric value `97`.

Therefore:

```java
characters[ch]
```

means:

```java
characters[97]
```

It is currently:

```text
false
```

So there is no duplicate.

Then:

```java
characters[ch] = true;
```

means:

```java
characters[97] = true;
```

We have now recorded:

```text
'a' has appeared
```

### Next character: `'b'`

`'b'` has numeric value `98`.

```text
characters[98] = false
```

So mark it:

```text
characters[98] = true
```

### Next: `'c'`

```text
'c' → 99 → characters[99]
```

Mark:

```text
characters[99] = true
```

And so on.

At the end:

```text
'a' → 97  → true
'b' → 98  → true
'c' → 99  → true
'd' → 100 → true
'e' → 101 → true
```

No character was already marked `true`, so the string contains unique characters.

---

# 7. Example with `"hello"`

Let's see how the duplicate is detected.

### `'h'`

```text
'h' → 104

characters[104] = false
```

Mark it:

```text
characters[104] = true
```

### `'e'`

```text
'e' → 101

characters[101] = false
```

Mark:

```text
characters[101] = true
```

### First `'l'`

```text
'l' → 108

characters[108] = false
```

Mark:

```text
characters[108] = true
```

### Second `'l'`

Again:

```text
'l' → 108
```

Check:

```java
characters[108]
```

It is already:

```text
true
```

Therefore:

```java
if (characters[ch]) {
    return false;
}
```

returns `false`.

We have found a duplicate.

---

# 8. Think of It as 256 Switches

A very useful mental model is to imagine 256 switches.

Initially:

```text
OFF OFF OFF OFF OFF ... OFF
```

When we encounter `'a'`:

```text
'a' → 97
```

Turn switch 97 ON:

```text
Switch 97 → ON
```

When we encounter `'b'`:

```text
'b' → 98
```

Turn switch 98 ON:

```text
Switch 98 → ON
```

When we encounter `'a'` again:

```text
'a' → 97
```

Switch 97 is already ON.

Therefore:

> `'a'` has appeared before → duplicate.

This is exactly what the boolean array is doing.

---

# 9. Why Not Just Compare Characters Directly?

We can solve the problem without using the numeric mapping by comparing every character with every other character.

```java
public static boolean hasUniqueCharacters(String word) {

    for (int i = 0; i < word.length(); i++) {

        for (int j = i + 1; j < word.length(); j++) {

            if (word.charAt(i) == word.charAt(j)) {
                return false;
            }
        }
    }

    return true;
}
```

Here we directly compare:

```java
word.charAt(i) == word.charAt(j)
```

For `"apple"`:

```text
a == p ? No
a == p ? No
a == l ? No
a == e ? No

p == p ? YES
```

So we return `false`.

---

# 10. Boolean Array vs Nested Loops

| Approach | Technique | Time | Extra Space |
|---|---|---:|---:|
| Boolean array | Character → array index | O(n) | O(1) |
| Nested loops | Compare characters | O(n²) | O(1) |

The boolean-array approach is generally preferred because it is faster.

---

# 11. Important Java `char` Detail

Java `char` is actually a UTF-16 code unit.

Its range is:

```text
0 → 65,535
```

It is therefore not technically correct to say:

> "Every Java character has an ASCII value."

A better statement is:

> "For ASCII input, the character's numeric value can be used as an array index."

For example:

```java
char ch = 'A';

System.out.println((int) ch);
```

Output:

```text
65
```

Therefore:

```java
characters[ch]
```

can access:

```java
characters[65]
```

---

# 12. If the Input Is Only Lowercase `a-z`

If the interviewer specifically says:

> "The string contains only lowercase English letters."

Then we don't need 256 positions.

We can use:

```java
boolean[] characters = new boolean[26];
```

Map the characters to indexes using:

```java
int index = ch - 'a';
```

For example:

```text
'a' - 'a' = 0
'b' - 'a' = 1
'c' - 'a' = 2
...
'z' - 'a' = 25
```

So:

```java
char ch = 'c';

int index = ch - 'a';
```

gives:

```text
2
```

Then:

```java
characters[2]
```

represents `'c'`.

This is even more memory-efficient.

---

# 13. Core Algorithm to Remember

The entire idea can be remembered as:

```text
Character
    ↓
Numeric value / mapped index
    ↓
Boolean array
    ↓
Have we seen it before?
    ↓
YES → duplicate → false
NO  → mark true → continue
```

The key line is:

```java
if (characters[ch]) {
    return false;
}
```

followed by:

```java
characters[ch] = true;
```

So the algorithm essentially asks:

> "Have I already seen this character?"

If yes → duplicate.

If no → remember it.

---

## Complexity

For a string of length `n`:

**Time:**

```text
O(n)
```

We scan the string once.

**Space:**

```text
O(1)
```

The boolean array has a fixed size under the chosen character-range assumption.

---

## Interview Explanation

A concise interview explanation would be:

> "I will use a boolean array as a lookup table. Since an ASCII character has a numeric value, I can use that value as the array index. Initially all positions are false. For each character, I check whether its corresponding position is already true. If it is, the character has appeared before, so the string is not unique. Otherwise, I mark that position as true. This gives O(n) time and O(1) extra space, without using the Java Collection API."
