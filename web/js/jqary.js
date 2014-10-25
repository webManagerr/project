   
$(document).ready(function () {
    var cook = $.cookie('activate-menu');
     if (cook==="false"&&cook!==null){ 
            $(".wrapper").toggleClass('active');
            alert(cook); 
      }
    
     
    $("#menu-submit").click(function () {
       $(".wrapper").toggleClass('active');

       
       cook = $.cookie('activate-menu');
        if (cook==="false"){ 
            $.cookie('activate-menu',"true");
            
        }else{  
            $.cookie('activate-menu',"false");
            
        }
    });


    $("#list-folder").click(function () {
        if ($(".menu-list").css("display") === "none") {
            $(".menu-list").css("display", "");
        } else {
            $(".menu-list").css("display", "none");
        }
    });
});

