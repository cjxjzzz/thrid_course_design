<!-- 新闻正文的组件 -->
<template>
  <div class="content">
    <div class="close" @click="close">x</div>
    <div class="title">
      {{ newsInfo.title }}
    </div>
    <div class="desciption">
      {{ newsInfo.description }}
      <div class="images">
        <img
          :src="image"
          alt=""
          v-for="(image, index) in newsInfo.imageUrls"
          :key="index"
        />
      </div>
      <div class="videos">
        <video
          :src="video"
          alt=""
          v-for="(video, index) in newsInfo.videoUrls"
          :key="index"
          controls="controls"
        ></video>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NewsContent",
  data() {
    return {
      newsInfo: {},
    };
  },
  methods: {
    close() {
      console.log("关闭窗口");
      this.$bus.$emit("close");
    },
  },
  mounted() {
    this.$bus.$on("getNewsInfo", (newsInfo) => {
      // 对data进行处理
      console.log(newsInfo);
      newsInfo.imageUrls =
        newsInfo.imageUrls != "" ? newsInfo.imageUrls.split(",") : [];
      newsInfo.videoUrls =
        newsInfo.videoUrls != "" ? newsInfo.videoUrls.split(",") : [];
      newsInfo.likes = newsInfo.likes != "" ? newsInfo.likes.split(",") : [];
      newsInfo.collects =
        newsInfo.collects != "" ? newsInfo.collects.split(",") : [];
      console.log(newsInfo);
      this.newsInfo = newsInfo;
    });
  },
};
</script>
<style lang='scss' scoped>
.content {
  position: absolute;
  z-index: 99;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 500px;
  height: 800px;
  border-radius: 5%;
  background: rgb(222, 220, 220);
  padding: 10px 20px;
  overflow: auto;
  .close {
    position: absolute;
    top: 0;
    right: 30px;
    font-size: 50px;
    cursor: pointer;
  }
  // 修改滚动条样式
  &::-webkit-scrollbar {
    width: 8px;
    /*height: 4px;*/
  }
  // 滚动的滑块
  &::-webkit-scrollbar-thumb {
    border-radius: 10px;
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    background: rgba(0, 0, 0, 0.1);
  }
  &:hover::-webkit-scrollbar-thumb {
    background: rgba(0, 0, 0, 0.4);
  }
  // 外层轨道
  &::-webkit-scrollbar-track {
    box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
    border-radius: 0;
    background: rgba(0, 0, 0, 0.1);
  }
  .title {
    text-align: center;
    font-size: 30px;
  }
  .desciption {
    font-size: 24px;
    .images {
      img {
        width: 300px;
        height: 300px;
      }
    }
    .videos {
      video {
        // width: 300px;
        width: 90%;
        height: 300px;
      }
    }
  }
}
</style>