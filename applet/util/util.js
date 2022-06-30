// 防抖 点击多次只算一次 后面的点击都会取消前面
export function debounce(fn, delay) {
  let timer = null;
  return function () {
    // 获取传递的参数
    let args = Array.prototype.slice.call(arguments);
    if (timer) clearTimeout(timer)
    timer = setTimeout(() => {
      fn.call(this, ...args)
    }, delay)
  }
}
// 节流 多次点击也只会在定时器范围内触发
export function throttle(fn, delay) {
  let timer = null;
  let flag = false;
  return function () {
    if (flag) return;
    flag = true;
    // 获取参数
    let args = Array.prototype.slice.call(arguments);
    clearTimeout(timer);
    timer = setTimeout(() => {
      fn.call(this, args);
      flag = false;
    }, delay)
  }
}