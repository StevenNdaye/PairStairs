var locomotives = locomotives || {};
locomotives.controllers = locomotives.controllers || {};

locomotives.controllers.index = function(){
    var initialize = function () {
        $.getJSON("/PairStairs/api/locomotives").success(
            function(data){
                data.forEach(
                    function(train){
                        $("body").append("<div>TRAIN: "+ train.name + " "+ train.id + "</div>")
                    }
            );
        });
    }
    return {
        initialize:initialize
    };
};