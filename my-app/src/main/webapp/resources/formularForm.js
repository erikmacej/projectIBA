$(document).ready(function() {
    $.validator.addMethod("regex", function(value, element, regexpr) {          
        return regexpr.test(value);
    }, "Meno obsahuje nedovolené znaky");
      
    $("#formularForm").validate({
        rules:{
            name:{
                required:true,
                minlength:1,
                maxlength:60,
                regex: /^[a-zA-Z ]+$/
            },
            surname:{
                required:true,
                minlength:1,
                maxlength:60,
                regex: /^[a-zA-Z ]+$/ 
            },
            datepicker:{
                date:true,
                required:true
            },
            sex:"required"
        },
        messages:{
            name:{
                required:"Prosím zadajte svoje meno",
                minlength:"Meno musí obsahovať minimálne jeden znak",
                maxlength:"Meno nesmie obsahovať viac ako 60 znakov"
            },
            surname:{
                required:"Prosím zadajte svoje priezvisko",
                minlength:"Priezvisko musí obsahovať minimálne jeden znak",
                maxlength:"Priezvisko nesmie obsahovať viac ako 60 znakov"
            },
            datepicker:{
                date:"Zly format",
                required:"tata"
            },
            sex:"Prosim zadajte pohlavie"
            }
    });
   
    $( "#datepicker" ).datepicker({
            changeYear:true,
            maxDate:0,
            onClose: function() {$(this).valid();}
    });            
    
});
