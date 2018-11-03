package no.hvl.dat108;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

import no.hvl.dat108.entities.Deltaker;
import no.hvl.dat108.utils.LoginUtils;

class LoginUtilsTest {
	
	 private MockHttpServletRequest request;
	 private MockHttpServletResponse response;
	 //private MockHttpSession sesjon;

	 
	 
	 @Before
	 public void setup() {
		 request = new MockHttpServletRequest();
		 response = new MockHttpServletResponse();
		 //sesjon = new MockHttpSession();
		 
	 }
	 
	 @Test
	 public void nyBrukerErIkkeInnlogget() {
		 Deltaker testDeltaker= new Deltaker("12345678", "passordHash", "Fornavn", "Etternavn", "m");
		 //sesjon.setAttribute("mobil", testDeltaker.getMobil());

		 //request.setSession(new MockHttpSession());
		 request.setAttribute("mobil", testDeltaker.getMobil());
		 assertTrue(LoginUtils.brukerErInnlogget(request));
	 }

}
