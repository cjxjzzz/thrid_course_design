<!-- 点击进入详情页面 -->
<template>
  <view class="detail">
    <view class="title">
      {{ content.title }}
    </view>
    <view class="author">
      <view class="avatar">
        <u-avatar :src="src"></u-avatar>
      </view>
      <view class="authorInfo">
        <view class="name">{{ content.source }}</view>
        <view class="pubDate">{{ content.pubDate }}</view>
      </view>
    </view>
    <view class="content">{{ content.desc }}</view>
    <!-- 假如有图片，那么展示图片 -->
    <view
      class="contentPic"
      v-show="content.havePic"
      v-for="(imageurl, index) in content.imageurls"
      :key="index"
    >
      <!-- {{imageurl.url}} -->
      <img :src="imageurl.url" alt="" />
    </view>
  </view>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      content: {},
      loading: true,
      src: "https://cdn.uviewui.com/uview/album/1.jpg",
      imageurls: [
        "photo1.jpg",
        "photo2.jpg"
      ],
    };
  },
  onLoad(option) {
    console.log("打开了详情页");
    // const eventChannel = this.$scope.eventChannel;
    const eventChannel = this.getOpenerEventChannel();
    // eventChannel.emit("acceptDataFromOpenedPage", {
    //   data: "data from test page",
    // });
    eventChannel.on("goToDetailWithInfo", (data) => {
      console.log(data);
      this.content = data;
    });
  },
  methods: {},
};
</script>
<style lang='less' scoped>
.detail {
  width: 100%;
  padding: 0 25rpx;
  box-sizing: border-box;
  color: #000;
  .title {
    margin: 10rpx 0;
    font-size: 22px;
  }
  .author {
    display: flex;
    .authorInfo {
      display: flex;
      flex-direction: column;
      padding-left: 20rpx;
      .name {
        font-size: 20px;
      }
      .pubDate {
        font-size: 12px;
        color: #333;
      }
    }
  }
  .content {
    line-height: 200%;
  }
}
</style>