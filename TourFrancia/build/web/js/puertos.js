$(document).ready(function ($) {
    $.ajax({
        url:   'GetPuertos',
        type:  'post',
        success:  function (response) {
            response = JSON.parse(response);
            var categorias = [];
            var selectCategorias = $("#puertoCategoria");
            var cromos = $("#cromosPuerto");
            for(var i = 0; i < response.length; i++){
                if($.inArray(response[i].NombreCategoria, categorias)==-1){
                    categorias.push(response[i].NombreCategoria);
                    selectCategorias.append("<option value=\""+response[i].IdCategoria+"\">"+response[i].NombreCategoria+"</option>");
                }
                cromos.append("<article class=\"cromoPuerto\"><span>"+textos[idioma].nombre+": "+response[i].Nombre+"</span><span>"+textos[idioma].alturaMaxima+": "+response[i].AltMax+"</span><span>"+textos[idioma].dorsal+": "+response[i].DorsalCiclista+"</span><span>"+textos[idioma].categoria+": "+response[i].NombreCategoria+"</span></article>");
            }
            
            //Ordernar el select
            $("#puertoCategoria").html($("#puertoCategoria option").sort(function (a, b) {
                return a.text == b.text ? 0 : a.text < b.text ? -1 : 1
            }));
            selectCategorias.prepend("<option value=\"-1\">"+textos[idioma].todos+"</option>");
        }
    });
});


function changeFiltroCategoria(value){
    var url;
    if(value == -1){
        url = "GetPuertos";
    }else{
        url = "PuertoCategoria";
    }
    $.ajax({
        data:  {idCat: value},
        url:   url,
        type:  'post',
        beforeSend: function () {
            $("#overlay").css("visibility", "visible");
            $("#overlay").css("opacity", "1");
            $("#overlay").html("<img src=\"img/load.gif\" alt=\"load\">");
        },
        success:  function (response) {
            response = JSON.parse(response);
            var cromos = $("#cromosPuerto");
            cromos.html("");
            for(var i = 0; i < response.length; i++){
                cromos.append("<article class=\"cromoPuerto\"><span>"+textos[idioma].nombre+": "+response[i].Nombre+"</span><span>"+textos[idioma].alturaMaxima+": "+response[i].AltMax+"</span><span>"+textos[idioma].dorsal+": "+response[i].DorsalCiclista+"</span><span>"+textos[idioma].categoria+": "+response[i].NombreCategoria+"</span></article>");
            }
            $("#overlay").css("visibility", "hidden");
            $("#overlay").css("opacity", "0");
            $("#overlay").html("");
        }
    });
}

function picosAltos(){
    $.ajax({
        data:  {},
        url:   "PuertoPicos",
        type:  'post',
        beforeSend: function () {
            $("#overlay").css("visibility", "visible");
            $("#overlay").css("opacity", "1");
            $("#overlay").html("<img src=\"img/load.gif\" alt=\"load\">");
        },
        success:  function (response) {
            response = JSON.parse(response);
            var cromos = $("#cromosPuerto");
            cromos.html("");
            for(var i = 0; i < response.length; i++){
                cromos.append("<article class=\"cromoPuerto\"><span>"+textos[idioma].nombre+": "+response[i].Nombre+"</span><span>"+textos[idioma].alturaMaxima+": "+response[i].AltMax+"</span><span>"+textos[idioma].dorsal+": "+response[i].DorsalCiclista+"</span><span>"+textos[idioma].categoria+": "+response[i].NombreCategoria+"</span></article>");
            }
            $("#overlay").css("visibility", "hidden");
            $("#overlay").css("opacity", "0");
            $("#overlay").html("");
        }
    });
}