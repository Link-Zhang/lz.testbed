package cn.sh.lz.inspect.ssh;

import lombok.Data;

/**
 * Created by Link at 13:47 on 2021/08/05.
 */
@Data
public class Remote {
    private String host = "10.166.52.11";
    private int port = 22;
    private String username = "admin";
    private String password = "Shch@1128@&*(";
    private String command = "display current-configuration";
//    private String command = "screen-length disable\ndisplay current-configuration\n";
}
