/**
 * Created by Jacobo on 03/03/2015.
 */

/**
 * Created by Jacobo on 17/02/2015.
 */

$(document).ready(function(){

    //eventos
    iniciarPaginacion();

    $('.numerador').click(function(e){
        var nroPaginaActual = parseInt($(this).text());
        var nroPaginaSiguiente = nroPaginaActual+1;
        var nroPaginaAnterior = nroPaginaActual-1;

        if(nroPaginaAnterior===0){
            $('#anterior').addClass('disabled');
        }else{
            $('#anterior').removeClass('disabled');
        }

        if($(this).is('.numerador:last')){
            $('#siguiente').addClass('disabled');
        }else{
            $('#siguiente').removeClass('disabled');
        }

        cargarPerfiles(nroPaginaActual);
    });

    $('#siguiente').click(function (e) {


        if($(this).hasClass('disabled')){
            return;
        }else{
            var nroPaginaActual = parseInt($('.numerador.active').text());
            var nroPaginaSiguente = nroPaginaActual+1;

            cargarPerfiles(nroPaginaSiguente);

            if(nroPaginaActual===1){
                $('#anterior').removeClass('disabled');
            }

            if($('.numerador.active').is('.numerador:last')){
                $('#siguiente').addClass('disabled');
            }else{
                $('#siguiente').removeClass('disabled');
            }

        }
    });

    $('#anterior').click(function (e){
        if($(this).hasClass('disabled')){
            return;
        }else{
            var nroPaginaActual = parseInt($('.numerador.active').text());
            var nroPaginaAnterior = nroPaginaActual-1;

            cargarPerfiles(nroPaginaAnterior);

            if(nroPaginaAnterior===1){
                $('#anterior').addClass('disabled');
            }

            if(!$('numerador.active').is('.numerador:last')){
                $('#siguiente').removeClass('disabled');
            }


        }


    });


    //funciones



    function iniciarPaginacion(){
        $('#pag1').addClass('active');
        $('#anterior').addClass('disabled');
        cargarPerfiles($('.numerador.active').text());
    }

    function cargarPerfiles(nroPagina){


        $('#tablaPerfiles').empty().addClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('#tablaPerfiles').load('/Perfiles/ajax/perfiles.do?pg='+nroPagina);

        $('#tablaPerfiles').empty().removeClass('fa fa-circle-o-notch fa-spin fa-4x');


        $('.numerador.active').removeClass('active');
        $('#pag'+ nroPagina ).addClass('active');


    }
});