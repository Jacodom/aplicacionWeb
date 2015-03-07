/**
 * Created by pablo on 04/03/2015.
 */
$(document).ready(function() {
    ocultarCampos();
    $('#codigoInput').focusout(verificarLongitud);


    $("#btnRegistrar").on("click",function() {
        if (verificarCampos() == false) {
            $("#errorvalidacion").css('display', "block");
            return false;

        } else {
            $('#iconoSubmit').addClass('fa fa-circle-o-notch fa-spin');
            $('#btnRegistrar span').text("Registrando  ");
        }
    });
    limpiarTextos();

    function limpiarTextos(){
        //---- Campos Basicos ------//
        $('#codigoInput').val('');
        $('#NameInput').val('');
        $('#chkEstado').prop('checked',true);
    }
    function verificarCampos() {
        if ($('#codigoInput').val() == '') {
            return false;
        }
        if ($('#NameInput').val() == '') {
            return false;
        }
    }
    function ocultarCampos(){
        $("#errorvalidacion").css('display',"none");
    }
    function verificarLongitud(){
        var IdGrupo = $("#codigoInput").val();
        if(IdGrupo.length==3){
            $.ajax({
                type:"POST",
                url:"/Grupos/verificarGrupo.do",
                data:IdGrupo,
                dataType:"json",
                contentType:"application/json",
                success: function (response) {
                    if (response == true) {
                        //grupo válido
                        $('#codigoInput').closest('.form-group').removeClass('has-error').addClass('has-success');
                        $('#iconoCodigo').removeClass('glyphicon-asterisk glyphicon-remove fa fa-circle-o-notch fa-spin').addClass('glyphicon-ok');
                        $('#errorGrupoId').text('');

                    } else {
                        //incorrecto
                        $('#codigoInput').closest('.form-group').removeClass('has-success').addClass('has-error');
                        $('#iconoCodigo').removeClass('glyphicon-asterisk glyphicon-ok fa fa-circle-o-notch fa-spin').addClass('glyphicon-remove');
                        $('#errorGrupoId').text('Ya existe un grupo con el mismo código');

                    }
                },
                    error:function(e){alert("Error: "+e)}
                })
        }else{
        $('#codigoInput').closest('.form-group').addClass('has-error');
        $('#errorGrupoId').text("Debe contener exactamente 3 caracteres")
            return false;
    }
    }
});

