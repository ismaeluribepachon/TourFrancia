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
        <link rel="stylesheet" href="css/alert.css"/>
        <script src="js/alert.js"></script>
        <title></title>
    </head>
    <body>
        <div id="alert"></div>
        <%
            if (session.getAttribute("userTour") != null) {
                out.println("<div id=\"alert\"></div><div class=\"md-modal md-effect\" id=\"modalAdd\">\n" +
"            <div class=\"md-content\">\n" +
"                <h3><script>document.write(textos[idioma].titulomodalMas);</script></h3>\n" +
"                <div>\n" +
"                    <p><script>document.write(textos[idioma].textModalMas);</script></p>\n" +
"                    <ul class=\"button-group\">\n" +
"                        <li><button class=\"active\"><script>document.write(textos[idioma].ciclista);</script></button></li>\n" +
"                        <li><button><script>document.write(textos[idioma].equipo);</script></button></li>\n" +
"                    </ul>\n" +
"                    <section id=\"addCiclistaModal\">\n" +
"                        <span class=\"input input--yoshiko\">\n" +
"                            <input class=\"input__field input__field--yoshiko\" id=\"nombreCiclista\" type=\"text\"/>\n" +
"                        </span>\n" +
"                        <span class=\"input input--yoshiko\">\n" +
"                            <input class=\"input__field input__field--yoshiko\" id=\"dorsalCiclista\" type=\"text\"/>\n" +
"                        </span>\n" +
"                        <span class=\"input input--yoshiko\">\n" +
"                            <select class=\"input__field input__field--yoshiko\" id=\"equipoCiclista\"></select>\n" +
"                        </span>\n" +
"                    </section>\n" +
"                    <section id=\"addEquipoModal\" style=\"display: none;\">\n" +
"                        <span class=\"input input--yoshiko\">\n" +
"                            <input class=\"input__field input__field--yoshiko\" id=\"nombreEquipo\" type=\"text\"/>\n" +
"                        </span>\n" +
"                        <span class=\"input input--yoshiko\">\n" +
"                            <input class=\"input__field input__field--yoshiko\" id=\"directorEquipo\" type=\"text\"/>\n" +
"                        </span>\n" +
"                    </section>\n" +
"                    <section class=\"inline md-close\">\n" +
"                        <button onclick=\"saveAdd();\"><script>document.write(textos[idioma].titulomodalMas);</script></button>\n" +
"                        <button><script>document.write(textos[idioma].cancelar);</script></button>\n" +
"                    </section>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"        <div class=\"md-modal md-effect\" id=\"modalDel\">\n" +
"            <div class=\"md-content\">\n" +
"                <h3><script>document.write(textos[idioma].titulomodalMenos);</script></h3>\n" +
"                <div>\n" +
"                    <p id=\"mensajeCiclista\"></p>\n" +
"                    <br>\n" +
"                    <section class=\"inline md-close\">\n" +
"                        <button onclick=\"delCiclista()\"><script>document.write(textos[idioma].eliminar);</script></button>\n" +
"                        <button><script>document.write(textos[idioma].cancelar);</script></button>\n" +
"                    </section>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>\n" +
"        <div class=\"md-modal md-effect\" id=\"modalEdit\">\n" +
"            <div class=\"md-content\">\n" +
"                <h3><script>document.write(textos[idioma].titulomodalEditar);</script></h3>\n" +
"                <div>\n" +
"                    <p><script>document.write(textos[idioma].textModalEditar);</script></p>\n" +
"                    <br>\n" +
"                    <section id=\"EditCiclista\">\n" +
"                        <span class=\"input input--yoshiko\">\n" +
"                            <input class=\"input__field input__field--yoshiko\" id=\"nombreCiclistaEditar\" type=\"text\"/>\n" +
"                        </span>\n" +
"                        <span class=\"input input--yoshiko\">\n" +
"                            <input class=\"input__field input__field--yoshiko\" id=\"dorsalCiclistaEditar\" type=\"text\"/>\n" +
"                        </span>\n" +
"                        <span class=\"input input--yoshiko\">\n" +
"                            <select class=\"input__field input__field--yoshiko\" id=\"equipoCiclistaEditar\"></select>\n" +
"                        </span>\n" +
"                    </section>\n" +
"                    <section class=\"inline md-close\">\n" +
"                        <button onclick=\"updateCiclista()\"><script>document.write(textos[idioma].editar);</script></button>\n" +
"                        <button><script>document.write(textos[idioma].cancelar);</script></button>\n" +
"                    </section>\n" +
"                </div>\n" +
"            </div>\n" +
"        </div>");
            }
        %>
        <header class="header">
            <div class="flags">
                <a href="ciclistas.jsp?lang=es"><img src="img/banderas/es.png" alt="es"></a>
                <a href="ciclistas.jsp?lang=en"><img src="img/banderas/en.png" alt="en"></a>
            </div>
            <h1><script>document.write(textos[idioma].menu2);</script></h1>
            <a class="menu-launcher">
                <span></span>
            </a>
        </header>
        <nav class="nav-container">
            <ul class="nav-ul">
                <li><a name="index.jsp"><script>document.write(textos[idioma].menu1);</script></a></li>
                <li class="selected"><a name="ciclistas.jsp"><script>document.write(textos[idioma].menu2);</script></a></li>
                <li><a name="puertos.jsp"><script>document.write(textos[idioma].menu3);</script></a></li>
                <li><a name="etapas.jsp"><script>document.write(textos[idioma].menu4);</script></a></li>
                <li><a name="login.jsp"><%
                    if (session.getAttribute("userTour") == null) {
                        out.println("<script>document.write(textos[idioma].menu5);</script>");
                    } else {
                        out.println("<script>document.write(textos[idioma].cerrarSesion);</script>" + " (" + session.getAttribute("userTour") + ")");
                    }
                        %></a></li>
            </ul>
            
            <span class="marker"></span>	
        </nav>
        <main>
            <section id="busquedaCiclista">
                <p><script>document.write(textos[idioma].textCiclistas11);</script></p>
                <p>
                    <span class="input input--yoshiko">
                        <input oninput="inputCiclistas()" list="dataListCiclistas" class="input__field input__field--yoshiko" id="listCiclistas" type="text"/>
                        <label class="input__label input__label--yoshiko" for="input-11">
                            <span class="input__label-content input__label-content--yoshiko" id="textBuscarCiclista">&nbsp;</span>
                        </label>
                    </span>
                </p>
                <datalist id="dataListCiclistas">

                </datalist>
                <%
                    if (session.getAttribute("userTour") != null) {
                        out.println("<br><section class=\"btn-admin\"><button class=\"button-mas md-trigger md-setperspective\" data-modal=\"modalAdd\"></button><button class=\"button-menos md-trigger md-setperspective\" data-modal=\"modalDel\" disabled></button><button class=\"button-editar md-trigger md-setperspective\" data-modal=\"modalEdit\" disabled onclick=\"loadCiclista();\"></button></section>");
                    }
                %>
                <br>
                <button onclick="getEquipoCiclista();"><script>document.write(textos[idioma].buscar);</script></button>
                <article class="cromoEquipo"></article>
            </section>


            <section id="busquedaEquipo">
                <p><script>document.write(textos[idioma].textCiclistas21);</script></p>
                <p><script>document.write(textos[idioma].textCiclistas22);</script></p>
                <p>
                    <span class="input input--yoshiko">
                        <select onchange="changeFiltroEquipos(this)" list="dataListCiclistas" class="input__field input__field--yoshiko" id="listaEquipos">

                        </select>
                    </span> 
                </p>
                <section id="cromosCiclistas" class="cromosCiclistas">

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
        <div id="overlay" class="md-overlay"></div>
        <script src="js/classie.js"></script>
        <script src="js/modal.js"></script>
        <script src="js/main.js"></script>
        <script src="js/ciclistas.js"></script>
    </body>
</html>