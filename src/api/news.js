import axios from './axios'
import QS from 'qs'

const baseURL = "http://localhost:8080/"

/**
 * 获取商品类型
 * @returns 
 */
export const getGoodsType = () =>{
  return axios.request({
    url:baseURL + "goods/goodsType",
    method:"get"
  })
}

/**
 * 上传商品
 * @param {*} form 
 * @returns 
 */
export const uploadGoods = (form) =>{
  return axios.request({
    url:baseURL + "admin/uploadGoods",
    method:"post",
    data:QS.stringify(form)
  })
}