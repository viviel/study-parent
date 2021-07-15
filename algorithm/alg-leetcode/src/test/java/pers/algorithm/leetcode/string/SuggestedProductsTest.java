package pers.algorithm.leetcode.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SuggestedProductsTest {

    private SuggestedProducts o;

    @BeforeEach
    void setUp() {
        o = new SuggestedProducts();
    }

    @Test
    void test1() {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> r = o.suggestedProducts(products, searchWord);
    }

    @Test
    void test2() {
        String[] products = {"havana"};
        String searchWord = "havana";
        List<List<String>> r = o.suggestedProducts(products, searchWord);
    }

    @Test
    void test3() {
        String[] products = {"bags", "baggage", "banner", "box", "cloths"};
        String searchWord = "bags";
        List<List<String>> r = o.suggestedProducts(products, searchWord);
    }

    @Test
    void test4() {
        String[] products = {"bags", "baggage", "banner", "box", "cloths"};
        String searchWord = "bags1";
        List<List<String>> r = o.suggestedProducts(products, searchWord);
    }
}
