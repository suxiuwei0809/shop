<template>
  <div id="app">
      <div>
    <el-container>
      <el-aside width="200px"><el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
      
         <menu_tree></menu_tree>
  
      <el-menu-item index="4">
        <i class="el-icon-setting"></i>
         
        <span slot="title"> <router-link to="/menus">菜单设置</router-link></span>
      </el-menu-item>
    </el-menu>
    </el-aside>
      <el-container>
        <el-header><el-menu
  :default-active="activeIndex2"
  class="el-menu-demo"
  mode="horizontal"
  @select="handleSelect"
  background-color="#545c64"
  text-color="#fff"
  active-text-color="#ffd04b">
  <el-menu-item index="1">处理中心</el-menu-item>
  <el-submenu index="2">
    <template slot="title">我的工作台</template>
    <el-menu-item index="2-1">选项1</el-menu-item>
    <el-menu-item index="2-2">选项2</el-menu-item>
    <el-menu-item index="2-3">选项3</el-menu-item>
    <el-submenu index="2-4">
      <template slot="title">选项4</template>
      <el-menu-item index="2-4-1">选项1</el-menu-item>
      <el-menu-item index="2-4-2">选项2</el-menu-item>
      <el-menu-item index="2-4-3">选项3</el-menu-item>
    </el-submenu>
  </el-submenu>
  <el-menu-item index="3" disabled>消息中心</el-menu-item>
  <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item>
</el-menu>
</el-header>
<el-main>
  <div id="main">
           <router-view></router-view>
    </div>
</el-main>
      </el-container>
    </el-container>
  </div>
  </div>
 
</template>

<script>
import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import MenuTree  from  './components/MenuTree'
Vue.use(ElementUI);
export default {
  name: 'App' ,
  components:{
    menu_tree:MenuTree
  },
   data() {
      return {
        activeIndex: '1',
        activeIndex2: '1'
      };
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
     
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
   
    }
}
</script>

<style>
#app {
  width: 100%;
  height: 500px;
}
</style>
 

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .el-menu{
    height: 100%;
  }
   .el-header{
    padding: 0;
  }
 .el-main{
    height: 600px;
      background-color: rgb(84, 92, 100);
 }
 
</style>
