/**
 * 
 */

"use strict";


let skjema = document.getElementById("skjema");
skjema.addEventListener("change", sjekk, false); //Lager listener for onchange for alle felt i skjema - Hver gang et felt skrives i og feltet mister fokus - kjør sjekk() for felt som ble klikket på

/**
 * Kjøres onchange i skjema - velger felt som er forandret og validerer dette
 * @param e felt som er blitt endret
 * 
 */
function sjekk(e) {
    if (e.target !== e.currentTarget) { //Ikke reager på hendelser for selve skjemaet
        var felt = e.target.id;
       validerFelt(felt);
    }
    e.stopPropagation(); //Trenger ikke sjekke om noe skjer oppover i DOM
};

/**
 * Validerer felt i påmeldingsskjema
 * @param felt som skal valideres
 * @returns Om gitt felt er gyldig eller ei
 */
function validerFelt(felt){
	//Egen håndtering for å sammenligne passord og passordRepetert
	if(felt === "passordRepetert"){
		let passord=document.getElementById("passord");
		let passordRepetert = document.getElementById("passordRepetert");
		if(!(passordRepetert.value === passord.value)){
			document.getElementById("passordRepetertFeil").classList.remove("gjemt");
			document.getElementById(felt).classList.add("ugyldig");
			document.getElementById("passordRepetertServerFeil").classList.remove("gjemt");
			return false;
		} else{
			document.getElementById("passordRepetertFeil").classList.add("gjemt");
			document.getElementById(felt).classList.remove("ugyldig");
			document.getElementById("passordRepetertServerFeil").classList.add("gjemt");
			return true;
		}
		//Egen håndtering for om kjønn er haket av
	} else if(felt === "kjonnM" || felt === "kjonnK" ){
		//Hent value i kjonn-radio-knappene
		let kjonnRadio = skjema.kjonn.value;
		if(kjonnRadio === ""){
			document.getElementById("kjonnFeil").classList.remove("gjemt");
			document.getElementById("kjonnServerFeil").classList.remove("gjemt");
			return false;
		} else{
			document.getElementById("kjonnFeil").classList.add("gjemt");
			document.getElementById("kjonnServerFeil").classList.add("gjemt");
			return true;
		}
	} else{
		//Håndtering for alle andre felt
		let aktueltRegExp;
		
		if(felt === "fornavn"){
			aktueltRegExp = /^[A-ZÆØÅ]([- ]*[a-zA-ZæøåÆØÅ]){1,19}$/;
		} else if(felt ==="etternavn"){
			aktueltRegExp = /^[A-ZÆØÅ]{1}[a-zA-ZæøåÆØÅ]{1,19}$/;
		} else if(felt === "mobil"){
			aktueltRegExp = /^[1-9]{1}[0-9]{7}$/;
		} else if(felt === "passord"){
			aktueltRegExp = /.{4,}/;
		}
		
		//Hent felt i skjema og tilhørende <p> for å skrive feilmeldinger
		let aktueltFelt = document.getElementById(felt);
		let feilFelt = felt+"Feil";
		let serverFeilFelt = felt+"ServerFeil";
		
		if(!aktueltRegExp.test(aktueltFelt.value)){
			document.getElementById(feilFelt).classList.remove("gjemt");
			document.getElementById(serverFeilFelt).classList.remove("gjemt");
			document.getElementById(felt).classList.add("ugyldig");
			return false;
		} else{
			document.getElementById(feilFelt).classList.add("gjemt");
			document.getElementById(felt).classList.remove("ugyldig");
			document.getElementById(serverFeilFelt).classList.add("gjemt");
			return true;
		}
	}

};
	
//Lag listener for når skjema forsøkes å sende inn
skjema.addEventListener("submit", event => {
	
	//Hent alle felt i skjema
	let alleFelt = document.getElementById("skjema").elements;
	
	let ok = true;
	
	/*
	 * Gå gjennom skjema - .elements gir array hvor fieldset er 0, og submit-knapper etc ligger etter aktuelle felt - sjekker derfor index 1-5
	 */
	for (let i = 1; i < 8; i++){
		if(!validerFelt(alleFelt[i].id)){
			event.preventDefault();
			ok = false;
		}
	}
	return ok;
	
});

//Legg til listener for passord-felt som validerer passord for hver input
document.getElementById("passord").addEventListener("input", event =>{
	let middels = /([a-z]{4,})|([A-Z]{4,})|([0-9]{4,})/;
	let sterkt = /[a-zA-Z0-9!”$%&’()*\+,\/;\[\]\\\^_`{|}~\+\$]{8,}/;
	
	let passordInput = document.getElementById("passord").value;
	let passordTilbakemelding = document.getElementById("passordTilbakemelding");
	if(sterkt.test(passordInput)){
		passordTilbakemelding.innerHTML = "Bra passord!";
		passordTilbakemelding.style.color="green";
	} else if(middels.test(passordInput)){
		passordTilbakemelding.innerHTML = "Ok passord! Vi anbefaler likevel et sterkere passord!";
		passordTilbakemelding.style.color="orange";
	} else{
		passordTilbakemelding.innerHTML = "Passord m&aring; v&aelig;re over 4 tegn!";
		passordTilbakemelding.style.color="red";
	}
})




