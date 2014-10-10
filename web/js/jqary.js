
$(document).ready(function(){
$("#Menu1").click(function(){
  $(".wrapper").toggleClass('active');
});
});

$(document).ready(function(){
$("#list-folder").click(function(){
    if (  $(".menu-list").css("display") === "none"){
       $(".menu-list").css("display","");
    }else{
         $(".menu-list").css("display","none");
    }
});
});