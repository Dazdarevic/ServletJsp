<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Valute</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand">Valute</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Valute</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${valuta != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${valuta == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${valuta != null}">
            			Ažuriraj
            		</c:if>
						<c:if test="${valuta == null}">
            			Dodaj novu valutu
            		</c:if>
					</h2>
				</caption>

				<c:if test="${valuta != null}">
					<input type="hidden" name="id" value="<c:out value='${valuta.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Valuta</label> <input type="text"
						value="<c:out value='${valuta.naziv}' />" class="form-control"
						name="naziv" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Država</label> <input type="text"
						value="<c:out value='${valuta.drzava}' />" class="form-control"
						name="drzava">
				</fieldset>

				<fieldset class="form-group">
					<label>Vrednost</label> <input type="text"
						value="<c:out value='${valuta.vrednost}' />" class="form-control"
						name="vrednost">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>