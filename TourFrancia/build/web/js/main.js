$(document).ready(function ($) {
    $('.marker').css({
        'left': $('.selected').offset().left
    });
    //toggle 3d navigation
    $('.menu-launcher').on('click', function () {
        toggle3D(!$('.header').hasClass('nav-is-visible'));
        setTimeout(function(){
            $('.marker').css({
                'left': $('.selected').offset().left
            });
        }, 350);
        
    });

    //select a new item from the 3d navigation
    $('.nav-ul a').on('click', function () {
        var selected = $(this);
        var select = this;
        var url = select.name;
        selected.parent('li').addClass('selected').siblings('li').removeClass('selected');
        updateSelectedNav('close');
        switch(idioma){
            case 0:
                url = url+"?lang=es";
                break;
            case 1:
                url = url+"?lang=en";
                break;
        }
        setTimeout(function(){
            window.location = url;
        }, 1000);
    });

    $(window).on('resize', function () {
        window.requestAnimationFrame(updateSelectedNav);
    });    
});

function toggle3D(addOrRemove) {
    if (typeof (addOrRemove) == 'undefined')
        addOrRemove = true;
    $('.header').toggleClass('nav-is-visible', addOrRemove);
    $('main').toggleClass('nav-is-visible', addOrRemove);
    $('footer').toggleClass('nav-is-visible', addOrRemove);
    $('.nav-container').toggleClass('nav-is-visible', addOrRemove);
}

function updateSelectedNav(type) {
    var selectedItem = $('.selected'),
            selectedItemPosition = selectedItem.index() + 1,
            leftPosition = selectedItem.offset().left,
            backgroundColor = selectedItem.data('color');

    $('.marker').css({
        'left': leftPosition
    });
    if (type == 'close') {
        $('.marker').one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
            $('.marker').css({
                'left': $('.selected').offset().left
            });
            toggle3D(false);
        });
    }
}

