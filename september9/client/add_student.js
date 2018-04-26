Template.addStudent.events({
	'click #btnSave':function(e){
		var name = $('#txtFullname').val();
		var course = $('#txtCourse').val();
		var address = $('#txtAddress').val();
		if(name != "" && course != "" && address != ""){
			Students.insert({
				Fullname:name,
				Course:course,
				Address:address
			});
			$('#txtFullname').val('');
			$('#txtCourse').val('');
			$('#txtAddress').val('');
			Router.go('showStudents');
		}else{
			alert("Please fill out the whole form");
		}
	}
});