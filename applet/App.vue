<script>
export default {
  onLaunch: function () {
    console.log("App Launch");
  },
  onShow: function () {
    console.log("App Show");
  },
  onHide: function () {
    console.log("App Hide");
  },
};
</script>

<style lang="scss">
@import "@/uni_modules/uview-ui/index.scss";
@import "@/static/css/iconfont.css";
/*每个页面公共css */
*{
	margin: 0;
	padding: 0;
}
</style>
