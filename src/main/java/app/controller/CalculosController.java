package app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Entrada;
import app.entity.Resultado;
import app.service.CalculosService;

@RestController
@RequestMapping("/calculos")
public class CalculosController {
	
	private final CalculosService calculosService;

	CalculosController(CalculosService calculosService) {
		this.calculosService = calculosService;
	}

	@GetMapping("/calcular")
	public ResponseEntity<Resultado> calcular(@RequestBody Entrada entrada){
		
		try {
			
			Resultado resultado = this.calculosService.calcular(entrada);
			return new ResponseEntity<Resultado>(resultado, HttpStatus.OK);
			
		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		}
	}
	
}
