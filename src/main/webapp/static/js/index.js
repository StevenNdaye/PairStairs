var developer = developer || {};
developer.controllers = developer.controllers || {};

developer.controllers.index = function(){
    var initialize = function () {

        var viewModel = {
            devs: ko.observableArray(),
            count: ko.observable(),
            newName: ko.observable(),
            developerId: ko.observable(),
            submit: function(){
                $.ajax({
                    url: "/PairStairs/api/developers/new",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify({name: this.newName()})
                }).success(function(){
                    viewModel.listDevelopers();
                })
            },

            listDevelopers: function(){
                $.ajax({
                    url: "/PairStairs/api/developers",
                    type: "GET"
                }).success(
                    function(data){
                       viewModel.devs(data);
                    }
                );

                $.getJSON("/PairStairs/api/developers/count").success(
                        function(count){
                           viewModel.count(count);
                        }
                    );
                },

            deleteDev: function(){
                $.ajax({
                    url: "/PairStairs/api/developers/delete/" + this.developerId(),
                    type: "DELETE"

                }).success(
                    function(){
                       viewModel.listDevelopers();
                    });
            }


        };

        viewModel.listDevelopers();

        ko.applyBindings(viewModel)
    };

    return {
        initialize:initialize
    };
};