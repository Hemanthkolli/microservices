package com.ecm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecm.entity.Users;
import com.ecm.entity.UsersRepository;

@Controller
public class ActivationController {

	@Autowired
	UsersRepository usersRepository;

	@RequestMapping(value = "/activate", method = RequestMethod.GET)
	public String confirmRegistration(Model model, @RequestParam("UUID") String uuid) {
		Users users = usersRepository.findByUuid(uuid);

		if (users == null) { // No token found in DB

			return "failure";
		}
		users.setEnabled(true);
		usersRepository.save(users);

		return "activated";

	}
}
