"use strict";(self["webpackChunkvue_learning"]=self["webpackChunkvue_learning"]||[]).push([[666],{1306:function(e,t,o){o.d(t,{Z:function(){return u}});var l=o(3396),a=o(2268);const s={class:"dialog-footer"};function n(e,t,o,n,i,r){const d=(0,l.up)("el-button"),m=(0,l.up)("el-text"),u=(0,l.up)("el-form-item"),g=(0,l.up)("el-input"),p=(0,l.up)("el-form"),c=(0,l.up)("el-dialog");return(0,l.wg)(),(0,l.iD)(l.HY,null,[(0,l.Wm)(d,{type:"primary",onClick:t[0]||(t[0]=t=>{i.dialogFormVisible=!0,e.$emit("myClick")})},{default:(0,l.w5)((()=>[(0,l.Uk)(" 借阅 ")])),_:1}),(0,l.Wm)(c,{modelValue:i.dialogFormVisible,"onUpdate:modelValue":t[3]||(t[3]=e=>i.dialogFormVisible=e),title:"借书登记",onOpen:r.prepare},{footer:(0,l.w5)((()=>[(0,l._)("span",s,[(0,l.Wm)(d,{onClick:t[2]||(t[2]=e=>{i.dialogFormVisible=!1})},{default:(0,l.w5)((()=>[(0,l.Uk)("取消")])),_:1}),(0,l.Wm)(d,{type:"primary",onClick:r.submit},{default:(0,l.w5)((()=>[(0,l.Uk)(" 确认 ")])),_:1},8,["onClick"])])])),default:(0,l.w5)((()=>[(0,l.Wm)(p,null,{default:(0,l.w5)((()=>[(0,l.Wm)(u,{label:"可借书本数","label-width":i.formLabelWidth},{default:(0,l.w5)((()=>[(0,l.Wm)(m,null,{default:(0,l.w5)((()=>[(0,l.Uk)((0,a.zw)(i.lend.customer.lendBookNum),1)])),_:1})])),_:1},8,["label-width"]),(0,l.Wm)(u,{label:"书籍剩余数量","label-width":i.formLabelWidth},{default:(0,l.w5)((()=>[(0,l.Wm)(m,null,{default:(0,l.w5)((()=>[(0,l.Uk)((0,a.zw)(i.lend.book.freeNumber),1)])),_:1})])),_:1},8,["label-width"]),(0,l.Wm)(u,{label:"借书天数","label-width":i.formLabelWidth},{default:(0,l.w5)((()=>[(0,l.Wm)(g,{modelValue:i.lend.lenDays,"onUpdate:modelValue":t[1]||(t[1]=e=>i.lend.lenDays=e),modelModifiers:{number:!0},autocomplete:"off"},null,8,["modelValue"])])),_:1},8,["label-width"])])),_:1})])),_:1},8,["modelValue","onOpen"])],64)}var i=o(9168),r={name:"LendDetails_mila",data(){return{dialogFormVisible:!1,lend:{lenDays:0},formLabelWidth:"140px"}},mounted(){this.lend.customer=JSON.parse(sessionStorage.getItem("user")),this.lend.book=JSON.parse(sessionStorage.getItem("nowBook"))},methods:{prepare(){this.lend.customer=JSON.parse(sessionStorage.getItem("user")),this.lend.book=JSON.parse(sessionStorage.getItem("nowBook"))},formDate(e){let t=e.getFullYear(),o=(e.getMonth()+1).toString().padStart(2,"0"),l=e.getDate().toString().padStart(2,"0");return`${t}-${o}-${l}`},submit(){0!==this.lend.book.freeNumber?0!==this.lend.customer.lendBookNum?(this.dialogFormVisible=!1,this.lend.borrowTime=this.formDate(new Date),i.Z.post("api/book/lend",this.lend).then((e=>{"-1"===e.data.code?this.$message({message:e.data.msg,type:"error"}):(this.$message({message:"借阅成功",type:"success"}),console.log(e.data.data),this.lend=e.data.data,console.log(this.lend),sessionStorage.setItem("user",JSON.stringify(this.lend.customer)),window.location.reload())}))):this.$message({message:"达到借书上限",type:"error"}):this.$message({message:"书籍无剩余",type:"error"})}}},d=o(89);const m=(0,d.Z)(r,[["render",n],["__scopeId","data-v-6e5c03d4"]]);var u=m},5666:function(e,t,o){o.r(t),o.d(t,{default:function(){return f}});var l=o(3396),a=o(2268);const s={class:"image-container"},n=["src"],i={style:{height:"30px"}},r={style:{height:"30px"}};function d(e,t,o,d,m,u){const g=(0,l.up)("el-button"),p=(0,l.up)("lend"),c=(0,l.up)("el-card"),h=(0,l.up)("el-col"),f=(0,l.up)("el-row"),b=(0,l.up)("el-pagination");return(0,l.wg)(),(0,l.iD)(l.HY,null,[(0,l.Wm)(f,{gutter:20,style:{"margin-left":"2%"}},{default:(0,l.w5)((()=>[((0,l.wg)(!0),(0,l.iD)(l.HY,null,(0,l.Ko)(m.books,(e=>((0,l.wg)(),(0,l.j4)(h,{xs:12,sm:6,key:e.id},{default:(0,l.w5)((()=>[(0,l.Wm)(c,{class:"book-card",style:{overflow:"hidden"}},{default:(0,l.w5)((()=>[(0,l._)("div",s,[(0,l._)("img",{src:e.imgSrc,alt:"Book Cover",style:{"max-width":"100%",height:"150px","object-fit":"cover"}},null,8,n)]),(0,l._)("div",null,[(0,l._)("h3",i,(0,a.zw)(e.bookName),1),(0,l._)("p",r,(0,a.zw)(e.description),1),(0,l.Wm)(g,{type:"text",onClick:t=>u.detail(e)},{default:(0,l.w5)((()=>[(0,l.Uk)("图书详情")])),_:2},1032,["onClick"]),(0,l.Wm)(p,{onMyClick:t=>u.lend(e)},null,8,["onMyClick"])])])),_:2},1024)])),_:2},1024)))),128))])),_:1}),(0,l.Wm)(b,{background:"",layout:"prev, pager, next",total:m.totalBooks},null,8,["total"])],64)}o(560);var m=o(1306),u=o(9168),g=o(1120),p={name:"BookList_mila",components:{lend:m.Z},data(){return{books:[],totalBooks:10}},mounted(){u.Z.post("api/book/findALl").then((e=>{"-1"===e.data.code?this.$message({message:e.data.msg,type:"error"}):(this.books=e.data.data,console.log(e.data.data))}))},methods:{detail(e){sessionStorage.setItem("nowBook",JSON.stringify(e)),g.Z.push("/bookDetails")},lend(e){sessionStorage.setItem("nowBook",JSON.stringify(e))}}},c=o(89);const h=(0,c.Z)(p,[["render",d],["__scopeId","data-v-d9de34b8"]]);var f=h}}]);
//# sourceMappingURL=666.41f0d14e.js.map