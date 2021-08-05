package cn.sh.lz.inspect.ssh.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Link at 21:27 on 2021/08/05.
 */
@Data
public class ServerArray {
    @JsonProperty("devices")
    private Server[] servers;
}
