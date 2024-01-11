package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private final String template = "Hello, %S!" ;
	private  final AtomicLong  counter = new AtomicLong();
	
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "nome",defaultValue = "Word")String nome) {
		
		return new Greeting(counter.incrementAndGet(), String.format(template, nome));
		
	}

}
