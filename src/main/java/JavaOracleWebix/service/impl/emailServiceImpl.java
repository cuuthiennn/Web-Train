package JavaOracleWebix.service.impl;

import org.apache.ibatis.mapping.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import JavaOracleWebix.mapper.userMapper;
import JavaOracleWebix.service.emailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailServiceImpl implements emailService{
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private userMapper userMapper;
	@Override
	public void sendEmail(Long userId, String toEmail) throws MailException {
		// TODO Auto-generated method stub
		MimeMessage message = mailSender.createMimeMessage();
		String checkResult =  userMapper.checkToSendEmail(userId);
		try {
			if(!checkResult.isEmpty()) {
				String htmlContent ="<h1>WELLCOM</h1>" +
				                    "<p>Wellcome "+ checkResult +" to join <strong>THIENKHONGNGU company</strong> hope you have a great experiences.</p>"+
									"<p>Now you can go to work next week.</p>"+
									"<p>Good to see you.</p>";
				String subject="WELLCOME";
				
				message.setFrom(new InternetAddress("thienweret@gmail.com"));
				message.setRecipients(MimeMessage.RecipientType.TO, toEmail);
				message.setContent(htmlContent, "text/html; charset=utf-8");
				message.setSubject(subject);
				mailSender.send(message);
			}
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
