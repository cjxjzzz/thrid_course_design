<!-- home的list -->
<template>
  <view class="homeList" @click="goToDetail">
    <view class="left">
      <view class="title">{{ content.title }}</view>
      <view class="date">
        {{ content.source }}
        {{ content.pubDate | formateDate }}
      </view>
    </view>
    <view class="right" v-show="content.img">
      <img :src="content.img" alt="" />
    </view>
    <!-- <u-icon name="level"></u-icon> -->
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
      console.log("进入详情页");
      uni.navigateTo({
        url: "/pages/Discussion/children/DetaiList/index",
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
.homeList {
  position: relative;
  display: flex;
  justify-content: center;
  width: 100%;
  border-bottom: 5rpx solid rgb(212, 210, 210);
  // background: pink;
  box-sizing: border-box;
  .left {
    flex: 2;
    .title {
      padding: 20rpx 0 40rpx;
      color: #000;
    }
    .date {
      position: absolute;
      bottom: 0;
      left: 10rpx;
      font-size: 10px;
      color: #333;
    }
  }
  .right {
    flex: 1;
    line-height: 100%;
    img {
      width: 300rpx;
      height: 200rpx;
    }
  }
}
</style>