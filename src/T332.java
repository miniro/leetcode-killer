import java.util.*;

public class T332 {
    class Solution {
        List<String> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        public List<String> findItinerary(List<List<String>> tickets) {
            for(List<String> ticket : tickets) {
                if(!map.containsKey(ticket.get(0))) {
                    List<String> list = new ArrayList<>();
                    list.add(ticket.get(1));
                    map.put(ticket.get(0), list);
                } else {
                    List<String> list = map.get(ticket.get(0));
                    list.add(ticket.get(1));
                }
            }
            for(String key : map.keySet()) {
                Collections.sort(map.get(key));
            }
            dfs("JFK");
            return result;
        }

        public void dfs(String place) {
            result.add(place);
            if(map.containsKey(place)) {
                for(String nextPlace : map.get(place)) {
                    if(!result.contains(nextPlace)) {
                        dfs(nextPlace);
                        result.remove(result.size() - 1);
                    }
                }
            }
        }
    }
}
