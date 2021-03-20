
<template>
<diV>
    <el-input
    placeholder="输入关键字进行过滤"
    v-model="filterText">
    </el-input>
    <el-tree class="filter-tree" :data="treeData"
    :props="defaultProps"
    default-expand-all
    :filter-node-method="filterNode"
    ref="tree">
    </el-tree>
</diV>

</template>
 
<script>
import  Vue from 'vue'
import  VueRouter  from  'vue-router'
import { getRequest } from '../network/request';
import  path from 'path'
 Vue.use(VueRouter) 
 Vue.use(path) 

  export default {
     data() {
      return {
         rootObj:{},
         memusData:[],
          treeData:[],
        filterText: '',
        defaultProps: {
          children: 'children',
          label: 'name'
        }
      };
    },
    watch: {
      filterText(val) {
        this.$refs.tree.filter(val);
      }
    },
    created(){
        this.getMenuTree()
    },
    methods: {
      filterNode(value, data) {
        if (!value) return true;
        return data.label.indexOf(value) !== -1;
      },
      getMenuTree(){ 
         let  that=this;
          getRequest('menu/getMenus').then(res=>{
                  if(res.data.msg=='success'){
                  that.memusData   =res.data.data;
                  that.changeTree();//  数据处理成树 
                  //加载路由
                  }  
                  console.log(that.rootObj)
                  that.treeData.push(that.rootObj)
                  that.loadRouters();
          })
      },
       changeTree(){
            let that=this;
            if(!that.rootObj.hasOwnProperty('parentid')){
                for(let menu of that.memusData){
                    if(menu.parentid=='root'){
                        that.rootObj=menu; 
                        that.memusData.splice(that.memusData.findIndex(item=>item.parentid=='root'),1)
                        this.$set( that.rootObj,'children',[]);
                        that.getChildren(that.rootObj);
                      } 
                    }
                } 
      },
      getChildren(fatherObj){
          let that=this;
          if(fatherObj!=null){
                  for(let menu of  that.memusData){ 
                      if(menu.parentid==fatherObj.name){
                        if(fatherObj.hasOwnProperty('children')){
                          fatherObj.children.push(menu); 
                          let  getfatherObj=menu;
                           this.getChildren(getfatherObj)
                       }else{
                         this.$set( fatherObj,'children',[]);
                        let  getfatherObj=menu;
                         fatherObj.children.push(menu); 
                        this.getChildren(getfatherObj)
                      }
                  }
            }
         console.log(that.rootObj)
      }
    },
   
        //加载路由
        loadRouters(){
          let  that =this;
          const routes=[];
           for(let menu of  that.memusData){ 
             if(menu.path!=null||menu.path!=''){
               let componentName = ()=> import  (menu.componentName );
               let  pagePath=  '@/'+menu.pagePath;
              
               let  router={
                    path:menu.path,
                    component:componentName}
              routes.push(router)
             }
           }
            const  router =new  VueRouter({//第二步创建vueRouter对象
                routes,
                mode:'history'  //默认是hash模式  ，现在改为html5的history模式 没有#
              })

            //前置钩子  首卫导航  路由跳转之前调用
            router.beforeEach((to,from,next)=>{
              //  document.title=to.matched[0].meta.title;
                next();
            });

          //后置钩子   路由跳转之后调用
            router.afterEach((to,from)=>{

            })
           
        }
    
    }
  }
</script>