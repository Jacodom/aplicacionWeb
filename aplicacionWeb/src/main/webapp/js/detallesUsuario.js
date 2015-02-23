/**
 * Created by Jacobo on 23/02/2015.
 */

$(document).ready(function (e) {

    //eventos
    $('#tableU tbody tr').click(function () {

        var id = $(this).find("td").eq(1).html();
        obtenerDetallesUsuario(id);
    });


    //funciones
    function obtenerDetallesUsuario(idUsuario){
        $('#datosUsuario').empty().addClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('#datosUsuario').load('/Usuarios/ajax/usuario.do?idUsuario='+idUsuario);

        $('#datosUsuario').empty().removeClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('html, body').animate({
            scrollTop: $("#datosUsuarios").offset().top
        }, 1000);
    }


});