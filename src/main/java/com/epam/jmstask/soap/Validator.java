package com.epam.jmstask.soap;

import javax.jws.WebService;

@WebService
public interface Validator {
	boolean validate(CreditCard creditCard);
	CreditCard getCard();
}
