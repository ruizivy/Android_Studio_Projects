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
}); // Router.route('/home' , {                                      // 6
// 	name : 'Home'                                                    // 12
// });                                                               // 13
///////////////////////////////////////////////////////////////////////

},"student.js":function(){

///////////////////////////////////////////////////////////////////////
//                                                                   //
// lib/student.js                                                    //
//                                                                   //
///////////////////////////////////////////////////////////////////////
                                                                     //
ListStudent = new Mongo.Collection('liststudent');                   // 1
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
