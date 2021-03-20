import  axios from  'axios'
import qs from 'qs'
export    function getRequest(config){
    const instance1 = axios.create({
        baseURL:'http://127.0.0.1:8888/',
        timeout:5000,
        method:'get',
     })
     return instance1(config);
}

export    function postRequest(config){
    axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    const instance2 = axios.create({
        baseURL:'http://127.0.0.1:8888/',
        timeout:5000,
        method:'post',
      })
     return instance2(config);
}