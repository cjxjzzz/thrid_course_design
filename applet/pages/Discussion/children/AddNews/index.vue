<!-- 添加新闻的组件 -->
<template>
  <view class="addNewsInfo">
    <!-- 注意，如果需要兼容微信小程序，最好通过setRules方法设置rules规则 -->
    <u--form labelPosition="left" :model="newsInfo" :rules="rules" ref="form1">
      <u-form-item label="新闻标题" prop="userInfo.title" borderBottom ref="item1">
        <u--input v-model="newsInfo.userInfo.title" border="none"></u--input>
      </u-form-item>
      <u-form-item label="姓名" prop="userInfo.name" borderBottom ref="item1">
        <u--input v-model="newsInfo.userInfo.name" border="none"></u--input>
      </u-form-item>
      <u-form-item
        label="性别"
        prop="userInfo.sex"
        borderBottom
        @click="
          showSex = true;
          hideKeyboard();
        "
        ref="item1"
      >
        <u--input
          v-model="newsInfo.userInfo.sex"
          disabled
          disabledColor="#ffffff"
          placeholder="请选择性别"
          border="none"
        ></u--input>
        <u-icon slot="right" name="arrow-right"></u-icon>
      </u-form-item>
    </u--form>
    <u-action-sheet
      :show="showSex"
      :actions="actions"
      title="请选择性别"
      description="如果选择保密会报错"
      @close="showSex = false"
      @select="sexSelect"
    >
    </u-action-sheet>
  </view>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      showSex: false,
			newsInfo: {
				userInfo: {
          title:"",
					name: 'uView UI',
					sex: '',
				},
			},
			actions: [{
				name: '男',
				},
				{
					name: '女',
				},
				{
					name: '保密',
				},
			],
			rules: {
				'userInfo.name': {
					type: 'string',
					required: true,
					message: '请填写姓名',
					trigger: ['blur', 'change']
				},
				'userInfo.sex': {
					type: 'string',
					max: 1,
					required: true,
					message: '请选择男或女',
					trigger: ['blur', 'change']
				},
			},
			radio: '',
			switchVal: false
    };
  },
  onLoad() {},
  methods: {
    sexSelect(e) {
			this.newsInfo.userInfo.sex = e.name
			this.$refs.form1.validateField('userInfo.sex')
		},
  },
};
</script>
<style lang='less' scoped>
.addNewsInfo{
  width: 100%;
  box-sizing: border-box;
  padding: 0 20rpx;
}
</style>