import Vue from 'vue'
import store from '@/store/index'
import App from './App.vue'
import axios from 'axios'
import router from './router'

// 引入基础css
import '@/assets/css/base.css'
import {
  Button,
  Select,
  Radio,
  Form,
  Container,
  Aside,
  Header,
  Main,
  Menu,
  MenuItem,
  MenuItemGroup,
  Submenu,
  Dropdown,
  DropdownMenu,
  DropdownItem,
  Card,
  Row,
  Col,
  Table,
  TableColumn,
  Pagination,
  Popover,
  Tag,
  Input,
  Message,
  Popconfirm,
  Option,
  Upload,
  FormItem,
  Carousel,
  CarouselItem,
  MessageBox
} from 'element-ui'


Vue.use(Button);
Vue.use(Select);
Vue.use(Radio);
Vue.use(Form);
Vue.use(Container);
Vue.use(Aside);
Vue.use(Header);
Vue.use(Main);
Vue.use(Menu);
Vue.use(MenuItem);
Vue.use(MenuItemGroup);
Vue.use(Submenu);
Vue.use(Dropdown);
Vue.use(DropdownMenu);
Vue.use(DropdownItem);
Vue.use(Card);
Vue.use(Row);
Vue.use(Col);
Vue.use(Table);
Vue.use(TableColumn);
Vue.use(Pagination);
Vue.use(Popover);
Vue.use(Tag);
Vue.use(Input);
Vue.use(Popconfirm);
Vue.use(Option);
Vue.use(Upload);
Vue.use(FormItem);
Vue.use(Carousel);
Vue.use(CarouselItem);


Vue.config.productionTip = false

// 允许跨域携带参数
axios.defaults.withCredentials = true;

Vue.prototype.$message = Message   //vue实例上挂载Message  
Vue.prototype.$http = axios;
Vue.prototype.$msgbox = MessageBox;
Vue.prototype.$alert = MessageBox.alert;
Vue.prototype.$prompt = MessageBox.prompt;

new Vue({
  render: h => h(App),
  store,
  router,
  // 配置全局事件总线
  beforeCreate(){
    Vue.prototype.$bus = this
  },
}).$mount('#app')