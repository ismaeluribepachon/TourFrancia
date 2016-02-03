document.querySelector("#textBuscarCiclista").setAttribute("data-content", textos[idioma].textCiclistas12);
document.querySelector("#listCiclistas").setAttribute("placeholder", textos[idioma].textCiclistas12);

function changeFiltroEquipos(value) {
    var url;
    if (value.options[value.selectedIndex].text === textos[idioma].todos) {
        url = "CiclistasNombre";
    } else {
        url = "CiclistasEquipo";
    }
    console.log(url);
    console.log(value.options[value.selectedIndex].text);
    $.ajax({
        data: {nombre: value.options[value.selectedIndex].text},
        url: url,
        type: 'post',
        beforeSend: function () {
            $("#overlay").css("visibility", "visible");
            $("#overlay").css("opacity", "1");
            $("#overlay").html("<img src=\"img/load.gif\" alt=\"load\">");
        },
        success: function (response) {
            response = JSON.parse(response);
            console.log(response);
            var cromos = $("#cromosCiclistas");
            cromos.html("");
            for (var i = 0; i < response.length; i++) {
                cromos.append("<article class=\"cromoCiclista\"><span>" + textos[idioma].nombre + ": " + response[i].nombre + "</span><br><span>" + textos[idioma].dorsal + ": " + response[i].numDorsal + "</span><br><span>" + textos[idioma].equipo + ": " + response[i].nEquipo + "</span></article>");
            }
            $("#overlay").css("visibility", "hidden");
            $("#overlay").css("opacity", "0");
            $("#overlay").html("");
        }
    });
}

$(document).ready(function ($) {
    var equipos = [];
    var objEquipos = [];
    ciclistas = [];
    $.ajax({
        url: 'CiclistasNombre',
        type: 'post',
        success: function (response) {
            response = JSON.parse(response);
            var datalist = $("#dataListCiclistas");
            var cromos = $("#cromosCiclistas");
            var selectEquipos = $("#listaEquipos");
            selectEquipos.append("<option value=\"-1\">" + textos[idioma].todos + "</option>");
            for (var i = 0; i < response.length; i++) {
                if ($.inArray(response[i].idEquipo, equipos) === -1) {
                    equipos.push(response[i].idEquipo);
                    objEquipos.push({id: response[i].idEquipo, nombre: response[i].nEquipo});
                    selectEquipos.append("<option value=\"" + response[i].idEquipo + "\">" + response[i].nEquipo + "</option>");
                }
                cromos.append("<article class=\"cromoCiclista\"><span>" + textos[idioma].nombre + ": " + response[i].nombre + "</span><br><span>" + textos[idioma].dorsal + ": " + response[i].numDorsal + "</span><br><span>" + textos[idioma].equipo + ": " + response[i].nEquipo + "</span></article>");
                ciclistas.push(response[i].nombre);
                datalist.append("<option value=\"" + response[i].nombre + "\">" + response[i].nombre + "</option>");
            }
            if (document.querySelector(".md-modal") !== null) {

                $.ajax({
                    url: 'Equipos',
                    type: 'post',
                    success: function (response) {
                        response = JSON.parse(response);
                        console.log(response);
                        var selectEquipos = $("#equipoCiclista");
                        var selectEquiposEdit = $("#equipoCiclistaEditar");
                        selectEquipos.html("");
                        document.querySelector("#nombreCiclista").setAttribute("placeholder", textos[idioma].nombre);
                        document.querySelector("#dorsalCiclista").setAttribute("placeholder", textos[idioma].dorsal);
                        document.querySelector("#nombreEquipo").setAttribute("placeholder", textos[idioma].nombre);
                        document.querySelector("#directorEquipo").setAttribute("placeholder", textos[idioma].director);
                        for (var i = 0; i < response.length; i++) {
                            selectEquiposEdit.append("<option value=\"" + response[i].IdEquipo + "\">" + response[i].Nombre + "</option>");
                            selectEquipos.append("<option value=\"" + response[i].IdEquipo + "\">" + response[i].Nombre + "</option>");
                        }
                    }
                });
            }
        }
    });
});

