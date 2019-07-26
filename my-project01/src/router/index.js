import Vue from 'vue'
import Router from 'vue-router'
import News from '@/components/News.vue';
import pageToLogin from '@/components/pagetologin.vue';
import student from '@/components/student.vue';
import top from '@/components/top.vue';
import pagetohandleStudent from '@/components/pagetohandleStudent.vue';
import pagetoselectAllStudent from '@/components/pagetoselectAllStudent.vue';
import pagetoselectAllCourse from '@/components/pagetoselectAllCourse.vue';

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: student
    },
    { path: '/news', component: News },
    { path: '/pagetologin', component: pageToLogin },
    { path: '/student', component: student},
    { path: '/top', component: top},
    { path: '/pagetoselectAllStudent', component: pagetoselectAllStudent},
    { path: '/pagetoselectAllCourse', component: pagetoselectAllCourse},
    {
      path: '/pagetohandleStudent',
      name: 'pagetohandleStudent',
      component: pagetohandleStudent
    },
    
  ]
})
