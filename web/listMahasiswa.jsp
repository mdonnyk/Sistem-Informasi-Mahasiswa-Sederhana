
<%@page import="java.lang.Object"%>
<%@page import="Model.*"%>
<%@page import="controller.*"%>
<%
    DatabaseManager db = new DatabaseManager();
    Mahasiswa[] mhs = null;
    String cari = request.getParameter("cari");
        if (cari.compareTo("all")==0) {
            mhs = db.showMahasiswa();
        }
        else{
            String collumn = request.getParameter("collumn");
            mhs = db.cariMahasiswa(cari.toLowerCase(), collumn);
        }
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

						<article id="showMahasiswa" class="panel">
								<header>
									<h2>Daftar Mahasiswa</h2>
								</header>
                                                            <table>
                                                                <tr>
                                                                    <td>
                                                                        NIM
                                                                    </td>
                                                                    <td>
                                                                        Nama
                                                                    </td>
                                                                    <td>
                                                                        Total SKS
                                                                    </td>
                                                                    <td>
                                                                        
                                                                    </td>
                                                                </tr>
                                                                <%for (int i = 0; i < mhs.length; i++) { %>
                                                                <tr>
                                                                <form action="krs.jsp" method="post">
                                                                    <td>
                                                                        <%= mhs[i].getNim() %> 
                                                                    </td>
                                                                    <td>
                                                                        <%= mhs[i].getNama() %> 
                                                                    </td>
                                                                    <td>
                                                                        0
                                                                    </td>
                                                                    <td>
                                                                        <input type="hidden" name="nim" value="<%=mhs[i].getNim()%>" />
                                                                        <input type="submit" value="Lihat KRS" />
                                                                    </td>
                                                                 </form>
                                                                </tr>
                                                                <%}%>
                                                            </table>
								
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