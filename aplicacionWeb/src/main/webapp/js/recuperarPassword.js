/**
 * Created by Jacobo on 20/02/2015.
 */
$(document).ready(function(){

    //eventos
    ocultarAlertas();
    limpiarTextos();

    $('#btnRecuperar').click(function(e){
        generarPassword();
    });


    //funciones
    function limpiarTextos(){
        $('#inputUsername').val("");
        $('#emailUsr').val("");
    }

    function ocultarAlertas(){
        $('.alert').hide();
    }

    function deshabilitarElementos(){
        $('#inputUsername').prop('disabled',true);
        $('#emailUsr').prop('disabled',true);
        $('#btnRecuperar').prop('disabled',true);
        $('#btnVolver').prop('disabled',true);

       //$('#btnRecuperar').addClass('disabled');
        $('#btnVolver').addClass('disabled');
    }

    function habilitarElementos(){
        $('#inputUsername').prop('disabled',false);
        $('#emailUsr').prop('disabled',false);
        $('#btnRecuperar').prop('disabled',false);
        $('#btnVolver').prop('disabled',false);

        $('#btnRecuperar').removeClass('disabled');
        $('#btnVolver').removeClass('disabled');
    }

    function verificarIngresoMail(mail){
        var filter = /[\w-\.]{3,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/;

        if(!filter.test(mail))
            return false;
    }

    function verificarCampos(){
        if($('#inputUsername').val()==''){
            return false;
        }

        if($('#emailUsr').val()==''){
            return false;
        }

        return true;

    }


    function generarPassword(){
        $('#errorDisplayEmail').text("");
        $('#errorDisplayUserName').text("");
        $('#errorDisplayRecuperar').text("");
        $('.alert').hide();
        var jUserName= $('#inputUsername').val();
        var jEmail= $('#emailUsr').val();

        var jUser = {
            'idUsuario':jUserName,
            'emailUsuario':jEmail
        };

        if(verificarCampos()==false)
        {
            $('#errorDisplayRecuperar').text('Debe completar los campos vacios!');
        }else {
            if (verificarIngresoMail(jEmail) == false) {
                if (jEmail == "") {
                    $('#errorDisplayEmail').text("Debe ingresar un mail");
                } else {
                    $('#errorDisplayEmail').text("Debe ingresar un mail válido");
                }
            } else {
                deshabilitarElementos();


                $('#iconoSubmit').addClass('fa fa-circle-o-notch fa-spin');
                $('#btnRecuperar span').text("Enviando  ");

                $.ajax({
                        type: "POST",
                        url: $('#formRecuperar').attr('action'),
                        data: JSON.stringify(jUser),
                        dataType: "json",
                        contentType: "application/json",
                        success: function (response) {
                            $('#iconoSubmit').removeClass('fa fa-circle-o-notch fa-spin');
                            $('#btnRecuperar span').text('Recuperar');
                            habilitarElementos();
                            if(response==true) {
                                limpiarTextos();
                                $('.alert.alert-success').fadeIn();
                            }else{
                                $('.alert.alert-danger').fadeIn();
                            }
                        }
                    }
                )
            }
        }
    }

});