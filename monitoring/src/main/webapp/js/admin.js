/*show hide*/
function showLayer(tgtEl) {
document.getElementById(tgtEl).style.display = "block";
}
function hideLayer(tgtEl) {
document.getElementById(tgtEl).style.display = "none";
} 

$(function() {
	/* LNB 네비게이션 설정 */
	$('.lnb > li.on').addClass('current-menu');//현재 페이지 고정하기 위한 가상 클래스 적용
	$('#lnb-group').mouseleave(function() {
		$(this).data('timer', setTimeout(function(){
			$('.lnb > li.current-menu .lnb-sub').slideDown(function() {
				$(this.parentNode).addClass('on');
			});
			$('.lnb > li:not(.current-menu) .lnb-sub').slideUp(function() {
				$(this.parentNode).removeClass('on');
			});
		}, 2000));
	}).mouseenter(function() {
		if($(this).data('timer')){
			clearTimeout($(this).data('timer'));
			$(this).data('timer', false);
		}
	});
	$('.lnb > li > a').click(function() {
		var sub = $('.lnb-sub', this.parentNode);
		if(sub.length > 0){
			if(sub.is(':visible')){
				return false;
			}

			$('.lnb > li .lnb-sub').slideUp(function() {
				$(this.parentNode).removeClass('on');
			});
			$('.lnb-sub', this.parentNode).slideDown(function() {
					$(this.parentNode).addClass('on');
			});
			return false;
		}
	});

	if($('#wrap').length > 0) {
		$(window).resize(function() {
			if($('#wrap').height() < $(window).height() - 72) {
				$('#footer-wrap').css({
					'position': 'fixed',
					'bottom': '0px'
				});
			} else {
				$('#footer-wrap').css({
					'position': '',
					'bottom': ''
				});
			}
		}).trigger('resize');
	}
});;