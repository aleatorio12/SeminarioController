var conteo = 0  //Definimos la Variable

$("#change").click(function() { //Funcion del Click
    if(conteo == 0) { //Si la variable es igual a 0
    conteo = 1; //La cambiamos a 1
    $('#pass').removeAttr("type", "password"); //Removemos el atributo de Tipo Contraseña
    $("#pass").prop("type", "text"); //Agregamos el atributo de Tipo Texto(Para que se vea la Contraseña escribida)
    $("#change").removeClass("eye"); //Removemos una clase (la imagen del ojo por defecto)
    $("#change").addClass("eye2"); //Agregamos una Nueva Clase (la imagen del ojo nueva)
    }else{ //En caso contrario
    conteo = 0; //La cambiamos a 0
    $('#pass').removeAttr("type", "text"); //Removemos el atributo de Tipo Texto
    $("#pass").prop("type", "password"); //Agregamos el atributo de Tipo Contraseña
    $("#change").removeClass("eye2"); //Removemos una clase (la imagen del ojo nueva)
    $("#change").addClass("eye"); //Agregamos una Nueva Clase (la imagen del ojo por defecto)
    } //Cierre del Else
}); //Cierre de la funcion Click
