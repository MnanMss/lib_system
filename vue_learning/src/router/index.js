import { createRouter, createWebHistory } from 'vue-router'

const routes = [
    {
        path: '/',
        name: 'layout',
        redirect: 'login',
        component: () => import('@/components/Layout.vue'),
        children: [
            {
                path: '/home',
                name: 'home',
                component: ()=> import('@/views/Home.vue')
            },
            {
                name: 'element',
                path: '/element',
                component: ()=> import('@/components/element.vue')
            },
            {
                name: 'search',
                path: '/search',
                component: ()=> import('@/views/Search.vue')
            },
            {
                name: 'rend',
                path: '/rend',
                component: () => import('@/views/Rend.vue')
            },
            {
                name: 'bookList',
                path: '/bookList',
                component: ()=> import('@/views/BookList.vue')
            }
        ],
    },
    {
        path: '/login',
        name: 'login',
        component: ()=> import('@/views/Login.vue')
    },
    {
        path: '/register',
        name: 'register',
        component: ()=>import('@/views/Register.vue')
    }
    // path: '/',
    //
    // children:[
    // {
    //     path: '/login',
    //     name: 'Login',
    //     component: ()=>import('@/views/Login.vue')
    // },
    // {
    //     path: '/element',
    //     name: 'element',
    //     component: ()=> import('@/components/element.vue')
    // },
    // {
    //     path: '/register',
    //     name: 'register',
    //     component: ()=> import('@/views/Register.vue')
    // },
    // {
    //     path: '/home',
    //     name: 'home',
    //     component: () => import('@/views/Home.vue')
    // }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router