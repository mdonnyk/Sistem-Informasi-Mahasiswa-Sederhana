<%@page import="Model.*"%>
<%@page import="controller.*"%>
<!DOCTYPE HTML>
<%

%>
<html>
	<head>
		<title>WebProjectUSD</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

		<!-- Wrapper-->
			<div id="wrapper">

				<!-- Nav -->
					<nav id="nav">
						<a href="#me" class="icon fa-home active"><span>Home</span></a>
						<a href="#login" class="icon fa-key"><span>Login</span></a>
						<a href="#showMakul" class="icon fa-book"><span>Mata Kuliah</span></a>
					</nav>

				<!-- Main -->
					<div id="main">

						<!-- HOME -->
							<article id="me" class="panel">
								<header>
									<h1>Sistem Informasi</h1>
									<p>Universitas Sanata Dharma</p>
								</header>
								<a href="#login" class="jumplink pic">
									<span class="arrow icon fa-chevron-right"><span>See my work</span></span>
									<img src="images/me.jpg" alt="" />
								</a>
							</article>
							
							<!-- LOGIN -->
							<article id="login" class="panel">
								<header>
									<h2>LOGIN</h2>
								</header>
								<form action="Login" method="post">
									<div>
										<div class="row">
											<div class="6u 12u$(mobile)">
												<input type="text" name="nim" placeholder="NIM" />
											</div>
											<div class="6u$ 12u$(mobile)">
												<input type="password" name="pass" placeholder="Password" />
											</div>
											<div class="12u$">
												<input type="submit" value="Login" />
											</div>
										</div>
									</div>
								</form>
							</article>

						<!-- SHOW MAKUL -->
							<article id="showMakul" class="panel">
								<header>
									<h2>Daftar Matakuliah</h2>
								</header>
                                                                <%DatabaseManager m = new DatabaseManager();
                                                                    MataKuliah[] mk = m.showMataKuliah(); %>
                                                                <table>
                                                                    <tr>
                                                                        <td><b>Kode</b></td>
                                                                        <td><b>Nama</b></td>
                                                                        <td><b>Dosen</b></td>
                                                                        <td><b>SKS</b></td>
                                                                    </tr>
                                                                    <%for (int i = 0; i < mk.length; i++) {%>
                                                                    <tr>
                                                                        <td> 
                                                                            <%= mk[i].getKode() %>  
                                                                        </td>
                                                                        <td> 
                                                                            <%= mk[i].getNama() %> 
                                                                        </td>
                                                                        <td> 
                                                                            <%= mk[i].getDosen() %> 
                                                                        </td>
                                                                        <td> 
                                                                            <%= mk[i].getJumlahSKS() %> 
                                                                        </td>
                                                                    </tr>
                                                                    <%}%>
                                                                </table>
							</article>					

					</div>

				<!-- Footer -->
					<div id="footer">
						<ul class="copyright">
							<li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
						</ul>
					</div>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/skel-viewport.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>