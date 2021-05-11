package cn.sh.lz.cig.C2P10;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Created by Link at 09:37 on 2021/05/11.
 */

@Setter
@Getter
@RequiredArgsConstructor()
public class NumberLinkedNode {
    @NonNull
    private int value;

    private NumberLinkedNode next;
}
