<template>
  <view class="content">
    <!-- <HomeList /> -->
    <!-- 页面加载动画 -->
    <!-- <u-loading-page :loading1="loadingPage" loading-text="loading..."></u-loading-page> -->
    <!-- 数据刷新加载动画 -->
    <u-loading-icon text="加载中" textSize="18" :show="loadingPage"></u-loading-icon>
    <!-- 首页 -->
    <view class="home" v-show="!loadingPage">
      <!-- 首页标题 -->
      <view class="title">
        <span class="title-hour">7x24小时</span>
        实时直播
        <span class="title-live">LIVE</span>
        <pg-actionsheet
          :show="actionSheet.show"
          :tips="actionSheet.tips"
          :item-list="actionSheet.itemList"
          :mask-closable="actionSheet.maskClosable"
          :color="actionSheet.color"
          :size="actionSheet.size"
          :is-cancel="actionSheet.isCancel"
          @click="onActionSheetItemClick"
          @cancel="closeActionSheet"
        >
        </pg-actionsheet>
        <p @click="actionSheet.show = true">当前位置：{{ addrDel }}</p>
      </view>
      <HomeList
        v-for="(content, index) in contentList"
        :key="index"
        :content="content"
      />
      <!-- 加载更多的动画 -->
      <u-loading-icon v-show="isLoading" :text="loadingText"></u-loading-icon>
    </view>
  </view>
</template>

