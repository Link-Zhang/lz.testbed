package cn.sh.lz.inspect.ssh.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Link at 13:47 on 2021/08/05.
 */
@Data
public class Server {
    @JsonProperty("host")
    private String host;

    @JsonProperty("port")
    private int port = 22;

    @JsonProperty("username")
    private String username = "admin";

    @JsonProperty("password")
    private String password = "Shch@1128@&*(";

    @JsonProperty("commands")
    private String[] commands = {"screen-length disable", "display current-configuration"};
}
