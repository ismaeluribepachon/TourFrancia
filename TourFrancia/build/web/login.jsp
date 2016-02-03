<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.setAttribute("userTour", null);
%>
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
        <link rel="stylesheet" href="css/style.css">
        <title></title>
    </head>
    <body>
        <header class="header">
            <div class="flags">
                <a href="login.jsp?lang=es"><img src="img/banderas/es.png" alt="es"></a>
                <a href="login.jsp?lang=en"><img src="img/banderas/en.png" alt="en"></a>
            </div>
            <h1><script>document.write(textos[idioma].menu5);</script></h1>
            <a class="menu-launcher">
                <span></span>
            </a>
        </header>
        <nav class="nav-container">
            <ul class="nav-ul">
                <li><a name="index.jsp"><script>document.write(textos[idioma].menu1);</script></a></li>
                <li><a name="ciclistas.jsp"><script>document.write(textos[idioma].menu2);</script></a></li>
                <li><a name="puertos.jsp"><script>document.write(textos[idioma].menu3);</script></a></li>
                <li><a name="etapas.jsp"><script>document.write(textos[idioma].menu4);</script></a></li>
                <li class="selected"><a name="login.jsp"><%
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
            <section id="errors">
                
            </section>
            <section id="login">
                <br>
                <br>
               <form action="Login" method="post">
                   <p>
                       <script>document.write(textos[idioma].textLogin11);</script>
                   </p>
                    <p>
                        <span class="input input--yoshiko">
                            <input class="input__field input__field--yoshiko" id="inputUsuario" name="user" type="text"/>
                            <label class="input__label input__label--yoshiko" for="input-11">
                                <span class="input__label-content input__label-content--yoshiko" id="textUser">&nbsp;</span>
                            </label>
                        </span>
                    </p>
                    <p>
                        <span class="input input--yoshiko">
                            <input class="input__field input__field--yoshiko" id="inputPassword" name="pass" type="password"/>
                            <label class="input__label input__label--yoshiko" for="input-11">
                                <span class="input__label-content input__label-content--yoshiko" id="textPass">&nbsp;</span>
                            </label>
                        </span>
                    </p>
                    <br><br>
                    <button><script>document.write(textos[idioma].menu5);</script></button>
                </form>
                <br>
                <br>
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
        <script src="js/login.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>