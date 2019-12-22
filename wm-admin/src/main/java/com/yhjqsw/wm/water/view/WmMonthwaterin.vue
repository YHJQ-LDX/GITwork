<template>
  <div class="container" style="width:99%;margin-top:-25px;">
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.label" placeholder="名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:wmMonthwaterin:view" type="primary" @click="findPage(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:wmMonthwaterin:add" type="primary" @click="handleAdd" />
			</el-form-item>
		</el-form>
	</div>
	<!--表格内容栏-->
	<kt-table permsEdit="sys:wmMonthwaterin:edit" permsDelete="sys:wmMonthwaterin:delete"
		:data="pageResult" :columns="columns" 
		@findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete">
	</kt-table>
	<!--新增编辑界面-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisible" :close-on-click-modal="false">
		<el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm" :size="size">
			<el-form-item label="" prop="id"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="组织编码" prop="deptno"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.deptno" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="组织名称" prop="deptname"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.deptname" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="水表号" prop="watermno"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.watermno" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="计量年月" prop="metermonth"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.metermonth" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="" prop="waterin"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.waterin" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人编码" prop="createby"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.createby" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createtime"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.createtime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人编码" prop="lastupdateby"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.lastupdateby" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastupdatetime"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.lastupdatetime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="备注" prop="remark"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.remark" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisible = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitForm" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>
  </div>
</template>

<script>
import KtTable from "@/views/Core/KtTable"
import KtButton from "@/views/Core/KtButton"
import { format } from "@/utils/datetime"
export default {
	components:{
			KtTable,
			KtButton
	},
	data() {
		return {
			size: 'small',
			filters: {
				label: ''
			},
			columns: [
				{prop:"id", label:"", minWidth:100},
				{prop:"deptno", label:"组织编码", minWidth:100},
				{prop:"deptname", label:"组织名称", minWidth:100},
				{prop:"watermno", label:"水表号", minWidth:100},
				{prop:"metermonth", label:"计量年月", minWidth:100},
				{prop:"waterin", label:"", minWidth:100},
				{prop:"createby", label:"创建人编码", minWidth:100},
				{prop:"createtime", label:"创建时间", minWidth:100},
				{prop:"lastupdateby", label:"更新人编码", minWidth:100},
				{prop:"lastupdatetime", label:"更新时间", minWidth:100},
				{prop:"remark", label:"备注", minWidth:100},
			],
			pageRequest: { pageNum: 1, pageSize: 8 },
			pageResult: {},

			operation: false, // true:新增, false:编辑
			editDialogVisible: false, // 新增编辑界面是否显示
			editLoading: false,
			dataFormRules: {
				label: [
					{ required: true, message: '请输入名称', trigger: 'blur' }
				]
			},
			// 新增编辑界面数据
			dataForm: {
				id: null,
				deptno: null,
				deptname: null,
				watermno: null,
				metermonth: null,
				waterin: null,
				createby: null,
				createtime: null,
				lastupdateby: null,
				lastupdatetime: null,
				remark: null,
			}
		}
	},
	methods: {
		// 获取分页数据
		findPage: function (data) {
			if(data !== null) {
				this.pageRequest = data.pageRequest
			}
			this.pageRequest.columnFilters = {label: {name:'label', value:this.filters.label}}
			this.$api.wmMonthwaterin.findPage(this.pageRequest).then((res) => {
				this.pageResult = res.data
			}).then(data!=null?data.callback:'')
		},
		// 批量删除
		handleDelete: function (data) {
			this.$api.wmMonthwaterin.batchDelete(data.params).then(data!=null?data.callback:'')
		},
		// 显示新增界面
		handleAdd: function () {
			this.editDialogVisible = true
			this.operation = true
			this.dataForm = {
				id: null,
				deptno: null,
				deptname: null,
				watermno: null,
				metermonth: null,
				waterin: null,
				createby: null,
				createtime: null,
				lastupdateby: null,
				lastupdatetime: null,
				remark: null,
			}
		},
		// 显示编辑界面
		handleEdit: function (params) {
			this.editDialogVisible = true
			this.operation = false
			this.dataForm = Object.assign({}, params.row)
		},
		// 编辑
		submitForm: function () {
			this.$refs.dataForm.validate((valid) => {
				if (valid) {
					this.$confirm('确认提交吗？', '提示', {}).then(() => {
						this.editLoading = true
						let params = Object.assign({}, this.dataForm)
						this.$api.wmMonthwaterin.save(params).then((res) => {
							if(res.code == 200) {
								this.$message({ message: '操作成功', type: 'success' })
							} else {
								this.$message({message: '操作失败, ' + res.msg, type: 'error'})
							}
							this.editLoading = false
							this.$refs['dataForm'].resetFields()
							this.editDialogVisible = false
							this.findPage(null)
						})
					})
				}
			})
		},
		// 时间格式化
      	dateFormat: function (row, column, cellValue, index){
          	return format(row[column.property])
      	}
	},
	mounted() {
	}
}
</script>

<style scoped>

</style>