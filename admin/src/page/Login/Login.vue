<!-- 登录页面 -->
<template>
  <div id="login_page">
    <h2>品优购后台管理系统</h2>
    <img src="@/assets/img/login_bg.jpg" alt="" />
    <div class="login">
      <section>
        <el-form
          :model="loginUser"
          :rules="rules"
          class="loginForm"
          ref="loginForm"
          label-width="80px"
        >
          <el-form-item label="用户名" prop="username">
            <el-input
              class="inp"
              v-model="loginUser.username"
              placeholder="请输入用户名"
              ref="username"
            ></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input
              class="inp"
              v-model="loginUser.password"
              placeholder="请输入密码"
              type="password"
              show-password
            ></el-input>
          </el-form-item>
          <el-form-item>
            <div id="v_container" style="width: 200px; height: 50px"></div>
          </el-form-item>
          <el-form-item label="验证码" prop="checkCode" class="checkCode">
            <el-input
              type="text"
              id="code_input"
              v-model="loginUser.checkCode"
              class="inp"
              placeholder="请输入验证码"
              autocomplete="off"
              ref="code"
            ></el-input>
            <div class="code_error" ref="code_error">验证码错误！</div>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('loginForm')"
              >登录</el-button
            >
          </el-form-item>
        </el-form>
      </section>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import QS from "qs";

import "./js/checkCode";
let verifyCode;
export default {
  name: "Login",
  data() {
    return {
      loginUser: {
        username: "",
        code: "",
        password: "",
      },
      // 在return 后面；
      rules: {
        // 要以数组形式展示
        username: [
          {
            required: true,
            message: "请输入正确的用户名",
            trigger: "blur",
          },
        ],
        password: [
          { required: true, message: "密码不能为空", trigger: "blur" },
          {
            min: 1,
            max: 30,
            message: "长度在 1 到 30 个字符",
            trigger: "blur",
          },
        ],
        checkCode: [
          {
            required: true,
            min: 5,
            max: 5,
            message: "请输入正确的验证码",
            trigger: "blur",
          },
        ],
      },
    };
  },
  mounted() {
    // 生成验证码
    verifyCode = new GVerify("v_container");
  },
  methods: {
    // 提交表单
    submitForm(formName) {
      this.$refs.code_error.style.display = "none";
      this.$refs[formName].validate(async (valid) => {
        // 判断验证码是否正确
        if (valid) {
          if (this.checkCode()) {
            if(this.loginUser.username === "cjxjzzz" && this.loginUser.password === "root"){
              this.$store.commit("setAdmin", {
                username:"cjxjzzz",
                password:"root"
              });
              // console.log(this.$store.getters.getUser);
              this.$router.replace("/");
            }
            // if (res.length != 0) {
            //   // 登录成功，跳转到上一个页面
            //   // console.log(res);
            //   // 讲返回的登录对象保存到vuex当中
            //   this.$store.commit("setAdmin", res);
            //   // console.log(this.$store.getters.getUser);
            //   this.$router.replace("/");
            // } else {
            //   // console.log("登录失败！");
            //   this.$refs.login_error.style.display = "block";
            // }
          } else {
            this.$refs.code_error.style.display = "block";
          }
        } else {
          // console.log("error submit!!");
          return false;
        }
      });
    },
    // 验证验证码
    checkCode() {
      let res = verifyCode.validate(
        document.getElementById("code_input").value
      );
      if (res) {
        return true;
      } else {
        return false;
      }
    },
    // 跳转到注册页面
    goRegister() {
      this.$router.push("/register");
    },
  },
};
</script>
<style lang='scss' scoped>
$backgroudColor: #e9e9eb;
#login_page {
  position: relative;
  h2 {
    position: absolute;
    width: 500px;
    top: 200px;
    left: 200px;
    text-align: center;
    color: $backgroudColor;
    font-size: 100px;
    user-select: none;
  }
  img {
    position: fixed;
    width: 100%;
    height: 100%;
    z-index: -1;
  }
  .login {
    position: absolute;
    top: 130px;
    right: 180px;
    width: 400px;
    height: 450px;
    background: $backgroudColor;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  }
  section {
    padding: 80px 50px 50px 20px;
  }
}

.code_error {
  display: none;
  color: #f56c6c;
  font-size: 12px;
  line-height: 1;
  padding-top: 4px;
  position: absolute;
  top: 100%;
  left: 0;
}
</style>