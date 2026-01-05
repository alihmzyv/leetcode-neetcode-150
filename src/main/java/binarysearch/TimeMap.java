package binarysearch;

import java.util.*;

/*
set() - time - O(1)
get() - time - O(logn)
space - O(m * n)
 */
public class TimeMap {
    private final Map<String, List<TimeVal>> data;

    static class TimeVal implements Comparable<TimeVal> {
        int timestamp;
        String value;

        public TimeVal(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        @Override
        public int compareTo(TimeVal o) {
            return timestamp - o.timestamp;
        }
    }

    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<TimeVal> vals = data.computeIfAbsent(key, k -> new ArrayList<>());
        vals.add(new TimeVal(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<TimeVal> vals = data.get(key);
        String val = "";
        if (vals != null) {
            int index = Collections.binarySearch(vals, new TimeVal(timestamp, key));
            if (index >= 0) {
                val = vals.get(index).value;
            } else if (index == -1) {
                val = "";
            } else {
                val = vals.get(Math.abs(index + 2)).value;
            }
        }
        return val;
    }
}
