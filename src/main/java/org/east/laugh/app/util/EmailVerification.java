package org.east.laugh.app.util;


import io.github.thundzeng.miniemail.config.MailConfig;
import io.github.thundzeng.miniemail.constant.SmtpEnum;
import io.github.thundzeng.miniemail.core.MiniEmail;
import io.github.thundzeng.miniemail.core.MiniEmailFactory;
import io.github.thundzeng.miniemail.core.MiniEmailFactoryBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmailVerification {

    private static MiniEmailFactory miniEmailFactory;

    public EmailVerification() {
        miniEmailFactory = new MiniEmailFactoryBuilder().build(MailConfig.config("east_laugh@163.com", "ZLKEDPOCHAQKMDEL")
                .setMailDebug(false)
                .setSenderNickname("EAST LAUGH")
                .setMailSmtpHost(SmtpEnum.SMTP_163));
    }

    public void SendEmail(String TO_EMAIL,String content){
        MiniEmail miniEmail = miniEmailFactory.init();
        miniEmail.send(TO_EMAIL, content);
    }
}
