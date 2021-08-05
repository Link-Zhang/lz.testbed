package cn.sh.lz.inspect.ssh;

import cn.sh.lz.inspect.ssh.entities.Server;
import cn.sh.lz.inspect.ssh.entities.ServerArray;
import cn.sh.lz.inspect.ssh.utils.SSHUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.jcraft.jsch.JSchException;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Link at 20:51 on 2021/08/05.
 */
public class SSH {
    public static void main(String[] args) throws IOException, JSchException {
        long totalStart = System.currentTimeMillis();
        File yamlSource = ResourceUtils.getFile("classpath:devices.yml");
        YAMLFactory yamlFactory = new YAMLFactory();
        ObjectMapper objectMapper = new ObjectMapper(yamlFactory);
        ServerArray serverArray = objectMapper.readValue(yamlSource, ServerArray.class);
        if (serverArray == null || serverArray.getServers() == null) {
            return;
        }
        for (int i = 0; i < serverArray.getServers().length; i++) {
            System.out.println(i + 1 + "==>>");
            long start = System.currentTimeMillis();
            Server server = serverArray.getServers()[i];
            String content = SSHUtil.remoteExecute(server);
            SSHUtil.write(server.getHost(), content);
            long end = System.currentTimeMillis();
            NumberFormat formatter = new DecimalFormat("#0.00000");
            System.out.println("Cost seconds: " + formatter.format((end - start) / 1000d));
        }
        long totalEnd = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Total Cost Seconds: " + formatter.format((totalEnd - totalStart) / 1000d));
    }
}