<script>
import HomeList from "./children/HomeList/index.vue";
import { reqGetNewsByCity } from "../../util/api.js";
import amap from "../../util/amap-wx.130";
import actionSheet from "../../components/pg-actionsheet/index.vue";
export default {
  data() {
    return {
      // title: "Hello",
      contentList: [
        {
          img: "https://inews.gtimg.com/newsapp_bt/0/15041673155/1000",
          link: "https://new.qq.com/omn/20220626/20220626A05J2Q00.html",
          imageurls: [
            {
              width: 0,
              url: "https://inews.gtimg.com/newsapp_bt/0/15041673155/1000",
              height: 0,
            },
            {
              width: 0,
              url: "https://inews.gtimg.com/newsapp_bt/0/15041673751/1000",
              height: 0,
            },
            {
              width: 0,
              url: "https://inews.gtimg.com/newsapp_bt/0/15041675370/1000",
              height: 0,
            },
          ],
          channelName: "育儿最新",
          source: "腾讯网",
          id: "03c29f376612a5d63592a15ee23f6422",
          title:
            "重庆天佑儿童医院何旭涛医生科普：导致孩子患上自闭症的先天因素有哪些呢？",
          pubDate: "2022-06-26 17:26:43",
          havePic: true,
          channelId: "61b6c3e26de57a0ac09d7e07",
        },
        {
          img: "https://inews.gtimg.com/newsapp_bt/0/15041667185/1000",
          link: "https://new.qq.com/omn/20220626/20220626A05I5P00.html",
          imageurls: [
            {
              width: 0,
              url: "https://inews.gtimg.com/newsapp_bt/0/15041667185/1000",
              height: 0,
            },
            {
              width: 0,
              url: "https://inews.gtimg.com/newsapp_bt/0/15041668097/1000",
              height: 0,
            },
          ],
          channelName: "育儿最新",
          source: "腾讯网",
          id: "9e67e0fc4aa43a9ea154d5ba7deca6c7",
          title:
            "重庆天佑儿童医院何旭涛医生：孩子患上自闭症这些环境因素不可忽视",
          pubDate: "2022-06-26 17:24:02",
          havePic: true,
          channelId: "61b6c3e26de57a0ac09d7e07",
        },
        {
          img: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/98b4598f-1cab-48a8-a251-b0255bc32777_zsite.jpg",
          link: "https://www.chinanews.com.cn/tp/2022/06-25/9788775.shtml",
          imageurls: [
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/98b4598f-1cab-48a8-a251-b0255bc32777_zsite.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/9ab817ab-49d9-459e-a983-d9b73f866572_zsite.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/64bc67f9-11fa-407d-a620-dd2b275c62e1_zsite.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/1ce5b275-daf4-47cb-89d3-49fc526e6fac_zsite.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/69539ac6-32dd-4da9-9e00-2eb7f3fc5cba_zsite.jpg",
              height: 0,
            },
          ],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "07148e195271e1bfe131de6048588826",
          title: "2022中国西部美食大师赛正式开赛",
          pubDate: "2022-06-25 21:44:54",
          havePic: true,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "参赛选手制作的精美菜肴。　于晶 摄\r\n\n裁判正在品尝参赛选手制作美食。　于晶 摄\r\n\n参赛选手正在制作美食。　于晶 摄\r\n\n参赛选手正在制作美食。　于晶 摄\r\n\n参赛选手制作的精美菜肴吸引民众观看。　于晶 摄\r\n\n　　为进一步弘扬西部美食文化，推动地方美食烹饪技艺交流传承，促进餐饮业高质量发展，6月25日，2022中国西部美食大师赛在宁夏吴忠正式开赛。据悉，本次大赛旨在挖掘西部特色美食，弘扬西部美食文化，交流创新烹饪技艺，推动餐饮发展、提振消费信心。来自重庆、甘肃、陕西、四川、宁夏等5个省市区的50名选手现场开展烹饪技艺，共同带来一场西部特色的美食盛宴。",
        },
        {
          img: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/1ae17764-5f3e-4bcf-8ad5-bd16c71b61f9_zsite.jpg",
          link: "https://www.chinanews.com.cn/tp/2022/06-25/9788770.shtml",
          imageurls: [
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/1ae17764-5f3e-4bcf-8ad5-bd16c71b61f9_zsite.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/779a89b4-3490-4cfe-a75a-3658b174cb64_zsite.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/ff974faf-da05-45f9-8229-db2fddcb7693_zsite.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/171579c0-be84-47ef-bdf2-8c5900526483_zsite.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/a59528ca-7e04-41db-afa8-72807a7d2bd4_zsite.jpg",
              height: 0,
            },
          ],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "4dd7a72f0402218ea3f8cf1c2eba2a8c",
          title: "川渝拳击交流赛开打 8名职业拳手上演精彩对决",
          pubDate: "2022-06-25 21:44:36",
          havePic: true,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "图为重庆拳手罗文森对阵四川拳手宋宁圆。　肖江川 摄\r\n\n图为重庆拳手罗文森对阵四川拳手宋宁圆。　肖江川 摄\r\n\n图为重庆拳手罗文森对阵四川拳手宋宁圆。　肖江川 摄\r\n\n图为重庆拳手罗文森对阵四川拳手宋宁圆。　肖江川 摄\r\n\n图为重庆拳手罗文森经过4回合大战，最终战胜了四川拳手宋宁圆。　肖江川 摄\r\n\n　　6月25日，2022年川渝拳击交流赛在千年古镇重庆磁器口拉开帷幕，来自重庆和四川的8名职业拳手上演了四场精彩对决。",
        },
        {
          img: "https://n.sinaimg.cn/sports/transform/145/w539h406/20220625/d737-e8832b77cb07bc947143ad9e833ddce0.png",
          link: "https://sports.sina.com.cn/china/j/2022-06-25/doc-imizirav0529072.shtml",
          imageurls: [
            {
              width: 0,
              url: "https://n.sinaimg.cn/sports/transform/145/w539h406/20220625/d737-e8832b77cb07bc947143ad9e833ddce0.png",
              height: 0,
            },
          ],
          channelName: "国内足球最新",
          source: "新浪网",
          id: "61cd3dd1f52b2f9eaaa3fdcb8e4bc79a",
          title: "媒体人谈重庆队重组：很多欧洲破产豪门都是如此",
          pubDate: "2022-06-25 20:49:00",
          channelId: "5572a10ab3cdc86cf39001e8",
          havePic: true,
        },
        {
          link: "https://www.chinanews.com.cn/tp/2022/06-25/9788696.shtml",
          imageurls: [],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "c8dfac40979e692ba080b9ac618f4828",
          title: "“火炉”重庆气温超35℃ 民众戏水纳凉",
          pubDate: "2022-06-25 20:14:44",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "市民玩水享清凉。　杨孝永 摄\r\n\n市民玩水享清凉。　杨孝永 摄\r\n\n市民玩水享清凉。　杨孝永 摄\r\n\n市民玩水享清凉。　杨孝永 摄\r\n\n　　6月25日，重庆涪陵，众多市民在涪陵红酒小镇水上乐园内戏水纳凉。当日，重庆大部分地区的最高气温已经超过35℃。",
        },
        {
          img: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/88393b5a-18ec-4936-a6ee-b4206ca4f814_zsite.JPG",
          link: "https://www.chinanews.com.cn/tp/2022/06-25/9788601.shtml",
          imageurls: [
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/88393b5a-18ec-4936-a6ee-b4206ca4f814_zsite.JPG",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/26287b45-1519-4088-afab-dcf59d4913a9_zsite.JPG",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/094c15e3-cc95-475c-9605-28183a297006_zsite.JPG",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/030680f4-89d1-4ed3-9cb7-ab7710bef5a8_zsite.JPG",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/5a006ccb-74fe-43d0-8afc-8ba422a505e7_zsite.JPG",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/26116881-32a1-444e-9793-cb6f63e8f78e_zsite.JPG",
              height: 0,
            },
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/b4c8cc3d-03a2-415e-872d-49da11b6e120_zsite.JPG",
              height: 0,
            },
          ],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "039e55c6803f4b95c34ac5dffeec4d30",
          title: "重庆国际汽车展览会启幕：新能源汽车受热捧",
          pubDate: "2022-06-25 18:36:17",
          havePic: true,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "车展吸引不少市民前来观看。　陈超 摄\r\n\n车展上的模特摆出各种造型。　陈超 摄\r\n\n车展吸引不少市民前来观看。　陈超 摄\r\n\n美女通过网络直播为自己的粉丝介绍各类车型。　陈超 摄\r\n\n新能源汽车吸引顾客。　陈超 摄\r\n\n车展吸引不少市民前来观看。　陈超 摄\r\n\n新能源汽车吸引不少市民前来了解。　陈超 摄\r\n\n　　6月25日，第二十四届重庆国际汽车展览会在重庆国际博览中心启幕。展会现场，各品牌的新能源汽车特别受民众关注。",
        },
        {
          link: "https://www.chinanews.com.cn/cj/2022/06-25/9788550.shtml",
          imageurls: [],
          channelName: "财经最新",
          source: "中国新闻网",
          id: "96f516ada989ff829d07df3434ccb9b0",
          title: "布局新基建 重庆推动绿色建材产业高质量发展",
          pubDate: "2022-06-25 16:13:46",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001e0",
          desc: "　　中新网重庆6月25日电 (梁钦卿)走进重庆永川区的东鹏智能家居生产基地，所有瓷砖生产线都选用建陶行业先进的智能制造系统，云计算与物联网实时交互，自动化设备互联互通……智能制造的投入，使东鹏永川基地的人均产出效率提升30%至50%。",
        },
        {
          link: "https://www.chinanews.com.cn/gn/2022/06-25/9788541.shtml",
          imageurls: [],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "f34e1bdfa4353809556242096b6f36f1",
          title: "治理耕地酸化 水稻增产8%以上",
          pubDate: "2022-06-25 15:54:04",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　央视网消息：重庆现有耕地面积2805万亩，一部分耕地酸化严重。为此，当地探索出了一套改良土地质量的办法，来提高耕地质量。",
        },
        {
          img: "https://nimg.ws.126.net/?url=http%3A%2F%2Fcms-bucket.ws.126.net%2F2022%2F0625%2F8cd5e6d7j00re0w2k002cc000ku00dwc.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
          link: "https://www.163.com/sports/article/HANHG60600059ADR.html",
          imageurls: [
            {
              width: 0,
              url: "https://nimg.ws.126.net/?url=http%3A%2F%2Fcms-bucket.ws.126.net%2F2022%2F0625%2F8cd5e6d7j00re0w2k002cc000ku00dwc.jpg&thumbnail=660x2147483647&quality=80&type=jpg",
              height: 0,
            },
            {
              width: 0,
              url: "https://static.ws.126.net/163/f2e/product/post_nodejs/static/logo.png",
              height: 0,
            },
          ],
          channelName: "国内足球最新",
          source: "网易",
          id: "7a3b8877d28c13347c95df94e8dda606",
          title: "重庆两江竞技解散后两江集团成立新俱乐部 打中 ",
          pubDate: "2022-06-25 15:44:00",
          havePic: true,
          channelId: "5572a10ab3cdc86cf39001e8",
        },
        {
          img: "https://inews.gtimg.com/newsapp_bt/0/15026809909/1000",
          link: "https://new.qq.com/omn/20220625/20220625A054GX00.html",
          imageurls: [
            {
              width: 0,
              url: "https://inews.gtimg.com/newsapp_bt/0/15026809909/1000",
              height: 0,
            },
            {
              width: 0,
              url: "https://inews.gtimg.com/newsapp_bt/0/10353299979/1000",
              height: 0,
            },
            {
              width: 0,
              url: "https://inews.gtimg.com/newsapp_bt/0/10845889049/1000",
              height: 0,
            },
          ],
          channelName: "育儿最新",
          source: "腾讯网",
          id: "6da74f65a63ea70aec770c6d42ea2bee",
          title: "重庆语言障碍训练：语言发育迟缓会对孩子造成哪些影响？",
          pubDate: "2022-06-25 15:15:57",
          havePic: true,
          channelId: "61b6c3e26de57a0ac09d7e07",
        },
        {
          img: "https://n.sinaimg.cn/sports/transform/281/w650h431/20220625/72f0-02130ad728082cae6832f59618a3a3af.jpg",
          link: "https://sports.sina.com.cn/china/j/2022-06-25/doc-imizmscu8678710.shtml",
          imageurls: [
            {
              width: 0,
              url: "https://n.sinaimg.cn/sports/transform/281/w650h431/20220625/72f0-02130ad728082cae6832f59618a3a3af.jpg",
              height: 0,
            },
          ],
          channelName: "国内足球最新",
          source: "新浪网",
          id: "8f9d5c8c6443dafed6b3f86713d9314d",
          title: "重庆两江队在龙兴重生？确有其事 力争四年内冲超",
          pubDate: "2022-06-25 14:40:00",
          channelId: "5572a10ab3cdc86cf39001e8",
          havePic: true,
        },
        {
          img: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/ca7a8aa4-353e-43dc-a61b-d5ef74f47931_zsite.jpeg",
          link: "https://www.chinanews.com.cn/sh/2022/06-25/9788442.shtml",
          imageurls: [
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/ca7a8aa4-353e-43dc-a61b-d5ef74f47931_zsite.jpeg",
              height: 0,
            },
          ],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "dedea9448ccf9af594fb8a609009bced",
          title: "重庆最繁忙轨道交通线路再“扩编”",
          pubDate: "2022-06-25 12:24:55",
          havePic: true,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　中新网重庆6月25日电 (张旭)25日，重庆单轨3号线鱼洞—江北机场T2航站楼实现8编组列车贯通运营，实现“6(编组列车)改8(编组列车)”，便利民众出行。",
        },
        {
          img: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/dfd5a4d9-fd07-4e1c-b046-72b16f35682f_zsite.jpg",
          link: "https://www.chinanews.com.cn/cj/2022/06-25/9788409.shtml",
          imageurls: [
            {
              width: 0,
              url: "http://i2.chinanews.com.cn/simg/ypt/2022/220625/dfd5a4d9-fd07-4e1c-b046-72b16f35682f_zsite.jpg",
              height: 0,
            },
          ],
          channelName: "财经最新",
          source: "中国新闻网",
          id: "158676eeea4b177129af622ee4eac167",
          title: "重庆 “南岸惠购节”启动 近百项惠民活动助力消费市场回暖",
          pubDate: "2022-06-25 11:57:19",
          havePic: true,
          channelId: "5572a109b3cdc86cf39001e0",
          desc: "　　中新网重庆6月25日电 (记者 何蓬磊)为打通“内循环”，加快消费市场回暖，促进经济增长，24日晚，由重庆市商务委员会、南岸区人民政府主办的2022南岸城市惠购节(以下简称“南岸惠购节”)在重庆南岸区南坪商圈启动。",
        },
        {
          img: "https://inews.gtimg.com/newsapp_bt/0/13059881819/1000",
          link: "https://new.qq.com/omn/20220625/20220625A02TG900.html",
          imageurls: [
            {
              width: 0,
              url: "https://inews.gtimg.com/newsapp_bt/0/13059881819/1000",
              height: 0,
            },
            {
              width: 0,
              url: "https://inews.gtimg.com/newsapp_bt/0/7652043781/1000",
              height: 0,
            },
            {
              width: 0,
              url: "https://inews.gtimg.com/newsapp_bt/0/15030672764/1000",
              height: 0,
            },
          ],
          channelName: "育儿最新",
          source: "腾讯网",
          id: "638f39efd20d2c7cec46d8ed539231a4",
          title: "重庆矮小症治疗：生长激素需要治疗多久？",
          pubDate: "2022-06-25 10:55:39",
          havePic: true,
          channelId: "61b6c3e26de57a0ac09d7e07",
        },
        {
          link: "https://www.chinanews.com.cn/sh/2022/06-25/9788387.shtml",
          imageurls: [],
          channelName: "社会最新",
          source: "中国新闻网",
          id: "bdbf0345b8d9c4a4cf1d17994c75709e",
          title: "中国气象局启动暴雨四级应急响应",
          pubDate: "2022-06-25 10:44:20",
          havePic: false,
          channelId: "5572a10bb3cdc86cf39001f8",
          desc: "　　中国气象网讯#8194;来自中国气象局应急办消息，鉴于6月25日夜间至28日，四川盆地至华北、黄淮、东北地区中南部一带将出现一次区域性强降雨过程。经综合研判和应急会商，局领导于6月25日10时签发命令，中国气象局办公室、减灾司、预报司、观测司，气象中心、气候中心、卫星中心、信息中心、数值预报中心、探测中心、公共服务中心、人影中心、宣传科普中心(报社)、华风集团立即进入四级应急响应状态。四川、重庆、湖北、河南、陕西、山东、北京、天津、河北、辽宁、吉林及可能受影响的省级气象局根据实际研判启动或调整相应级别应急响应。各单位要严格按照气象灾害应急响应工作流程做好各项工作，加强值班值守，滚动做好强降雨及强对流天气监测预报预警，有重要情况及时报告中国气象局。",
        },
        {
          link: "https://www.chinanews.com.cn/sh/2022/06-25/9788332.shtml",
          imageurls: [],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "139de97ccbb79777162cb887d865a3b6",
          title: "31省份新增本土确诊病例7例、本土无症状感染者15例",
          pubDate: "2022-06-25 09:09:40",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　中新网6月25日电 据国家卫健委网站消息，6月24日0—24时，31个省(自治区、直辖市)和新疆生产建设兵团报告新增确诊病例53例。其中境外输入病例46例(广东9例，上海5例，福建5例，云南5例，陕西5例，四川4例，北京3例，江苏3例，浙江2例，江西2例，天津1例，湖南1例，重庆1例)，含8例由无症状感染者转为确诊病例(广东2例，四川2例，陕西2例，浙江1例，湖南1例)；本土病例7例(广东5例，北京2例)，含1例由无症状感染者转为确诊病例(在广东)。无新增死亡病例。无新增疑似病例。",
        },
        {
          img: "https://n.sinaimg.cn/edu/crawl/778/w550h1028/20220625/a211-b65b1328a58dd376c01b2f747d26c302.jpg",
          link: "https://edu.sina.com.cn/gaokao/2022-06-25/doc-imizmscu8627476.shtml",
          imageurls: [
            {
              width: 0,
              url: "https://n.sinaimg.cn/edu/crawl/778/w550h1028/20220625/a211-b65b1328a58dd376c01b2f747d26c302.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "https://n.sinaimg.cn/edu/crawl/546/w550h796/20220625/e697-f210e4af6949a5a7df1ae6b630f97686.jpg",
              height: 0,
            },
            {
              width: 0,
              url: "https://n.sinaimg.cn/edu/crawl/117/w550h367/20220625/665c-8f42cf9665606ac76f650c9ff7e6daac.jpg",
              height: 0,
            },
          ],
          channelName: "教育最新",
          source: "新浪网",
          id: "fc054265ec7da70094877f940fbaf2f2",
          title: "重庆考生：今夏最幸福的“烦恼”--查不到高考分数",
          pubDate: "2022-06-25 08:02:00",
          channelId: "5572a10ab3cdc86cf39001ef",
          havePic: true,
        },
        {
          link: "https://www.chinanews.com.cn/sh/2022/06-24/9788093.shtml",
          imageurls: [],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "da008dd92cdede5584765a202f394e6b",
          title: "重庆警方破获非法经营“笑气”新型毒品案 查获“笑气”1300余升",
          pubDate: "2022-06-24 22:33:24",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　中新网重庆6月24日电 (记者 刘相琳)记者24日从重庆市公安局获悉，重庆渝北警方近日破获一起涉嫌非法经营“笑气”新型毒品案，抓获犯罪嫌疑人10人，现场查获尚未贩卖的“笑气”61罐、1300余升。该案是重庆侦破的首例非法经营“笑气”案件。",
        },
        {
          link: "https://www.chinanews.com.cn/gn/2022/06-24/9788064.shtml",
          imageurls: [],
          channelName: "国内最新",
          source: "中国新闻网",
          id: "f58df375d7a7aeba3f5bc444cefe97fb",
          title: "重庆“云上”招人成效初显 累计14万个就业岗位做客直播招聘",
          pubDate: "2022-06-24 22:14:29",
          havePic: false,
          channelId: "5572a109b3cdc86cf39001db",
          desc: "　　中新网重庆6月24日电 (记者 钟旖)“直播求职的优点就一个字，快！直接和HR沟通，回复及时，既人性化又有温度。”24岁的秦雪寒近日入职小康动力有限公司工作，与此前在线下投简历常常“石沉大海”不同，这次求职她通过“重庆英才·职等您来”网络直播招聘，五天不到就完成了面试流程，“效率比线下招聘快很多”。",
        },
      ],
      addrDel: "北京", // 当前地理位置 默认是北京
      page: 1,
      loadingPage: true, // 进入页面的加载动画
      isLoading: false, // 底部加载更多的动画
      loadingText: "正在加载更多",
      title: "标题",
      addrList: [],
      addr: [
        "北京市",
        "天津市",
        "上海市",
        "重庆市",
        "河北省",
        "河南省",
        "云南省",
        "辽宁省",
        "黑龙江省",
        "湖南省",
        "安徽省",
        "山东省",
        "新疆省",
        "江苏省",
        "浙江省",
        "江西省",
        "湖北省",
        "广西省",
        "甘肃省",
        "山西省",
        "内蒙古省",
        "陕西省",
        "吉林省",
        "福建省",
        "贵州省",
        "广东省",
        "青海省",
        "西藏省",
        "四川省",
        "宁夏省",
        "海南省",
        "台湾省",
        "香港特别行政区",
        "澳门特别行政区",
      ],
      actionSheet: {
        show: false,
        maskClosable: true,
        tips: "",
        itemList: [
          { text: "复制", color: "#1a1a1a" },
          { text: "删除", color: "#1a1a1a" },
        ],
        color: "#9a9a9a",
        size: 26,
        isCancel: true,
      }
    };
  },
  components: {
    HomeList,
    "pg-actionsheet": actionSheet,
  },
  onLoad() {
    // 初始化
    this.init();
  },
  methods: {
    init() {
      // 获取当前的地理位置 根据地理位置来获取当地的实时新闻
      this.getLocation().then(
        async (res) => {
          console.log(res);
          // 市级
          this.addrDel = res[0].regeocodeData.addressComponent.province;
          // 修改 修改地理位置的时的数组addrList
          this.addr.forEach((item) => {
            this.addrList.push({
              text: item,
              color: "#1a1a1a",
            });
          });
          this.actionSheet.itemList = this.addrList;
          // 区级
          // this.addrDel = res[0].regeocodeData.addressComponent.district;
          console.log(this.addrDel);
          // 根据获取到的地理位置来获取对应的实时新闻
          // let result = await reqGetNewsByCity(this.addrDel,this.page);
          // console.log(result);
          // if (result.code === 200) {
          //   this.contentList = result.data.showapi_res_body.pagebean.contentlist;
          //   // 当数据获取完成后
          //   this.$nextTick(()=>{
          //     // 将数据渲染到dom上之后显示
              this.loadingPage = false;
          //   })
          // }
        },
        () => {
          uni.showToast({
            title: "获取地址失败，将导致部分功能不可用",
            icon: "none",
          });
        }
      );
    },
    // 获取当前位置的地理位置
    getLocation() {
      return new Promise((resovle, reject) => {
        const amapObject = new amap.AMapWX({
          key: "8db69a1b7cdc7c3064309f764bec7120",
        });
        amapObject.getRegeo({
          success: (res) => {
            // resovle(res);
            // res[0].regeocodeData.addressComponent.province = "abc";
            resovle(res);
          },
          fail: (err) => {
            reject(err);
          },
        });
      });
    },
    // 获取当前的地理位置相关的新闻信息
    getNewsInfoByCity() {
      return new Promise((resovle,reject)=>{
        reqGetNewsByCity(this.addrDel, this.page).then(
        (res) => {
          if (res.code === 200) {
            this.contentList = res.data.showapi_res_body.pagebean.contentlist;
          }
          resovle("信息获取成功!");
        },
        (err) => {
          reject("信息获取失败!");
        }
      );
      })
    },
    onActionSheetItemClick(index) {
      // console.log(this.addr[index.index]);
      this.addrDel = this.addr[index.index];
        // 关闭选择框
      this.actionSheet.show = false;
      // 开启刷新动画
      this.loadingPage = true;
      // 重新获取当前选择地理位置的新闻信息
      this.getNewsInfoByCity().then(res=>{
      console.log(res);
      // 关闭刷新动画
      this.loadingPage = false;
    },err=>{
      console.log(err);
      // 关闭刷新动画
      this.loadingPage = false;
    })
    },
    closeActionSheet() {
      // 关闭选择框
      this.actionSheet.show = false;
    },
  },
  onPullDownRefresh() {
    // 重新获取新闻列表
    // 首先将page修改为1
    this.page = 1;
    this.loadingText = "正在加载更多";
    // 然后获取最新的信息
    this.getNewsInfoByCity().then(res=>{
      console.log(res);
      uni.stopPullDownRefresh();
    },err=>{
      console.log(err);
      uni.stopPullDownRefresh();
    })
  },
  onReachBottom() {
    this.page++;
    this.isLoading = true;
    // 获取信息
    reqGetNewsByCity(this.addrDel, this.page).then(
      (res) => {
        if (res.code === 200) {
          // 将获取到的信息直接push到信息列表中
          let result = res.data.showapi_res_body.pagebean.contentlist;
          if (result.length <= 0) {
            this.loadingText = "已经到底部";
          }
          this.contentList.push(...result);
        }
        console.log("加载完成");
        this.isLoading = false;
      },
      (err) => {
        console.log(err);
        console.log("加载失败");
        this.isLoading = false;
      }
    );
    console.log("页面到底部");
  },
};
</script>

<style lang="less" scoped>
.title {
  width: 100%;
  padding-bottom: 10rpx;
  margin-bottom: 50rpx;
  font-size: 32px;
  .title-hour {
    color: #d02618;
  }
  .title-live {
    display: inline-block;
    margin-left: 5px;
    background: #d02618;
    color: #fff;
    padding: 2px 6px;
    font-size: 12px;
  }
}
.content {
  width: 100%;
  box-sizing: border-box;
  padding-left: 100rpx;
  padding-top: 50rpx;
}
</style>