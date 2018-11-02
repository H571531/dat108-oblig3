package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat108.utils.InputValidator;

class InputValidatorTest {

	@Test
	public void fornavnErMellomToOgTjueTegn() {
		assertFalse(InputValidator.isFornavnGyldig("a"));
		assertFalse(InputValidator.isFornavnGyldig("Abcdefghijklmnopqrstu")); //21 tegn
		
	}
	
	@Test
	public void fornavnKanHaDashOgMellomrom() {
		assertTrue(InputValidator.isFornavnGyldig("Ab ab"));
		assertTrue(InputValidator.isFornavnGyldig("Ab-ab"));
		assertTrue(InputValidator.isFornavnGyldig("Ab Cd Ef"));
		assertTrue(InputValidator.isFornavnGyldig("Aa-Bb Cc"));
	}
	
	@Test
	public void fornavnMaaBegynneMedStorBokstav() {
		assertTrue(InputValidator.isFornavnGyldig("Abc"));
		assertFalse(InputValidator.isFornavnGyldig("abc"));
		assertFalse(InputValidator.isFornavnGyldig(" Abc"));
		assertFalse(InputValidator.isFornavnGyldig("-Abc"));
		assertFalse(InputValidator.isFornavnGyldig("1abc"));
		assertFalse(InputValidator.isFornavnGyldig("ab ab"));
		assertFalse(InputValidator.isFornavnGyldig("ab-ab"));
	}
	
	@Test
	public void fornavnKanIkkeSlutteMedDash() {
		assertFalse(InputValidator.isFornavnGyldig("Abc-"));
	}
	
	@Test
	public void fornavnKanIkkeInneholdeHTMLEllerSQL() {
		assertFalse(InputValidator.isFornavnGyldig("INSERT INTO--"));
		assertFalse(InputValidator.isFornavnGyldig("Drop table deltaker;--"));
		assertFalse(InputValidator.isFornavnGyldig("<script></script>"));
	}
	
	@Test
	public void fornavnKanIkkeHaTall() {
		assertFalse(InputValidator.isFornavnGyldig("Ab12cd"));
		assertFalse(InputValidator.isFornavnGyldig("Ab 2d"));
	}
	
	@Test
	public void etternavnErMellomToOgTjueTegn() {
		assertFalse(InputValidator.isEtternavnGyldig("a"));
		assertFalse(InputValidator.isEtternavnGyldig("Abcdefghijklmnopqrstu")); //21 tegn
	}
	
	@Test
	public void etternavnKanIkkeHaMellomromOgDash() {
		assertFalse(InputValidator.isEtternavnGyldig("Ab ab"));
		assertFalse(InputValidator.isEtternavnGyldig("Ab-ab"));
		assertFalse(InputValidator.isEtternavnGyldig("ab ab"));
		assertFalse(InputValidator.isEtternavnGyldig("ab-ab"));
		assertFalse(InputValidator.isEtternavnGyldig("Abc-"));
	}
	
	@Test
	public void etternavnMaaBegynneMedBokstav() {
		assertTrue(InputValidator.isEtternavnGyldig("Abc"));
		assertFalse(InputValidator.isEtternavnGyldig("abc"));
		
		assertFalse(InputValidator.isEtternavnGyldig("1abc"));
		assertFalse(InputValidator.isEtternavnGyldig(" Abc"));
		assertFalse(InputValidator.isEtternavnGyldig("-Abc"));
	}
	
	@Test
	public void etternavnKanIkkeHaHTMLOgSQL() {
		assertFalse(InputValidator.isEtternavnGyldig("INSERT INTO--"));

		assertFalse(InputValidator.isEtternavnGyldig("<script></script>"));
		assertFalse(InputValidator.isEtternavnGyldig("<script></script>"));
	}
	
	@Test
	public void etternavnKanIkkeHaTall() {
		assertFalse(InputValidator.isEtternavnGyldig("Ab12cd"));
		assertFalse(InputValidator.isEtternavnGyldig("Ab 2d"));
	}
	
	
	@Test
	public void testIsMobilGyldig() {
		assertFalse(InputValidator.isMobilGyldig("abcdefgh"));
		
	}
	
	@Test
	public void mobilMaaHa8Tegn() {
		assertTrue(InputValidator.isMobilGyldig("12345678"));
		assertFalse(InputValidator.isMobilGyldig("1"));
		assertFalse(InputValidator.isMobilGyldig("1234567"));
		assertFalse(InputValidator.isMobilGyldig("123456789"));
	}
	
	@Test
	public void mobilMaaHaTall() {
		assertFalse(InputValidator.isMobilGyldig("a1234567"));
		assertFalse(InputValidator.isMobilGyldig("1234567a"));
		assertFalse(InputValidator.isMobilGyldig("1234567DROP TABLE deltaker;--"));
		assertFalse(InputValidator.isMobilGyldig("<script></script>"));
		assertFalse(InputValidator.isMobilGyldig("abcdefgh"));
		assertFalse(InputValidator.isMobilGyldig("ABCDEFGH"));
	}
	
	@Test
	public void testIsPasswordGyldig() {
		assertTrue(InputValidator.isPassordGyldig("abcd"));
		assertTrue(InputValidator.isPassordGyldig("1234"));
		assertFalse(InputValidator.isPassordGyldig("123"));
		assertTrue(InputValidator.isPassordGyldig("1 2 3 4"));
	}
}
