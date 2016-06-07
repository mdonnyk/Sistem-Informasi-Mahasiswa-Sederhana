<%@page import="Model.Admin"%>
<%@page import="Model.Mahasiswa"%>
<%@page import="controller.DatabaseManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/error.jsp" %>
<%
    Admin a = (Admin) session.getAttribute("admin");
    
%>
<!DOCTYPE HTML>
<html>
	<head>
            <title>Administrator</title>
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
                                                <a href="#showMahasiswa" class="icon fa-users"><span>Mahasiswa</span></a>
                                                <a href="#setting" class="icon fa-wrench"><span>Setting</span></a>
					</nav>

				<!-- Main -->
					<div id="main">

						<!-- HOME -->
							<article id="me" class="panel">
								<header>
                                                                        <h1>Selamat Datang<br></h1>
                                                                        <p><%= a.getNama() %></p>
								</header>
                                                            
								
							</article>
							
						<!-- LIHAT MAHASISWA  -->
							<article id="showMahasiswa" class="panel">
								<header>
									<h2>Daftar Mahasiswa</h2>
								</header>
                                                            <form action="listMahasiswa.jsp">
                                                            <table>
                                                                <tr>
                                                                    <td>
                                                                        <input type="text" name="cari" placeholder="Keyword" />
                                                                    </td>
                                                                    <td>
                                                                        <select name="collumn">
                                                                            <option>nim</option>
                                                                            <option>nama</option>
                                                                        </select>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                                <input type="submit" value="Cari" />
                                                                <br>
                                                            </form>
                                                            <form action="listMahasiswa.jsp">
                                                                <input type="hidden" name="cari" value="all" />
                                                                <input type="submit" value="Lihat Semua" />
                                                            </form>
                                                            
                                                                
                                                                
                                                                
                                                            
								
							</article>	
                                                <!-- SETTING -->
							<article id="setting" class="panel">
								<header>
									<h2>Setting</h2>
								</header>
                                                            
                                                            <a href="Logout"><button>LOGOUT</button></a> 
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