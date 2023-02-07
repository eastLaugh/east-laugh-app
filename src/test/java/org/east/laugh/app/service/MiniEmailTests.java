package org.east.laugh.app.service;

import io.github.thundzeng.miniemail.config.MailConfig;
import io.github.thundzeng.miniemail.constant.SmtpEnum;
import io.github.thundzeng.miniemail.core.MiniEmail;
import io.github.thundzeng.miniemail.core.MiniEmailFactory;
import io.github.thundzeng.miniemail.core.MiniEmailFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.io.File;
import java.net.URL;
@SpringBootTest
public class MiniEmailTests {
    // 该邮箱修改为你需要测试的收件邮箱地址
    private static final String TO_EMAIL = "east_laugh@qq.com";

    MiniEmailFactory miniEmailFactory;

    @Before
    public void before() {
        System.out.println(233);
        // 使用入参创建（不推荐）
//        miniEmailFactory = new MiniEmailFactoryBuilder().build(true, "123456@sina.com", "xxxxxx", SmtpEnum.SMTP_SINA);
        // 使用配置类创建（推荐）

    }

    /**
     * 快速发送文本邮件，2行代码搞定
     */
    @Test
    public void testSendText() throws MessagingException {
        miniEmailFactory = new MiniEmailFactoryBuilder().build(MailConfig.config("east_laugh@163.com", "ZLKEDPOCHAQKMDEL")
                .setMailDebug(false)
                .setSenderNickname("天雷盖地虎")
                .setMailSmtpHost(SmtpEnum.SMTP_163));
        MiniEmail miniEmail = miniEmailFactory.init();
        miniEmail.send(TO_EMAIL, "信件内容123456");
    }



}