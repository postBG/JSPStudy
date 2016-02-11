function makeUserNameMsg(username){
   var len = username.length;
   
   if (len == 0) {
     return "이름을 입력해주세요.";
   } 
   if(len < 2){
     return "이름은 2자 이상이어야 합니다.";
   }
   
   return "";
};

function makeEmailValidation(email){
  var reg_email = /^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{0}[-A-Za-z0-9_.]*$/;

  if (email.length == 0) {
    return "이메일을 입력해주세요.";
  } 
  if (email.search(reg_email) == -1) {
    return "이메일 포멧이 올바르지 않습니다.";
  }
  
  return "";
}

$(document).ready(function() {

  $("#username").on("input", function() {
    var username = $(this).val(); 
    var validationMsg = makeUserNameMsg(username);
    $("#username_error").html(validationMsg);
    
    if(validationMsg !== ""){
      $(this).css("border-color", "red");
      return;
    }
    $(this).css("border-color", "");
  });

  $("#email").on("input", function() {
    var email = $(this).val();
    var validationMsg = makeEmailValidation(email);
    $("#password_error").html(validationMsg);
  });

  $("#user_info").submit(function() {
    var username=$("#username").val();
    var email=$("#email").val();
    
    if(makeUserNameMsg(username) !== "" || makeEmailValidation(email) !== ""){
      return false;
    }
    
    var url = "/email/store?username=" + username + "&email=" + email;
    $.get(url, function(userName){
      $("#success_msg").html(userName + "님의 정보를 성공적으로 저장했습니다.");
    });
    return false;
  });
});
