<!-- 讨论区模块 -->
<template>
  <view class="content">
    <view class="nav">
      <view class="search">
        <u--input
          placeholder="请输入内容"
          prefixIcon="search"
          prefixIconStyle="font-size: 22px;color: #909399"
          border="surround"
          clearable
          v-model="value"
          @change="changeInput"
        ></u--input>
        <u-icon
          name="plus"
          color="#909399"
          size="28"
          class="addNews"
          @click="addNewsInfo"
        ></u-icon>
      </view>
    </view>

    <HomeList
      v-for="(content, index) in contentList"
      :key="index"
      :content="content"
    />
  </view>
</template>

<script>
import HomeList from "./children/HomeList/index.vue";
import { reqGetDiscussionNewsInfoController } from "../../util/api.js";
export default {
  name: "Discussion",
  data() {
    return {
      title: "Hello",
      contentList: [
        {
          link: "https://www.chinanews.com.cn/gn/2022/06-02/9769898.shtml",
          imageurls: [],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "efffd8134daa85d7350cafbb60aa8c9d",
          title: "量子光子处理器有多快？36微秒完胜超级计算机逾9000年",
          pubDate: "2022-06-02 10:37:10",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　中新网北京6月2日电 (记者 孙自法)用于量子计算的量子光子处理器最新计算速度能有多快？国际著名学术期刊《自然》发表一篇论文称，研究人员最新研发的一台量子光子处理器，仅需36微秒即可完成超级计算机需耗时超过9000年才能完成的一项任务。",
        },
        {
          link: "https://www.chinanews.com.cn/gj/2022/06-02/9769913.shtml",
          imageurls: [],
          channelName: "国际最新",
          source: "中国新闻网",
          id: "a3c2a69cd9361dbb416fa699738c0ab1",
          title: "美国解除飞往古巴航班限制",
          pubDate: "2022-06-02 10:34:54",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001de",
          desc: "　　海外网6月2日电 据路透社报道，当地时间1日，美国交通部宣布，解除针对飞往古巴航班的一系列限制。不过，由于目前美国航班行程已满、航空人员紧缺，尚不清楚将恢复多少飞往古巴的航班。",
        },
        {
          img: "http://i2.chinanews.com.cn/simg/ypt/2022/220602/52058312-da4f-4ffa-bdb9-501eb414d9fa_zsite.jpg",
          link: "https://www.chinanews.com.cn/sh/2022/06-02/9769905.shtml",
          imageurls: [
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220602/52058312-da4f-4ffa-bdb9-501eb414d9fa_zsite.jpg",
              height: 0,
            },
          ],
          channelName: "社会最新",
          source: "中国新闻网",
          id: "3c999d4537c1f916b4d3c725d9a55608",
          title: "《自然》论文：模拟组织柔软传感器可实时监测大脑肠道神经递质",
          pubDate: "2022-06-02 10:33:56",
          havePic: true,
          channelId: "5572a10bb3cdc86cf39001f8",
          desc: "　　中新网北京6月2日电 (记者 孙自法)国际著名学术期刊《自然》最新发表一篇材料科学论文，研究人员描述了一种模拟组织的柔软传感器，可用于实时监测大脑与肠道的神经递质。通过研究小鼠的肠道-大脑交流已表明这种传感器的能力，或有望实现其他身体柔软器官的生物分子传感。",
        },
      ],
      value: "", // 用户输入的内容
      timer: null, // 防抖的定时器
    };
  },
  components: {
    HomeList,
  },
  onLoad() {
    reqGetDiscussionNewsInfoController().then((res) => {
      console.log(res);
    });
    this.init();
  },
  methods: {
    async init() {
      // let result = await reqGetNewsByCity();
      // if(result.code === 200){
      //   this.contentList = result.data.showapi_res_body.pagebean.contentlist;
      // }
      // console.log(result);
    },
    // 输入框更改之后调用
    changeInput(e) {
      // 使用防抖的方式发送网络请求
      if (this.timer) clearTimeout(this.timer);
      this.timer = setTimeout(() => {
        console.log("change", e);
        // 发送网络请求
      }, 1000);
    },
    // 添加新闻
    addNewsInfo() {
      // 跳转到添加新闻的界面
      uni.navigateTo({
        url: "/pages/Discussion/children/AddNews/index",
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
          // res.eventChannel.emit("goToDetailWithInfo", this.content);
        },
      });
      uni.navigateBack({
        delta: 1,
        animationType: "pop-out",
        animationDuration: 200,
      });
    },
  },
  onPullDownRefresh() {
    console.log("刷新");
  },
  onReachBottom() {
    console.log("页面到底部");
  },
};
</script>
<style lang='less' scoped>
.content {
  display: flex;
  flex-direction: column;
  width: 100%;
  box-sizing: border-box;
  padding: 0 20rpx;
  .nav {
    width: 100%;
    .search {
      display: flex;
      .icon-search {
        font-size: 10px;
        color: #333;
      }
    }
  }
  /* align-items: center; */
  /* justify-content: center; */
}

.logo {
  height: 200rpx;
  width: 200rpx;
  margin-top: 200rpx;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 50rpx;
}

.text-area {
  display: flex;
  justify-content: center;
}

.title {
  font-size: 36rpx;
  color: #8f8f94;
}
</style>