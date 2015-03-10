/**
 * Created by pablo on 10/03/2015.
 */
/**
 * Created by pablo on 09/03/2015.
 */

$(document).ready(function () {

    $('#detalleGrupo tbody tr td.infoP').click(function () {
        var id = $(this).closest('tr').find('td').eq(0).html();
        obtenerDetallesGrupo(id);
    });

    function obtenerDetallesGrupo(idGrupo){
        $('#datosGrupo').empty().addClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('#datosGrupo').load('/Grupos/ajax/grupo.do?idGrupo='+idGrupo+"&accion="+$('#accion').text());

        $('#datosGrupo').empty().removeClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('html, body').animate({
            scrollTop: $("#detalles").offset().top
        }, 1000);
    }


});
