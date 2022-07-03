<!-- 首页布局 -->
<template>
  <el-container>
    <el-aside width="auto" style="height:100%">
      <Aside />
    </el-aside>
    <el-container>
      <el-header>
        <Header />
      </el-header>
      <el-main style="position: relative;">
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Aside from "@/components/common/Aside"
import Header from "@/components/common/Header"
export default {
  name:'Layout',
  data () {
    return {
    };
  },

  components: {
    Aside,
    Header
  },

  computed: {},

  methods: {}
}

</script>
<style lang='scss' scoped>
.el-header{
  box-shadow: 0 1px 4px rgb(0 21 41 / 8%);
}
.el-main{
  padding-top: 0;
}
</style>