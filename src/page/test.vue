<!--  -->
<template>
  <div></div>
</template>

<script>
import { goodsBuy } from "@/api/buy";
export default {
  name: "test",
  data() {
    return {};
  },

  created() {
    this.init();
  },

  components: {},

  computed: {},

  methods: {
    init() {
      goodsBuy("华为官方旗舰店").then((res) => {
        console.log(res);
      });
    },
  },
};
</script>
<style lang='scss' scoped>
</style>