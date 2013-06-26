var developer = developer || {};
developer.controllers = developer.controllers || {};

developer.controllers.index = function(){


    var initialize = function () {

        var viewModel = {
            devs: ko.observableArray(),
            count: ko.observable(),
            newName: ko.observable(),
            developerId: ko.observable(),
            newIdToUpdate: ko.observable(),
            newNameToUpdate: ko.observable(),



            submit: function(){
                $.ajax({
                    url: "/PairStairs/api/developers/new",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify({name: this.newName()})
                }).success(function(){
                    viewModel.newName("");
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
                       viewModel.developerId("");
                       viewModel.listDevelopers();
                });
            },

            updateDev: function(){
                $.ajax({
                    url: "/PairStairs/api/developers/update",
                    type: "PUT" ,
                    contentType: "application/json",
                    data: JSON.stringify({id:this.newIdToUpdate(), name: this.newNameToUpdate()})

                }).success(
                    function(){
                       viewModel.newIdToUpdate("");
                       viewModel.newNameToUpdate("");
                       viewModel.listDevelopers();
                });
            }


        };


        viewModel.pairings = ko.computed(function(){
                       var self = this;
                       var pairings = [];
                       self.devs().forEach(function(devOne){
                            var others = [];
                            self.devs().forEach(function(devTwo){
                                if(devOne !== devTwo){
                                    others.push(devTwo);
                                }
                            });
                            pairings.push({
                                dev: devOne,
                                others: others
                            })
                       });
                       return pairings;
                    }, viewModel);

        viewModel.listDevelopers();

        ko.applyBindings(viewModel)



    };

    return {
        initialize:initialize

    };
};