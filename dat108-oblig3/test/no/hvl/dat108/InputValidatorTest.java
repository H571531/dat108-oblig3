package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat108.utils.InputValidator;

class InputValidatorTest {

	@Test
	public void testeGyldigFornavn() {
		assertTrue(InputValidator.isFornavnGyldig("Abc"));
		assertFalse(InputValidator.isFornavnGyldig("abc"));
		assertFalse(InputValidator.isFornavnGyldig("a"));
		assertFalse(InputValidator.isFornavnGyldig("1abc"));
		assertTrue(InputValidator.isFornavnGyldig("Ab ab"));
		assertTrue(InputValidator.isFornavnGyldig("Ab-ab"));
		assertFalse(InputValidator.isFornavnGyldig("ab ab"));
		assertFalse(InputValidator.isFornavnGyldig("ab-ab"));
		assertFalse(InputValidator.isFornavnGyldig("Abcdefghijklmnopqrstu")); //21 tegn
		assertFalse(InputValidator.isFornavnGyldig(" Abc"));
		assertFalse(InputValidator.isFornavnGyldig("-Abc"));
		assertFalse(InputValidator.isFornavnGyldig("Abc-"));
		assertFalse(InputValidator.isFornavnGyldig("INSERT INTO--"));
		assertFalse(InputValidator.isFornavnGyldig("Drop table deltaker;--"));
		assertTrue(InputValidator.isFornavnGyldig("Ab Cd Ef"));
		assertTrue(InputValidator.isFornavnGyldig("Aa-Bb Cc"));

		

		assertFalse(InputValidator.isFornavnGyldig("<script></script>"));
	}
	
	@Test
	public void testeGyldigEtternavn() {
		assertTrue(InputValidator.isEtternavnGyldig("Abc"));
		assertFalse(InputValidator.isEtternavnGyldig("abc"));
		assertFalse(InputValidator.isEtternavnGyldig("a"));
		assertFalse(InputValidator.isEtternavnGyldig("1abc"));
		assertFalse(InputValidator.isEtternavnGyldig("Ab ab"));
		assertFalse(InputValidator.isEtternavnGyldig("Ab-ab"));
		assertFalse(InputValidator.isEtternavnGyldig("ab ab"));
		assertFalse(InputValidator.isEtternavnGyldig("ab-ab"));
		assertFalse(InputValidator.isEtternavnGyldig("Abcdefghijklmnopqrstu")); //21 tegn
		assertFalse(InputValidator.isEtternavnGyldig(" Abc"));
		assertFalse(InputValidator.isEtternavnGyldig("-Abc"));
		assertFalse(InputValidator.isEtternavnGyldig("Abc-"));
		assertFalse(InputValidator.isEtternavnGyldig("INSERT INTO--"));

		assertFalse(InputValidator.isFornavnGyldig("<script></script>"));
	}
	
	@Test
	public void testIsMobilGyldig() {
		assertTrue(InputValidator.isMobilGyldig("12345678"));
		assertFalse(InputValidator.isMobilGyldig("123"));
		assertFalse(InputValidator.isMobilGyldig("abcdefgh"));
		assertFalse(InputValidator.isMobilGyldig("123456789"));
	}
	
	@Test
	public void testIsPasswordGyldig() {
		assertTrue(InputValidator.isPassordGyldig("abcd"));
		assertTrue(InputValidator.isPassordGyldig("1234"));
		assertFalse(InputValidator.isPassordGyldig("123"));
		assertTrue(InputValidator.isPassordGyldig("1 2 3 4"));
	}
}
