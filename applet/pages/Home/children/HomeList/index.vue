<!-- home的list -->
<template>
  <view>
    <view class="line"></view>
    <view class="homeList" @click="goToDetail">
      <img src="/static/blue.png" alt="" class="round" />
      <view class="pubDate">{{ content.pubDate }}</view>
      <view class="description" v-if="content.desc">
        {{content.desc}}
      </view>
      <view class="title" v-else>
        {{content.title}}
      </view>
    </view>
  </view>
</template>

<script>
export default {
  name: "HomeList",
  data() {
    return {};
  },
  onLoad() {},
  methods: {
    // 进入详情页面
    goToDetail() {
      // console.log("进入详情页");
      uni.navigateTo({
        url: "/pages/Home/children/DetaiList/index",
        animationType: "pop-in",
        animationDuration: 200,
        events: {
          // 为指定事件添加一个监听器，获取被打开页面传送到当前页面的数据
          // acceptDataFromOpenedPage: function (data) {
          //   console.log(data);
          // },
        },
        success: (res) => {
          // 通过eventChannel向被打开页面传送数据
          res.eventChannel.emit("goToDetailWithInfo", this.content);
        },
      });
      uni.navigateBack({
        delta: 1,
        animationType: "pop-out",
        animationDuration: 200,
      });
    },
  },
  filters: {
    // 对时间进行格式化处理
    formateDate(time) {
      time = new Date(time);
      let nowTime = new Date();
      let formateTime = nowTime.getTime() - time.getTime();
      let hour = (formateTime / 1000 / 60 / 60) % 24; // 当前新闻发布的小时数量
      let day = formateTime / 1000 / 60 / 60 / 24; // 当前新闻发布的天数数量
      let month = formateTime / 1000 / 60 / 60 / 24 / 30; // 当前新闻发布的月数数量
      let year = formateTime / 1000 / 60 / 60 / 24 / 365; // 当前新闻发布的年数数量
      if (day < 1) {
        return `${Number.parseInt(hour)}小时前`;
      } else if (month < 1) {
        return `${Number.parseInt(day)}天前`;
      } else if (year < 1) {
        return `${Number.parseInt(month)}月前`;
      } else {
        return `${Number.parseInt(year)}年前`;
      }
    },
  },
  props: ["content"],
};
</script>
<style lang='less' scoped>
.line {
  border-bottom: 1px solid #eaeaea;
}
.homeList {
  position: relative;
  width: 100%;
  margin-top: -30rpx;
  border: 1px solid #eaeaea;
  border-bottom: none;
  border-top: none;
  .round {
    position: absolute;
    top: 10rpx;
    left: -20rpx;
    width: 40rpx;
    height: 40rpx;
  }

  .pubDate {
    position: absolute;
    width: 95%;
    padding: 20rpx 0;
    left: 5%;
    top: 0rpx;
    color: #004a94;
    font-size: 18px;
    font-weight: bolder;
    background: #f0f0f0;
  }

  .description,
  .title {
    width: 100%;
    height: 100%;
    box-sizing: border-box;
    padding: 100rpx 5% 60rpx;
    line-height: 200%;
    white-space: pre-wrap; // 设置\n换行
  }
}
</style>