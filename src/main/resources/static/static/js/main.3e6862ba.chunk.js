(this["webpackJsonpmatch-fun-words-fe"]=this["webpackJsonpmatch-fun-words-fe"]||[]).push([[0],{101:function(e,t,n){e.exports=n(142)},106:function(e,t,n){},107:function(e,t,n){},130:function(e,t,n){},132:function(e,t,n){},134:function(e,t,n){},135:function(e,t,n){},142:function(e,t,n){"use strict";n.r(t);var a=n(0),r=n.n(a),c=n(9),o=n.n(c),l=(n(106),n(107),n(28)),u=n(32),i=n(12),s=n(13),m=function(e){return{type:"CHANGE_ROLE",role:e}},d=n(18),b=n.n(d),f=n(33),p=n(26),E=n.n(p),v="/login",h="/register",g="/match",O="/",j="/join",w="/card",y="/judge",x="/user",N=function(){var e=Object(f.a)(b.a.mark((function e(t,n){var a;return b.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return a={username:t,pwd:n},e.abrupt("return",E.a.post(x+v,a));case 2:case"end":return e.stop()}}),e)})));return function(t,n){return e.apply(this,arguments)}}(),S=function(){var e=Object(f.a)(b.a.mark((function e(t){return b.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",E.a.post(x+h,t));case 1:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}(),k=n(181),C=n(86),I=n.n(C),A=n(87),J=n.n(A),D=n(178),P=n(186),G=(n(130),n(83)),W=n.n(G),L=n(173),R=function(e){return r.a.createElement("div",{className:"header"},r.a.createElement("div",{className:"div-title"},r.a.createElement("span",{className:"rainbow-text"},e.title)),e.options?r.a.createElement("div",{className:"div-option"},r.a.createElement(L.a,{edge:"end",color:"inherit"},r.a.createElement(W.a,null))):r.a.createElement("div",null))},U=n(177),z=Object(U.a)({root:{background:"linear-gradient(263deg, rgba(2,0,36,1) 0%, rgba(79,119,189,1) 45%, rgba(0,212,255,1) 100%)",minWidth:"218px"},label:{color:"whitesmoke"}}),Y=(n(132),function(){var e=Object(a.useState)(""),t=Object(i.a)(e,2),n=t[0],c=t[1],o=Object(a.useState)(""),m=Object(i.a)(o,2),d=m[0],b=m[1],f=Object(u.g)(),p=Object(s.b)(),E=z();return r.a.createElement(D.a,{className:"page",maxWidth:"md"},r.a.createElement(R,{title:"Match fun words"}),r.a.createElement("div",{className:"page-content"},r.a.createElement(P.a,{id:"username",label:"Username",margin:"normal",variant:"outlined",value:n,onChange:function(e){return c(e.target.value)},InputProps:{startAdornment:r.a.createElement(I.a,null)}}),r.a.createElement("br",null),r.a.createElement(P.a,{id:"password",label:"Password",type:"password",autoComplete:"current-password",margin:"normal",variant:"outlined",value:d,onChange:function(e){return b(e.target.value)},InputProps:{startAdornment:r.a.createElement(J.a,null)}}),r.a.createElement("br",null),r.a.createElement("br",null),r.a.createElement(k.a,{classes:{root:E.root,label:E.label},size:"large",variant:"text",onClick:function(){N(n,d).then((function(e){var t=e.data;null!=t&&(console.log(t),localStorage.setItem("jwt",t.jwt),p({type:"LOGIN",user:t}),f.push("/dashboard"))})).catch((function(e){return console.log(e)}))}},"login"),r.a.createElement("br",null),r.a.createElement("br",null),r.a.createElement("div",{className:"redirect-register-div"},"New user?",r.a.createElement("br",null),r.a.createElement("b",null,r.a.createElement(l.b,{to:"/register"},"Register now!")))))}),T=n(23),_=n(189),H=n(187),B={email:"",name:"",password:"",surname:"",username:""},F=function(e){return r.a.createElement(H.a,Object.assign({elevation:6,variant:"filled"},e))},M=function(){var e=Object(a.useState)(B),t=Object(i.a)(e,2),n=t[0],c=t[1],o=Object(a.useState)(!1),l=Object(i.a)(o,2),s=l[0],m=l[1],d=Object(a.useState)(!1),b=Object(i.a)(d,2),f=b[0],p=b[1],E=Object(u.g)(),v=z();return r.a.createElement(D.a,{className:"page",maxWidth:"md"},r.a.createElement(R,{title:"Join"}),r.a.createElement("div",{className:"page-content"},r.a.createElement(P.a,{id:"username",label:"Username",type:"text",margin:"normal",variant:"outlined",value:n.username,onChange:function(e){e.persist(),c((function(t){return Object(T.a)({},t,{username:e.target.value})}))}}),r.a.createElement("br",null),r.a.createElement(P.a,{id:"email",label:"Email",type:"text",margin:"normal",variant:"outlined",value:n.email,onChange:function(e){e.persist(),c((function(t){return Object(T.a)({},t,{email:e.target.value})}))}}),r.a.createElement("br",null),r.a.createElement(P.a,{id:"name",label:"Name",type:"text",margin:"normal",variant:"outlined",value:n.name,onChange:function(e){e.persist(),c((function(t){return Object(T.a)({},t,{name:e.target.value})}))}}),r.a.createElement("br",null),r.a.createElement(P.a,{id:"surname",label:"Surname",type:"text",margin:"normal",variant:"outlined",value:n.surname,onChange:function(e){e.persist(),c((function(t){return Object(T.a)({},t,{surname:e.target.value})}))}}),r.a.createElement("br",null),r.a.createElement(P.a,{id:"password",label:"Password",type:"password",margin:"normal",variant:"outlined",value:n.password,onChange:function(e){e.persist(),c((function(t){return Object(T.a)({},t,{password:e.target.value})}))}}),r.a.createElement("br",null),r.a.createElement("br",null),r.a.createElement(k.a,{size:"large",variant:"text",classes:{root:v.root,label:v.label},onClick:function(){S(n).then((function(e){var t=e.data;console.log(t),m((function(){return!0})),p(t)}))}},"Register")),r.a.createElement(_.a,{open:s,autoHideDuration:3e3,onClose:function(){m((function(){return!1})),f&&E.push("/login")}},r.a.createElement(F,{severity:f?"success":"error"},f?"Registrazione effettuata con successo":"Registrazione non andata a buon fine")))},q=function(e){return e.user.username},Q=function(e){return e.user.role},V=g;E.a.interceptors.request.use((function(e){return e.headers.Authorization="Bearer "+localStorage.getItem("jwt"),e}));var $,K=function(){var e=Object(f.a)(b.a.mark((function e(){return b.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",E.a.post(V+O));case 1:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}}(),X=function(){var e=Object(f.a)(b.a.mark((function e(t){return b.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",E.a.post(V+"/"+t+j));case 1:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}(),Z=function(){var e=Object(f.a)(b.a.mark((function e(t){return b.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",E.a.post(V+"/"+t+w));case 1:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}(),ee=function(){var e=Object(f.a)(b.a.mark((function e(t){return b.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",E.a.post(V+"/"+t+y));case 1:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}();!function(e){e[e.PLAYER=0]="PLAYER",e[e.JUDGE=1]="JUDGE"}($||($={}));var te=function(e){return{type:"INIT",answers:e}},ne=function(){var e=Object(s.c)(q),t=Object(u.g)(),n=Object(s.b)();return r.a.createElement(D.a,{className:"page",maxWidth:"md"},r.a.createElement(R,{title:"Welcome ".concat(e)}),r.a.createElement("div",{className:"page-content"},r.a.createElement(k.a,{variant:"outlined",color:"primary",onClick:function(){K().then((function(e){var a=e.data;console.log(a),n(m($.JUDGE)),Z(a).then((function(e){console.log(e);var t=e.data;n(te(t))})),t.push("/match/"+a)})).catch((function(e){return console.log(e)}))}},"Create a new match"),r.a.createElement("br",null),r.a.createElement("br",null),r.a.createElement(k.a,{variant:"outlined",color:"primary",onClick:function(){t.push("/join")}},"Join a match")))},ae=function(e){var t="";if(e.isAuthenticated||(t=e.authenticationPath),t){return r.a.createElement(u.b,Object.assign({},e,{component:function(){return r.a.createElement(u.a,{to:{pathname:t}})},render:void 0}))}return r.a.createElement(u.b,e)},re=n(39),ce=(n(134),function(e){var t=e.text,n=e.role,a=e.buttonFunction;return r.a.createElement("div",{className:"answer-card-div"},t,r.a.createElement(k.a,{className:"send-btn",variant:"text",color:"primary",onClick:a},n===$.JUDGE?"CHOOSE":"SEND"))}),oe=n(190),le=n(191),ue=(n(135),function(e){var t=e.matchId,n=e.client,c=Object(a.useState)(),o=Object(i.a)(c,2),l=o[0],u=o[1],d=Object(a.useState)([]),b=Object(i.a)(d,2),f=b[0],p=b[1],E=Object(a.useState)(""),v=Object(i.a)(E,2),h=v[0],g=v[1],O=Object(a.useState)(!1),j=Object(i.a)(O,2),w=j[0],y=j[1],x=Object(a.useState)(),N=Object(i.a)(x,2),S=N[0],C=N[1],I=Object(s.b)();Object(a.useEffect)((function(){ee(t).then((function(e){u((function(){return e.data}))})).catch((function(e){return console.log(e)}))}),[t]),Object(a.useEffect)((function(){if(n.connected){var e=n.subscribe("/game/judge/".concat(t),(function(e){var t=JSON.parse(e.body);p((function(e){return[].concat(Object(re.a)(e),[t])}))})).id;g((function(){return e})),C((function(){return setInterval((function(){return n.send("/")}),5e4)}))}else clearInterval(S)}),[t,n.connected]);return r.a.createElement("div",null,r.a.createElement("div",null,r.a.createElement("div",{className:"judge-card-div"},l?null===l||void 0===l?void 0:l.text.replace("{}","___"):r.a.createElement("div",null))),r.a.createElement("div",{className:"page-content"},f?f.map((function(e,a){return r.a.createElement(ce,{key:a,text:e.text,role:$.JUDGE,buttonFunction:function(){return a=e,console.log(a),n.send("/app/match/".concat(t,"/judge/choose"),{},JSON.stringify(a)),n.unsubscribe(h),void y(!0);var a}})})):r.a.createElement("div",null)),r.a.createElement(oe.a,{onClose:function(){},"aria-labelledby":"simple-dialog-title",open:w},r.a.createElement(le.a,{id:"simple-dialog-title"},"Waiting for other player"),r.a.createElement("div",null,"Vai al prossimo round ",r.a.createElement("br",null),r.a.createElement(k.a,{size:"small",variant:"outlined",onClick:function(){n.disconnect((function(){return console.log("Websocket disconnected")})),I(m($.PLAYER))},color:"primary"},"Next round"))))}),ie=function(e){return e.answer},se=n(184),me=n(182),de=n(183),be=n(58),fe=n(57),pe=function(e){var t=e.matchId,n=e.client,c=Object(s.c)(q),o=Object(s.b)(),l=Object(a.useState)(!1),u=Object(i.a)(l,2),d=u[0],b=u[1],f=Object(a.useState)(!1),p=Object(i.a)(f,2),E=p[0],v=p[1],h=Object(a.useState)((function(){return r.a.createElement("div",null)})),g=Object(i.a)(h,2),O=g[0],j=g[1],w=Object(a.useState)($.PLAYER),y=Object(i.a)(w,2),x=y[0],N=y[1],S=Object(a.useState)(),C=Object(i.a)(S,2),I=C[0],A=C[1];Object(a.useEffect)((function(){if(n.connected){var e=n.subscribe("/game/player/".concat(t,"/").concat(c),(function(t){var n=JSON.parse(t.body);o({type:"ADD",answer:n}),e.unsubscribe()})),a=n.subscribe("/game/player/".concat(t),(function(e){JSON.parse(e.body).playerId===c?(N($.JUDGE),j((function(){return r.a.createElement("div",null,r.a.createElement(me.a,{fontSize:"large",style:{color:be.a[500]}}),r.a.createElement("br",null),"Complimenti hai vinto")}))):j((function(){return r.a.createElement("div",null,r.a.createElement(de.a,{fontSize:"large",style:{color:fe.a[500]}}),r.a.createElement("br",null),"Peccato, hai perso")})),a.unsubscribe(),v((function(){return!0}))}));A((function(){return setInterval((function(){return n.send("/")}),5e4)}))}else clearInterval(I)}),[t,n.connected,c]);var J=Object(s.c)(ie);return r.a.createElement("div",null,J?J.map((function(e,a){return r.a.createElement(ce,{key:a,text:e.text,role:$.PLAYER,buttonFunction:function(){return function(e){e.playerId=c,console.log(e),n.send("/app/match/".concat(t,"/player/").concat(c,"/card"),{},JSON.stringify(e)),o(function(e){return{type:"DELETE",answer:e}}(e)),b((function(){return!0})),j((function(){return r.a.createElement("div",null,r.a.createElement(se.a,null))}))}(e)}})})):r.a.createElement("div",null),r.a.createElement(oe.a,{onClose:function(){},"aria-labelledby":"simple-dialog-title",open:d},r.a.createElement(le.a,{id:"simple-dialog-title"},"Waiting for other player"),r.a.createElement("div",null,O,r.a.createElement(k.a,{disabled:!E,size:"small",variant:"outlined",onClick:function(){o(m(x)),n.disconnect((function(){return console.log("Websocket disconnected")}))},color:"primary"},"Next round"))))},Ee=n(88),ve=n.n(Ee),he=function(e){console.log(e);var t=e.match.params.matchId,n=Object(s.c)(Q),a=new WebSocket("wss://match-fun-words.herokuapp.com/match-fun-words"),c=ve.a.over(a);return c.connect({},(function(){console.log("connesso al websocket")})),r.a.createElement(D.a,{className:"page",maxWidth:"md"},r.a.createElement(R,{title:"".concat(n===$.JUDGE?"Giudice":"Giocatore"," ").concat(t)}),n===$.JUDGE?r.a.createElement(ue,{matchId:t,client:c}):r.a.createElement(pe,{matchId:t,client:c}))},ge=n(185),Oe=function(){var e=Object(a.useState)(""),t=Object(i.a)(e,2),n=t[0],c=t[1],o=Object(u.g)(),l=Object(s.b)();return r.a.createElement(D.a,{className:"page",maxWidth:"md"},r.a.createElement(R,{title:"Join match"}),r.a.createElement("div",{className:"page-content"},r.a.createElement(P.a,{label:"Match Id",variant:"outlined",onChange:function(e){e.preventDefault(),c(e.target.value)},value:n,InputProps:{startAdornment:r.a.createElement(ge.a,null)}}),r.a.createElement("br",null),r.a.createElement("br",null),r.a.createElement(k.a,{variant:"outlined",color:"primary",onClick:function(){X(n).then((function(e){!0===e.data?(l(m($.PLAYER)),Z(n).then((function(e){console.log(e);var t=e.data;l(te(t))})),o.push("/match/"+n)):console.log("Qualcosa \xe8 andato storto")})).catch((function(e){return console.log(e)}))}},"Join")))},je=function(){var e=Object(s.c)(q);return r.a.createElement("div",{className:"App"},r.a.createElement(l.a,null,r.a.createElement(u.d,null,r.a.createElement(u.b,{path:"/",exact:!0},r.a.createElement(u.a,{to:"/login"})),r.a.createElement(u.b,{path:"/login",exact:!0},r.a.createElement(Y,null)),r.a.createElement(u.b,{path:"/register",exact:!0},r.a.createElement(M,null)),r.a.createElement(ae,{isAuthenticated:""!==e,authenticationPath:"/login",exact:!0,path:"/dashboard",component:ne}),r.a.createElement(ae,{isAuthenticated:""!==e,authenticationPath:"/login",exact:!0,path:"/match/:matchId",component:he}),r.a.createElement(ae,{isAuthenticated:""!==e,authenticationPath:"/login",exact:!0,path:"/join",component:Oe}))))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));var we=n(40),ye=n(89),xe={name:"",surname:"",email:"",username:"",jwt:"",role:$.PLAYER},Ne=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:xe,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"LOGIN":return Object(T.a)({},t.user);case"LOGOUT":return Object(T.a)({},xe);case"CHANGE_ROLE":return Object(T.a)({},e,{role:t.role});default:return Object(T.a)({},e)}},Se=[],ke=function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:Se,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case"INIT":return Object(re.a)(t.answers);case"ADD":return Object(re.a)(e.concat(t.answer));case"DELETE":return Object(re.a)(e.filter((function(e){return e.text!==t.answer.text})));default:return Object(re.a)(e)}},Ce=Object(we.createStore)(Object(we.combineReducers)({user:Ne,answer:ke}),Object(ye.composeWithDevTools)());o.a.render(r.a.createElement(s.a,{store:Ce},r.a.createElement(je,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))}},[[101,1,2]]]);
//# sourceMappingURL=main.3e6862ba.chunk.js.map