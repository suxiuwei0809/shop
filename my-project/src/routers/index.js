import  VueRouter  from  'vue-router'
import  Vue  from  'vue'
 // import  about  from  '../components/About'
// import  home  from  '../components/Home';直接加载的方式
 const about  = ()=>import('../components/About');
 const home  = ()=>import('../components/Home');
 const user  = ()=>import('../components/User');
 const news  = ()=>import('../components/HomeNews');
 const message  = ()=>import('../components/HomeMessage');
 const homes  = ()=>import('../views/menu/Homes');
 const menus  = ()=>import('../views/menu/Menus');
 const menuAdd  = ()=>import('../views/menu/MenuAdd');
Vue.use(VueRouter)  //第一步通过vue.use--意思为VueRouter.install 安装插件vuerouter

//这里一直要用routes  不要用routers  !!!!!!!!  坑
const routes=[
    
 
  
    {
        path:'/menus',
        component:menus

    } ,
    {
        path:'/menuAdd',
        component:menuAdd

    } 
] 

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
export default  router;  // 导出router