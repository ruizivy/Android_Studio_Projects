var require = meteorInstall({"client":{"pages":{"template.addnew.js":function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// client/pages/template.addnew.js                                                                                   //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
                                                                                                                     // 1
Template.__checkName("addStudent");                                                                                  // 2
Template["addStudent"] = new Template("Template.addStudent", (function() {                                           // 3
  var view = this;                                                                                                   // 4
  return [ HTML.Raw('<label for="txtfullname">Fullname</label>\n<input class="form-control" type="text" name="txtAuthor" placeholder="Enter Fullname">\n\n '), HTML.DIV({
    class: "form-group"                                                                                              // 6
  }, "\n    ", HTML.Raw('<label for="cmbcourse">Course</label>'), "\t\n\t", HTML.Raw('<button type="button" role="group" id="btnaddcourse" class="btn btn-round btn-warning  " data-toggle="modal" data-target="#addcoursemodal">+</button>'), "\n\t\n\t ", HTML.SELECT({
    class: "form-control ",                                                                                          // 8
    id: "cmbcourse",                                                                                                 // 9
    placeholder: "Choose Course"                                                                                     // 10
  }, "\n\t", Blaze.Each(function() {                                                                                 // 11
    return Spacebars.call(view.lookup("items"));                                                                     // 12
  }, function() {                                                                                                    // 13
    return [ "\n         ", HTML.OPTION({                                                                            // 14
      id: function() {                                                                                               // 15
        return Spacebars.mustache(view.lookup("_id"));                                                               // 16
      }                                                                                                              // 17
    }, " ", Blaze.View("lookup:Items", function() {                                                                  // 18
      return Spacebars.mustache(view.lookup("Items"));                                                               // 19
    }), " "), "\n    " ];                                                                                            // 20
  }), " \n\t"), "\n"), HTML.Raw('\n\n<label for="txtaddress">Address</label>\n<input class="form-control" type="text" name="txtTitle" placeholder="Enter Address">\n<br>\n<button class="btn btn-primary" id="btnSave">Save</button>\n\n\n<div class="modal fade" id="addcoursemodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">\n  <div class="modal-dialog" role="document">\n    <div class="modal-content">\n      <div class="modal-header">\n        <h5 class="modal-title" id="exampleModalLabel">Add Course(s)</h5>\n      </div>\n      <div class="modal-body">\n        \n    <input type="text" class="form-control col" id="txtaddcourse" placeholder="Enter Course Name">\n\t\n      </div>\n      <div class="modal-footer">\n        <button type="button" class="btn btn-danger " data-dismiss="modal">CLOSE</button>\n        <button type="button" id="btnaddcoursedone" class="btn btn-success">ADD</button>\n      </div>\n    </div>\n  </div>\n</div>') ];
}));                                                                                                                 // 22
                                                                                                                     // 23
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

},"template.header.js":function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// client/pages/template.header.js                                                                                   //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
                                                                                                                     // 1
Template.__checkName("header");                                                                                      // 2
Template["header"] = new Template("Template.header", (function() {                                                   // 3
  var view = this;                                                                                                   // 4
  return [ HTML.DIV({                                                                                                // 5
    id: "navbar"                                                                                                     // 6
  }, "\n\t\t", HTML.NAV({                                                                                            // 7
    class: "navbar btn-primary",                                                                                     // 8
    role: "navigation"                                                                                               // 9
  }, "\n\n\t\t\t", HTML.Raw('<div class="navbar-default">\n\t\t\t\t<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> \n\t\t\t\t<span class="sr-only">Toggle navigation</span> \n\t\t\t\t<span class="icon-bar"></span> \n\t\t\t\t<span class="icon-bar"></span> \n\t\t\t\t<span class="icon-bar"></span>\n\t\t\t\t </button>\n\t\t\t\t<a class="navbar-brand" style="margin-left:10%;width:200px;height:80px;background-color: darkslategray;" href="#"></a>\n\t\t\t\t</div>'), "\n\n\t\t\t", HTML.DIV({
    class: "collapse navbar-collapse text-right center-block",                                                       // 11
    id: "bs-example-navbar-collapse-1"                                                                               // 12
  }, "\n\t\t\t\t", HTML.UL({                                                                                         // 13
    class: "nav navbar-nav pull-right center-block ",                                                                // 14
    id: "rightnav"                                                                                                   // 15
  }, "\n\t\t\t\t\t", HTML.LI(HTML.A({                                                                                // 16
    href: function() {                                                                                               // 17
      return Spacebars.mustache(view.lookup("pathFor"), "Home");                                                     // 18
    },                                                                                                               // 19
    style: "color:#FFFFFF;",                                                                                         // 20
    id: "home"                                                                                                       // 21
  }, "HOME")), "\n\t\t\t\t\t", HTML.Raw('<li><a href="#" style="color:#FFFFFF">PRODUCTS</a></li>'), "\n\t\t\t\t\t", HTML.Raw('<li><a href="#" style="color:#FFFFFF">\t</a></li>'), "\n\t\t\t\t"), "\n\t\t\t"), "\n\t\t\t", HTML.Raw("<!-- /.navbar-collapse -->"), "\n\t\t"), "\n\t"), HTML.Raw("\n\t<!--  end navbar -->") ];
}));                                                                                                                 // 23
                                                                                                                     // 24
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

},"template.home.js":function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// client/pages/template.home.js                                                                                     //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
                                                                                                                     // 1
Template.__checkName("home");                                                                                        // 2
Template["home"] = new Template("Template.home", (function() {                                                       // 3
  var view = this;                                                                                                   // 4
  return [ HTML.Raw("<p> this is home</p>\n\n\t"), Blaze.If(function() {                                             // 5
    return Spacebars.call(view.lookup("currentUser"));                                                               // 6
  }, function() {                                                                                                    // 7
    return [ "\n\n\t\t", Spacebars.include(view.lookupTemplate("loggedIn")), "\n\n\t" ];                             // 8
  }, function() {                                                                                                    // 9
    return [ "\n\n\t\t", Spacebars.include(view.lookupTemplate("notLoggedIn")), "\n\n\t" ];                          // 10
  }) ];                                                                                                              // 11
}));                                                                                                                 // 12
                                                                                                                     // 13
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

},"template.layout.js":function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// client/pages/template.layout.js                                                                                   //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
                                                                                                                     // 1
Template.__checkName("layout");                                                                                      // 2
Template["layout"] = new Template("Template.layout", (function() {                                                   // 3
  var view = this;                                                                                                   // 4
  return [ HTML.DIV({                                                                                                // 5
    class: "container fluid-pull-right"                                                                              // 6
  }, "\n\t", Spacebars.include(view.lookupTemplate("loginButtons")), "\n"), "\n\n", Spacebars.include(view.lookupTemplate("header")), "\n\n", HTML.DIV({
    id: "main"                                                                                                       // 8
  }, " \n ", Spacebars.include(view.lookupTemplate("yield")), "\n") ];                                               // 9
}));                                                                                                                 // 10
                                                                                                                     // 11
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

},"template.show_students.js":function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// client/pages/template.show_students.js                                                                            //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
                                                                                                                     // 1
Template.__checkName("showStudents");                                                                                // 2
Template["showStudents"] = new Template("Template.showStudents", (function() {                                       // 3
  var view = this;                                                                                                   // 4
  return HTML.DIV({                                                                                                  // 5
    class: "panel panel-info"                                                                                        // 6
  }, HTML.Raw('\n    <div class="panel-heading">\n      <h4>Student List </h4>\n    </div>\n    '), HTML.DIV({       // 7
    class: "panel-body"                                                                                              // 8
  }, "\n  ", HTML.DIV({                                                                                              // 9
    class: "container-fluid"                                                                                         // 10
  }, "\n  ", HTML.UL({                                                                                               // 11
    class: "list-group"                                                                                              // 12
  }, "\n    ", Blaze.Each(function() {                                                                               // 13
    return Spacebars.call(view.lookup("liststudent"));                                                               // 14
  }, function() {                                                                                                    // 15
    return [ "\n      ", HTML.LI({                                                                                   // 16
      class: "list-group-item clearfix",                                                                             // 17
      id: function() {                                                                                               // 18
        return Spacebars.mustache(view.lookup("_id"));                                                               // 19
      },                                                                                                             // 20
      value: function() {                                                                                            // 21
        return Spacebars.mustache(view.lookup("fullname"));                                                          // 22
      }                                                                                                              // 23
    }, " ", Blaze.View("lookup:_id", function() {                                                                    // 24
      return Spacebars.mustache(view.lookup("_id"));                                                                 // 25
    }), " ", HTML.BR(), " ", Blaze.View("lookup:fullname", function() {                                              // 26
      return Spacebars.mustache(view.lookup("fullname"));                                                            // 27
    }), " ", HTML.BR(), "  ", Blaze.View("lookup:course", function() {                                               // 28
      return Spacebars.mustache(view.lookup("course"));                                                              // 29
    }), "  ", HTML.BR(), " ", Blaze.View("lookup:address", function() {                                              // 30
      return Spacebars.mustache(view.lookup("address"));                                                             // 31
    }), "\n      ", HTML.BUTTON({                                                                                    // 32
      id: "btnPortal",                                                                                               // 33
      class: "btn btn-success pull-right"                                                                            // 34
    }, "Show Portal"), "\n\t \n      "), "\n    " ];                                                                 // 35
  }), "\n  "), "\n"), "\n", HTML.Raw('<button class="btn btn-primary pull-right" id="btnAdd">ADD NEW</button>'), "\n"), "\n\t  ");
}));                                                                                                                 // 37
                                                                                                                     // 38
Template.__checkName("loggedIn");                                                                                    // 39
Template["loggedIn"] = new Template("Template.loggedIn", (function() {                                               // 40
  var view = this;                                                                                                   // 41
  return HTML.Raw("<h1> I am logged in</h1>");                                                                       // 42
}));                                                                                                                 // 43
                                                                                                                     // 44
Template.__checkName("notLoggedIn");                                                                                 // 45
Template["notLoggedIn"] = new Template("Template.notLoggedIn", (function() {                                         // 46
  var view = this;                                                                                                   // 47
  return HTML.Raw("<h1>Not Logged In</h1>");                                                                         // 48
}));                                                                                                                 // 49
                                                                                                                     // 50
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

},"template.main.js":function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// client/pages/template.main.js                                                                                     //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
                                                                                                                     // 1
Template.__checkName("main");                                                                                        // 2
Template["main"] = new Template("Template.main", (function() {                                                       // 3
  var view = this;                                                                                                   // 4
  return [ HTML.Raw("s\n<h1>This is main</h1>\n\n"), Spacebars.include(view.lookupTemplate("showStudents")) ];       // 5
}));                                                                                                                 // 6
                                                                                                                     // 7
Template.__checkName("loggedIn");                                                                                    // 8
Template["loggedIn"] = new Template("Template.loggedIn", (function() {                                               // 9
  var view = this;                                                                                                   // 10
  return HTML.Raw("<h1> I am logged in</h1>");                                                                       // 11
}));                                                                                                                 // 12
                                                                                                                     // 13
