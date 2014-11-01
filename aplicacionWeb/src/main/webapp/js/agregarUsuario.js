/**
 * Created by Jacobo on 30/10/14.
 */
$(document).ready(function(){

    $('#nombreInput').focusout(verificarUsername
    );

    function verificarUsername() {
        var userName = $(this).val();

        if (userName.length < 6) {
            $('#errorDisplayNombre').text("El username debe contener al menos 6 caracteres");
        } else {
            $.ajax({
                type:"POST",
                url:'/Usuarios/verifyUsuario.do',
                data:userName,
                dataType:"json",
                contentType:"application/json",
                success: function (response) {
                if (response == true) {
                    $('#nombreInput').closest('.form-group').removeClass('has-error').addClass('has-success');
                    $('#iconoNombre').removeClass('glyphicon-asterisk glyphicon-remove').addClass('glyphicon-ok');
                    $('#errorDisplayNombre').text('');

                } else {
                    $('#nombreInput').closest('.form-group').removeClass('has-success').addClass('has-error');
                    $('#iconoNombre').removeClass('glyphicon-asterisk glyphicon-ok').addClass('glyphicon-remove');
                    $('#errorDisplayNombre').text('Ya existe un usuario con ese username');
                    }
                },
                error:function(e){alert("Error: "+e)}
                }

            )
        }

    }
});