package twopointers;

public class ValidPalindrome {
    //time - O(n), space - O(1)
    public boolean isPalindrome(String s) {
        //TODO: look at neetcode solutions
        int left = 0;
        int length = s.length();
        int right = length - 1;
        while (right > left) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
