package cn.sh.lz.cig.C2P9;

import java.util.HashMap;

/***
 * @author Link
 * @date 2020/08/26
 * @time 15:09
 */
public class Copy {
    public RandomLinkedNode copy(RandomLinkedNode head) {
        HashMap<RandomLinkedNode, RandomLinkedNode> map = new HashMap<>();
        RandomLinkedNode cur = head;
        while (null != cur) {
            map.put(cur, new RandomLinkedNode(cur.getData()));
            cur = cur.getNext();
        }
        cur = head;
        while (null != cur) {
            map.get(cur).setNext(map.get(cur.getNext()));
            map.get(cur).setRand(map.get(cur.getRand()));
            cur = cur.getNext();
        }
        return map.get(head);
    }
}
