package cn.sh.lz.cig.C2P7;

import cn.sh.lz.cig.C2P1.LinkedNode;
import cn.sh.lz.cig.C2P1.Node;

/***
 * @author Link
 * @date 2020/08/26
 * @time 10:29
 */
public class PalindromeMain {
    public static void main(String[] args) {
        int[] l1 = new int[]{1, 2, 3, 2, 1};
        Node node = new Node();
        LinkedNode head = node.build(l1);
        System.out.println("The LinkedList:");
        node.print(head);
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(head));
        node.print(head);
    }
}