Template.__checkName("notLoggedIn");                                                                                 // 14
Template["notLoggedIn"] = new Template("Template.notLoggedIn", (function() {                                         // 15
  var view = this;                                                                                                   // 16
  return HTML.Raw("<h1>Not Logged In</h1>");                                                                         // 17
}));                                                                                                                 // 18
                                                                                                                     // 19
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}},"js":{"addnew.js":function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// client/js/addnew.js                                                                                               //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
                                                                                                                     //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

},"bootstrap.js":function(require){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// client/js/bootstrap.js                                                                                            //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
var _typeof2 = require("babel-runtime/helpers/typeof");                                                              //
                                                                                                                     //
var _typeof3 = _interopRequireDefault(_typeof2);                                                                     //
                                                                                                                     //
function _interopRequireDefault(obj) { return obj && obj.__esModule ? obj : { "default": obj }; }                    //
                                                                                                                     //
/*!                                                                                                                  // 1
 * Bootstrap v3.0.2 by @fat and @mdo                                                                                 //
 * Copyright 2013 Twitter, Inc.                                                                                      //
 * Licensed under http://www.apache.org/licenses/LICENSE-2.0                                                         //
 *                                                                                                                   //
 * Designed and built with all the love in the world by @mdo and @fat.                                               //
 */if (typeof jQuery === "undefined") {                                                                              //
  throw new Error("Bootstrap requires jQuery");                                                                      // 9
} /* ========================================================================                                        // 9
   * Bootstrap: transition.js v3.0.2                                                                                 //
   * http://getbootstrap.com/javascript/#transitions                                                                 //
   * ========================================================================                                        //
   * Copyright 2013 Twitter, Inc.                                                                                    //
   *                                                                                                                 //
   * Licensed under the Apache License, Version 2.0 (the "License");                                                 //
   * you may not use this file except in compliance with the License.                                                //
   * You may obtain a copy of the License at                                                                         //
   *                                                                                                                 //
   * http://www.apache.org/licenses/LICENSE-2.0                                                                      //
   *                                                                                                                 //
   * Unless required by applicable law or agreed to in writing, software                                             //
   * distributed under the License is distributed on an "AS IS" BASIS,                                               //
   * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                                        //
   * See the License for the specific language governing permissions and                                             //
   * limitations under the License.                                                                                  //
   * ======================================================================== */                                     //
                                                                                                                     //
+function ($) {                                                                                                      // 31
  "use strict"; // CSS TRANSITION SUPPORT (Shoutout: http://www.modernizr.com/)                                      // 31
  // ============================================================                                                    // 34
                                                                                                                     //
  function transitionEnd() {                                                                                         // 36
    var el = document.createElement('bootstrap');                                                                    // 37
    var transEndEventNames = {                                                                                       // 39
      'WebkitTransition': 'webkitTransitionEnd',                                                                     // 40
      'MozTransition': 'transitionend',                                                                              // 41
      'OTransition': 'oTransitionEnd otransitionend',                                                                // 42
      'transition': 'transitionend'                                                                                  // 43
    };                                                                                                               // 39
                                                                                                                     //
    for (var name in meteorBabelHelpers.sanitizeForInObject(transEndEventNames)) {                                   // 46
      if (el.style[name] !== undefined) {                                                                            // 47
        return {                                                                                                     // 48
          end: transEndEventNames[name]                                                                              // 48
        };                                                                                                           // 48
      }                                                                                                              // 49
    }                                                                                                                // 50
  } // http://blog.alexmaccaw.com/css-transitions                                                                    // 51
                                                                                                                     //
                                                                                                                     //
  $.fn.emulateTransitionEnd = function (duration) {                                                                  // 54
    var called = false,                                                                                              // 55
        $el = this;                                                                                                  // 55
    $(this).one($.support.transition.end, function () {                                                              // 56
      called = true;                                                                                                 // 56
    });                                                                                                              // 56
                                                                                                                     //
    var callback = function () {                                                                                     // 57
      if (!called) $($el).trigger($.support.transition.end);                                                         // 57
    };                                                                                                               // 57
                                                                                                                     //
    setTimeout(callback, duration);                                                                                  // 58
    return this;                                                                                                     // 59
  };                                                                                                                 // 60
                                                                                                                     //
  $(function () {                                                                                                    // 62
    $.support.transition = transitionEnd();                                                                          // 63
  });                                                                                                                // 64
}(jQuery); /* ========================================================================                               // 66
            * Bootstrap: alert.js v3.0.2                                                                             //
            * http://getbootstrap.com/javascript/#alerts                                                             //
            * ========================================================================                               //
            * Copyright 2013 Twitter, Inc.                                                                           //
            *                                                                                                        //
            * Licensed under the Apache License, Version 2.0 (the "License");                                        //
            * you may not use this file except in compliance with the License.                                       //
            * You may obtain a copy of the License at                                                                //
            *                                                                                                        //
            * http://www.apache.org/licenses/LICENSE-2.0                                                             //
            *                                                                                                        //
            * Unless required by applicable law or agreed to in writing, software                                    //
            * distributed under the License is distributed on an "AS IS" BASIS,                                      //
            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                               //
            * See the License for the specific language governing permissions and                                    //
            * limitations under the License.                                                                         //
            * ======================================================================== */                            //
+function ($) {                                                                                                      // 88
  "use strict"; // ALERT CLASS DEFINITION                                                                            // 88
  // ======================                                                                                          // 91
                                                                                                                     //
  var dismiss = '[data-dismiss="alert"]';                                                                            // 93
                                                                                                                     //
  var Alert = function (el) {                                                                                        // 94
    $(el).on('click', dismiss, this.close);                                                                          // 95
  };                                                                                                                 // 96
                                                                                                                     //
  Alert.prototype.close = function (e) {                                                                             // 98
    var $this = $(this);                                                                                             // 99
    var selector = $this.attr('data-target');                                                                        // 100
                                                                                                                     //
    if (!selector) {                                                                                                 // 102
      selector = $this.attr('href');                                                                                 // 103
      selector = selector && selector.replace(/.*(?=#[^\s]*$)/, ''); // strip for ie7                                // 104
    }                                                                                                                // 105
                                                                                                                     //
    var $parent = $(selector);                                                                                       // 107
    if (e) e.preventDefault();                                                                                       // 109
                                                                                                                     //
    if (!$parent.length) {                                                                                           // 111
      $parent = $this.hasClass('alert') ? $this : $this.parent();                                                    // 112
    }                                                                                                                // 113
                                                                                                                     //
    $parent.trigger(e = $.Event('close.bs.alert'));                                                                  // 115
    if (e.isDefaultPrevented()) return;                                                                              // 117
    $parent.removeClass('in');                                                                                       // 119
                                                                                                                     //
    function removeElement() {                                                                                       // 121
      $parent.trigger('closed.bs.alert').remove();                                                                   // 122
    }                                                                                                                // 123
                                                                                                                     //
    $.support.transition && $parent.hasClass('fade') ? $parent.one($.support.transition.end, removeElement).emulateTransitionEnd(150) : removeElement();
  }; // ALERT PLUGIN DEFINITION                                                                                      // 130
  // =======================                                                                                         // 134
                                                                                                                     //
                                                                                                                     //
  var old = $.fn.alert;                                                                                              // 136
                                                                                                                     //
  $.fn.alert = function (option) {                                                                                   // 138
    return this.each(function () {                                                                                   // 139
      var $this = $(this);                                                                                           // 140
      var data = $this.data('bs.alert');                                                                             // 141
      if (!data) $this.data('bs.alert', data = new Alert(this));                                                     // 143
      if (typeof option == 'string') data[option].call($this);                                                       // 144
    });                                                                                                              // 145
  };                                                                                                                 // 146
                                                                                                                     //
  $.fn.alert.Constructor = Alert; // ALERT NO CONFLICT                                                               // 148
  // =================                                                                                               // 152
                                                                                                                     //
  $.fn.alert.noConflict = function () {                                                                              // 154
    $.fn.alert = old;                                                                                                // 155
    return this;                                                                                                     // 156
  }; // ALERT DATA-API                                                                                               // 157
  // ==============                                                                                                  // 161
                                                                                                                     //
                                                                                                                     //
  $(document).on('click.bs.alert.data-api', dismiss, Alert.prototype.close);                                         // 163
}(jQuery); /* ========================================================================                               // 165
            * Bootstrap: button.js v3.0.2                                                                            //
            * http://getbootstrap.com/javascript/#buttons                                                            //
            * ========================================================================                               //
            * Copyright 2013 Twitter, Inc.                                                                           //
            *                                                                                                        //
            * Licensed under the Apache License, Version 2.0 (the "License");                                        //
            * you may not use this file except in compliance with the License.                                       //
            * You may obtain a copy of the License at                                                                //
            *                                                                                                        //
            * http://www.apache.org/licenses/LICENSE-2.0                                                             //
            *                                                                                                        //
            * Unless required by applicable law or agreed to in writing, software                                    //
            * distributed under the License is distributed on an "AS IS" BASIS,                                      //
            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                               //
            * See the License for the specific language governing permissions and                                    //
            * limitations under the License.                                                                         //
            * ======================================================================== */                            //
+function ($) {                                                                                                      // 187
  "use strict"; // BUTTON PUBLIC CLASS DEFINITION                                                                    // 187
  // ==============================                                                                                  // 190
                                                                                                                     //
  var Button = function (element, options) {                                                                         // 192
    this.$element = $(element);                                                                                      // 193
    this.options = $.extend({}, Button.DEFAULTS, options);                                                           // 194
  };                                                                                                                 // 195
                                                                                                                     //
  Button.DEFAULTS = {                                                                                                // 197
    loadingText: 'loading...'                                                                                        // 198
  };                                                                                                                 // 197
                                                                                                                     //
  Button.prototype.setState = function (state) {                                                                     // 201
    var d = 'disabled';                                                                                              // 202
    var $el = this.$element;                                                                                         // 203
    var val = $el.is('input') ? 'val' : 'html';                                                                      // 204
    var data = $el.data();                                                                                           // 205
    state = state + 'Text';                                                                                          // 207
    if (!data.resetText) $el.data('resetText', $el[val]());                                                          // 209
    $el[val](data[state] || this.options[state]); // push to event loop to allow forms to submit                     // 211
                                                                                                                     //
    setTimeout(function () {                                                                                         // 214
      state == 'loadingText' ? $el.addClass(d).attr(d, d) : $el.removeClass(d).removeAttr(d);                        // 215
    }, 0);                                                                                                           // 218
  };                                                                                                                 // 219
                                                                                                                     //
  Button.prototype.toggle = function () {                                                                            // 221
    var $parent = this.$element.closest('[data-toggle="buttons"]');                                                  // 222
                                                                                                                     //
    if ($parent.length) {                                                                                            // 224
      var $input = this.$element.find('input').prop('checked', !this.$element.hasClass('active')).trigger('change');
      if ($input.prop('type') === 'radio') $parent.find('.active').removeClass('active');                            // 228
    }                                                                                                                // 229
                                                                                                                     //
    this.$element.toggleClass('active');                                                                             // 231
  }; // BUTTON PLUGIN DEFINITION                                                                                     // 232
  // ========================                                                                                        // 236
                                                                                                                     //
                                                                                                                     //
  var old = $.fn.button;                                                                                             // 238
                                                                                                                     //
  $.fn.button = function (option) {                                                                                  // 240
    return this.each(function () {                                                                                   // 241
      var $this = $(this);                                                                                           // 242
      var data = $this.data('bs.button');                                                                            // 243
      var options = (typeof option === "undefined" ? "undefined" : (0, _typeof3.default)(option)) == 'object' && option;
      if (!data) $this.data('bs.button', data = new Button(this, options));                                          // 246
      if (option == 'toggle') data.toggle();else if (option) data.setState(option);                                  // 248
    });                                                                                                              // 250
  };                                                                                                                 // 251
                                                                                                                     //
  $.fn.button.Constructor = Button; // BUTTON NO CONFLICT                                                            // 253
  // ==================                                                                                              // 257
                                                                                                                     //
  $.fn.button.noConflict = function () {                                                                             // 259
    $.fn.button = old;                                                                                               // 260
    return this;                                                                                                     // 261
  }; // BUTTON DATA-API                                                                                              // 262
  // ===============                                                                                                 // 266
                                                                                                                     //
                                                                                                                     //
  $(document).on('click.bs.button.data-api', '[data-toggle^=button]', function (e) {                                 // 268
    var $btn = $(e.target);                                                                                          // 269
    if (!$btn.hasClass('btn')) $btn = $btn.closest('.btn');                                                          // 270
    $btn.button('toggle');                                                                                           // 271
    e.preventDefault();                                                                                              // 272
  });                                                                                                                // 273
}(jQuery); /* ========================================================================                               // 275
            * Bootstrap: carousel.js v3.0.2                                                                          //
            * http://getbootstrap.com/javascript/#carousel                                                           //
            * ========================================================================                               //
            * Copyright 2013 Twitter, Inc.                                                                           //
            *                                                                                                        //
            * Licensed under the Apache License, Version 2.0 (the "License");                                        //
            * you may not use this file except in compliance with the License.                                       //
            * You may obtain a copy of the License at                                                                //
            *                                                                                                        //
            * http://www.apache.org/licenses/LICENSE-2.0                                                             //
            *                                                                                                        //
            * Unless required by applicable law or agreed to in writing, software                                    //
            * distributed under the License is distributed on an "AS IS" BASIS,                                      //
            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                               //
            * See the License for the specific language governing permissions and                                    //
            * limitations under the License.                                                                         //
            * ======================================================================== */                            //
+function ($) {                                                                                                      // 297
  "use strict"; // CAROUSEL CLASS DEFINITION                                                                         // 297
  // =========================                                                                                       // 300
                                                                                                                     //
  var Carousel = function (element, options) {                                                                       // 302
    this.$element = $(element);                                                                                      // 303
    this.$indicators = this.$element.find('.carousel-indicators');                                                   // 304
    this.options = options;                                                                                          // 305
    this.paused = this.sliding = this.interval = this.$active = this.$items = null;                                  // 306
    this.options.pause == 'hover' && this.$element.on('mouseenter', $.proxy(this.pause, this)).on('mouseleave', $.proxy(this.cycle, this));
  };                                                                                                                 // 315
                                                                                                                     //
  Carousel.DEFAULTS = {                                                                                              // 317
    interval: 5000,                                                                                                  // 318
    pause: 'hover',                                                                                                  // 319
    wrap: true                                                                                                       // 320
  };                                                                                                                 // 317
                                                                                                                     //
  Carousel.prototype.cycle = function (e) {                                                                          // 323
    e || (this.paused = false);                                                                                      // 324
    this.interval && clearInterval(this.interval);                                                                   // 326
    this.options.interval && !this.paused && (this.interval = setInterval($.proxy(this.next, this), this.options.interval));
    return this;                                                                                                     // 332
  };                                                                                                                 // 333
                                                                                                                     //
  Carousel.prototype.getActiveIndex = function () {                                                                  // 335
    this.$active = this.$element.find('.item.active');                                                               // 336
    this.$items = this.$active.parent().children();                                                                  // 337
    return this.$items.index(this.$active);                                                                          // 339
  };                                                                                                                 // 340
                                                                                                                     //
  Carousel.prototype.to = function (pos) {                                                                           // 342
    var that = this;                                                                                                 // 343
    var activeIndex = this.getActiveIndex();                                                                         // 344
    if (pos > this.$items.length - 1 || pos < 0) return;                                                             // 346
    if (this.sliding) return this.$element.one('slid', function () {                                                 // 348
      that.to(pos);                                                                                                  // 348
    });                                                                                                              // 348
    if (activeIndex == pos) return this.pause().cycle();                                                             // 349
    return this.slide(pos > activeIndex ? 'next' : 'prev', $(this.$items[pos]));                                     // 351
  };                                                                                                                 // 352
                                                                                                                     //
  Carousel.prototype.pause = function (e) {                                                                          // 354
    e || (this.paused = true);                                                                                       // 355
                                                                                                                     //
    if (this.$element.find('.next, .prev').length && $.support.transition.end) {                                     // 357
      this.$element.trigger($.support.transition.end);                                                               // 358
      this.cycle(true);                                                                                              // 359
    }                                                                                                                // 360
                                                                                                                     //
    this.interval = clearInterval(this.interval);                                                                    // 362
    return this;                                                                                                     // 364
  };                                                                                                                 // 365
                                                                                                                     //
  Carousel.prototype.next = function () {                                                                            // 367
    if (this.sliding) return;                                                                                        // 368
    return this.slide('next');                                                                                       // 369
  };                                                                                                                 // 370
                                                                                                                     //
  Carousel.prototype.prev = function () {                                                                            // 372
    if (this.sliding) return;                                                                                        // 373
    return this.slide('prev');                                                                                       // 374
  };                                                                                                                 // 375
                                                                                                                     //
  Carousel.prototype.slide = function (type, next) {                                                                 // 377
    var $active = this.$element.find('.item.active');                                                                // 378
    var $next = next || $active[type]();                                                                             // 379
    var isCycling = this.interval;                                                                                   // 380
    var direction = type == 'next' ? 'left' : 'right';                                                               // 381
    var fallback = type == 'next' ? 'first' : 'last';                                                                // 382
    var that = this;                                                                                                 // 383
                                                                                                                     //
    if (!$next.length) {                                                                                             // 385
      if (!this.options.wrap) return;                                                                                // 386
      $next = this.$element.find('.item')[fallback]();                                                               // 387
    }                                                                                                                // 388
                                                                                                                     //
    this.sliding = true;                                                                                             // 390
    isCycling && this.pause();                                                                                       // 392
    var e = $.Event('slide.bs.carousel', {                                                                           // 394
      relatedTarget: $next[0],                                                                                       // 394
      direction: direction                                                                                           // 394
    });                                                                                                              // 394
    if ($next.hasClass('active')) return;                                                                            // 396
                                                                                                                     //
    if (this.$indicators.length) {                                                                                   // 398
      this.$indicators.find('.active').removeClass('active');                                                        // 399
      this.$element.one('slid', function () {                                                                        // 400
        var $nextIndicator = $(that.$indicators.children()[that.getActiveIndex()]);                                  // 401
        $nextIndicator && $nextIndicator.addClass('active');                                                         // 402
      });                                                                                                            // 403
    }                                                                                                                // 404
                                                                                                                     //
    if ($.support.transition && this.$element.hasClass('slide')) {                                                   // 406
      this.$element.trigger(e);                                                                                      // 407
      if (e.isDefaultPrevented()) return;                                                                            // 408
      $next.addClass(type);                                                                                          // 409
      $next[0].offsetWidth; // force reflow                                                                          // 410
                                                                                                                     //
      $active.addClass(direction);                                                                                   // 411
      $next.addClass(direction);                                                                                     // 412
      $active.one($.support.transition.end, function () {                                                            // 413
        $next.removeClass([type, direction].join(' ')).addClass('active');                                           // 415
        $active.removeClass(['active', direction].join(' '));                                                        // 416
        that.sliding = false;                                                                                        // 417
        setTimeout(function () {                                                                                     // 418
          that.$element.trigger('slid');                                                                             // 418
        }, 0);                                                                                                       // 418
      }).emulateTransitionEnd(1200);                                                                                 // 419
    } else {                                                                                                         // 421
      this.$element.trigger(e);                                                                                      // 422
      if (e.isDefaultPrevented()) return;                                                                            // 423
      $active.removeClass('active');                                                                                 // 424
      $next.addClass('active');                                                                                      // 425
      this.sliding = false;                                                                                          // 426
      this.$element.trigger('slid');                                                                                 // 427
    }                                                                                                                // 428
                                                                                                                     //
    isCycling && this.cycle();                                                                                       // 430
    return this;                                                                                                     // 432
  }; // CAROUSEL PLUGIN DEFINITION                                                                                   // 433
  // ==========================                                                                                      // 437
                                                                                                                     //
                                                                                                                     //
  var old = $.fn.carousel;                                                                                           // 439
                                                                                                                     //
  $.fn.carousel = function (option) {                                                                                // 441
    return this.each(function () {                                                                                   // 442
      var $this = $(this);                                                                                           // 443
      var data = $this.data('bs.carousel');                                                                          // 444
      var options = $.extend({}, Carousel.DEFAULTS, $this.data(), (typeof option === "undefined" ? "undefined" : (0, _typeof3.default)(option)) == 'object' && option);
      var action = typeof option == 'string' ? option : options.slide;                                               // 446
      if (!data) $this.data('bs.carousel', data = new Carousel(this, options));                                      // 448
      if (typeof option == 'number') data.to(option);else if (action) data[action]();else if (options.interval) data.pause().cycle();
    });                                                                                                              // 452
  };                                                                                                                 // 453
                                                                                                                     //
  $.fn.carousel.Constructor = Carousel; // CAROUSEL NO CONFLICT                                                      // 455
  // ====================                                                                                            // 459
                                                                                                                     //
  $.fn.carousel.noConflict = function () {                                                                           // 461
    $.fn.carousel = old;                                                                                             // 462
    return this;                                                                                                     // 463
  }; // CAROUSEL DATA-API                                                                                            // 464
  // =================                                                                                               // 468
                                                                                                                     //
                                                                                                                     //
  $(document).on('click.bs.carousel.data-api', '[data-slide], [data-slide-to]', function (e) {                       // 470
    var $this = $(this),                                                                                             // 471
        href;                                                                                                        // 471
    var $target = $($this.attr('data-target') || (href = $this.attr('href')) && href.replace(/.*(?=#[^\s]+$)/, '')); //strip for ie7
                                                                                                                     //
    var options = $.extend({}, $target.data(), $this.data());                                                        // 473
    var slideIndex = $this.attr('data-slide-to');                                                                    // 474
    if (slideIndex) options.interval = false;                                                                        // 475
    $target.carousel(options);                                                                                       // 477
                                                                                                                     //
    if (slideIndex = $this.attr('data-slide-to')) {                                                                  // 479
      $target.data('bs.carousel').to(slideIndex);                                                                    // 480
    }                                                                                                                // 481
                                                                                                                     //
    e.preventDefault();                                                                                              // 483
  });                                                                                                                // 484
  $(window).on('load', function () {                                                                                 // 486
    $('[data-ride="carousel"]').each(function () {                                                                   // 487
      var $carousel = $(this);                                                                                       // 488
      $carousel.carousel($carousel.data());                                                                          // 489
    });                                                                                                              // 490
  });                                                                                                                // 491
}(jQuery); /* ========================================================================                               // 493
            * Bootstrap: collapse.js v3.0.2                                                                          //
            * http://getbootstrap.com/javascript/#collapse                                                           //
            * ========================================================================                               //
            * Copyright 2013 Twitter, Inc.                                                                           //
            *                                                                                                        //
            * Licensed under the Apache License, Version 2.0 (the "License");                                        //
            * you may not use this file except in compliance with the License.                                       //
            * You may obtain a copy of the License at                                                                //
            *                                                                                                        //
            * http://www.apache.org/licenses/LICENSE-2.0                                                             //
            *                                                                                                        //
            * Unless required by applicable law or agreed to in writing, software                                    //
            * distributed under the License is distributed on an "AS IS" BASIS,                                      //
            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                               //
            * See the License for the specific language governing permissions and                                    //
            * limitations under the License.                                                                         //
            * ======================================================================== */                            //
+function ($) {                                                                                                      // 515
  "use strict"; // COLLAPSE PUBLIC CLASS DEFINITION                                                                  // 515
  // ================================                                                                                // 518
                                                                                                                     //
  var Collapse = function (element, options) {                                                                       // 520
    this.$element = $(element);                                                                                      // 521
    this.options = $.extend({}, Collapse.DEFAULTS, options);                                                         // 522
    this.transitioning = null;                                                                                       // 523
    if (this.options.parent) this.$parent = $(this.options.parent);                                                  // 525
    if (this.options.toggle) this.toggle();                                                                          // 526
  };                                                                                                                 // 527
                                                                                                                     //
  Collapse.DEFAULTS = {                                                                                              // 529
    toggle: true                                                                                                     // 530
  };                                                                                                                 // 529
                                                                                                                     //
  Collapse.prototype.dimension = function () {                                                                       // 533
    var hasWidth = this.$element.hasClass('width');                                                                  // 534
    return hasWidth ? 'width' : 'height';                                                                            // 535
  };                                                                                                                 // 536
                                                                                                                     //
  Collapse.prototype.show = function () {                                                                            // 538
    if (this.transitioning || this.$element.hasClass('in')) return;                                                  // 539
    var startEvent = $.Event('show.bs.collapse');                                                                    // 541
    this.$element.trigger(startEvent);                                                                               // 542
    if (startEvent.isDefaultPrevented()) return;                                                                     // 543
    var actives = this.$parent && this.$parent.find('> .panel > .in');                                               // 545
                                                                                                                     //
    if (actives && actives.length) {                                                                                 // 547
      var hasData = actives.data('bs.collapse');                                                                     // 548
      if (hasData && hasData.transitioning) return;                                                                  // 549
      actives.collapse('hide');                                                                                      // 550
      hasData || actives.data('bs.collapse', null);                                                                  // 551
    }                                                                                                                // 552
                                                                                                                     //
    var dimension = this.dimension();                                                                                // 554
    this.$element.removeClass('collapse').addClass('collapsing')[dimension](0);                                      // 556
    this.transitioning = 1;                                                                                          // 561
                                                                                                                     //
    var complete = function () {                                                                                     // 563
      this.$element.removeClass('collapsing').addClass('in')[dimension]('auto');                                     // 564
      this.transitioning = 0;                                                                                        // 568
      this.$element.trigger('shown.bs.collapse');                                                                    // 569
    };                                                                                                               // 570
                                                                                                                     //
    if (!$.support.transition) return complete.call(this);                                                           // 572
    var scrollSize = $.camelCase(['scroll', dimension].join('-'));                                                   // 574
    this.$element.one($.support.transition.end, $.proxy(complete, this)).emulateTransitionEnd(350)[dimension](this.$element[0][scrollSize]);
  };                                                                                                                 // 580
                                                                                                                     //
  Collapse.prototype.hide = function () {                                                                            // 582
    if (this.transitioning || !this.$element.hasClass('in')) return;                                                 // 583
    var startEvent = $.Event('hide.bs.collapse');                                                                    // 585
    this.$element.trigger(startEvent);                                                                               // 586
    if (startEvent.isDefaultPrevented()) return;                                                                     // 587
    var dimension = this.dimension();                                                                                // 589
    this.$element[dimension](this.$element[dimension]())[0].offsetHeight;                                            // 591
    this.$element.addClass('collapsing').removeClass('collapse').removeClass('in');                                  // 595
    this.transitioning = 1;                                                                                          // 600
                                                                                                                     //
    var complete = function () {                                                                                     // 602
      this.transitioning = 0;                                                                                        // 603
      this.$element.trigger('hidden.bs.collapse').removeClass('collapsing').addClass('collapse');                    // 604
    };                                                                                                               // 608
                                                                                                                     //
    if (!$.support.transition) return complete.call(this);                                                           // 610
    this.$element[dimension](0).one($.support.transition.end, $.proxy(complete, this)).emulateTransitionEnd(350);    // 612
  };                                                                                                                 // 616
                                                                                                                     //
  Collapse.prototype.toggle = function () {                                                                          // 618
    this[this.$element.hasClass('in') ? 'hide' : 'show']();                                                          // 619
  }; // COLLAPSE PLUGIN DEFINITION                                                                                   // 620
  // ==========================                                                                                      // 624
                                                                                                                     //
                                                                                                                     //
  var old = $.fn.collapse;                                                                                           // 626
                                                                                                                     //
  $.fn.collapse = function (option) {                                                                                // 628
    return this.each(function () {                                                                                   // 629
      var $this = $(this);                                                                                           // 630
      var data = $this.data('bs.collapse');                                                                          // 631
      var options = $.extend({}, Collapse.DEFAULTS, $this.data(), (typeof option === "undefined" ? "undefined" : (0, _typeof3.default)(option)) == 'object' && option);
      if (!data) $this.data('bs.collapse', data = new Collapse(this, options));                                      // 634
      if (typeof option == 'string') data[option]();                                                                 // 635
    });                                                                                                              // 636
  };                                                                                                                 // 637
                                                                                                                     //
  $.fn.collapse.Constructor = Collapse; // COLLAPSE NO CONFLICT                                                      // 639
  // ====================                                                                                            // 643
                                                                                                                     //
  $.fn.collapse.noConflict = function () {                                                                           // 645
    $.fn.collapse = old;                                                                                             // 646
    return this;                                                                                                     // 647
  }; // COLLAPSE DATA-API                                                                                            // 648
  // =================                                                                                               // 652
                                                                                                                     //
                                                                                                                     //
  $(document).on('click.bs.collapse.data-api', '[data-toggle=collapse]', function (e) {                              // 654
    var $this = $(this),                                                                                             // 655
        href;                                                                                                        // 655
    var target = $this.attr('data-target') || e.preventDefault() || (href = $this.attr('href')) && href.replace(/.*(?=#[^\s]+$)/, ''); //strip for ie7
                                                                                                                     //
    var $target = $(target);                                                                                         // 659
    var data = $target.data('bs.collapse');                                                                          // 660
    var option = data ? 'toggle' : $this.data();                                                                     // 661
    var parent = $this.attr('data-parent');                                                                          // 662
    var $parent = parent && $(parent);                                                                               // 663
                                                                                                                     //
    if (!data || !data.transitioning) {                                                                              // 665
      if ($parent) $parent.find('[data-toggle=collapse][data-parent="' + parent + '"]').not($this).addClass('collapsed');
      $this[$target.hasClass('in') ? 'addClass' : 'removeClass']('collapsed');                                       // 667
    }                                                                                                                // 668
                                                                                                                     //
    $target.collapse(option);                                                                                        // 670
  });                                                                                                                // 671
}(jQuery); /* ========================================================================                               // 673
            * Bootstrap: dropdown.js v3.0.2                                                                          //
            * http://getbootstrap.com/javascript/#dropdowns                                                          //
            * ========================================================================                               //
            * Copyright 2013 Twitter, Inc.                                                                           //
            *                                                                                                        //
            * Licensed under the Apache License, Version 2.0 (the "License");                                        //
            * you may not use this file except in compliance with the License.                                       //
            * You may obtain a copy of the License at                                                                //
            *                                                                                                        //
            * http://www.apache.org/licenses/LICENSE-2.0                                                             //
            *                                                                                                        //
            * Unless required by applicable law or agreed to in writing, software                                    //
            * distributed under the License is distributed on an "AS IS" BASIS,                                      //
            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                               //
            * See the License for the specific language governing permissions and                                    //
            * limitations under the License.                                                                         //
            * ======================================================================== */                            //
+function ($) {                                                                                                      // 695
  "use strict"; // DROPDOWN CLASS DEFINITION                                                                         // 695
  // =========================                                                                                       // 698
                                                                                                                     //
  var backdrop = '.dropdown-backdrop';                                                                               // 700
  var toggle = '[data-toggle=dropdown]';                                                                             // 701
                                                                                                                     //
  var Dropdown = function (element) {                                                                                // 702
    var $el = $(element).on('click.bs.dropdown', this.toggle);                                                       // 703
  };                                                                                                                 // 704
                                                                                                                     //
  Dropdown.prototype.toggle = function (e) {                                                                         // 706
    var $this = $(this);                                                                                             // 707
    if ($this.is('.disabled, :disabled')) return;                                                                    // 709
    var $parent = getParent($this);                                                                                  // 711
    var isActive = $parent.hasClass('open');                                                                         // 712
    clearMenus();                                                                                                    // 714
                                                                                                                     //
    if (!isActive) {                                                                                                 // 716
      if ('ontouchstart' in document.documentElement && !$parent.closest('.navbar-nav').length) {                    // 717
        // if mobile we we use a backdrop because click events don't delegate                                        // 718
        $('<div class="dropdown-backdrop"/>').insertAfter($(this)).on('click', clearMenus);                          // 719
      }                                                                                                              // 720
                                                                                                                     //
      $parent.trigger(e = $.Event('show.bs.dropdown'));                                                              // 722
      if (e.isDefaultPrevented()) return;                                                                            // 724
      $parent.toggleClass('open').trigger('shown.bs.dropdown');                                                      // 726
      $this.focus();                                                                                                 // 730
    }                                                                                                                // 731
                                                                                                                     //
    return false;                                                                                                    // 733
  };                                                                                                                 // 734
                                                                                                                     //
  Dropdown.prototype.keydown = function (e) {                                                                        // 736
    if (!/(38|40|27)/.test(e.keyCode)) return;                                                                       // 737
    var $this = $(this);                                                                                             // 739
    e.preventDefault();                                                                                              // 741
    e.stopPropagation();                                                                                             // 742
    if ($this.is('.disabled, :disabled')) return;                                                                    // 744
    var $parent = getParent($this);                                                                                  // 746
    var isActive = $parent.hasClass('open');                                                                         // 747
                                                                                                                     //
    if (!isActive || isActive && e.keyCode == 27) {                                                                  // 749
      if (e.which == 27) $parent.find(toggle).focus();                                                               // 750
      return $this.click();                                                                                          // 751
    }                                                                                                                // 752
                                                                                                                     //
    var $items = $('[role=menu] li:not(.divider):visible a', $parent);                                               // 754
    if (!$items.length) return;                                                                                      // 756
    var index = $items.index($items.filter(':focus'));                                                               // 758
    if (e.keyCode == 38 && index > 0) index--; // up                                                                 // 760
                                                                                                                     //
    if (e.keyCode == 40 && index < $items.length - 1) index++; // down                                               // 761
                                                                                                                     //
    if (!~index) index = 0;                                                                                          // 762
    $items.eq(index).focus();                                                                                        // 764
  };                                                                                                                 // 765
                                                                                                                     //
  function clearMenus() {                                                                                            // 767
    $(backdrop).remove();                                                                                            // 768
    $(toggle).each(function (e) {                                                                                    // 769
      var $parent = getParent($(this));                                                                              // 770
      if (!$parent.hasClass('open')) return;                                                                         // 771
      $parent.trigger(e = $.Event('hide.bs.dropdown'));                                                              // 772
      if (e.isDefaultPrevented()) return;                                                                            // 773
      $parent.removeClass('open').trigger('hidden.bs.dropdown');                                                     // 774
    });                                                                                                              // 775
  }                                                                                                                  // 776
                                                                                                                     //
  function getParent($this) {                                                                                        // 778
    var selector = $this.attr('data-target');                                                                        // 779
                                                                                                                     //
    if (!selector) {                                                                                                 // 781
      selector = $this.attr('href');                                                                                 // 782
      selector = selector && /#/.test(selector) && selector.replace(/.*(?=#[^\s]*$)/, ''); //strip for ie7           // 783
    }                                                                                                                // 784
                                                                                                                     //
    var $parent = selector && $(selector);                                                                           // 786
    return $parent && $parent.length ? $parent : $this.parent();                                                     // 788
  } // DROPDOWN PLUGIN DEFINITION                                                                                    // 789
  // ==========================                                                                                      // 793
                                                                                                                     //
                                                                                                                     //
  var old = $.fn.dropdown;                                                                                           // 795
                                                                                                                     //
  $.fn.dropdown = function (option) {                                                                                // 797
    return this.each(function () {                                                                                   // 798
      var $this = $(this);                                                                                           // 799
      var data = $this.data('dropdown');                                                                             // 800
      if (!data) $this.data('dropdown', data = new Dropdown(this));                                                  // 802
      if (typeof option == 'string') data[option].call($this);                                                       // 803
    });                                                                                                              // 804
  };                                                                                                                 // 805
                                                                                                                     //
  $.fn.dropdown.Constructor = Dropdown; // DROPDOWN NO CONFLICT                                                      // 807
  // ====================                                                                                            // 811
                                                                                                                     //
  $.fn.dropdown.noConflict = function () {                                                                           // 813
    $.fn.dropdown = old;                                                                                             // 814
    return this;                                                                                                     // 815
  }; // APPLY TO STANDARD DROPDOWN ELEMENTS                                                                          // 816
  // ===================================                                                                             // 820
                                                                                                                     //
                                                                                                                     //
  $(document).on('click.bs.dropdown.data-api', clearMenus).on('click.bs.dropdown.data-api', '.dropdown form', function (e) {
    e.stopPropagation();                                                                                             // 824
  }).on('click.bs.dropdown.data-api', toggle, Dropdown.prototype.toggle).on('keydown.bs.dropdown.data-api', toggle + ', [role=menu]', Dropdown.prototype.keydown);
}(jQuery); /* ========================================================================                               // 828
            * Bootstrap: modal.js v3.0.2                                                                             //
            * http://getbootstrap.com/javascript/#modals                                                             //
            * ========================================================================                               //
            * Copyright 2013 Twitter, Inc.                                                                           //
            *                                                                                                        //
            * Licensed under the Apache License, Version 2.0 (the "License");                                        //
            * you may not use this file except in compliance with the License.                                       //
            * You may obtain a copy of the License at                                                                //
            *                                                                                                        //
            * http://www.apache.org/licenses/LICENSE-2.0                                                             //
            *                                                                                                        //
            * Unless required by applicable law or agreed to in writing, software                                    //
            * distributed under the License is distributed on an "AS IS" BASIS,                                      //
            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                               //
            * See the License for the specific language governing permissions and                                    //
            * limitations under the License.                                                                         //
            * ======================================================================== */                            //
+function ($) {                                                                                                      // 850
  "use strict"; // MODAL CLASS DEFINITION                                                                            // 850
  // ======================                                                                                          // 853
                                                                                                                     //
  var Modal = function (element, options) {                                                                          // 855
    this.options = options;                                                                                          // 856
    this.$element = $(element);                                                                                      // 857
    this.$backdrop = this.isShown = null;                                                                            // 858
    if (this.options.remote) this.$element.load(this.options.remote);                                                // 861
  };                                                                                                                 // 862
                                                                                                                     //
  Modal.DEFAULTS = {                                                                                                 // 864
    backdrop: true,                                                                                                  // 865
    keyboard: true,                                                                                                  // 866
    show: true                                                                                                       // 867
  };                                                                                                                 // 864
                                                                                                                     //
  Modal.prototype.toggle = function (_relatedTarget) {                                                               // 870
    return this[!this.isShown ? 'show' : 'hide'](_relatedTarget);                                                    // 871
  };                                                                                                                 // 872
                                                                                                                     //
  Modal.prototype.show = function (_relatedTarget) {                                                                 // 874
    var that = this;                                                                                                 // 875
    var e = $.Event('show.bs.modal', {                                                                               // 876
      relatedTarget: _relatedTarget                                                                                  // 876
    });                                                                                                              // 876
    this.$element.trigger(e);                                                                                        // 878
    if (this.isShown || e.isDefaultPrevented()) return;                                                              // 880
    this.isShown = true;                                                                                             // 882
    this.escape();                                                                                                   // 884
    this.$element.on('click.dismiss.modal', '[data-dismiss="modal"]', $.proxy(this.hide, this));                     // 886
    this.backdrop(function () {                                                                                      // 888
      var transition = $.support.transition && that.$element.hasClass('fade');                                       // 889
                                                                                                                     //
      if (!that.$element.parent().length) {                                                                          // 891
        that.$element.appendTo(document.body); // don't move modals dom position                                     // 892
      }                                                                                                              // 893
                                                                                                                     //
      that.$element.show();                                                                                          // 895
                                                                                                                     //
      if (transition) {                                                                                              // 897
        that.$element[0].offsetWidth; // force reflow                                                                // 898
      }                                                                                                              // 899
                                                                                                                     //
      that.$element.addClass('in').attr('aria-hidden', false);                                                       // 901
      that.enforceFocus();                                                                                           // 905
      var e = $.Event('shown.bs.modal', {                                                                            // 907
        relatedTarget: _relatedTarget                                                                                // 907
      });                                                                                                            // 907
      transition ? that.$element.find('.modal-dialog') // wait for modal to slide in                                 // 909
      .one($.support.transition.end, function () {                                                                   // 910
        that.$element.focus().trigger(e);                                                                            // 912
      }).emulateTransitionEnd(300) : that.$element.focus().trigger(e);                                               // 913
    });                                                                                                              // 916
  };                                                                                                                 // 917
                                                                                                                     //
  Modal.prototype.hide = function (e) {                                                                              // 919
    if (e) e.preventDefault();                                                                                       // 920
    e = $.Event('hide.bs.modal');                                                                                    // 922
    this.$element.trigger(e);                                                                                        // 924
    if (!this.isShown || e.isDefaultPrevented()) return;                                                             // 926
    this.isShown = false;                                                                                            // 928
    this.escape();                                                                                                   // 930
    $(document).off('focusin.bs.modal');                                                                             // 932
    this.$element.removeClass('in').attr('aria-hidden', true).off('click.dismiss.modal');                            // 934
    $.support.transition && this.$element.hasClass('fade') ? this.$element.one($.support.transition.end, $.proxy(this.hideModal, this)).emulateTransitionEnd(300) : this.hideModal();
  };                                                                                                                 // 944
                                                                                                                     //
  Modal.prototype.enforceFocus = function () {                                                                       // 946
    $(document).off('focusin.bs.modal') // guard against infinite focus loop                                         // 947
    .on('focusin.bs.modal', $.proxy(function (e) {                                                                   // 947
      if (this.$element[0] !== e.target && !this.$element.has(e.target).length) {                                    // 950
        this.$element.focus();                                                                                       // 951
      }                                                                                                              // 952
    }, this));                                                                                                       // 953
  };                                                                                                                 // 954
                                                                                                                     //
  Modal.prototype.escape = function () {                                                                             // 956
    if (this.isShown && this.options.keyboard) {                                                                     // 957
      this.$element.on('keyup.dismiss.bs.modal', $.proxy(function (e) {                                              // 958
        e.which == 27 && this.hide();                                                                                // 959
      }, this));                                                                                                     // 960
    } else if (!this.isShown) {                                                                                      // 961
      this.$element.off('keyup.dismiss.bs.modal');                                                                   // 962
    }                                                                                                                // 963
  };                                                                                                                 // 964
                                                                                                                     //
  Modal.prototype.hideModal = function () {                                                                          // 966
    var that = this;                                                                                                 // 967
    this.$element.hide();                                                                                            // 968
    this.backdrop(function () {                                                                                      // 969
      that.removeBackdrop();                                                                                         // 970
      that.$element.trigger('hidden.bs.modal');                                                                      // 971
    });                                                                                                              // 972
  };                                                                                                                 // 973
                                                                                                                     //
  Modal.prototype.removeBackdrop = function () {                                                                     // 975
    this.$backdrop && this.$backdrop.remove();                                                                       // 976
    this.$backdrop = null;                                                                                           // 977
  };                                                                                                                 // 978
                                                                                                                     //
  Modal.prototype.backdrop = function (callback) {                                                                   // 980
    var that = this;                                                                                                 // 981
    var animate = this.$element.hasClass('fade') ? 'fade' : '';                                                      // 982
                                                                                                                     //
    if (this.isShown && this.options.backdrop) {                                                                     // 984
      var doAnimate = $.support.transition && animate;                                                               // 985
      this.$backdrop = $('<div class="modal-backdrop ' + animate + '" />').appendTo(document.body);                  // 987
      this.$element.on('click.dismiss.modal', $.proxy(function (e) {                                                 // 990
        if (e.target !== e.currentTarget) return;                                                                    // 991
        this.options.backdrop == 'static' ? this.$element[0].focus.call(this.$element[0]) : this.hide.call(this);    // 992
      }, this));                                                                                                     // 995
      if (doAnimate) this.$backdrop[0].offsetWidth; // force reflow                                                  // 997
                                                                                                                     //
      this.$backdrop.addClass('in');                                                                                 // 999
      if (!callback) return;                                                                                         // 1001
      doAnimate ? this.$backdrop.one($.support.transition.end, callback).emulateTransitionEnd(150) : callback();     // 1003
    } else if (!this.isShown && this.$backdrop) {                                                                    // 1009
      this.$backdrop.removeClass('in');                                                                              // 1010
      $.support.transition && this.$element.hasClass('fade') ? this.$backdrop.one($.support.transition.end, callback).emulateTransitionEnd(150) : callback();
    } else if (callback) {                                                                                           // 1018
      callback();                                                                                                    // 1019
    }                                                                                                                // 1020
  }; // MODAL PLUGIN DEFINITION                                                                                      // 1021
  // =======================                                                                                         // 1025
                                                                                                                     //
                                                                                                                     //
  var old = $.fn.modal;                                                                                              // 1027
                                                                                                                     //
  $.fn.modal = function (option, _relatedTarget) {                                                                   // 1029
    return this.each(function () {                                                                                   // 1030
      var $this = $(this);                                                                                           // 1031
      var data = $this.data('bs.modal');                                                                             // 1032
      var options = $.extend({}, Modal.DEFAULTS, $this.data(), (typeof option === "undefined" ? "undefined" : (0, _typeof3.default)(option)) == 'object' && option);
      if (!data) $this.data('bs.modal', data = new Modal(this, options));                                            // 1035
      if (typeof option == 'string') data[option](_relatedTarget);else if (options.show) data.show(_relatedTarget);  // 1036
    });                                                                                                              // 1038
  };                                                                                                                 // 1039
                                                                                                                     //
  $.fn.modal.Constructor = Modal; // MODAL NO CONFLICT                                                               // 1041
  // =================                                                                                               // 1045
                                                                                                                     //
  $.fn.modal.noConflict = function () {                                                                              // 1047
    $.fn.modal = old;                                                                                                // 1048
    return this;                                                                                                     // 1049
  }; // MODAL DATA-API                                                                                               // 1050
  // ==============                                                                                                  // 1054
                                                                                                                     //
                                                                                                                     //
  $(document).on('click.bs.modal.data-api', '[data-toggle="modal"]', function (e) {                                  // 1056
    var $this = $(this);                                                                                             // 1057
    var href = $this.attr('href');                                                                                   // 1058
    var $target = $($this.attr('data-target') || href && href.replace(/.*(?=#[^\s]+$)/, '')); //strip for ie7        // 1059
                                                                                                                     //
    var option = $target.data('modal') ? 'toggle' : $.extend({                                                       // 1060
      remote: !/#/.test(href) && href                                                                                // 1060
    }, $target.data(), $this.data());                                                                                // 1060
    e.preventDefault();                                                                                              // 1062
    $target.modal(option, this).one('hide', function () {                                                            // 1064
      $this.is(':visible') && $this.focus();                                                                         // 1067
    });                                                                                                              // 1068
  });                                                                                                                // 1069
  $(document).on('show.bs.modal', '.modal', function () {                                                            // 1071
    $(document.body).addClass('modal-open');                                                                         // 1072
  }).on('hidden.bs.modal', '.modal', function () {                                                                   // 1072
    $(document.body).removeClass('modal-open');                                                                      // 1073
  });                                                                                                                // 1073
}(jQuery); /* ========================================================================                               // 1075
            * Bootstrap: tooltip.js v3.0.2                                                                           //
            * http://getbootstrap.com/javascript/#tooltip                                                            //
            * Inspired by the original jQuery.tipsy by Jason Frame                                                   //
            * ========================================================================                               //
            * Copyright 2013 Twitter, Inc.                                                                           //
            *                                                                                                        //
            * Licensed under the Apache License, Version 2.0 (the "License");                                        //
            * you may not use this file except in compliance with the License.                                       //
            * You may obtain a copy of the License at                                                                //
            *                                                                                                        //
            * http://www.apache.org/licenses/LICENSE-2.0                                                             //
            *                                                                                                        //
            * Unless required by applicable law or agreed to in writing, software                                    //
            * distributed under the License is distributed on an "AS IS" BASIS,                                      //
            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                               //
            * See the License for the specific language governing permissions and                                    //
            * limitations under the License.                                                                         //
            * ======================================================================== */                            //
+function ($) {                                                                                                      // 1098
  "use strict"; // TOOLTIP PUBLIC CLASS DEFINITION                                                                   // 1098
  // ===============================                                                                                 // 1101
                                                                                                                     //
  var Tooltip = function (element, options) {                                                                        // 1103
    this.type = this.options = this.enabled = this.timeout = this.hoverState = this.$element = null;                 // 1104
    this.init('tooltip', element, options);                                                                          // 1111
  };                                                                                                                 // 1112
                                                                                                                     //
  Tooltip.DEFAULTS = {                                                                                               // 1114
    animation: true,                                                                                                 // 1115
    placement: 'top',                                                                                                // 1116
    selector: false,                                                                                                 // 1117
    template: '<div class="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-inner"></div></div>',       // 1118
    trigger: 'hover focus',                                                                                          // 1119
    title: '',                                                                                                       // 1120
    delay: 0,                                                                                                        // 1121
    html: false,                                                                                                     // 1122
    container: false                                                                                                 // 1123
  };                                                                                                                 // 1114
                                                                                                                     //
  Tooltip.prototype.init = function (type, element, options) {                                                       // 1126
    this.enabled = true;                                                                                             // 1127
    this.type = type;                                                                                                // 1128
    this.$element = $(element);                                                                                      // 1129
    this.options = this.getOptions(options);                                                                         // 1130
    var triggers = this.options.trigger.split(' ');                                                                  // 1132
                                                                                                                     //
    for (var i = triggers.length; i--;) {                                                                            // 1134
      var trigger = triggers[i];                                                                                     // 1135
                                                                                                                     //
      if (trigger == 'click') {                                                                                      // 1137
        this.$element.on('click.' + this.type, this.options.selector, $.proxy(this.toggle, this));                   // 1138
      } else if (trigger != 'manual') {                                                                              // 1139
        var eventIn = trigger == 'hover' ? 'mouseenter' : 'focus';                                                   // 1140
        var eventOut = trigger == 'hover' ? 'mouseleave' : 'blur';                                                   // 1141
        this.$element.on(eventIn + '.' + this.type, this.options.selector, $.proxy(this.enter, this));               // 1143
        this.$element.on(eventOut + '.' + this.type, this.options.selector, $.proxy(this.leave, this));              // 1144
      }                                                                                                              // 1145
    }                                                                                                                // 1146
                                                                                                                     //
    this.options.selector ? this._options = $.extend({}, this.options, {                                             // 1148
      trigger: 'manual',                                                                                             // 1149
      selector: ''                                                                                                   // 1149
    }) : this.fixTitle();                                                                                            // 1149
  };                                                                                                                 // 1151
                                                                                                                     //
  Tooltip.prototype.getDefaults = function () {                                                                      // 1153
    return Tooltip.DEFAULTS;                                                                                         // 1154
  };                                                                                                                 // 1155
                                                                                                                     //
  Tooltip.prototype.getOptions = function (options) {                                                                // 1157
    options = $.extend({}, this.getDefaults(), this.$element.data(), options);                                       // 1158
                                                                                                                     //
    if (options.delay && typeof options.delay == 'number') {                                                         // 1160
      options.delay = {                                                                                              // 1161
        show: options.delay,                                                                                         // 1162
        hide: options.delay                                                                                          // 1163
      };                                                                                                             // 1161
    }                                                                                                                // 1165
                                                                                                                     //
    return options;                                                                                                  // 1167
  };                                                                                                                 // 1168
                                                                                                                     //
  Tooltip.prototype.getDelegateOptions = function () {                                                               // 1170
    var options = {};                                                                                                // 1171
    var defaults = this.getDefaults();                                                                               // 1172
    this._options && $.each(this._options, function (key, value) {                                                   // 1174
      if (defaults[key] != value) options[key] = value;                                                              // 1175
    });                                                                                                              // 1176
    return options;                                                                                                  // 1178
  };                                                                                                                 // 1179
                                                                                                                     //
  Tooltip.prototype.enter = function (obj) {                                                                         // 1181
    var self = obj instanceof this.constructor ? obj : $(obj.currentTarget)[this.type](this.getDelegateOptions()).data('bs.' + this.type);
    clearTimeout(self.timeout);                                                                                      // 1185
    self.hoverState = 'in';                                                                                          // 1187
    if (!self.options.delay || !self.options.delay.show) return self.show();                                         // 1189
    self.timeout = setTimeout(function () {                                                                          // 1191
      if (self.hoverState == 'in') self.show();                                                                      // 1192
    }, self.options.delay.show);                                                                                     // 1193
  };                                                                                                                 // 1194
                                                                                                                     //
  Tooltip.prototype.leave = function (obj) {                                                                         // 1196
    var self = obj instanceof this.constructor ? obj : $(obj.currentTarget)[this.type](this.getDelegateOptions()).data('bs.' + this.type);
    clearTimeout(self.timeout);                                                                                      // 1200
    self.hoverState = 'out';                                                                                         // 1202
    if (!self.options.delay || !self.options.delay.hide) return self.hide();                                         // 1204
    self.timeout = setTimeout(function () {                                                                          // 1206
      if (self.hoverState == 'out') self.hide();                                                                     // 1207
    }, self.options.delay.hide);                                                                                     // 1208
  };                                                                                                                 // 1209
                                                                                                                     //
  Tooltip.prototype.show = function () {                                                                             // 1211
    var e = $.Event('show.bs.' + this.type);                                                                         // 1212
                                                                                                                     //
    if (this.hasContent() && this.enabled) {                                                                         // 1214
      this.$element.trigger(e);                                                                                      // 1215
      if (e.isDefaultPrevented()) return;                                                                            // 1217
      var $tip = this.tip();                                                                                         // 1219
      this.setContent();                                                                                             // 1221
      if (this.options.animation) $tip.addClass('fade');                                                             // 1223
      var placement = typeof this.options.placement == 'function' ? this.options.placement.call(this, $tip[0], this.$element[0]) : this.options.placement;
      var autoToken = /\s?auto?\s?/i;                                                                                // 1229
      var autoPlace = autoToken.test(placement);                                                                     // 1230
      if (autoPlace) placement = placement.replace(autoToken, '') || 'top';                                          // 1231
      $tip.detach().css({                                                                                            // 1233
        top: 0,                                                                                                      // 1235
        left: 0,                                                                                                     // 1235
        display: 'block'                                                                                             // 1235
      }).addClass(placement);                                                                                        // 1235
      this.options.container ? $tip.appendTo(this.options.container) : $tip.insertAfter(this.$element);              // 1238
      var pos = this.getPosition();                                                                                  // 1240
      var actualWidth = $tip[0].offsetWidth;                                                                         // 1241
      var actualHeight = $tip[0].offsetHeight;                                                                       // 1242
                                                                                                                     //
      if (autoPlace) {                                                                                               // 1244
        var $parent = this.$element.parent();                                                                        // 1245
        var orgPlacement = placement;                                                                                // 1247
        var docScroll = document.documentElement.scrollTop || document.body.scrollTop;                               // 1248
        var parentWidth = this.options.container == 'body' ? window.innerWidth : $parent.outerWidth();               // 1249
        var parentHeight = this.options.container == 'body' ? window.innerHeight : $parent.outerHeight();            // 1250
        var parentLeft = this.options.container == 'body' ? 0 : $parent.offset().left;                               // 1251
        placement = placement == 'bottom' && pos.top + pos.height + actualHeight - docScroll > parentHeight ? 'top' : placement == 'top' && pos.top - docScroll - actualHeight < 0 ? 'bottom' : placement == 'right' && pos.right + actualWidth > parentWidth ? 'left' : placement == 'left' && pos.left - actualWidth < parentLeft ? 'right' : placement;
        $tip.removeClass(orgPlacement).addClass(placement);                                                          // 1259
      }                                                                                                              // 1262
                                                                                                                     //
      var calculatedOffset = this.getCalculatedOffset(placement, pos, actualWidth, actualHeight);                    // 1264
      this.applyPlacement(calculatedOffset, placement);                                                              // 1266
      this.$element.trigger('shown.bs.' + this.type);                                                                // 1267
    }                                                                                                                // 1268
  };                                                                                                                 // 1269
                                                                                                                     //
  Tooltip.prototype.applyPlacement = function (offset, placement) {                                                  // 1271
    var replace;                                                                                                     // 1272
    var $tip = this.tip();                                                                                           // 1273
    var width = $tip[0].offsetWidth;                                                                                 // 1274
    var height = $tip[0].offsetHeight; // manually read margins because getBoundingClientRect includes difference    // 1275
                                                                                                                     //
    var marginTop = parseInt($tip.css('margin-top'), 10);                                                            // 1278
    var marginLeft = parseInt($tip.css('margin-left'), 10); // we must check for NaN for ie 8/9                      // 1279
                                                                                                                     //
    if (isNaN(marginTop)) marginTop = 0;                                                                             // 1282
    if (isNaN(marginLeft)) marginLeft = 0;                                                                           // 1283
    offset.top = offset.top + marginTop;                                                                             // 1285
    offset.left = offset.left + marginLeft;                                                                          // 1286
    $tip.offset(offset).addClass('in'); // check to see if placing tip in new offset caused the tip to resize itself
                                                                                                                     //
    var actualWidth = $tip[0].offsetWidth;                                                                           // 1293
    var actualHeight = $tip[0].offsetHeight;                                                                         // 1294
                                                                                                                     //
    if (placement == 'top' && actualHeight != height) {                                                              // 1296
      replace = true;                                                                                                // 1297
      offset.top = offset.top + height - actualHeight;                                                               // 1298
    }                                                                                                                // 1299
                                                                                                                     //
    if (/bottom|top/.test(placement)) {                                                                              // 1301
      var delta = 0;                                                                                                 // 1302
                                                                                                                     //
      if (offset.left < 0) {                                                                                         // 1304
        delta = offset.left * -2;                                                                                    // 1305
        offset.left = 0;                                                                                             // 1306
        $tip.offset(offset);                                                                                         // 1308
        actualWidth = $tip[0].offsetWidth;                                                                           // 1310
        actualHeight = $tip[0].offsetHeight;                                                                         // 1311
      }                                                                                                              // 1312
                                                                                                                     //
      this.replaceArrow(delta - width + actualWidth, actualWidth, 'left');                                           // 1314
    } else {                                                                                                         // 1315
      this.replaceArrow(actualHeight - height, actualHeight, 'top');                                                 // 1316
    }                                                                                                                // 1317
                                                                                                                     //
    if (replace) $tip.offset(offset);                                                                                // 1319
  };                                                                                                                 // 1320
                                                                                                                     //
  Tooltip.prototype.replaceArrow = function (delta, dimension, position) {                                           // 1322
    this.arrow().css(position, delta ? 50 * (1 - delta / dimension) + "%" : '');                                     // 1323
  };                                                                                                                 // 1324
                                                                                                                     //
  Tooltip.prototype.setContent = function () {                                                                       // 1326
    var $tip = this.tip();                                                                                           // 1327
    var title = this.getTitle();                                                                                     // 1328
    $tip.find('.tooltip-inner')[this.options.html ? 'html' : 'text'](title);                                         // 1330
    $tip.removeClass('fade in top bottom left right');                                                               // 1331
  };                                                                                                                 // 1332
                                                                                                                     //
  Tooltip.prototype.hide = function () {                                                                             // 1334
    var that = this;                                                                                                 // 1335
    var $tip = this.tip();                                                                                           // 1336
    var e = $.Event('hide.bs.' + this.type);                                                                         // 1337
                                                                                                                     //
    function complete() {                                                                                            // 1339
      if (that.hoverState != 'in') $tip.detach();                                                                    // 1340
    }                                                                                                                // 1341
                                                                                                                     //
    this.$element.trigger(e);                                                                                        // 1343
    if (e.isDefaultPrevented()) return;                                                                              // 1345
    $tip.removeClass('in');                                                                                          // 1347
    $.support.transition && this.$tip.hasClass('fade') ? $tip.one($.support.transition.end, complete).emulateTransitionEnd(150) : complete();
    this.$element.trigger('hidden.bs.' + this.type);                                                                 // 1355
    return this;                                                                                                     // 1357
  };                                                                                                                 // 1358
                                                                                                                     //
  Tooltip.prototype.fixTitle = function () {                                                                         // 1360
    var $e = this.$element;                                                                                          // 1361
                                                                                                                     //
    if ($e.attr('title') || typeof $e.attr('data-original-title') != 'string') {                                     // 1362
      $e.attr('data-original-title', $e.attr('title') || '').attr('title', '');                                      // 1363
    }                                                                                                                // 1364
  };                                                                                                                 // 1365
                                                                                                                     //
  Tooltip.prototype.hasContent = function () {                                                                       // 1367
    return this.getTitle();                                                                                          // 1368
  };                                                                                                                 // 1369
                                                                                                                     //
  Tooltip.prototype.getPosition = function () {                                                                      // 1371
    var el = this.$element[0];                                                                                       // 1372
    return $.extend({}, typeof el.getBoundingClientRect == 'function' ? el.getBoundingClientRect() : {               // 1373
      width: el.offsetWidth,                                                                                         // 1374
      height: el.offsetHeight                                                                                        // 1375
    }, this.$element.offset());                                                                                      // 1373
  };                                                                                                                 // 1377
                                                                                                                     //
  Tooltip.prototype.getCalculatedOffset = function (placement, pos, actualWidth, actualHeight) {                     // 1379
    return placement == 'bottom' ? {                                                                                 // 1380
      top: pos.top + pos.height,                                                                                     // 1380
      left: pos.left + pos.width / 2 - actualWidth / 2                                                               // 1380
    } : placement == 'top' ? {                                                                                       // 1380
      top: pos.top - actualHeight,                                                                                   // 1381
      left: pos.left + pos.width / 2 - actualWidth / 2                                                               // 1381
    } : placement == 'left' ? {                                                                                      // 1381
      top: pos.top + pos.height / 2 - actualHeight / 2,                                                              // 1382
      left: pos.left - actualWidth                                                                                   // 1382
    } : /* placement == 'right' */{                                                                                  // 1382
      top: pos.top + pos.height / 2 - actualHeight / 2,                                                              // 1383
      left: pos.left + pos.width                                                                                     // 1383
    };                                                                                                               // 1383
  };                                                                                                                 // 1384
                                                                                                                     //
  Tooltip.prototype.getTitle = function () {                                                                         // 1386
    var title;                                                                                                       // 1387
    var $e = this.$element;                                                                                          // 1388
    var o = this.options;                                                                                            // 1389
    title = $e.attr('data-original-title') || (typeof o.title == 'function' ? o.title.call($e[0]) : o.title);        // 1391
    return title;                                                                                                    // 1394
  };                                                                                                                 // 1395
                                                                                                                     //
  Tooltip.prototype.tip = function () {                                                                              // 1397
    return this.$tip = this.$tip || $(this.options.template);                                                        // 1398
  };                                                                                                                 // 1399
                                                                                                                     //
  Tooltip.prototype.arrow = function () {                                                                            // 1401
    return this.$arrow = this.$arrow || this.tip().find('.tooltip-arrow');                                           // 1402
  };                                                                                                                 // 1403
                                                                                                                     //
  Tooltip.prototype.validate = function () {                                                                         // 1405
    if (!this.$element[0].parentNode) {                                                                              // 1406
      this.hide();                                                                                                   // 1407
      this.$element = null;                                                                                          // 1408
      this.options = null;                                                                                           // 1409
    }                                                                                                                // 1410
  };                                                                                                                 // 1411
                                                                                                                     //
  Tooltip.prototype.enable = function () {                                                                           // 1413
    this.enabled = true;                                                                                             // 1414
  };                                                                                                                 // 1415
                                                                                                                     //
  Tooltip.prototype.disable = function () {                                                                          // 1417
    this.enabled = false;                                                                                            // 1418
  };                                                                                                                 // 1419
                                                                                                                     //
  Tooltip.prototype.toggleEnabled = function () {                                                                    // 1421
    this.enabled = !this.enabled;                                                                                    // 1422
  };                                                                                                                 // 1423
                                                                                                                     //
  Tooltip.prototype.toggle = function (e) {                                                                          // 1425
    var self = e ? $(e.currentTarget)[this.type](this.getDelegateOptions()).data('bs.' + this.type) : this;          // 1426
    self.tip().hasClass('in') ? self.leave(self) : self.enter(self);                                                 // 1427
  };                                                                                                                 // 1428
                                                                                                                     //
  Tooltip.prototype.destroy = function () {                                                                          // 1430
    this.hide().$element.off('.' + this.type).removeData('bs.' + this.type);                                         // 1431
  }; // TOOLTIP PLUGIN DEFINITION                                                                                    // 1432
  // =========================                                                                                       // 1436
                                                                                                                     //
                                                                                                                     //
  var old = $.fn.tooltip;                                                                                            // 1438
                                                                                                                     //
  $.fn.tooltip = function (option) {                                                                                 // 1440
    return this.each(function () {                                                                                   // 1441
      var $this = $(this);                                                                                           // 1442
      var data = $this.data('bs.tooltip');                                                                           // 1443
      var options = (typeof option === "undefined" ? "undefined" : (0, _typeof3.default)(option)) == 'object' && option;
      if (!data) $this.data('bs.tooltip', data = new Tooltip(this, options));                                        // 1446
      if (typeof option == 'string') data[option]();                                                                 // 1447
    });                                                                                                              // 1448
  };                                                                                                                 // 1449
                                                                                                                     //
  $.fn.tooltip.Constructor = Tooltip; // TOOLTIP NO CONFLICT                                                         // 1451
  // ===================                                                                                             // 1455
                                                                                                                     //
  $.fn.tooltip.noConflict = function () {                                                                            // 1457
    $.fn.tooltip = old;                                                                                              // 1458
    return this;                                                                                                     // 1459
  };                                                                                                                 // 1460
}(jQuery); /* ========================================================================                               // 1462
            * Bootstrap: popover.js v3.0.2                                                                           //
            * http://getbootstrap.com/javascript/#popovers                                                           //
            * ========================================================================                               //
            * Copyright 2013 Twitter, Inc.                                                                           //
            *                                                                                                        //
            * Licensed under the Apache License, Version 2.0 (the "License");                                        //
            * you may not use this file except in compliance with the License.                                       //
            * You may obtain a copy of the License at                                                                //
            *                                                                                                        //
            * http://www.apache.org/licenses/LICENSE-2.0                                                             //
            *                                                                                                        //
            * Unless required by applicable law or agreed to in writing, software                                    //
            * distributed under the License is distributed on an "AS IS" BASIS,                                      //
            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                               //
            * See the License for the specific language governing permissions and                                    //
            * limitations under the License.                                                                         //
            * ======================================================================== */                            //
+function ($) {                                                                                                      // 1484
  "use strict"; // POPOVER PUBLIC CLASS DEFINITION                                                                   // 1484
  // ===============================                                                                                 // 1487
                                                                                                                     //
  var Popover = function (element, options) {                                                                        // 1489
    this.init('popover', element, options);                                                                          // 1490
  };                                                                                                                 // 1491
                                                                                                                     //
  if (!$.fn.tooltip) throw new Error('Popover requires tooltip.js');                                                 // 1493
  Popover.DEFAULTS = $.extend({}, $.fn.tooltip.Constructor.DEFAULTS, {                                               // 1495
    placement: 'right',                                                                                              // 1496
    trigger: 'click',                                                                                                // 1497
    content: '',                                                                                                     // 1498
    template: '<div class="popover"><div class="arrow"></div><h3 class="popover-title"></h3><div class="popover-content"></div></div>'
  }); // NOTE: POPOVER EXTENDS tooltip.js                                                                            // 1495
  // ================================                                                                                // 1504
                                                                                                                     //
  Popover.prototype = $.extend({}, $.fn.tooltip.Constructor.prototype);                                              // 1506
  Popover.prototype.constructor = Popover;                                                                           // 1508
                                                                                                                     //
  Popover.prototype.getDefaults = function () {                                                                      // 1510
    return Popover.DEFAULTS;                                                                                         // 1511
  };                                                                                                                 // 1512
                                                                                                                     //
  Popover.prototype.setContent = function () {                                                                       // 1514
    var $tip = this.tip();                                                                                           // 1515
    var title = this.getTitle();                                                                                     // 1516
    var content = this.getContent();                                                                                 // 1517
    $tip.find('.popover-title')[this.options.html ? 'html' : 'text'](title);                                         // 1519
    $tip.find('.popover-content')[this.options.html ? 'html' : 'text'](content);                                     // 1520
    $tip.removeClass('fade top bottom left right in'); // IE8 doesn't accept hiding via the `:empty` pseudo selector, we have to do
    // this manually by checking the contents.                                                                       // 1525
                                                                                                                     //
    if (!$tip.find('.popover-title').html()) $tip.find('.popover-title').hide();                                     // 1526
  };                                                                                                                 // 1527
                                                                                                                     //
  Popover.prototype.hasContent = function () {                                                                       // 1529
    return this.getTitle() || this.getContent();                                                                     // 1530
  };                                                                                                                 // 1531
                                                                                                                     //
  Popover.prototype.getContent = function () {                                                                       // 1533
    var $e = this.$element;                                                                                          // 1534
    var o = this.options;                                                                                            // 1535
    return $e.attr('data-content') || (typeof o.content == 'function' ? o.content.call($e[0]) : o.content);          // 1537
  };                                                                                                                 // 1541
                                                                                                                     //
  Popover.prototype.arrow = function () {                                                                            // 1543
    return this.$arrow = this.$arrow || this.tip().find('.arrow');                                                   // 1544
  };                                                                                                                 // 1545
                                                                                                                     //
  Popover.prototype.tip = function () {                                                                              // 1547
    if (!this.$tip) this.$tip = $(this.options.template);                                                            // 1548
    return this.$tip;                                                                                                // 1549
  }; // POPOVER PLUGIN DEFINITION                                                                                    // 1550
  // =========================                                                                                       // 1554
                                                                                                                     //
                                                                                                                     //
  var old = $.fn.popover;                                                                                            // 1556
                                                                                                                     //
  $.fn.popover = function (option) {                                                                                 // 1558
    return this.each(function () {                                                                                   // 1559
      var $this = $(this);                                                                                           // 1560
      var data = $this.data('bs.popover');                                                                           // 1561
      var options = (typeof option === "undefined" ? "undefined" : (0, _typeof3.default)(option)) == 'object' && option;
      if (!data) $this.data('bs.popover', data = new Popover(this, options));                                        // 1564
      if (typeof option == 'string') data[option]();                                                                 // 1565
    });                                                                                                              // 1566
  };                                                                                                                 // 1567
                                                                                                                     //
  $.fn.popover.Constructor = Popover; // POPOVER NO CONFLICT                                                         // 1569
  // ===================                                                                                             // 1573
                                                                                                                     //
  $.fn.popover.noConflict = function () {                                                                            // 1575
    $.fn.popover = old;                                                                                              // 1576
    return this;                                                                                                     // 1577
  };                                                                                                                 // 1578
}(jQuery); /* ========================================================================                               // 1580
            * Bootstrap: scrollspy.js v3.0.2                                                                         //
            * http://getbootstrap.com/javascript/#scrollspy                                                          //
            * ========================================================================                               //
            * Copyright 2013 Twitter, Inc.                                                                           //
            *                                                                                                        //
            * Licensed under the Apache License, Version 2.0 (the "License");                                        //
            * you may not use this file except in compliance with the License.                                       //
            * You may obtain a copy of the License at                                                                //
            *                                                                                                        //
            * http://www.apache.org/licenses/LICENSE-2.0                                                             //
            *                                                                                                        //
            * Unless required by applicable law or agreed to in writing, software                                    //
            * distributed under the License is distributed on an "AS IS" BASIS,                                      //
            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                               //
            * See the License for the specific language governing permissions and                                    //
            * limitations under the License.                                                                         //
            * ======================================================================== */                            //
+function ($) {                                                                                                      // 1602
  "use strict"; // SCROLLSPY CLASS DEFINITION                                                                        // 1602
  // ==========================                                                                                      // 1605
                                                                                                                     //
  function ScrollSpy(element, options) {                                                                             // 1607
    var href;                                                                                                        // 1608
    var process = $.proxy(this.process, this);                                                                       // 1609
    this.$element = $(element).is('body') ? $(window) : $(element);                                                  // 1611
    this.$body = $('body');                                                                                          // 1612
    this.$scrollElement = this.$element.on('scroll.bs.scroll-spy.data-api', process);                                // 1613
    this.options = $.extend({}, ScrollSpy.DEFAULTS, options);                                                        // 1614
    this.selector = (this.options.target || (href = $(element).attr('href')) && href.replace(/.*(?=#[^\s]+$)/, '') //strip for ie7
    || '') + ' .nav li > a';                                                                                         // 1615
    this.offsets = $([]);                                                                                            // 1618
    this.targets = $([]);                                                                                            // 1619
    this.activeTarget = null;                                                                                        // 1620
    this.refresh();                                                                                                  // 1622
    this.process();                                                                                                  // 1623
  }                                                                                                                  // 1624
                                                                                                                     //
  ScrollSpy.DEFAULTS = {                                                                                             // 1626
    offset: 10                                                                                                       // 1627
  };                                                                                                                 // 1626
                                                                                                                     //
  ScrollSpy.prototype.refresh = function () {                                                                        // 1630
    var offsetMethod = this.$element[0] == window ? 'offset' : 'position';                                           // 1631
    this.offsets = $([]);                                                                                            // 1633
    this.targets = $([]);                                                                                            // 1634
    var self = this;                                                                                                 // 1636
    var $targets = this.$body.find(this.selector).map(function () {                                                  // 1637
      var $el = $(this);                                                                                             // 1640
      var href = $el.data('target') || $el.attr('href');                                                             // 1641
      var $href = /^#\w/.test(href) && $(href);                                                                      // 1642
      return $href && $href.length && [[$href[offsetMethod]().top + (!$.isWindow(self.$scrollElement.get(0)) && self.$scrollElement.scrollTop()), href]] || null;
    }).sort(function (a, b) {                                                                                        // 1647
      return a[0] - b[0];                                                                                            // 1648
    }).each(function () {                                                                                            // 1648
      self.offsets.push(this[0]);                                                                                    // 1650
      self.targets.push(this[1]);                                                                                    // 1651
    });                                                                                                              // 1652
  };                                                                                                                 // 1653
                                                                                                                     //
  ScrollSpy.prototype.process = function () {                                                                        // 1655
    var scrollTop = this.$scrollElement.scrollTop() + this.options.offset;                                           // 1656
    var scrollHeight = this.$scrollElement[0].scrollHeight || this.$body[0].scrollHeight;                            // 1657
    var maxScroll = scrollHeight - this.$scrollElement.height();                                                     // 1658
    var offsets = this.offsets;                                                                                      // 1659
    var targets = this.targets;                                                                                      // 1660
    var activeTarget = this.activeTarget;                                                                            // 1661
    var i;                                                                                                           // 1662
                                                                                                                     //
    if (scrollTop >= maxScroll) {                                                                                    // 1664
      return activeTarget != (i = targets.last()[0]) && this.activate(i);                                            // 1665
    }                                                                                                                // 1666
                                                                                                                     //
    for (i = offsets.length; i--;) {                                                                                 // 1668
      activeTarget != targets[i] && scrollTop >= offsets[i] && (!offsets[i + 1] || scrollTop <= offsets[i + 1]) && this.activate(targets[i]);
    }                                                                                                                // 1673
  };                                                                                                                 // 1674
                                                                                                                     //
  ScrollSpy.prototype.activate = function (target) {                                                                 // 1676
    this.activeTarget = target;                                                                                      // 1677
    $(this.selector).parents('.active').removeClass('active');                                                       // 1679
    var selector = this.selector + '[data-target="' + target + '"],' + this.selector + '[href="' + target + '"]';    // 1683
    var active = $(selector).parents('li').addClass('active');                                                       // 1687
                                                                                                                     //
    if (active.parent('.dropdown-menu').length) {                                                                    // 1691
      active = active.closest('li.dropdown').addClass('active');                                                     // 1692
    }                                                                                                                // 1695
                                                                                                                     //
    active.trigger('activate');                                                                                      // 1697
  }; // SCROLLSPY PLUGIN DEFINITION                                                                                  // 1698
  // ===========================                                                                                     // 1702
                                                                                                                     //
                                                                                                                     //
  var old = $.fn.scrollspy;                                                                                          // 1704
                                                                                                                     //
  $.fn.scrollspy = function (option) {                                                                               // 1706
    return this.each(function () {                                                                                   // 1707
      var $this = $(this);                                                                                           // 1708
      var data = $this.data('bs.scrollspy');                                                                         // 1709
      var options = (typeof option === "undefined" ? "undefined" : (0, _typeof3.default)(option)) == 'object' && option;
      if (!data) $this.data('bs.scrollspy', data = new ScrollSpy(this, options));                                    // 1712
      if (typeof option == 'string') data[option]();                                                                 // 1713
    });                                                                                                              // 1714
  };                                                                                                                 // 1715
                                                                                                                     //
  $.fn.scrollspy.Constructor = ScrollSpy; // SCROLLSPY NO CONFLICT                                                   // 1717
  // =====================                                                                                           // 1721
                                                                                                                     //
  $.fn.scrollspy.noConflict = function () {                                                                          // 1723
    $.fn.scrollspy = old;                                                                                            // 1724
    return this;                                                                                                     // 1725
  }; // SCROLLSPY DATA-API                                                                                           // 1726
  // ==================                                                                                              // 1730
                                                                                                                     //
                                                                                                                     //
  $(window).on('load', function () {                                                                                 // 1732
    $('[data-spy="scroll"]').each(function () {                                                                      // 1733
      var $spy = $(this);                                                                                            // 1734
      $spy.scrollspy($spy.data());                                                                                   // 1735
    });                                                                                                              // 1736
  });                                                                                                                // 1737
}(jQuery); /* ========================================================================                               // 1739
            * Bootstrap: tab.js v3.0.2                                                                               //
            * http://getbootstrap.com/javascript/#tabs                                                               //
            * ========================================================================                               //
            * Copyright 2013 Twitter, Inc.                                                                           //
            *                                                                                                        //
            * Licensed under the Apache License, Version 2.0 (the "License");                                        //
            * you may not use this file except in compliance with the License.                                       //
            * You may obtain a copy of the License at                                                                //
            *                                                                                                        //
            * http://www.apache.org/licenses/LICENSE-2.0                                                             //
            *                                                                                                        //
            * Unless required by applicable law or agreed to in writing, software                                    //
            * distributed under the License is distributed on an "AS IS" BASIS,                                      //
            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                               //
            * See the License for the specific language governing permissions and                                    //
            * limitations under the License.                                                                         //
            * ======================================================================== */                            //
+function ($) {                                                                                                      // 1761
  "use strict"; // TAB CLASS DEFINITION                                                                              // 1761
  // ====================                                                                                            // 1764
                                                                                                                     //
  var Tab = function (element) {                                                                                     // 1766
    this.element = $(element);                                                                                       // 1767
  };                                                                                                                 // 1768
                                                                                                                     //
  Tab.prototype.show = function () {                                                                                 // 1770
    var $this = this.element;                                                                                        // 1771
    var $ul = $this.closest('ul:not(.dropdown-menu)');                                                               // 1772
    var selector = $this.data('target');                                                                             // 1773
                                                                                                                     //
    if (!selector) {                                                                                                 // 1775
      selector = $this.attr('href');                                                                                 // 1776
      selector = selector && selector.replace(/.*(?=#[^\s]*$)/, ''); //strip for ie7                                 // 1777
    }                                                                                                                // 1778
                                                                                                                     //
    if ($this.parent('li').hasClass('active')) return;                                                               // 1780
    var previous = $ul.find('.active:last a')[0];                                                                    // 1782
    var e = $.Event('show.bs.tab', {                                                                                 // 1783
      relatedTarget: previous                                                                                        // 1784
    });                                                                                                              // 1783
    $this.trigger(e);                                                                                                // 1787
    if (e.isDefaultPrevented()) return;                                                                              // 1789
    var $target = $(selector);                                                                                       // 1791
    this.activate($this.parent('li'), $ul);                                                                          // 1793
    this.activate($target, $target.parent(), function () {                                                           // 1794
      $this.trigger({                                                                                                // 1795
        type: 'shown.bs.tab',                                                                                        // 1796
        relatedTarget: previous                                                                                      // 1797
      });                                                                                                            // 1795
    });                                                                                                              // 1799
  };                                                                                                                 // 1800
                                                                                                                     //
  Tab.prototype.activate = function (element, container, callback) {                                                 // 1802
    var $active = container.find('> .active');                                                                       // 1803
    var transition = callback && $.support.transition && $active.hasClass('fade');                                   // 1804
                                                                                                                     //
    function next() {                                                                                                // 1808
      $active.removeClass('active').find('> .dropdown-menu > .active').removeClass('active');                        // 1809
      element.addClass('active');                                                                                    // 1814
                                                                                                                     //
      if (transition) {                                                                                              // 1816
        element[0].offsetWidth; // reflow for transition                                                             // 1817
                                                                                                                     //
        element.addClass('in');                                                                                      // 1818
      } else {                                                                                                       // 1819
        element.removeClass('fade');                                                                                 // 1820
      }                                                                                                              // 1821
                                                                                                                     //
      if (element.parent('.dropdown-menu')) {                                                                        // 1823
        element.closest('li.dropdown').addClass('active');                                                           // 1824
      }                                                                                                              // 1825
                                                                                                                     //
      callback && callback();                                                                                        // 1827
    }                                                                                                                // 1828
                                                                                                                     //
    transition ? $active.one($.support.transition.end, next).emulateTransitionEnd(150) : next();                     // 1830
    $active.removeClass('in');                                                                                       // 1836
  }; // TAB PLUGIN DEFINITION                                                                                        // 1837
  // =====================                                                                                           // 1841
                                                                                                                     //
                                                                                                                     //
  var old = $.fn.tab;                                                                                                // 1843
                                                                                                                     //
  $.fn.tab = function (option) {                                                                                     // 1845
    return this.each(function () {                                                                                   // 1846
      var $this = $(this);                                                                                           // 1847
      var data = $this.data('bs.tab');                                                                               // 1848
      if (!data) $this.data('bs.tab', data = new Tab(this));                                                         // 1850
      if (typeof option == 'string') data[option]();                                                                 // 1851
    });                                                                                                              // 1852
  };                                                                                                                 // 1853
                                                                                                                     //
  $.fn.tab.Constructor = Tab; // TAB NO CONFLICT                                                                     // 1855
  // ===============                                                                                                 // 1859
                                                                                                                     //
  $.fn.tab.noConflict = function () {                                                                                // 1861
    $.fn.tab = old;                                                                                                  // 1862
    return this;                                                                                                     // 1863
  }; // TAB DATA-API                                                                                                 // 1864
  // ============                                                                                                    // 1868
                                                                                                                     //
                                                                                                                     //
  $(document).on('click.bs.tab.data-api', '[data-toggle="tab"], [data-toggle="pill"]', function (e) {                // 1870
    e.preventDefault();                                                                                              // 1871
    $(this).tab('show');                                                                                             // 1872
  });                                                                                                                // 1873
}(jQuery); /* ========================================================================                               // 1875
            * Bootstrap: affix.js v3.0.2                                                                             //
            * http://getbootstrap.com/javascript/#affix                                                              //
            * ========================================================================                               //
            * Copyright 2013 Twitter, Inc.                                                                           //
            *                                                                                                        //
            * Licensed under the Apache License, Version 2.0 (the "License");                                        //
            * you may not use this file except in compliance with the License.                                       //
            * You may obtain a copy of the License at                                                                //
            *                                                                                                        //
            * http://www.apache.org/licenses/LICENSE-2.0                                                             //
            *                                                                                                        //
            * Unless required by applicable law or agreed to in writing, software                                    //
            * distributed under the License is distributed on an "AS IS" BASIS,                                      //
            * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.                               //
            * See the License for the specific language governing permissions and                                    //
            * limitations under the License.                                                                         //
            * ======================================================================== */                            //
+function ($) {                                                                                                      // 1897
  "use strict"; // AFFIX CLASS DEFINITION                                                                            // 1897
  // ======================                                                                                          // 1900
                                                                                                                     //
  var Affix = function (element, options) {                                                                          // 1902
    this.options = $.extend({}, Affix.DEFAULTS, options);                                                            // 1903
    this.$window = $(window).on('scroll.bs.affix.data-api', $.proxy(this.checkPosition, this)).on('click.bs.affix.data-api', $.proxy(this.checkPositionWithEventLoop, this));
    this.$element = $(element);                                                                                      // 1908
    this.affixed = this.unpin = null;                                                                                // 1909
    this.checkPosition();                                                                                            // 1912
  };                                                                                                                 // 1913
                                                                                                                     //
  Affix.RESET = 'affix affix-top affix-bottom';                                                                      // 1915
  Affix.DEFAULTS = {                                                                                                 // 1917
    offset: 0                                                                                                        // 1918
  };                                                                                                                 // 1917
                                                                                                                     //
  Affix.prototype.checkPositionWithEventLoop = function () {                                                         // 1921
    setTimeout($.proxy(this.checkPosition, this), 1);                                                                // 1922
  };                                                                                                                 // 1923
                                                                                                                     //
  Affix.prototype.checkPosition = function () {                                                                      // 1925
    if (!this.$element.is(':visible')) return;                                                                       // 1926
    var scrollHeight = $(document).height();                                                                         // 1928
    var scrollTop = this.$window.scrollTop();                                                                        // 1929
    var position = this.$element.offset();                                                                           // 1930
    var offset = this.options.offset;                                                                                // 1931
    var offsetTop = offset.top;                                                                                      // 1932
    var offsetBottom = offset.bottom;                                                                                // 1933
    if ((typeof offset === "undefined" ? "undefined" : (0, _typeof3.default)(offset)) != 'object') offsetBottom = offsetTop = offset;
    if (typeof offsetTop == 'function') offsetTop = offset.top();                                                    // 1936
    if (typeof offsetBottom == 'function') offsetBottom = offset.bottom();                                           // 1937
    var affix = this.unpin != null && scrollTop + this.unpin <= position.top ? false : offsetBottom != null && position.top + this.$element.height() >= scrollHeight - offsetBottom ? 'bottom' : offsetTop != null && scrollTop <= offsetTop ? 'top' : false;
    if (this.affixed === affix) return;                                                                              // 1943
    if (this.unpin) this.$element.css('top', '');                                                                    // 1944
    this.affixed = affix;                                                                                            // 1946
    this.unpin = affix == 'bottom' ? position.top - scrollTop : null;                                                // 1947
    this.$element.removeClass(Affix.RESET).addClass('affix' + (affix ? '-' + affix : ''));                           // 1949
                                                                                                                     //
    if (affix == 'bottom') {                                                                                         // 1951
      this.$element.offset({                                                                                         // 1952
        top: document.body.offsetHeight - offsetBottom - this.$element.height()                                      // 1952
      });                                                                                                            // 1952
    }                                                                                                                // 1953
  }; // AFFIX PLUGIN DEFINITION                                                                                      // 1954
  // =======================                                                                                         // 1958
                                                                                                                     //
                                                                                                                     //
  var old = $.fn.affix;                                                                                              // 1960
                                                                                                                     //
  $.fn.affix = function (option) {                                                                                   // 1962
    return this.each(function () {                                                                                   // 1963
      var $this = $(this);                                                                                           // 1964
      var data = $this.data('bs.affix');                                                                             // 1965
      var options = (typeof option === "undefined" ? "undefined" : (0, _typeof3.default)(option)) == 'object' && option;
      if (!data) $this.data('bs.affix', data = new Affix(this, options));                                            // 1968
      if (typeof option == 'string') data[option]();                                                                 // 1969
    });                                                                                                              // 1970
  };                                                                                                                 // 1971
                                                                                                                     //
  $.fn.affix.Constructor = Affix; // AFFIX NO CONFLICT                                                               // 1973
  // =================                                                                                               // 1977
                                                                                                                     //
  $.fn.affix.noConflict = function () {                                                                              // 1979
    $.fn.affix = old;                                                                                                // 1980
    return this;                                                                                                     // 1981
  }; // AFFIX DATA-API                                                                                               // 1982
  // ==============                                                                                                  // 1986
                                                                                                                     //
                                                                                                                     //
  $(window).on('load', function () {                                                                                 // 1988
    $('[data-spy="affix"]').each(function () {                                                                       // 1989
      var $spy = $(this);                                                                                            // 1990
      var data = $spy.data();                                                                                        // 1991
      data.offset = data.offset || {};                                                                               // 1993
      if (data.offsetBottom) data.offset.bottom = data.offsetBottom;                                                 // 1995
      if (data.offsetTop) data.offset.top = data.offsetTop;                                                          // 1996
      $spy.affix(data);                                                                                              // 1998
    });                                                                                                              // 1999
  });                                                                                                                // 2000
}(jQuery);                                                                                                           // 2002
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

},"bootstrap.min.js":function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// client/js/bootstrap.min.js                                                                                        //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
/*!                                                                                                                  // 1
 * Bootstrap v3.0.2 by @fat and @mdo                                                                                 // 2
 * Copyright 2013 Twitter, Inc.                                                                                      // 3
 * Licensed under http://www.apache.org/licenses/LICENSE-2.0                                                         // 4
 *                                                                                                                   // 5
 * Designed and built with all the love in the world by @mdo and @fat.                                               // 6
 */                                                                                                                  // 7
                                                                                                                     // 8
if("undefined"==typeof jQuery)throw new Error("Bootstrap requires jQuery");+function(a){"use strict";function b(){var a=document.createElement("bootstrap"),b={WebkitTransition:"webkitTransitionEnd",MozTransition:"transitionend",OTransition:"oTransitionEnd otransitionend",transition:"transitionend"};for(var c in b)if(void 0!==a.style[c])return{end:b[c]}}a.fn.emulateTransitionEnd=function(b){var c=!1,d=this;a(this).one(a.support.transition.end,function(){c=!0});var e=function(){c||a(d).trigger(a.support.transition.end)};return setTimeout(e,b),this},a(function(){a.support.transition=b()})}(jQuery),+function(a){"use strict";var b='[data-dismiss="alert"]',c=function(c){a(c).on("click",b,this.close)};c.prototype.close=function(b){function c(){f.trigger("closed.bs.alert").remove()}var d=a(this),e=d.attr("data-target");e||(e=d.attr("href"),e=e&&e.replace(/.*(?=#[^\s]*$)/,""));var f=a(e);b&&b.preventDefault(),f.length||(f=d.hasClass("alert")?d:d.parent()),f.trigger(b=a.Event("close.bs.alert")),b.isDefaultPrevented()||(f.removeClass("in"),a.support.transition&&f.hasClass("fade")?f.one(a.support.transition.end,c).emulateTransitionEnd(150):c())};var d=a.fn.alert;a.fn.alert=function(b){return this.each(function(){var d=a(this),e=d.data("bs.alert");e||d.data("bs.alert",e=new c(this)),"string"==typeof b&&e[b].call(d)})},a.fn.alert.Constructor=c,a.fn.alert.noConflict=function(){return a.fn.alert=d,this},a(document).on("click.bs.alert.data-api",b,c.prototype.close)}(jQuery),+function(a){"use strict";var b=function(c,d){this.$element=a(c),this.options=a.extend({},b.DEFAULTS,d)};b.DEFAULTS={loadingText:"loading..."},b.prototype.setState=function(a){var b="disabled",c=this.$element,d=c.is("input")?"val":"html",e=c.data();a+="Text",e.resetText||c.data("resetText",c[d]()),c[d](e[a]||this.options[a]),setTimeout(function(){"loadingText"==a?c.addClass(b).attr(b,b):c.removeClass(b).removeAttr(b)},0)},b.prototype.toggle=function(){var a=this.$element.closest('[data-toggle="buttons"]');if(a.length){var b=this.$element.find("input").prop("checked",!this.$element.hasClass("active")).trigger("change");"radio"===b.prop("type")&&a.find(".active").removeClass("active")}this.$element.toggleClass("active")};var c=a.fn.button;a.fn.button=function(c){return this.each(function(){var d=a(this),e=d.data("bs.button"),f="object"==typeof c&&c;e||d.data("bs.button",e=new b(this,f)),"toggle"==c?e.toggle():c&&e.setState(c)})},a.fn.button.Constructor=b,a.fn.button.noConflict=function(){return a.fn.button=c,this},a(document).on("click.bs.button.data-api","[data-toggle^=button]",function(b){var c=a(b.target);c.hasClass("btn")||(c=c.closest(".btn")),c.button("toggle"),b.preventDefault()})}(jQuery),+function(a){"use strict";var b=function(b,c){this.$element=a(b),this.$indicators=this.$element.find(".carousel-indicators"),this.options=c,this.paused=this.sliding=this.interval=this.$active=this.$items=null,"hover"==this.options.pause&&this.$element.on("mouseenter",a.proxy(this.pause,this)).on("mouseleave",a.proxy(this.cycle,this))};b.DEFAULTS={interval:5e3,pause:"hover",wrap:!0},b.prototype.cycle=function(b){return b||(this.paused=!1),this.interval&&clearInterval(this.interval),this.options.interval&&!this.paused&&(this.interval=setInterval(a.proxy(this.next,this),this.options.interval)),this},b.prototype.getActiveIndex=function(){return this.$active=this.$element.find(".item.active"),this.$items=this.$active.parent().children(),this.$items.index(this.$active)},b.prototype.to=function(b){var c=this,d=this.getActiveIndex();return b>this.$items.length-1||0>b?void 0:this.sliding?this.$element.one("slid",function(){c.to(b)}):d==b?this.pause().cycle():this.slide(b>d?"next":"prev",a(this.$items[b]))},b.prototype.pause=function(b){return b||(this.paused=!0),this.$element.find(".next, .prev").length&&a.support.transition.end&&(this.$element.trigger(a.support.transition.end),this.cycle(!0)),this.interval=clearInterval(this.interval),this},b.prototype.next=function(){return this.sliding?void 0:this.slide("next")},b.prototype.prev=function(){return this.sliding?void 0:this.slide("prev")},b.prototype.slide=function(b,c){var d=this.$element.find(".item.active"),e=c||d[b](),f=this.interval,g="next"==b?"left":"right",h="next"==b?"first":"last",i=this;if(!e.length){if(!this.options.wrap)return;e=this.$element.find(".item")[h]()}this.sliding=!0,f&&this.pause();var j=a.Event("slide.bs.carousel",{relatedTarget:e[0],direction:g});if(!e.hasClass("active")){if(this.$indicators.length&&(this.$indicators.find(".active").removeClass("active"),this.$element.one("slid",function(){var b=a(i.$indicators.children()[i.getActiveIndex()]);b&&b.addClass("active")})),a.support.transition&&this.$element.hasClass("slide")){if(this.$element.trigger(j),j.isDefaultPrevented())return;e.addClass(b),e[0].offsetWidth,d.addClass(g),e.addClass(g),d.one(a.support.transition.end,function(){e.removeClass([b,g].join(" ")).addClass("active"),d.removeClass(["active",g].join(" ")),i.sliding=!1,setTimeout(function(){i.$element.trigger("slid")},0)}).emulateTransitionEnd(1200)}else{if(this.$element.trigger(j),j.isDefaultPrevented())return;d.removeClass("active"),e.addClass("active"),this.sliding=!1,this.$element.trigger("slid")}return f&&this.cycle(),this}};var c=a.fn.carousel;a.fn.carousel=function(c){return this.each(function(){var d=a(this),e=d.data("bs.carousel"),f=a.extend({},b.DEFAULTS,d.data(),"object"==typeof c&&c),g="string"==typeof c?c:f.slide;e||d.data("bs.carousel",e=new b(this,f)),"number"==typeof c?e.to(c):g?e[g]():f.interval&&e.pause().cycle()})},a.fn.carousel.Constructor=b,a.fn.carousel.noConflict=function(){return a.fn.carousel=c,this},a(document).on("click.bs.carousel.data-api","[data-slide], [data-slide-to]",function(b){var c,d=a(this),e=a(d.attr("data-target")||(c=d.attr("href"))&&c.replace(/.*(?=#[^\s]+$)/,"")),f=a.extend({},e.data(),d.data()),g=d.attr("data-slide-to");g&&(f.interval=!1),e.carousel(f),(g=d.attr("data-slide-to"))&&e.data("bs.carousel").to(g),b.preventDefault()}),a(window).on("load",function(){a('[data-ride="carousel"]').each(function(){var b=a(this);b.carousel(b.data())})})}(jQuery),+function(a){"use strict";var b=function(c,d){this.$element=a(c),this.options=a.extend({},b.DEFAULTS,d),this.transitioning=null,this.options.parent&&(this.$parent=a(this.options.parent)),this.options.toggle&&this.toggle()};b.DEFAULTS={toggle:!0},b.prototype.dimension=function(){var a=this.$element.hasClass("width");return a?"width":"height"},b.prototype.show=function(){if(!this.transitioning&&!this.$element.hasClass("in")){var b=a.Event("show.bs.collapse");if(this.$element.trigger(b),!b.isDefaultPrevented()){var c=this.$parent&&this.$parent.find("> .panel > .in");if(c&&c.length){var d=c.data("bs.collapse");if(d&&d.transitioning)return;c.collapse("hide"),d||c.data("bs.collapse",null)}var e=this.dimension();this.$element.removeClass("collapse").addClass("collapsing")[e](0),this.transitioning=1;var f=function(){this.$element.removeClass("collapsing").addClass("in")[e]("auto"),this.transitioning=0,this.$element.trigger("shown.bs.collapse")};if(!a.support.transition)return f.call(this);var g=a.camelCase(["scroll",e].join("-"));this.$element.one(a.support.transition.end,a.proxy(f,this)).emulateTransitionEnd(350)[e](this.$element[0][g])}}},b.prototype.hide=function(){if(!this.transitioning&&this.$element.hasClass("in")){var b=a.Event("hide.bs.collapse");if(this.$element.trigger(b),!b.isDefaultPrevented()){var c=this.dimension();this.$element[c](this.$element[c]())[0].offsetHeight,this.$element.addClass("collapsing").removeClass("collapse").removeClass("in"),this.transitioning=1;var d=function(){this.transitioning=0,this.$element.trigger("hidden.bs.collapse").removeClass("collapsing").addClass("collapse")};return a.support.transition?(this.$element[c](0).one(a.support.transition.end,a.proxy(d,this)).emulateTransitionEnd(350),void 0):d.call(this)}}},b.prototype.toggle=function(){this[this.$element.hasClass("in")?"hide":"show"]()};var c=a.fn.collapse;a.fn.collapse=function(c){return this.each(function(){var d=a(this),e=d.data("bs.collapse"),f=a.extend({},b.DEFAULTS,d.data(),"object"==typeof c&&c);e||d.data("bs.collapse",e=new b(this,f)),"string"==typeof c&&e[c]()})},a.fn.collapse.Constructor=b,a.fn.collapse.noConflict=function(){return a.fn.collapse=c,this},a(document).on("click.bs.collapse.data-api","[data-toggle=collapse]",function(b){var c,d=a(this),e=d.attr("data-target")||b.preventDefault()||(c=d.attr("href"))&&c.replace(/.*(?=#[^\s]+$)/,""),f=a(e),g=f.data("bs.collapse"),h=g?"toggle":d.data(),i=d.attr("data-parent"),j=i&&a(i);g&&g.transitioning||(j&&j.find('[data-toggle=collapse][data-parent="'+i+'"]').not(d).addClass("collapsed"),d[f.hasClass("in")?"addClass":"removeClass"]("collapsed")),f.collapse(h)})}(jQuery),+function(a){"use strict";function b(){a(d).remove(),a(e).each(function(b){var d=c(a(this));d.hasClass("open")&&(d.trigger(b=a.Event("hide.bs.dropdown")),b.isDefaultPrevented()||d.removeClass("open").trigger("hidden.bs.dropdown"))})}function c(b){var c=b.attr("data-target");c||(c=b.attr("href"),c=c&&/#/.test(c)&&c.replace(/.*(?=#[^\s]*$)/,""));var d=c&&a(c);return d&&d.length?d:b.parent()}var d=".dropdown-backdrop",e="[data-toggle=dropdown]",f=function(b){a(b).on("click.bs.dropdown",this.toggle)};f.prototype.toggle=function(d){var e=a(this);if(!e.is(".disabled, :disabled")){var f=c(e),g=f.hasClass("open");if(b(),!g){if("ontouchstart"in document.documentElement&&!f.closest(".navbar-nav").length&&a('<div class="dropdown-backdrop"/>').insertAfter(a(this)).on("click",b),f.trigger(d=a.Event("show.bs.dropdown")),d.isDefaultPrevented())return;f.toggleClass("open").trigger("shown.bs.dropdown"),e.focus()}return!1}},f.prototype.keydown=function(b){if(/(38|40|27)/.test(b.keyCode)){var d=a(this);if(b.preventDefault(),b.stopPropagation(),!d.is(".disabled, :disabled")){var f=c(d),g=f.hasClass("open");if(!g||g&&27==b.keyCode)return 27==b.which&&f.find(e).focus(),d.click();var h=a("[role=menu] li:not(.divider):visible a",f);if(h.length){var i=h.index(h.filter(":focus"));38==b.keyCode&&i>0&&i--,40==b.keyCode&&i<h.length-1&&i++,~i||(i=0),h.eq(i).focus()}}}};var g=a.fn.dropdown;a.fn.dropdown=function(b){return this.each(function(){var c=a(this),d=c.data("dropdown");d||c.data("dropdown",d=new f(this)),"string"==typeof b&&d[b].call(c)})},a.fn.dropdown.Constructor=f,a.fn.dropdown.noConflict=function(){return a.fn.dropdown=g,this},a(document).on("click.bs.dropdown.data-api",b).on("click.bs.dropdown.data-api",".dropdown form",function(a){a.stopPropagation()}).on("click.bs.dropdown.data-api",e,f.prototype.toggle).on("keydown.bs.dropdown.data-api",e+", [role=menu]",f.prototype.keydown)}(jQuery),+function(a){"use strict";var b=function(b,c){this.options=c,this.$element=a(b),this.$backdrop=this.isShown=null,this.options.remote&&this.$element.load(this.options.remote)};b.DEFAULTS={backdrop:!0,keyboard:!0,show:!0},b.prototype.toggle=function(a){return this[this.isShown?"hide":"show"](a)},b.prototype.show=function(b){var c=this,d=a.Event("show.bs.modal",{relatedTarget:b});this.$element.trigger(d),this.isShown||d.isDefaultPrevented()||(this.isShown=!0,this.escape(),this.$element.on("click.dismiss.modal",'[data-dismiss="modal"]',a.proxy(this.hide,this)),this.backdrop(function(){var d=a.support.transition&&c.$element.hasClass("fade");c.$element.parent().length||c.$element.appendTo(document.body),c.$element.show(),d&&c.$element[0].offsetWidth,c.$element.addClass("in").attr("aria-hidden",!1),c.enforceFocus();var e=a.Event("shown.bs.modal",{relatedTarget:b});d?c.$element.find(".modal-dialog").one(a.support.transition.end,function(){c.$element.focus().trigger(e)}).emulateTransitionEnd(300):c.$element.focus().trigger(e)}))},b.prototype.hide=function(b){b&&b.preventDefault(),b=a.Event("hide.bs.modal"),this.$element.trigger(b),this.isShown&&!b.isDefaultPrevented()&&(this.isShown=!1,this.escape(),a(document).off("focusin.bs.modal"),this.$element.removeClass("in").attr("aria-hidden",!0).off("click.dismiss.modal"),a.support.transition&&this.$element.hasClass("fade")?this.$element.one(a.support.transition.end,a.proxy(this.hideModal,this)).emulateTransitionEnd(300):this.hideModal())},b.prototype.enforceFocus=function(){a(document).off("focusin.bs.modal").on("focusin.bs.modal",a.proxy(function(a){this.$element[0]===a.target||this.$element.has(a.target).length||this.$element.focus()},this))},b.prototype.escape=function(){this.isShown&&this.options.keyboard?this.$element.on("keyup.dismiss.bs.modal",a.proxy(function(a){27==a.which&&this.hide()},this)):this.isShown||this.$element.off("keyup.dismiss.bs.modal")},b.prototype.hideModal=function(){var a=this;this.$element.hide(),this.backdrop(function(){a.removeBackdrop(),a.$element.trigger("hidden.bs.modal")})},b.prototype.removeBackdrop=function(){this.$backdrop&&this.$backdrop.remove(),this.$backdrop=null},b.prototype.backdrop=function(b){var c=this.$element.hasClass("fade")?"fade":"";if(this.isShown&&this.options.backdrop){var d=a.support.transition&&c;if(this.$backdrop=a('<div class="modal-backdrop '+c+'" />').appendTo(document.body),this.$element.on("click.dismiss.modal",a.proxy(function(a){a.target===a.currentTarget&&("static"==this.options.backdrop?this.$element[0].focus.call(this.$element[0]):this.hide.call(this))},this)),d&&this.$backdrop[0].offsetWidth,this.$backdrop.addClass("in"),!b)return;d?this.$backdrop.one(a.support.transition.end,b).emulateTransitionEnd(150):b()}else!this.isShown&&this.$backdrop?(this.$backdrop.removeClass("in"),a.support.transition&&this.$element.hasClass("fade")?this.$backdrop.one(a.support.transition.end,b).emulateTransitionEnd(150):b()):b&&b()};var c=a.fn.modal;a.fn.modal=function(c,d){return this.each(function(){var e=a(this),f=e.data("bs.modal"),g=a.extend({},b.DEFAULTS,e.data(),"object"==typeof c&&c);f||e.data("bs.modal",f=new b(this,g)),"string"==typeof c?f[c](d):g.show&&f.show(d)})},a.fn.modal.Constructor=b,a.fn.modal.noConflict=function(){return a.fn.modal=c,this},a(document).on("click.bs.modal.data-api",'[data-toggle="modal"]',function(b){var c=a(this),d=c.attr("href"),e=a(c.attr("data-target")||d&&d.replace(/.*(?=#[^\s]+$)/,"")),f=e.data("modal")?"toggle":a.extend({remote:!/#/.test(d)&&d},e.data(),c.data());b.preventDefault(),e.modal(f,this).one("hide",function(){c.is(":visible")&&c.focus()})}),a(document).on("show.bs.modal",".modal",function(){a(document.body).addClass("modal-open")}).on("hidden.bs.modal",".modal",function(){a(document.body).removeClass("modal-open")})}(jQuery),+function(a){"use strict";var b=function(a,b){this.type=this.options=this.enabled=this.timeout=this.hoverState=this.$element=null,this.init("tooltip",a,b)};b.DEFAULTS={animation:!0,placement:"top",selector:!1,template:'<div class="tooltip"><div class="tooltip-arrow"></div><div class="tooltip-inner"></div></div>',trigger:"hover focus",title:"",delay:0,html:!1,container:!1},b.prototype.init=function(b,c,d){this.enabled=!0,this.type=b,this.$element=a(c),this.options=this.getOptions(d);for(var e=this.options.trigger.split(" "),f=e.length;f--;){var g=e[f];if("click"==g)this.$element.on("click."+this.type,this.options.selector,a.proxy(this.toggle,this));else if("manual"!=g){var h="hover"==g?"mouseenter":"focus",i="hover"==g?"mouseleave":"blur";this.$element.on(h+"."+this.type,this.options.selector,a.proxy(this.enter,this)),this.$element.on(i+"."+this.type,this.options.selector,a.proxy(this.leave,this))}}this.options.selector?this._options=a.extend({},this.options,{trigger:"manual",selector:""}):this.fixTitle()},b.prototype.getDefaults=function(){return b.DEFAULTS},b.prototype.getOptions=function(b){return b=a.extend({},this.getDefaults(),this.$element.data(),b),b.delay&&"number"==typeof b.delay&&(b.delay={show:b.delay,hide:b.delay}),b},b.prototype.getDelegateOptions=function(){var b={},c=this.getDefaults();return this._options&&a.each(this._options,function(a,d){c[a]!=d&&(b[a]=d)}),b},b.prototype.enter=function(b){var c=b instanceof this.constructor?b:a(b.currentTarget)[this.type](this.getDelegateOptions()).data("bs."+this.type);return clearTimeout(c.timeout),c.hoverState="in",c.options.delay&&c.options.delay.show?(c.timeout=setTimeout(function(){"in"==c.hoverState&&c.show()},c.options.delay.show),void 0):c.show()},b.prototype.leave=function(b){var c=b instanceof this.constructor?b:a(b.currentTarget)[this.type](this.getDelegateOptions()).data("bs."+this.type);return clearTimeout(c.timeout),c.hoverState="out",c.options.delay&&c.options.delay.hide?(c.timeout=setTimeout(function(){"out"==c.hoverState&&c.hide()},c.options.delay.hide),void 0):c.hide()},b.prototype.show=function(){var b=a.Event("show.bs."+this.type);if(this.hasContent()&&this.enabled){if(this.$element.trigger(b),b.isDefaultPrevented())return;var c=this.tip();this.setContent(),this.options.animation&&c.addClass("fade");var d="function"==typeof this.options.placement?this.options.placement.call(this,c[0],this.$element[0]):this.options.placement,e=/\s?auto?\s?/i,f=e.test(d);f&&(d=d.replace(e,"")||"top"),c.detach().css({top:0,left:0,display:"block"}).addClass(d),this.options.container?c.appendTo(this.options.container):c.insertAfter(this.$element);var g=this.getPosition(),h=c[0].offsetWidth,i=c[0].offsetHeight;if(f){var j=this.$element.parent(),k=d,l=document.documentElement.scrollTop||document.body.scrollTop,m="body"==this.options.container?window.innerWidth:j.outerWidth(),n="body"==this.options.container?window.innerHeight:j.outerHeight(),o="body"==this.options.container?0:j.offset().left;d="bottom"==d&&g.top+g.height+i-l>n?"top":"top"==d&&g.top-l-i<0?"bottom":"right"==d&&g.right+h>m?"left":"left"==d&&g.left-h<o?"right":d,c.removeClass(k).addClass(d)}var p=this.getCalculatedOffset(d,g,h,i);this.applyPlacement(p,d),this.$element.trigger("shown.bs."+this.type)}},b.prototype.applyPlacement=function(a,b){var c,d=this.tip(),e=d[0].offsetWidth,f=d[0].offsetHeight,g=parseInt(d.css("margin-top"),10),h=parseInt(d.css("margin-left"),10);isNaN(g)&&(g=0),isNaN(h)&&(h=0),a.top=a.top+g,a.left=a.left+h,d.offset(a).addClass("in");var i=d[0].offsetWidth,j=d[0].offsetHeight;if("top"==b&&j!=f&&(c=!0,a.top=a.top+f-j),/bottom|top/.test(b)){var k=0;a.left<0&&(k=-2*a.left,a.left=0,d.offset(a),i=d[0].offsetWidth,j=d[0].offsetHeight),this.replaceArrow(k-e+i,i,"left")}else this.replaceArrow(j-f,j,"top");c&&d.offset(a)},b.prototype.replaceArrow=function(a,b,c){this.arrow().css(c,a?50*(1-a/b)+"%":"")},b.prototype.setContent=function(){var a=this.tip(),b=this.getTitle();a.find(".tooltip-inner")[this.options.html?"html":"text"](b),a.removeClass("fade in top bottom left right")},b.prototype.hide=function(){function b(){"in"!=c.hoverState&&d.detach()}var c=this,d=this.tip(),e=a.Event("hide.bs."+this.type);return this.$element.trigger(e),e.isDefaultPrevented()?void 0:(d.removeClass("in"),a.support.transition&&this.$tip.hasClass("fade")?d.one(a.support.transition.end,b).emulateTransitionEnd(150):b(),this.$element.trigger("hidden.bs."+this.type),this)},b.prototype.fixTitle=function(){var a=this.$element;(a.attr("title")||"string"!=typeof a.attr("data-original-title"))&&a.attr("data-original-title",a.attr("title")||"").attr("title","")},b.prototype.hasContent=function(){return this.getTitle()},b.prototype.getPosition=function(){var b=this.$element[0];return a.extend({},"function"==typeof b.getBoundingClientRect?b.getBoundingClientRect():{width:b.offsetWidth,height:b.offsetHeight},this.$element.offset())},b.prototype.getCalculatedOffset=function(a,b,c,d){return"bottom"==a?{top:b.top+b.height,left:b.left+b.width/2-c/2}:"top"==a?{top:b.top-d,left:b.left+b.width/2-c/2}:"left"==a?{top:b.top+b.height/2-d/2,left:b.left-c}:{top:b.top+b.height/2-d/2,left:b.left+b.width}},b.prototype.getTitle=function(){var a,b=this.$element,c=this.options;return a=b.attr("data-original-title")||("function"==typeof c.title?c.title.call(b[0]):c.title)},b.prototype.tip=function(){return this.$tip=this.$tip||a(this.options.template)},b.prototype.arrow=function(){return this.$arrow=this.$arrow||this.tip().find(".tooltip-arrow")},b.prototype.validate=function(){this.$element[0].parentNode||(this.hide(),this.$element=null,this.options=null)},b.prototype.enable=function(){this.enabled=!0},b.prototype.disable=function(){this.enabled=!1},b.prototype.toggleEnabled=function(){this.enabled=!this.enabled},b.prototype.toggle=function(b){var c=b?a(b.currentTarget)[this.type](this.getDelegateOptions()).data("bs."+this.type):this;c.tip().hasClass("in")?c.leave(c):c.enter(c)},b.prototype.destroy=function(){this.hide().$element.off("."+this.type).removeData("bs."+this.type)};var c=a.fn.tooltip;a.fn.tooltip=function(c){return this.each(function(){var d=a(this),e=d.data("bs.tooltip"),f="object"==typeof c&&c;e||d.data("bs.tooltip",e=new b(this,f)),"string"==typeof c&&e[c]()})},a.fn.tooltip.Constructor=b,a.fn.tooltip.noConflict=function(){return a.fn.tooltip=c,this}}(jQuery),+function(a){"use strict";var b=function(a,b){this.init("popover",a,b)};if(!a.fn.tooltip)throw new Error("Popover requires tooltip.js");b.DEFAULTS=a.extend({},a.fn.tooltip.Constructor.DEFAULTS,{placement:"right",trigger:"click",content:"",template:'<div class="popover"><div class="arrow"></div><h3 class="popover-title"></h3><div class="popover-content"></div></div>'}),b.prototype=a.extend({},a.fn.tooltip.Constructor.prototype),b.prototype.constructor=b,b.prototype.getDefaults=function(){return b.DEFAULTS},b.prototype.setContent=function(){var a=this.tip(),b=this.getTitle(),c=this.getContent();a.find(".popover-title")[this.options.html?"html":"text"](b),a.find(".popover-content")[this.options.html?"html":"text"](c),a.removeClass("fade top bottom left right in"),a.find(".popover-title").html()||a.find(".popover-title").hide()},b.prototype.hasContent=function(){return this.getTitle()||this.getContent()},b.prototype.getContent=function(){var a=this.$element,b=this.options;return a.attr("data-content")||("function"==typeof b.content?b.content.call(a[0]):b.content)},b.prototype.arrow=function(){return this.$arrow=this.$arrow||this.tip().find(".arrow")},b.prototype.tip=function(){return this.$tip||(this.$tip=a(this.options.template)),this.$tip};var c=a.fn.popover;a.fn.popover=function(c){return this.each(function(){var d=a(this),e=d.data("bs.popover"),f="object"==typeof c&&c;e||d.data("bs.popover",e=new b(this,f)),"string"==typeof c&&e[c]()})},a.fn.popover.Constructor=b,a.fn.popover.noConflict=function(){return a.fn.popover=c,this}}(jQuery),+function(a){"use strict";function b(c,d){var e,f=a.proxy(this.process,this);this.$element=a(c).is("body")?a(window):a(c),this.$body=a("body"),this.$scrollElement=this.$element.on("scroll.bs.scroll-spy.data-api",f),this.options=a.extend({},b.DEFAULTS,d),this.selector=(this.options.target||(e=a(c).attr("href"))&&e.replace(/.*(?=#[^\s]+$)/,"")||"")+" .nav li > a",this.offsets=a([]),this.targets=a([]),this.activeTarget=null,this.refresh(),this.process()}b.DEFAULTS={offset:10},b.prototype.refresh=function(){var b=this.$element[0]==window?"offset":"position";this.offsets=a([]),this.targets=a([]);var c=this;this.$body.find(this.selector).map(function(){var d=a(this),e=d.data("target")||d.attr("href"),f=/^#\w/.test(e)&&a(e);return f&&f.length&&[[f[b]().top+(!a.isWindow(c.$scrollElement.get(0))&&c.$scrollElement.scrollTop()),e]]||null}).sort(function(a,b){return a[0]-b[0]}).each(function(){c.offsets.push(this[0]),c.targets.push(this[1])})},b.prototype.process=function(){var a,b=this.$scrollElement.scrollTop()+this.options.offset,c=this.$scrollElement[0].scrollHeight||this.$body[0].scrollHeight,d=c-this.$scrollElement.height(),e=this.offsets,f=this.targets,g=this.activeTarget;if(b>=d)return g!=(a=f.last()[0])&&this.activate(a);for(a=e.length;a--;)g!=f[a]&&b>=e[a]&&(!e[a+1]||b<=e[a+1])&&this.activate(f[a])},b.prototype.activate=function(b){this.activeTarget=b,a(this.selector).parents(".active").removeClass("active");var c=this.selector+'[data-target="'+b+'"],'+this.selector+'[href="'+b+'"]',d=a(c).parents("li").addClass("active");d.parent(".dropdown-menu").length&&(d=d.closest("li.dropdown").addClass("active")),d.trigger("activate")};var c=a.fn.scrollspy;a.fn.scrollspy=function(c){return this.each(function(){var d=a(this),e=d.data("bs.scrollspy"),f="object"==typeof c&&c;e||d.data("bs.scrollspy",e=new b(this,f)),"string"==typeof c&&e[c]()})},a.fn.scrollspy.Constructor=b,a.fn.scrollspy.noConflict=function(){return a.fn.scrollspy=c,this},a(window).on("load",function(){a('[data-spy="scroll"]').each(function(){var b=a(this);b.scrollspy(b.data())})})}(jQuery),+function(a){"use strict";var b=function(b){this.element=a(b)};b.prototype.show=function(){var b=this.element,c=b.closest("ul:not(.dropdown-menu)"),d=b.data("target");if(d||(d=b.attr("href"),d=d&&d.replace(/.*(?=#[^\s]*$)/,"")),!b.parent("li").hasClass("active")){var e=c.find(".active:last a")[0],f=a.Event("show.bs.tab",{relatedTarget:e});if(b.trigger(f),!f.isDefaultPrevented()){var g=a(d);this.activate(b.parent("li"),c),this.activate(g,g.parent(),function(){b.trigger({type:"shown.bs.tab",relatedTarget:e})})}}},b.prototype.activate=function(b,c,d){function e(){f.removeClass("active").find("> .dropdown-menu > .active").removeClass("active"),b.addClass("active"),g?(b[0].offsetWidth,b.addClass("in")):b.removeClass("fade"),b.parent(".dropdown-menu")&&b.closest("li.dropdown").addClass("active"),d&&d()}var f=c.find("> .active"),g=d&&a.support.transition&&f.hasClass("fade");g?f.one(a.support.transition.end,e).emulateTransitionEnd(150):e(),f.removeClass("in")};var c=a.fn.tab;a.fn.tab=function(c){return this.each(function(){var d=a(this),e=d.data("bs.tab");e||d.data("bs.tab",e=new b(this)),"string"==typeof c&&e[c]()})},a.fn.tab.Constructor=b,a.fn.tab.noConflict=function(){return a.fn.tab=c,this},a(document).on("click.bs.tab.data-api",'[data-toggle="tab"], [data-toggle="pill"]',function(b){b.preventDefault(),a(this).tab("show")})}(jQuery),+function(a){"use strict";var b=function(c,d){this.options=a.extend({},b.DEFAULTS,d),this.$window=a(window).on("scroll.bs.affix.data-api",a.proxy(this.checkPosition,this)).on("click.bs.affix.data-api",a.proxy(this.checkPositionWithEventLoop,this)),this.$element=a(c),this.affixed=this.unpin=null,this.checkPosition()};b.RESET="affix affix-top affix-bottom",b.DEFAULTS={offset:0},b.prototype.checkPositionWithEventLoop=function(){setTimeout(a.proxy(this.checkPosition,this),1)},b.prototype.checkPosition=function(){if(this.$element.is(":visible")){var c=a(document).height(),d=this.$window.scrollTop(),e=this.$element.offset(),f=this.options.offset,g=f.top,h=f.bottom;"object"!=typeof f&&(h=g=f),"function"==typeof g&&(g=f.top()),"function"==typeof h&&(h=f.bottom());var i=null!=this.unpin&&d+this.unpin<=e.top?!1:null!=h&&e.top+this.$element.height()>=c-h?"bottom":null!=g&&g>=d?"top":!1;this.affixed!==i&&(this.unpin&&this.$element.css("top",""),this.affixed=i,this.unpin="bottom"==i?e.top-d:null,this.$element.removeClass(b.RESET).addClass("affix"+(i?"-"+i:"")),"bottom"==i&&this.$element.offset({top:document.body.offsetHeight-h-this.$element.height()}))}};var c=a.fn.affix;a.fn.affix=function(c){return this.each(function(){var d=a(this),e=d.data("bs.affix"),f="object"==typeof c&&c;e||d.data("bs.affix",e=new b(this,f)),"string"==typeof c&&e[c]()})},a.fn.affix.Constructor=b,a.fn.affix.noConflict=function(){return a.fn.affix=c,this},a(window).on("load",function(){a('[data-spy="affix"]').each(function(){var b=a(this),c=b.data();c.offset=c.offset||{},c.offsetBottom&&(c.offset.bottom=c.offsetBottom),c.offsetTop&&(c.offset.top=c.offsetTop),b.affix(c)})})}(jQuery);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

},"show_students.js":function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// client/js/show_students.js                                                                                        //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
Template.showStudents.helpers({                                                                                      // 1
	'liststudent': function () {                                                                                        // 3
		return ListStudent.find({});                                                                                       // 4
	}                                                                                                                   // 5
});                                                                                                                  // 1
$(document).ready(function () {                                                                                      // 9
	if (itemscollection == 0) {                                                                                         // 11
		for (var i = 0; i < lstitem.length; i++) {                                                                         // 12
			Items.insert({                                                                                                    // 14
				items: lstitem[i].toString()                                                                                     // 15
			});                                                                                                               // 14
		}                                                                                                                  // 17
	} else {}                                                                                                           // 19
                                                                                                                     //
	$('#btnaddcoursedone').on("click", function () {                                                                    // 21
		var entered = $('#txtaddcourse').val();                                                                            // 22
		var courseCollection = Items.find({                                                                                // 23
			lstcourseitem: entered                                                                                            // 23
		}).count();                                                                                                        // 23
                                                                                                                     //
		if (courseCollection.toString() == "0") {                                                                          // 25
			Items.insert({                                                                                                    // 26
				Items: $('#txtaddcourse').val().toUpperCase()                                                                    // 27
			});                                                                                                               // 26
			alert("success");                                                                                                 // 29
		} else {                                                                                                           // 30
			alert("already exist");                                                                                           // 30
		}                                                                                                                  // 30
	});                                                                                                                 // 32
});                                                                                                                  // 34
Template.showStudents.events({                                                                                       // 36
	'click #btnAdd': function (event) {                                                                                 // 37
		//event.preventDefault();                                                                                          // 38
		Router.go('addStudent');                                                                                           // 40
	}                                                                                                                   // 41
});                                                                                                                  // 36
Template.addStudent.events({                                                                                         // 45
	'click #btnSave': function (event) {                                                                                // 46
		txtfullname = $('#txtfullname').val();                                                                             // 47
		txtaddress = $('#txtaddress').val();                                                                               // 48
		cmbcourse1 = $('#cmbcourse').val();                                                                                // 49
		var fname = txtfullname;                                                                                           // 51
		var studentsColletion = ListStudent.find({                                                                         // 52
			fullname: fname                                                                                                   // 52
		}).count();                                                                                                        // 52
                                                                                                                     //
		if (studentsColletion.toString() == "0") {                                                                         // 53
			if (txtfullname.trim().toString().length != 0) {                                                                  // 54
				ListStudent.insert({                                                                                             // 55
					fullname: txtfullname,                                                                                          // 56
					course: cmbcourse1,                                                                                             // 57
					address: txtaddress                                                                                             // 58
				});                                                                                                              // 55
				$('#txtfullname').val("");                                                                                       // 61
				$('#txtaddress').val("");                                                                                        // 62
				$('#cmbcourse').val("");                                                                                         // 63
			} else {                                                                                                          // 64
				alert('Please complete the requirments');                                                                        // 65
			}                                                                                                                 // 65
		} else {                                                                                                           // 66
			s;                                                                                                                // 66
			alert('Student already exist!!!');                                                                                // 67
		}                                                                                                                  // 68
	}                                                                                                                   // 69
});                                                                                                                  // 45
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}}},"lib":{"router.js":function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// lib/router.js                                                                                                     //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
Router.configure({                                                                                                   // 2
  layoutTemplate: 'layout'                                                                                           // 3
});                                                                                                                  // 2
Router.route('/', {                                                                                                  // 6
  name: 'main'                                                                                                       // 8
});                                                                                                                  // 6
Router.route('/addnew', {                                                                                            // 11
  name: 'addStudent',                                                                                                // 13
  template: 'addStudent'                                                                                             // 14
});                                                                                                                  // 11
Router.route('/home', {                                                                                              // 17
  name: 'Home'                                                                                                       // 18
});                                                                                                                  // 17
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

},"student.js":function(){

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                                   //
// lib/student.js                                                                                                    //
//                                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                                                                                                     //
ListStudent = new Mongo.Collection('liststudent');                                                                   // 1
Items = new Mongo.Collection('items');                                                                               // 2
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}}},{
  "extensions": [
    ".js",
    ".json",
    ".html",
    ".css"
  ]
});
require("./client/pages/template.addnew.js");
require("./client/pages/template.header.js");
require("./client/pages/template.home.js");
require("./client/pages/template.layout.js");
require("./client/pages/template.show_students.js");
require("./client/pages/template.main.js");
require("./lib/router.js");
require("./lib/student.js");
require("./client/js/addnew.js");
require("./client/js/bootstrap.js");
require("./client/js/bootstrap.min.js");
require("./client/js/show_students.js");