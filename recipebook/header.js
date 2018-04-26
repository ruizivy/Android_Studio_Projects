Template.header.helpers({
    'category' : function(){
        return Category.find({},{sort:{name:-1}});
    }
});
