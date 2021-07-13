package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarrayBitwiseORsTest {

    private SubarrayBitwiseORs o;

    @BeforeEach
    void setUp() {
        o = new SubarrayBitwiseORs();
    }

    /**
     * [1]
     * 1
     * <p>
     * [1]
     * 1
     * <p>
     * [2]
     * 2
     * <p>
     * [1, 1]
     * 1
     * <p>
     * [1, 2]
     * 3
     * <p>
     * [1, 1, 2]
     * 3
     */
    @Test
    void test1() {
        int[] p = new int[]{1, 1, 2};
        int r = o.subarrayBitwiseORs(p);
        assertEquals(3, r);
    }

    @Test
    void test2() {
        int[] p = new int[]{1, 2, 4};
        int r = o.subarrayBitwiseORs(p);
        assertEquals(6, r);
    }

    /**
     * 6            6
     * 6, 12        14
     * 6, 12, 7     15
     * 12           12
     * 12, 7        15
     * 7            7
     */
    @Test
    void test3() {
        int[] p = new int[]{6, 12, 7};
        int r = o.subarrayBitwiseORs(p);
        assertEquals(5, r);
    }

    @Test
    void test4() {
        System.out.println(12 | 7);
    }

    @Test
    void test5() throws IOException, URISyntaxException {
        URL url = getClass().getResource("/SubarrayBitwiseORs");
        if (url == null) {
            return;
        }
        File file = new File(url.toURI());
        InputStreamReader ir = new FileReader(file);
        BufferedReader br = new BufferedReader(ir);
        System.out.println(br.readLine());
    }

    @Test
    void test6() throws URISyntaxException, IOException {
        URL url = getClass().getResource("/SubarrayBitwiseORs");
        if (url == null) {
            return;
        }
        File file = new File(url.toURI());
        InputStreamReader ir = new FileReader(file);
        BufferedReader br = new BufferedReader(ir);

        String s = br.readLine();
        String[] split = s.split(",");
        int[] p = Arrays.stream(split).mapToInt(Integer::valueOf).toArray();

        int r = o.subarrayBitwiseORs(p);
        assertEquals(28606, r);
    }
}
