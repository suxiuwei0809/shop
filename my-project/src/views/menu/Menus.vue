<template>
  <div class="menus">
<el-row>
   <el-button type="info" @click='addMenu'>新增</el-button>
</el-row>
 

    <el-table
      :data="tableData"
      style="width: 100%">
     
      <el-table-column
        prop="name"
        label="菜单名称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="parentid"
        label="父菜单名称">
      </el-table-column>
       <el-table-column
        prop="path"
        label="请求路径">
      </el-table-column>
       <el-table-column
        prop="sorts"
        label="排序">
      </el-table-column>
      <el-table-column
        prop="module"
        label="模块">
      </el-table-column>
         <el-table-column
        prop="isback"
        label="是否后台">
      </el-table-column>
         <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <!-- <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button> -->
        <el-button   @click="handleDelete(scope.row.id)"   type="danger" icon="el-icon-delete" circle size="small"></el-button>
      </template>
    </el-table-column>
    </el-table>
  
  </div>
</template>

<script>
import Vue from 'vue';
import Element from 'element-ui';
import {getRequest} from '../../network/request'
export default {
  name: 'menus',
  data(){
    return {
        tableData:[]
        }
    },
  
  methods:{
      addMenu(){
      this.$router.push({path: '/menuAdd'})
      },
      getMenus(){
        getRequest('menu/getMenus').then(res=>{
            this.tableData=res.data.data;
        });
      },
      handleDelete(id){
         let config={
          url:'menu/deleteMenu',
          params:{id:id}
        }
        getRequest(config).then(res=>{
              if(res.data.msg){
            this.$message({
              showClose: true,
              message: '恭喜你，这是一条成功消息',
              type: 'success'
            });
             this.getMenus()
          }else{
            this.$message({
              showClose: true,
              message: '错了哦，这是一条错误消息',
              type: 'error'
            });
          }
        });
      }
    },
     created(){
        this.getMenus()
      }
  }
 
 
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
 
</style>
