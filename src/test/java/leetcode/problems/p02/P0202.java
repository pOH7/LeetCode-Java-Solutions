package leetcode.problems.p02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 202. Happy Number
 *
 * @link https://leetcode.com/problems/happy-number/
 * @author zhanglei
 * @date 2022/2/23
 */
@Slf4j
class P0202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            n =
                    Stream.of(n)
                            .flatMap(
                                    i -> {
                                        Stream.Builder<Integer> builder = Stream.builder();
                                        while (i >= 10) {
                                            builder.add(i % 10);
                                            i /= 10;
                                        }
                                        builder.add(i);
                                        return builder.build();
                                    })
                            .mapToInt(i -> i * i)
                            .sum();
        }

        return n == 1;
    }

    @Test
    void test1() {
        assertTrue(isHappy(19));
    }

    @Test
    void test2() {
        assertFalse(isHappy(2));
    }
}
