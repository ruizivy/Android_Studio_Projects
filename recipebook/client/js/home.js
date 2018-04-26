Template.home.events({
  'click #hearteu' : function(events){
      $('#hearteu').removeClass('glyphicon glyphicon-heart-empty ')
                    .addClass('glyphicon glyphicon-heart');
 
  },

  'click #asoup' : function(events){
  }
});

Template.home.helpers({
'category_name' : function(){
        return Category.find({},{sort:{name:-1}});
    }
});

