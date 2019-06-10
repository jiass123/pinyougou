package com.asiainfo.config.sftp;

import com.asiainfo.sftp_jsch.SftpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SftpConfig {

    @Bean
    public SftpClient sftpClient(@Value("${sftp.host}") String host, @Value("${sftp.username}") String username,
                                 @Value("${sftp.password}") String password) {
        return new SftpClient(host, username, password);
    }
}
