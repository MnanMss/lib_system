"use strict";(self["webpackChunkvue_learning"]=self["webpackChunkvue_learning"]||[]).push([[510],{4510:function(e,o,l){l.r(o),l.d(o,{default:function(){return f}});var a=l(3396);const n=e=>((0,a.dD)("data-v-81258b76"),e=e(),(0,a.Cn)(),e),r={class:"login-wrapper"},s=n((()=>(0,a._)("div",{class:"title"},"图书管理系统",-1)));function i(e,o,l,n,i,m){const t=(0,a.up)("router-view"),u=(0,a.up)("el-input"),d=(0,a.up)("el-form-item"),p=(0,a.up)("el-button"),c=(0,a.up)("el-form"),f=(0,a.up)("el-card");return(0,a.wg)(),(0,a.iD)(a.HY,null,[(0,a.Wm)(t),(0,a._)("div",r,[(0,a.Wm)(f,{class:"login-box"},{default:(0,a.w5)((()=>[s,(0,a.Wm)(c,{ref:"loginForm",model:i.loginForm,"label-position":"top"},{default:(0,a.w5)((()=>[(0,a.Wm)(d,null,{default:(0,a.w5)((()=>[(0,a.Wm)(u,{modelValue:i.loginForm.username,"onUpdate:modelValue":o[0]||(o[0]=e=>i.loginForm.username=e),placeholder:"用户名","prefix-icon":m.User,autocomplete:"off"},null,8,["modelValue","prefix-icon"])])),_:1}),(0,a.Wm)(d,null,{default:(0,a.w5)((()=>[(0,a.Wm)(u,{type:"password",modelValue:i.loginForm.password,"onUpdate:modelValue":o[1]||(o[1]=e=>i.loginForm.password=e),placeholder:"密码","prefix-icon":m.Unlock,autocomplete:"off","show-password":""},null,8,["modelValue","prefix-icon"])])),_:1}),(0,a.Wm)(d,null,{default:(0,a.w5)((()=>[(0,a.Wm)(u,{type:"password",modelValue:i.confirmPassword,"onUpdate:modelValue":o[2]||(o[2]=e=>i.confirmPassword=e),placeholder:"确认密码","prefix-icon":m.Unlock,autocomplete:"off","show-password":""},null,8,["modelValue","prefix-icon"])])),_:1}),(0,a.Wm)(d,null,{default:(0,a.w5)((()=>[(0,a.Wm)(u,{modelValue:i.loginForm.phone,"onUpdate:modelValue":o[3]||(o[3]=e=>i.loginForm.phone=e),placeholder:"电话","prefix-icon":m.Iphone},null,8,["modelValue","prefix-icon"])])),_:1}),(0,a.Wm)(d,null,{default:(0,a.w5)((()=>[(0,a.Wm)(u,{modelValue:i.loginForm.mail,"onUpdate:modelValue":o[4]||(o[4]=e=>i.loginForm.mail=e),placeholder:"邮箱","prefix-icon":m.Message},null,8,["modelValue","prefix-icon"])])),_:1}),(0,a.Wm)(d,null,{default:(0,a.w5)((()=>[(0,a.Wm)(p,{type:"primary",block:"",onClick:m.handle},{default:(0,a.w5)((()=>[(0,a.Uk)("注册")])),_:1},8,["onClick"])])),_:1})])),_:1},8,["model"])])),_:1})])],64)}l(560);var m=l(1120),t=l(9168),u=l(2748),d={name:"Register_mila",computed:{Iphone(){return u.ni$},Unlock(){return u.Slr},User(){return u.n5m},Message(){return u.v0C}},data(){return{loginForm:{username:"",password:"",phone:"",mail:""},confirmPassword:""}},methods:{handle(){""!==this.loginForm.username&&""!==this.loginForm.password&&""!==this.loginForm.phone&&""!==this.loginForm.mail?this.loginForm.password===this.confirmPassword?(t.Z.post("api/Customer/register",this.loginForm).then((e=>{this.$message({message:e.data.msg,type:"0"===e.data.code?"success":"error"}),"0"===e.data.code&&sessionStorage.setItem("user",JSON.stringify(e.data.data))})),m.Z.push("/search")):this.$message({message:"两次密码不相同",type:"warning"}):this.$message({message:"请填写完整信息",type:"warning"})}}},p=l(89);const c=(0,p.Z)(d,[["render",i],["__scopeId","data-v-81258b76"]]);var f=c}}]);
//# sourceMappingURL=510.6bccaaf6.js.map