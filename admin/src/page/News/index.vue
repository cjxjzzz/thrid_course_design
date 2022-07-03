<!-- 首页 -->
<template>
  <div class="newsInfo">
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="creator" label="创建者" width="180">
      </el-table-column>
      <el-table-column prop="title" label="新闻标题" width="180">
      </el-table-column>
      <el-table-column label="新闻正文">
        <template slot-scope="scope">
          <el-button type="primary" @click="open(scope.row)">查看</el-button>
          <!-- {{ scope.row.description }} -->
        </template>
      </el-table-column>
      <el-table-column prop="pubDate" label="上传时间"> </el-table-column>
      <el-table-column prop="status" label="状态"> </el-table-column>
      <el-table-column prop="dealWithInformation" label="处理">
        <template slot-scope="scope">
          <el-button type="primary" @click="update(scope.row)">下架</el-button>
          <!-- {{ scope.row.description }} -->
        </template>
      </el-table-column>
    </el-table>
    <NewsContent v-show="show" />
  </div>
</template>

<script>
import {
  getDiscussionNewsInfo,
  agreeDiscussionNewsInfo,
  rejectDiscussionNewsInfo,
} from "@/api/user";
import NewsContent from "./children/NewsContent.vue";
export default {
  name: "Home",
  data() {
    return {
      tableData: [],
      show: false,
      newsInfo: {},
    };
  },
  components: { NewsContent },

  computed: {},

  methods: {
    async init() {
      let result = await getDiscussionNewsInfo();
      if (result.code === 200) {
        // 过滤掉已经通过审核的新闻
        let arrList = result.data.filter((item) => {
          // 修改pubDate的格式
          item.pubDate = `${item.pubDate.split("T")[0]} ${
            item.pubDate.split("T")[1]
          }`;
          // return item.status === "审核中";
          return true;
        });
        this.tableData = arrList;
        console.log(arrList);
      }
    },
    open(index) {
      this.show = true;
      this.$bus.$emit("getNewsInfo", index);
    },
    update(index) {
      console.log(index);
      this.$prompt("请输入理由", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
      })
        .then(({ value }) => {
          // console.log(value);
          rejectDiscussionNewsInfo(index.id, value).then((res) => {
            console.log(res);
            this.init();
          });
        })
        .catch(() => {});
    },
  },

  mounted() {
    this.init();
    this.$bus.$on("close", () => {
      this.show = false;
    });
  },
};
</script>