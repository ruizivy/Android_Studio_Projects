Template.addcategory.events({
'submit form': function(e){
        e.preventDefault();
        var input =  $('[name="category"]');
        var categoryname = input.val();
     Category.insert({
            name : categoryname,
      });
           input.val('');
           alert('Success')
     },
});