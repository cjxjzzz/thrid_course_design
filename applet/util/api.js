const baseURL = "http://localhost:8000/"
// 按地理位置获取新闻
export const reqGetNewsByCity = (city,page) => {
  return new Promise((resovle, reject) => {
    uni.request({
      url: baseURL + "news/getInfo", //仅为示例，并非真实接口地址。
      data: {
        city,
        page
      },
      method: "get",
      success: (res) => {
        resovle(res.data);
      }
    });
  })
}

// 讨论区获取信息
export const reqGetDiscussionNewsInfoController = () => {
  return new Promise((resovle, reject) => {
    uni.request({
      url: baseURL + "discussionNewsInfo/getInfo", 
      method: "post",
      success: (res) => {
        resovle(res.data);
      }
    });
  })
}