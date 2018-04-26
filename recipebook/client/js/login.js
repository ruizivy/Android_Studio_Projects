Template.login.helpers({
 'user_info' : function(){
        return User.find({},{sort:{name:-1}});
    }
});

Template.login.events({
    'click #btnSignIn' : function(event){
      var uname = $('#uName');
        var pword = $('#pword');
        var photo = $('#user_img');
        
        var user_collection  = User.find({e_mail : uname} , {password : pword}).count();
    

        if(uname.trim().toString() == "" || pword.trim().toString() == ""){
            if(user_collection.toString() != "0"){
                
                alert("User successfully login!");
            }
        }else{
            alert("User doesn't exist!");
        }
       
    }
});