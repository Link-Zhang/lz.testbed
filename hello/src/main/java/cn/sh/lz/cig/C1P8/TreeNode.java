package cn.sh.lz.cig.C1P8;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/***
 * @author Link
 * @date 2020/07/23
 * @time 10:59
 */
@Setter
@Getter
@RequiredArgsConstructor()
public class TreeNode {
    @NonNull
    private int data;

    private TreeNode left;

    private TreeNode right;
}
