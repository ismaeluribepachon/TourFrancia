<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/png" href="img/favicon.png"/>
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,500' rel='stylesheet' type='text/css'>
        <script src="js/jquery.js"></script>
        <script src="js/url.js"></script>
        <script src="js/textos.js"></script>
        <link rel="stylesheet" href="css/style.css">
        <title>Tour</title>
    </head>
    <body>
        <header class="header">
            <div class="flags">
                <a href="index.jsp?lang=es"><img src="img/banderas/es.png" alt="es"></a>
                <a href="index.jsp?lang=en"><img src="img/banderas/en.png" alt="en"></a>
            </div>
            <h1><script>document.write(textos[idioma].menu1);</script></h1>
            <a class="menu-launcher">
                <span></span>
            </a>
        </header>
        <nav class="nav-container">
            <ul class="nav-ul">
                <li class="selected"><a name="#"><script>document.write(textos[idioma].menu1);</script></a></li>
                <li><a name="ciclistas.jsp"><script>document.write(textos[idioma].menu2);</script></a></li>
                <li><a name="puertos.jsp"><script>document.write(textos[idioma].menu3);</script></a></li>
                <li><a name="etapas.jsp"><script>document.write(textos[idioma].menu4);</script></a></li>
                <li><a name="login.jsp">
                <%
                    if(session.getAttribute("userTour")== null){
                        out.println("<script>document.write(textos[idioma].menu5);</script>");
                    }else{
                        out.println("<script>document.write(textos[idioma].cerrarSesion);</script>"+" ("+session.getAttribute("userTour")+")");
                    }
                %></a></li>
            </ul>
            <span class="marker"></span>	
        </nav>
        <main>
            <section id="inicio1">
                <p><script>document.write(textos[idioma].textInicio11);</script></p>
                <p><script>document.write(textos[idioma].textInicio12);</script></p>
                <p><script>document.write(textos[idioma].textInicio13);</script></p>
            </section>
            <section id="inicioImg">
                <div></div>
            </section>
            <section id="inicio2">
                <p><script>document.write(textos[idioma].textInicio21);</script></p>
            </section>
        </main>
        <footer>
            <section>
                <p><script>document.write(textos[idioma].textFooter11);</script></p>
                <p><script>document.write(textos[idioma].textFooter12);</script></p>
                <br>
                <p><a href="mailto:ismaeluribepachon@gmail.com"><script>document.write(textos[idioma].textFooter13);</script></a></p>
                <p><a href="mailto:mariavillarescastillo@gmail.com"><script>document.write(textos[idioma].textFooter14);</script></a></p>
            </section>
            <section>
                <img src="img/logo.png" alt="tourLogo">
            </section>
            <section>
                <p><script>document.write(textos[idioma].textFooter31);</script></p>
                <a target="_blank" href="http://www.uah.es"><img src="img/uahLogo.gif" alt="uahLogo"></a>
            </section>
        </footer>
        <script src="js/main.js"></script>
    </body>
</html>