package in.ashokit.util;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
    
    @Autowired
    private JavaMailSender mailSender;
    
    // ✅ Updated method: supports file attachment
    public boolean sendEmail(String subject, String body, String to, File file) {
        try {
            MimeMessage mimeMsg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true); // true = allows attachments
            
            helper.setSubject(subject);
            helper.setText(body, true); // HTML content
            helper.setTo(to);

            if (file != null && file.exists()) {
                helper.addAttachment(file.getName(), file);
            }

            mailSender.send(mimeMsg);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
