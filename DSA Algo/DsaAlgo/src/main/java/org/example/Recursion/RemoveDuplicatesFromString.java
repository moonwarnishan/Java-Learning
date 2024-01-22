package org.example.Recursion;

public class RemoveDuplicatesFromString {

    public static void RemoveDuplicate(String str, int index, StringBuilder newString, boolean[] map) {
        if (index == str.length()) {
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(index);
        if (map[currChar - 'a']) {
            RemoveDuplicate(str, index + 1, newString, map);
        } else {
            map[currChar - 'a'] = true;
            RemoveDuplicate(str, index + 1, newString.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        RemoveDuplicate("Hello", 0, new StringBuilder(""), new boolean[26]);
    }
}
