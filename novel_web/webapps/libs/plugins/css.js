/**
 * css loader plugin
 * @author Microc
 */
define('css', ['onlyn'], function(onlyn) {
	var css = onlyn.config.map.css || [];
	var _loadCss = function(css) {
		css = onlyn.path(css, '.css');
		var link = document.createElement('link');
		link.rel = 'stylesheet';
		link.type = 'text/css';
		link.href = css;
		document.getElementsByTagName('head')[0].appendChild(link);
	}
	for(var i in css) {
		_loadCss(css[i]);
	}
	return {
		css: _loadCss
	};
});