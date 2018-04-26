Template.showStudents.helpers({

	'liststudent' : function(){
		return ListStudent.find({});
	}
});


$(document).ready(function(){

if(itemscollection == 0){
				for( var i = 0; i < lstitem.length; i++)
				{
						Items.insert({
						items : lstitem[i].toString()
						});
				}
				
		}else{}

$('#btnaddcoursedone').on("click",function(){
	var entered = $('#txtaddcourse').val();
	var courseCollection = Items.find({lstcourseitem:entered}).count();
		
		if(courseCollection.toString() == "0"){
			Items.insert({
				Items :$('#txtaddcourse').val().toUpperCase()
			});
			alert("success");
		}else{ alert("already exist"); }

	 });

});

Template.showStudents.events({
	'click #btnAdd' : function(event){
		//event.preventDefault();

		Router.go('addStudent');
	} 

});

Template.addStudent.events({
	'click #btnSave' : function(event){
	txtfullname = $('#txtfullname').val();
	txtaddress = $('#txtaddress').val();
	cmbcourse1 =  $('#cmbcourse').val();

	var fname = txtfullname;
	var studentsColletion = ListStudent.find({fullname : fname}).count();
	if(studentsColletion.toString() == "0"){
		if(txtfullname.trim().toString().length != 0){
			 ListStudent.insert({
						fullname : txtfullname,
						course : cmbcourse1,
						address : txtaddress
					});

				$('#txtfullname').val("");
				$('#txtaddress').val("");
				$('#cmbcourse').val("");	
		}
		else {alert('Please complete the requirments');}
	}else{s
		alert('Student already exist!!!');
	}
}
});