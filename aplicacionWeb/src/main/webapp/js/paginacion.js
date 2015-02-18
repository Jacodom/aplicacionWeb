/**
 * Created by Jacobo on 17/02/2015.
 */

$(document).ready(function(){

    //eventos
    iniciarPaginacion();
    $('.numerador').click(function(e){
        cargarUsuarios($(this).text());
    });




    //funciones



    function iniciarPaginacion(){
        $('#pag1').addClass('active');
        cargarUsuarios($('.numerador.active').text());
    }

    function cargarUsuarios(nroPagina){


        $('#tablaUsuarios').empty().addClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('#tablaUsuarios').load('/Usuarios/ajax/usuarios.do?pg='+nroPagina);

        $('#tablaUsuarios').empty().removeClass('fa fa-circle-o-notch fa-spin fa-4x');


        $('.numerador.active').removeClass('active');
        $('#pag'+ nroPagina ).addClass('active');


    }
});