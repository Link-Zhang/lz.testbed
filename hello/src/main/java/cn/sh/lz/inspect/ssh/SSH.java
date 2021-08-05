package cn.sh.lz.inspect.ssh;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Link at 13:49 on 2021/08/05.
 */
public class SSH {
    private static final int CONNECT_TIMEOUT = 60000;

    private static String PATH = "/Users/Link/Backup/";

    private static String FILE_EXTENTION = ".log";

    public static String remoteExecute(Remote remote) throws JSchException, IOException {
        JSch jSch = new JSch();
        Session session = jSch.getSession(remote.getUsername(), remote.getHost(), remote.getPort());
        session.setPassword(remote.getPassword());
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect(CONNECT_TIMEOUT);
        if (session.isConnected()) {
            System.out.println("Host connected: " + remote.getHost());
        }
        StringBuilder result = new StringBuilder();
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand(remote.getCommand());
        InputStream input = channel.getInputStream();
        channel.connect(CONNECT_TIMEOUT);
        byte[] tmp = new byte[1024];
        while (true) {
            while (input.available() > 0) {
                int i = input.read(tmp, 0, 1024);
                if (i < 0) break;
                result.append(new String(tmp, 0, i));
            }
            if (channel.isClosed()) {
                if (input.available() > 0) continue;
                System.out.println("Exit Code: " + channel.getExitStatus());
                break;
            }
        }
        channel.disconnect();
        session.disconnect();
        return result.toString().replaceAll("\\p{Cntrl}", System.lineSeparator()).replaceAll("(?m)^[ \t]*\r?\n", "");
    }

    public static void write(String host, String content) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyyMMdd");
        Date date = new Date();
        String dirSuffix = sdf.format(date);
        sdf.applyPattern("HHmmss");
        String fileSuffix = sdf.format(date);
        String path = PATH + dirSuffix;
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        path = path + File.separator + host + "_" + fileSuffix + FILE_EXTENTION;
        Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) throws Exception {
        Remote remote = new Remote();
        long start = System.currentTimeMillis();
        String result = SSH.remoteExecute(remote);
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
        SSH.write(remote.getHost(), result);
    }
}
