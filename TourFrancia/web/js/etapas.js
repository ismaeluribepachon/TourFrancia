fillSelectEtapas();

function fillSelectEtapas(){
    var url;
    var inner = document.querySelector("#etapasBusqueda .active").innerHTML;
    if(inner.indexOf(textos[idioma].etapa) > -1){
        url = "EtapasTodas";
    }else if(inner.indexOf(textos[idioma].maillot) > -1){
        url = "MaillotsTodos";
    }else{
        url = "CiclistasNombre";
    }
    $.ajax({
        url:   url,
        type:  'post',
        success:  function (response) {
            response = JSON.parse(response);
            var selectEtapas = $("#selectEtapas");
            selectEtapas.html("");
            if(inner.indexOf(textos[idioma].etapa) > -1){
                for(var i = 0; i < response.length; i++){
                    selectEtapas.append("<option value=\""+response[i].NumEtapa+"\">"+response[i].NumEtapa+" "+response[i].CiudadSalida+" - "+response[i].CiudadEntrada+"</option>");
                }
            }else if(inner.indexOf(textos[idioma].maillot) > -1){
                for(var i = 0; i < response.length; i++){
                    selectEtapas.append("<option value=\""+response[i].Codigo+"\">"+response[i].Color+" - "+response[i].Tipo+"</option>");
                }
            }else{
               for(var i = 0; i < response.length; i++){
                    selectEtapas.append("<option value=\""+response[i].idCiclista+"\">"+response[i].nombre+" - "+response[i].numDorsal+"</option>");
                }
            }
            changeFiltroEtapas();
        }
    });
}


function changeFiltroEtapas(){
    var url;
    var inner = document.querySelector("#etapasBusqueda .active").innerHTML;
    if(inner.indexOf(textos[idioma].etapa) > -1){
        url = "PorEtapas";
    }else if(inner.indexOf(textos[idioma].maillot) > -1){
        url = "PorMaillot";
    }else{
        url = "PorCiclista";
    }
    $.ajax({
        data: {data: $("#selectEtapas").val()},
        url:   url,
        type:  'post',
        success:  function (response) {
            response = JSON.parse(response);
            var cromos = $("#cromosEtapas");
            cromos.html("");
            for(var i = 0; i < response.length; i++){
                cromos.append("<article class=\"cromoEtapa\"><span>"+textos[idioma].etapa+": "+response[i].NumEtapa+"</span><br><span>"+textos[idioma].maillot+": "+response[i].Color+"</span><br><span>"+textos[idioma].ciclista+": "+response[i].Nombre+"</span></article>");
            }
        }
    });
}