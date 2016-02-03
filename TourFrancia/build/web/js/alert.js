function alerta(cadena, tipo){
    var nodo = $('<div/>');
    nodo.addClass(tipo);
    nodo.text(cadena);
    $('#alert').append(nodo);
    nodo.addClass('in');
    nodo.fadeTo(2000, 500).slideUp(1000, function(){
        nodo.removeClass('in');
    });
    setTimeout(function(){
        $(nodo).remove();
    }, 3100);
}
