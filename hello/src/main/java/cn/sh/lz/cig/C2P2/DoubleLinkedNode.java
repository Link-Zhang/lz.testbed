package cn.sh.lz.cig.C2P2;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/***
 * @author Link
 * @date 2020/07/30
 * @time 09:31
 */
@Setter
@Getter
@RequiredArgsConstructor()
public class DoubleLinkedNode {
    @NonNull
    private int data;

    private DoubleLinkedNode last;

    private DoubleLinkedNode next;
}
