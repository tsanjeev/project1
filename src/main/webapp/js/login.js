$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
        $('#register-form-link').removeClass('btn-primary active');
        $('#register-form-link').addClass('btn-outline-primary');
        $(this).addClass('btn btn-primary active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
 		
        $('#login-form-link').removeClass('btn-primary active');
        $('#login-form-link').addClass('btn btn-outline-primary');
        $(this).addClass('btn btn-primary active');
		e.preventDefault();
	});

});