package com.epam.jmstask.jms;

import org.springframework.web.bind.annotation.*;

@RestController
public class BookRestService {
	
	@GetMapping("/book")
	public Book book(@RequestParam(value="name", defaultValue="Dune") String name) {
		return new Book(1, name);
	}
}
