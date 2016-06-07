<%@page import="java.lang.Object"%>
<%@page import="Model.*"%>
<%@page import="controller.*"%>
<%
    DatabaseManager db = new DatabaseManager();
    Mahasiswa mhs = (Mahasiswa) session.getAttribute("mahasiswa");
    MataKuliah[] mk;
    
        mk = db.showMataKuliah(request.getParameter("nim"));
    
    int totSKS = 0;
%>
<!DOCTYPE HTML>
<html>
	<head>
            <title>KRS</title>
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

				<!-- Main -->
					<div id="main">

						<!-- HOME -->
							<article id="KRS" class="panel">
								<header>
                                                                        <header>
									<h2>Kartu Rencana Studi</h2>
                                                                        </header>
                                                                        <table>
                                                                            <tr>
                                                                                <td><b>Kode</b></td>
                                                                                <td><b>Nama</b></td>
                                                                                <td><b>Dosen</b></td>
                                                                                <td><b>SKS</b></td>
                                                                                <td><b></b></td>
                                                                            </tr>
                                                                            <%for (int i = 0; i < mk.length; i++) {
                                                                                totSKS = totSKS+mk[i].getJumlahSKS();
                                                                            %>
                                                                            <tr>
                                                                            <form action="HapusMataKuliah" method="post">
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
                                                                                <td> 
                                                                                    <input type="hidden" name="sks" value="<%= mk[i].getJumlahSKS() %>" />
                                                                                    <input type="hidden" name="kode" value="<%= mk[i].getKode() %>" />
                                                                                    <input type="submit" value="hapus" />
                                                                                </td>
                                                                                </form>
                                                                             </tr>
                                                                            <%}%>
                                                                        </table>
                                                                        Total SKS = <%= totSKS %>
								</header>
								
							</article>

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