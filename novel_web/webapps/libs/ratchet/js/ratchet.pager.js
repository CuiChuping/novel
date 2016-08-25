/**
 * author: cuichuping
 */
window.addEventListener("load", function() {
	var viewList = document.querySelectorAll(".table-view-1");
	for(var i = 0; i < viewList.length; i++) {
		var loadBtn = createLoadBtn(viewList[i]);
		viewList[i].appendChild(loadBtn);
		nextPager(loadBtn.options);
	}
	var loadBtnList = document.querySelectorAll(".loading");
	for(var i = 0; i < loadBtnList.length; i++) {
		loadBtnList[i].onclick = function() {
			nextPager(this.parentNode.parentNode.options);
		}
	}
}, false);

function createLoadBtn(tableView) {
	var loadBtn = document.createElement("li");
	loadBtn.className = "table-view-cell";
	loadBtn.innerHTML = "<span><button class=\"btn btn-block btn-sm loading\">点击加载更多</button></span>";
	loadBtn.options = {
			index: 0,
			loadBtn: loadBtn,
			continer: tableView, 
			url: tableView.getAttribute("data-url"), 
			count: parseInt(tableView.getAttribute("data-count"))
	};
	return loadBtn;
}

function nextPager(options) {
	var xhr = new XMLHttpRequest();
    xhr.open('GET', options.url + "?index="+(options.index++)+"&count="+options.count, true);
    xhr.onreadystatechange = function () {
		if (xhr.readyState === 4 && xhr.status === 200) {
			success(options, JSON.parse(xhr.responseText));
		}
    };
    xhr.send(null);
}

function success(options, data) {
	for(var i in data) {
		var newItem = document.createElement("li");
		newItem.className = "table-view-cell";
		newItem.innerHTML = data[i];
		options.continer.insertBefore(newItem, options.loadBtn);
	}
	console.log(data)
}
