var conteo = 0;
    $('#change').click(function () {
        if (conteo == 0) {
            conteo = 1;
            $('#pass').removeAttr('type', 'password');
            $('#pass').prop('type', 'text');
            $('#change').removeClass('eye');
            $('#change').addClass('eye2');
        } else {
            conteo = 0;
            $('#pass').removeAttr('type', 'text');
            $('#pass').prop('type', 'password');
            $('#change').removeClass('eye2');
            $('#change').addClass('eye');
        }
    });
