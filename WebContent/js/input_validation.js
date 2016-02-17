function makeUserNameMsg(name){
   var len = name.length;
   
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

function showWarningColor(idString, validationMsg){
  
  if(validationMsg !== ""){
    $(idString).css("border", "1px solid #ff0000");
    return;
  }
  $(idString).css("border", "1px solid #000000");
}

$(document).ready(function() {

  $("#name").on("input", function() {
    var username = $(this).val(); 
    var validationMsg = makeUserNameMsg(username);
    $("#name_error").html(validationMsg);
    showWarningColor("#name", validationMsg);
  });

  $("#email").on("input", function() {
    var email = $(this).val();
    var validationMsg = makeEmailValidation(email);
    $("#email_error").html(validationMsg);
    showWarningColor("#email", validationMsg);
  });

  
  $("#recipient_info").submit(function() {
    var name=$("#name").val();
    var email=$("#email").val();
    
    if(makeUserNameMsg(name) !== "" || makeEmailValidation(email) !== ""){
      return false;
    }
    
    var url = "/email/store.do?name=" + name + "&email=" + email;
    $.get(url, function(msg){
      $("#success_msg").html(msg);
    });
    return false;
  });
});
