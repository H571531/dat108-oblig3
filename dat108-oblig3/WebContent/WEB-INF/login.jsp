<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="main">
		<div class="orange">


			<h1>Velkommen til gruppe 22s fantastiske handleliste</h1>

			<div class="loginBoks">

				<form action="logginn" method="post">
					<fieldset>
						<legend>Login</legend>
						<p class="error">${feilmelding}</p>
						<p>
							Passord: <input type="password" name="passord" />
						</p>
						<p>
							<input type="submit" value="Logg inn" />
						</p>
					</fieldset>
				</form>
			</div>

		</div>
	</div>