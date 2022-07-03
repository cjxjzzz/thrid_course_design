// 引入axios封装的发送请求
import requests from "./request";

const baseURL = "http://localhost:8000/"

// 获取新闻的接口
export const getDiscussionNewsInfo = () => {
  return requests({
    url: baseURL + "discussionNewsInfo/getInfo",
    method: "get"
  })
}

// 同意新闻的接口
export const agreeDiscussionNewsInfo = (id) => {
  return requests({
    url: baseURL + "discussionNewsInfo/agreeInfo",
    params: {
      id
    },
    method: "post"
  })
}

// 拒绝 填写理由的接口
export const rejectDiscussionNewsInfo = (id, dealWithInformation) => {
  return requests({
    url: baseURL + "discussionNewsInfo/rejectInfo",
    params: {
      id,
      dealWithInformation
    },
    method: "post"
  })
}