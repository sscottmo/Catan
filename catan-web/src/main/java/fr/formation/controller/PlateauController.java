package fr.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.DAO.IDAOPosition;

@Controller
public class PlateauController {
	
	@Autowired
	private IDAOPosition daoPosition;
	
	
	@GetMapping(value="/plateau")
	public String plateau(Model model) {
		model.addAttribute("positions", daoPosition.orderByPositions());
		return "plateau";
	}
}
