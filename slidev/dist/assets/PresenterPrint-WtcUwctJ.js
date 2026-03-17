import{d as p,u,a as h,c as d,b as f,r as g,t as v,e as y,_ as b,f as n,o as i,g as e,h as a,F as x,i as N,n as k,j as P,k as V,l as S}from"./index-CeDJLVrZ.js";import{N as j}from"./NoteDisplay-CpS3ik9y.js";const w=p({__name:"PresenterPrint",setup(m,{expose:r}){r(),u(`
@page {
  size: A4;
  margin-top: 1.5cm;
  margin-bottom: 1cm;
}
* {
  -webkit-print-color-adjust: exact;
}
html,
html body,
html #app,
html #page-root {
  height: auto;
  overflow: auto !important;
}
`),h({title:`Notes - ${d.title}`});const t={slidesWithNote:f(()=>g.map(s=>{var l;return(l=s.meta)==null?void 0:l.slide}).filter(s=>s!==void 0&&s.noteHTML!=="")),get configs(){return d},get themeVars(){return y},get total(){return v},NoteDisplay:j};return Object.defineProperty(t,"__isScriptSetup",{enumerable:!1,value:!0}),t}}),D={class:"m-4"},L={class:"mb-10"},T={class:"text-4xl font-bold mt-2"},W={class:"opacity-50"},B={class:"text-lg"},H={class:"font-bold flex gap-2"},z={class:"opacity-50"},C={key:0,class:"border-gray-400/50 mb-8"};function F(m,r,_,t,s,l){return i(),n("div",{id:"page-root",style:k(t.themeVars)},[e("div",D,[e("div",L,[e("h1",T,a(t.configs.title),1),e("div",W,a(new Date().toLocaleString()),1)]),(i(!0),n(x,null,N(t.slidesWithNote,(o,c)=>(i(),n("div",{key:c,class:"flex flex-col gap-4 break-inside-avoid-page"},[e("div",null,[e("h2",B,[e("div",H,[e("div",z,a(o==null?void 0:o.no)+"/"+a(t.total),1),S(" "+a(o==null?void 0:o.title)+" ",1),r[0]||(r[0]=e("div",{class:"flex-auto"},null,-1))])]),V(t.NoteDisplay,{"note-html":o.noteHTML,class:"max-w-full"},null,8,["note-html"])]),c<t.slidesWithNote.length-1?(i(),n("hr",C)):P("v-if",!0)]))),128))])],4)}const E=b(w,[["render",F],["__file","/Users/umitkose/javadayistanbul-modern-java-design-patterns/slidev/node_modules/@slidev/client/internals/PresenterPrint.vue"]]);export{E as default};
