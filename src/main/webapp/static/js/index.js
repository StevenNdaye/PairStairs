var developer = developer || {};
developer.controllers = developer.controllers || {};

developer.controllers.index = function(){
    var initialize = function () {
        $.getJSON("/PairStairs/api/developers").success(
            function(data){
                data.forEach(
                    function(dev){
                        $("body").append("<div>DEV: "+ dev.name + " "+ dev.id + "</div>")
                    }
            );
        });
    }
    return {
        initialize:initialize
    };
};