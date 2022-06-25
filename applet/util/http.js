export function myAjax({url,method,data}) {
  return new Promise((resovle, reject) => {
    const xhr = new XMLHttpRequest();
    xhr.responseType = "json";
    // 将data改为字符串形式
    let sendData = "";
    for (const key in data) {
      if (Object.hasOwnProperty.call(data, key)) {
        sendData += `${key}=${data[key]}&`;
      }
    }
    // 去掉最后一个&符号
    sendData = sendData.slice(0, sendData.length - 1);
    // get请求
    if (method == "get") {
      xhr.open("get", url + "?" + sendData);
      xhr.send();
    } else if (method == "post") {
      xhr.open("post", url);
      xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
      xhr.send(sendData);
    }
    xhr.onreadystatechange = function () {
      if (xhr.readyState === 4) {
        if (xhr.status >= 200 && xhr.status < 300) {
          resovle(xhr.response);
        }
      }
    }
  });
}