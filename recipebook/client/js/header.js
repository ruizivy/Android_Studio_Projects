Template.header.helpers({
    'category_name' : function(){
        return Category.find({},{sort:{name:-1}});
    }
});