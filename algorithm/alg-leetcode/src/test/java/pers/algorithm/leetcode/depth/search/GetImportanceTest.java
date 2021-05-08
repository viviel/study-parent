package pers.algorithm.leetcode.depth.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetImportanceTest {

    private final GetImportance o = new GetImportance();

    /**
     * [[1,5,[2,3]],[2,3,[4]],[3,4,[]],[4,1,[]]]
     * 1
     */
    @Test
    void test1() {
        assertEquals(o.getImportance(generate(), 1), 13);
    }

    private List<Employee> generate() {
        return new ArrayList<Employee>() {{
            add(new Employee() {{
                id = 1;
                importance = 5;
                subordinates = new ArrayList<Integer>() {{
                    add(2);
                    add(3);
                }};
            }});
            add(new Employee() {{
                id = 2;
                importance = 3;
                subordinates = new ArrayList<Integer>() {{
                    add(4);
                }};
            }});
            add(new Employee() {{
                id = 3;
                importance = 4;
                subordinates = new ArrayList<>();
            }});
            add(new Employee() {{
                id = 4;
                importance = 1;
                subordinates = new ArrayList<>();
            }});
        }};
    }

    @Test
    void test2() {
        assertEquals(o.getImportance2(generate(), 1), 13);
    }
}