$(document).ready(function(){
    $("#myform").validate({
        errorClass: "claserror",
        errorElement: 'erele',
        rules:{
            name: {
                required:true,
                maxlength:45
            },
            descripcion: {
                required:true,
                maxlength:100
            }
        }
    });
});


