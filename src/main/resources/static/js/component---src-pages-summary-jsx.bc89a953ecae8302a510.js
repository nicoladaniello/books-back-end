(self.webpackChunkbooks=self.webpackChunkbooks||[]).push([[90],{1730:function(e,t,n){"use strict";var r=n(7294),i=n(6594),a=n(5900),o=n.n(a);t.Z=function(e){var t=e.input,n=e.onClick,a=e.children;return r.createElement(i.Z,{variant:t?"primary-light":"light",className:o()(["mr-2",{"no-print":!t}]),onClick:function(){return n()}},a)}},5468:function(e,t,n){"use strict";n.r(t),n.d(t,{default:function(){return C}});var r=n(7294),i=n(3887),a=n(3948),o=n(1730),u=n(2531),c=n(8060),l=n(4309),s=n(2137),p=n(7757),d=n.n(p),m=n(3414),f=n(6594),v=n(2950),h=n(1522),y=n(7478),g=n(6856),E="SearchByPeriodModal",Z=function(){var e=(0,i.v9)((function(e){return e.summaries.modals.SearchByPeriodModal})),t=(0,i.I0)(),n=(0,r.useState)(),a=n[0],o=n[1],u=(e||{}).isOpen,c=function(){var e=(0,s.Z)(d().mark((function e(){return d().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:t((0,v.tr)({period:a})),t((0,l.il)()),t((0,v.Mr)(E));case 3:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}}(),p=function(){var e=(0,s.Z)(d().mark((function e(t,n){var r,i;return d().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.prev=0,e.next=3,h.Z.searchByMethod("periods","findByNameContainingIgnoreCase",{name:t});case 3:r=e.sent,i=r._embedded,n(i.periods),e.next=12;break;case 8:e.prev=8,e.t0=e.catch(0),alert("Errore: impossibile caricare opzioni."),console.error("Error while loading options.",e.t0);case 12:case"end":return e.stop()}}),e,null,[[0,8]])})));return function(t,n){return e.apply(this,arguments)}}();return r.createElement(g.Z,{isOpen:u,onClose:function(){return t((0,v.Mr)(E))}},r.createElement(m.Z.Body,null,r.createElement(y.Z,{getOptionLabel:function(e){return e.name},getOptionValue:function(e){return e.id},value:a,loadOptions:p,onChange:o})),r.createElement(m.Z.Footer,null,r.createElement(f.Z,{variant:"light",onClick:function(){return t((0,v.Mr)(E))}},"Annulla"),r.createElement(f.Z,{variant:"primary",type:"submit",onClick:c},"Confirma")))};Z.modal=E;var k=Z,b=JSON.parse('{"$schema":"http://json-schema.org/draft-07/schema#","title":"Situazione Fornitore","type":"object","properties":{"periodId":{"title":"ID periodo","readOnly":true,"writeOnly":true,"type":"integer"},"supplierName":{"title":"Fornitore","readOnly":true,"type":"string"},"totalDueAmount":{"title":"Fatture","readOnly":true,"type":"number","format":"currency"},"totalPaidAmount":{"title":"Pagamenti","readOnly":true,"type":"number","format":"currency"},"outstandingAmount":{"title":"Residuo","readOnly":true,"type":"number","format":"currency"}}}'),C=function(){var e,t,n,s=(0,i.v9)((function(e){return e.summaries})),p=(0,i.I0)();return(0,r.useEffect)((function(){p((0,l.il)())}),[p]),r.createElement(c.Z,{privateRoute:!0},r.createElement("div",{className:"h-100 px-3",style:{overflowY:"auto"}},r.createElement("div",{className:"my-3"},r.createElement(o.Z,{input:null===(e=s.search)||void 0===e?void 0:e.period,onClick:function(){return p((0,v.h7)({modal:k.modal}))}},(null===(t=s.search)||void 0===t||null===(n=t.period)||void 0===n?void 0:n.name)||"Seleiona periodo")),r.createElement(u.Z,{schema:b,ids:s.ids,entities:s.entities,page:s.page,isLoading:s.isLoading}),r.createElement(a.Z,{page:s.page,isLoading:s.isLoading,onLoadMore:function(){return p((0,l.nR)())}})),r.createElement(k,null))}}}]);
//# sourceMappingURL=component---src-pages-summary-jsx.bc89a953ecae8302a510.js.map