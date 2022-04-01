package com.example.mvccryptotracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import ch.qos.logback.core.subst.Token.Type;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CryptoController {

	@Autowired
	public MongoRepoView repo;
	// public MongoRepoDelete del;

	@GetMapping("/")
	public String homepage(Model model) {
		return "homepage";
	}

	@GetMapping("/viewcrypto")
	public String viewcrypto(Model model) {
		List<Crypto> crypto = repo.findAll();
		// del.deleteByname("sa");
		model.addAttribute("allcrypto", crypto);
		// model.addAttribute("b", new Crypto());
		return "viewcrypto";
	}

	@GetMapping("/addcrypto")
	public String addcrypto(Model model) {
		model.addAttribute("crypto", new Crypto());
		return "addcrypto";
	}

	@PostMapping("/addcrypto")
	public String submitcrypto(@ModelAttribute("crypto") Crypto crypto) {
		repo.save(crypto);
		return "redirect:viewcrypto";
	}
	/*
	 * @PostMapping("/editcrypto")
	 * public String submiteditcrypto(@ModelAttribute("crypto") Crypto crypto) {
	 * System.out.println(crypto.getname2());
	 * 
	 * 
	 * List<Crypto> crypto = repo.getcryptoByname(crypto.getname());
	 * for(Crypto b : crypto) {
	 * b.setname(crypto.getname2());
	 * b.setDescription(crypto.getDescription2());
	 * b.setName(crypto.getName2());
	 * b.setYearOfRelease(crypto.getYearOfRelease2());
	 * b.setRating(crypto.getRating2());
	 * repo.save(b);
	 * }
	 * 
	 * 
	 * return "redirect:viewcrypto";
	 * }
	 */

	@GetMapping("/deletecrypto")
	public String deleteCrypto(Model model) {
		model.addAttribute("crypto", new Crypto());
		return "deletecrypto";
	}

	@PostMapping("/deletecrypto")
	public String delcrypto(@ModelAttribute("crypto") Crypto crypto) {
		System.out.println(crypto.getName());
		List<Crypto> cryptos = repo.getCryptoByname(crypto.getName());
		for (Crypto b : cryptos) {

			/*
			 * System.out.println(
			 * "------------------------------------------------------------------------------------\ndelete"
			 * + b.getName());
			 * System.out.println(b.getFunds() + b.getName() + b.getPrice() +
			 * b.getShortForm());
			 */
			/*
			 * Crypto temp = new Crypto();
			 * temp.setName(b.getName());
			 * temp.setShortForm(b.getShortForm());
			 * temp.setFunds(b.getFunds());
			 * temp.setPrice(b.getPrice());
			 * temp.setValue(b.getFunds(), b.getPrice());
			 */
			repo.deleteByName(b.getName());
		}
		return "redirect:viewcrypto";
	}

	@PostMapping("/deleteIndcrypto")
	public String delcryptoInd(String name) {
		repo.deleteByName(name);
		return "redirect:viewcrypto";
	}
}
