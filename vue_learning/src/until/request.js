import axios from "axios";
import router from "@/router";

const request = axios.create({
    timeout:5000
})

// request 拦截器
request.interceptors.request.use(config => {
    if(!config.headers) config.headers['Content-Type'] ='application/json;charset=utf-8'

    let userJson = sessionStorage.getItem("user")
    if(!userJson) {
        router.push("/login")
    }
    return config
},error => {
    return Promise.reject(error)
})

export default request

