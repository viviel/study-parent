package pers.algorithm.leetcode.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给你一个产品数组products和一个字符串searchWord，products 数组中每个产品都是一个字符串。
 * <p>
 * 请你设计一个推荐系统，在依次输入单词searchWord 的每一个字母后，推荐products 数组中前缀与searchWord 相同的最多三个产品。
 * 如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 * <p>
 * 请你以二维列表的形式，返回在输入searchWord每个字母后相应的推荐产品的列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * 输出：[
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * 解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
 * 输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
 * 输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
 * 示例 2：
 * <p>
 * 输入：products = ["havana"], searchWord = "havana"
 * 输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * 示例 3：
 * <p>
 * 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * 输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * 示例 4：
 * <p>
 * 输入：products = ["havana"], searchWord = "tatiana"
 * 输出：[[],[],[],[],[],[],[]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= products.length <= 1000
 * 1 <= Σ products[i].length <= 2 * 10^4
 * products[i]中所有的字符都是小写英文字母。
 * 1 <= searchWord.length <= 1000
 * searchWord中所有字符都是小写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-suggestions-system
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class SuggestedProducts {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<String> p = Arrays.stream(products).collect(Collectors.toList());
        List<List<String>> r = new LinkedList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> filter = new LinkedList<>();
            for (String s : p) {
                if (s.startsWith(searchWord.substring(0, i + 1))) {
                    filter.add(s);
                    if (filter.size() == 3) {
                        break;
                    }
                }
            }
            r.add(filter);
        }
        return r;
    }
}
