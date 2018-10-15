package com.proenca.services;

import org.springframework.mail.SimpleMailMessage;

import com.proenca.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage simpleMail);

}
