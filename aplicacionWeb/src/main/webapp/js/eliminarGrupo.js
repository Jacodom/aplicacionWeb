/**
 * Created by pablo on 10/03/2015.
 */
$(document).ready(function() {

    $('#confirmarModal').on('show.bs.modal', function (e) {
        iniciarModal();
        $('#grupoID').hide();
        var id = $(e.relatedTarget).data('grupo-id');
        $(e.currentTarget).find('p[name="grupoID"]').text(id);
    });

    $("#aceptarModal").click(function () {
        if ($.trim($(this).html()) == 'Eliminar' || $.trim($(this).html()) == 'Reintentar') {
            eliminarGrupo($('#grupoID').text());
        } else {
            cargarGrupos(parseInt($('.numerador.active').text()));
            $('#confirmarModal').modal('toggle');
            $('.modal-backdrop').remove();
            $('body').removeClass('modal-open');
            $('#datosGrupo').empty();

        }
    });
    function cargarGrupos(nroPagina) {

        $('#tablaGrupos').empty().addClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('#tablaGrupos').load('/Grupos/ajax/grupos.do?pg='+nroPagina+"&accion="+$('#accion').text());

        $('#tablaGrupos').empty().removeClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('.numerador.active').removeClass('active');
        $('#pag' + nroPagina).addClass('active');

    }

    function iniciarModal() {
        $('#mensajeModal').removeClass('alert alert-danger alert-success');
        $('#mensajeModal h3').text("¿Realmente desea eliminar el grupo seleccionado?");
        $('#aceptarModal').html('Eliminar');
    }

    function deshabilitarElementos() {
        $('.modal-footer .btn').prop('disabled', true);
    }

    function habilitarElementos() {
        $('.modal-footer .btn').prop('disabled', false);
    }

    function eliminarGrupo(idGrupo) {
        var idGrupo = idGrupo;
        $('.modal-body h3').text("Eliminando ");
        $('#iconoAceptar').addClass('fa fa-2x fa-spin fa-circle-o-notch');
        deshabilitarElementos();
        $.ajax({
            type: $('#formEliminarGrupo').attr('method'),
            url: $('#formEliminarGrupo').attr('action'),
            data: idGrupo,
            dataType: 'json',
            contentType: 'application/json',
            success: function (response) {
                if (response == true) {
                    $('#mensajeModal').addClass('alert alert-success');
                    $('.modal-body h3').text("Grupo eliminado con éxito!");
                    $('#iconoAceptar').removeClass('fa fa-2x fa-spin fa-circle-o-notch');
                    $('#aceptarModal').html('Aceptar');
                    habilitarElementos();
                } else {
                    $('#mensajeModal').addClass('alert alert-danger');
                    $('.modal-body h3').text("No se ha podido eliminar el grupo!");
                    $('#iconoAceptar').removeClass('fa fa-2x fa-spin fa-circle-o-notch');
                    $('#aceptarModal').html('Reintentar');
                    habilitarElementos();
                    iniciarModal();
                }
            },
            error: function (e) {
                alert("Error: " + e)
            }
        })


    }
});