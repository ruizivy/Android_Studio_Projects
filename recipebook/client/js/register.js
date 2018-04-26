Template.register.events({
    'click #btnSignUp': function (event) {
        var fname = $('#fName');
        var lname = $('#lName');
        var addr = $('#address');
        var gender = $('#cmbgender');
        var age = $('#txtage');
        var email = $('#txtEmail');
        var pword = $('#txtPassword');

        var emailCollection = User.find({ e_mail: email }).count();

        if (fname.trim() == "" && lname.trim() == "" &&
            addr.trim() == "" && gender.trim() == "" &&
            age.trim() == "" && email.trim() == "" && pword.trim() == "") {

            alert("Please fill up the whole form!");

        } else if (emailCollection.toString() == "0") {
            User.insert({
                firstname: fname,
                lastname: lname,
                address: addr,
                gender: gender,
                age: age,
                e_mail: email,
                password: pword,
                photo : null
            });
            
            alert("Success!!");
        } else {
            alert("Invalid email  , Email already exist!");
        }
    }


});