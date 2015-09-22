<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Certificados Fatec ZL</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse"></button>
		</div>
		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
		</ul>
		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav">
				<li class="active"><a href="http://www.fateczl.edu.br"
					target="_blank"><img alt="FATEC ZONA LESTE"
						src="./images/fateczl.png" height="90" width="196"></a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse --> </nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Certificados de Eventos <small>1� Semestre de 2013 a 1�
								Semestre de 2015</small>
						</h1>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="row">
						<div class="col-lg-6 text-center">
							<div class="panel panel-default">
								<div class="panel-body">
									<form action="palestras" method="post">
										<div class="table-responsive">
											<table class="table table-bordered table-hover table-striped">
												<tr>
													<td colspan="3" align="center">PALESTRAS</td>
												</tr>
												<tr>
													<td>RA</td>
													<td>Nome</td>
													<td></td>
												</tr>
												<c:forEach items="${listaPalestras }" var="palestra">
													<tr>
														<td><c:out value="${palestra.ra }" /></td>
														<td><c:out value="${palestra.titulo }" /></td>
														<td><a
															href="${pageContext.request.contextPath}/certificados?ra=<c:out value=" ${palestra.ra }"/>&titulo=<c:out
																value="${palestra.titulo }" />"
															target="_blank"> <img alt="Download"
																src="./images/pdficone.png" height="36" width="36">
														</a></td>
													</tr>
												</c:forEach>
												<tr>
													<td colspan="3">
														<a href="index.jsp"><button type="button" class="btn btn-lg btn-info">Sair</button></a>
													</td>
												</tr>
											</table>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Morris Charts JavaScript -->
	<script src="js/plugins/morris/raphael.min.js"></script>
	<script src="js/plugins/morris/morris.min.js"></script>
	<script src="js/plugins/morris/morris-data.js"></script>

</body>

</html>
