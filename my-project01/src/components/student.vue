<template>
	<div>
		<top></top>

		<div style="align-content: center;margin-top: 300px;">
			<span style="font-family: '华文行楷'; font-size: 25px; margin: auto;">欢迎您来到学生管理系统首页，这里将为您提供最优质的服务！</span>
		</div>
	</div>
</template>

<script>
	import top from "./top.vue";
	import axios from "axios";
	import qs from 'qs';
	export default {
		data() {
			return {
				username: '你好111'
			};
		},
		components: {
			top
		},
		created() {
			this.getUserName()
		},
		methods: {
			getUserName: function() {
				this.username = this.$route.query.username
			},
		},

	}
</script>