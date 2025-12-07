package arraysandhashing;

import java.util.LinkedList;
import java.util.List;

public class EncodeAndDecodeStrings {
    private static final char DELIMITER = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        strs.forEach(str -> {
            sb.append(str.length())
                    .append(DELIMITER)
                    .append(str);
        });

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new LinkedList<>();
        int endOfPrevious = -1;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == DELIMITER) {
                int lengthOfStr = Integer.parseInt(str.substring(endOfPrevious + 1, i));
                result.add(str.substring(i + 1, i + 1 + lengthOfStr));
                endOfPrevious = i + lengthOfStr;
                i += (1 + lengthOfStr);
            }
        }
        return result;
    }
}
