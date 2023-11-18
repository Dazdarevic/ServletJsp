<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista valuta</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" 
crossorigin="anonymous"></script>
<style type="text/css">
body {
background-image: url("parice2.jpg");
}
</style>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
	  <a style="padding-left: 600px" class="navbar-brand" href="#">Lista valutnih kodova po drzavama</a>
</nav>
<div class="container" style="background: white; width: 1100px; min-height: 700px;">
	<div style="padding: 0 400px; padding-top: 50px;">
		<form method="GET" action="CurrencyConverter" >
		  <div class="form-group">
		    <label for="iznos">Unesite iznos u dinarima</label>
		    <input type="text" class="form-control" id="iznos" name = "iznos" aria-describedby="iznos"><br>
		  </div>
		  <div class="form-group">
		      <label for="valuta">Izaberite valutu</label>
		      <select id="valuta" name="valuta" class="form-select">
		        <option value="eur" selected>EUR</option>
		        <option value="usd">USD</option>
		        <option value="km">KM</option>
		        <option value="try">TRY</option>
		      </select>
		    </div>
		    <br>
		  <button type="submit" class="btn btn-primary">Konvertuj</button>
		  <br><br>
		  <div class="form-group">
		    <p style="color: green;">
		    	<% if(request.getParameter("q")!=null){out.print(" "  + request.getParameter("q"));} %>
		    </p>
		    <br>
		  </div>
		</form>
	</div>
</div>


</body>
</html>