function getEquipoCiclista() {
    if (document.querySelector("#listCiclistas").value !== "") {
        $("#listCiclistas").css({
            border: "2px solid rgba(255, 0, 0, 0)"
        });
        $.ajax({
            data: {nombre: document.querySelector("#listCiclistas").value},
            url: 'EquipoCiclista',
            type: 'post',
            beforeSend: function () {
                $("#overlay").css("visibility", "visible");
                $("#overlay").css("opacity", "1");
                $("#overlay").html("<img src=\"img/load.gif\" alt=\"load\">");
            },
            success: function (response) {
                response = JSON.parse(response);
                if (response !== -1) {
                    var cromo = $("#busquedaCiclista article");
                    cromo.html("");
                    cromo.append("<span>" + textos[idioma].nombre + ": " + response.Nombre + "</span><br><br>")
                    cromo.append("<span>" + textos[idioma].director + ": " + response.Director + "</span>")
                    cromo.fadeIn(300);
                } else {
                    $("#listCiclistas").css({
                        border: "2px solid rgba(255, 0, 0, 0.8)"
                    });
                }
                $("#overlay").css("visibility", "hidden");
                $("#overlay").css("opacity", "0");
                $("#overlay").html("");
            }
        });
    } else {
        $("#listCiclistas").css({
            border: "2px solid rgba(255, 0, 0, 0.8)"
        });
    }

}

$(".button-group li").click(function () {
    $(this.parentNode.querySelector(".active")).removeClass("active");
    $(this.firstChild).addClass("active");
    if ($(this.parentNode.querySelector(".active")).html().indexOf(textos[idioma].ciclista) === -1) {
        $("#addCiclistaModal").fadeOut(0);
        $("#addEquipoModal").fadeIn(300);
    } else {
        $("#addEquipoModal").fadeOut(0);
        $("#addCiclistaModal").fadeIn(300);
    }
});

function saveAdd() {
    var url;
    var data;
    if ($("#modalAdd .active").html().indexOf(textos[idioma].ciclista) === -1) {
        url = "AddEquipo";
        data = {nombre: $("#nombreEquipo").val(), director: $("#directorEquipo").val()};
    } else {
        url = "AddCiclista";
        data = {nombre: $("#nombreCiclista").val(), dorsal: $("#dorsalCiclista").val(), equipo: $("#equipoCiclista").val()};
    }
    $.ajax({
        data: data,
        url: url,
        type: 'post',
        success: function (response) {
            response = JSON.parse(response);
            if (response) {
                alerta(textos[idioma].insercionCorrecta, "success");
            } else {
                alerta(textos[idioma].insercionErronea, "error");
            }
        }
    });
}

function inputCiclistas() {
    
    if (document.querySelector(".md-modal") !== null) {
        if (ciclistas.indexOf($("#listCiclistas").val()) != -1) {
            $("#mensajeCiclista").html(textos[idioma].textModalMenos+$("#listCiclistas").val()+"?");
            $(".button-menos").prop("disabled", false);
            $(".button-editar").prop("disabled", false);
        } else {
            $(".button-menos").prop("disabled", true);
            $(".button-editar").prop("disabled", true);
        }
    }
}

function delCiclista(){
    if (document.querySelector(".md-modal") !== null) {
        $.ajax({
            data: {nombre:$("#listCiclistas").val()},
            url: "DeleteCiclista",
            type: 'post',
            success: function (response) {
                response = JSON.parse(response);
                if (response) {
                    alerta(textos[idioma].eliminacionCorrecta, "success");
                } else {
                    alerta(textos[idioma].eliminacionErronea, "error");
                }
            }
        });
    }
}

function updateCiclista(){
    if (document.querySelector(".md-modal") !== null) {
        $.ajax({
            data: {nombre:$("#nombreCiclistaEditar").val(), dorsal: $("#dorsalCiclistaEditar").val(), equipo: $("#equipoCiclistaEditar").val()},
            url: "UpdateCiclista",
            type: 'post',
            success: function (response) {
                response = JSON.parse(response);
                if (response) {
                    alerta(textos[idioma].edicioncorrecta, "success");
                } else {
                    alerta(textos[idioma].edicionfallida, "error");
                }
            }
        });
    }
}


function loadCiclista(){
    if (document.querySelector(".md-modal") !== null) {
        $.ajax({
            data: {nombre:$("#listCiclistas").val()},
            url: "CiclistaPorNombre",
            type: 'post',
            success: function (response) {
                response = JSON.parse(response);
                if (response!=-1) {
                    console.log(response);
                    $("#nombreCiclistaEditar").val(response.nombre);
                    $("#dorsalCiclistaEditar").val(response.numDorsal);
                    $("#equipoCiclistaEditar").val(response.idEquipo);
                }
            }
        });
    }
}