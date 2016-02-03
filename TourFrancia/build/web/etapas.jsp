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
        <link rel="stylesheet" href="css/inputs.css" />
        <link rel="stylesheet" href="css/modal.css">
        <link rel="stylesheet" href="css/buttonGroup.css">
        <link rel="stylesheet" href="css/style.css">
        <title></title>
    </head>
    <body>
        <header class="header">
            <div class="flags">
                <a href="etapas.jsp?lang=es"><img src="img/banderas/es.png" alt="es"></a>
                <a href="etapas.jsp?lang=en"><img src="img/banderas/en.png" alt="en"></a>
            </div>
            <h1><script>document.write(textos[idioma].menu4);</script></h1>
            <a class="menu-launcher">
                <span></span>
            </a>
        </header>
        <nav class="nav-container">
            <ul class="nav-ul">
                <li><a name="index.jsp"><script>document.write(textos[idioma].menu1);</script></a></li>
                <li><a name="ciclistas.jsp"><script>document.write(textos[idioma].menu2);</script></a></li>
                <li><a name="puertos.jsp"><script>document.write(textos[idioma].menu3);</script></a></li>
                <li class="selected"><a name="etapas.jsp"><script>document.write(textos[idioma].menu4);</script></a></li>
                <li><a name="login.jsp"><%
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
            <section id="etapasBusqueda">
                <p><script>document.write(textos[idioma].textEtapas11);</script></p>
                <p><script>document.write(textos[idioma].textEtapas12);</script></p>
                <p><script>document.write(textos[idioma].textEtapas13);</script></p>
                <p><script>document.write(textos[idioma].textEtapas14);</script></p><br><br>
                <ul class="button-group">
                    <li><button class="active"><script>document.write(textos[idioma].etapa);</script></button></li>
                    <li><button><script>document.write(textos[idioma].maillot);</script></button></li>
                    <li><button><script>document.write(textos[idioma].ciclista);</script></button></li>
                </ul>
                <p>
                    <span class="input input--yoshiko">
                        <select onchange="changeFiltroEtapas(this)" class="input__field input__field--yoshiko" id="selectEtapas">
                            
                        </select>
                    </span> 
                </p>
                <section id="cromosEtapas">
                </section>
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
        <script src="js/buttonGroup.js"></script>
        <script src="js/etapas.js"></script>
    </body>
</html>