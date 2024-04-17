package leetcode.problems.p03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 332. Reconstruct Itinerary
 *
 * @link https://leetcode.com/problems/reconstruct-itinerary/
 * @author zhanglei
 * @date 2022/4/24
 */
class P0332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(
                tickets,
                Comparator.comparing(
                        t -> ((t.get(0).equals("JFK") ? "000" : t.get(0)) + t.get(1))));
        List<String> result = new ArrayList<>();
        findItinerary(tickets, new ArrayList<>(), result);
        return result;
    }

    boolean findItinerary(
            List<List<String>> tickets, List<List<String>> temp, List<String> result) {
        if (tickets.size() == 0) {
            for (int i = 0; i < temp.size(); i++) {
                if (i == 0) {
                    result.add(temp.get(i).get(0));
                }
                result.add(temp.get(i).get(1));
            }
            return true;
        } else {
            for (int i = 0, size = tickets.size(); i < size; i++) {
                List<String> ticket = tickets.get(i);
                if (temp.size() > 0 && !temp.get(temp.size() - 1).get(1).equals(ticket.get(0))) {
                    continue;
                }
                tickets.remove(ticket);
                temp.add(ticket);
                if (findItinerary(tickets, temp, result)) {
                    return true;
                }
                tickets.add(i, temp.remove(temp.size() - 1));
            }
        }
        return false;
    }

    @Test
    void test1() {
        List<List<String>> tickets =
                new ArrayList<>(
                        Arrays.asList(
                                Arrays.asList("MUC", "LHR"),
                                Arrays.asList("JFK", "MUC"),
                                Arrays.asList("SFO", "SJC"),
                                Arrays.asList("LHR", "SFO")));
        assertEquals("[JFK, MUC, LHR, SFO, SJC]", findItinerary(tickets).toString());
    }

    @Test
    void test2() {
        List<List<String>> tickets =
                new ArrayList<>(
                        Arrays.asList(
                                Arrays.asList("JFK", "SFO"),
                                Arrays.asList("JFK", "ATL"),
                                Arrays.asList("SFO", "ATL"),
                                Arrays.asList("ATL", "JFK"),
                                Arrays.asList("ATL", "SFO")));
        assertEquals("[JFK, ATL, JFK, SFO, ATL, SFO]", findItinerary(tickets).toString());
    }
}
