
 Router.configure({
 	layoutTemplate : 'layout'
 });

 Router.route('/' , {

 	name : 'main'
 });

 Router.route('/addnew', {

 			name : 'addStudent' ,
			template : 'addStudent'
		}); 

Router.route('/home' , {
	name : 'Home'
});