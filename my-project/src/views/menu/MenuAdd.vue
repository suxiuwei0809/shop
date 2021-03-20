<template>
  <div class="menuAdd">
   <el-form ref="form" :model="form" label-width="80px" :rules="rules">
     <el-row>
  <el-col :span="5">
      <el-form-item label="菜单名称"  prop="name">
      <el-input v-model="form.name"></el-input> </el-form-item>
  </el-col>
  <el-col :span="5">
    <el-form-item label="父id"  prop="parentid">
    <el-input v-model="form.parentid"></el-input>
  </el-form-item>
  </el-col>
   <el-col :span="5">
    <el-form-item label="路径"  prop="path">
    <el-input v-model="form.path"></el-input>
  </el-form-item>
   </el-col>
    <el-col :span="5">
    <el-form-item label="排序">
    <el-input v-model="form.sorts"></el-input>
    </el-form-item>
    </el-col>
    </el-row>
     <el-row>
        <el-col :span="5">
      <el-form-item label="模块">
    <el-input v-model="form.module"></el-input>
      
  </el-form-item>
        </el-col>
  <el-col :span="5">
      <el-form-item label="是否后台"  prop="isback">
    <el-input v-model="form.isback"></el-input>
  </el-form-item>
   </el-col>
     </el-row>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">立即创建</el-button>
    <el-button>取消</el-button>
  </el-form-item>
</el-form>
  </div>
</template>

<script>
import qs from 'qs'
import  {postRequest,getRequest} from '../../network/request'
 export default {
    data() {
      return {
        rules:{
          name:[ { required: true, message: '名称不能为空'},],
          parentid:[ { required: true, message: '父id不能为空'},],
          path:[ { required: true, message: '路径不能为空'},],
          
          isback:[ { required: true, message: '不能为空'},],
           sorts:[ { type: Number, message: '数字'},],
        }
     
      ,
        form: {
          name: '',
          parentid: '',
          path: '',
          sorts: '',
          module: '',
          isback: '' 
        }
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
        let config={
          url:'menu/saveMenu',
          data:qs.stringify(this.form)
        }
    //    config.data=qs.stringify(this.form)
        postRequest(config).then(res=>{
          console.log(res);
          if(res.data.msg){
            this.$message({
              showClose: true,
              message: '恭喜你，这是一条成功消息',
              type: 'success'
            });
             this.$router.push({path: '/menus'})
          }else{
            this.$message({
              showClose: true,
              message: '错了哦，这是一条错误消息',
              type: 'error'
            });
          }
        });
        // let  config={
        //   url:'goods/queryBanner',
        //   params:{}
        // }
        // getRequest(config).then(res=>{
        //   console.log(res)
        // })
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style>
 .el-form-item__label{color:white}
 .el-radio__label{color:white}
 .el-checkbox__label{color:white}
 .el-col{color:white}
</style>
