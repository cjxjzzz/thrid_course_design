import Vue from 'vue'
import Vuex from 'vuex'
import tab from './tab'

Vue.use(Vuex)

const store =  new Vuex.Store({
  state: {
    admin: {}
  },
  mutations: {
    setAdmin(state, value) {
      state.admin = value;
    }
  },
  getters: {
    getAdmin(state) {
      return state.admin;
    }
  },
  modules:{
    tab
  }
})

export default store;