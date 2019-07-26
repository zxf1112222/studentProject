<template>
	<div>
		<top></top>
		
		<div style="height: 120px;"></div>
		<div style="align-content: center;">
			<div class="grid-content bg-purple" style="width: 400px; margin: auto; ">
			<el-form ref="form" :model="tstudents" label-width="80px">
				<el-form-item label="id" v-if="show">
					<el-input v-model="tstudents.id"></el-input>
				</el-form-item>
				<el-form-item label="学号" v-if="show">
					<el-input v-model="tstudents.snum"></el-input>
				</el-form-item>
				<el-form-item label="姓名">
					<el-input v-model="tstudents.name"></el-input>
				</el-form-item>
				<el-form-item label="性别">
					<el-radio-group v-model="tstudents.sex">
						<el-radio label="男"></el-radio>
						<el-radio label="女"></el-radio>
					</el-radio-group>
				</el-form-item>
				<el-form-item label="年龄">
					<el-input v-model="tstudents.age"></el-input>
				</el-form-item>
				<el-form-item label="联系电话">
					<el-input v-model="tstudents.phone"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="updateStudent()">确认修改</el-button>

				</el-form-item>
			</el-form>
		</div>
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
				show:false,
				tstudents: [],
				
				
			};
		},
		created() {
			this.handleStudent()
			
		},
		components: {
			top
		},
		methods: {
			handleStudent: function() {
				this.tstudents = this.$route.query.student;
				console.log(this.$route.query.student)
			},

			updateStudent: function() {
			    var	that=this;
				axios.post("/updateStudent", qs.stringify(this.tstudents,{
					headers: {
						'content-type': 'application/x-www-form-urlencoded'
					}
				})).then(function(result) {
					alert(result.data)
					console.log(result);
					that.$router.push("pagetoselectAllStudent");
				});

			}
		}

	}
</script>
