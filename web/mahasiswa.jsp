
<%@page import="java.lang.Object"%>
<%@page import="Model.*"%>
<%@page import="controller.*"%>
<%
    DatabaseManager db = new DatabaseManager();
    Mahasiswa mhs = (Mahasiswa) session.getAttribute("mahasiswa");
    MataKuliah[] mk = mhs.getMakul(); 
    MataKuliah[] pmk = db.showMataKuliah();%>
<!DOCTYPE HTML>
<html>
	<head>
            <title><%= mhs.getNama() %></title>
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
						<a href="#showMakul" class="icon fa-book"><span>KRS</span></a>
                                                <a href="#pilihMakul" class="icon fa-plus-circle"><span>Mata Kuliah</span></a>
                                                <a href="#setting" class="icon fa-wrench"><span>Setting</span></a>
                                                
					</nav>

				<!-- Main -->
					<div id="main">

						<!-- HOME -->
							<article id="me" class="panel">
								<header>
                                                                        <h1>Selamat Datang<br></h1>
									<p>
                                                                        <%= mhs.getNama() %>
                                                                        <br>
                                                                            <%= mhs.getNim()%></p>
								</header>
								
							</article>
							
						<!-- PILIH MATA KULIAH  -->
							<article id="pilihMakul" class="panel">
								<header>
									<h2>Daftar Matakuliah</h2>
								</header>
                                                                
                                                                <table>
                                                                    <tr>
                                                                        <td><b>Kode</b></td>
                                                                        <td><b>Nama</b></td>
                                                                        <td><b>Dosen</b></td>
                                                                        <td><b>SKS</b></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <%for (int i = 0; i < pmk.length; i++) {%>
                                                                    <tr>
                                                                        <form action="TambahMataKuliah" method="post">
                                                                            <td> 
                                                                                <%= pmk[i].getKode() %>  
                                                                            </td>
                                                                            <td> 
                                                                                <%= pmk[i].getNama() %> 
                                                                            </td>
                                                                            <td> 
                                                                                <%= pmk[i].getDosen() %> 
                                                                            </td>
                                                                            <td> 
                                                                                <%= pmk[i].getJumlahSKS() %> 
                                                                            </td>
                                                                            <td>
                                                                                <input type="hidden" name="kode" value="<%= pmk[i].getKode() %>" />
                                                                                <input type="hidden" name="sks" value="<%= pmk[i].getJumlahSKS()%>" />
                                                                                <input type="submit" value="tambah" />
                                                                            </td>
                                                                       </form>
                                                                    </tr>
                                                                    <%}%>
                                                                </table>
                                                            
								
							</article>	

						<!-- SHOW MAKUL -->
							<article id="showMakul" class="panel">
								<header>
									<h2>Daftar Matakuliah</h2>
								</header>
                                                                
                                                            <form action="krs.jsp" method="post">
                                                                <input type="hidden" name="nim" value="<%=mhs.getNim()%>" />
                                                                <input type="submit" value="Lihat KRS" />
                                                            </form>                                                            
							</article>	
                                                                
                                                <!-- SETTING -->
							<article id="setting" class="panel">
								<header>
									<h2>Setting</h2>
								</header>
                                                            
                                                            <a href="Logout"><button>LOGOUT</button></a>
                                                            <form action="UpdatePassword" method="POST">
                                                                <br>password lama :<input type="password" name="passLama" value="" />
                                                                <br>password baru :<input type="password" name="passBaru" value="" />
                                                                <br><input type="submit" value="update" />
                                                            </form>
                                                            
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