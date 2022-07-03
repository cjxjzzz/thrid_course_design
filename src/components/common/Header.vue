<!-- 头部区域 -->
<template>
  <header>
    <div class="l-content">
      <el-button plain icon="el-icon-menu" size="mini" @click="handleMenu"></el-button>
      <h3 style="color: black">首页</h3>
    </div>
    <div class="r-content">
      <el-dropdown trigger="click" szie="mini">
        <span class="el-dropdown-link">
          <img :src="userImg" alt="" />
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item @click.native="goHome">个人中心</el-dropdown-item>
          <el-dropdown-item @click.native="logout">退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </header>
</template>

<script>
import {logout} from "@/api/user.js"
export default {
  name: "Header",
  data() {
    return {
      userImg:
        "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80",
    };
  },

  components: {},

  computed: {},

  methods: {
    handleMenu(){
      this.$store.commit('collapseMenu')
    },
    goHome(){
      this.$router.push("/");
    },
    // 登出
    async logout(){
      let {data:res} =  await logout();
      if(res){
        this.$router.go(0);
      }
    } 
  },
};
</script>
<style lang='scss' scoped>
header{
  display: flex;
  height: 100%;
  align-items: center;
  justify-content: space-between;
}
.l-content{
  display: flex;
  align-items: center;
  .el-button{
    margin-right: 20px;
  }
}
.r-content {
  img {
    width: 40px;
    border-radius: 10px;
    &:hover{
      cursor: pointer;
    }
  }
}
</style>