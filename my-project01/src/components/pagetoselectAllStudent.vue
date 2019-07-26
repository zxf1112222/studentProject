<template>

	<div>
		<top></top>
		
		<div style="height: 120px;"></div>
		<div style="align-content: center;">
			<el-table style="width: 100%;"
                    :data="tstudents.slice((currentPage-1)*pagesize,currentPage*pagesize)"  
                    >
				<el-table-column prop="id" label="id" width="180" v-if="show">
				</el-table-column>
				<el-table-column prop="snum" label="学号" width="180">
				</el-table-column>
				<el-table-column prop="name" label="姓名" width="180">
				</el-table-column>
				<el-table-column prop="sex" label="性别" width="180">
				</el-table-column>
				<el-table-column prop="age" label="年龄" width="180">
				</el-table-column>
				<el-table-column prop="phone" label="联系电话" width="180">
				</el-table-column>
				<el-table-column label="操作">
					<template slot-scope="scope">
						<el-button size="mini" @click="pagetohandleStudent(scope.$index, scope.row)">编辑</el-button>
						<el-button size="mini" type="danger" @click="handleDeleteStudent(scope.$index, scope.row)">删除</el-button>
					</template>
				</el-table-column>
			</el-table>
 			<el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currentPage"
                :page-sizes="[1, 5, 10, 20]" 
                :page-size="pagesize"         
                layout="total, sizes, prev, pager, next, jumper"
                :total="tstudents.length">   
            </el-pagination>
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
				currentPage:1,
                pagesize:1
			};
		},
		components: {
			top
		},
		created() {
			this.selectAllStudent()
		},
		methods: {
			selectAllStudent: function() {
				var that = this;
				axios.post("/selectAllStudent").then(function(result) {
					console.log(result);
					that.tstudents = result.data;
				});
			},
			pagetohandleStudent:function(index,row){
				this.$router.push({
					name: 'pagetohandleStudent',
					query:{student:row}
				})
				
			},
			handleDeleteStudent:function(index,row){
				var b=confirm("确认删除吗?");
				if(b){
					var that = this;
					axios.post("/handleDeleteStudent").then(function(result) {
						that.selectAllStudent();
						console.log(result);
					});
				}
			},
			handleSizeChange: function (size) {
                this.pagesize = size;
                console.log(this.pagesize)  //每页下拉显示数据
	        },
	        handleCurrentChange: function(currentPage){
	                this.currentPage = currentPage;
	                console.log(this.currentPage)  //点击第几页
	        }
		}

	}
</script>
