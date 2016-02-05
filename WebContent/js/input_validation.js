$(document).ready(function(){
  
  $("#username").on("input", function(){
    var len = $(this).val().length;
    
    if(len == 0){
      $("#username_error").html("이름을 입력해주세요.");
    }
    else if(len < 2){
      $("#username_error").html("이름은 2자 이상이어야 합니다.");
    }
    else{
      $("#username_error").html("");
    }
  });
  
  $("#email").on("input", function(){
    var reg_email=/^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{0}[-A-Za-z0-9_.]*$/;
    if($(this).val().search(reg_email) == -1){
      $("#password_error").html("이메일 포멧이 올바르지 않습니다.");
    }
    else{
      $("#password_error").html("");
    }
  });
});