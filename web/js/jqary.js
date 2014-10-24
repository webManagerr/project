$(document).ready(function () {
     $(".wrapper").toggleClass('active');
});    
$(document).ready(function () {
    
    
    
    $("#menu-submit").click(function () {
        $(".wrapper").toggleClass('active');
//        if (activeMenu!==null)  activeMenu = $.cookie(activeMenu, null);
//        else   activeMenu = $.cookie(activeMenu, true);
    });


    $("#list-folder").click(function () {
        if ($(".menu-list").css("display") === "none") {
            $(".menu-list").css("display", "");
        } else {
            $(".menu-list").css("display", "none");
        }
    });
});

