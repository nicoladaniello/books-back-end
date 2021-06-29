(self.webpackChunkbooks=self.webpackChunkbooks||[]).push([[192],{1730:function(e,n,r){"use strict";var t=r(7294),i=r(6594),o=r(5900),a=r.n(o);n.Z=function(e){var n=e.input,r=e.onClick,o=e.children;return t.createElement(i.Z,{variant:n?"primary-light":"light",className:a()(["mr-2",{"no-print":!n}]),onClick:function(){return r()}},o)}},7534:function(e,n,r){"use strict";var t=r(7294),i=r(3414),o=r(6594),a=r(6856);n.Z=function(e){var n=e.isOpen,r=e.onConfirm,l=e.onDismiss,c=e.children;return t.createElement(a.Z,{isOpen:n,onClose:l},t.createElement(i.Z.Body,null,c),t.createElement(i.Z.Footer,null,t.createElement(o.Z,{variant:"light",onClick:function(){return l()}},"Annulla"),t.createElement(o.Z,{variant:"primary",onClick:function(){return r()}},"Conferma")))}},1597:function(e,n,r){"use strict";r.r(n),r.d(n,{default:function(){return z}});var t=r(7294),i=r(3887),o=r(1730),a=r(7569),l=r(3948),c=r(2531),u=r(8060),s=r(9297),p=r(2137),d=r(7757),m=r.n(d),f=r(3645),v=r(7534),h=r(8066),E="DeleteInvoiceModal",Z=function(){var e=(0,i.v9)((function(e){return e.invoices.modals[E]})),n=(0,i.I0)(),r=e||{},o=r.isOpen,a=r.props,l=(a=void 0===a?{}:a).invoice,c=function(){var e=(0,p.Z)(m().mark((function e(){var r;return m().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,n((0,s.Od)(l));case 3:r=e.sent,(0,f.SI)(r),n((0,h.Mr)(E)),e.next=12;break;case 8:e.prev=8,e.t0=e.catch(0),alert("Errore durante l'eliminazione della fattura."),console.error("An error occurred while deleting the invoice.",e.t0);case 12:case"end":return e.stop()}}),e,null,[[0,8]])})));return function(){return e.apply(this,arguments)}}();return t.createElement(v.Z,{isOpen:o,onConfirm:c,onDismiss:function(){return n((0,h.Mr)(E))}},'Sei sicuro di voler eliminare la fattura "',null==l?void 0:l.description,'"?')};Z.modal=E;var C=Z,g=r(3414),k=r(6594),y=r(1522),b=r(7478),w=r(6856),M="SearchByPeriodModal",O=function(){var e=(0,i.v9)((function(e){return e.invoices.modals.SearchByPeriodModal})),n=(0,i.I0)(),r=(0,t.useState)(),o=r[0],a=r[1],l=(e||{}).isOpen,c=function(){var e=(0,p.Z)(m().mark((function e(){return m().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:n((0,h.tr)({period:o})),n((0,s.il)()),n((0,h.Mr)(M));case 3:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}}(),u=function(){var e=(0,p.Z)(m().mark((function e(n,r){var t,i;return m().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,y.Z.searchByMethod("periods","findByNameContainingIgnoreCase",{name:n});case 3:t=e.sent,i=t._embedded,r(i.periods),e.next=12;break;case 8:e.prev=8,e.t0=e.catch(0),alert("Errore: impossibile caricare opzioni."),console.error("Error while loading options.",e.t0);case 12:case"end":return e.stop()}}),e,null,[[0,8]])})));return function(n,r){return e.apply(this,arguments)}}();return t.createElement(w.Z,{isOpen:l,onClose:function(){return n((0,h.Mr)(M))}},t.createElement(g.Z.Body,null,t.createElement(b.Z,{getOptionLabel:function(e){return e.name},getOptionValue:function(e){return e.id},value:o,loadOptions:u,onChange:a})),t.createElement(g.Z.Footer,null,t.createElement(k.Z,{variant:"light",onClick:function(){return n((0,h.Mr)(M))}},"Annulla"),t.createElement(k.Z,{variant:"primary",type:"submit",onClick:c},"Confirma")))};O.modal=M;var x=O,S="SearchBySupplierModal",B=function(){var e=(0,i.v9)((function(e){return e.invoices.modals.SearchBySupplierModal})),n=(0,i.I0)(),r=(0,t.useState)(),o=r[0],a=r[1],l=(e||{}).isOpen,c=function(){var e=(0,p.Z)(m().mark((function e(){return m().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:n((0,h.tr)({supplier:o})),n((0,s.il)()),n((0,h.Mr)(S));case 3:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}}(),u=function(){var e=(0,p.Z)(m().mark((function e(n,r){var t,i;return m().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,y.Z.searchByMethod("suppliers","findByNameContainingIgnoreCase",{name:n});case 3:t=e.sent,i=t._embedded,r(i.suppliers),e.next=12;break;case 8:e.prev=8,e.t0=e.catch(0),alert("Errore: impossibile caricare opzioni."),console.error("Error while loading options.",e.t0);case 12:case"end":return e.stop()}}),e,null,[[0,8]])})));return function(n,r){return e.apply(this,arguments)}}();return t.createElement(w.Z,{isOpen:l,onClose:function(){return n((0,h.Mr)(S))}},t.createElement(g.Z.Body,null,t.createElement(b.Z,{getOptionLabel:function(e){return e.name},getOptionValue:function(e){return e.id},value:o,loadOptions:u,onChange:a})),t.createElement(g.Z.Footer,null,t.createElement(k.Z,{variant:"light",onClick:function(){return n((0,h.Mr)(S))}},"Annulla"),t.createElement(k.Z,{variant:"primary",type:"submit",onClick:c},"Confirma")))};B.modal=S;var I=B,L=r(9975),N=r(6094),z=function(){var e,n,r,p,d,m,f=(0,i.v9)((function(e){return e.invoices})),v=(0,i.I0)();(0,t.useEffect)((function(){v((0,s.il)())}),[v]);var E=[{label:t.createElement(a.Z,{icon:"edit"}),onClick:function(e){return v((0,h.h7)({modal:L.Z.modal,props:{invoice:e}}))}},{label:t.createElement(a.Z,{icon:"trash-alt"}),onClick:function(e){return v((0,h.h7)({modal:C.modal,props:{invoice:e}}))}}];return t.createElement(u.Z,{privateRoute:!0},t.createElement("div",{className:"h-100 px-3",style:{overflowY:"auto"}},t.createElement("div",{className:"my-3"},t.createElement(o.Z,{input:null===(e=f.search)||void 0===e?void 0:e.period,onClick:function(){return v((0,h.h7)({modal:x.modal}))}},(null===(n=f.search)||void 0===n||null===(r=n.period)||void 0===r?void 0:r.name)||"Seleiona periodo"),t.createElement(o.Z,{input:null===(p=f.search)||void 0===p?void 0:p.supplier,onClick:function(){return v((0,h.h7)({modal:I.modal}))}},(null===(d=f.search)||void 0===d||null===(m=d.supplier)||void 0===m?void 0:m.name)||"Seleziona fornitore")),t.createElement(c.Z,{schema:N,ids:f.ids,entities:f.entities,page:f.page,isLoading:f.isLoading,actions:E}),t.createElement(l.Z,{page:f.page,isLoading:f.isLoading,onLoadMore:function(){return v((0,s.nR)())}}),t.createElement(C,null),t.createElement(x,null),t.createElement(I,null)))}}}]);
//# sourceMappingURL=component---src-pages-invoices-jsx.e1438302366eb377b648.js.map