/**
 * Created by Jacobo on 24/02/2015.
 */

$(document).ready(function () {

    //eventos
    apagarAlertas();
    $("#formModificarUsuario").submit(function(){
        $("#gruposUsuario option").each(function(){
            $(this).prop('selected', true);
        });

        $("#formModificarUsuario").submit();
    });

    //funciones
    function apagarAlertas(){
        $('.alert').hide();
    }

    $('#btnAdd').click(function(e) {
        var seleccionGrupos = $('#gruposTodos option:selected');

        if (seleccionGrupos.length == 0) {
            alert("Seleccione un elemento.");
            e.preventDefault();
        }
        $('#gruposUsuario').append($(seleccionGrupos).clone());
        $(seleccionGrupos).remove();
        e.preventDefault();
    });

    $('#btnDel').click(function(e) {
        var seleccionGrupos = $('#gruposUsuario option:selected');
        if (seleccionGrupos.length == 0) {
            e.preventDefault();
        }

        $('#gruposTodos').append($(seleccionGrupos).clone());
        $(seleccionGrupos).remove();
        e.preventDefault();
    });



});
