/**
 * Created by Jacobo on 03/03/2015.
 */
$(document).ready(function () {

    //eventos
    $('#tableP tbody tr').click(function () {

        var id = $(this).find("td").eq(0).html();
        obtenerDetallesPerfil(id);
    });


    //funciones
    function obtenerDetallesPerfil(idPerfil){
        $('#detallesPerfil').empty().addClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('#detallesPerfil').load('/Perfiles/ajax/perfil.do?idPerfil='+idPerfil+"&accion="+$('#accion').text());

        $('#detallesPerfil').empty().removeClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('html, body').animate({
            scrollTop: $("#detalles").offset().top
        }, 1000);
    }


});