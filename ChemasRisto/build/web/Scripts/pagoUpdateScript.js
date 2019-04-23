$(document).ready(function(){
    $("#myform").validate({
        errorClass: "claserror",
        errorElement: 'erele',
        rules:{
            cliente_id: {
                required:true
            },
            tipo: {
                required:true
            }
        }
    });
});


