(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0d70d2"],{"74ba":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-container",{staticClass:"justify-center"},[t._l(t.answers,function(e){return a("div",{key:e.id},[a("v-card",{staticClass:"ma-2 d-flex flex-column elevation-12 orange lighten-2",attrs:{height:"300","max-width":"300"}},[a("v-card-title",{staticClass:"justify-center black--text"},[a("h4",[t._v(t._s(e.text))])]),!0===e.correct?a("div",[t._v("\n        Odpowiedź prawidłowa.\n      ")]):t._e(),!1===e.correct?a("div",[t._v("\n        Odpowiedź błędna.\n      ")]):t._e(),a("v-divider"),a("v-card-actions",[a("v-btn",{staticClass:"ma-2",attrs:{small:"",color:"primary"},on:{click:function(a){return a.preventDefault(),t.editAnswer(e.id)}}},[t._v("Edytuj")])],1)],1)],1)}),a("v-dialog",{attrs:{persistent:""},scopedSlots:t._u([{key:"activator",fn:function(e){var s=e.on;return[a("v-btn",t._g({staticClass:"ma-2",attrs:{disabled:4==t.answers.length}},s),[t._v("Dodaj odpowiedz")])]}}]),model:{value:t.dialog,callback:function(e){t.dialog=e},expression:"dialog"}},[a("v-card",{staticClass:"elevation-12 orange lighten-5"},[a("v-toolbar",{staticClass:" orange lighten-3"},[a("v-toolbar-title",{staticClass:"headline"},[t._v("Dodaj nową odpowiedź")])],1),a("v-card-text",[a("v-container",[a("v-row",[a("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[a("v-text-field",{attrs:{label:"Nazwa odpowiedzi*",type:"text",required:""},model:{value:t.answer.text,callback:function(e){t.$set(t.answer,"text",e)},expression:"answer.text"}})],1)],1),a("v-switch",{staticClass:"mx-2",attrs:{label:"Odpowiedz prawidłowa ?*"},model:{value:t.answer.isCorrect,callback:function(e){t.$set(t.answer,"isCorrect",e)},expression:"answer.isCorrect"}})],1),a("small",[t._v("Pola oznaczone '*' są wymagane")])],1),a("v-card-actions",[a("v-spacer"),a("v-btn",{attrs:{color:"error darken-1"},on:{click:function(e){t.dialog=!1}}},[t._v("Zamknij")]),a("v-btn",{attrs:{color:"success darken-1"},on:{click:function(e){return t.addAnswer()}}},[t._v("Zapisz")])],1)],1)],1),a("v-dialog",{attrs:{persistent:""},model:{value:t.dialogEdit,callback:function(e){t.dialogEdit=e},expression:"dialogEdit"}},[a("v-card",{staticClass:"elevation-12 orange lighten-5"},[a("v-toolbar",{staticClass:" orange lighten-3"},[a("v-toolbar-title",{staticClass:"headline"},[t._v("Dodaj nową odpowiedź")])],1),a("v-card-text",[a("v-container",[a("v-row",[a("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[a("v-text-field",{attrs:{label:"Nazwa odpowiedzi*",type:"text",required:""},model:{value:t.answer.text,callback:function(e){t.$set(t.answer,"text",e)},expression:"answer.text"}})],1)],1),a("v-switch",{staticClass:"mx-2",attrs:{label:"Odpowiedz prawidłowa ?*"},model:{value:t.answer.isCorrect,callback:function(e){t.$set(t.answer,"isCorrect",e)},expression:"answer.isCorrect"}})],1),a("small",[t._v("Pola oznaczone '*' są wymagane")])],1),a("v-card-actions",[a("v-spacer"),a("v-btn",{attrs:{color:"error darken-1"},on:{click:function(e){t.dialogEdit=!1}}},[t._v("Zamknij")]),a("v-btn",{attrs:{color:"success darken-1"},on:{click:function(e){return t.updateAnswer()}}},[t._v("Zapisz")])],1)],1)],1)],2)},n=[],i=a("4c19"),r=a.n(i),o={data:function(){return{id:this.$route.params.id,dialog:!1,dialogEdit:!1,editAnswerId:"",canAddNewAnswer:!0,answers:[],answer:{text:"",isCorrect:""}}},methods:{getAnswers:function(t){var e=this;r.a.get("/api/quiz/"+t+"/answers").then(function(t){e.answers=t.data})},addAnswer:function(){var t=this;r.a.post("api/quiz/"+this.id+"/addAnswer",this.answer).then(function(){t.getAnswers(t.id),t.answer={text:"",isCorrect:""},t.dialog=!1})},updateAnswer:function(){var t=this;r.a.put("api/quiz/"+this.id+"/updateAnswer/"+this.editAnswerId,this.answer).then(function(){t.answer={text:"",isCorrect:""},t.dialogEdit=!1,t.getAnswers(t.id)})},editAnswer:function(t){this.editAnswerId=t,this.dialogEdit=!0}},created:function(){this.getAnswers(this.id)}},d=o,c=a("2877"),l=Object(c["a"])(d,s,n,!1,null,null,null);e["default"]=l.exports}}]);
//# sourceMappingURL=chunk-2d0d70d2.268e34e7.js.map