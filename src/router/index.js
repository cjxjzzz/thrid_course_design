import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store/index.js'

import Layout from "@/layout/Layout"
import Login from "@/page/Login/Login"

Vue.use(VueRouter)

// 路由配置
const routes = [{
  path: "/",
  name: "Layout",
  component: Layout,
  redirect: "/home",
  children: [{
    path: "/home",
    name: "Home",
    component: () => import("@/page/Home/Home")
  }, {
    path: "/news",
    name: "Bews",
    component: () => import("@/page/News/index")
  }]
}, {
  path: "/login",
  name: "Login",
  component: Login
}]

const router = new VueRouter({
  mode: "history",
  routes
})

// // 前置守卫
// // 判断用户登录的状态
// router.beforeEach(async (to, from, next) => {
  
//   // 如果to.fullpath && from.fullpath != '/login' 则代表刷新了页面 需要先去后端取session域中的数据
//   // 当用户刷新页面的时候 我们去请求后台的session域中保存好的Admin
//   // 获取登录状态
//   if (!(store.getters.getAdmin.length > 0) && to.fullPath != "/login" && from.fullPath != "/login") {
//     // 没有登录，则去请求session
//     let {
//       data: res
//     } = await login();
//     if (res.length > 0) {
//       store.commit("setAdmin", res[0]);
//       // 用户访问无权利的网站
//       if (to.fullPath == "/mall" || to.fullPath == "/user") {
//         // 进行判断用户是否能够跳转
//         if (!(store.getters.getAdmin.business === "管理员")) {
//           next("/error");
//         }
//       }
//       next();
//       return;
//     }
//   }

//   if (to.fullPath != "/login") {
//     // 进行判断用户是否登录了
//     if (!(store.getters.getAdmin.length > 0)) {
//       // 没有登录，则修改跳转的页面到login
//       next("/login");
//     }
//   }

//   next();
// })

// 解决重复跳转问题
const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(to) {
  return VueRouterPush.call(this, to).catch(err => err)
}

export default router;