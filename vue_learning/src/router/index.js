import { createRouter, createWebHistory } from 'vue-router'
import store from "@/store";

const routes = [
    {
        path: '/',
        name: 'layout',
        redirect: 'login',
        component: () => import('@/components/Layout.vue'),
        children: [
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
            },
            {
                name: 'bookDetails',
                path: '/bookDetails',
                component: () => import('@/views/BookDetails.vue')
            },
            {
                name: 'managementBook',
                path: '/managementBook',
                component:()=>import('@/views/ManagementBook.vue')
            },
            {
                name: 'addBook',
                path: '/addBook',
                component: ()=>import('@/views/AddBook.vue')
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
]



const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

router.beforeEach((to , from , next) => {
    if(to.fullPath === '/register' || to.fullPath === '/login') {
        next()
    }
    else if(sessionStorage.getItem("user") == null) {
        router.push('/login')
    }
    else if((to.fullPath === '/addBook' || to.fullPath === '/managementBook') && store.state.authority !== "Admin") {
        next(false)
    }
    else {
        if(store.state.isModalVisible === true) {
            next(false)
        }else {
            next()
        }
    }

})

export default router