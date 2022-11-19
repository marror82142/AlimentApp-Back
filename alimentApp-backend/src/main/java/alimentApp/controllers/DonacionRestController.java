package alimentApp.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import alimentApp.models.entity.Donacion;
import alimentApp.models.entity.Usuario;
import alimentApp.models.services.IDonacionService;
import alimentApp.models.services.IUsuarioService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DonacionRestController {
	
	@Autowired
	private IDonacionService donacionService;
	
	@PostMapping("/donacion")
	@ResponseStatus(HttpStatus.CREATED)
	public Donacion create(@RequestBody Donacion donacion){			
		return donacionService.createDonacion(donacion);		
	}
}
