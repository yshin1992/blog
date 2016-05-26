/**
 * 获取XMLHttpRequest对象
 * XMLHttpRequest对象的属性
 * onreadystatechange 当readyState状态改变时的回调函数
 * readyState 返回当前的请求状态 0 1 2 3 4(响应已完成)
 * responseBody 将信息以unsigned byte数组形式返回
 * responseStream 以Ado Stream对象的形式返回响应消息
 * responseText 以普通文本返回的数据
 * responseXML 以XML文档形式回应的数据
 * status 返回当前请求的http状态码
 * statusText 返回当前请求的响应行状态
 * abort() 取消当前所发出的请求
 * getAllResponseHeaders() 取得所有的HTTP头信息
 * getResponseHeader()取得一个指定的HTTP头信息
 * open()
 * send()
 * setRequestHeader() 设置一个指定请求的HTTP头信息
 * @returns
 */
function getXMLHttpRequest()
{
	if(window.XMLHttpRequest){
		return new XMLHttpRequest();
	}else{
		return new ActiveXObject("Microsoft.XMLHTTP");
	}
}