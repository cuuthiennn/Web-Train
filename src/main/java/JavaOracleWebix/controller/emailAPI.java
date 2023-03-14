package JavaOracleWebix.controller;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import JavaOracleWebix.service.emailService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/email")
public class emailAPI {
	@Autowired
	emailService emailSrc;
	
	@GetMapping("/sendEmailWellcome")
	ResponseEntity<?> doSendEmail(@RequestParam("maKh") Long userId, @RequestParam("toEmail") String toEmail) throws MailException{
		HashMap<String , Object> result = new HashMap<>();
		try {
			emailSrc.sendEmail(userId, toEmail);
			result.put("success", true);
			result.put("message", "Success to call api sendEmail!");
			result.put("data", toEmail);
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Fail to call api sendEmail!", e);
			result.put("success", false);
			result.put("message", "Fail to call api sendEmail!");
			result.put("data", null);
		}
		return ResponseEntity.ok(result);
	}
}
