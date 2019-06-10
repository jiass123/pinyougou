package com.pinyougou;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.pinyougou.sftp_jsch.SftpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JschTest {

    @Autowired
    private SftpClient sftpClient;

    @Value("${sftp.localPath}")
    private String localFilename;

    @Value("${sftp.remotePath}")
    private String remoteFilename;

    @Value("${sftp.tomcatResStart}")
    private String tomcatPath;

    @Test
    public void upload() throws SftpException {
        sftpClient.upload(localFilename, remoteFilename);
    }

    @Test
    public void shutdown() throws JSchException, IOException {
        sftpClient.shutdownTomcat(tomcatPath);
    }

    @Test
    public void start() throws JSchException, IOException {
        sftpClient.startTomcat(tomcatPath);
    }
}
