import { createStore } from 'vuex'


export default createStore({
    state() {
        return {
            isModalVisible: false,
            authority: "Customer"
        }
    },
    mutations: {
        setIsModalVisible(state , newValue) {
            state.isModalVisible = newValue
        },
        setAuthority(state , newValue) {
            state.authority = newValue
        }
    }
})