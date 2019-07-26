<template>
	<el-row>
		<div style="height: 60px;"></div>
		<div style="align-content: center;">
			<span style="font-family: '华文行楷';">
				<h1>学生信息管理系统</h1>
			</span>
			<hr />
			<div class="grid-content bg-purple" style="width: 300px; margin: auto; ">

				<el-form :label-position="labelPosition" :model="formLabelAlign">
					<el-form-item style="font-family: '华文行楷'; font-size: 20px;" label="学号:">
						<el-input v-model="user.snum"></el-input>
					</el-form-item>
					<el-form-item style="font-family: '华文行楷'; font-size: 20px;" label="密码:">
						<el-input type="password" v-model="user.password"></el-input>
					</el-form-item>
					<el-button type="info" @click="login()" plain><span style="font-family: '华文行楷'; font-size: 18px;">登陆</span></el-button>
					<el-button type="info" @click="pagetoregister()" plain><span style="font-family: '华文行楷'; font-size: 18px;">注册</span></el-button>
				</el-form>
				<span style="font-family: '华文行楷'; font-size: 18px;">{{result}}</span>
				
			</div>
		</div>
	</el-row>
</template>
<script>
	import axios from "axios";
	import qs from 'qs';
	export default {
		data() {
			return {
				labelPosition: 'left',
				user: {
					snum: '',
					password: '',
					
					
				},
				result:''

			};
		},
		methods: {
			login: function() {
				//注释
				var that = this;
				axios.post("/login", qs.stringify(this.user, {
					headers: {
						'content-type': 'application/x-www-form-urlencoded'
					}
				})).then(function(result) {
					that.result = result;
					console.log(result);
					
					if (result.data) {
						that.$router.push('/student')
					} else {
						that.result="用户名或者密码错误！";
						that.$router.push('/pagetologin')
					}

				});
			},

			pagetoregister: function() {
				this.$router.push({
					name: 'pagetoregister'
				})
			}
		},
	}
</script>
