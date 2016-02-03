$(".button-group li").click(function(){         
    $(this.parentNode.querySelector(".active")).removeClass("active");
    $(this.firstChild).addClass("active");
    fillSelectEtapas();
});

