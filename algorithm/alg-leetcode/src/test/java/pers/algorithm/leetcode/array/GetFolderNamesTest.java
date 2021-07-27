package pers.algorithm.leetcode.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GetFolderNamesTest {

    private GetFolderNames o;

    @BeforeEach
    void setUp() {
        o = new GetFolderNames();
    }

    @Test
    void test1() {
        String r = o.append("vv");
        assertEquals("vv(1)", r);
    }

    @Test
    void test2() {
        String r = o.next("vv(12)");
        assertEquals("vv(13)", r);
    }

    @Test
    void test3() {
        String[] p = new String[]{"pes", "fifa", "gta", "pes(2019)"};
        String[] r = o.getFolderNames(p);
        String[] t = new String[]{"pes", "fifa", "gta", "pes(2019)"};
        assertArrayEquals(t, r);
    }

    @Test
    void test4() {
        String[] p = new String[]{"gta", "gta(1)", "gta", "avalon"};
        String[] r = o.getFolderNames(p);
        String[] t = new String[]{"gta", "gta(1)", "gta(2)", "avalon"};
        assertArrayEquals(t, r);
    }

    @Test
    void test5() {
        String[] p = new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        String[] r = o.getFolderNames(p);
        String[] t = new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece(4)"};
        assertArrayEquals(t, r);
    }

    @Test
    void test6() {
        String[] p = new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"};
        String[] r = o.getFolderNames(p);
        String[] t = new String[]{"kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)"};
        assertArrayEquals(t, r);
    }

    @Test
    void test7() {
        String[] p = new String[]{"wano", "wano", "wano", "wano"};
        String[] r = o.getFolderNames(p);
        String[] t = new String[]{"wano", "wano(1)", "wano(2)", "wano(3)"};
        assertArrayEquals(t, r);
    }

    @Test
    void test8() {
        String[] p = new String[]{"kaido", "kaido(4)", "kaido", "kaido(1)"};
        String[] r = o.getFolderNames(p);
        String[] t = new String[]{"kaido", "kaido(4)", "kaido(1)", "kaido(1)(1)"};
        assertArrayEquals(t, r);
    }

    @Test
    void test9() {
        String[] p = new String[]{"kaido", "kaido(3)", "kaido", "kaido", "kaido"};
        String[] r = o.getFolderNames(p);
        String[] t = new String[]{"kaido", "kaido(3)", "kaido(1)", "kaido(2)", "kaido(4)"};
        assertArrayEquals(t, r);
    }
}
