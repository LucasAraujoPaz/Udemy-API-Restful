package br.com.erudio.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
	public Double sum(@PathVariable("firstNumber") String firstNumber, 
			@PathVariable("secondNumber") String secondNumber) {
		
		Double x = convertStringToNumber(firstNumber);
		Double y = convertStringToNumber(secondNumber);
		
		return x + y;
	}
	
	@RequestMapping(value = "/multiply/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
	public Double multiply(@PathVariable("firstNumber") String firstNumber, 
			@PathVariable("secondNumber") String secondNumber) {
		
		Double x = convertStringToNumber(firstNumber);
		Double y = convertStringToNumber(secondNumber);
		
		return x * y;
	}

	@RequestMapping(value = "/power/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
	public Double power(@PathVariable("firstNumber") String firstNumber, 
			@PathVariable("secondNumber") String secondNumber) {
		
		Double x = convertStringToNumber(firstNumber);
		Double y = convertStringToNumber(secondNumber);
		
		return Math.pow(x, y);
	}
	
	private Double convertStringToNumber(String numberInString) {
		
		Double number = 0.0;
		
		try {
			number = Double.valueOf(numberInString.replace(",", "."));
		} catch (RuntimeException e) {
			throw new UnsupportedMathOperationException("Please send a numeric value.");
		}
		
		return number;
	}
	
}
