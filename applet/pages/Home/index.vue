<template>
  <view class="content">
    <!-- <HomeList /> -->
    <HomeList
      v-for="(content, index) in contentList"
      :key="index"
      :content="content"
    />
  </view>
</template>

<script>
import HomeList from "./children/HomeList/index.vue";
import { reqGetNewsByCity } from "../../util/api.js";
export default {
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
        {
          link: "https://www.chinanews.com.cn/gj/2022/06-02/9769909.shtml",
          imageurls: [],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "596564f70d93d20b748a05e559c9914f",
          title: "墨西哥耗资98亿美元项目“玛雅列车”因影响环境被叫停",
          pubDate: "2022-06-02 10:32:52",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　全长1500公里、耗资98亿美元！墨西哥“玛雅列车”影响环境被叫停",
        },
        {
          img: "http://i2.chinanews.com.cn/simg/ypt/2022/220602/0ec60db1-4425-474c-b6e6-0ac5d41e439b.jpg",
          link: "https://www.chinanews.com.cn/cj/2022/06-02/9769880.shtml",
          imageurls: [
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220602/0ec60db1-4425-474c-b6e6-0ac5d41e439b.jpg",
              height: 0,
            },
          ],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "34af9eea69de7eab7c6eade25942cab7",
          title: "1500万客户使用！平安臻享RUN三大尖刀服务打造“三省”体验",
          pubDate: "2022-06-02 10:32:06",
          havePic: true,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　为充分发挥保险保障作用，满足客户健康管理需求，打造有温度的保险，助力健康中国建设，平安人寿持续依托平安臻享RUN健康服务计划(以下简称平安臻享RUN)，以专职医生和专业健康账户为基础，重点打造门诊预约协助及陪诊、控糖管理、重疾专案管理三大尖刀服务，持续提供覆盖健康、慢病、医疗三方面的专业健康管理服务，为客户打造省心、省时、省钱的一站式健康臻享体验。据悉，平安臻享RUN推出以来已服务1500万客户，客户满意度高达98%。",
        },
        {
          link: "https://www.chinanews.com.cn/cul/2022/06-02/9769872.shtml",
          imageurls: [],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "5e377fb4ceea3be94387766020149b31",
          title: "湖南拥有国家级非遗代表性项目137个 激发非遗市场活力",
          pubDate: "2022-06-02 10:31:26",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　中新网长沙6月2日电(向一鹏)6月1日晚，2022年“文化和自然遗产日”湖南省非物质文化遗产宣传展示主场活动暨第三届湖南非遗购物节在雨花非遗馆启动。记者从现场获悉，截至目前，湖南共有国家级代表性项目137个、省级代表性项目410个、非遗工坊166家，数量和市场化程度等指标均高于全国平均水平。",
        },
        {
          img: "http://news.youth.cn/gn/202206/./W020220602378891730436.jpg",
          link: "http://news.youth.cn/gn/202206/t20220602_13741711.htm",
          imageurls: [
            {
              width: 0,
              url: "http://news.youth.cn/gn/202206/./W020220602378891730436.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "http://news.youth.cn/gn/202206/./W020220602378894469004.jpg",
              height: 0,
            },
          ],
          channelName: "国内焦点",
          source: "央视新闻客户端",
          id: "2bb8f69730a64b44cbce8726522ac900",
          title: "雅安芦山县6.1级地震：受地震影响的铁路已恢复正常运行",
          pubDate: "2022-06-02 10:31:00",
          havePic: true,
          channelId: "5572a108b3cdc86cf39001cd",
        },
        {
          link: "https://www.chinanews.com.cn/dwq/2022/06-02/9769853.shtml",
          imageurls: [],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "981a0f0a511ab933b70d21d55830e542",
          title: "区嘉宏：国家强盛让香港特区护照享负盛名 便利港人出行",
          pubDate: "2022-06-02 10:29:06",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　中新网6月2日电 据香港文汇网报道，香港作为国际大都会，与世界各地紧密连接，市民亦热爱出外旅游，自由行尤其盛行。香港入境事务处处长区嘉宏日前接受访问，分享辖下“协助在外香港居民小组”的工作和深刻体会，并介绍香港回归后特区护照的演变和展望。",
        },
        {
          link: "https://www.chinanews.com.cn/gj/2022/06-02/9769902.shtml",
          imageurls: [],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "33c2d677d97a8d9bbacf16fc17249a24",
          title: "联合国报告：去年东亚东南亚共缉获10亿片“冰毒”",
          pubDate: "2022-06-02 10:28:40",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　联合国报告：去年东亚东南亚共缉获10亿片“冰毒”，是10年前7倍",
        },
        {
          link: "https://www.chinanews.com.cn/sh/2022/06-02/9769901.shtml",
          imageurls: [],
          channelName: "社会最新",
          source: "中国新闻网",
          id: "1618ed130615ed52cb9229d379f8cf3e",
          title: "一路向北 追逐丰收——夏收版图北扩时",
          pubDate: "2022-06-02 10:28:12",
          havePic: false,
          channelId: "5572a10bb3cdc86cf39001f8",
          desc: "　　新华全媒+｜一路向北 追逐丰收——夏收版图北扩时",
        },
        {
          link: "https://edu.sina.com.cn/gaokao/2022-06-02/doc-imizirau6158193.shtml",
          imageurls: [],
          channelName: "教育最新",
          source: "新浪网",
          id: "e47eaccdb3494b1adb48847ab32fab3d",
          title: "2021高考生物真题及参考答案（海南卷）",
          pubDate: "2022-06-02 10:28:00",
          channelId: "5572a10ab3cdc86cf39001ef",
          havePic: false,
        },
        {
          link: "https://www.chinanews.com.cn/life/2022/06-02/9769895.shtml",
          imageurls: [],
          channelName: "社会最新",
          source: "中国新闻网",
          id: "f8736a9f66febba3775200ab82b586bd",
          title: "广州：不得用楼盘名命名地铁站",
          pubDate: "2022-06-02 10:27:16",
          havePic: false,
          channelId: "5572a10bb3cdc86cf39001f8",
          desc: "　　不得用楼盘名命名地铁站",
        },
        {
          link: "https://www.chinanews.com.cn/cul/2022/06-02/9769897.shtml",
          imageurls: [],
          channelName: "社会最新",
          source: "中国新闻网",
          id: "a085af517a05d757129bb1e9ab55e600",
          title: "论古建筑的保护之道",
          pubDate: "2022-06-02 10:26:56",
          havePic: false,
          channelId: "5572a10bb3cdc86cf39001f8",
          desc: "　　古建保护的日本之道",
        },
        {
          link: "https://www.chinanews.com.cn/gj/2022/06-02/9769896.shtml",
          imageurls: [],
          channelName: "国际最新",
          source: "中国新闻网",
          id: "b6185723690692cae76736fe25a30731",
          title: "乌波两国计划成立合资企业生产武器装备",
          pubDate: "2022-06-02 10:25:39",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001de",
          desc: "　　新华社基辅6月1日电 据乌克兰政府网站1日报道，乌克兰和波兰两国计划成立合资企业生产武器装备。",
        },
        {
          link: "https://www.chinanews.com.cn/cj/2022/06-02/9769893.shtml",
          imageurls: [],
          channelName: "财经最新",
          source: "中国新闻网",
          id: "1e355c26ea08eb905a9df2bc5e4a0eb7",
          title: "超1600亿元！运输服务已成我国第一大服务贸易领域",
          pubDate: "2022-06-02 10:24:05",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001e0",
          desc: "　　央视网消息：数据显示，4月份我国运输服务进出口额超1600亿元，运输服务已经成为我国第一大服务贸易领域，面对全球新冠肺炎疫情的冲击，我国高效稳定的运输物流网络为保障全球产业链供应链稳定作出了重要贡献。",
        },
        {
          link: "https://www.chinanews.com.cn/sh/2022/06-02/9769892.shtml",
          imageurls: [],
          channelName: "社会最新",
          source: "中国新闻网",
          id: "3a744a37018a3e56d7ec623a4d5d8d1c",
          title: "四川芦山妥善安置受灾群众 全力防范次生灾害",
          pubDate: "2022-06-02 10:24:05",
          havePic: false,
          channelId: "5572a10bb3cdc86cf39001f8",
          desc: "　　昨天(1日)下午5点，四川雅安市芦山县发生6.1级地震，震源深度17千米。下午5点03分，雅安市宝兴县发生4.5级地震，震源深度18千米。地震发生后，国务院抗震救灾指挥部办公室、应急管理部立即启动国家地震应急Ⅲ级响应，派出工作组赴现场指导处置，调派国家综合性消防救援力量赶赴震区。",
        },
        {
          link: "https://www.chinanews.com.cn/sh/2022/06-02/9769891.shtml",
          imageurls: [],
          channelName: "社会最新",
          source: "中国新闻网",
          id: "60f21155780d9056a4412dc801cd82d2",
          title: "四川雅安芦山6.1级地震已致4人遇难41人受伤",
          pubDate: "2022-06-02 10:23:29",
          havePic: false,
          channelId: "5572a10bb3cdc86cf39001f8",
          desc: "　　中新网雅安6月2日电 (单鹏)四川省雅安市人民政府2日在雅安市芦山县举行新闻发布会通报雅安“6.1”芦山地震受灾、救援和安置情况。雅安市副市长龚兵在新闻发布会上透露，截至6月2日9时，地震已造成雅安市4人遇难，41人受伤。其中，宝兴遇难4人，受伤30人；芦山受伤11人。受伤人员均已送往医院救治，其中1人伤情危重，目前暂未脱离生命危险；2人重伤，目前生命体征平稳；其余38名受伤人员为轻伤，无生命危险。目前雅安其他区县未接到人员伤亡报告。(完)",
        },
        {
          img: "https://img1.gamersky.com/upimg/pic/2022/06/02/small_202206021022177150.jpg",
          link: "https://www.gamersky.com/news/202206/1487735.shtml",
          imageurls: [
            {
              width: 0,
              url: "https://img1.gamersky.com/upimg/pic/2022/06/02/small_202206021022177150.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "https://img1.gamersky.com/upimg/pic/2022/06/02/small_202206021022097017.png",
              height: 0,
            },
          ],
          channelName: "游戏最新",
          source: "游民星空",
          id: "6de8a5e715830f6253621b1665df5dfb",
          title: "最后机会！任亏券6月5日停售 《宝可梦朱紫》开放兑换",
          pubDate: "2022-06-02 10:23:00",
          havePic: true,
          channelId: "5572a10ab3cdc86cf39001ee",
        },
        {
          img: "http://img5.mtime.cn/mg/2022/06/02/095206.11498976.jpg",
          link: "http://content.mtime.com/article/228886120",
          imageurls: [
            {
              width: 0,
              url: "http://img5.mtime.cn/mg/2022/06/02/095206.11498976.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "http://img5.mtime.cn/mg/2022/06/02/100020.77445100.jpg",
              height: 0,
            },
          ],
          channelName: "电影最新",
          source: "时光网",
          id: "48e4490fc0d45c31523d7cc7c9d708ac",
          title: "华纳影业高层大调整 或成立DC影业",
          pubDate: "2022-06-02 10:22:00",
          havePic: true,
          channelId: "5572a10ab3cdc86cf39001ed",
        },
        {
          link: "https://www.chinanews.com.cn/hr/2022/06-02/9769888.shtml",
          imageurls: [],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "4702b23133d94d6b3d5b851b7d8c0e15",
          title: "纽约交通局拟将华埠宰也街打造为行人专用广场",
          pubDate: "2022-06-02 10:21:45",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　中新网6月2日电 据美国《世界日报》报道，美国纽约曼哈顿华埠宰也街(Doyers St.)每年夏天都会邀请艺术家彩绘路面，并实施时段封街来吸引人流以促进当地消费，成效卓越。据了解，市交通局(DOT)拟将该条街封街项目永久化，除询问小商家意见，将于6月7日(周二)在曼哈顿第三社区委员会提出，把宰也街改为行人专用的“宰也街广场”(Doyers St. Plaza)。",
        },
      ],
    };
  },
  components: {
    HomeList,
  },
  onLoad() {
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
  },
  onPullDownRefresh(){
    console.log("刷新");
  },
  onReachBottom(){
    console.log("页面到底部");
  },
};
</script>

<style>
.content {
  display: flex;
  flex-direction: column;
  width: 100%;
  box-sizing: border-box;
  padding: 0 20rpx;
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
