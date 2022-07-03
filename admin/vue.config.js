const path = require('path'); //引入path模块
function resolve(dir) {
    return path.join(__dirname, dir) //path.join(__dirname)设置绝对路径
}


module.exports = {

    devServer: {
        port: 8000, // 端口
    },
    lintOnSave: false, // 取消 eslint 验证

    // 配置别名
    configureWebpack: {
        resolve: {
            alias: {
                'api': '@/api',
                'assets': '@/assets',
                'common': '@/common',
                'components': '@/components',
                'network': '@/network',
                'store': '@/store',
                'layout':'@/layout',
                'page': '@/page',
                'upload':'@/upload',
            }
        }
    }
}