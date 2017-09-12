package com.ecm.api;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecm.entity.Authorities;
import com.ecm.entity.AuthoritiesRepository;
import com.ecm.entity.Users;
import com.ecm.entity.UsersRepository;
import com.ecm.vo.UsersVO;

@RestController
public class UserRegisterController {

	@Autowired
	UsersRepository usersRepository;

	@Autowired
	AuthoritiesRepository authoritiesRepository;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping(value = "/postregister", method = RequestMethod.POST)
	@ResponseBody
	public Users getCurrentLoggedInUser(UsersVO user) {

		System.out.println(user.getUsername());

		Users users = new Users();
		users.setUsername(user.getUsername());
		users.setPassword(user.getPassword());
		users.setAddress(user.getAddress());
		users.setCompany(user.getCompany());
		users.setFullName(user.getFullName());
		users.setRegion(user.getRegion());
		users.setEnabled(false);
		users.setUuid(UUID.randomUUID().toString());

		users = usersRepository.save(users);

		Authorities authorities = new Authorities();
		authorities.setUsername(user.getUsername());
		authorities.setAuthority("ROLE_USER");

		authoritiesRepository.save(authorities);
		
		SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getUsername());
        mail.setFrom("ecmventus@gmail.com");
        mail.setSubject("Active for registeration confirmation");
        mail.setText("To confirm your e-mail address, please click the link below:\n" + ""
                + "http://localhost:8899/userauth/activate?UUID=" + users.getUuid());
        javaMailSender.send(mail);

		return users;
	}



}
