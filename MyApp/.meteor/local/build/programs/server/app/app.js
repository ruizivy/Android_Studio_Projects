var require = meteorInstall({"lib":{"router.js":function(){

///////////////////////////////////////////////////////////////////////
//                                                                   //
// lib/router.js                                                     //
//                                                                   //
///////////////////////////////////////////////////////////////////////
                                                                     //
Router.configure({                                                   // 2
  layoutTemplate: 'layout'                                           // 3
});                                                                  // 2
Router.route('/', {                                                  // 6
  name: 'main'                                                       // 8
});                                                                  // 6
Router.route('/addnew', {                                            // 11
  name: 'addStudent',                                                // 13
  template: 'addStudent'                                             // 14
});                                                                  // 11
Router.route('/home', {                                              // 17
  name: 'Home'                                                       // 18
});                                                                  // 17
///////////////////////////////////////////////////////////////////////

},"student.js":function(){

///////////////////////////////////////////////////////////////////////
//                                                                   //
// lib/student.js                                                    //
//                                                                   //
///////////////////////////////////////////////////////////////////////
                                                                     //
ListStudent = new Mongo.Collection('liststudent');                   // 1
Items = new Mongo.Collection('items');                               // 2
///////////////////////////////////////////////////////////////////////

}}},{
  "extensions": [
    ".js",
    ".json"
  ]
});
require("./lib/router.js");
require("./lib/student.js");
//# sourceMappingURL=app.js.map
