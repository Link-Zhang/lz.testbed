package cn.sh.lz.cig.C2C;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/***
 * @author Link
 * @date 2020/07/29
 * @time 13:52
 */
@Setter
@Getter
@RequiredArgsConstructor()
public class LinkedNode {
    @NonNull
    private int data;

    private LinkedNode next;
}
