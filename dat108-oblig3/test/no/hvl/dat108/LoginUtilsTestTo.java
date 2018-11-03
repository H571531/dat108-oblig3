package no.hvl.dat108;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

import no.hvl.dat108.entities.Deltaker;
import no.hvl.dat108.utils.LoginUtils;
import no.hvl.dat108.utils.PassordUtil;

public class LoginUtilsTestTo {

	
		
		 private MockHttpServletRequest request;
		 private MockHttpServletResponse response;
		 private MockHttpSession sesjon;

		 private Deltaker testDeltaker;
		 
		 
		 @Before
		 public void setup() {
			 request = new MockHttpServletRequest();
			 response = new MockHttpServletResponse();
			 sesjon = new MockHttpSession();
			 
			 testDeltaker= new Deltaker("12345678", PassordUtil.krypterPassord("1234"), "Fornavn", "Etternavn", "m");
		 }
		 
		 @Test
		 public void nyBrukerErIkkeInnlogget() {
			 request.setSession(sesjon);
			 assertFalse(LoginUtils.brukerErInnlogget(request));

			 sesjon.setAttribute("mobil", testDeltaker.getMobil());
			 assertTrue(LoginUtils.brukerErInnlogget(request));
		 }
		 
		 @Test
		 public void manglendeLoginGirRettFeilmelding() {
			 assertEquals("", LoginUtils.loginOverskrift(request));
			 request.setParameter("trengerLogin", "");
			 assertEquals("Denne handlingen krever at du logger inn", LoginUtils.loginOverskrift(request));
			 
		 }
		 
		 @Test 
		 public void feilBrukernavnPassordGirRettFeilmelding(){
			 assertEquals("", LoginUtils.loginOverskrift(request));
			 request.setParameter("feilPassord", "");
			 assertEquals("Feil brukernavn/passord. Pr&oslash;v igjen", LoginUtils.loginOverskrift(request));
		 }
		 
		 @Test
		 public void gittPassordErGyldig() {
			
			 assertFalse(LoginUtils.loginOk(testDeltaker, "abcd"));
			 assertTrue(LoginUtils.loginOk(testDeltaker, "1234"));
		 }
		 
		 @Test
		 public void manglendeLoginDataErUgyldigLogin() {
			 assertFalse(LoginUtils.loginOk(testDeltaker, null));
			 assertFalse(LoginUtils.loginOk(null, "1234"));
		 }

	

}
