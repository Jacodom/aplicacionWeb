/**
 * Created by Jacobo on 30/10/14.
 */
$(document).ready(function(){

    //eventos
    $('#userNameInput').focusout(verificarUsername);
    $('#emailUser').focusout(verificarEmail);
    //$('#btnRegistrar').click(addUsuario);

    //funciones
    function verificarUsername() {
        var userName = $(this).val();

        if (userName.length < 6) {
            $('#errorDisplayUserName').text("El username debe contener al menos 6 caracteres");
        } else {

            $('#iconoUserName').removeClass('glyphicon-asterisk glyphicon-remove').addClass('fa fa-circle-o-notch fa-spin');

            $.ajax({
                type:"POST",
                url:'/Usuarios/verifyUsuario.do',
                data:userName,
                dataType:"json",
                contentType:"application/json",
                success: function (response) {
                if (response == true) {
                    $('#userNameInput').closest('.form-group').removeClass('has-error').addClass('has-success');
                    $('#iconoUserName').removeClass('glyphicon-asterisk glyphicon-remove fa fa-circle-o-notch fa-spin').addClass('glyphicon-ok');
                    $('#errorDisplayUserName').text('');

                } else {
                    $('#userNameInput').closest('.form-group').removeClass('has-success').addClass('has-error');
                    $('#iconoUserName').removeClass('glyphicon-asterisk glyphicon-ok fa fa-circle-o-notch fa-spin').addClass('glyphicon-remove');
                    $('#errorDisplayUserName').text('Ya existe un usuario con ese username');
                    }
                },
                error:function(e){alert("Error: "+e)}
                }

            )
        }

    }

    function verificarIngresoMail(mail){
        var filter = /[\w-\.]{3,}@([\w-]{2,}\.)*([\w-]{2,}\.)[\w-]{2,4}/;

        if(!filter.test(mail))
            return false;
    }

    function verificarCampos(){
        if($('#nameInput').val()==''){
            return false;
        }

        if($('userNameInput').val()==''){
            return false;
        }

        if($('emailUser').val()==''){
            return false;
        }

        if($('passwordUser').val()==''){
            return false;
        }

        return true;

    }

    function verificarEmail(){
        $('#errorDisplayEmail').text("");
        var emailUser = $(this).val();

        if(verificarIngresoMail(emailUser)==false){
            if(emailUser=="")
                $('#errorDisplayEmail').text("Debe ingresar un mail");
            $('#emailUser').closest('.form-group').removeClass('has-success').addClass('has-error');
            $('#iconoEmail').removeClass('glyphicon-asterisk glyphicon-ok ').addClass('glyphicon-remove');
            $('#errorDisplayEmail').text("Debe ingresar un mail válido");
        }else{

            $('#iconoEmail').removeClass('glyphicon-asterisk glyphicon-remove').addClass('fa fa-circle-o-notch fa-spin');

            $.ajax({
                    type:'POST',
                    url:'/Usuarios/verifyEmail.do',
                    data: emailUser,
                    dataType: 'json',
                    contentType:'application/json',
                    success: function(response){
                        if(response==true){
                            $('#emailUser').closest('.form-group').removeClass('has-error').addClass('has-success');
                            $('#iconoEmail').removeClass('glyphicon-asterisk glyphicon-remove fa fa-circle-o-notch fa-spin').addClass('glyphicon-ok');
                            $('#errorDisplayEmail').text('');
                        }else{
                            $('#emailUser').closest('.form-group').removeClass('has-success').addClass('has-error');
                            $('#iconoEmail').removeClass('glyphicon-asterisk glyphicon-ok fa fa-circle-o-notch fa-spin').addClass('glyphicon-remove');
                            $('#errorDisplayEmail').text('Ya existe un usuario con ese username');
                        }
                    },
                    error:function(e){alert("Error: "+e)}
                }
            )
        }
    }

    /*function addUsuario(){
        var jNombre = $('#nameInput').val();
        var jUserName= $('#userNameInput').val();
        var jEmail= $('#emailUser').val();
        var jPassword = $('#passwordUser').val();

        var jUser = {
            'idUsuario':jUserName,
            'claveUsuario':jPassword,
            'emailUsuario':jEmail,
            'estadoUsuario':true,
            'nombreUsuario':jNombre
        };

        if(verificarCampos()==false)
        {
            $('#errorDisplayAgregar').text('Debe completar los campos vacios!');
        }else{
            if($('#userNameInput').hasClass('has-error')||$('#emailUser').hasClass('has-error')){
                $('#errorDisplayAgregar').text('No puede agregar un usuario con Username o Email existente');
            }else{
                $('#btnRegistrar').prop('value','');
                $('#btnRegistrar').addClass('fa fa-circle-o-notch fa-spin');

                $.ajax({
                        type:"POST",
                        url:$('#addUsuarioForm').attr('action'),
                        data: JSON.stringify(jUser),
                        dataType:"json",
                        contentType:"application/json",
                        success:function(response){
                            if(response==true)
                                window.location("usuarioAgregado.jsp");

                        }
                    }
                )
            }


        }


    }*/
});