/**
 * 아이디, 별명, 휴대폰, 이메일 중복체크 
 */
$(function(){
	// 아이디 중복체크
	var inputUid = $('input[name=uid]');
	
	inputUid.focusout(function(){
		var uid = $(this).val();
		var jsonData = {'uid': uid};
		
		$.ajax({
			url: '/Jboard1/user/proc/checkUid.jsp',
			type: 'get',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				
				if(data.result == 0){
					$('.resultId').css('color', 'green').text('사용 가능한 아이디 입니다.');
				}else{
					$('.resultId').css('color', 'red').text('이미 사용중인 아이디 입니다.');
				}
			}
		});
		
	});
	
	// 별명 중복체크
	
	// 이메일 중복체크
	
	// 휴대폰 중복체크
	
	
});  