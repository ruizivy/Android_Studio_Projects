Router.configure({
 	layoutTemplate : 'layout'
 });

 Router.route('/' , {

 	name : 'Home'
 });
 
 Router.route('/login' , {
	name : 'Login',
	template : 'login'
 });
 
 Router.route('/register' , {
	name : 'Register',
	template : 'register'
 });

 Router.route('/cupcake' , {
	name : 'Viewing',
	template : 'viewing'
 });

 Router.route('/addrecipe' , {
	name : 'AddRecipe',
	template : 'addrecipe'
 });

 Router.route('/adminview' , {
	 name: 'Admin',
	 template: 'adminview'

 });
 
 Router.route('/addcategory' , {
	 name: 'AddCategory',
	 template: 'addcategory'
 });
