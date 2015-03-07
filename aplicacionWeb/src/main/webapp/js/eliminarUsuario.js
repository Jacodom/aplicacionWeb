/**
 * Created by Jacobo on 06/03/2015.
 */
$(document).ready(function(){

    //eventos
    $('#confirmarModal').on('show.bs.modal', function(e) {
        iniciarModal();
        $('#usuarioID').hide();
        var usuarioID = $(e.relatedTarget).data('usuario-id');
        $(e.currentTarget).find('p[name="usuarioID"]').text(usuarioID);
    });

    $("#aceptarModal").click(function () {
        if($.trim($(this).html())=='Eliminar'|| $.trim($(this).html())=='Reintentar'){
            eliminarUsuario($('#usuarioID').text());
        }else{
            cargarUsuarios(parseInt($('.numerador.active').text()));
            $('#confirmarModal').modal('toggle');
            $('.modal-backdrop').remove();
            $('body').removeClass('modal-open');
            $('#datosUsuario').empty();
        }
    });



    //funciones

    function cargarUsuarios(nroPagina){


        $('#tablaUsuarios').empty().addClass('fa fa-circle-o-notch fa-spin fa-4x');

        $('#tablaUsuarios').load('/Usuarios/ajax/usuarios.do?pg='+nroPagina+"&accion="+$('#accion').text());

        $('#tablaUsuarios').empty().removeClass('fa fa-circle-o-notch fa-spin fa-4x');


        $('.numerador.active').removeClass('active');
        $('#pag'+ nroPagina ).addClass('active');


    }


    function iniciarModal(){
        $('#mensajeModal').removeClass('alert alert-danger alert-success');
        $('#mensajeModal h3').text("¿Realmente desea eliminar el usuario seleccionado?");
        $('#aceptarModal').html('Eliminar');
    }

    function deshabilitarElementos(){
        $('.modal-footer .btn').prop('disabled',true);
    }

    function habilitarElementos(){
        $('.modal-footer .btn').prop('disabled',false);
    }

    function eliminarUsuario(idUsuario){
        var idUsuario = idUsuario;


        $('.modal-body h3').text("Eliminando ");
        $('#iconoAceptar').addClass('fa fa-2x fa-spin fa-circle-o-notch');
        deshabilitarElementos();
        $.ajax({
            type: $('#formEliminar').attr('method'),
            url: $('#formEliminar').attr('action'),
            data: idUsuario,
            dataType: 'json',
            contentType: 'application/json',
            success: function (response) {
                if (response == true) {
                    $('#mensajeModal').addClass('alert alert-success');
                    $('.modal-body h3').text("Usuario eliminado con éxito!");
                    $('#iconoAceptar').removeClass('fa fa-2x fa-spin fa-circle-o-notch');
                    $('#aceptarModal').html('Aceptar');
                    habilitarElementos();
                } else {
                    $('#mensajeModal').addClass('alert alert-danger');
                    $('.modal-body h3').text("No se ha podido eliminar el usuario!");
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