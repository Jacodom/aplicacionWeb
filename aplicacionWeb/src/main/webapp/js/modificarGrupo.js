/**
 * Created by pablo on 10/03/2015.
 */
$(document).ready(function () {

    //eventos
    apagarAlertas();
    $("#formModificarGrupo").submit(function(){
        $("#usuarioGrupo option").each(function(){
            $(this).prop('selected', true);
        });

        $("#formModificarGrupo").submit();
    });

    //funciones
    function apagarAlertas(){
        $('.alert').hide();
    }

    $('#btnAdd').click(function(e) {
        var seleccionUsuarios = $('#usuariosTodos option:selected');

        if (seleccionUsuarios.length == 0) {
            alert("Seleccione un elemento.");
            e.preventDefault();
        }
        $('#usuarioGrupo').append($(seleccionUsuarios).clone());
        $(seleccionUsuarios).remove();
        e.preventDefault();
    });

    $('#btnDel').click(function(e) {
        var seleccionUsuarios = $('#usuarioGrupo option:selected');
        if (seleccionUsuarios.length == 0) {
            e.preventDefault();
        }

        $('#usuariosTodos').append($(seleccionGrupos).clone());
        $(seleccionUsuarios).remove();
        e.preventDefault();
    });



});

