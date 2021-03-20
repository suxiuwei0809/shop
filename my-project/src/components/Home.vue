<template>

  <div class="name">
    <h1>我是首页</h1>
    <router-link to="/home/news">新闻</router-link>
    <router-link to="/home/message" >消息</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'home',
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 
</style>
