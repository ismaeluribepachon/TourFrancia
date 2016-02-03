document.querySelector("#textUser").setAttribute("data-content", textos[idioma].usuario);
document.querySelector("#inputUsuario").setAttribute("placeholder", textos[idioma].usuario.slice(0, -1));
document.querySelector("#textPass").setAttribute("data-content", textos[idioma].pass);
document.querySelector("#inputPassword").setAttribute("placeholder", textos[idioma].pass.slice(0, -1));

$(document).ready(function ($) {
    var error = getUrlValue("error");
    var errorSection = $("#errors");
    if(error != ""){
        switch(parseInt(error)){
            case 1:
                errorSection.append("<p>"+textos[idioma].error1+"</p>");
                break;
            case 2:
                errorSection.append("<p>"+textos[idioma].error2+"</p>");
                break;
            default:
                errorSection.append("<p>"+textos[idioma].errorDefault+"</p>");
        }
    }
});