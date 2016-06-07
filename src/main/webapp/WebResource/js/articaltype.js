/**
 * 文章类型编辑工具类
 */
var articalEdit={
		level:1,
		domIDs:{
			typeAppend : "typeAppend",
			saveBtn : "saveBtn",
			addBtn : "addBtn"
		},
		initAdd:function(){
			if(this.level == 2){
				this.domIDs.typeAppend = "typeAppend-second";
				this.domIDs.saveBtn = "saveBtn-second";
				this.domIDs.addBtn = "addBtn-second";
			}else{
				this.domIDs.typeAppend = "typeAppend";
				this.domIDs.saveBtn = "saveBtn";
				this.domIDs.addBtn = "addBtn";
			}
			document.getElementById(this.domIDs.typeAppend).style.display="inline-block";
			document.getElementById(this.domIDs.typeAppend).focus();
			document.getElementById(this.domIDs.saveBtn).style.display="inline-block";
			document.getElementById(this.domIDs.addBtn).style.display="none";
		},
		add:function(){
			if(this.level == 2){
				this.domIDs.typeAppend = "typeAppend-second";
				this.domIDs.saveBtn = "saveBtn-second";
				this.domIDs.addBtn = "addBtn-second";
			}else{
				this.domIDs.typeAppend = "typeAppend";
				this.domIDs.saveBtn = "saveBtn";
				this.domIDs.addBtn = "addBtn";
			}
			document.getElementById(this.domIDs.typeAppend).value="";
			document.getElementById(this.domIDs.typeAppend).style.display="none";
			document.getElementById(this.domIDs.saveBtn).style.display="none";
			document.getElementById(this.domIDs.addBtn).style.display="inline-block";
		}
}
