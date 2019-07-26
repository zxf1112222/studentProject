<template>
	<div>
		<div class="line"></div>
		<el-menu :default-active="activeIndex2" class="el-menu-demo" mode="horizontal" @select="handleSelect" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
			<el-menu-item index="1">首页</el-menu-item>
			<el-submenu index="2">
				<template slot="title">管理员</template>
				<el-menu-item index="2-1" @click="pagetoselectAllStudent()">查询全部学生信息</el-menu-item>
				<el-menu-item index="2-2" @click="pagetoselectAllCourse()">查询全部课程信息</el-menu-item>
			</el-submenu>
		</el-menu>
	</div>

</template>
<script>
	export default {
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
			pagetoselectAllStudent(){
				this.$router.push('pagetoselectAllStudent');
			},
			pagetoselectAllCourse(){
				this.$router.push('pagetoselectAllCourse');
			}
		}
	}
</script>