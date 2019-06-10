package com.pinyougou.sftp_jsch;

import com.jcraft.jsch.*;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SftpClient {

    private static final Logger logger = LoggerFactory.getLogger(SftpClient.class);

    private ChannelSftp instance;

    private String hostname;

    private int port;

    private String username;

    private String password;

    private static final int default_port = 22022;

    public SftpClient(String hostname, String username, String password) {
        this(hostname, default_port, username, password);
    }

    public SftpClient(String hostname, int port, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public ChannelSftp getInstance() {
        return instance;
    }

    public Session connect() throws JSchException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(username, hostname, port);
        session.setPassword(password);
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        session.setConfig(sshConfig);
        session.connect();
        return session;
    }


    public void disconnect() throws JSchException {
        Session session = instance.getSession();
        session.disconnect();
    }

    public synchronized boolean upload(String localFilePath, String remoteFilePath) throws SftpException {
        if (instance == null || !instance.isConnected()) {
            try {
                Session session = connect();
                Channel channel = session.openChannel("sftp");
                channel.connect();
                instance = (ChannelSftp) channel;
            } catch (JSchException e) {
                logger.error("本地文件：{} sftp上传connect错误(JSchException)：", localFilePath, e);
                return false;
            }
        }
        File file = new File(localFilePath);
        FileInputStream uploadLoaclFis = null;
        try {
            uploadLoaclFis = new FileInputStream(file);
            instance.put(uploadLoaclFis, remoteFilePath, ChannelSftp.OVERWRITE);
            logger.info("SFTP上传成功！目录：{}", localFilePath);
            return true;
        } catch (Exception e) {
            logger.error("SFTP上传失败！目录：{} 错误为:{}", localFilePath, e.getMessage());
            return false;
        } finally {
            if (uploadLoaclFis != null) {
                try {
                    // 关闭流
                    uploadLoaclFis.close();
                    instance.disconnect();
                } catch (Exception e) {
                    logger.error("inputStream close IOException:" + e.getMessage(), e);
                }
            }
        }
    }


    public String execCommandByJSch(String command, String resultEncoding) throws IOException, JSchException {
        Session session = connect();
        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        InputStream in = channelExec.getInputStream();
        channelExec.setCommand(command);
        channelExec.setErrStream(System.err);
        channelExec.connect();
        String result = IOUtils.toString(in, resultEncoding);
        channelExec.disconnect();
        return result;
    }

    public void shutdownTomcat(String tomcatPath) throws IOException, JSchException {
        String s = execCommandByJSch("export PATH;" +
                "PATH=$PATH:$HOME/.local/bin:$HOME/bin;" +
                "JAVA_HOME=/home/puaiuc/dianqu-test/jdk/jdk1.8.0_181;" +
                "PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH;" +
                "CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib:$CLASSPATH;" +
                "export JAVA_HOME CLASSPATH PATH;" +
                "sh " + tomcatPath + "shutdown.sh;", "UTF-8");
    }

    public void startTomcat(String tomcatPath) throws IOException, JSchException {
        String s = execCommandByJSch("export PATH;" +
                "PATH=$PATH:$HOME/.local/bin:$HOME/bin;" +
                "JAVA_HOME=/home/puaiuc/dianqu-test/jdk/jdk1.8.0_181;" +
                "PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH;" +
                "CLASSPATH=.:$JAVA_HOME/lib:$JAVA_HOME/jre/lib:$CLASSPATH;" +
                "export JAVA_HOME CLASSPATH PATH;" +
                "sh " + tomcatPath + "startup.sh;", "UTF-8");
    }

}
