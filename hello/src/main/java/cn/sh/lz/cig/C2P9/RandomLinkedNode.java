package cn.sh.lz.cig.C2P9;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/***
 * @author Link
 * @date 2020/08/26
 * @time 15:04
 */
@Setter
@Getter
@RequiredArgsConstructor()
public class RandomLinkedNode {
    @NonNull
    private int data;

    private RandomLinkedNode next;

    private RandomLinkedNode rand;
}
