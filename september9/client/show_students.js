Template.showStudents.helpers({
	'students':function(){
		return Students.find({});
	}
});
Template.showStudents.events({
	'click #btnAdd':function(e){
		Router.go('addStudent');
	}
});