package JavaOracleWebix.service;

import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

public interface emailService {
	
	void sendEmail(Long userId, String toEmail) throws MailException;
}
