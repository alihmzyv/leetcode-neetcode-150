import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> formatToStrs = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> letterToFrequency = new HashMap<>();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char ch = str.charAt(i);
                Integer currentFrequency = letterToFrequency.getOrDefault(ch, 0);
                letterToFrequency.put(ch, currentFrequency + 1);
            }
            List<String> anagrams = formatToStrs.get(letterToFrequency);
            if (anagrams == null) {
                List<String> newAnagrams = new LinkedList<>();
                newAnagrams.add(str);
                formatToStrs.put(letterToFrequency, newAnagrams);
            } else {
                anagrams.add(str);
            }
        }

        return formatToStrs.values().stream()
                .toList();
    }

    public List<List<String>> groupAnagramsV2(String[] strs) {
        Map<String, List<String>> countOfLettersToStrs = new HashMap<>();

        for (String str : strs) {
            int[] countOfLetters = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char ch = str.charAt(i);
                countOfLetters[ch - 'a']++;
            }
            String countOfLettersStr = Arrays.toString(countOfLetters);
            List<String> anagrams = countOfLettersToStrs.get(countOfLettersStr);
            if (anagrams == null) {
                List<String> newAnagrams = new LinkedList<>();
                newAnagrams.add(str);
                countOfLettersToStrs.put(countOfLettersStr, newAnagrams);
            } else {
                anagrams.add(str);
            }
        }

        return countOfLettersToStrs.values().stream()
                .toList();
    }
}
