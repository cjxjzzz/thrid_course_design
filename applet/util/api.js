const baseURL = "http://localhost:8000/"
// 按地理位置获取新闻
export const reqGetNewsByCity = (city) => {
  return new Promise((resovle, reject) => {
    uni.request({
      url: baseURL + "news/getInfo", //仅为示例，并非真实接口地址。
      data: {
        city
      },
      method: "get",
      success: (res) => {
        resovle(res.data);
      }
    });
  })
}