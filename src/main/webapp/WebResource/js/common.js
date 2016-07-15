/**
 * 显示DOM元素
 * @param dom
 */
function show(dom){
	dom.style.visibility="visible";
}
/**
 * 隐藏DOM元素
 * @param dom
 */
function hide(dom){
	dom.style.visibility="hidden";
}

/**
 * 根据DOMID获取元素
 * @param domId
 */
function GetElement(domId){
	return document.getElementById(domId);
}


/**
 * 二级联动下拉列表
 * @param firstDOM 第一个下拉列表
 * @param secondDOM 第二个下拉列表
 * @param firstURL 获取第一个下拉列表内容的请求URL
 * @param changeURL 改变第一个下拉列表时触发的第二个下拉列表的请求URL
 * @param optionValueField ajax请求到的内容中设置为option value的字段名 如:"city.id"
 * @param optionTextField ajax请求到的内容中设置为option text的字段名 如:"city.name"
 */
var DoubleSelectUtil = function(firstDOM,secondDOM,firstURL,changeURL,optionValueField,optionTextField){
	this.$ajax = new ajaxUtil();
	this.init=function(){
		var $self = this;
		function _$initDOM(dom,url){
			dom.innerHTML="";
			$self.$ajax.settings={
					url:url,
					method:"GET",
					param:null
			};
			$self.$ajax.send(function(xhr){
				var childs = xhr.responseText;
				childs = eval(childs);
				var emptyOption = document.createElement("option");
				emptyOption.appendChild(document.createTextNode(""));
				dom.appendChild(emptyOption);
				for(var i=0;i<childs.length;i++){
					var option = document.createElement("option");
					option.setAttribute("value",eval("childs[i]."+optionValueField));
					option.appendChild(document.createTextNode(eval("childs[i]."+optionTextField)));
					dom.appendChild(option);
				}
			});
		}
		_$initDOM(firstDOM,firstURL());
		//绑定change事件
		firstDOM.addEventListener("change",function(){
			_$initDOM(secondDOM,changeURL());
		});
	};
	return this;
}
