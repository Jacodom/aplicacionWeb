/**
 * Created by Jacobo on 05/03/2015.
 */
$(document).ready(function(){

    //eventos


    $('#confirmarModal').on('show.bs.modal', function(e) {
        iniciarModal();
        $('#perfilID').hide();
        var perfilID = $(e.relatedTarget).data('perfil-id');
        $(e.currentTarget).find('p[name="perfilID"]').text(perfilID);
    });

    $("#aceptarModal").click(function () {
        if($.trim($(this).html())=='Eliminar'|| $.trim($(this).html())=='Reintentar'){
            eliminarPerfil(parseInt($('#perfilID').text()));
        }else{
            cargarPerfiles(parseInt($('.numerador.active').text()));
            $('#confirmarModal').modal('toggle');
            $('.modal-backdrop').remove();
        }
    });



    //funciones

    function cargarPerfiles(nroPagina){


        $('#tablaPerfiles').empty().addClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('#tablaPerfiles').load('/Perfiles/ajax/perfiles.do?pg='+nroPagina+'&accion='+$('#accion').text());

        $('#tablaPerfiles').empty().removeClass('fa fa-circle-o-notch fa-spin fa-4x');


        $('.numerador.active').removeClass('active');
        $('#pag'+ nroPagina ).addClass('active');


    }


    function iniciarModal(){
        $('#mensajeModal').removeClass('alert alert-danger alert-success');
        $('#mensajeModal h3').text("¿Realmente desea eliminar el perfil seleccionado?");
        $('#aceptarModal').html('Eliminar');
    }

    function deshabilitarElementos(){
        $('.modal-footer .btn').prop('disabled',true);
    }

    function habilitarElementos(){
        $('.modal-footer .btn').prop('disabled',false);
    }

    function eliminarPerfil(idPerfil){
        var idPerfil = idPerfil;

        $('.modal-body h3').text("Eliminando ");
        $('#iconoAceptar').addClass('fa fa-2x fa-spin fa-circle-o-notch');
        deshabilitarElementos();
        $.ajax({
            type: $('#formEliminar').attr('method'),
            url: $('#formEliminar').attr('action'),
            data: JSON.stringify(idPerfil),
            dataType: 'json',
            contentType: 'application/json',
            success: function (response) {
                if (response == true) {
                    $('#mensajeModal').addClass('alert alert-success');
                    $('.modal-body h3').text("Perfil eliminado con éxito!");
                    $('#iconoAceptar').removeClass('fa fa-2x fa-spin fa-circle-o-notch');
                    $('#aceptarModal').html('Aceptar');
                    habilitarElementos();
                } else {
                    $('#mensajeModal').addClass('alert alert-danger');
                    $('.modal-body h3').text("No se ha podido eliminar el perfil!");
                    $('#iconoAceptar').removeClass('fa fa-2x fa-spin fa-circle-o-notch');
                    $('#aceptarModal').html('Reintentar');
                    habilitarElementos();
                }
            },
            error: function (e) {
                alert("Error: " + e)
            }
        })



    }

});