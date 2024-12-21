import {createRouter, createWebHashHistory} from 'vue-router'

import Login from "../components/Login.vue";
import Regist from "../components/Regist.vue";
import ShowSchedule from "../components/ShowSchedule.vue";

const router = createRouter({
    history: createWebHashHistory(),
    routes: [
        {
            path: "/",
            component: ShowSchedule
        },
        {
            path:"/showSchedule",
            component: ShowSchedule
        },
        {
            path: "/login",
            component: Login
        },
        {
            path: "/regist",
            component: Regist
        }
    ]
})

// 通过路由的全局前置守卫，判断是否可以访问 showSchedule
router.beforeEach((to, from, next) => {
    if (to.path === "/showSchedule") {
        // 登陆了就放行，没有登陆就返回登陆页面
        
    }else {
        next()
    }
})

export default router
