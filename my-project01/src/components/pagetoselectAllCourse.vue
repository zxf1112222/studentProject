<template>
	<div>
		<top></top>
	
		<div style="height: 120px;"></div>
		<div style="align-content: center; ">
			<el-table v-loading="loading" :data="tcourse" style="width: 550px; margin:auto">
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
	import top from "./top.vue";
	import axios from "axios";
	import qs from 'qs';
	export default {
		data() {
			return {
				activeIndex2: '1',
				tcourse: []
			};
		},
		components: {
			top
		},
		created() {
			this.selectAllCourse()
		},
		methods: {
			selectAllCourse: function() {
				var that = this;
				axios.post("/selectAllCourse").then(function(result) {
					that.tcourse = result.data;
				});
			}
		}

	}
</script>
