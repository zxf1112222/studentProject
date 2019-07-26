<template>
	<div id="news">
		<h2>这是个News组件</h2>

		<div style="align-content: center; ">
			<el-table  :data="list" style="width: 550px; margin:auto">
				<el-table-column prop="cid" label="编号" width="180">
				</el-table-column>
				<el-table-column prop="cname" label="课程名" width="180">
				</el-table-column>
				<el-table-column prop="credit" label="学分" width="180">
				</el-table-column>
			</el-table>

		</div>

	</div>
</template>

<script>
	import Axios from 'axios';
	export default {
		name: 'news',
		data() {
			return {
				
				list:[]
			}
		},
		methods: {
			run() {
				alert("我是News组件上的方法")
			},
			getData() {
				var that = this;
				Axios.post("/selectAllCourse").then(function(result) {
					console.log(result);
					console.log(result.data)
					that.list = result.data;
				});
					
			}

		},
		created() {
			this.getData();
		}
	}
</script>

<style scoped>
	h2 {
		color: red;
	}
</style>